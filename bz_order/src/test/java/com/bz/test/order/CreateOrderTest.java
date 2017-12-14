package com.bz.test.order;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bz.framework.constant.order.OrderEnum.PayWay;
import com.bz.open.core.service.order.ScanOrderCreateService;
import com.bz.open.core.vo.request.order.ScanCodeOrderRequestVo;
import com.bz.order.core.server.order.base.ScanOrderCreateServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateOrderTest {

	private final Logger logger=LoggerFactory.getLogger(CreateOrderTest.class);
	
	@Autowired
	private ScanOrderCreateService scanOrderCreateService;
	
	@Test
	public void createOrderTest() {
		ScanCodeOrderRequestVo orderVo=new ScanCodeOrderRequestVo();
		orderVo.setUserId(1234);
		orderVo.setMerchantId(123);
		orderVo.setRequestTimeStr("1234567891011");
		orderVo.setPayWay(PayWay.WCHAT_PAY);
		orderVo.setPayMoney(new BigDecimal("10.00"));
		orderVo.setTotalMoney(new BigDecimal("160.00"));
		orderVo.setUseCashCoupon(true);
		orderVo.setCashCoupon(12345);
		orderVo.setCashCouponMoney(new BigDecimal("10.00"));
		orderVo.setQrCodeLink("http://www.baidu.com");
		orderVo.setRequestIp("http://www.baidu.com");
		orderVo.setOrderNumber("10086");
		scanOrderCreateService.createOrder(orderVo);
		
		
		
		
	}
}
