package com.bz.open.core.service.agent;

import com.bz.framework.pojo.base.BaseResult;
/**
 * 
 * @author 陈青山
 * @miaoshu 绑定自营业员
 */
public interface AgentBoundService {

	
	
	
	public BaseResult<String> boundAgent(String phone,String type,String userid);
}
