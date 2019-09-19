var $;
layui.use(['form', 'layedit', 'laydate'], function() {
	$ = layui.jquery;
	var form = layui.form,
		layer = layui.layer,
		layedit = layui.layedit,
		laydate = layui.laydate;
	// 日期
	laydate.render({
		elem: '#grade',
		type: 'year'
	});
	// 创建一个编辑器
	var editIndex = layedit.build('remark', {
		height: 150 //设置编辑器高度
	});
	// 自定义验证规则
	form.verify({
		dept_select: function(value) {
			if (value == '') {
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
		classname: function(value) {
			if (value == '') {
				return '班级名称不能为空';
			}
			if (value.length > 10){
				return '班级名称过长';
			}
		},
		classid: [
			/^[0-9]{7,10}$/, '班级编号必须7到9位数字，且不能出现空格'
		],
		content: function(value) {
			layedit.sync(editIndex);
		}
	});
	$(document).ready(function() {       
	    // select下拉框选中触发事件
	    form.on("select(department)", function(data){
	    	//var message=$("select[name=department").val();
            getMajors(data.value);
	    });
	    // 重置按钮除触发事件(用于清除layui富文本)
	    $("#reset").on("click", function() {
	    	layedit.setContent(editIndex, null);// 富文本中内容置空
	    	layedit.sync(editIndex);// 同步到文本
	    });
	 
	});
	// 监听提交
	form.on('submit(form)', function(data) {
		console.log(JSON.stringify(data));// 将数据块转化为JSON串
		var param = $(data.form).serialize();// 将数据块装转化为字符串
		submitform(param);// 提交班级信息
		return false;
	});
	/*****************************使用自定义含函数***********************************/
	// 获得院系，填充到下拉列表中
	$(document).ready(function() {       
		getDepartments();
	});
});

/* 通过Servlet获得院系下拉列表 */
function getDepartments(){
	clearDeptHtml();
    var param = {
        'ram' : Math.random()
    };
	$.getJSON("FindDepartmentServlet",param,function(data){
//		console.log(data);
		$.each(data, function(index, item) {
			if(item.deptname == 'xxx'){
				var op = $("<option>").val(item.deptid).text(item.deptname).prop('selected',true);
			} else {
				var op = $("<option>").val(item.deptid).text(item.deptname);
			}
			$("#department").append(op);
		});
		// 渲染页面表单，否则不显示数据
		layui.form.render('select');
	});
}
/* 清除院系下拉列表 */
function clearDeptHtml() {
	$("#department").html("");//empty()
    var pleaseOption = $("<option>").val("").text("请选择").prop('selected',true);
    $("#department").append(pleaseOption);
}

/* 通过Servlet获得专业下拉列表 */
function getMajors(deptid){
	clearMajorHtml();
    var param = {
    	'deptid':deptid,
        'ram' : Math.random()
    };
	$.getJSON("FindMajorServlet",param,function(data){
		//console.log(data);
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
//	layer.msg(param);
	// 使用get方式提交
//	$.getJSON("AddClassServlet",param,function(data){
//		if(data == true){
//			layer.msg('提交成功！', {
//				anim: 3,
//				icon: 6,
//				time: 2000,
//				shade: 0.1
//			});
//			window.location = 'views/classes/addclass.html';
//		} else {
//			layer.msg('提交失败，班级已存在！', {
//				anim: 6,
//				icon: 5,
//				time: 1500,
//				shade: 0.1
//			})
//		}
//	});
	
	//使用post方式提交(服务器错误是会有提示)
	$.ajax({
		type : "post",
		url : "AddClassServlet",
		data : param,
		dataType : "json",//预期服务器返回的数据类型
		success : function(data){	
			if(data == true){
				layer.msg('提交成功！', {anim: 3, icon: 6, time: 2000, shade: 0.1});
				setTimeout(function() {
					window.location = 'views/classes/addclass.html';
				}, 1000);
			} else {
				layer.msg('提交失败，班级已存在！', {anim: 6, icon: 5, time: 1500, shade: 0.1});
			}
		},
		error:function(xhr){
			//alert("错误提示： " + xhr.status + " " + xhr.statusText);
			window.location = 'views/error/500.html';
		}
		
	});
}




