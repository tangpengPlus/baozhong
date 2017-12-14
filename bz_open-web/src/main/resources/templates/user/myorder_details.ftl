[#assign base = request.contextPath /]
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>支付详情</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,shrink-to-fit=no">
    <meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
    <meta name="author" content="pkuny520,pkuny520@163.com"/>
    <meta name="copyright" content="Baozho Inc. All Rights Reserved"/>
    <meta name="description" content="宝众商城，支付详情">
    <meta name="keywords" content="宝众商城支付详情">
    <script type="text/javascript" src="${base}/js/common/reset.js"></script>
    <link rel="stylesheet" href="${base}/css/order/payment-details.debug.css" />
	[#include "/base/wxconfig.ftl"/]
    [#include "/base/alert_message.ftl"/]
</head>
<body>
<div class="content">
    <div class="message">
        <h2 class="title border">支付详情</h2>
        <div class="item border clear">
            <p>收款方：${details.merchantName}</p>
            <p>支付方式：${details.payway}</p>
            <p>交易金额：￥${details.tatolmoney}</p>
        </div>
        <div class="item clear">
            <p>备注：${details.payremark}</p>
        </div>
    </div>
</div>

<div id="return_top" class="return-top">
    <a href="javascript:;">
        <img src="${base}/images/top.png">
    </a>
</div>

<script src="${base}/js/common/jquery.js"></script>
<script src="${base}/js/scan_order/payment-details.debug.js"></script>
</body>
</html>