package com.bz.framework.error.exception;

import com.bz.framework.constant.exception.BzExceptionEnum.PayExceptionEnum;

/**
 * 
 * 作者:唐鹏
 * 描述:支付板块异常
 * 创建时间:2017年9月29日上午11:52:26
 */
public class PayException extends BzBaseException{

	private static final long serialVersionUID = 1L;

	public PayException() {
		// TODO Auto-generated constructor stub
	}

	public PayException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public PayException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public PayException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @param payExceptionEnum {@link PayExceptionEnum}
	* @param message 异常描述
	*/ 
	public PayException(PayExceptionEnum payExceptionEnum,String message){
		super(payExceptionEnum, message);
	}
}
