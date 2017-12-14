package com.bz.userbase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bz.dao.pojo.user.UserBase;
import com.bz.open.core.service.user.UserBaseService;

import me.chanjar.weixin.mp.bean.result.WxMpUser;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserBaseInfoTest {
@Autowired
private UserBaseService userBaseService;

	private final Logger logger=LoggerFactory.getLogger(UserBaseInfoTest.class);

	//@Test
    public void getUserInfoById() {
		logger.info("查询到的user为"+userBaseService.getUserByOpenId("123456789").getName());
	}
	
	@Test
	public void getuserInfoByWxUser() {
		WxMpUser mpUser=new WxMpUser();
		mpUser.setNickname("熊大");
		mpUser.setHeadImgUrl("www.baidu.com");
		mpUser.setOpenId("xxxxxxxxxxxxxxxxxx");
		logger.info("查询到的用户"+userBaseService.getUserByWeiXinUser(mpUser));
		
	}
}
