package com.bz.dao.mapper.merchant;

import com.bz.dao.mapper.base.BaseMapper;
import com.bz.dao.pojo.merchant.MerchantRedpacketUseRecord;

public interface MerchantRedpacketUseRecordMapper extends BaseMapper<MerchantRedpacketUseRecord> {
    /**
     *  动态字段,写入数据库记录,merchant_redpacket_use_record
     *
     * @param record
     */
    int insertSelective(MerchantRedpacketUseRecord record);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,merchant_redpacket_use_record
     *
     * @param record
     */
    int updateByPrimaryKeySelective(MerchantRedpacketUseRecord record);
}