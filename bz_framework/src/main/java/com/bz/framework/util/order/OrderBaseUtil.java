package com.bz.framework.util.order;
/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年11月6日上午11:55:42
 * 描述:订单基础工具
 * 备注:
 */

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bz.framework.error.exception.PayException;

public class OrderBaseUtil {

	public static final Logger logger=LoggerFactory.getLogger(OrderBaseUtil.class);
	
	/**
	 * 
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年11月6日上午11:57:05
	 * 描述:判断订单的合法性
	 * 备注:
	 * @return
	 * @throws Exception
	 */
	public static boolean isOrder(String orderNumber)throws PayException{
		logger.info("订单基础工具【判断订单的合法性】==》【orderNumber:"+orderNumber+"】");
		if(StringUtils.isEmpty(orderNumber)) {
			return false;
		}
		if(orderNumber.getBytes().length!=29) {
			return false;
		}
		return true;
	}
	
	
}
