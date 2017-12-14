package com.bz.open.core.service.merchant;

import com.bz.framework.error.exception.MerchantException;

/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年11月2日下午4:54:48
 * 描述:商户会员开放服务
 * 备注:
 */
public interface MerchantMemberService {
	
	/**
	 * 
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年11月2日下午4:57:50
	 * 描述:判断当前用户是否是该店的新会员
	 * 备注:
	 * @param userId
	 * @param merchantId
	 * @return
	 * @throws MerchantException
	 */
	boolean isNewMember(Integer userId,Integer merchantId)throws MerchantException;


	/**
	 * 
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年11月2日下午5:42:46
	 * 描述:增加商户的会员记录
	 * 备注:
	 * @param userId
	 * @param merchantId
	 * @throws MerchantException
	 */
    void addMerchantMember(Integer userId,Integer merchantId)throws MerchantException;
}
