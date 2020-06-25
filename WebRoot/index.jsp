<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>故宫</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="static/css/bmap.css">
<link rel="stylesheet" type="text/css" href="static/css/jqcloud.css">
<style>
html, body {
	height: 100%;
}

* {
	margin: 0;
	padding: 0;
	font-family: "Microsoft YaHei", '微软雅黑';
}

p {
	margin: 0 !important;
}

.f26 {
	font-weight: bold;
	font-size: 26px;
}

.f14 {
	font-size: 14px;
}

#wrapper {
	position: relative;
	margin: 0px auto;
	width: 100%;
	height: 100%;
	background-color: #353a48;
}

#banner {
	position: relative;
	width: 100%;
	height: 100%;
	overflow: hidden;
}

.imgList {
	position: relative;
	width: 600%;
	z-index: 10;
	height: 100%;
	overflow: hidden;
}

.imgList .slider_div {
	float: left;
	display: inline-block;
	width: 16.66%;
	height: 100%;
}

#prev, #next {
	position: absolute;
	top: 50%;
	margin-top: -28px;
	z-index: 20;
	cursor: pointer;
	opacity: 0.8;
	filter: alpha(opacity =     80);
}

#prev {
	left: 10px;
}

#next {
	right: 10px;
}

#prev:hover, #next:hover {
	opacity: 0.8;
	filter: alpha(opacity =     80);
}

.indexList {
	position: absolute;
	right: 10px;
	top: 5px;
	z-index: 30;
}

.indexList li {
	float: left;
	margin-right: 5px;
	padding: 2px 4px;
	border: 2px solid black;
	background: grey;
	cursor: pointer;
}

.indexList .indexOn {
	background: red;
	font-weight: bold;
	color: white;
}

h3 {
	margin-left: 160px;
}

.corporation {
	padding-top: 20px;
	width: 300px;
	height: 200px;
	float: left;
	margin-top:10px;
}
</style>


