[#assign base = request.contextPath /]
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
    <title>消息中心</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,shrink-to-fit=no">
    <meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
    <meta name="author" content="pkuny520,pkuny520@163.com"/>
    <meta name="copyright" content="Baozho Inc. All Rights Reserved"/>
    <meta name="description" content="宝众商城，消息中心">
    <meta name="keywords" content="宝众商城消息中心">
    <script type="text/javascript" src="${base}/js/common/reset.js"></script>
    <link rel="stylesheet" href="${base}/css/order/my-message.debug.css" />
    [#include "/base/wxconfig.ftl"/]
    [#include "/base/alert_message.ftl"/]
</head>
<body>
<div class="content">
    <div class="btn clear" id="btn-box">
        <span class="drop active">未读消息</span>
        <span class="drop">私人消息</span>
        <span class="drop">系统消息</span>
    </div>
	[#if message??]
		[#list message as me]
		<div class="item active">
        	<div class="message">
            	<div class="box clear">
                	<a class="pic" href="javascript:;"><img src="${base}/img/pic-sfasdfasd.png" alt="" /></a>
                	<div class="msg-box">
                    	<div class="top clear">
                        	<span class="title"><a href="javascript:;">${me.merchantName}</a></span>
                        	<span class="time">[#if me.createtime??]${me.createtime?datetime}[/#if]</span>
                    	</div>
                    	<a class="bottom" href="${base}/usermessage/messageDetails?messageId=${me.id}">${me.title}</a>
                	</div>
            	</div>
        	</div>
    	</div>
			[#if me.isprivately=0]
				<div class="item">
        			<div class="message">
            		<div class="box clear">
                		<a class="pic" href="javascript:;"><img src="${base}/img/pic-sfasdfasd.png" alt="" /></a>
                		<div class="msg-box">
                    		<div class="top clear">
                        		<span class="title"><a href="javascript:;">${me.merchantName}</a></span>
                        		<span class="time">[#if me.createtime??]${me.createtime?datetime}[/#if]</span>
                    		</div>
                    		<a class="bottom" href="${base}/usermessage/messageDetails?messageId=${me.id}">${me.title}</a>
                		</div>
            		</div>
        			</div>
    			</div>
			[/#if]
			[#if me.isprivately=1]
				    <div class="item">
        				<div class="message">
            				<div class="box clear">
                				<a class="pic" href="javascript:;"><img src="${base}/img/pic-sfasdfasd.png" alt="" /></a>
                				<div class="msg-box">
                    				<div class="top clear">
                        				<span class="title"><a href="javascript:;">${me.merchantName}</a></span>
                        				<span class="time">[#if me.createtime??]${me.createtime?datetime}[/#if]</span>
                    				</div>
                    				<a class="bottom" href="${base}/usermessage/messageDetails?messageId=${me.id}">${me.title}</a>
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
<script src="${base}/js/scan_order/my-message.debug.js"></script>
</body>
</html>