package com.bz.open.core.service.agent;

import com.bz.framework.error.exception.AgentIndexException;
import com.bz.framework.pojo.base.BaseResult;
import com.bz.open.core.vo.request.agent.AgentRegionRequestVo;
/**
 * 
 * @author 陈青山
 * 时间  ：2017年11月20日 下午18：02
 * 描述 ： 注册服务实现
 */
public interface AgentApplyService {

	/**
	 * @author 陈青山
	 * @miaoshu 查询此用户审核状态    0为审核1为通过2为不通过
	 * @param userid 用户id
	 * @param type 用户的合伙人类型
	 * @return 已经测试
	 */
	public int ifPass(String userid ,String type)throws AgentIndexException;
	/**
	 * @作者 陈青山
	 * @描述 合伙人注册服务
	 * @return  已经测试
	 */
	public BaseResult apply(AgentRegionRequestVo vo)throws AgentIndexException;
	/**
	 * @author 陈青山
	 * @miaoshu 判断当前地区是否已经申请过第【"+type+"】种类型的合伙人
	 * @param type 合伙人类型
	 * @param vo 地区请求参数
	 * @return true为可以申请  已经测试
	 */
	public boolean isHas(String type,String[] dizi );
	/**
	 * @miaoshu 根据地区id查询地区名拼接详细地址
	 * @param dizi
	 * @return
	 */
	public String address(String dizi[]);
}
