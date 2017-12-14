package com.bz.dao.mapper.agent;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bz.dao.mapper.base.BaseMapper;
import com.bz.dao.pojo.agent.BzPersonalDetails;

public interface BzPersonalDetailsMapper extends BaseMapper<BzPersonalDetails> {
    /**
     *  动态字段,写入数据库记录,bz_personal_details
     *
     * @param record
     */
    int insertSelective(BzPersonalDetails record);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,bz_personal_details
     *
     * @param record
     */
    int updateByPrimaryKeySelective(BzPersonalDetails record);
    
    /**
     * 
     * 作者: 兰俊
     * 描述: 根据合伙人userid获取合伙人信息集合
     * 创建时间:2017年11月22日下午5:39:33
     * @param id 合伙人userid
     * @return 合伙人信息集合
     */
    List<BzPersonalDetails> getAgentAddressByAgentId(String id);
    
    /**
     * 
     * 作者: 兰俊
     * 描述: 根据合伙人的addressCode、合伙人的类型获取该合伙人下该类型的合伙人信息集合
     * 创建时间:2017年11月22日下午6:53:44
     * @param agentType 合伙人类型
     * @param addressCode 合伙人addressCode
     * @return 合伙人信息集合
     */
    List<BzPersonalDetails> getAgentByAgentTypeAddress(@Param("address")String addressCode ,@Param("type")Integer agentType);
    /**
	 * @author 陈青山
	 * @miaoshu 判断当前地区是否已经申请过【"+type+"】种类型的合伙人
	 * @param type 合伙人类型
	 * @param address 地区请求参数
	 * @return
	 */
	int isHasAgent(@Param(value="type")String type, @Param(value="address")String address);
}