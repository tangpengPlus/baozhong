package com.bz.dao.mapper.agent;

import com.bz.dao.mapper.base.BaseMapper;
import com.bz.dao.pojo.agent.BzIncidenceRelation;

public interface BzIncidenceRelationMapper extends BaseMapper<BzIncidenceRelation> {
    /**
     *  动态字段,写入数据库记录,bz_incidence_relation
     *
     * @param record
     */
    int insertSelective(BzIncidenceRelation record);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,bz_incidence_relation
     *
     * @param record
     */
    int updateByPrimaryKeySelective(BzIncidenceRelation record);
}