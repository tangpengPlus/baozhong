package com.bz.framework.error.exception;

import com.bz.framework.constant.exception.BzExceptionEnum.UserExceptionEnum;

/**
 * 
 * 作者:唐鹏
 * 描述:用户板块异常封装
 * 创建时间:2017年9月29日上午11:18:23
 */
public class UserException extends BzBaseException{

	private static final long serialVersionUID = 1L;

	public UserException() {
		// TODO Auto-generated constructor stub
	}

	public UserException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public UserException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public UserException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @param userExceptionEnum {@link UserExceptionEnum}
	* @param message 异常描述
	*/ 
	public UserException(UserExceptionEnum userExceptionEnum,String message){
		super(userExceptionEnum, message);
	}
}
