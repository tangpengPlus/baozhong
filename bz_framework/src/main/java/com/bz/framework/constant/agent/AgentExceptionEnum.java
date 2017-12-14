package com.bz.framework.constant.agent;

import com.bz.framework.constant.base.BaseEnum;

/**
 * 
 * @author 陈青山
 * @MIAOSHU 合伙人异常枚举
 * @TIME 2017年11月18日 下午14:26
 */
public class AgentExceptionEnum {
	/**
	 * 
	 * @author 陈青山
	 * @MIAOSHU 合伙人首页异常枚举
	 * @TIME 2017年11月18日 下午14:26
	 */
	public enum AgentIndexEnum implements BaseEnum<Integer>{
	AGENT_PARAMETER_Exception(900001,"合伙人首页用户参数为空"),
	AGENT_DATA_Exception(900002,"后台数据错误");
	

	private Integer key;
	private String value;
		
		
	public String getValue() {
		return this.value;
	}
	public Integer getKey() {
		return this.key;
	}
	private  AgentIndexEnum(Integer key,String value){
	this.key=key;
	this.value=value;
	}
	public String toString() {
		return "[key="+key+",value="+value+"]";
	}
	public String getTitle() {
		return this.value;
	}
	}
	
	
}
