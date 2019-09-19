layui.use(['form', 'layer', 'layedit', 'laydate'], function() {
	var $ = layui.$,
		form = layui.form,
		layer = layui.layer,
		layedit = layui.layedit,
		laydate = layui.laydate;
	//创建一个编辑器
	var editIndex = layedit.build('userremark', {
		tool: ['left', 'center', 'right', '|', 'link', 'face', 'image'],
		height: 180 //设置编辑器高度
	});
	// 表示文档结构已经加载完成后触发的事件（用于动态数据的准备）
	$(document).ready(function() {   
		console.log("在这里准备数据");
		// 从Session中获得userid
		getSussionInfo();
    });
	//自定义验证规则
	form.verify({
		olduserpwd: function(value) {
			if (value == '') {
				return '请填写用户原密码';
			}
		},
		userpwd: function(value) {
			if (value == '') {
				return '请填写用户新密码';
			} else if(value == $('#olduserpwd').val()){
				$('#userpwd').val("");
				$('#userpwd2').val("");
				return '新密码不能与旧密码相同！';
			}
		},
		userpwd2: function(value) {
			if (value == '') {
				return '请再次填写用户新密码';
			} else if(value != $('#userpwd').val()) {
				return '两次填写密码不相同';
			}
		}
	});
	//监听提交
	form.on('submit(form)', function(data) {
		var param = data.field;
		console.log(param);
		$.ajax({
			type : "post",
			url : "ModifyUserServlet?status=modifyuserpwd",
			data : param,
			dataType : "json",//预期服务器返回的数据类型
			success : function(data){	
				if(data == true){
					layer.msg('修改成功！', {anim: 3, icon: 6, time: 2000, shade: 0.1});
					setTimeout(function() {
						$('#olduserpwd').val("");
						$('#userpwd').val("");
						$('#userpwd2').val("");
						window.location = 'views/user/modifyuserpwd.html';   
					}, 1000);
				} else {
					layer.msg('原密码输入错误！', {anim: 6, icon: 5, time: 1500, shade: 0.1});
					$('#olduserpwd').val("");
					$('#userpwd').val("");
					$('#userpwd2').val("");
				}
			}
		});
		return false;
	});
	
	// 从Session中获得用户信息
	function getSussionInfo(){
		var param = {'ram' : Math.random()};
		$.getJSON('FindSessionInfoServlet',param,function(data){
//			console.log(data);
			if(data != null){
				$('#userid').val(data.userid);
			} else {
				layer.msg('用户未登录！', {anim: 6, icon: 5, time: 1500, shade: 0.1});
			}
		});
	}
});