$.ajax({
	type : "POST",
	async : true, //同步执行
	url : "four/badcontext.do",
	dataType : "JSON",
	success : function(data) {
		var d = [];
		for (var i = 0; i < data.word.length; i++) {
			d.push({
				'text' : data.word[i],
				'weight' : data.num[i],
			})
		}
		badwordcloud(d);
	}
});

function badwordcloud(d) {
	$(document).ready(function() {
		$("#badwordcloud").jQCloud(d, {
			width : 300,
			height : 300
		});
	});
}

$.ajax({
	type : "POST",
	async : true, //同步执行
	url : "four/goodcontext.do",
	dataType : "JSON",
	success : function(data) {
		var d = [];
		for (var i = 0; i < data.word.length; i++) {
			d.push({
				'text' : data.word[i],
				'weight' : data.num[i],
			})
		}
		goodwordcloud(d);
	}
});

function goodwordcloud(d) {
	$(document).ready(function() {
		$("#goodwordcloud").jQCloud(d, {
			width : 300,
			height : 300
		});
	});
}




$.ajax({
	type : "POST",
	async : true, //同步执行
	url : "four/meituan.do",
	dataType : "JSON",
	success : function(data) {
		meituan(data);

	}
});

function meituan(data) {
	require([ 'echarts', 'js/chart/essos', 'echarts/chart/pie' ],
		function(ec, theme) {
			var myChart = ec.init(document.getElementById('meituan'), theme);
			myChart.setOption(showmeituan(data));
			
			var ecConfig = require('echarts/config');
			myChart.on(ecConfig.EVENT.CLICK, function(param) {
				console.log(param.name);
				tanceng();
				 function tanceng(){
					  layer.open({
					  type: 1,
					  title: param.seriesName+param.name+'详情',
					  maxmin: true,
					  shadeClose: true, //点击遮罩关闭层
					  area : ['800px' , '600px'],
					  content: '\<\div style="width:730px;margin:auto;">   \<\div id="container" style="position: absolute;margin-top:30px; width: 730px; height: 4000px; top: 50; border: 1px solid gray;overflow:hidden;">\<\/div>\<\/div>'
					  });
					};
					context(param.seriesName,param.name);
				
			});
			
		});
}

function showmeituan(data) {
	var option = {
		backgroundColor : '', //背景颜色透明
		title:{
			text:'美团',
			x:'center',
			textStyle:{
				color:"#fff"
			}
		},
		tooltip : {
			trigger : 'item'
		},

		series : [
			{
				name : 'meituan',
				type : 'pie',
				radius : [ '0', '50%' ], //饼图大小
				
				labelLine : { //图形外文字线
					normal : {
						length : 35,
						length2 : 80
					}
				},
				
				itemStyle:{
					normal:{
						label:{
							show:true,
							formatter:'{b}:{d}%'
						}
					}
				},
				
				data : [
					{
						value : data.good,
						name : '好评'
					},
					{
						value : data.bad,
						name : '差评'
					}
				],
				
			}
		]
	};
	return option;
};


$.ajax({
	type : "POST",
	async : true, //同步执行
	url : "four/qunaer.do",
	dataType : "JSON",
	success : function(data) {
		qunaer(data);

	}
});

function qunaer(data) {
	require([ 'echarts', 'js/chart/essos', 'echarts/chart/pie' ],
		function(ec, theme) {
			var myChart = ec.init(document.getElementById('qunaer'), theme);
			myChart.setOption(showqunaer(data));
			
			var ecConfig = require('echarts/config');
			myChart.on(ecConfig.EVENT.CLICK, function(param) {
				console.log(param.name);
				tanceng();
				 function tanceng(){
					  layer.open({
					  type: 1,
					  title: param.seriesName+param.name+'详情',
					  maxmin: true,
					  shadeClose: true, //点击遮罩关闭层
					  area : ['800px' , '600px'],
					  content: '\<\div style="width:730px;margin:auto;">   \<\div id="container" style="position: absolute;margin-top:30px; width: 730px; height: 4000px; top: 50; border: 1px solid gray;overflow:hidden;">\<\/div>\<\/div>'
					  });
					};
					context(param.seriesName,param.name);
				
			});
		});
}

