package com.bz.open.core.service.merchant;

import java.util.List;

import com.bz.open.core.vo.response.agent.StoreInfoResponseVo;
import com.bz.open.core.vo.response.merchant.MerchantDealFlowResponseVo;

public interface MerchantDealFlowService {

	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 根据店铺id获取店铺交易次数
	 * 创建时间:2017年11月21日下午3:29:57
	 * @param shopId 店铺id
	 * @return 店铺交易次数
	 */
	public Integer getDealCount(Integer shopId);
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 根据店铺id获取该店铺的所有流水详情
	 * 创建时间:2017年11月21日下午3:40:59
	 * @param shopId 店铺id curr 当前页  size 显示几条
	 * @return 订单集合
	 */
	public List<StoreInfoResponseVo> getAllDealOfShop(Integer shopId,Integer curr,Integer size);
	
	
}
