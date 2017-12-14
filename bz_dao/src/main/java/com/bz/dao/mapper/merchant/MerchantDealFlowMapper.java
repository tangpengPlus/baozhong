package com.bz.dao.mapper.merchant;

import java.util.List;

import com.bz.dao.mapper.base.BaseMapper;
import com.bz.dao.pojo.merchant.MerchantDealFlow;

public interface MerchantDealFlowMapper extends BaseMapper<MerchantDealFlow> {
    /**
     *  动态字段,写入数据库记录,merchant_deal_flow
     *
     * @param record
     */
    int insertSelective(MerchantDealFlow record);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,merchant_deal_flow
     *
     * @param record
     */
    int updateByPrimaryKeySelective(MerchantDealFlow record);
    
    /**
     * 查询资金流水信息  分页查询
     * @param shopId
     * @param min
     * @param max
     * @return
     */
    List<MerchantDealFlow> selectDealOfShop(Integer shopId,Integer min,Integer max);
}