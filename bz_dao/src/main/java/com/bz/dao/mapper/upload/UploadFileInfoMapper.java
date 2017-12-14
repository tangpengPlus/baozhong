package com.bz.dao.mapper.upload;

import com.bz.dao.mapper.base.BaseMapper;
import com.bz.dao.pojo.upload.UploadFileInfo;

public interface UploadFileInfoMapper extends BaseMapper<UploadFileInfo> {
    /**
     *  动态字段,写入数据库记录,system_upload_file_info
     *
     * @param record
     */
    int insertSelective(UploadFileInfo record);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,system_upload_file_info
     *
     * @param record
     */
    int updateByPrimaryKeySelective(UploadFileInfo record);
}