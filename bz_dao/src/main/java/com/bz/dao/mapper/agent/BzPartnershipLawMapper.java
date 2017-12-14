package com.bz.dao.mapper.agent;

import com.bz.dao.mapper.base.BaseMapper;
import com.bz.dao.pojo.agent.BzPartnershipLaw;

public interface BzPartnershipLawMapper extends BaseMapper<BzPartnershipLaw> {
    /**
     *  动态字段,写入数据库记录,bz_partnership_law
     *
     * @param record
     */
    int insertSelective(BzPartnershipLaw record);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,bz_partnership_law
     *
     * @param record
     */
    int updateByPrimaryKeySelective(BzPartnershipLaw record);
}