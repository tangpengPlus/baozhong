package com.bz.openweb.web.interceptor.wxshare;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.bz.openweb.core.model.wxshare.WxShareResponse;
import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.mp.api.WxMpService;

/**
 * 
 * 
 * 作者: 彭云山
 * 描述: 微信分享功能统一拦截
 * 创建时间:2017年11月14日下午7:30:19
 * 修改备注:
 */
public class WxShareInterceptor implements HandlerInterceptor{
      
	/*微信工具服务*/
	@Autowired
	private WxMpService wxMpService;
	
	@Value("${wechat.share.title}")
	private String shareTile;//分享标题
	
	@Value("${wechat.share.link}")
	private String shareLink;//分享连接
	
	@Value("${wechat.share.imgUrl}")
	private String shareImgUrl;//分享图标地址
	
	@Value("${wechat.share.desc}")
	private String shareDesc;//分享描述
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		 
    	
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2, ModelAndView mv)
			throws Exception {
	   if(mv!=null) {
		 //获取跳转地址
			String   urls="";
			if(null==request.getQueryString()) {
				    urls= "http://" + request.getServerName() //服务器地址             //端口号  
			       + request.getContextPath()      //项目名称  
			       + request.getServletPath();      //请求页面或其他地址  
			}else {
				    urls= "http://" + request.getServerName() //服务器地址             //端口号  
			       + request.getContextPath()      //项目名称  
			       + request.getServletPath()      //请求页面或其他地址  
			       + "?" + (request.getQueryString()); //参数  
			}
	 	  WxJsapiSignature jsapiSignature=wxMpService.createJsapiSignature(urls);
	 	  WxShareResponse shareResponse =new WxShareResponse();
	 	  shareResponse.setAppId(jsapiSignature.getAppId());
	 	  shareResponse.setNonceStr(jsapiSignature.getNonceStr());
	 	  shareResponse.setTimestamp(jsapiSignature.getTimestamp());
	 	  shareResponse.setSignature(jsapiSignature.getSignature());
	 	  shareResponse.setDesc(shareDesc);
	 	  shareResponse.setImgUrl(shareImgUrl);
	 	  shareResponse.setLink(shareLink);
	 	  shareResponse.setTitle(shareTile);
	 	  mv.addObject("wxshare", shareResponse);
	   }
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		
		return true;
	}

}
