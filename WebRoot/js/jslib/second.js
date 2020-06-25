
Show17year();
function Show17year() {
	$.ajax({
		type : "POST",
		async : false, // 同步执行 结束请求后再在执行下一个ajax
		url : "second/get17.do",
		dataType : "JSON",
		success : function(data) {
			require([ 'echarts', 'js/chart/dark',
					'echarts/chart/bar', // 按需加载所需图表，如需动态类型切换功能，别忘了同时加载相应图表
			], function(ec, theme) {
				var myChart = ec.init(
						document.getElementById('sthree'), theme);

				var option = {
						backgroundColor:'',
					tooltip : {
						text : '2017年评论量柱状图',
						color : 'rgb(255.255.255)',
					},

					calculable : true,
					grid : {
						y : 50,
						y2 : 30,
						x : 80,
						x2 : 20
					},
					legend : {
						data:['占比']
					},
					xAxis : [ {
						show : true,
						type : 'category',
						boundaryGap : true,
						data : data.month
					} ],
					yAxis : {},
					series : [
					{
						name : '占比',
						type : 'bar',
						barWidth: 20,
						barMaxWidth:20,
						
						data : data.num
					}]
				};
				myChart.setOption(option);
			});
		}
	});
}
Show18year();
function Show18year() {
	$.ajax({
		type : "POST",
		async : false, // 同步执行 结束请求后再在执行下一个ajax
		url : "second/get18.do",
		dataType : "JSON",
		success : function(data) {
			require([ 'echarts', 'js/chart/dark',
					'echarts/chart/bar', // 按需加载所需图表，如需动态类型切换功能，别忘了同时加载相应图表
			], function(ec, theme) {
				var myChart = ec.init(
						document.getElementById('sone'), theme);

				var option = {
						backgroundColor:'',//背景颜色透明
					tooltip : {
						text : '2018年评论量柱状图',
						color : 'rgb(255.255.255)',
					},

					calculable : true,
					grid : {
						y : 50,
						y2 : 30,
						x : 50,
						x2 : 50
					},
					legend : {
						data:['占比']
					},
					xAxis : [ {
						show : true,
						type : 'category',
						boundaryGap : true,
						data : data.month
					} ],
					yAxis : {},
					series : [
					{
						name : '占比',
						type : 'bar',
						barWidth: 20,
						barMaxWidth:20,
						
						data : data.num
					}]
				};
				myChart.setOption(option);
			});
		}
	});
}
Show19year();
function Show19year() {
	$.ajax({
		type : "POST",
		async : false, // 同步执行 结束请求后再在执行下一个ajax
		url : "second/get19.do",
		dataType : "JSON",
		success : function(data) {
			require([ 'echarts', 'js/chart/dark',
					'echarts/chart/bar', // 按需加载所需图表，如需动态类型切换功能，别忘了同时加载相应图表
			], function(ec, theme) {
				var myChart = ec.init(
						document.getElementById('stwo'), theme);

				var option = {
				
						backgroundColor:'',//背景颜色透明
					tooltip : {
						text : '2019年评论量柱状图',
						color : 'rgb(255.255.255)',
					},

					calculable : true,
					grid : {
						y : 50,
						y2 : 30,
						x : 50,
						x2 : 80
					},
					legend : {
						data:['占比'],
						left:'600'
					},
					xAxis : [ {
						show : true,
						type : 'category',
						boundaryGap : true,
						data : data.month
					} ],
					yAxis : {},
					series : [
					{
						name : '占比',
						type : 'bar',
						barWidth: 20,
						barMaxWidth:20,
						
						data : data.num
					}]
				};

				myChart.setOption(option);
			});
		}
	});
}