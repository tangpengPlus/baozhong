[#assign base = request.contextPath /]
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>我的订单</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,shrink-to-fit=no">
    <meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
    <meta name="author" content="pkuny520,pkuny520@163.com"/>
    <meta name="copyright" content="Baozho Inc. All Rights Reserved"/>
    <meta name="description" content="宝众商城，我的订单">
    <meta name="keywords" content="宝众商城我的订单">
    <script type="text/javascript" src="${base}/js/common/reset.js"></script>
    <link rel="stylesheet" href="${base}/css/order/my-order.debug.css" />
    [#include "/base/wxconfig.ftl"/]
    [#include "/base/alert_message.ftl"/]
</head>
<body>
<div class="content">
    <div class="btn clear" id="btn-box">
        <span class="drop active">待付款</span>
        <span class="drop">已付款</span>
        <span class="drop">付款失败</span>
    </div>
    [#if userorderList?? ]
	[#list userorderList as order]
		[#if order.paystate==1001||order.paystate==1002]
			<!-- 未付款 -->
    		<div class="item active">
        		<div class="message">
            		<div class="status">
                		<div class="box clear">
                    		<span class="fl">
                    		[#if order.ordertype==1]
                    			扫码订单
                    		[/#if]
                    		[#if order.ordertype==2]
                    			网上下单
                    		[/#if]
                    		</span>
                    		<span class="fr yellow">等待付款</span>
               		 	</div>
            		</div>
            		<div class="details clear">
                		<img src="${base}/img/pic-sfasdfasd.png" alt="" />
                		<h4>${order.merchantName}</h4>
                		<p>￥${order.tatolmoney}</p>
            		</div>
            		<div class="time-box">
                		<div class="box">
                    		<span class="fl month">[#if order.createtime??]${order.createtime?datetime}[/#if]</span>
                    		<a href="javascript:;" class="fr payment">立即支付</a>
                		</div>
            		</div>
        		</div>
        	</div>
		[/#if]
		[#if order.paystate==1004]
			<div class="item">
        		<div class="message">
           		 	<div class="status">
                	<div class="box clear">
                    	<span class="fl">
                    		[#if order.ordertype==1]
                    			扫码订单
                    		[/#if]
                    		[#if order.ordertype==2]
                    			网上下单
                    		[/#if]
                    		</span>
                    		<span class="fr yellow">付款成功</span>
                		</div>
            		</div>
            		<div class="details clear">
                		<img src="${base}/img/pic-sfasdfasd.png" alt="" />
                		<h4>${order.merchantName}</h4>
                		<p>￥${order.tatolmoney}</p>
            		</div>
            		<div class="time-box">
                		<div class="box">
                    		<span class="fl month">[#if order.createtime??]${order.createtime?datetime}[/#if]</span>
                		</div>
            		</div>
        		</div>
    		</div>
		[/#if]
		[#if order.paystate==1003||order.paystate==1005]
			 <div class="item defeated">
        		<div class="message">
            		<div class="status">
                		<div class="box clear">
                    		<span class="fl">
                    			[#if order.ordertype==1]
                    				扫码订单
                    			[/#if]
                    			[#if order.ordertype==2]
                    				网上下单
                    			[/#if]
                    		</span>
                    		<span class="fr yellow">付款失败</span>
                		</div>
            		</div>
            		<div class="details clear">
                		<img src="${base}/img/pic-sfasdfasd.png" alt="" />
                		<h4>${order.merchantName}</h4>
                		<p>￥${order.tatolmoney}</p>
            		</div>
            		<div class="time-box">
                		<div class="box">
                    		<span class="fl month">[#if order.createtime??]${order.createtime?datetime}[/#if]</span>
                    		<a href="${base}/user/orderDetails?orderId=${order.id}" class="fr payment">查看详情</a>
                		</div>
            		</div>
        		</div>
    		</div>
		[/#if]
	[/#list]
	[/#if]
</div>
<div id="return_top" class="return-top">
    <a href="javascript:;">
        <img src="${base}/img/top.png">
    </a>
</div>

<script src="${base}/js/common/jquery.js"></script>
<script src="${base}/js/scan_order/my-order.debug.js"></script>
</body>
</html>