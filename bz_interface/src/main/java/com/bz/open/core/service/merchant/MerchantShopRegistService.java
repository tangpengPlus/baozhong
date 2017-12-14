package com.bz.open.core.service.merchant;

import com.bz.framework.error.exception.MerchantException;
import com.bz.open.core.vo.request.merchant.MerchantShopRequestVo;
import com.bz.open.core.vo.response.merchant.MerchantShopResponseVo;

/**
 * 
 * 
 * 作者: 彭云山
 * 描述:商铺服务接口
 * 创建时间:2017年11月7日下午7:52:06
 * 修改备注:
 */
public interface MerchantShopRegistService {

	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月7日下午7:52:31
	 * 描述:新增商铺服务接口
	 * @param shop
	 * @return
	 */
	public Integer addMerchantShop(MerchantShopRequestVo shop)throws MerchantException;
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月7日下午7:55:39
	 * 描述:修改商铺服务接口
	 * @param shop
	 * @return
	 */
	public void updateMerchantShop(MerchantShopRequestVo shop)throws MerchantException;
	
	/**
	* @作者 胡竞
	* @Title: selectMerchantShopById 
	* @Description: TODO(通过商铺ID查询商铺信息) 
	* @param @param shopId
	* @param @return
	* @param @throws MerchantException    设定文件 
	* @return MerchantShopResponseVo    返回类型 
	* @throws
	 */
	public MerchantShopResponseVo selectMerchantShopById(Integer shopId) throws MerchantException;
}
