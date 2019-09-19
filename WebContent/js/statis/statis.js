// 定义全局变量
var $;
var competitionid = '';// 赛事文本框一
var competitionid2 = '';// 赛事文本框二
var majorid = '';// 专业文本框
var classid = '';// 班级文本框
var grade = '';// 班级文本框
var daterange = '';// 赛事时间范围文本框

var echarts_pienum,echarts_piewin,echarts_histogram;
layui.use(['form', 'layer', 'laydate'], function() {
	$ = layui.jquery;
	var form = layui.form,
		layer = layui.layer,
		laydate = layui.laydate;
	//日期1
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
	//日期2
	laydate.render({
		elem: '#daterange',
		type: 'month',
		range: '~'
	});
	
	// 表示文档结构已经加载完成后触发的事件（用于动态数据的准备）
	$(document).ready(function() {   
		console.log("在这里准备数据");
		/* 为所有 AJAX 请求设置默认 请求方式 同步 */
		$.ajaxSetup({
			async : false
		});
		
		// 赛事下拉列表准备数据
		getCompetition();
		// 获取专业下拉列表
        getMajors(5);
        
        echarts_pienum = echarts.init(document.getElementById('pienum'), 'walden');
        echarts_piewin = echarts.init(document.getElementById('piewin'), 'walden');
        echarts_histogram = echarts.init(document.getElementById('histogrammajor'), 'walden');
		// 获取班级下拉列表
		getClasses($('#grade').val());
		// 显示饼图1
		showpie_1();
		showpie_2();
		// 显示柱状图
	    showHistogram();
	    
    });
	// 监听专业下拉列表
	form.on("select(major)", function(data){
		// 获取班级下拉列表
		getClasses($('#grade').val());
    });
	
	// 监听搜索_1操作
	form.on('submit(data-search-btn1)', function(data) {
		competitionid = $('#competition').val();
		majorid = $('#major').val();
		classid = $('#clase').val();
		grade = $('#grade').val();
		
		// 刷新饼图
	    showpie_1();
	    showpie_2();
	    
		return false;
	});
	
	// 监听搜索_2操作
	form.on('submit(data-search-btn2)', function(data) {
		competitionid2 = $('#competition2').val();
		daterange = $('#daterange').val();
		
		// 刷新柱状图
	    showHistogram();
	    
		return false;
	});
	
	// 显示饼图1
    function showpie_1() {
    	var adtaArr = [2019, 10, 52, 200, 334];

    	var param = {
			'ram' : Math.random(),
			'competitionid' : $('#competition').val(),
			'grade' : $('#grade').val(),
			'majorid' : $('#major').val(),
			'classid' : $('#clase').val()
    	};
    	$.getJSON('StatisServlet?status=pie_1',param,function(data){
    		// console.log(data);
    		if(data != null){
    			adtaArr = data;
    		}
    	});

    	// 参赛人数统计饼图
    	var pienum = {
    	    title : {
    	        // text: '参赛人数统计',
    	        // subtext: '当前在校学生',
    	        // x:'center'
    	    },
    	    tooltip : {
    	        trigger: 'item',
    	        formatter: "{a} <br/>{b} : {c} ({d}%)"
    	    },
    	    legend: {
    	        orient: 'vertical',
    	        left: 'left',
    	        data: [adtaArr[0]+'',adtaArr[0]-1+'',adtaArr[0]-2+'',adtaArr[0]-3+'']
    	    },
    	    series : [
    	        {
    	            name: '参赛人数',
    	            type: 'pie',
    	            radius : '55%',
    	            center: ['50%', '60%'],
    	            data:[
    	                {value:adtaArr[1], name:adtaArr[0]+''},
    	                {value:adtaArr[2], name:adtaArr[0]-1+''},
    	                {value:adtaArr[3], name:adtaArr[0]-2+''},
    	                {value:adtaArr[4], name:adtaArr[0]-3+''},
    	            ],
    	            itemStyle: {
    	                emphasis: {
    	                    shadowBlur: 10,
    	                    shadowOffsetX: 0,
    	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
    	                }
    	            }
    	        }
    	    ]
    	};
    	
    	echarts_pienum.setOption(pienum);
        // echarts 窗口缩放自适应
        window.onresize = function(){
        	echarts_pienum.resize();
        }
    }
    
 // 显示饼图2
    function showpie_2() {
    	var adtaArr = [66, 6, 15, 33, 45, 128, 231];

    	var param = {		
			'ram' : Math.random(),
			'competitionid' : $('#competition').val(),
			'grade' : $('#grade').val(),
			'majorid' : $('#major').val(),
			'classid' : $('#clase').val()
    	};
    	$.getJSON('StatisServlet?status=pie_2',param,function(data){
    		console.log("---------------------------------------");
    		console.log(data);
    		if(data != null){
    			adtaArr = data;
    		}
    	});

    	// 参赛人数统计饼图
    	var piewin = {
    	    title : {
//    	        text: '参赛人数统计',
//    	        subtext: '当前在校学生',
//    	        x:'center'
    	    },
    	    tooltip : {
    	        trigger: 'item',
    	        formatter: "{a} <br/>{b} : {c} ({d}%)"
    	    },
    	    legend: {
    	        orient: 'vertical',
    	        left: 'left',
    	        data: [ '待定', '特等奖', '一等奖', '二等奖', '三等奖', '优秀奖', '未获奖' ]
    	    },
    	    series : [
    	        {
    	            name: '获奖情况',
    	            type: 'pie',
    	            radius : '55%',
    	            center: ['50%', '60%'],
    	            data:[
    	            	{value:adtaArr[0], name:'待定'},
    	                {value:adtaArr[1], name:'特等奖'},
    	                {value:adtaArr[2], name:'一等奖'},
    	                {value:adtaArr[3], name:'二等奖'},
    	                {value:adtaArr[4], name:'三等奖'},
    	                {value:adtaArr[5], name:'优秀奖'},
    	                {value:adtaArr[6], name:'未获奖'},
    	            ],
    	            itemStyle: {
    	                emphasis: {
    	                    shadowBlur: 10,
    	                    shadowOffsetX: 0,
    	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
    	                }
    	            }
    	        }
    	    ]
    	};
    	echarts_piewin.setOption(piewin);
    	// echarts 窗口缩放自适应
    	window.onresize = function() {
    		echarts_piewin.resize();
    	}
    }
	
	
	// 显示柱状图
    function showHistogram() {
    	var allnum = [10, 52, 200, 334, 390];
    	var winnum = [20, 72, 130, 234, 290];

    	var param = {
			'ram' : Math.random(),
			'competitionid' : $('#competition2').val(),
			'daterange' : $('#daterange').val()
    	};
    	$.getJSON('StatisServlet?status=histogram_1',param,function(data){
//    		console.log(data);
    		if(data != null){
    			allnum = data;
    		}
    	});
    	$.getJSON('StatisServlet?status=histogram_2',param,function(data){
//    		console.log(data);
    		if(data != null){
    			winnum = data;
    		}
    	});
        // 各专业参赛人数柱状图
        var optionRecords = {
		    tooltip : {
		        trigger: 'axis',
		        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
		            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
		        }
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
			legend : {
				data : [ '参赛人数', '获奖人数' ]
			},
			toolbox : {
				show : true,
				feature : {
					mark : {
						show : true
					},
					dataView : {
						show : true,
						readOnly : false
					},
					magicType : {
						show : true,
						type : [ 'line', 'bar' ]
					},
					restore : {
						show : true
					},
					saveAsImage : {
						show : true
					}
				}
			},
		    xAxis : [
		        {
		            type : 'category',
		            data : [ '数字媒体技术', '物联网工程', '计算机科学与技术', '网络工程', '软件工程'],
		            axisTick: {
		                alignWithLabel: true
		            }
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    series : [
		        {
		            name:'参赛人数',
		            type:'bar',
		            barWidth: '30%',
		            data:allnum,
		            itemStyle: {
						normal: {
							label: {
								show: true, //开启显示
								position: 'top', //在上方显示
								textStyle: { //数值样式
									color: 'gray',
									fontSize: 16
								}
							}
						}
					}
		        },
		        {
		            name:'获奖人数',
		            type:'bar',
		            barWidth: '30%',
		            data:winnum,
		            itemStyle: {
						normal: {
							label: {
								show: true, //开启显示
								position: 'top', //在上方显示
								textStyle: { //数值样式
									color: 'gray',
									fontSize: 16
								}
							}
						}
					}
		        }
		    ]
		};

        // 赋值
        echarts_histogram.setOption(optionRecords);
        // echarts 窗口缩放自适应
        window.onresize = function(){
        	echarts_histogram.resize();
        }
	}
    
    // 参赛人数统计饼图触发点击事件
    echarts_pienum.on('click', function(params) {
		layer.open({
			'ram' : Math.random(),
			type : 2,
			title: "参赛情况汇总",
			area : [ '100%', '100%' ],
			scrollbar: false,
			content : ['views/statis/find_statinfo2.html'], // 调到查询页面
			success : function(layero, index) {
				var body = layer.getChildFrame('body', index);
				var iframeWin = window[layero.find('iframe')[0]['name']]; // 得到iframe页的窗口对象
				
				body.find('#grade').val(params.name);
				body.find('#classid').val(classid);
				body.find('#daterange').val('');
		    	findCompetition_son(body, iframeWin, competitionid);
		    	findMajor_son(body, iframeWin, majorid, true);
				
			    // 渲染页面表单，否则不显示数据 
				iframeWin.layui.form.render();
			}
		})
	})
    // 获奖情况统计触发点击事件
    echarts_piewin.on('click', function(params) {
		layer.open({
			'ram' : Math.random(),
			type : 2,
			title: "参赛情况汇总",
			area : [ '100%', '100%' ],
			scrollbar: false,
			content : ['views/statis/find_statinfo2.html'], // 调到查询页面
			success : function(layero, index) {
				var body = layer.getChildFrame('body', index);
				var iframeWin = window[layero.find('iframe')[0]['name']]; // 得到iframe页的窗口对象
				
				body.find('#grade').val(grade);
			    body.find('#award').val(params.name);
			    body.find('#daterange').val('');
		    	findCompetition_son(body, iframeWin, competitionid);
		    	findMajor_son(body, iframeWin, majorid, true);
		    	
			    // 渲染页面表单，否则不显示数据 
				iframeWin.layui.form.render();
			}
		})
	})
	
    // 各专业获奖情况统计触发点击事件
    echarts_histogram.on('click', function(params) {
		layer.open({
			'ram' : Math.random(),
			type : 2,
			title: "参赛情况汇总",
			area : [ '100%', '100%' ],
			scrollbar: false,
			content : ['views/statis/find_statinfo2.html'], // 调到查询页面
			success : function(layero, index) {
				var body = layer.getChildFrame('body', index);
				var iframeWin = window[layero.find('iframe')[0]['name']]; // 得到iframe页的窗口对象
		    	
		    	body.find('#daterange').val(daterange);
		    	findCompetition_son(body, iframeWin, competitionid2);
		    	var majorname = params.name;
		    	findMajor_son(body, iframeWin, majorname, false);
		    	
			    // 渲染页面表单，否则不显示数据 
				iframeWin.layui.form.render();
			}
		})
	})
	
});

/* 获得赛事下拉列表 */
function getCompetition(){
	clearCompetitionHtml();
    var param = {'ram' : Math.random()};
	$.getJSON("FindCompetitionAllServlet",param,function(data){
		console.log(data);
		$.each(data, function(index, item) {
			if(item.deptname == 'xxx'){
				var op = $("<option>").val(item.competitionid).text(item.competitionname).prop('selected',true);
			} else {
				var op = $("<option>").val(item.competitionid).text(item.competitionname);
			}
			$("#competition").append(op);
			getCompetition_2();
		});
		// 渲染页面表单，否则不显示数据
		layui.form.render('select');
	});
}
/* 清除赛事下拉列表 */
function clearCompetitionHtml() {
	$("#competition").html("");//empty()
	var pleaseOption = $("<option>").val("").text("请选择").prop('selected',true);
	$("#competition").append(pleaseOption);
	
	$("#competition2").html("");//empty()
	var pleaseOption2 = $("<option>").val("").text("请选择").prop('selected',true);
	$("#competition2").append(pleaseOption2);
}
/* 获得赛事下拉列表2 */
function getCompetition_2(){
    var param = {'ram' : Math.random()};
	$.getJSON("FindCompetitionAllServlet",param,function(data){
		console.log(data);
		$.each(data, function(index, item) {
			if(item.deptname == 'xxx'){
				var op = $("<option>").val(item.competitionid).text(item.competitionname).prop('selected',true);
			} else {
				var op = $("<option>").val(item.competitionid).text(item.competitionname);
			}
			$("#competition2").append(op);
		});
		// 渲染页面表单，否则不显示数据
		layui.form.render('select');
	});
}
/* 获得赛事下拉列表-子页面 */
function findCompetition_son(body, iframeWin, srcparam){
	body.find("#competition").html("");//empty()
    var pleaseOption = $("<option>").val("").text("请选择").prop('selected',true);
    body.find("#competition").append(pleaseOption);
    
    var param = {'ram' : Math.random()};
	$.getJSON("FindCompetitionAllServlet",param,function(data){
		console.log(data);
		$.each(data, function(index, item) {
			if(item.competitionid == srcparam){
				var op = $("<option>").val(item.competitionid).text(item.competitionname).prop('selected',true);
			} else {
				var op = $("<option>").val(item.competitionid).text(item.competitionname);
			}
			body.find("#competition").append(op);
		});
		// 渲染页面表单，否则不显示数据
		iframeWin.layui.form.render('select');
	});
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
/* 获得赛事下拉列表-子页面 */
function findMajor_son(body, iframeWin, srcparam, flag){
	body.find("#major").html("");//empty()
    var pleaseOption = $("<option>").val("").text("请选择").prop('selected',true);
    body.find("#major").append(pleaseOption);
    
    var param = {'ram' : Math.random(), 'deptid':5,};
	$.getJSON("FindMajorServlet",param,function(data){
		console.log(data);
		if(flag){
			$.each(data, function(index, item) {
				if(item.majorid == srcparam){
					var op = $("<option>").val(item.majorid).text(item.majorname).prop('selected',true);
				} else {
					var op = $("<option>").val(item.majorid).text(item.majorname);
				}
				body.find("#major").append(op);
			});
		} else {
			$.each(data, function(index, item) {
				if(item.majorname == srcparam){
					var op = $("<option>").val(item.majorid).text(item.majorname).prop('selected',true);
				} else {
					var op = $("<option>").val(item.majorid).text(item.majorname);
				}
				body.find("#major").append(op);
			});
		}

		// 渲染页面表单，否则不显示数据
		iframeWin.layui.form.render('select');
	});
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
