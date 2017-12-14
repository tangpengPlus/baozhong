package com.bz.manage.web.configuration.exception;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * 
 * 作者:唐鹏
 * 描述: 异常
 * 版本: version 1.0.0
 * 时间: 2017年8月3日 下午1:48:42
 */   
@Component
public class SystemErrorPagesConfiguration {

	
	public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
	
	  return  new EmbeddedServletContainerCustomizer() {
		
		@Override
		public void customize(ConfigurableEmbeddedServletContainer arg0) {
			arg0.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/system/error/404"));
			arg0.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST,"/system/error/400"));
			arg0.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/system/error/500"));
			arg0.addErrorPages(new ErrorPage(java.lang.Throwable.class,"/system/error/500"));
		}
	};
	
	}
	
}
