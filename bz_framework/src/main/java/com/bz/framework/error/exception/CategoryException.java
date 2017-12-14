package com.bz.framework.error.exception;

import com.bz.framework.constant.exception.BzExceptionEnum.CategoryExceptionEnum;

/**
 * 
 * 作者: 彭云山
 * 描述:商品分类异常
 * 创建时间:2017年11月27日下午2:50:07
 * 修改备注:
 */
public class CategoryException extends BzBaseException{

	
	private static final long serialVersionUID = -5188235542670411594L;

	public CategoryException() {
		// TODO Auto-generated constructor stub
	}

	public CategoryException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public CategoryException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public CategoryException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @param CategoryExceptionEnum {@link CategoryExceptionEnum}
	* @param message 异常描述
	*/ 
	public CategoryException(CategoryExceptionEnum categoryExceptionEnum,String message){
		super(categoryExceptionEnum, message);
	}
}
