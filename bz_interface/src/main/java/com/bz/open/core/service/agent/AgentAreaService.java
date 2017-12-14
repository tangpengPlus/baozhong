package com.bz.open.core.service.agent;


import java.util.List;
import com.bz.open.core.vo.response.agent.AgentAreaInfoResponseVo;
import com.bz.open.core.vo.response.agent.PersonalDetailsResponseVo;

/**
 * 
 * 作者: 兰俊
 * 描述: 合伙人代理区域信息开放服务
 * 创建时间:2017年11月21日下午1:49:56
 * 修改备注:
 */
public interface AgentAreaService {

	/**
     * 
     * 作者: 兰俊
     * 描述: 根据合伙人的addressCode、合伙人的类型获取该合伙人下该类型的合伙人信息集合
     * 创建时间:2017年11月22日下午6:53:44
     * @param agentType 合伙人类型
     * @param addressCode 合伙人addressCode
     * @return 合伙人信息集合
     */
	public List<PersonalDetailsResponseVo> getAgentInfos(String addressCode,Integer agentType);

	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 根据合伙人的userid获取该合伙人的代理区域封装集合
	 * 创建时间:2017年11月22日下午5:56:30
	 * @param userid 合伙人的userid
	 * @return 代理区域封装集合
	 */
	public List<AgentAreaInfoResponseVo> getAgentAddressByAgentId(String userid);
}
