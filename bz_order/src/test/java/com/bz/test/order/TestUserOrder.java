package com.bz.test.order;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bz.dao.pojo.order.OrderBase;
import com.bz.open.core.service.order.UserOrderService;
import com.bz.open.core.vo.response.order.UserOrderResponseVo;
/**
 * 
 * 
 * 作者: 彭云山
 * 描述:用户订单查询
 * 创建时间:2017年11月3日下午7:02:28
 * 修改备注:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserOrder {

	private final Logger logger = LoggerFactory.getLogger(TestUserOrder.class);
	@Autowired
	private UserOrderService userOrderService;
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月3日下午7:02:01
	 * 描述:用户订单查询测试
	 */
	@Test
	public void userOrderTest() {
		logger.info("查看订单");
		List<UserOrderResponseVo> list= new ArrayList<UserOrderResponseVo>();
		list=userOrderService.selectUserOrderByOrderStatus(123,null);
		logger.info(list.toString());
	}
}
