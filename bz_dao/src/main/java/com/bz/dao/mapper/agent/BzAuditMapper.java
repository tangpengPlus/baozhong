package com.bz.dao.mapper.agent;

import com.bz.dao.mapper.base.BaseMapper;
import com.bz.dao.pojo.agent.BzAudit;

public interface BzAuditMapper extends BaseMapper<BzAudit> {
    /**
     *  动态字段,写入数据库记录,bz_audit
     *
     * @param record
     */
    int insertSelective(BzAudit record);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,bz_audit
     *
     * @param record
     */
    int updateByPrimaryKeySelective(BzAudit record);
}