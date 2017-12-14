package com.bz.order.core.server.order.user;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.bz.dao.mapper.order.OrderBaseMapper;
import com.bz.dao.pojo.order.OrderBase;
import com.bz.framework.constant.order.OrderEnum.OrderStateEnum;
import com.bz.framework.error.exception.OrderException;
import com.bz.framework.util.base.IntegerUtil;
import com.bz.open.core.service.merchant.MerchantBaseService;
import com.bz.open.core.service.order.UserOrderService;
import com.bz.open.core.vo.response.order.UserOrderResponseVo;
import com.bz.order.core.server.order.base.BaseOrderServiceImpl;
/**
 * 
 * 
 * 作者: 彭云山
 * 描述:用户订单服务实现类
 * 创建时间:2017年11月3日上午11:19:17
 * 修改备注:
 */
@Service(version="1.0.0",interfaceClass=com.bz.open.core.service.order.UserOrderService.class)
@Transactional
public class UserOrderServiceImpl implements UserOrderService{
	private final Logger logger=LoggerFactory.getLogger(BaseOrderServiceImpl.class);
	@Autowired
	private OrderBaseMapper orderBaseMapper;
	@Reference(version="1.0.0")
	private MerchantBaseService merchantBaseService;
	
	/**
	 * 查询订单支付状态
	 * userId：用户ID
	 * orderStateEnum参数：支付状态;0:未支付；1:支付成功;2:支付失败;3:支付超时
	 */
	@Override
	public List<UserOrderResponseVo> selectUserOrderByOrderStatus(Integer userId, OrderStateEnum orderStateEnum)
			throws OrderException {
		logger.info("查询ID为"+userId+"的用户的"+orderStateEnum+"订单【支付状态;0:未支付；1:支付成功;2:支付失败;3:支付超时】");
		if(IntegerUtil.isEmpty(userId)) {
			return null;
		}
		OrderBase orderBase=new OrderBase();
		orderBase.setUserid(userId);
		if(null!=orderStateEnum) {
			orderBase.setPaystate(orderStateEnum.getKey());
		}
		
		List<UserOrderResponseVo> userOrderVoList=new ArrayList<UserOrderResponseVo>();
		List<OrderBase> orderBaseList=new ArrayList<OrderBase>();
		orderBaseList=orderBaseMapper.selectList(orderBase);
		for (OrderBase orderBase2 : orderBaseList) {
			UserOrderResponseVo userOrderVo=new UserOrderResponseVo();
			
			//订单id
			userOrderVo.setId(orderBase2.getId());
			//订单编号
			userOrderVo.setOrderno(orderBase2.getOrderno());
			//订单关联用户ID
			userOrderVo.setUserid(orderBase2.getUserid());
			//订单关联店铺ID
			userOrderVo.setShopid(orderBase2.getShopid());
			//查询店铺名称
			try {
				userOrderVo.setMerchantName(merchantBaseService.getMerchantInfoById(orderBase2.getShopid()).getName());
			} catch (Exception e) {
				logger.error("用户订单查询获取商铺名称错误");
				e.printStackTrace();
			}
			//订单总额
			userOrderVo.setTatolmoney(orderBase2.getTatolmoney().toString());
			//线上支付总额
			userOrderVo.setOnlinepaymoney(orderBase2.getOnlinepaymoney());
			//线下支付总额
			userOrderVo.setOfflinepaymoney(orderBase2.getOfflinepaymoney());
			//活动抵用总额
			userOrderVo.setActivitypaymoney(orderBase2.getActivitypaymoney());
			//积分抵用总额
			userOrderVo.setIntegralpaymoney(orderBase2.getIntegralpaymoney());
			//支付状态;0:未支付；1:支付成功;2:支付失败;3:支付超时
			userOrderVo.setPaystate(orderBase2.getPaystate());
			//支付方式；1：微信支付；2：支付宝支付；3：混合支付；
			userOrderVo.setPayway(orderBase2.getPayway());
			//支付结果回调时间
			userOrderVo.setCallbacktime(orderBase2.getCallbacktime());
			//支付备注
			userOrderVo.setPayremark(orderBase2.getPayremark());
			//订单创建时间
			userOrderVo.setCreatetime(orderBase2.getCreatetime());
			//是否隐藏；0：展示；1：隐藏
			userOrderVo.setIsshow(orderBase2.getIsshow());
			//订单类型;1：扫码订单；2网店订单
			userOrderVo.setOrdertype(orderBase2.getOrdertype());
			//二维码地址
			userOrderVo.setQrcodelink(orderBase2.getQrcodelink());
			//客户端IP
			userOrderVo.setClientip(orderBase2.getClientip());
			
			
			userOrderVoList.add(userOrderVo);
		}
		
		return userOrderVoList;
	}

	@Override
	public UserOrderResponseVo selectUserOrderByOrderId(Integer orderId) throws OrderException {
		logger.info("传入的订单ID【orderId:"+orderId+"】");
		if(IntegerUtil.isEmpty(orderId)) {
			logger.error("传入的OrderI为空，："+orderId);
		}
		
		
		//传建一个dao层订单对象
		OrderBase base=new OrderBase();
		//注入ID
		base.setId(orderId);
		//查询当前ID的订单
		try {
			base=orderBaseMapper.selectById(orderId);
		} catch (Exception e) {
			logger.error("查询当前ID订单有误");
		}
		//创建订单响应类
		UserOrderResponseVo userOrderResponseVo=new UserOrderResponseVo();
		//订单id
		userOrderResponseVo.setId(base.getId());
		//订单编号
		userOrderResponseVo.setOrderno(base.getOrderno());
		//订单关联用户ID
		userOrderResponseVo.setUserid(base.getUserid());
		//订单关联店铺ID
		userOrderResponseVo.setShopid(base.getShopid());
		//查询店铺名称
		userOrderResponseVo.setMerchantName(merchantBaseService.getMerchantInfoById(base.getShopid()).getName());
		//订单总额
		userOrderResponseVo.setTatolmoney(base.getTatolmoney().toString());
		//线上支付总额
		userOrderResponseVo.setOnlinepaymoney(base.getOnlinepaymoney());
		//支付状态;0:未支付；1:支付成功;2:支付失败;3:支付超时
		userOrderResponseVo.setPaystate(base.getPaystate());
		//支付方式；1：微信支付；2：支付宝支付；3：混合支付；
		userOrderResponseVo.setPayway(base.getPayway());
		//支付结果回调时间
		userOrderResponseVo.setCallbacktime(base.getCallbacktime());
		//支付备注
		userOrderResponseVo.setPayremark(base.getPayremark());
		//订单创建时间
		
		userOrderResponseVo.setCreatetime(base.getCreatetime());
		//订单类型;1：扫码订单；2网店订单
		userOrderResponseVo.setOrdertype(base.getOrdertype());
		
		
		
		return userOrderResponseVo;
	}
	
	
}
