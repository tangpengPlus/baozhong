package com.bz.dao.mapper.merchant;

import com.bz.dao.mapper.base.BaseMapper;
import com.bz.dao.pojo.merchant.MerchantUserRecord;

public interface MerchantUserRecordMapper extends BaseMapper<MerchantUserRecord> {
    /**
     *  动态字段,写入数据库记录,merchant_user_record
     *
     * @param record
     */
    int insertSelective(MerchantUserRecord record);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,merchant_user_record
     *
     * @param record
     */
    int updateByPrimaryKeySelective(MerchantUserRecord record);
}