package com.bz.pay.test;
import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bz.framework.constant.pay.AliPayPaymentScenarioEnum;
import com.bz.framework.constant.pay.WeiXinPaymentScenarioEnum;
import com.bz.open.core.service.pay.AlipayService;
import com.bz.open.core.service.pay.WeiXinPayService;
import com.bz.open.core.vo.request.alipay.AliPayRequest;
import com.bz.open.core.vo.request.weixin.WeixinPayRequet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PayTest {

	@Autowired
	private WeiXinPayService weiXinPayService;
	@Autowired
	private AlipayService alipayService;
	
	private final Logger logger=LoggerFactory.getLogger(PayTest.class);
	
	/**
	* @作者 胡竞
	* @Title: wxPayTest 
	* @Description: TODO(微信支付测试) 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
//	@Test
	public void wxPayTest() {
		WeixinPayRequet weixinPayRequet=new WeixinPayRequet();
		weixinPayRequet.setOrderDescribe("1111");
		weixinPayRequet.setOrderNumber("123");
		weixinPayRequet.setPayMoney(new BigDecimal("10.00"));
		weixinPayRequet.setRequstIp("123");
		weixinPayRequet.setAttach("456");
		weixinPayRequet.setOrderDetail("测试微信支付");
		weixinPayRequet.setDeviceInfo("123");
		weixinPayRequet.setWeiXinPaymentScenarioEnum(WeiXinPaymentScenarioEnum.WEIXIN_NATIVE_PAY);
		
		logger.info("返回的数据为:"+weiXinPayService.wxPayUnifiedOrder(weixinPayRequet));
		
	}
	
	/**
	* @作者 胡竞
	* @Title: aliPayTest 
	* @Description: TODO(支付宝支付测试) 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
//	@Test
	public void aliPayTest() {
		AliPayRequest aliPayRequest=new AliPayRequest();
		aliPayRequest.setOrderNumber("123");
		aliPayRequest.setPayMoney(new BigDecimal("1.00"));
		aliPayRequest.setAliPayPaymentScenarioEnum(AliPayPaymentScenarioEnum.QUICK_WAP_PAY);
		aliPayRequest.setOrderTitle("测试支付宝支付");
		
		alipayService.AlipayMobilePhoneOrder(aliPayRequest);
	}
}
