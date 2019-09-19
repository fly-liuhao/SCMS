var $;
layui.use(['form', 'layedit', 'laydate'], function() {
	$ = layui.jquery;
	var form = layui.form,
		layer = layui.layer,
		layedit = layui.layedit,
		laydate = layui.laydate;
	//日期
	laydate.render({
		elem: '#grade',
		type: 'year'
	});
	//创建一个编辑器(消除浏览器加载次序影响)
	var editIndex;
	setTimeout(function() {
		editIndex = layedit.build('remark', {
			tool: ['left', 'center', 'right', '|', 'link', 'face', 'image'],
			height: 100 //设置编辑器高度
		});
	},100);
	//自定义验证规则
	form.verify({
		dept_select: function(value) {
			if (value == '') {
				time: 5000;
				return '请选择院系';
			}
		},
		major_select: function(value) {
			if (value == '') {
				return '请选择专业';
			}
		},
		grade_select: function(value) {
			if (value == '') {
				return '请选择年级';
			}
		},
		classid: [
			/^[0-9]{7,10}$/, '班级编号必须7到9位数字，且不能出现空格'
		],
		content: function(value) {
			layedit.sync(editIndex);
		}
	});
	// 监听院系下拉列表
    form.on("select(department)", function(data){
		 getMajors(data.value);
    });
	// 监听提交
	form.on('submit(form)', function(data) {
		console.log(data);
		var param = JSON.stringify(data.field);// 将对象直接转化为JSON字符串
		param = JSON.parse(param);// 将JSON字符串转化为JSON对象
		submitform(param);  
		return false;
	});
});

/* 通过Servlet获得专业下拉列表 */
function getMajors(deptid){
	clearMajorHtml();
    var param = {
    	'deptid':deptid,
        'ram' : Math.random()
    };
	$.getJSON("FindMajorServlet",param,function(data){
		$.each(data, function(index, item) {
			if(item.majorname == 'xxx'){
				var op = $("<option>").val(item.majorid).text(item.majorname).prop('selected',true);
			} else {
				var op = $("<option>").val(item.majorid).text(item.majorname);
			}
			$("#major").append(op);
		});
		// 渲染页面表单，否则不显示数据
		layui.form.render('select');
	});
}
/* 清除专业下拉列表 */
function clearMajorHtml() {
	$("#major").html("");//empty()
    var pleaseOption = $("<option>").val("").text("请选择").prop('selected',true);
    $("#major").append(pleaseOption);
}

/* 提交form表单班级信息 */
function submitform(param){	
	//使用post方式提交(服务器错误是会有提示)
	$.ajax({
		type : "get",
		url : "ModifyClassServlet",
		data : param,
		dataType : "json",//预期服务器返回的数据类型
		success : function(data){	
			if(data == true){
				layer.msg('修改成功！', {anim: 3, icon: 6, time: 2000, shade: 0.1});
				setTimeout(function() {
					// 关闭自身窗口
					var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
					parent.layer.close(index); //再执行关闭
					// 刷新父窗口
					parent.layui.table.reload('classTable');//重新加载父页面
				}, 1000);
			} else {
				layer.msg('修改失败，该班级不存在！', {anim: 6, icon: 5, time: 1500, shade: 0.1});
			}
		},
		error:function(xhr){
//			alert("错误提示： " + xhr.status + " " + xhr.statusText);
			window.location = 'views/error/500.html';
		}
		
	});
}