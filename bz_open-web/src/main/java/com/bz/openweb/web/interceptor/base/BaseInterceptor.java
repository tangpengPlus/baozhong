package com.bz.openweb.web.interceptor.base;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bz.framework.util.security.TokenUtil;
/**
 * 
 * 作者:唐鹏
 * 创建时间:2017年10月13日下午12:25:21
 * 描述:基础拦截器
 * 备注:1:生成每次请求token
 */
public class BaseInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		arg0.getSession().removeAttribute("token");
		String token = TokenUtil.getInstance().makeToken();//创建令牌
		arg0.getSession().setAttribute("token", token);
		
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		boolean isAjax = false;
		if(arg0.getHeader("x-requested-with")==null) {
			isAjax=true;
		}
		String token=(String) arg0.getAttribute("token");
		if(StringUtils.isNotEmpty(token)) {
			
		}else {
			if(isAjax) {
				arg1.getWriter().write("违法请求");
				return false;
			}else {
				
			}
		}
		return false;
	}

}
