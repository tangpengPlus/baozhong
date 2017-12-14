package com.bz.open.core.service.merchant;

import com.bz.framework.error.exception.MerchantException;
import com.bz.open.core.vo.request.merchant.MerchantServerInitVo;

/**
 * 
 * 
 * 作者: 彭云山
 * 描述:商家服务初始化接口
 * 创建时间:2017年11月13日下午2:44:22
 * 修改备注:
 */
public interface MerchantServiceInitService {

	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月13日下午2:49:34
	 * 描述:修改商家初始化服务
	 * @param merchantOpenStatus {@link merchantOpenStatus}修改商家初始化状态
	 * @return
	 * @throws MerchantException
	 */
	public boolean updateMerchantInitServer(MerchantServerInitVo merchantOpenStatus)throws MerchantException;
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月13日下午2:48:28
	 * 描述:商铺初始化服务状态
	 * @param merchantOpenStatus {@link merchantOpenStatus}增加的商家初始化状态
	 * @return
	 * @throws MerchantException
	 */
	public boolean initMerchantServer(Integer merchantId)throws MerchantException;
}
