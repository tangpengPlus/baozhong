package com.bz.dao.mapper.merchant;

import com.bz.dao.mapper.base.BaseMapper;
import com.bz.dao.pojo.merchant.MerchantRedpacketSetting;

public interface MerchantRedpacketSettingMapper extends BaseMapper<MerchantRedpacketSetting> {
    /**
     *  动态字段,写入数据库记录,merchant_redpacket_setting
     *
     * @param record
     */
    int insertSelective(MerchantRedpacketSetting record);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,merchant_redpacket_setting
     *
     * @param record
     */
    int updateByPrimaryKeySelective(MerchantRedpacketSetting record);
}