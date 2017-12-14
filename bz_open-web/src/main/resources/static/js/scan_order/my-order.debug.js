(function e(t,n,r){function s(o,u){if(!n[o]){if(!t[o]){var a=typeof require=="function"&&require;if(!u&&a)return a(o,!0);if(i)return i(o,!0);var f=new Error("Cannot find module '"+o+"'");throw f.code="MODULE_NOT_FOUND",f}var l=n[o]={exports:{}};t[o][0].call(l.exports,function(e){var n=t[o][1][e];return s(n?n:e)},l,l.exports,e,t,n,r)}return n[o].exports}var i=typeof require=="function"&&require;for(var o=0;o<r.length;o++)s(r[o]);return s})({1:[function(require,module,exports){
/**
 * Created by Administrator on 2017/11/7.
 */
;(function($){
    var myOrder = {
        init: function(){
            this.bindEvent();
        },
        bindEvent: function(){
            $(window).scroll(function() {
                //显示隐藏返回顶部按钮
                if($(window).scrollTop()>=500){
                    $("#return_top").show();
                }else{
                    $("#return_top").hide();
                }
            });
            //返回顶部
            $("#return_top").click(function(){
                $("body,html").animate({scrollTop:0},500)
            });

            $("#btn-box").on("click",".drop",function(){
                $(this).addClass("active").siblings(".drop").removeClass("active");
                $(this).parent().siblings(".item").eq($(this).index()).show().siblings(".item").hide();
            })
        }
    };
    myOrder.init();
})(jQuery);
},{}]},{},[1]);
