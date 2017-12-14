package com.bz.framework.util.pattern;

import com.bz.framework.error.exception.BzBaseException;

/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年10月31日下午4:04:13
 * 描述:观察者接口
 * 备注:
 * @param <T>
 */
public interface BzObserver<T> {

	/**
	 * 观察者处理信息
	 * @param data {@link T}
	 * @return {@link T}
	 * @throws BzBaseException
	 */
	public T handle(T data)throws BzBaseException;
	
	/**
	 * 是否处理
	 * @param data {@link T}
	 * @return 继续处理返回true;不处理返回false
	 */
	public boolean isHandle(T data);
}
