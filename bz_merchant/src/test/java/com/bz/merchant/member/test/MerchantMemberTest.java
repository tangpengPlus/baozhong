package com.bz.merchant.member.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.bz.open.core.service.merchant.MerchantBaseService;
import com.bz.open.core.service.merchant.MerchantMemberService;

/**
 * 
 * 作者: 兰俊
 * 描述: 测试商铺会员相关服务
 * 创建时间:2017年11月9日下午1:54:52
 * 修改备注:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MerchantMemberTest {

	private final Logger logger = LoggerFactory.getLogger(MerchantMemberTest.class);
	@Autowired
	private MerchantMemberService merchantMemberService;
	
	@Autowired
	private MerchantBaseService baseService;
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 测试判断该用户是否是当前商铺的新会员
	 * 创建时间:2017年11月9日上午11:46:35
	 */
//	@Test
	public void isNewMemberTest() {
		logger.info("开始测试该用户是否是当前店铺的新会员");
		logger.info("测试的 结果是:"+merchantMemberService.isNewMember(123, 1));
	}
	
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 测试增加商铺新会员记录
	 * 创建时间:2017年11月9日下午1:48:15
	 */
	//@Test
	public void addMerchantMemberTest() {
		logger.info("开始测试增加店铺新会员记录");
		if(merchantMemberService.isNewMember(223, 1)) {
			logger.info("该用户是新用户");
			merchantMemberService.addMerchantMember(223, 1);
		}else {
			logger.info("该用户是老用户");
		}
	}
	
	/**
	* @作者 胡竞
	* @Title: selectMerchantTest 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@Test
	public void selectMerchantTest() {
		logger.info("查询到商家:"+baseService.getMerchantInfoById(321));
	}
	
}
