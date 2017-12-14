package com.bz.framework.error.exception;

import com.bz.framework.constant.exception.BzExceptionEnum.ExternalExceptionEnum;

/**
 * 
 * 作者:唐鹏
 * 描述:外接服务板块异常
 * 创建时间:2017年9月29日上午11:56:53
 */
public class ExternalException extends BzBaseException{

	private static final long serialVersionUID = 6576835240378913550L;
	public ExternalException() {
		// TODO Auto-generated constructor stub
	}

	public ExternalException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public ExternalException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public ExternalException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @param externalExceptionEnum {@link ExternalExceptionEnum}
	* @param message 异常描述
	*/ 
	public ExternalException(ExternalExceptionEnum externalExceptionEnum,String message){
		super(externalExceptionEnum, message);
	}
}
