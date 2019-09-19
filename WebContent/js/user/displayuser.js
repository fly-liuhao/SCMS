layui.use(['form', 'layedit', 'laydate'], function() {
	var $ = layui.$,
		form = layui.form,
		layer = layui.layer,
		layedit = layui.layedit,
		laydate = layui.laydate;
	// 表示文档结构已经加载完成后触发的事件（用于动态数据的准备）
	$(document).ready(function() {   
		console.log("在这里准备数据");
		// 获取session中用户并添加到页面当中
		getSussionInfo();
    });

	function getSussionInfo(){
		var param = {'ram' : Math.random()};
		$.getJSON('FindSessionInfoServlet',param,function(data){
			console.log(data);
			if(data != null){
				$('#username').val(data.username);
				$('#realname').val(data.realname);
				$('input[name=role][value=普通用户]').attr("checked",data.userrole=="普通用户" ? true : false);
				$('input[name=role][value=管理员]').attr("checked",data.userrole=="管理员" ? true : false);
				$('#remark').val(data.userremark);
				layedit.build('remark', {
					tool: ['left', 'center', 'right', '|', 'link', 'face', 'image'],
					height: 180 //设置编辑器高度
				});
				layui.form.render();
			} else {
				layer.msg('用户未登录！', {anim: 6, icon: 5, time: 1500, shade: 0.1});
			}
		});
	}
});