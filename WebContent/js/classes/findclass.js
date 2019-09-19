// 定义全局变量
var $, form, table,layer,laydate;
//layui.config({
////	dir: 'lib/layui-v2.5.4/layui.js',//所在路径（注意，如果是script单独引入layui.js，无需设定该参数。），一般情况下可以无视
////	base: '../../'
//}).extend({
////	layuimini: 'js/layuimini',//指定js的别名
////	layui: 'lib/layui-v2.5.4/layui'//指定js的别名
//})
layui.use(['form', 'table', 'layer', 'laydate'], function() {
	$ = layui.jquery;
	form = layui.form;
	table = layui.table,
	layer = layui.layer,
	laydate = layui.laydate;
	// 日期
	laydate.render({
		elem: '#grade',
		type: 'year'
	});
	// 初始化表格 
	table.render({
		id: 'classTable',
		// 指定原始 table 容器
		elem: '#currentTableId',
		// 异步数据接口
		url: 'FindClassesServlet',
		where: {grade:'', majorid:'', classid:''},
		// 设置导出按钮
		toolbar: '#tablebar',
		//设置表头。值是一个二维数组
		cols: [
			[ {
				type:'numbers',
				width: 50,
				title: '序号',
				fixed: "left"
			}, {
				type: "checkbox",
				width: 50,
			}, {
				field: 'grade',
				width: 100,
				title: '年级',
				sort: true
			}, {
				field: 'deptname',
				width: 150,
				title: '院系'
			}, {
				field: 'majorname',
				width: 150,
				title: '专业'
			}, {
				field: 'classid',
				width: 150,
				title: '班级编号',
				sort: true
			}, {
				field: 'classname',
				width: 150,
				title: '班级名称'
			}, {
				field: 'classremark',
				title: '备注',
				minWidth: 300
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
	//自定义验证规则
	form.verify({
		classid: function(value) {
			if (value.length > 9) {
				return '班级编号必须7到9位数字';
			}
		}
	});
	// 监听搜索操作
	form.on('submit(data-search-btn)', function(data) {
		var result = JSON.stringify(data.field);// 将对象直接转化为JSON字符串
		result = JSON.parse(result);// 将JSON字符串转化为JSON对象
		//执行搜索重载
		table.reload('classTable', {
			method : 'post',
			page: {
				curr: 1
			},
			where: {
				grade:result.grade,
				majorid:result.major,
				classid:result.classid
			}
		}, 'data');
		return false;
	});
	// 监听批量删除操作(使用事件委托)
	$('body').on('click', '#batchremove', function() {
		var checkStatus = table.checkStatus('classTable');
		var	data = checkStatus.data;
		var param = {
			classlist:JSON.stringify(data)
		}
		//console.log(param);
		layer.confirm('真的删除?', function(index) {
			$.getJSON("user/RemoveClassSevlet?status=multiple", param, function(data){
				if(data == true){
					layer.msg('删除成功！', {anim: 3, icon: 6, time: 1500, shade: 0.1});						
					// 确定当前页码,重新加载数据表格
					var currpage = $(".layui-laypage-em").next().html();// 获取当前的页码	
					table.reload('classTable', {
						method : 'post',
						page: {curr: currpage},
						where: {
							grade:$('#grade').val(),
							majorid:$('#major').val(),
							classid:$('#classid').val()
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
	table.on('checkbox(currentTableFilter)', function(obj) {
		console.log(obj)
	});
	// 监听表格编辑、删除按钮
	table.on('tool(currentTableFilter)', function(obj) {
		var data = obj.data;
		var param = JSON.stringify(data);// 将对象直接转化为JSON字符串
		param = JSON.parse(param);// 将JSON字符串转化为JSON对象
		
		if (obj.event === 'edit') {			
			// 打开修改班级的页面
			layer.open({
				id: 'modifyclass_iframe', // 防止重复弹出
				title: '修改班级',
				type: 2,
				//offset: ['20px', '25%'],
				//area: ['500px', '600px'],
				offset: ['2%', '25%'],
				area: ['37%', '96%'],
				content: ['views/classes/modifyclass.html'], // no：弹窗不要滑动条
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
	    			body.find('#grade').val(param.grade);
	    			body.find('#classid').val(param.classid);
	    			body.find('#oldclassid').val(param.classid);
	    			body.find('#classname').val(param.classname);
	    		    body.find('#remark').val(param.classremark);

    		    	$.getJSON("FindDepartmentServlet",{'ram':Math.random()},function(data){
    		    		body.find("#department").html("");
    		    		$.each(data, function(index, item) {
    		    			if(item.deptid == param.deptid){
    		    				var op = $("<option>").val(item.deptid).text(item.deptname).prop('selected',true);
    		    			} else {
    		    				var op = $("<option>").val(item.deptid).text(item.deptname);
    		    			}
    		    			body.find("#department").append(op);
    		    		});
    		    		// 渲染页面表单，否则不显示数据
    		    		iframeWin.layui.form.render('select');
    		    	});
    		    	
    		    	$.getJSON("FindMajorServlet",{'deptid':param.deptid, 'ram':Math.random()},function(data){
    		    		body.find("#major").html("");
    		    		$.each(data, function(index, item) {
    		    			if(item.majorid == param.majorid){
    		    				var op = $("<option>").val(item.majorid).text(item.majorname).prop('selected',true);
    		    			} else {
    		    				var op = $("<option>").val(item.majorid).text(item.majorname);
    		    			}
    		    			body.find("#major").append(op);
    		    		});
    		    		// 渲染页面表单，否则不显示数据
    		    		iframeWin.layui.form.render('select');
    		    	});
				}
			});					
		} else if (obj.event === 'delete') {
			layer.confirm('确定删除该班级吗?', function(index) {
				$.getJSON("user/RemoveClassSevlet?status=single", param, function(data){
					if(data == true){
						layer.msg('删除成功！', {anim: 3, icon: 6, time: 1500, shade: 0.1});						
						// 确定当前页码,重新加载数据表格
						var currpage = $(".layui-laypage-em").next().html();// 获取当前的页码							
						table.reload('classTable', {
							method : 'post',
							page: {curr: currpage},
							where: {
								grade:$('#grade').val(),
								majorid:$('#major').val(),
								classid:$('#classid').val()
							}
						}, 'data');
					} else {
						layer.msg('删除失败，请查看该班级是否存在！', {anim: 6, icon: 5, time: 1500, shade: 0.1});
					}
				});
				layer.close(index);
			});
		}
	});
	/*****************************使用自定义含函数***********************************/
	// 获得院系，填充到下拉列表中
	$(document).ready(function() { 
		getMajors(5);// 固定死，之查看本系学生
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