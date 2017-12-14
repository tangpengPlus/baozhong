package com.bz.thirdparty.message;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.bz.framework.constant.message.MessageEnum;
import com.bz.open.core.service.weixin.WeixinTemplateMessageService;
import com.bz.open.core.vo.request.weixin.WeixinTemplageMessageValue;
import com.bz.open.core.vo.request.weixin.WeixinTemplateMessageRequest;
import com.bz.thirdparty.mail.MailTest;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpTemplateMsgService;
import me.chanjar.weixin.mp.api.impl.WxMpTemplateMsgServiceImpl;

/**
 * 
 * 作者: 兰俊
 * 描述: 发送微信模板消息测试类
 * 版本: version 1.0.0
 * 创建时间:2017年10月26日上午11:23:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WeixinTemplateMessageTest {

	private final Logger logger = LoggerFactory.getLogger(MailTest.class);
	
	@Autowired
	private WeixinTemplateMessageService weixinTemplateMessageService;
	@Autowired
	private WxMpService wxMpService;
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 测试发送模板消息是否成功
	 * 创建时间:2017年10月27日下午5:19:10
	 * @throws WxErrorException
	 */
	@Test
	public void testSendWeixinTemplateMessage() throws WxErrorException {
		logger.info("---进入发送模板消息测试---");
		WxMpTemplateMsgService m = new WxMpTemplateMsgServiceImpl(wxMpService);
		System.out.println("获取模板消息id："+m.getAllPrivateTemplate());
		//设置模板消息
		WeixinTemplateMessageRequest wxt = new WeixinTemplateMessageRequest();
		wxt.setMessageEnum(MessageEnum.WeixinTemplateMessageEnum.WEIXIN_TEMPLATE_MESSAGE_PAYMENT);
//		wxt.setMessageEnum(MessageEnum.WeixinTemplateMessageEnum.WEIXIN_TEMPLATE_MESSAGE_COLLECTION);
		wxt.setOpenId("oeE270r_qvSOKULmBHs1l4LqChT0");	
		WeixinTemplageMessageValue value = new WeixinTemplageMessageValue();
//		value.setFirst("您好，您收到一笔款项！");
		value.setFirst("您好，您已付款成功");
		value.setKeyword1("宝众商城");
		value.setKeyword2("24");
//		value.setKeyword3("25");
		value.setKeyword3("2.00");
		value.setKeyword4("2017-10-27 10:51");
		value.setKeyword5("201710271051");
//		value.setRemark("祝您生活愉快！！");
		value.setRemark("欢迎下次光临！！");
		wxt.setValue(value);
		logger.info("模板消息："+wxt);
		logger.info("发送模板消息："+weixinTemplateMessageService.sendWeixinTemplateMessage(wxt));
	}
}