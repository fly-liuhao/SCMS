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
		id : 'studentTable',
		// 指定原始 table 容器
		elem: '#studentTableId',
		// 异步数据接口
		url: 'FindStudentInfoServlet?status=findstudent',
		where: {stuid:'',stuname:''},
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
				field: 'stuid',
				width: 120,
				title: '学号',
				align: "center"
			}, {
				field: 'stuname',
				width: 120,
				title: '姓名',
				align: "center"
			}, {
				field: 'sex',
				width: 100,
				title: '性别',
				align: "center"
			}, {
				field: 'mobile',
				width: 130,
				title: '联系方式',
				align: "center"
			}, {
				field: 'classname',
				width: 130,
				title: '班级',
				align: "center"
			}, {
				field: 'majorname',
				width: 190,
				title: '专业',
				align: "center"
			}, {
				field: 'deptname',
				width: 130,
				title: '院系',
				align: "center"
			}, {
				field: 'grade',
				width: 100,
				title: '年级',
				align: "center"
			}, {
				title: '操作',
				minWidth: 100,
				templet: '#currentTableBar',
				fixed: "right",
				align: "center"
			}]
		],
		// 每页条数的选择项
		limits: [5, 10, 15, 20, 25, 50, 100],
		// 每页显示的条数
		limit: 15,
		// 是否开启分页
		page: true
	});
	// 监听搜索操作
	form.on('submit(data-search-btn)', function(data) {
		var param = data.field;
		//执行搜索重载
		table.reload('studentTable', {
			page: {
				curr: 1
			},
			where: {
				stuid:param.stuid,
				stuname:param.stuname
			}
		}, 'data');
		return false;
	});
	// 监听表格编辑、删除按钮
	table.on('tool(studentTableFilter)', function(obj) {
		var param = obj.data;
		if (obj.event === 'findcompet') {
			// 修改班级弹出框
			var othis = $(this),
				method = othis.data('method');
			active[method] ? active[method].call(this, othis, param) : '';
		}
	});
	// 定义触发事件弹出厨框
	var active = {
		findcompet: function(othis, param) {
			layer.open({
				id: 'modifycompetition_iframe', // 防止重复弹出
				title: '参与赛事查询',
				type: 2,
				offset: ['5%', '15%'],
				area: ['63%', '80%'],
				content: ['views/team/stu_compet.html', 'no'], // no：弹窗不要滑动条
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
					console.log(layero, index);
					var body = layer.getChildFrame('body', index);
				    var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
				    //console.log(body.html()) //得到iframe页的body内容
				    body.find('#stuid').val(param.stuid);
	    		    // 渲染页面表单，否则不显示数据
	    		    iframeWin.layui.form.render();
				}
			});
		}
	};
});