(function e(t,n,r){function s(o,u){if(!n[o]){if(!t[o]){var a=typeof require=="function"&&require;if(!u&&a)return a(o,!0);if(i)return i(o,!0);var f=new Error("Cannot find module '"+o+"'");throw f.code="MODULE_NOT_FOUND",f}var l=n[o]={exports:{}};t[o][0].call(l.exports,function(e){var n=t[o][1][e];return s(n?n:e)},l,l.exports,e,t,n,r)}return n[o].exports}var i=typeof require=="function"&&require;for(var o=0;o<r.length;o++)s(r[o]);return s})({1:[function(require,module,exports){
/**
 * Created by Administrator on 2017/11/16.
 */
;(function($){
    var sotreApple = {
        init:function(){
            this.bindEvent();
        },
        bindEvent:function(){
            //电话号码验证
            var res = /^1[3|4|5|7|8|9]\d{9}$/;
            $("#message .mobile").blur(function(){
                if( !(res.test($(this).val())) ){
                    $(this).css("color","#d8292c");
                    $("#btn").attr('disabled',"true");//添加disabled属性
                    $("#btn_sub").attr('disabled',"true");//添加disabled属性
                    layer.open({
                        content: '请正确填写手机号码！',
                        skin: 'msg',
                        time: 2 //2秒后自动关闭
                    });
                    return false;
                }
            }).focus(function(){
                $(this).css("color","#000000");
                $("#btn").removeAttr('disabled',"true");//添加disabled属性
                $("#btn_sub").removeAttr('disabled',"true");//添加disabled属性
            });

            //倒计时
            var InterValObj; //timer变量，控制时间
            var count = 60; //间隔函数，1秒执行
            var curCount;//当前剩余秒数


            $("#btn").on("click",function(){
                curCount = count;
                //设置button效果，开始计时
                $("#btn").attr("disabled", "true");
                $("#btn").val(curCount + "秒");
                InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次

                //请求后台发送验证码 TODO
            });

            //timer处理函数
            function SetRemainTime() {
                if (curCount == 0) {
                    window.clearInterval(InterValObj);//停止计时器
                    $("#btn").removeAttr("disabled");//启用按钮
                    $("#btn").val("重新发送");
                }
                else {
                    curCount--;
                    $("#btn").val(curCount + "秒");
                }
            };

            if($("#message .mobile").val()==""){
                $("#btn").attr("disabled", "true");
            };


            //验证码
            $("#message .yanzheng").blur(function(){
                if( !(/^\d{4}$/.test($(this).val())) ){
                    layer.open({
                        content: '请正确填写验证码！',
                        skin: 'msg',
                        time: 2 //2秒后自动关闭
                    });
                    $("#btn_sub").attr('disabled',"true");//添加disabled属性
                }
            }).focus(function(){
                $("#btn_sub").removeAttr('disabled',"true");//添加disabled属性
            });

            //店铺名称
            $("#message .mingcheng").blur(function(){
                if( $(this).val()=="" ){
                    layer.open({
                        content: '请正确填写店铺名称！',
                        skin: 'msg',
                        time: 2 //2秒后自动关闭
                    });
                    $("#btn_sub").attr('disabled',"true");//添加disabled属性
                }
            }).focus(function(){
                $("#btn_sub").removeAttr('disabled',"true");//添加disabled属性
            });

            //店铺简介
            $("#message .jieshao").blur(function(){
                if( $(this).val()=="" ){
                    layer.open({
                        content: '请正确填写店铺简介！',
                        skin: 'msg',
                        time: 2 //2秒后自动关闭
                    });
                    $("#btn_sub").attr('disabled',"true");//添加disabled属性
                }
            }).focus(function(){
                $("#btn_sub").removeAttr('disabled',"true");//添加disabled属性
            });

            $("#message .add").click(function(){
                console.log(111111);
                $("#iframe").show();
            });

            //详细地址
            $("#message .address").blur(function(){
                if( $(this).val()=="" ){
                    $(this).css("color","#d8292c");
                    layer.open({
                        content: '请正确填写店铺详细地址！',
                        skin: 'msg',
                        time: 2 //2秒后自动关闭
                    });
                    $("#btn_sub").attr('disabled',"true");//添加disabled属性
                }
            }).focus(function(){
                $("#btn_sub").removeAttr('disabled',"true");//添加disabled属性
            });
            

            $("#btn_sub").click(function(){
                if($("#message .text").val()==""){
                    $(this).attr("disabled", "true");
                    layer.open({
                        content: '请填写信息！',
                        skin: 'msg',
                        time: 2 //2秒后自动关闭
                    });
                }else {
                    $(this).removeAttr("disabled", "true");
                }
            });

            $("#btn-box").on("click",".drop",function(){
                $(this).addClass("active").siblings(".drop").removeClass("active");
                $(this).parent().siblings(".item").eq($(this).index()).show().siblings(".item").hide();
            });
            
            if(!($("#Check").checked("checked"))){
            	layer.open({
                    content: '请阅读开店协议！',
                    skin: 'msg',
                    time: 2 //2秒后自动关闭
                });
            	$("#btn_sub").attr('disabled',"true");//添加disabled属性
            }else{
            	$("#btn_sub").removeAttr('disabled',"true");//添加disabled属性
            }

        }
    };
    sotreApple.init();
})(jQuery);
},{}]},{},[1]);
