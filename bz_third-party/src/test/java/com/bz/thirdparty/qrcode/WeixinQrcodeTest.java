package com.bz.thirdparty.qrcode;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.bz.open.core.service.weixin.WeixinMessageService;
import com.bz.open.core.vo.request.weixin.WeixinMassMessageRequest;
import com.bz.open.core.service.qrcode.WeixinQrcodeService;


/**
 * 
 * 作者: 兰俊
 * 描述:
 * 版本: version 1.0.0
 * 创建时间:2017年11月1日下午7:21:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WeixinQrcodeTest {
	private Logger logger = LoggerFactory.getLogger(WeixinQrcodeTest.class);
	
	@Autowired
	private WeixinQrcodeService weixinQrcodeService;
	
	@Autowired
	private WeixinMessageService wxMpService;
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 测试生成收款二维码的方法
	 * 创建时间:2017年11月3日下午3:47:58
	 */
	@Test
	public void createQrcade() {
		logger.info("进入生成收款二维码的测试");
		ByteArrayInputStream bis = weixinQrcodeService.createQrcade("{'shop_name':'合成羊绒糖果','contents':'http://www.baidu.com'}");
		WeixinMassMessageRequest message = new WeixinMassMessageRequest();
		List<String> list = new ArrayList<>();
		list.add("oRkX0t0sbR1tTU_KWFwqJlhPk-9k");
		list.add("");
		message.setWeixinUserOpenIds(list);
		message.setSendToOne(false);
		message.setFileType("jpg");
		wxMpService.sendImageMessage(message,bis);
	}
}