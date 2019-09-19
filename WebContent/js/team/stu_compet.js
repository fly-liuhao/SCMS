// 定义全局变量
var $;
layui.use(['form', 'table', 'layer', 'laydate'], function() {
	$ = layui.jquery;
	var form = layui.form,
		table = layui.table,
		layer = layui.layer,
		laydate = layui.laydate;
	//日期
	laydate.render({
		elem: '#daterange',
		type: 'month',
		range: '~'
	});
	// 延时加载（否则可能查询不到--条件没有准备好）
	setTimeout(function() {
		// 初始化表格 
		table.render({
			//设置ID
			id : 'competitionTable',
			// 指定原始 table 容器
			elem: '#competitionTableId',
			// 异步数据接口
			url: 'FindCompetByStuidServlet',
			where:{stuid:$('#stuid').val()},
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
					field: 'sturole',
					width: 140,
					title: '参与角色'
				}, {
					field: 'competitionname',
					width: 150,
					title: '赛事名称',
				}, {
					field: 'competitiondate',
					width: 140,
					title: '举办时间'
				}, {
					field: 'competitionlevel',
					width: 140,
					title: '赛事级别'
				}, {
					field: 'competitiontype',
					minWidth: 140,
					title: '赛事类型'
				}]
			],
			// 是否开启分页
			page: false
		});
	}, 50);
});