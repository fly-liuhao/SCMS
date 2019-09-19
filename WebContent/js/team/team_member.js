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
			id : 'teammemberTable',
			// 指定原始 table 容器
			elem: '#teammemberTableId',
			// 异步数据接口
			url: 'FindStudentInfoServlet?status=findstuinfosbyteamid',
			where:{teamid:$('#teamid').val()},
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
					field: 'stuid',
					width: 120,
					title: '成员学号'
				}, {
					field: 'stuname',
					width: 110,
					title: '成员姓名'
				}, {
					field: 'sex',
					width: 110,
					title: '成员性别'
				}, {
					field: 'mobile',
					width: 120,
					title: '联系方式'
				}, {
					field: 'classname',
					width: 110,
					title: '班级'
				}, {
					field: 'majorname',
					minWidth: 110,
					title: '专业'
				}]
			],
			// 是否开启分页
			page: false
		});
	}, 50);
});