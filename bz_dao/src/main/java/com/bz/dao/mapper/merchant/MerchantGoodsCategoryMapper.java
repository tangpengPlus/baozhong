package com.bz.dao.mapper.merchant;

import com.bz.dao.mapper.base.BaseMapper;
import com.bz.dao.pojo.merchant.MerchantGoodsCategory;

public interface MerchantGoodsCategoryMapper extends BaseMapper<MerchantGoodsCategory> {
    /**
     *  动态字段,写入数据库记录,merchant_goods_category
     *
     * @param record
     */
    int insertSelective(MerchantGoodsCategory record);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,merchant_goods_category
     *
     * @param record
     */
    int updateByPrimaryKeySelective(MerchantGoodsCategory record);
}