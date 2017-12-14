[#assign base = request.contextPath /]
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
    <title>店铺申请</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=no,shrink-to-fit=no">
    <meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
    <meta name="author" content="pkuny520,pkuny520@163.com"/>
    <meta name="copyright" content="Baozho Inc. All Rights Reserved"/>
    <meta name="keywords" content="宝众商城，店铺，申请，设置">
    <meta name="description" content="宝众商城店铺申请设置">
     <link type="text/css" rel="stylesheet" href="${base}/css/store/store-apply.debug.css" />
    <script src="${base}/js/store/jquery.js"></script>
    <script type="text/javascript" src="${base}/js/store/reset.js"></script>
    [#include "/base/wxconfig.ftl"/]
    [#include "/base/alert_message.ftl"/]
   <script type="text/javascript">
   var shopLogoImage="";//门面logo
   var shopDetailImage="";//店铺实拍
   var frontidcardimg="";//身份证正面照
   var backidcardimg="";//身份证背面照
   var licenseImage="";//营业执照、
   
   var shopLogoImagePath="";//门面logo路径
   var shopdetailImagePath="";//店铺实拍路径
   var frontidcardImgPath="";//身份证正面照路径
   var backidcardImgPath="";//身份证背面照路径
   var licenseimagePath="";//营业执照路径
    //拍照或从手机相册中选图接口
    function choseImage(obj){
		wx.chooseImage({
		    count: 1, // 默认9
		    sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
		    sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
		    success: function (res) {
			   var localIds = res.localIds; // 返回选定照片的本地ID列表，localId可以作为img标签的src属性显示图片
			   var imageList=localIds.toString();
			   $(obj).attr("src",imageList);
			    wx.uploadImage({
    				localId: imageList, // 需要上传的图片的本地ID，由chooseImage接口获得
    				isShowProgressTips: 1, // 默认为1，显示进度提示
    				success: function (res) {
       			    var serverId = res.serverId; // 返回图片的服务器端ID
						assignment($(obj).attr("id"),serverId,imageList);
    				}
				});
			}
		});
	 }
	 //赋值给全局变量
	 function assignment(key,value,imagePath){
		 if(key.toString()=="shopLogoImage"){
		 	$("#shopLogoImageInput").val(value);
		 	$("#shopLogoImageInputs").val(imagePath);
		 }
		 if(key.toString()=="shopDetailImage"){
			 	$("#shopdetailimageInput").val(value);	
			 	$("#shopdetailimageInputs").val(imagePath);
	 	 }
		 if(key.toString()=="frontidcardimg"){
			 	 $("#frontidcardimgInput").val(value);
			 	 $("#frontidcardimgInputs").val(imagePath);
	 	 }
		 if(key.toString()=="backidcardimg"){
			 	$("#backidcardimgInput").val(value);
			 	$("#backidcardimgInputs").val(imagePath);
	 	 }
	 	 if(key.toString()=="licenseImage"){
		   	    $("#licenseimageInput").val(value);
		   	 	$("#licenseimageInputs").val(imagePath);
 	 	 }
	 }
    </script>
    
</head>
<body>
<div class="content" id="content">
    <form method="post">
        <div class="boxse active">
            <div class="banner clear" id="banner">
                <div class="store-logo items">
                	<p>上传您的店铺LOGO</p>
                	<div class="box">
                    [#if merchant.shopLogoImagePath ??&& merchant.shopLogoImagePath !=""]
                       <img id="shopLogoImage" class="pic" src="${merchant.shopLogoImagePath}" onclick="choseImage(this);" />
                    [#else]
                       <img id="shopLogoImage" class="pic" src="${base}/img/img-logo.png" onclick="choseImage(this);" />
                    [/#if]
                    </div>
                </div>
                <div class="store-name items">
                	<p>上传您的店铺门头</p>
                    <div class="box">
                    [#if merchant.shopdetailImagePath ??&& merchant.shopdetailImagePath!=""]
                        <img id="shopDetailImage" class="pic" src="${merchant.shopdetailImagePath}" onclick="choseImage(this);" />
                    [#else]
                   		<img id="shopDetailImage" class="pic" src="${base}/img/img-mentou.png" onclick="choseImage(this);" />
                    [/#if]
                    </div>
                </div>
            </div>

            <ul class="message">
            	<li>
                    <label>手机号码</label>
                    <input type="text" id="phone" value="${merchant.phone}" name="phone" class="text mobile" placeholder="请输入您的联系电话">
                    <input type="hidden" name="licenseimage" value="${merchant.licenseimage}" id="licenseimageInput"/>
                    <input type="hidden" name="shopLogoImage" value="${merchant.shopLogoImage}" id="shopLogoImageInput" />
                    <input type="hidden" name="shopdetailimage" value="${merchant.shopdetailimage}" id="shopdetailimageInput"/>
                    <input type="hidden" name="frontidcardimg" value="${merchant.frontidcardimg}" id="frontidcardimgInput"/>
                    <input type="hidden" name="backidcardimg" value="${merchant.backidcardimg}" id="backidcardimgInput"/>
                    
                </li>
                <li class="yanzheng">
                  	<label>验证码</label>
                  	<input class="text yanzheng" type="text" id="telCode" />
                  	<input type="hidden" id="sendSms" onclick="sendTelMessage()" />
                    <input type="button" id="btn" class="btn" value="获取验证码" />
                </li>
                <li>
                	<label>店铺名称</label>
                    <input type="text" name="name" value="${merchant.name}" class="text mingcheng" />
                </li>
                <li>
                  	<label>店铺介绍</label>
                    <input type="text" name="verifyRemark" value="${merchant.verifyRemark}" class="text jieshao" />
                </li>
                <li>
	                <label>所属行业</label>
	                <p class="add classify" id="streetLevel" name="streetLevel">${merchant.regionlevecode}</p>
            	</li>
                <li>
                <label>所在区域</label>
               		 <p class="add area">${merchant.regionlevecode}</p>
            	</li>
                <li>
                	<label>详细地址</label>
                    <input type="text" name="detailAddress" value="${merchant.detailAddress}" class="text address" />
                </li>
                
            </ul>

            <div class="btnn clear" id="btn-box">
                <span class="drop active"><a href="javascript:;">身份证注册</a></span>
                <span class="drop"><a href="javascript:;">营业执照注册</a></span>
            </div>

            <div class="identity-card item">
                <ul class="clear">
                    <li>
                    	<p>身份证正面</p>
                        <div class="box">
                        [#if merchant.frontidcardImgPath ?? && merchant.frontidcardImgPath!=""]
                      		<img class="pic" id="frontidcardimg" src="${merchant.frontidcardImgPath}" onclick="choseImage(this);" >      
                        [#else]
                       		<img class="pic" id="frontidcardimg" src="${base}/img/pic-01-zhengmian.png" onclick="choseImage(this);" >
                        [/#if]
                        </div>
                    </li>
                    <li>
                    	<p>身份证背面</p>
                        <div class="box">
                        [#if merchant.backidcardImgPath ?? && merchant.backidcardImgPath!=""]
                            <img id="backidcardimg"  class="pic" src="${merchant.backidcardImgPath}"  onclick="choseImage(this);">
                        [#else]
                        	<img id="backidcardimg"  class="pic" src="${base}/img/pic-02-fanmian.png"  onclick="choseImage(this);">
                        [/#if]
                        </div>
                    </li>
                </ul>
            </div>

            <div class="business-license item">
                <ul class="clear">
                    <li>
                    	<p>营业执照</p>
                        <div class="box">
                        [#if merchant.licenseimagePath ?? && merchant.licenseimagePath != ""]
                            <img id="licenseImage" class="pic" src="${merchant.licenseimagePath}"  onclick="choseImage(this);">
                        [#else]
                        	<img id="licenseImage" class="pic" src="${base}/img/pic-03-yingyezhizhao.png"  onclick="choseImage(this);">
                        [/#if]
                        </div>
                    </li>
                </ul>
            </div>

            <div class="agree">
	            <input type="checkbox" class="check" id="Check" checked="checked" name="agree" value="" />
	            <label for="Check">已阅并同意</label>
	            <a href="javascript:;" target="_blank" class="wold">《开店协议》</a>
        	</div>
               <div style="display:none">
	                <input type="hidden" name="openId" value="${wxUserInfo.openId}" />
	                <input type="hidden" name="nickName" value="${wxUserInfo.nickName}" />
	                <input type="hidden" name="headImgUrl" value="${wxUserInfo.headImgUrl}" />
	                <input type="hidden" name="licenseimagePath" value="merchant.licenseimagePath"  id="licenseimageInputs"/>
                    <input type="hidden" name="shopLogoImagePath" value="${merchant.shopLogoImagePath}" id="shopLogoImageInputs" />
                    <input type="hidden" name="shopdetailImagePath" value="${merchant.shopdetailImagePath}" id="shopdetailimageInputs"/>
                    <input type="hidden" name="frontidcardImgPath" value="${merchant.frontidcardImgPath}" id="frontidcardimgInputs"/>
                    <input type="hidden" name="backidcardImgPath" value="${merchant.backidcardImgPath}" id="backidcardimgInputs"/>
                    <input type="hidden" name="coordinate"  value="${merchant.coordinate}" id="coordinateInput"/>
                 <div id='container'>
                 </div>
               </div>
            </div>
           
            <div class="submit">
            <input type="submit" id="btn_sub" class="btn" value="提交" onclick="uploadimg()">
        	</div>
        
    </form>
</div>

<script src="${base}/js/store/area.js"></script>
<script src="${base}/common/layer/mobile/layer.js"></script>
<script src="${base}/js/store/store-apply.debug.js"></script>
<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.4.1&key=e4f43f4a1988073a3b764e4f3f2f9479"></script>
<script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
<!--高德定位-->
<script type="text/javascript">
 var map, geolocation;
    //加载地图，调用浏览器定位服务
    map = new AMap.Map('container', {
        resizeEnable: true
    });
    map.plugin('AMap.Geolocation', function() {
        geolocation = new AMap.Geolocation({
            enableHighAccuracy: true,//是否使用高精度定位，默认:true
            timeout: 10000,          //超过10秒后停止定位，默认：无穷大
            buttonOffset: new AMap.Pixel(10, 20),//定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
            zoomToAccuracy: true,      //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
            buttonPosition:'RB'
        });
        map.addControl(geolocation);
        geolocation.getCurrentPosition();
        AMap.event.addListener(geolocation, 'complete', onComplete);//返回定位信息
        AMap.event.addListener(geolocation, 'error', onError);      //返回定位出错信息
    });
    //解析定位结果
    function onComplete(data) {
        var lng=data.position.getLng();
        var lat=data.position.getLat();
        //赋值经纬度
        $("#coordinateInput").val(lng+","+lat);
    }
    //解析定位错误信息
    function onError(data) {
      alert("定位失败");
    }
</script>
<script type="text/javascript">
function getRegin(siteId){
	$("#streetLevel").val(siteId);
}
</script>

<script type="text/javascript">
function sendTelMessage(){
	var tel=$("#phone").val();
	if(tel==null){
		alert("请输入您的手机号码");
		return false;
	}
	$.ajax({
		   url:"${base}/merchant/sendvildCode",
		   data:{"telPhone":tel},
		   dataType:"json",
		   type:"post",
		   success: function(data){
			   if(date.false){
				   alert("请正确填写手机号码");
			   }
			   
		   }
	   });
}
</script>

			



</body>
</html>