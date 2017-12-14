<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
    <script type="text/javascript">
    wx.config({
        debug: false, 
        appId: '${wxshare.appId}',
        timestamp:${wxshare.timestamp},
        nonceStr:'${wxshare.nonceStr}', 
        signature:'${wxshare.signature}',
        jsApiList: ['onMenuShareTimeline','onMenuShareAppMessage','onMenuShareQQ','onMenuShareWeibo','onMenuShareQZone','chooseImage','previewImage','uploadImage','downloadImage','getLocation'] 
    });
    
    wx.ready(function(){
        wx.onMenuShareTimeline({
            title: '${wxshare.title}',
            link: '${wxshare.link}', 
            imgUrl: '${wxshare.imgUrl}', 
            success: function () { 
            },
            cancel: function () { 
            }
        });
        wx.onMenuShareAppMessage({
        	title: '${wxshare.title}',
            desc: '${wxshare.desc}', 
            link: '${wxshare.link}', 
            imgUrl: '${wxshare.imgUrl}', 
            type: '', 
            dataUrl: '', 
            success: function () { 
            },
            cancel: function () { 
            }
        });
        wx.onMenuShareQQ({
        	 title: '${wxshare.title}',
        	 desc: '${wxshare.desc}',
             link: '${wxshare.link}', 
             imgUrl: '${wxshare.imgUrl}', 
            success: function () { 
            },
            cancel: function () { 
            }
        });
        wx.onMenuShareWeibo({
        	 title: '${wxshare.title}',
        	 desc: '${wxshare.desc}', 
             link: '${wxshare.link}', 
             imgUrl: '${wxshare.imgUrl}', 
            success: function () { 
            },
            cancel: function () { 
            }
        });
        wx.onMenuShareQZone({
        	 title: '${wxshare.title}', 
        	 desc: '${wxshare.desc}', 
             link: '${wxshare.link}',
             imgUrl: '${wxshare.imgUrl}', 
            success: function () { 
            },
            cancel: function () { 
            }
        });
        
    });
    </script>