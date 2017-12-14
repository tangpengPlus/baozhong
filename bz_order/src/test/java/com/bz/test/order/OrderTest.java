package com.bz.test.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bz.framework.util.date.DateUtil;
import com.bz.framework.util.number.BzCodeGenerate;
import com.bz.open.core.service.order.ScanOrderCreateService;
import com.bz.open.core.vo.order.BaseOrderVo;
import com.bz.open.core.vo.request.order.ScanCodeOrderRequestVo;
/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年10月26日${time}
 * 描述:order项目服务
 * 备注:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTest {

	private final Logger logger=LoggerFactory.getLogger(OrderTest.class);
	
	@Autowired
	private ScanOrderCreateService orderService;
	/**
	 * 
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年10月26日${time}
	 * 描述:订单编号创建
	 * 备注:
	 */
	@Test
	public void createOrderNumber() {
		/**
		 * 订单生成规则
		 * 订单前缀:BZS+时间戳前七位+商户id(四位)+时间戳后两位+用户Id(四位)+时间戳最后两位
		 * BZS15089910244879510  20171026152032
		 * BZS15089910244879570
		 * BZS2017108564923452079354281984
		 */
		for(int i=0;i<100;i++) { 
			String time=DateUtil.getCurryTimeStr();
			logger.info("生成的订单编号是:BZS"+time.substring(0, 6)+"8564"+BzCodeGenerate.getSysNumber());
		}
	}
	
	@Test
	public void createOrder() {
		BaseOrderVo vo=new ScanCodeOrderRequestVo();
		//orderService.createOrder(vo);
	}
}
