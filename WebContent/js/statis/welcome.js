layui.config({
    base: "js/"
}).extend({
    "layuimini": "layuimini"
});
layui.use(['layer', 'layuimini'], function () {
    var $ = layui.jquery,
        layer = layui.layer;
    
	// 表示文档结构已经加载完成后触发的事件（用于动态数据的准备）
	$(document).ready(function() {   
		console.log("在这里准备数据");
		/* 为所有 AJAX 请求设置默认 请求方式 同步 */
		$.ajaxSetup({
			async : false
		});
		
		// 获得参赛学生总人数
		getStuNum();
		// 获得获奖学生总人数
		getWinNum();
		// 获得未获奖学生总人数
		getLoserNum();
		// 获得用户登陆记录
		getLoginlog();
		// 显示柱状图
		showHistogram();
    });

    function getStuNum(){
    	var param = {'ram' : Math.random()};
    	$.getJSON('StatisServlet?status=getStuNum',param,function(data){
//			console.log(data);
			if(data != null){
				$('#stunum').html(data);
			} else {
				layer.msg('用户未登录！', {anim: 6, icon: 5, time: 1500, shade: 0.1});
			}
		});
    }
    function getWinNum(){
    	var param = {'ram' : Math.random()};
    	$.getJSON('StatisServlet?status=getWinNum',param,function(data){
//			console.log(data);
			if(data != null){
				$('#winnum').html(data);
			} else {
				layer.msg('用户未登录！', {anim: 6, icon: 5, time: 1500, shade: 0.1});
			}
		});
    }
    function getLoserNum(){
    	var param = {'ram' : Math.random()};
    	$.getJSON('StatisServlet?status=getLoserNum',param,function(data){
//			console.log(data);
			if(data != null){
				$('#losernum').html(data);
			} else {
				layer.msg('用户未登录！', {anim: 6, icon: 5, time: 1500, shade: 0.1});
			}
		});
    }
    function getLoginlog(){
    	var param = {'ram' : Math.random()};
    	$.getJSON('StatisServlet?status=getLoginlog',param,function(data){
			console.log(data);
			if(data != null){
				for (var i = 1; i <= data.length-1; i++){
					$('#notice-title_'+i).html(data[i].loginsite+" / "+data[i].loginos+" / "+data[i].loginbrowser);
					$('#notice-extra_'+i).html(data[i].logintime);
					if(i == 6){
						break;
					}
				}
			} else {
				layer.msg('用户未登录！', {anim: 6, icon: 5, time: 1500, shade: 0.1});
			}
		});
    }
    
    // 显示柱状图
    function showHistogram() {
    	var allnum = [10, 52, 200, 334, 390];
    	var winnum = [20, 72, 130, 234, 290];

    	var param = {
			'ram' : Math.random(),
			'competitionid' : '',
			'daterange' : ''
    	};
    	$.getJSON('StatisServlet?status=histogram_1',param,function(data){
    		console.log("---------------------------------------");
    		console.log(data);
    		if(data != null){
    			allnum = data;
    		}
    	});
    	$.getJSON('StatisServlet?status=histogram_2',param,function(data){
    		console.log("---------------------------------------");
    		console.log(data);
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
		            data : [ '数媒', '物联网', '计科', '网工', '软工' ],
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

        // 获取指定索引的图表元素
        var echartsRecords = echarts.init(document.getElementById('echarts-records'), 'walden');
        // 赋值
        echartsRecords.setOption(optionRecords);
        // echarts 窗口缩放自适应
        window.onresize = function(){
        	echartsRecords.resize();
        }
	}
});