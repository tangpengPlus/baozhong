package com.bz.user.message.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bz.open.core.service.message.UserMessageService;
import com.bz.open.core.service.user.RedCouponService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMessageTest {

	private final Logger logger=LoggerFactory.getLogger(UserMessageTest.class);
	
	@Autowired
	private UserMessageService userMessageService;
	@Autowired
	private RedCouponService red;
	
	@Test
	public void messageTest() {
		logger.info("收到的数据"+userMessageService.selectUserMessage(123, 0));
		//logger.info("+++++++++++++++++++++++++++++++++"+red.isCanUseCurryRedpacket(123, 1));
	}
}
