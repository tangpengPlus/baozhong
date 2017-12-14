package com.bz.open.core.service.agent;
/**
 * 
 * @author 陈青山
 * @Miaoshu 判断是不是合伙人
 *
 */
public interface AgentJudgeService {
	/**
	 * 只能判断当前用户通过审核没有
	 * @param userid
	 * @return 已经测试
	 */
	boolean isAgent(String userid);
}
