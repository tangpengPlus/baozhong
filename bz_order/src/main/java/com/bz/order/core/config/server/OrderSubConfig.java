package com.bz.order.core.config.server;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bz.framework.util.pattern.BzObserver;
import com.bz.open.core.vo.request.order.ScanCodeOrderRequestVo;
import com.bz.order.core.server.order.observer.ScanOrderCreateObServerImpl;
import com.bz.order.core.server.order.observer.ScanOrderPayObServerImpl;
import com.bz.order.core.server.order.subject.ScanOrderCreateSubject;
/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年11月6日下午4:08:36
 * 描述:订单服务实现配置
 * 备注:
 */
@Configuration
public class OrderSubConfig {

	private final Logger logger=LoggerFactory.getLogger(OrderSubConfig.class);
	
	@Autowired
	private ScanOrderCreateObServerImpl scanOrderCreateObServerImpl;
	@Autowired
	private ScanOrderPayObServerImpl scanOrderPayObServerImpl;
	
	/**
	 * 
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年11月6日下午4:11:08
	 * 描述:扫码订单创建器
	 * 备注:
	 * @return
	 */
	@Bean
	public ScanOrderCreateSubject createScanOrderCreateSubject() {
		logger.info(">>>>>>>>>>>>>>>>>>初始化扫码订单创建器<<<<<<<<<<<<<<<<<<<<<<");
		ScanOrderCreateSubject createSubject=new ScanOrderCreateSubject();
		//设置扫码订单观察者
		List<BzObserver<ScanCodeOrderRequestVo>> observerList =new ArrayList<>();
		observerList.add(scanOrderCreateObServerImpl);
		observerList.add(scanOrderPayObServerImpl);
		createSubject.setObserverList(observerList);
		return createSubject;
	}
}
