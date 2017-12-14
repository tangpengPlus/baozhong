package com.bz.agent.service.boundagent;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.bz.dao.mapper.agent.BzIncidenceRelationMapper;
import com.bz.dao.mapper.agent.BzPersonalDetailsMapper;
import com.bz.dao.pojo.agent.BzIncidenceRelation;
import com.bz.dao.pojo.agent.BzPersonalDetails;
import com.bz.framework.constant.result.ResultValueEnum;
import com.bz.framework.pojo.base.BaseResult;
import com.bz.open.core.service.agent.AgentBoundService;
import com.mysql.fabric.xmlrpc.base.Data;
/**
 * 
 * @author 陈青山
 * @miaoshu 绑定合伙人服务
 *
 */
@Service(version="1.0.0",interfaceClass=com.bz.open.core.service.agent.AgentBoundService.class)
public class AgentBoundServiceImp implements AgentBoundService{
	@Autowired
	private BzPersonalDetailsMapper bzPersonalDetailsMapper;
	@Autowired
	private BzIncidenceRelationMapper bzIncidenceRelationMapper;
	
	private Logger log=LoggerFactory.getLogger(AgentBoundServiceImp.class);
	@Transactional
	public BaseResult<String> boundAgent(String phone,String type,String userid) {
		log.info("绑定合伙人开始   参数【phone:"+phone+" type:"+type+" userid:"+userid+"】");
		BaseResult<String> base=BaseResult.newInstance();
		if(StringUtils.isEmpty(phone)) {
			log.error("参数为空");
			base.changeStatus(ResultValueEnum.AGENT_TELL_NULL_ERROR);
		}
		if(StringUtils.isEmpty(type)||StringUtils.isEmpty(userid)) {
			log.error("系统获取参数错误");
			base.changeStatus(ResultValueEnum.AGENT_PARAM_NULL_ERROR);
		}
		BzPersonalDetails per=new BzPersonalDetails();
		per.setImphone(phone);
		per.setSgrade(1);
		BzPersonalDetails selectOne = bzPersonalDetailsMapper.selectOne(per);
		BzPersonalDetails per1=new BzPersonalDetails();
		per1.setUserid(userid);
		per1.setSgrade(Integer.parseInt(type));
		BzPersonalDetails selecttwo = bzPersonalDetailsMapper.selectOne(per);
		BzIncidenceRelation bz=new BzIncidenceRelation();
		bz.setCreatetime(new Data().toString());
		bz.setRefuserid( selectOne.getId()+"");
		bz.setUserid(selecttwo.getId()+"");
		bzIncidenceRelationMapper.save(bz);
		log.info("用户"+selectOne.getId()+"与用户"+selecttwo.getId()+"绑定成功！！！");
		return base;
	}
	
}
