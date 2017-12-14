package com.bz.dao.mapper.merchant;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bz.dao.mapper.base.BaseMapper;
import com.bz.dao.pojo.merchant.MerchantShop;

public interface MerchantShopMapper extends BaseMapper<MerchantShop> {
    /**
     *  动态字段,写入数据库记录,merchant_shop
     *
     * @param record
     */
    int insertSelective(MerchantShop record);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,merchant_shop
     *
     * @param record
     */
    int updateByPrimaryKeySelective(MerchantShop record);
    
    /**
     * 
     * 作者: 兰俊
     * 描述: 根据特定的条件获取店铺信息
     * 创建时间:2017年11月23日下午9:54:00
     * @param condition
     * @return
     */
    List<MerchantShop> getMerchantInfoByCondition(@Param("cond")MerchantShop condition);
}