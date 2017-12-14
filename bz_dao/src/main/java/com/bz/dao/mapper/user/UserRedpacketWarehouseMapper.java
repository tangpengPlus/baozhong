package com.bz.dao.mapper.user;

import com.bz.dao.mapper.base.BaseMapper;
import com.bz.dao.pojo.user.UserRedpacketWarehouse;

public interface UserRedpacketWarehouseMapper extends BaseMapper<UserRedpacketWarehouse> {
    /**
     *  动态字段,写入数据库记录,user_redpacket_warehouse
     *
     * @param record
     */
    int insertSelective(UserRedpacketWarehouse record);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,user_redpacket_warehouse
     *
     * @param record
     */
    int updateByPrimaryKeySelective(UserRedpacketWarehouse record);
}