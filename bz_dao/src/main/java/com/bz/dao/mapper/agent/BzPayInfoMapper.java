package com.bz.dao.mapper.agent;

import com.bz.dao.mapper.base.BaseMapper;
import com.bz.dao.pojo.agent.BzPayInfo;

public interface BzPayInfoMapper extends BaseMapper<BzPayInfo> {
    /**
     *  动态字段,写入数据库记录,bz_pay_info
     *
     * @param record
     */
    int insertSelective(BzPayInfo record);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,bz_pay_info
     *
     * @param record
     */
    int updateByPrimaryKeySelective(BzPayInfo record);
}