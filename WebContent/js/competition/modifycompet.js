layui.use(['form', 'layedit', 'laydate'], function() {
	var $ = layui.$,
		form = layui.form,
		layer = layui.layer,
		layedit = layui.layedit,
		laydate = layui.laydate;
	//日期
	laydate.render({
		elem: '#competitiondate',
		type: 'month'
	});
	//创建一个编辑器(消除浏览器加载次序影响)
	var editIndex;
	setTimeout(function() {
		editIndex = layedit.build('competitiondescribe', {
			tool: ['left', 'center', 'right', '|', 'link', 'face', 'image'],
			height: 120 //设置编辑器高度
		});
	}, 100);
	//自定义验证规则
	form.verify({
		competitionname: function(value) {
			if (value == '') {
				return '请填写赛事名称';
			}
		},
		competitiondate: function(value) {
			if (value == '') {
				return '请选择举办时间';
			}
		},
		competitionlevel_select: function(value) {
			if (value == '') {
				return '请选择赛事级别';
			}
		},
		competitiontype_select: function(value) {
			if (value == '') {
				return '请选择赛事类型';
			}
		},
		content: function(value) {
			layedit.sync(editIndex);// 将富文本中内容同步到文本
		}
	});
	//监听提交
	form.on('submit(form)', function(data) {
		var param = data.field;
		console.log(param);
		$.getJSON('ModifyCompetitionServlet', param, function(data){
			if(data == true){
				layer.msg('修改成功！', {anim: 3, icon: 6, time: 2000, shade: 0.1});
				setTimeout(function() {
					// 关闭自身窗口
					var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
					parent.layer.close(index); //再执行关闭
					// 刷新父窗口
					parent.layui.table.reload('competitionTable');
				}, 1000);
			} else {
				layer.msg('修改失败，该赛事不存在！', {anim: 6, icon: 5, time: 1500, shade: 0.1});
			}
			
		})
		return false;
	});
});