</head>
<body>
	<div id="wrapper">
		<!-- 最外层部分 -->
		<div id="banner">
			<!-- 轮播部分 -->
			<div class="imgList">
				<!-- 图片部分 -->


				<div class="slider_div">
					<div style="width: 100%;height: 100%;background-color: #121c35">
						<p
							style="color: white;text-align: center;font-size: 28px; font-weight: bold;line-height: 46px;height: 46px;margin: 0;padding: 0;">故宫数据分析平台</p>
						<div
							style="height:100%;width:100%; background-image:url(bg.jpg);background-repeat:no-repeat;background-size:100% 100%;">
							<div style="float:left; width:23%;height: 100%;margin-right:1px;">
								<div
									style="padding-top:50px; width: 100%;height: 30%;margin-bottom:1px;background-color: #7F2726;">
									<br />
									<p style="color: white;text-align: center;font-size: 25px">19年参观人数</p>
									<p id="year"
										style="color: white;text-align: center;font-size: 30px"></p>
									<p class="span_div" style="color: white;text-align: center;">
									</p>
								</div>
								<div
									style="padding-top:50px; width: 100%;height: 30%;margin-bottom:1px ;background-color: #7F2726;">
									<br />
									<p style="color: white;text-align: center;font-size: 25px">参观人数最多的月份</p>
									<p id="month"
										style="color: white;text-align: center;font-size: 30px"></p>
								</div>
								<div
									style="padding-top:50px; width:100%;height:30%;background-color:#7F2726;">
									<br />
									<p style="color:white;text-align:center;font-size:25px;">预测下一次高峰期为</p>
									<p id="forecast"
										style="color: white;text-align: center;font-size: 30px"></p>
								</div>

							</div>

							<div
								style="padding-top:20px;padding-left:100px;float:left; width:50%;height: 100%;margin-right: 1px">
								<h3 style="color:white;padding-left:80px;">游客印象关键词</h3>
								<div id="impression" style="margin-left: 10px;width:250px;height:150px "></div>
							</div>
							<div style="float:left;width:23%;height:100%;">
								<br />
								<div
									style="width: 100%;height:50%;text-align:center;padding-top:80px">
									<p style="color:rgb(255,255,255)">旺季占比图</p>
									<div>
										<div id="wangji" style="width:300px;height:200px"></div>
									</div>
								</div>
								<div style="width: 100%;height:50%;text-align:center;">
									<p style="color:rgb(255,255,255)">淡季占比图</p>
									<div>
										<div id="danji" style="width:300px;height:200px"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="slider_div">
					<div style="width: 100%;height: 100%;background-color: #121c35">
						<p
							style="color: white;text-align: center;font-size: 28px; font-weight: bold;line-height: 46px;height: 46px;margin: 0;padding: 0;">2018-2019各月参观人数占比柱状图</p>
						<div
							style="height:100%;width:100%; background-image:url(bg.jpg);background-repeat:no-repeat;background-size:100% 100%;">
							<div class="container" style="width:100%">
								<div style="width:33.3%;float:left;margin-top: 150px;">
									<p style="color:rgb(255,255,255);padding-left: 200px;">17年各月参观人数占比</p>
									<div id="sthree" style="width:520px;height:350px"></div>
								</div>
								<div style="width:33.3%;float:left;margin-top: 150px;">
									<p style="color:rgb(255,255,255);padding-left: 180px;">18年各月参观人数占比</p>
									<div id="sone" style="width:520px;height:350px"></div>
								</div>
								<div style="width:33.3%;float:left;margin-top: 150px;">
									<p style="color:rgb(255,255,255);padding-left: 160px;">19年各月参观人数占比</p>
									<div id="stwo" style="width:520px;height:350px"></div>
								</div>
							</div>
						</div>
					</div>
				</div>


				<div class="slider_div">
					<div style="width: 100%;height: 100%;background-color: #121c35">
						<p
							style="color: white;text-align: center;font-size: 28px; font-weight: bold;line-height: 46px;height: 46px;margin: 0;padding: 0;">故宫2020游客流量变化</p>
						<!--  <div style="height:100%;width:100%; background-color:#222b30">-->
						<div
							style="height:100%;width:100%; background-image:url(bg.jpg);background-repeat:no-repeat;background-size:100% 100%;">
							<div class="container">
								<div>
									<div>
										<div id="gugong2020"
											style="margin-top:85px;height:550px;width:1100px;"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="slider_div">
					<div style="width: 100%;height: 100%;background-color: #121c35">
						<p
							style="color: white;text-align: center;font-size: 28px; font-weight: bold;line-height: 46px;height: 46px;margin: 0;padding: 0;">
							游客评价</p>
						<div
							style="height:100%;width:100%; background-image:url(bg.jpg);background-repeat:no-repeat;background-size:100% 100%;">
							<!--  <div style="width:85%;margin:10px auto;">-->
							<div style="width: 50%;height: 100%;float: left;">
								<div
									style="margin-left:80px;margin-top:130px; width: 300px;height: 300px;float: left;">
									<h3 style="color:white;padding-left:30px;margin-bottom:30px;">差评词云</h3>
									<div id="badwordcloud"
										style="height:300px;   margin-left: 70px;"></div>
								</div>
								<div
									style="margin-left:50px;margin-top:130px; width: 300px;height: 300px;float: left;">
									<h3 style="color:white;margin-bottom:30px;">好评词云</h3>
									<div id="goodwordcloud"
										style="height:300px;    margin-left: 40px;
									"></div>
								</div>
							</div>
							<div style="width: 50%;height: 100%;float: left;">
								<div class="corporation">
									<div id="meituan" style="width:300px;height:200px;"></div>
								</div>
								<div class="corporation">
									<div id="qunaer" style="width:300px;height:200px;"></div>
								</div>
								<div class="corporation">
									<div id="xiecheng" style="width:300px;height:200px;"></div>
								</div>
								<div class="corporation">
									<div id="tongcheng" style="width:300px;height:200px;"></div>
								</div>
								<div class="corporation">
									<div id="tuniu" style="width:300px;height:200px;"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<img src="./images/left.png" width="64" height="64" id="prev"> <img
			src="./images/right.png" width="64" height="64" id="next">

	</div>

	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="static/js/jquery-2.2.1.min.js"></script>
	<!-- 弹层插件 -->
	<script src="js/layer/layer.js"></script>

	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="static/js/bootstrap.min.js"></script>
	<!-- echarts -->
	<!--  	<script type="text/javascript"src="js/jquery-2.2.1.min.js"></script>-->
	<script src="js/echarts.js"></script>

	<script type="text/javascript" src="js/jqcloud-1.0.4.js"></script>
	<!-- 词云 -->

	<script type="text/javascript">
	
		require.config({
			paths : {
				'echarts' : 'js'
			}
		});
	
		var curIndex = 0, //当前index
			imgLen = $(".imgList .slider_div").length; //图片总数
		// 定时器自动变换2.5秒每次
		var autoChange = setInterval(function() {
			if (curIndex < imgLen - 1) {
				curIndex++;
			} else {
				curIndex = 0;
			}
		//调用变换处理函数
		/* changeTo(curIndex);  */
		}, 6000);
		//左箭头滑入滑出事件处理
		$("#prev").hover(function() {
			//滑入清除定时器
			clearInterval(autoChange);
		}, function() {
			//滑出则重置定时器
			//autoChangeAgain();
		});
		//左箭头点击处理
		$("#prev").click(function() {
			//根据curIndex进行上一个图片处理
			curIndex = (curIndex > 0) ? (--curIndex) : (imgLen - 1);
			changeTo(curIndex);
		});
		//右箭头滑入滑出事件处理
		$("#next").hover(function() {
			//滑入清除定时器
			clearInterval(autoChange);
		}, function() {
			//滑出则重置定时器
			/* autoChangeAgain(); */
		});
		//右箭头点击处理
		$("#next").click(function() {
			curIndex = (curIndex < imgLen - 1) ? (++curIndex) : 0;
			changeTo(curIndex);
		});
		//对右下角按钮index进行事件绑定处理等
		$(".indexList").find("li").each(function(item) {
			$(this).hover(function() {
				clearInterval(autoChange);
				changeTo(item);
				curIndex = item;
			}, function() {
				/* autoChangeAgain(); */
			});
		});
		//清除定时器时候的重置定时器--封装
		/*  function autoChangeAgain(){ 
		     autoChange = setInterval(function(){ 
		      if(curIndex < imgLen-1){ 
		        curIndex ++;
		      }else{ 
		        curIndex = 0;
		      }
		   	//调用变换处理函数
		     	changeTo(curIndex);
		     	},5000);
		 } */
		function changeTo(num) {
			var goLeft = num;
			$(".imgList").animate({
				left : "-" + goLeft * 100 + "%"
			}, 500);
			$(".indexList").find("li").removeClass("indexOn").eq(num).addClass(
				"indexOn");
		}
	</script>
	<script type="text/javascript"
		src="http://api.map.baidu.com/api?v=2.0&ak=whWrhHB8Q2orXafl4B9sb1fwuBsaqV8Q">
	//v2.0版本的引用方式：src="http://api.map.baidu.com/api?v=2.0&ak=您的密钥"
	//v1.4版本及以前版本的引用方式：src="http://api.map.baidu.com/api?v=1.4&key=您的密钥&callback=initialize"
	</script>
	<script type="text/javascript" src="js/jslib/first.js"></script>
	<script type="text/javascript" src="js/jslib/second.js"></script>
	<script type="text/javascript" src="js/jslib/three.js"></script>
	<script type="text/javascript" src="js/jslib/four.js"></script>
</body>
</html>
