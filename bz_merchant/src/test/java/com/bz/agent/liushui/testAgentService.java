package com.bz.agent.liushui;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bz.open.core.service.merchant.MerchantBaseService;
import com.bz.open.core.service.merchant.MerchantDealFlowService;
import com.bz.open.core.service.user.UserBaseService;
import com.bz.open.core.vo.response.agent.StoreInfoResponseVo;
import com.bz.open.core.vo.response.agentShop.AgentShopResponseVo;
import com.bz.open.core.vo.response.user.UserBaseResponseVo;
@RunWith(SpringRunner.class)
@SpringBootTest
public class testAgentService {
	@Autowired
	private MerchantDealFlowService merchantDealFlowService;
	@Reference(version="1.0.0")
	private UserBaseService userBaseService;
	@Test
	public void test() {
		List<StoreInfoResponseVo> list = merchantDealFlowService.getAllDealOfShop(1, 1, 1);
	System.out.println(list.size());
	}
	@Test
	public void test1() {
		UserBaseResponseVo userBaseInfo = userBaseService.getUserBaseInfo(4);
		System.out.println(userBaseInfo.getName());
	}
}
