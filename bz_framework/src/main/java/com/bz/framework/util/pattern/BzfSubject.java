package com.bz.framework.util.pattern;

import java.util.List;

import com.bz.framework.error.exception.BzBaseException;

/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年10月31日下午4:01:41
 * 描述:BZ被观察者
 * @param <T1> 观察者数据类型
 * @param <T2> 指定通知接收数据类型
 */
public interface BzfSubject <T>{

	/**
	 * 设置观察者数据
	 * 有序集合
	 * @param observer List<{@link BzObserver<{@link T}>} >
	 */
	public void setObserverList(List<BzObserver<T>> observerList);
	
	/**
	 * 获取观察者列表
	 * @return  List<{@link BzObserver<{@link T}>} >
	 */
	public List<BzObserver<T>> getObserverList();
	/**
	 * 执行通知
	 * @param data {@link T}
	 * @return {@link T}
	 * @throws BzBaseException
	 */
	public T execute(T data)throws BzBaseException;
}
