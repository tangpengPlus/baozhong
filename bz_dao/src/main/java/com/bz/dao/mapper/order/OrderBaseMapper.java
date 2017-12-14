package com.bz.dao.mapper.order;

import org.apache.ibatis.annotations.Param;

import com.bz.dao.mapper.base.BaseMapper;
import com.bz.dao.pojo.order.OrderBase;

public interface OrderBaseMapper extends BaseMapper<OrderBase> {
    /**
     *  动态字段,写入数据库记录,order_base
     *
     * @param record
     */
    int insertSelective(OrderBase record);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,order_base
     *
     * @param record
     */
    int updateByPrimaryKeySelective(OrderBase record);
    
    /**
     * 
     *  作者:唐鹏
     *  描述:更新超时订单
     *  备注:
     *  创建时间:2017年11月27日下午2:05:34
     *  @param timeInterval
     */
    void updateTimeOutOrder(@Param("timeInterval")long timeInterval);
}