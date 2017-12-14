package com.bz.pay.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bz.framework.constant.order.OrderEnum.OrderStateEnum;
import com.bz.open.core.service.pay.PayNotifyService;
import com.bz.open.core.vo.request.notify.PayNotifyRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PayNotifyTest {

	private final Logger logger=LoggerFactory.getLogger(PayNotifyTest.class);
	
	@Autowired
	private PayNotifyService payNotifyService;
	
	@Test
	public void payNotifyTest() {
		PayNotifyRequest pnr=new PayNotifyRequest();
		pnr.setOrderNumber("123");
		pnr.setPayCode("123456789");
		pnr.setPayMerchantId(123);
		pnr.setPayMessage("987654321");
		pnr.setOrderStateEnum(OrderStateEnum.ORDER_PAY_SUCCESS);
		pnr.setPayUserId(123);
		
		payNotifyService.payNotify(pnr);
		
	}
}
