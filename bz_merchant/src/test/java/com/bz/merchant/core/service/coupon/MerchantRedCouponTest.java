package com.bz.merchant.core.service.coupon;

import java.math.BigDecimal;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.bz.open.core.service.merchant.MerchantRedCouponService;
import com.bz.open.core.vo.request.merchant.MerchantRedpacketGrantRecordRequest;
import com.bz.open.core.vo.request.merchant.MerchantRedpacketSettingRequest;
import com.bz.open.core.vo.request.merchant.MerchantRedpacketUseRecordRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MerchantRedCouponTest {
	
	private final Logger logger = LoggerFactory.getLogger(MerchantRedCouponTest.class);
	@Autowired
	private MerchantRedCouponService merchantRedCouponService;

	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 测试验证验证用户付款金额合法性
	 * 创建时间:2017年11月7日下午3:59:55
	 */
//	@Test
	public void checkRedCouponAmountTest() {
		logger.info("开始测试验证用户付款的合法性");
		logger.info("判断的结果是:"+merchantRedCouponService.checkRedCouponAmount(BigDecimal.valueOf(20.6d), BigDecimal.valueOf(1.65d), 123, 123));
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 测试根据条件查询红包劵设置信息
	 * 创建时间:2017年11月7日下午2:02:45
	 */
	@Test
	public void getMerchantRedpacketSettingByConditionTest() {
		logger.info("开始测试根据条件查询红包劵设置信息");
		MerchantRedpacketSettingRequest redpacketSetting = new MerchantRedpacketSettingRequest();
		redpacketSetting.setId(1236);	
//		redpacketSetting.setRpno("1234");
//		redpacketSetting.setIsdelete(0);
//		redpacketSetting.setIsstart(0);
//		redpacketSetting.setMerchantid(1234);
//		redpacketSetting.setTermofvalidity(10);
		logger.info("获得的红包劵设置信息:"+merchantRedCouponService.getMerchantRedpacketSettingByCondition(redpacketSetting));
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述:	测试添加或更新红包劵设置信息
	 * 创建时间:2017年11月7日下午2:18:52
	 */
//	@Test
	public void addMerchantRedpacketTest() {
		logger.info("开始测试添加或更新红包劵设置信息");
		MerchantRedpacketSettingRequest redpacketSetting = new MerchantRedpacketSettingRequest();
		redpacketSetting.setRpno("11234");
		redpacketSetting.setIsdelete(0);
		redpacketSetting.setIsstart(0);
		redpacketSetting.setMerchantid(12345);
		redpacketSetting.setId(6);
		redpacketSetting.setTermofvalidity(15);
		merchantRedCouponService.addMerchantRedpacket(redpacketSetting);
	}
	
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 测试红包发放记录
	 * 创建时间:2017年11月7日下午3:50:35
	 */
//	@Test
	public void addGrantRecordTest() {
		logger.info("------开始测试-----");
		MerchantRedpacketGrantRecordRequest mr = new MerchantRedpacketGrantRecordRequest();
		mr.setUserid(123);
		mr.setOrderno("123");
		mr.setCreatetime(new Date());
		mr.setRpid(123);
		mr.setShopid(123);
		merchantRedCouponService.addGrantRecord(mr);
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 测试添加红包使用记录
	 * 创建时间:2017年11月7日下午3:49:55
	 */
//	@Test
	public void addUseRecordTest() {
		MerchantRedpacketUseRecordRequest mr = new MerchantRedpacketUseRecordRequest();
		mr.setOrderno("123");
		mr.setRpid(123);
		mr.setShopid(123);
		mr.setUsemoney(10L);
		mr.setUserid(123);
		mr.setUsetime(new Date());
		logger.info("添加使用记录详情:"+merchantRedCouponService.addUseRecord(mr));
	}
	
}
