package com.bz.dao.mapper.merchant;

import com.bz.dao.mapper.base.BaseMapper;
import com.bz.dao.pojo.merchant.MerchantBase;

public interface MerchantBaseMapper extends BaseMapper<MerchantBase> {
    /**
     *  动态字段,写入数据库记录,merchant_base
     *
     * @param record
     */
    int insertSelective(MerchantBase record);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,merchant_base
     *
     * @param record
     */
    int updateByPrimaryKeySelective(MerchantBase record);
}