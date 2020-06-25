$.ajax({
	type : "POST",
	async : true, //同步执行
	url : "three/q.do",
	dataType : "JSON",
	success : function(data) {
		optuserplat(data);
		
	}
});
	
	function optuserplat(data) {
		require([ 'echarts','js/chart/dark', 'echarts/chart/line'],
				function(ec,theme) {
					var myChart = ec.init(document.getElementById('gugong2020'),theme);
					myChart.setOption(mationuserplat(data));
				});
	}
	
	function mationuserplat(data) {
		
		var option = {
			backgroundColor:'',//背景颜色透明
			title : {
				text : '故宫2020年1月至6月人流量 ',
				x : 'center'
			},
			tooltip : {
				trigger : 'axis'
			},
			legend : {
				data : [ '2020年1月至6月' ,'往年同期'],
				top:'5',
				x:'right'
			},
			xAxis:{
				type:'category',
				data:['1月','2月','3月','4月','5月','6月'],//x轴数据
				name:'月份',
				nameTextStyle:{
					fontWeight:600,
					fontSize:18
				},
			},
			yAxis:{
				type:'value',
				name:'游客流量',
				nameTextStyle:{
					fontWeight:600,
					fontSize:18
				}
			},
			series : [ 
				{
				name : '2020年1月至6月',
				type : 'line', 
				data : [data.d1[0],data.d1[1],data.d1[2],data.d1[3],data.d1[4],data.d1[5]]
				} ,
				{
				name : '往年同期',
				type : 'line', 
				data : [data.d2[0],data.d2[1],data.d2[2],data.d2[3],data.d2[4],data.d2[5]]
				} 
			]
		};
		return option;
	};
	
	
	
	