package com.bz.dao.mapper.user;

import com.bz.dao.mapper.base.BaseMapper;
import com.bz.dao.pojo.user.UserDealFlow;

public interface UserDealFlowMapper extends BaseMapper<UserDealFlow> {
    /**
     *  动态字段,写入数据库记录,user_deal_flow
     *
     * @param record
     */
    int insertSelective(UserDealFlow record);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,user_deal_flow
     *
     * @param record
     */
    int updateByPrimaryKeySelective(UserDealFlow record);
}