function showqunaer(data) {
	var option = {
		backgroundColor : '', //背景颜色透明
		title:{
			text:'去哪儿',
			x:'center',
			textStyle:{
				color:"#fff"
			}
		},
		tooltip : {
			trigger : 'item'
		},
		
		series : [
			{
				name : 'qunaer',
				type : 'pie',
				radius : [ '0', '50%' ], //饼图大小
				
				labelLine : { //图形外文字线
					normal : {
						length : 35,
						length2 : 80
					}
				},
				
				itemStyle:{
					normal:{
						label:{
							show:true,
							formatter:'{b}:{d}%'
						}
					}
				},
				
				data : [
					{
						value : data.good,
						name : '好评'
					},
					{
						value : data.bad,
						name : '差评'
					}
				],
				
			}
		]
	};
	return option;
};


$.ajax({
	type : "POST",
	async : true, //同步执行
	url : "four/tongcheng.do",
	dataType : "JSON",
	success : function(data) {
		tongcheng(data);
	}
});

function tongcheng(data) {
	require([ 'echarts', 'js/chart/essos', 'echarts/chart/pie' ],
		function(ec, theme) {
			var myChart = ec.init(document.getElementById('tongcheng'), theme);
			myChart.setOption(showtongcheng(data));

			var ecConfig = require('echarts/config');
			myChart.on(ecConfig.EVENT.CLICK, function(param) {
				console.log(param.name);
				tanceng();
				 function tanceng(){
					  layer.open({
					  type: 1,
					  title: param.seriesName+param.name+'详情',
					  maxmin: true,
					  shadeClose: true, //点击遮罩关闭层
					  area : ['800px' , '600px'],
					  content: '\<\div style="width:730px;margin:auto;">   \<\div id="container" style="position: absolute;margin-top:30px; width: 730px; height: 4000px; top: 50; border: 1px solid gray;overflow:hidden;">\<\/div>\<\/div>'
					  });
					};
					context(param.seriesName,param.name);
				
			});
		});
}

function showtongcheng(data) {
	var option = {
		backgroundColor : '', //背景颜色透明
		title:{
			text:'同程',
			x:'center',
			textStyle:{
				color:"#fff"
			}
		},
		tooltip : {
			trigger : 'item'
		},

		series : [
			{
				name : 'tongcheng',
				type : 'pie',
				radius : [ '0', '50%' ], //饼图大小
				
				labelLine : { //图形外文字线
					normal : {
						length : 35,
						length2 : 80
					}
				},
				
				itemStyle:{
					normal:{
						label:{
							show:true,
							formatter:'{b}:{d}%'
						}
					}
				},
				
				data : [
					{
						value : data.good,
						name : '好评'
					},
					{
						value : data.bad,
						name : '差评'
					}
				],
				
			}
		]
	};
	return option;
};


$.ajax({
	type : "POST",
	async : true, //同步执行
	url : "four/xiecheng.do",
	dataType : "JSON",
	success : function(data) {
		xiecheng(data);
	}
});

function xiecheng(data) {
	require([ 'echarts', 'js/chart/essos', 'echarts/chart/pie' ],
		function(ec, theme) {
			var myChart = ec.init(document.getElementById('xiecheng'), theme);
			myChart.setOption(showxiecheng(data));
			
			var ecConfig = require('echarts/config');
			myChart.on(ecConfig.EVENT.CLICK, function(param) {
				console.log(param.name);
				tanceng();
				 function tanceng(){
					  layer.open({
					  type: 1,
					  title: param.seriesName+param.name+'详情',
					  maxmin: true,
					  shadeClose: true, //点击遮罩关闭层
					  area : ['800px' , '600px'],
					  content: '\<\div style="width:730px;margin:auto;">   \<\div id="container" style="position: absolute;margin-top:30px; width: 730px; height: 4000px; top: 50; border: 1px solid gray;overflow:hidden;">\<\/div>\<\/div>'
					  });
					};
					context(param.seriesName,param.name);
				
			});
		});
}

