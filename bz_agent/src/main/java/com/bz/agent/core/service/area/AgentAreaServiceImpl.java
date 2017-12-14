 package com.bz.agent.core.service.area;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.bz.dao.mapper.agent.BzPersonalDetailsMapper;
import com.bz.dao.pojo.agent.BzPersonalDetails;
import com.bz.open.core.service.agent.AgentAreaService;
import com.bz.open.core.vo.response.agent.AgentAreaInfoResponseVo;
import com.bz.open.core.vo.response.agent.PersonalDetailsResponseVo;

/**
 * 
 * 作者: 兰俊
 * 描述: 合伙人代理区域服务实现
 * 创建时间:2017年11月22日下午5:12:48
 * 修改备注e:
 */
@Service(version="1.0.0", interfaceClass=com.bz.open.core.service.agent.AgentAreaService.class)
@Transactional
public class AgentAreaServiceImpl implements AgentAreaService {

	Logger logger = LoggerFactory.getLogger(AgentAreaServiceImpl.class);
	@Autowired
	private BzPersonalDetailsMapper personalDetailsMapper;
	/** 
     * 
     * 作者: 兰俊
     * 描述: 根据合伙人的addressCode、合伙人的类型获取该合伙人下该类型的合伙人信息集合
     * 创建时间:2017年11月22日下午6:53:44
     * @param agentType 合伙人类型
     * @param addressCode 合伙人addressCode
     * @return 合伙人信息集合
     */
	@Override
	public List<PersonalDetailsResponseVo> getAgentInfos(String addressCode,Integer agentType) {
		logger.info("根据合伙人类型【agentType="+agentType+"】合伙人的【addressCode="+addressCode+"】获取下级合伙人信息");
		List<BzPersonalDetails> bzPersonalDetailses = personalDetailsMapper.getAgentByAgentTypeAddress(addressCode,agentType);
		if(bzPersonalDetailses==null||bzPersonalDetailses.size()==0) {
			return null;
		}
		List<PersonalDetailsResponseVo> personalDetailsResps = new ArrayList<>();
		for(BzPersonalDetails p:bzPersonalDetailses) {
			PersonalDetailsResponseVo personalDetailsResp = new PersonalDetailsResponseVo();
			try {
				BeanUtils.copyProperties(personalDetailsResp, p);
			} catch (IllegalAccessException e) {
				logger.error("bean类型转换有误,【BzPersonalDetails:"+p+"】转换到【PersonalDetailsResponseVo:"+personalDetailsResp+"】有误");
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				logger.error("bean类型转换有误,【BzPersonalDetails:"+p+"】转换到【PersonalDetailsResponseVo:"+personalDetailsResp+"】有误");
				e.printStackTrace();
			}
			personalDetailsResps.add(personalDetailsResp);
		}
		return personalDetailsResps;
	}

	/**
	 * --
	 * 作者: 兰俊
	 * 描述: 根据合伙人的userid获取该合伙人的代理区域封装集合
	 * 创建时间:2017年11月22日下午5:56:30
	 * @param userid 合伙人的userid
	 * @return 代理区域封装集合
	 */
	public List<AgentAreaInfoResponseVo> getAgentAddressByAgentId(String userid){
		logger.info("根据合伙人的【uerid="+userid+"】获取合伙人的代理区域");
		List<BzPersonalDetails> personalDetails = personalDetailsMapper.getAgentAddressByAgentId(userid);
		if(personalDetails.size()==0) {
			return null;
		}
		List<AgentAreaInfoResponseVo> addresses = new ArrayList<>();
		for(BzPersonalDetails p:personalDetails) {
			AgentAreaInfoResponseVo areaInfo = new AgentAreaInfoResponseVo();
			areaInfo.setAddress(p.getAddress());
			areaInfo.setAgentType(p.getSgrade());
			areaInfo.setAddressCode(p.getAgentaddress());
			addresses.add(areaInfo);
           }
		return addresses;
	}

	
	
	
}
