var $;
layui.use(['form', 'layedit', 'laydate'], function() {
	$ = layui.$;
	var	form = layui.form,
		layer = layui.layer,
		layedit = layui.layedit,
		laydate = layui.laydate;
	//日期
	laydate.render({
		elem: '#grade',
		type: 'year',
		done: function(value, date){
		    //console.log(value); //得到日期生成的值，如：2017-08-18
		    //console.log(date); //得到日期时间对象：{year: 2017, month: 8, date: 18, hours: 0, minutes: 0, seconds: 0}
			// 获取班级下拉列表
			getClasses(value);
		}
	});
	// 表示文档结构已经加载完成后触发的事件（用于动态数据的准备）
	$(document).ready(function() {   
		// console.log("在这里准备数据");
		// 获取院系下拉列表
		getDepartments();
    });
	// 监听院系下拉列表
	form.on("select(department)", function(data){
		// 获取专业下拉列表
        getMajors(data.value);
		// 获取班级下拉列表
		getClasses($('#grade').val());
    });
	// 监听专业下拉列表
	form.on("select(major)", function(data){
		// 获取班级下拉列表
		getClasses($('#grade').val());
    });
	//自定义验证规则
	form.verify({
		stuid: function(value) {
			if (value == '') {
				return '请填写学号';
			}
		},
		stuname: function(value) {
			if (value == '') {
				return '请填写姓名';
			}
		},
		mobile: function(value) {
			if (value == '') {
				return '请填写联系方式';
			}
		},
		department: function(value) {
			if (value == '') {
				return '请选择系部';
			}
		},
		major: function(value) {
			if (value == '') {
				return '请选择专业';
			}
		},
		grade: function(value) {
			if (value == '') {
				return '请选择年级';
			}
		},
		clase: function(value) {
			if (value == '') {
				return '请选择班级';
			}
		}
	});
	//监听提交
	form.on('submit(form)', function(data) {
		// console.log(data);
		var param = data.field;
		addTeamMember(param);// 添加团队成员
		return false;
	});
});

/* 通过Servlet获得院系下拉列表 */
function getDepartments(){
	clearDeptHtml();
    var param = {
        'ram' : Math.random()
    };
	$.getJSON("FindDepartmentServlet",param,function(data){
		//console.log(data);
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
/* 查找班级 */
function getClasses(gradedate){
	clearclassHtml();
	var param = {
		majorid:$('#major').val(),
		grade:gradedate
	}
	// console.log(param);
	$.getJSON("FindClassByMajorServlet",param,function(data){
		//console.log(data);
		$.each(data, function(index, item) {
			if(item.majorname == 'xxx'){
				var op = $("<option>").val(item.classid).text(item.classname).prop('selected',true);
			} else {
				var op = $("<option>").val(item.classid).text(item.classname);
			}
			$("#clase").append(op);
		});
		// 渲染页面表单，否则不显示数据
		layui.form.render('select');
	});
}
/* 清除班级下拉列表 */
function clearclassHtml() {
	$("#clase").html("");//empty()
    var pleaseOption = $("<option>").val("").text("请选择").prop('selected',true);
    $("#clase").append(pleaseOption);
}

/* 添加团队成员 */
function addTeamMember(param){
	$.getJSON('AddStudentServlet?status=add', param, function(data){
		if(data == true){
			// 添加成员团队关系
			addStuTeamRelation(param);
			// 弹出提示
			layer.msg('添加成功！', {anim: 3, icon: 6, time: 2000, shade: 0.1});
			setTimeout(function() {
				// 关闭自身窗口
				var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
				parent.layer.close(index); //再执行关闭
				// 刷新父窗口
				parent.layui.table.reload('teamMemberTable');//重新加载父页面中的数据表格
			}, 1000);
		} else {
			layer.msg('添加失败，该同学已存在！', {anim: 6, icon: 5, time: 1500, shade: 0.1});
		}
	})
}
/* 添加对应关系表 */
function addStuTeamRelation(param){
	$.getJSON('AddStuTeamRelationServlet?status=add', param, function(data){
		// console.log("添加对应关系表结果："+data);
	})	
}

/* 判断改成学生是否已经在团队 */
function check_StuInTeam(param){
	var result;
	$.ajax({
		type : "get",
		url : "AddStuTeamRelationServlet?status=check",
		data : param,
		dataType : "json",//预期服务器返回的数据类型
		async:false,
		success : function(data){	
			result = data;
		}
	});
	//console.log("结果"+result);
	return result;
}

/* 监测学号输入框，判断该是否已经录入 */
function checkStuid(){
	var param = {
		stuid : $('#stuid').val(),	
		teamid : $('#teamid').val()	
	};
	//console.log(param);
	$.getJSON('AddStudentServlet?status=check', param, function(data){
		// 该学生已录入
		if(data == true){
			//console.log("该学生已录入");
			
			// 该学生为加入到该团队
			if(check_StuInTeam(param)){
				layer.msg('该同学已存在团队中！', {anim: 6, icon: 5, time: 1500, shade: 0.1});
				$('#stuid').val('');
			} else {
				layer.confirm('该学生已经存在，是否加入团队?', {icon: 3, title:'提示'}, function(index){
					// 关闭弹窗
					layer.close(index);
					// 添加成员团队关系
					addStuTeamRelation(param);
					// 提示信息
					layer.msg('添加成功！', {anim: 3, icon: 6, time: 2000, shade: 0.1});
					// 关闭自身窗口，刷新父窗口
					setTimeout(function() {
						var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
						parent.layer.close(index); //再执行关闭
						parent.layui.table.reload('teamMemberTable');//重新加载父页面中的数据表格
					}, 1000);
				});
				// 清空输入框
				$('#stuid').val('');
			}
		} 
	});
}