package com.bz.order.core.server.order.base;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.bz.dao.mapper.order.OrderBaseMapper;
import com.bz.dao.pojo.order.OrderBase;
import com.bz.framework.constant.exception.BzExceptionEnum.OrderExceptionEnum;
import com.bz.framework.constant.order.OrderEnum;
import com.bz.framework.constant.order.OrderEnum.OrderStateEnum;
import com.bz.framework.error.exception.OrderException;
import com.bz.framework.util.exception.BzfAssert;
import com.bz.open.core.service.order.BaseOrderService;
/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年11月1日下午2:24:36
 * 描述:订单基础服务实现
 * 备注:
 */
@Service(version="1.0.0",interfaceClass=com.bz.open.core.service.order.BaseOrderService.class)
@Transactional
public class BaseOrderServiceImpl implements BaseOrderService{
       private final Logger logger=LoggerFactory.getLogger(BaseOrderServiceImpl.class);
	@Autowired
	private OrderBaseMapper orderBaseMapper;
	@Override
	public boolean isSuccessOrder(String orderNumber) throws OrderException {
		logger.info("判断当前订单编号是否有效【"+orderNumber+"】");
		if(StringUtils.isEmpty(orderNumber)){
			logger.info("订单编号为空");
			return false;
		}
		OrderBase orderBase=new OrderBase();
		orderBase.setOrderno(orderNumber);
		orderBase=orderBaseMapper.selectOne(orderBase);
		return orderBase.getPaystate().intValue()==1?true:false;
	}

	@Override
	public void changeOrderState(String orderNumber, OrderStateEnum orderStateEnum, String signStr)
			throws OrderException {
		logger.info("改变订单状态 orderNumber:{},OrderEnum:{},signStr:{}",orderNumber,orderStateEnum,signStr);
		//基本判断
        BzfAssert.isNull(OrderException.class, orderStateEnum, "订单状态类枚举不能为空");	
        
        if(StringUtils.isEmpty(signStr)){
        	logger.error("改变订单状态 ：订单签名【signStr】为空");
        	throw new OrderException(OrderExceptionEnum.ORDER_STATE_CANGE_PARM_NULL,"改变订单状态 ：订单签名【signStr】为空");
        }
		OrderBase t=new OrderBase();
		t.setOrderno(orderNumber);
		t=orderBaseMapper.selectOne(t);
		if(null==t) {
			logger.info("改变订单状态:当前订单编号【orderNumber:{}不存在】",orderNumber);
		}else {
			//判断签名
			if(t.getSignstr()!=null&&t.getSignstr().equals(signStr)) {
				//获取当前订单的状态
				if(t.getPaystate().intValue()!=OrderEnum.OrderStateEnum.ORDER_INIT_STATE.getKey().intValue()) {
					logger.error("改变订单状态 ：当前订单无法改变订单状态");
		        	throw new OrderException(OrderExceptionEnum.ORDER_STATE_CANGE_PARM_NULL,"改变订单状态 ：当前订单无法改变订单状态");
				}else {
					//改变订单的状态
					OrderBase base=new OrderBase();
					base.setId(t.getId());
					base.setPaystate(orderStateEnum.getKey());
					orderBaseMapper.update(base);
				}
			}else {
				logger.error("改变订单状态 ：订单签名【signStr】错误");
	        	throw new OrderException(OrderExceptionEnum.ORDER_STATE_CANGE_PARM_NULL,"改变订单状态 ：订单签名【signStr】错误");
			}
		}
	}

}
