package com.bz.dao.mapper.pay;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.bz.dao.mapper.base.BaseMapper;
import com.bz.dao.pojo.pay.PayRecord;

public interface PayRecordMapper extends BaseMapper<PayRecord> {
    /**
     *  动态字段,写入数据库记录,pay_record
     *
     * @param record
     */
    int insertSelective(PayRecord record);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,pay_record
     *
     * @param record
     */
    int updateByPrimaryKeySelective(PayRecord record);
    
    /**
     * 
     * 
     * 作者:唐鹏
     * 创建时间:2017年11月6日下午5:36:28
     * 描述:更改订单支付记录
     * 备注:
     * @param orderNumber:订单编号
     * @param state:支付状态
     * @param notifyDate:回调时间
     */
    void updatePayRecordInfo(@Param("orderNumber")String orderNumber,@Param("state")Integer state,@Param("notifyDate")Date notifyDate);
}