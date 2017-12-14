package com.bz.openweb.config.ini;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.bz.openweb.web.interceptor.base.BaseInterceptor;
import com.bz.openweb.web.interceptor.wxshare.WxShareInterceptor;

/**
 * 
 * 作者:唐鹏
 * 描述: Spring Mvc 基础配置
 * 版本: version 1.0.0
 * 时间: 2017年8月29日 下午2:31:00
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter{
	private static final Log log=LogFactory.getLog(MyWebAppConfigurer.class);
		
	  @Bean
	  public BaseInterceptor baseInterceptor() {
	    return new BaseInterceptor();
	  }
	
	  @Bean
	  public WxShareInterceptor getWxShareInterceptor() {
		  return new WxShareInterceptor();
	  }
	  
		/**
		 * 拦截器配置
		 */
	 	@Override
	    public void addInterceptors(InterceptorRegistry registry) {
	 		log.info(">>>>>>>>>>>>>>>>>>>>>>>初始化系统拦截器<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	        //基础处理拦截器
//	        registry.addInterceptor(baseInterceptor())
//	        .addPathPatterns("/**");
	 		registry.addInterceptor(getWxShareInterceptor())
	 		.addPathPatterns("/**")
	 		.excludePathPatterns("/css/**")
	 		.excludePathPatterns("/img/**")
	 		.excludePathPatterns("/merchant/sendvildCode")
	 		.excludePathPatterns("/merchant/registCode")
	 		.excludePathPatterns("/js/**")
	 		.excludePathPatterns("/user/centerCode");
	    }
}
