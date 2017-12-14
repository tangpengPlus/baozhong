package com.bz.user.coupon.test;

import java.math.BigDecimal;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bz.dao.pojo.user.UserRedpacketUserecord;
import com.bz.dao.pojo.user.UserRedpacketWarehouse;
import com.bz.open.core.service.user.RedCouponService;
import com.bz.open.core.vo.request.user.UserRedpacketUserecordRequestVo;
import com.bz.open.core.vo.request.user.UserRedpacketWareHouseRequestVo;
import com.bz.open.core.vo.response.user.UserRedpacketUserecordResponseVo;

/**
 * 
 * 作者: 兰俊
 * 描述: 测试用户红包服务
 * 创建时间:2017年11月8日上午10:31:23
 * 修改备注:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedCouponTest {

	private final Logger logger = LoggerFactory.getLogger(RedCouponTest.class);
	@Autowired
	private RedCouponService redCouponService;
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 测试查询用户所有红包劵
	 * 创建时间:2017年11月6日下午3:25:47
	 */
//	@Test
	public void selectUserRedpacketWarehouseTest() {
		logger.info("开始测试查询用户所有红包劵");
		logger.info("获得的数据:"+redCouponService.selectUserRedpacketWarehouse(123));
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 测试查询用户所有红包使用记录
	 * 创建时间:2017年11月6日下午3:26:27
	 */
//	@Test
	public void selectUserRedpacketRserecordTest() {
		logger.info("开始测试查询用户所有红包劵使用记录");
		logger.info("获得的数据:"+redCouponService.selectUserRedpacketUserecord(123));
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 测试添加用户领取红包劵
	 * 创建时间:2017年11月6日下午3:26:56
	 */
	@Test
	public void addUserRedpacketTest() {
		logger.info("开始测试添加用户领取红包劵");
		UserRedpacketWareHouseRequestVo ur = new UserRedpacketWareHouseRequestVo();
		ur.setCreatetime(new Date());
		ur.setEndtime(new Date());
		ur.setMerchantid(321);
		ur.setIsuse(1);
		ur.setOrdernumber("234");
		ur.setRpid(1234);
		ur.setRpmoney(BigDecimal.valueOf(10L));
		ur.setUserid(5);
		redCouponService.addUserRedpacket(ur);
		
		
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 测试添加用户红包劵使用记录
	 * 创建时间:2017年11月6日下午3:27:34
	 */
//	@Test
	public void adduseRedpacketTest() {
		logger.info("开始测试添加用户红包劵使用记录");
		UserRedpacketUserecordRequestVo ur = new UserRedpacketUserecordRequestVo();
		ur.setId(2);;
		ur.setOrderno("123");;
		ur.setUserid(123);
		ur.setRpid(1234);
		ur.setUsemoney(BigDecimal.valueOf(10L));
		ur.setUserid(123);
		ur.setUsetime(new Date());
		redCouponService.adduseRedpacket(ur);
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 测试判断当前用户当前红包券是否能使用
	 * 创建时间:2017年11月6日下午3:28:14
	 */
//	@Test
	public void isCanUseCurryRedpacketTest() {
		logger.info("开始测试判断当前用户当前红包劵是否能使用");
		logger.info("当前红包能否使用:"+redCouponService.isCanUseCurryRedpacket(123, 1234));
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 测试查询用户所有有效的红包劵
	 * 创建时间:2017年11月6日下午4:05:20
	 */
//	@Test
	public void selectEffectiveUserRedpacketWarehouseTest() {
		logger.info("开始测试查询用户所有有效的红包劵");
		logger.info("获得的数据:"+redCouponService.selectEffectiveUserRedpacketWarehouse(123));
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 测试根据条件查询用户红包劵信息
	 * 创建时间:2017年11月6日下午4:08:47
	 */
//	@Test
	public void selectUserUserRedpacketWarehouseByConditionTest() {
		logger.info("开始测试根据条件查询用户红包劵信息");
		UserRedpacketWareHouseRequestVo ur = new UserRedpacketWareHouseRequestVo();
//		ur.setOrdernumber("123");
		ur.setId(1);
		logger.info("获得的数据:"+redCouponService.selectUserUserRedpacketWarehouseByCondition(ur));
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述:	测试锁定用户红包劵（即消费红包劵）
	 * 创建时间:2017年11月6日下午4:17:26
	 */
//	@Test
	public void lockUserCouponTest() {
		logger.info("开始测试锁定红包用户劵");
		logger.info("是否锁定:"+redCouponService.lockUserCoupon(1234));
	}
}