function showxiecheng(data) {
	var option = {
		backgroundColor : '', //背景颜色透明
		title:{
			text:'携程',
			x:'center',
			textStyle:{
				color:"#fff"
			}
		},
		tooltip : {
			trigger : 'item'
		},

		series : [
			{
				name : 'xiecheng',
				type : 'pie',
				radius : [ '0', '50%' ], //饼图大小
				
				labelLine : { //图形外文字线
					normal : {
						length : 35,
						length2 : 80
					}
				},
				
				itemStyle:{
					normal:{
						label:{
							show:true,
							formatter:'{b}:{d}%'
						}
					}
				},
				
				data : [
					{
						value : data.good,
						name : '好评'
					},
					{
						value : data.bad,
						name : '差评'
					}
				],
				
			}
		]
	};
	return option;
};


$.ajax({
	type : "POST",
	async : true, //同步执行
	url : "four/tuniu.do",
	dataType : "JSON",
	success : function(data) {
		tuniu(data);
	}
});

function tuniu(data) {
	require([ 'echarts', 'js/chart/essos', 'echarts/chart/pie' ],
		function(ec, theme) {
			var myChart = ec.init(document.getElementById('tuniu'), theme);
			myChart.setOption(showtuniu(data));
			
			var ecConfig = require('echarts/config');
			myChart.on(ecConfig.EVENT.CLICK, function(param) {
				console.log(param.name);
				tanceng();
				 function tanceng(){
					  layer.open({
					  type: 1,
					  title: '途牛'+param.name+'详情',
					  maxmin: true,
					  shadeClose: true, //点击遮罩关闭层
					  area : ['800px' , '600px'],
					  content: '\<\div style="width:730px;margin:auto;">   \<\div id="container" style="position: absolute;margin-top:30px; width: 730px; height: 4000px; top: 50; border: 1px solid gray;overflow:hidden;">\<\/div>\<\/div>'
					  });
					};
					context(param.seriesName,param.name);
				
			});
		});
}

function showtuniu(data) {
	var option = {
		backgroundColor : '', //背景颜色透明
		title:{
			text:'途牛',
			x:'center',
			textStyle:{
				color:"#fff"
			}
		},
		tooltip : {
			trigger : 'item'
		},

		series : [
			{
				name : 'tuniu',
				type : 'pie',
				radius : [ '0', '50%' ], //饼图大小
				
				labelLine : { //图形外文字线
					normal : {
						length : 35,
						length2 : 80
					}
				},
				
				itemStyle:{
					normal:{
						label:{
							show:true,
							formatter:'{b}:{d}%'
						}
					}
				},
				
				data : [
					{
						value : data.good,
						name : '好评'
					},
					{
						value : data.bad,
						name : '差评'
					}
				],
				
			}
		]
	};
	return option;
};


function context(cor,type) {
	var t=null;

	if(type=="差评"){
		t="bad";
	}
	else if(type=="好评"){
		t="good"
	}
	console.log(t);
	$.ajax({
		type : "POST",
		async : false, // 同步执行 结束请求后再在执行下一个ajax
		url : "four/"+cor+t+".do",
		data : {
			context : cor
		},
		dataType : "JSON",
		success : function(data) {
			$("#container").html("");
			$("#container").append(
					"<table class=\"table\"><thead><tr><th>"
							+ "用户名" + "</th><th>" + "评论内容"
							+ "</th><th>" + "时间" + "</th><th>"
							+ "平台"  + "</th></tr></thead></table>");
			for ( var i = 0; i < data.list.length; i++) {
				$(".table").append(
						"<tr><td>"
								+ data.list[i].username
								+ "</td><td>"
								+ data.list[i].context
								+ "</td><td>"
								+ data.list[i].time
								+ "</td><td>"
								+ data.list[i].corporation
								+ "</td></tr>");
			}
		}
	});
};
