package com.bz.framework.error.exception;

import com.bz.framework.constant.exception.BzExceptionEnum.MerchantExceptionEnum;

/**
 * 
 * 作者:唐鹏
 * 描述:商户模块异常信息封装
 * 创建时间:2017年9月29日上午11:47:57
 */
public class MerchantException extends BzBaseException{

	private static final long serialVersionUID = 1L;

	public MerchantException() {
		// TODO Auto-generated constructor stub
	}

	public MerchantException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public MerchantException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public MerchantException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @param merchantException {@link MerchantExceptionEnum}
	* @param message 异常描述
	*/ 
	public MerchantException(MerchantExceptionEnum merchantException,String message){
		super(merchantException, message);
	}
}
