ShowYear();
function ShowYear() {
	$.ajax({
		type : "POST",
		async : true, // 同步执行 结束请求后再在执行下一个ajax
		url : "frist/year.do",
		dataType : "JSON",
		success : function(data) {
			$("#year").html(data + "人次");
		}
	});
}

showMonth();
function showMonth() {
	$.ajax({
		type : "POST",
		async : true, // 同步执行 结束请求后再在执行下一个ajax
		url : "frist/month.do",
		dataType : "JSON",
		success : function(data) {
			$("#month").html(data + "月");
		}
	});
}

showForecast();
function showForecast() {
	$.ajax({
		type : "POST",
		async : true, // 同步执行 结束请求后再在执行下一个ajax
		url : "frist/forecast.do",
		dataType : "JSON",
		success : function(data) {
			$("#forecast").html(data + "月");
		}
	});
}
ShowBusyseason();
function ShowBusyseason() {
	$.ajax({
		type : "POST",
		async : false, // 同步执行 结束请求后再在执行下一个ajax
		url : "frist/getbusyseason.do",
		dataType : "JSON",
		success : function(data) {
			require([ 'echarts', 'js/chart/essos',
					'echarts/chart/bar', // 按需加载所需图表，如需动态类型切换功能，别忘了同时加载相应图表
			], function(ec, theme) {
				var myChart = ec.init(
						document.getElementById('wangji'), theme);

				var option = {
					backgroundColor:'',//背景颜色透明
					tooltip : {
						text : '旺季图',
						trigger : 'axis'
					},
					barWidth:'100%',
					calculable : true,
					grid : {
						y : 50,
						y2 : 30,
						x : 80,
						x2 : 80
					},
					legend : {
						data:['占比'],
						textStyle:{
							clolr:'ffffff'
						}
					},
					xAxis : [ {
						type : 'category',
						name : '月',
						boundaryGap : false,
						data : data.month,
						splitLine : {
							show : false
						},
						axisLine:{
	                        lineStyle:{
	                            color:'#FFFFFF',
	                        }
	                    } 

					} ],
					yAxis : {
						show : false,
						splitLine : {
							show : false
						},
					axisLine:{
                        lineStyle:{
                            color:'#FFFFFF',
                        }
                    } 
					},
					series : [
					{
						name : '占比',
						type : 'bar',					
						data : data.num,
						barWidth: 30
					}] 
				};

				myChart.setOption(option);
			});
		}
	});
}

Showlow();
function Showlow() {
	$.ajax({
		type : "POST",
		async : false, // 同步执行 结束请求后再在执行下一个ajax
		url : "frist/getlowseason.do",
		dataType : "JSON",
		success : function(data) {
			console.log(data);
			require([ 'echarts', 'js/chart/dark',
					'echarts/chart/bar', // 按需加载所需图表，如需动态类型切换功能，别忘了同时加载相应图表
			], function(ec, theme) {
				var myChart = ec.init(
						document.getElementById('danji'), theme);

				var option = {
					backgroundColor:'',//背景颜色透明
					tooltip : {
						text : '淡季图',
						trigger : '淡季'
					},

					calculable : true,
					grid : {
						y : 50,
						y2 : 30,
						x : 80,
						x2 : 80
					},
					legend : {
						data:['占比'],
						textStyle:{
							clolr:'ffffff'
						}
					},
					xAxis : [ {
						type : 'category',
						boundaryGap : false,
						name : '月',
						data:data.month,//x轴数据
						axisLine:{
	                        lineStyle:{
	                            color:'#FFFFFF',
	                        }
	                    } ,
	                 
						splitLine : {
							show : false
						},
					} ],
					yAxis : {
						show : false,
						splitLine : {
							show : false
						},
						axisLine:{
	                        lineStyle:{
	                            color:'#FFFFFF',
	                        }
	                    } 
					},
					series : [
					{
						name : '占比',
						type : 'bar',
						itemStyle : {
							normal : {
								color : 'rgba(75,225,213,1)',
							/*
							 * label : { show : true }
							 */
							}
						},
						barWidth: 30,
						data : data.num
					}]
				};
				myChart.setOption(option);
			});
		}
	});
}
$.ajax({
	type : "POST",
	async : true, //同步执行
	url : "frist/getimpression.do",
	dataType : "JSON",
	success : function(data) {
		var d = [];
		for (var i = 0; i < data.word.length; i++) {
			d.push({
				'text' : data.word[i],
				'weight' : data.num[i],
			})
		}
		impression(d);
	}
});

function impression(d) {
	$(document).ready(function() {
		$("#impression").jQCloud(d, {
			width : 600,
			height : 600
		});
	});
}