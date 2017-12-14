package com.bz.dao.mapper.agent;

import com.bz.dao.mapper.base.BaseMapper;
import com.bz.dao.pojo.agent.BzMovementOfFunds;

public interface BzMovementOfFundsMapper extends BaseMapper<BzMovementOfFunds> {
    /**
     *  动态字段,写入数据库记录,bz_movement_of_funds
     *
     * @param record
     */
    int insertSelective(BzMovementOfFunds record);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,bz_movement_of_funds
     *
     * @param record
     */
    int updateByPrimaryKeySelective(BzMovementOfFunds record);
}