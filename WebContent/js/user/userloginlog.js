// 定义全局变量
var $;
layui.use(['form', 'table', 'layer', 'laydate'], function() {
	$ = layui.jquery;
	var form = layui.form,
		table = layui.table,
		layer = layui.layer,
		laydate = layui.laydate;
	// 延时加载（否则可能查询不到--条件没有准备好）
	setTimeout(function() {
		// 初始化表格 
		table.render({
			// 设置ID
			id : 'userloginlogTable',
			// 指定原始 table 容器
			elem: '#userloginlogTableId',
			// 异步数据接口
			url: 'FindLoginlogServlet?status=look',
			// 设置导出按钮
			toolbar: '#tablebar',
			//设置表头。值是一个二维数组
			cols: [
				[{
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
					width: 110,
					title: '操作系统',
					align: "center"
				}, {
					field: 'loginbrowser',
					width: 110,
					title: '浏览器',
					align: "center"
				}, {
					field: 'loginremark',
					title: '登陆备注',
					minWidth: 220
				}]
				],
				where:{
					userid:$('#userid').val()
				},
				// 是否开启分页
				page: false
		});
	}, 50);
});