package com.bz.sms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bz.thirdparty.core.api.sms.SmsHttpApiService;
import com.bz.thirdparty.map.AdministrativeAreaTest;
import com.bz.thirdparty.model.sms.SmsAccountResult;
import com.bz.thirdparty.model.sms.SmsSendResult;
/**
 * 
 * 
 * 作者: 彭云山
 * 描述:调用短信接口测试类
 * 创建时间:2017年10月25日下午2:16:45
 * 修改备注:
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest
public class TestSmsHttpApiService {
	private final Logger logger=LoggerFactory.getLogger(TestSmsHttpApiService.class);
	@Autowired
	private SmsHttpApiService sms;
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月25日下午5:18:12
	 * 描述:测试短信平台是否欠费
	 */
	@Test
	public void testisArrears(){
		Object sale = sms.isArrears();
		logger.info("zheshi");
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月25日下午5:19:24
	 * 描述:测试获取当前短信平台账号信息
	 */
	@Test
	public void testGetCurrySmsAccountInfo() {
		SmsAccountResult smsResult = new SmsAccountResult();
		smsResult = sms.getCurrySmsAccountInfo();
		logger.info(smsResult.toString());
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月25日下午5:21:16
	 * 描述:验证码信息短信发送
	 */
	@Test
	public void testSendCaptchaSms() {
		SmsSendResult result=new SmsSendResult();
		result = sms.sendCaptchaSms("18723218726","【宝众科技】您的验证码是:336051，请在五分钟内输入。请勿告诉他人。");
		logger.info(result.toString());
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月25日下午5:22:20
	 * 描述:营销短信批量发送
	 */
	@Test
	public void testSendMarketingSms() {
		SmsSendResult results=new SmsSendResult();
		results = sms.sendMarketingSms("18580636634,18723218726", "【宝众科技】尊敬的超级VIP商户您好，感谢您注册宝众科技。退订回T。", "2017-10-25 17:55:00");
		logger.info(results.toString());
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月25日下午5:23:33
	 * 描述:发送通知短信
	 */
	@Test
	public void testSendtNoticeSms() {
		SmsSendResult resultmessage=new SmsSendResult();
		resultmessage = sms.sendtNoticeSms("18580636634","【宝众科技】尊敬的{变量1}商户您好，感谢您注册宝众科技。退订回T。\r\n" + 
				"");
		logger.info(resultmessage.toString());
	}
		
}
