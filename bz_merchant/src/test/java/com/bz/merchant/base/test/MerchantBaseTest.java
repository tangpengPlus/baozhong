package com.bz.merchant.base.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.bz.framework.error.exception.MerchantException;
import com.bz.open.core.service.merchant.MerchantBaseService;
import com.bz.open.core.vo.response.agentShop.AgentShopResponseVo;
import com.bz.open.core.vo.response.merchant.MerchantServerStatusResponseVo;
import com.bz.open.core.vo.response.merchant.MerchantShopResponseVo;

/**
 * 
 * 作者: 兰俊
 * 描述:
 * 创建时间:2017年11月24日上午9:51:17
 * 修改备注:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MerchantBaseTest {

	
	private static final Logger logger = LoggerFactory.getLogger(MerchantBaseTest.class);
	@Autowired
	private MerchantBaseService merchantBaseService;
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 测试根据地区编码、店铺名称查询店铺信息
	 * 创建时间:2017年11月24日上午9:54:34
	 * @param agentAddress 地区编码
	 * @return 店铺信息集合
	 */
	@Test
	public void getMerchantInfoByAreaTest() {
		logger.info("开始测试根据地区编码、店铺名称查询店铺信息");
		String address = "重庆市,";
		String shopName = "某";
		List<MerchantShopResponseVo> shopes = merchantBaseService.getMerchantInfoByArea(address, shopName);
		logger.info("获得的数据:"+shopes);
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 测试根据商家id查询商家开启的功能信息
	 * 创建时间:2017年11月21日下午5:08:24
	 * @param merchantId
	 * @return
	 * @throws MerchantException
	 */
	@Test
	public void getMerchantServerStatusByIdTest() {
		logger.info("开始测试根据商家id查询商家开启的功能信息");
		MerchantServerStatusResponseVo status = merchantBaseService.getMerchantServerStatusById(1236);
		logger.info("获得的数据:"+status);
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 测试根据用户的openid获取该用户的店铺信息
	 * 创建时间:2017年11月23日下午10:20:00
	 * @param openId
	 * @return
	 */
	@Test
	public void getMerchantShopInfoTest() {
		logger.info("开始测试根据用户的openid获取用户的店铺信息");
		List<AgentShopResponseVo> agent = merchantBaseService.getMerchantShopInfo("oeE270liPdEX6XHltvDeZAQLQvEI");
		logger.info("获得的数据:"+agent);
	}
}
