package com.bz.order.core.server.order.observer;

import org.springframework.stereotype.Service;

import com.bz.framework.error.exception.BzBaseException;
import com.bz.framework.util.pattern.BzObserver;
import com.bz.open.core.vo.request.order.ScanCodeOrderRequestVo;
/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年11月3日上午11:40:07
 * 描述:扫码订单创建器
 * 备注:
 */
@Service
public class ScanOrderCreateObServerImpl implements BzObserver<ScanCodeOrderRequestVo> {

	public ScanOrderCreateObServerImpl() {
   
	} 
	
	@Override
	public ScanCodeOrderRequestVo handle(ScanCodeOrderRequestVo data) throws BzBaseException {
		
		return null;
	}

	@Override
	public boolean isHandle(ScanCodeOrderRequestVo data) {
		
		return false;
	}

}
