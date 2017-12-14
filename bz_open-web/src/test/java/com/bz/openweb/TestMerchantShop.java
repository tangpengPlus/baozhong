package com.bz.openweb;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bz.framework.pojo.base.BaseResult;
import com.bz.openweb.core.model.agent.AgentRegionResponse;
import com.bz.openweb.core.model.merchant.MerchantRegistRequest;
import com.bz.openweb.core.service.merchant.MerchantRegistService;

/**
 * 
 * 
 * 作者: 彭云山
 * 描述:商铺测试类
 * 创建时间:2017年11月13日下午3:38:39
 * 修改备注:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMerchantShop {

	@Reference(version="1.0.0")
	private MerchantRegistService merchantRegist;
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月13日下午3:39:07
	 * 描述:添加商铺测试类
	 */
	@Test
	public void testMerchantRegistService() {
		MerchantRegistRequest merchantRegistRequest = new MerchantRegistRequest();
		merchantRegistRequest.setOpenId("oRkX0t0sbR1tTU_KWFwqJlhPk-9k");
		merchantRegistRequest.setNickname("张三");
		merchantRegistRequest.setHeadImgUrl("");
		merchantRegistRequest.setNumber("bz001");
		merchantRegistRequest.setName("测试店铺名称");
		merchantRegistRequest.setLicenseimage("gdasgdsdg");
		merchantRegistRequest.setProvincelevecode("重庆市");
		merchantRegistRequest.setCitylevecode("涪陵区");
		merchantRegistRequest.setRegionlevecode("百胜镇");
		merchantRegistRequest.setDetailaddress("c重庆市涪陵区百胜镇");
		merchantRegistRequest.setCoordinate("112.3445,35.8485");
		merchantRegistRequest.setPhone("72162967");
		merchantRegistRequest.setShopdetailimage("fasfa");
		merchantRegistRequest.setFrontidcardimg("dasfsa");
		merchantRegistRequest.setBelongmerchantid(1);
		merchantRegistRequest.setBackidcardimg("fafsafa");
		merchantRegistRequest.setBustimg("gaadgadg");
		merchantRegist.registMerchant(merchantRegistRequest);
	}
	
}
