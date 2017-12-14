package com.bz.order.core.vo.base;

import com.bz.framework.pojo.base.BasePojo;
/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年10月31日下午4:46:08
 * 描述: 订单调用基础信息封装
 * 备注:
 */
public abstract class BaseCreateOrderMq extends BasePojo {

	private static final long serialVersionUID = 1L;

	private String orderNumber;//订单编号
	
	private String requestIp;//请求创建订单Ip
	
	private String orderType;//订单类型
	
	
}
