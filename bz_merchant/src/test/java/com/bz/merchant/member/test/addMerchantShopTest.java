package com.bz.merchant.member.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.bz.open.core.service.merchant.MerchantShopRegistService;
import com.bz.open.core.vo.request.merchant.MerchantShopRequestVo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class addMerchantShopTest {
	
	private final Logger logger =LoggerFactory.getLogger(addMerchantShopTest.class);
	
	@Autowired
	private MerchantShopRegistService merchantShopRegistService;
	
	/**
	* @作者 胡竞
	* @Title: testAddMerchantShop 
	* @Description: TODO(新增商铺服务接口测试) 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@Test
	public void testAddMerchantShop() {
		logger.info("进入新增商铺服务接口测试");
		MerchantShopRequestVo shop=new MerchantShopRequestVo();
		shop.setNumber("852");
		shop.setName("是是是");
		merchantShopRegistService.addMerchantShop(shop);
	}
	
	
	
}
