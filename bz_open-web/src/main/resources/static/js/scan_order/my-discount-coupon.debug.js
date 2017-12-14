/**
 * Created by Administrator on 2017/11/8.
 */
;(function($){
    var myCoupon = {
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
    myCoupon.init();
})(jQuery);

