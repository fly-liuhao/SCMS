// 定义全局变量
var $;
layui.use(['form', 'table', 'layer', 'laydate'], function() {
	$ = layui.jquery;
	var form = layui.form,
		table = layui.table,
		layer = layui.layer,
		laydate = layui.laydate;
	// 初始化表格 
	table.render({
		// 设置ID
		id : 'teamTable',
		// 指定原始 table 容器
		elem: '#teamTableId',
		// 异步数据接口
		url: 'FindTeamServlet?status=addteamlater',
		where:{teamname:'', competitionname:'', adviser:''},
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
				field: 'teamgroup',
				width: 130,
				title: '团队组别',
				sort: true
			}, {
				field: 'teamname',
				width: 130,
				title: '团队名称'
			}, {
				field: 'competitionname',
				width: 130,
				title: '赛事名称'
			}, {
				field: 'leader',
				width: 100,
				title: '团队组长'
			}, {
				field: 'adviser',
				width: 140,
				title: '指导老师'
			},{
				field: 'award',
				width: 100,
				title: '获奖情况'
			}, {
				field: 'registusername',
				width: 100,
				title: '录入人'
			}, {
				field: 'registdate',
				width: 160,
				title: '添加时间'
			}, {
				title: '操作',
				minWidth: 220,
				templet: '#currentTableBar',
				fixed: "right",
				align: "center"
			}]
		],
		// 每页条数的选择项
		limits: [10, 15, 20, 25, 50, 100],
		// 每页显示的条数
		limit: 15,
		// 是否开启分页
		page: true
	});
	// 监听搜索操作
	form.on('submit(data-search-btn)', function(data) {
		var param = data.field;
		//执行搜索重载
		table.reload('teamTable', {
			page: {
				curr: 1
			},
			where: {
				teamname:param.teamname,
				competitionname:param.competitionname, 
				adviser:param.adviser
			}
		}, 'data');
		return false;
	});

	// 监听表格编辑、删除按钮
	table.on('tool(teamTableFilter)', function(obj) {
		var param = obj.data;
		console.log(param);
		if (obj.event === 'findmember') {
			// 团队成员弹出框
			var othis = $(this),
				method = othis.data('method');
			active[method] ? active[method].call(this, othis, param) : '';
		} else if (obj.event === 'modifyteam') {
			var othis = $(this),
				method = othis.data('method');
			active[method] ? active[method].call(this, othis, param) : '';
		} else if (obj.event === 'deleteteam') {
			layer.confirm('真的删除该团队吗?', function(index) {
				// 删除该团队
				// 删除该团队的所有成员（如果该学生没有参加其它比赛就连同该学生也删除）
				removeteam(param);
				
				layer.close(index);
			});
		}
	});
	
	// 定义触发事件弹出厨框
	var active = {
		findmember: function(othis, param) {
			layer.open({
				id: 'addstudent_iframe', // 防止重复弹出
				title: '团队成员',
				type: 2,
				offset: ['5%', '15%'],
				area: ['60%', '80%'],
				content: ['views/team/team_member.html'], // no：弹窗不要滑动条
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
				    body.find('#teamid').val(param.teamid);
	    			
	    		    // 渲染页面表单，否则不显示数据
	    		    iframeWin.layui.form.render();
				}
			});
		},
		modifyteam: function(othis, param) {
			layer.open({
				id: 'modifyuser_iframe', // 防止重复弹出
				title: '修改团队',
				type: 2,
				area: ['100%', '100%'],
				content: ['views/team/modifyteam.html', 'no'], // no：弹窗不要滑动条
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
				    body.find('#teamid').val(param.teamid);
				    body.find('#teamgroup').val(param.teamgroup);
				    body.find('#teamname').val(param.teamname);
				    body.find('#adviser').val(param.adviser);
				    body.find('#award').val(param.award);
				    body.find('#oldleader').val(param.leader);
				    
				    findCompetition(body, iframeWin, param);
				    	    			
	    		    // 渲染页面表单，否则不显示数据
	    		    iframeWin.layui.form.render();
				}
			});
		}
	};
});

/* 获得赛事下拉列表 */
function findCompetition(body, iframeWin, srcparam){
	body.find("#competition").html("");//empty()
    var pleaseOption = $("<option>").val("").text("请选择").prop('selected',true);
    body.find("#competition").append(pleaseOption);
    
    var param = {'ram' : Math.random()};
	$.getJSON("FindCompetitionAllServlet",param,function(data){
		console.log(data);
		$.each(data, function(index, item) {
			if(item.competitionname == srcparam.competitionname){
				var op = $("<option>").val(item.competitionid).text(item.competitionname).prop('selected',true);
			} else {
				var op = $("<option>").val(item.competitionid).text(item.competitionname);
			}
			body.find("#competition").append(op);
		});
		// 渲染页面表单，否则不显示数据
		iframeWin.layui.form.render('select');
	});
}

/* 删除团队 */
function removeteam(srcparam){
	var param = {
			teamid:srcparam.teamid,
	        'ram' : Math.random()
	};
	console.log(param);
	$.getJSON("RemoveTeamServlet", param, function(data){
		if(data == true){
			removememberAll(param);
		} else {
			layer.msg('删除失败！[status:1]', {anim: 6, icon: 5, time: 1500, shade: 0.1});
		}
	});
}

/* 删除团队成员 */
function removememberAll(param){
	$.getJSON("RemoveStudentServlet?status=multiple", param, function(data){
		if(data == true){
			// 删除成员团队关系
			removestuteamrelationAll(param);
		} else {
			layer.msg('删除失败！[status:2]', {anim: 6, icon: 5, time: 1500, shade: 0.1});
		}
	});
}
/* 删除该团队所有成员团队关系 */
function removestuteamrelationAll(param){
	console.log(param);
	$.getJSON('RemoveStuTeamRelationServlet?status=multiple', param, function(data){
		console.log("删除对应关系表结果："+data);
		if(data == true){
			// 提示信息
			layer.msg('删除成功！', {anim: 3, icon: 6, time: 1500, shade: 0.1});						
			// 刷新table
			layui.table.reload('teamTable');
		}else {
			layer.msg('删除失败！[status:3]', {anim: 6, icon: 5, time: 1500, shade: 0.1});
		}
	})
}