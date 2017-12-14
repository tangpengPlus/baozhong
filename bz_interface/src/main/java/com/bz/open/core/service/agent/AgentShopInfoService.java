package com.bz.open.core.service.agent;

import java.util.List;

import com.bz.dao.pojo.agent.BzPersonalDetails;

/**
 * 
 * 作者: 兰俊
 * 描述: 合伙人店铺信息开放服务
 * 创建时间:2017年11月21日下午2:28:07
 * 修改备注:
 */
public interface AgentShopInfoService {

	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 根据合伙人id获取其关联的店铺数量
	 * 创建时间:2017年11月21日下午2:06:59
	 * @param agentId 当前合伙人的id
	 * @return 店铺数量	已经测试
	 */
	public Integer getShopCountOfAgent(String agentId,String type);
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 根据封装条件获取合伙人店铺关系类集合
	 * 创建时间:2017年11月21日下午8:23:47
	 * @param storeAssociated 合伙人店铺关系类
	 * @return 合伙人店铺id集合  还需要调用店铺表查询出店铺信息   已经测试
	 */
	public List<String> getShopIdsOfAgent(String userid,String type,int pagesize,int cursize );
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 根据当前合伙人的id获取其关联的自营业员信息集合
	 * 创建时间:2017年11月21日下午2:14:47
	 * @param agentId 当前合伙人的id
	 * @return 合伙人集合 			已经测试
	 */
	public List<BzPersonalDetails> getMyAgent(String agentId);

	
	
}
