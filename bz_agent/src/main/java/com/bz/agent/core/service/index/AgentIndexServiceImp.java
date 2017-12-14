package com.bz.agent.core.service.index;

import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.dubbo.config.annotation.Service;
import com.bz.dao.mapper.agent.BzAuditMapper;
import com.bz.dao.mapper.agent.BzCorporateInfoMapper;
import com.bz.dao.mapper.agent.BzPersonalDetailsMapper;
import com.bz.dao.pojo.agent.BzAudit;
import com.bz.dao.pojo.agent.BzPersonalDetails;
import com.bz.open.core.service.agent.AgentJudgeService;
/**
 * 
 * @author 陈青山
 * @TIME 2017年11月22日 下午22:52
 * @MIAOSHU 判断是不是合伙人 ，此service服务为了初次进入合伙人页面
 * @return 
 */
@Service(version="1.0.0",interfaceClass=com.bz.open.core.service.agent.AgentJudgeService.class)
@Transactional
public class AgentIndexServiceImp implements AgentJudgeService{
	//此常量用于判断用户是不是通过审核
	private static final Integer STATE_ONE = 1;



	private Logger log=LoggerFactory.getLogger(AgentIndexServiceImp.class);
	
	
	
	@Resource
	private BzAuditMapper bzAuditMapper;//审核接口
	@Resource
	private BzCorporateInfoMapper bzCorporateInfoMapper;//公司信息接口
	@Resource
	private BzPersonalDetailsMapper bzPersonalDetailsMapper;//个人信息接口

	

	/**
	 * @author 陈青山
	 * @miaoshu 为了判断当前用户是不是合伙人
	 * @param userid
	 * @return
	 */
	public boolean isAgent(String userid) {
		log.info("判断当前用户是不是合伙人   【参数用户id  "+userid+"】");
		BzPersonalDetails per=new BzPersonalDetails();
		per.setUserid(userid);
		List<BzPersonalDetails> selectList = bzPersonalDetailsMapper.selectList(per);
		if(selectList==null) {
			return false;
		}
		for(BzPersonalDetails deta:selectList) {
			BzAudit selectById = bzAuditMapper.selectById(deta.getId());
			if(selectById.getState()==STATE_ONE) {
				log.info("查询此用户审核状态    通过");
				return true;
			}
		}
		log.info("查询此用户审核状态    不通过");
		return false;
	}
	
	
}
