package com.bz.framework.error.exception;

import com.bz.framework.constant.exception.BzExceptionEnum.FileExceptionEnum;

/**
 * 
 * 作者:唐鹏
 * 描述:文件服务板块异常封装
 * 创建时间:2017年9月29日上午11:54:10
 */
public class FileException extends BzBaseException{

	private static final long serialVersionUID = 1L;

	public FileException() {
		// TODO Auto-generated constructor stub
	}

	public FileException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public FileException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public FileException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @param fileExceptionEnum {@link FileExceptionEnum}
	* @param message 异常描述
	*/ 
	public FileException(FileExceptionEnum fileExceptionEnum,String message){
		super(fileExceptionEnum, message);
	}
}
