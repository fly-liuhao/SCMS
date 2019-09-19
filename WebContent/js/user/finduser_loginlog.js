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
		id : 'userloginlogTable',
		// 指定原始 table 容器
		elem: '#userloginlogTableId',
		// 异步数据接口
		url: 'FindLoginlogServlet?status=search',
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
				field: 'username',
				width: 110,
				title: '用户名',
				align: "center",
				sort: true
			}, {
				field: 'realname',
				width: 110,
				title: '姓名',
				align: "center",
				sort: true
			}, {
				field: 'logintime',
				width: 160,
				title: '登陆时间',
				align: "center",
				sort: true
			}, {
				field: 'loginsite',
				width: 120,
				title: '登陆地点',
				align: "center"
			}, {
				field: 'loginip',
				width: 120,
				title: '登陆IP',
				align: "center"
			}, {
				field: 'loginos',
				width: 120,
				title: '操作系统',
				align: "center"
			}, {
				field: 'loginbrowser',
				width: 120,
				title: '浏览器',
				align: "center"
			}, {
				field: 'loginremark',
				title: '登陆备注',
				minWidth: 260
			}, {
				title: '操作',
				minWidth: 80,
				templet: '#currentTableBar',
				fixed: "right",
				align: "center"
			}]
		],
		where:{
			username:'',
			realname:''
		},
		// 是否开启分页
		page: false
	});
	// 监听搜索操作
	form.on('submit(data-search-btn)', function(data) {
		var result = data.field;
		//执行搜索重载
		table.reload('userloginlogTable', {
			where: {
				username:result.username,
				realname:result.realname
			}
		}, 'data');
		return false;
	});
	// 监听表格删除按钮
	table.on('tool(userloginlogTableFilter)', function(obj) {
		var param = obj.data;
		console.log(param);
		if(obj.event === 'delete') {
			layer.confirm('真的删除行?', function(index) {
				$.getJSON("RemoveLoginlogServlet", param, function(data){
					if(data == true){
						layer.msg('删除成功！', {anim: 3, icon: 6, time: 1500, shade: 0.1});						
						// 确定当前页码,重新加载数据表格
						table.reload('userloginlogTable', {
							where: {
								username:$('#username').val(),
								realname:$('#realname').val()
							}
						}, 'data');
					} else {
						layer.msg('删除失败，请查看该日志是否存在！', {anim: 6, icon: 5, time: 1500, shade: 0.1});	
					}
				});
				layer.close(index);
			});
		}
	});
});