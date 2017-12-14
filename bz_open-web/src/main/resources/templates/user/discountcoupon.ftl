[#assign base = request.contextPath /]
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>我的优惠券</title>
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,shrink-to-fit=no">
<meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
<meta name="author" content="pkuny520,pkuny520@163.com" />
<meta name="copyright" content="Baozho Inc. All Rights Reserved" />
<meta name="description" content="宝众商城，我的优惠券">
<meta name="keywords" content="宝众商城我的优惠券">
<script type="text/javascript" src="${base}/js/common/reset.js"></script>
<link rel="stylesheet" href="${base}/css/order/my-discount-coupon.debug.css" />
    [#include "/base/wxconfig.ftl"/]
    [#include "/base/alert_message.ftl"/]
</head>
<body>
	<div class="content">
		<div class="btn" id="btn-box">
			<span class="drop active">未使用</span> 
			<span class="drop">已使用</span> 
			<span class="drop">已过期</span>
		</div>
		
		<div class="item unused active">
			[#list redpacketList as red ] [#if red.isuse==0]
			<div class="message clear">
				<div class="left">
					<div class="wrap">
						<i>￥</i><em>${red.rpmoney}</em>
					</div>
					<span>满${red.fulfilMoney}元可用</span>
				</div>
				<div class="right">
					<h2 class="title">${red.merchantName}</h2>
					<p class="number">${red.ordernumber}</p>
					<div class="box">
						<span class="time">[#if red.createtime??]${red.createtime?date}[/#if]~[#if red.endtime??]${red.endtime?date}[/#if ]</span> <a href="javascript:;">立即使用</a>
					</div>
				</div>
			</div>
			[/#if][/#list]
		</div>
		 
		<!-- 已经使用的优惠券 -->
		<div class="item used">
			[#list redpacketList as red ][#if red.isuse==1]
			<div class="message clear">
				<div class="left">
					<div class="wrap">
						<i>￥</i><em>${red.rpmoney}</em>
					</div>
					<span>满${red.fulfilMoney}元可用</span>
				</div>
				<div class="right">
					<h2 class="title">${red.merchantName}</h2>
					<p class="number">${red.ordernumber}</p>
					<div class="box">
						<span class="time">[#if red.createtime??]${red.createtime?date}[/#if]~[#if red.endtime??]${red.endtime?date}[/#if ]</span> <a href="javascript:;">已使用</a>
					</div>
				</div>
			</div>
			[/#if][/#list]
		</div>
		 
		<!-- 过期优惠券 -->
		<div class="item due">
			[#list redpacketList as red ][#if red.isuse==2]
			<div class="message clear">
				<div class="left">
					<div class="wrap">
						<i>￥</i><em>${red.rpmoney}</em>
					</div>
					<span>满${red.fulfilMoney}元可用</span>
				</div>
				<div class="right">
					<h2 class="title">${red.merchantName}</h2>
					<p class="number">${red.ordernumber}</p>
					<div class="box">
						<span class="time">[#if red.createtime??]${red.createtime?date}[/#if]~[#if red.endtime??]${red.endtime?date}[/#if ]</span> <a href="javascript:;">已过期</a>
					</div>
				</div>
			</div>
			[/#if] [/#list]
		</div>
		
	</div>

	<div id="return_top" class="return-top">
		<a href="javascript:;"> <img src="${base}/img/top.png">
		</a>
	</div>

	<script src="${base}/js/common/jquery.js"></script>
	<script src="${base}/js/scan_order/my-discount-coupon.debug.js"></script>
</body>
</html>