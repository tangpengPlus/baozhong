package com.bz.open.core.service.merchant;

import java.util.List;

import com.bz.framework.error.exception.MerchantException;
import com.bz.open.core.vo.response.agentShop.AgentShopResponseVo;
import com.bz.open.core.vo.response.merchant.MerchantInfoResponseVo;
import com.bz.open.core.vo.response.merchant.MerchantServerStatusResponseVo;
import com.bz.open.core.vo.response.merchant.MerchantShopResponseVo;

/**
 * 
 *  作者:唐鹏
 *  描述:商家基础服务开放接口 
 *  备注:1.根据商家Id查询商家基本信息
 *  创建时间:2017年11月15日下午6:14:26
 */
public interface MerchantBaseService {

	
	
	/**
	 * 
	 *  作者:唐鹏
	 *  描述:根据商家Id查询商家基本信息
	 *  备注:
	 *  创建时间:2017年11月15日下午6:17:32
	 *  @param merchantId :商家Id
	 *  @return MerchantInfoResponseVo: 商户基本信息封装
	 *  @throws MerchantException ${@link MerchantException}商户异常封装
	 */
	MerchantInfoResponseVo getMerchantInfoById(Integer merchantId)throws MerchantException;

	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 根据地区编码、店铺名称查询店铺信息
	 * 创建时间:2017年11月23日下午4:47:34
	 * @param agentAddress 地区编码
	 * @return 店铺信息集合
	 */
	public List<MerchantShopResponseVo> getMerchantInfoByArea(String agentAddress,String shopName);
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 根据商家id查询商家开启的功能信息
	 * 创建时间:2017年11月21日下午5:08:24
	 * @param merchantId
	 * @return
	 * @throws MerchantException
	 */
	public MerchantServerStatusResponseVo getMerchantServerStatusById(Integer merchantId) throws MerchantException;


	/**
	 * @author 陈青山
	 * @miaoshu 得到绑定商家信息
	 * @param list 店铺id集合
	 * @return
	 */
	public List<AgentShopResponseVo> getAgentShopInfo(List<String> list);
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 根据用户的openid获取该用户的店铺信息
	 * 创建时间:2017年11月23日下午10:20:00
	 * @param openId
	 * @return
	 */
	public List<AgentShopResponseVo> getMerchantShopInfo(String openId);


}
