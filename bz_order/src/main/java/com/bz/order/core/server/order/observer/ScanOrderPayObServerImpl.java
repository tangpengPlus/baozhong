package com.bz.order.core.server.order.observer;

import org.springframework.stereotype.Service;

import com.bz.framework.error.exception.BzBaseException;
import com.bz.framework.util.pattern.BzObserver;
import com.bz.open.core.vo.request.order.ScanCodeOrderRequestVo;
/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年11月6日下午4:18:12
 * 描述:订单创建支付服务实现
 * 备注:
 */
@Service
public class ScanOrderPayObServerImpl implements BzObserver<ScanCodeOrderRequestVo>{

	@Override
	public ScanCodeOrderRequestVo handle(ScanCodeOrderRequestVo data) throws BzBaseException {
		
		return null;
	}

	@Override
	public boolean isHandle(ScanCodeOrderRequestVo data) {
		
		return false;
	}

}
