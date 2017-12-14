package com.bz.thirdparty.mail;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bz.open.core.service.mail.MailService;
import com.bz.open.core.vo.request.mail.MailRequestVo;


/**
 * 
 * 作者: 兰俊
 * 描述: 发送邮件测试类
 * 版本: version 1.0.0
 * 创建时间:2017年10月26日上午9:42:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {

	private final Logger logger = LoggerFactory.getLogger(MailTest.class);
	
	@Autowired
	private MailService mailService;
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 测试发送邮件方法
	 * 创建时间:2017年10月26日下午3:27:58
	 * 备注: 邮件发送人的邮箱需要设置客户端授权码（即开启POP3/IMAP/SMTP服务）
	 */
	@Test
	public void testSendEmail() {
		logger.info("进入发送邮件测试");
		//设置邮件信息
		MailRequestVo mailvo = new MailRequestVo();
		mailvo.setTheRecipients("916021232@qq.com");
		mailvo.setTilte("ll");
		mailvo.setMailType(3);
		mailvo.setCount("aaaa");
		mailvo.setFile(new File("C:\\Users\\Administrator\\Desktop\\7K{ROGRFJ6V]V0Q828MX7[6.jpg"));
		logger.info("邮件发送"+mailService.sendEmail(mailvo));
	}
	
}
