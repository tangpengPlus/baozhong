[#assign base = request.contextPath /]
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
    <title>消息详情</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,shrink-to-fit=no">
    <meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
    <meta name="author" content="pkuny520,pkuny520@163.com"/>
    <meta name="copyright" content="Baozho Inc. All Rights Reserved"/>
    <meta name="description" content="宝众商城，消息详情">
    <meta name="keywords" content="宝众商城消息详情">
    <script type="text/javascript" src="${base}/js/common/reset.js"></script>
    <link rel="stylesheet" href="${base}/css/order/message-details.debug.css" />
	[#include "/base/wxconfig.ftl"/]
    [#include "/base/alert_message.ftl"/]
</head>
<body>
[#if message??]
	<div class="content">
    	<div class="message">	
        	<div class="item border clear">
            	<span class="fl title">${message.merchantName}</span>
            	<span class="fr"><i>[#if message.createtime??]${message.createtime?string('dd.MM.yyyy HH:mm:ss')}[/#if]</i></span>
        	</div>
        	<div class="item border clear">
            	<p>${message.title}</p>
            	<p>${message.content}</p>
        	</div>
        	<div class="item clear">
            	<a href="javascript:;" class="fr payment">查看详情&nbsp;&gt;&gt;</a>
        	</div>
    	</div>
	</div>
[/#if]
<div id="return_top" class="return-top">
    <a href="javascript:;">
        <img src="${base}/img/top.png">
    </a>
</div>

<script src="${base}/js/common/jquery.js"></script>
<script src="${base}/js/scan_order/my-message.debug.js"></script>
</body>
</html>