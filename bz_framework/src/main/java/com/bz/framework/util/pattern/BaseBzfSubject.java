package com.bz.framework.util.pattern;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bz.framework.error.exception.BzBaseException;

/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年10月31日下午4:00:29
 * 描述:被观察者基类
 * 备注:
 */
public class BaseBzfSubject<T> implements BzfSubject<T>{

	protected List<BzObserver<T>> observerList;
	protected static Logger logger=LoggerFactory.getLogger(BaseBzfSubject.class);
	@Override
	public void setObserverList(List<BzObserver<T>> observerList) {
		this.observerList=observerList;
		
	}

	@Override
	public List<BzObserver<T>> getObserverList() {
		// TODO Auto-generated method stub
		return observerList;
	}

	@Override
	public T execute( final T data) throws BzBaseException {
		T result=null;
		if(null!=observerList){
			for(BzObserver<T> observer:observerList){
				if(observer.isHandle(data)){
					result=observer.handle(data);
				}
			}
		}
		return result;
	}
	
}
