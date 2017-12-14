package com.bz.dao.mapper.merchant;

import com.bz.dao.mapper.base.BaseMapper;
import com.bz.dao.pojo.merchant.MerchantServerStatus;

public interface MerchantServerStatusMapper extends BaseMapper<MerchantServerStatus> {
    /**
     *  动态字段,写入数据库记录,merchant_server_status
     *
     * @param record
     */
    int insertSelective(MerchantServerStatus record);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,merchant_server_status
     *
     * @param record
     */
    int updateByPrimaryKeySelective(MerchantServerStatus record);
}