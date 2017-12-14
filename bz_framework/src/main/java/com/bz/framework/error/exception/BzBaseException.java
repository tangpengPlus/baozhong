package com.bz.framework.error.exception;

import com.bz.framework.constant.base.BaseEnum;
/**
 * 
 * 作者:唐鹏
 * 描述:异常父类 封装异常基础信息及设置异常基础信息
 * 创建时间:2017年9月29日上午10:56:48
 */
public abstract class BzBaseException extends RuntimeException {
	private static final long serialVersionUID = -4452302797597641927L;
	private BaseEnum<Integer> bzBaseExceptionEnum;
	public BzBaseException() {
		// TODO Auto-generated constructor stub
	}

	public BzBaseException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public BzBaseException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public BzBaseException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 通过枚举基类来构造
	 * @param bzExceptionEnum 枚举基类{@link BaseEnum<Integer>}
	 * @param message 异常描述
	 */
	public BzBaseException(BaseEnum<Integer> bzExceptionEnum,String message){
		super(message);
		this.bzBaseExceptionEnum=bzExceptionEnum;
	}
	/**
	 * 获取{@link BaseEnum<Integer>}错误枚举类型
	 * @return {@link BaseEnum<Integer>}
	 */
	public BaseEnum<Integer> getHpfExceptionEnum(){
		return this.bzBaseExceptionEnum;
	}
	@Override
	public String getMessage() {
//		if(this.hpfExceptionEnum!=null){
//			return super.getMessage()+this.hpfExceptionEnum;
//		}else{
//			return super.getMessage();
//		}
		return super.getMessage();
	}
}