[#assign base = request.contextPath /]
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>个人中心</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,shrink-to-fit=no">
    <meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
    <meta name="author" content="pkuny520,pkuny520@163.com"/>
    <meta name="copyright" content="Baozho Inc. All Rights Reserved"/>
    <meta name="keywords" content="宝众商城，个人中心">
    <meta name="description" content="宝众商城个人中心">
    <script type="text/javascript" src="${base}/common/reset.js"></script>
    <link type="text/css" rel="stylesheet" href="${base}/css/order/personal-center.debug.css" />
    [#include "/base/wxconfig.ftl"/]
    [#include "/base/alert_message.ftl"/]
</head>
<body>
<div class="head">
    <div class="top-bar">
        <a class="setting" href="javascript:;"></a>
    </div>
    <div class="head-portrait">
        <a class="head-portrait-box" href="javascript:;">
            <img src="${user.wechatimage}" alt="" />
        </a>
    </div>
    <div class="nickname">
        <span>${user.name}</span>
    </div>
    <div class="message">
        <div class="bg"></div>
        <a href="${base}/user/message?id=${user.id}">
            <em></em>
            <span>我的消息</span>
        </a>
    </div>
</div>

<div class="content">
    <ul class="clear">
        <li>
            <a href="${base}/user/redpacket?id=${user.id}">
                <img src="${base}/img/pic-my-hongbao.png" alt="" />
                <span class="title">我的红包</span>
            </a>
        </li>
        <li>
            <a href="${base}/user/order?id=${user.id}">
                <img src="${base}/img/pic-my-order.png" alt="" />
                <span class="title">我的订单</span>
            </a>
        </li>
        <li>
            <a href="javascript:;">
                <img src="${base}/img/pic-my-zhangdan.png" alt="" />
                <span class="title">我的账单</span>
            </a>
        </li>
        <li>
            <a href="javascript:;">
                <img src="${base}/img/pic-my-zuji.png" alt="" />
                <span class="title">我的足迹</span>
            </a>
        </li>
        <li>
            <a href="javascript:;">
                <img src="${base}/img/pic-my-shoucang.png" alt="" />
                <span class="title">我的收藏</span>
            </a>
        </li>
        <li>
            <a href="${base}/merchant/registCode?id=${user.id}">
                <img src="${base}/img/pic-apply-store.png" alt="" />
                <span class="title">申请开店</span>
            </a>
        </li>
    </ul>
</div>

<script src="${base}/common/jquery.js"></script>
<script src="${base}/js/personal_center/personal-center.debug.js"></script>
</body>
</html>