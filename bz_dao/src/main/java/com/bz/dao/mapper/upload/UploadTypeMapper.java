package com.bz.dao.mapper.upload;

import com.bz.dao.mapper.base.BaseMapper;
import com.bz.dao.pojo.upload.UploadType;

public interface UploadTypeMapper extends BaseMapper<UploadType> {
    /**
     *  动态字段,写入数据库记录,system_upload_type
     *
     * @param record
     */
    int insertSelective(UploadType record);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,system_upload_type
     *
     * @param record
     */
    int updateByPrimaryKeySelective(UploadType record);
}