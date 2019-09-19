// 定义全局变量
var $;
layui.use(['form', 'table', 'layer', 'laydate'], function() {
	$ = layui.jquery;
	var form = layui.form,
		table = layui.table,
		layer = layui.layer,
		laydate = layui.laydate;
	//日期
	laydate.render({
		elem: '#daterange',
		type: 'month',
		range: '~'
	});
	// 初始化表格 
	table.render({
		//设置ID
		id : 'competitionTable',
		// 指定原始 table 容器
		elem: '#competitionTableId',
		// 异步数据接口
		url: 'FindCompetitionServlet',
		where: {competitionname:'',daterange:'',competitionlevel:'', competitiontype:''},
		// 设置导出按钮
		toolbar: '#tablebar',
		//设置表头。值是一个二维数组
		cols: [
			[{
				type:'numbers',
				width: 50,
				title: '序号',
				fixed: "left"
			}, {
				type: "checkbox",
				width: 50,
			}, {
				field: 'competitionname',
				width: 180,
				title: '赛事名称',
				sort: true
			}, {
				field: 'competitiondate',
				width: 180,
				title: '举办时间'
			}, {
				field: 'competitionlevel',
				width: 140,
				title: '赛事级别'
			}, {
				field: 'competitiontype',
				width: 140,
				title: '赛事类型'
			}, {
				field: 'competitiondescribe',
				title: '赛事说明',
				minWidth: 320
			}, {
				title: '操作',
				minWidth: 150,
				templet: '#currentTableBar',
				fixed: "right",
				align: "center"
			}]
		],
		// 每页条数的选择项
		limits: [10, 15, 20, 25, 50, 100],
		// 每页显示的条数
		limit: 10,
		// 是否开启分页
		page: true
	});
	// 监听搜索操作
	form.on('submit(data-search-btn)', function(data) {
		var result = data.field;
		//执行搜索重载
		table.reload('competitionTable', {
			page: {
				curr: 1
			},
			where: {
				competitionname:result.competitionname,
				daterange:result.daterange,
				competitionlevel:result.competitionlevel,
				competitiontype:result.competitiontype
			}
		}, 'data');
		return false;
	});
	// 监听删除操作
	$("body").on('click', '.data-delete-btn', function() {
		var checkStatus = table.checkStatus('competitionTable'),
			data = checkStatus.data;
		console.log(data);
		var param = {
				competitionlist:JSON.stringify(data)
			}
		//console.log(param);
		layer.confirm('真的删除?', function(index) {
			$.getJSON("RemoveCompetitionServlet?status=multiple", param, function(data){
				if(data == true){
					layer.msg('删除成功！', {anim: 3, icon: 6, time: 1500, shade: 0.1});						
					// 确定当前页码,重新加载数据表格
					var currpage = $(".layui-laypage-em").next().html();// 获取当前的页码	
					table.reload('competitionTable', {
						method : 'post',
						page: {curr: currpage},
						where: {
							competitionname:$('#competitionname').val(),
							daterange:$('#daterange').val(),
							competitionlevel:$('#competitionlevel').val(),
							competitiontype:$('#competitiontype').val()
						}
					}, 'data');
				} else {
					layer.msg('删除失败，请查该班级是否已经删除！', {anim: 6, icon: 5, time: 1500, shade: 0.1});
				}
			});
			layer.close(index);
		});			
	});
	//监听表格复选框选择
	table.on('checkbox(competitionTableFilter)', function(obj) {
		console.log(obj)
	});
	// 监听表格编辑、删除按钮
	table.on('tool(competitionTableFilter)', function(obj) {
		var param = obj.data;
		// console.log(param);
		if (obj.event === 'edit') {
			var othis = $(this), method = othis.data('method');
			active[method] ? active[method].call(this, othis, param) : '';
		} else if (obj.event === 'delete') {
			layer.confirm('真的删除该赛事吗?', function(index) {
				$.getJSON("RemoveCompetitionServlet?status=single", param, function(data){
					if(data == true){
						layer.msg('删除成功！', {anim: 3, icon: 6, time: 1500, shade: 0.1});						
						// 确定当前页码,重新加载数据表格
						var currpage = $(".layui-laypage-em").next().html();// 获取当前的页码							
						table.reload('competitionTable', {
							method : 'post',
							page: {curr: currpage},
							where: {
								competitionname:$('#competitionname').val(),
								daterange:$('#daterange').val(),
								competitionlevel:$('#competitionlevel').val(),
								competitiontype:$('#competitiontype').val()
							}
						}, 'data');
					} else {
						layer.msg('删除失败，请查看该赛事是否存在！', {anim: 6, icon: 5, time: 1500, shade: 0.1});
					}
				});
				layer.close(index);
			});
		}
	});
	// 定义触发事件弹出厨框
	var active = {
		editcompetition: function(othis, param) {
			console.log(param);
			layer.open({
				id: 'modifycompetition_iframe', // 防止重复弹出
				title: '修改赛事',
				type: 2,
				offset: ['2%', '25%'],
				area: ['37%', '96%'],
				content: ['views/competition/modifycompet.html'], // no：弹窗不要滑动条
				skin: 'layui-layer-molv',
				//							btn: '关闭全部',
				//							btnAlign: 'c' ,//按钮居中
				//							yes: function() {
				//								layer.closeAll();
				//							}
				shade: 0.3, //不显示遮罩
				maxmin: true, //开启最大化按钮
				anim: 3, // 过渡效果（3或者4）
				resize: false, // 禁止窗体拉伸
				//							time : 1000,//定时关闭
				success: function(layero, index) { //弹出层弹出后的回调函数
					var body = layer.getChildFrame('body', index);
				    var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
				    //console.log(body.html()) //得到iframe页的body内容
	    			body.find('#competitionid').val(param.competitionid);
	    			body.find('#competitionname').val(param.competitionname);
	    			body.find('#competitiondate').val(param.competitiondate);
	    			body.find('#competitionlevel').val(param.competitionlevel);
	    			body.find('#competitiontype').val(param.competitiontype);
	    		    body.find('#competitiondescribe').val(param.competitiondescribe);
					
	    		    // 渲染页面表单，否则不显示数据
	    		    iframeWin.layui.form.render("select");
	    		    }
			});
		}
	};
});



















