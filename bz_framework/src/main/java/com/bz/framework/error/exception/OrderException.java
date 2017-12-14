package com.bz.framework.error.exception;

import com.bz.framework.constant.exception.BzExceptionEnum.OrderExceptionEnum;

/**
 * 
 * 作者:唐鹏
 * 描述:订单板块异常封装
 * 创建时间:2017年9月29日上午11:51:27
 */
public class OrderException extends BzBaseException{

	private static final long serialVersionUID = 1L;

	public OrderException() {
		// TODO Auto-generated constructor stub
	}

	public OrderException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public OrderException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public OrderException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @param orderExceptionEnum {@link OrderExceptionEnum}
	* @param message 异常描述
	*/ 
	public OrderException(OrderExceptionEnum orderExceptionEnum,String message){
		super(orderExceptionEnum, message);
	}
}
