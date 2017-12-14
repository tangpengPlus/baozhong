package com.bz.dao.pojo.pay;

import com.bz.framework.pojo.base.BasePojo;
import java.math.BigDecimal;
import java.util.Date;

/**
	* 作者:唐鹏
	* 描述:
	* 版本: version 1.0.0
	* 时间:2017-11-06 14:17:07
  */
public class PayRecord extends BasePojo {
    /**
     * 支付记录ID
     * 表字段 : pay_record.id
     */
    private Integer id;

    /**
     * 关联订单编号
     * 表字段 : pay_record.orderNo
     */
    private String orderno;

    /**
     * 支付类型；1：微信支付；2：支付宝支付；
     * 表字段 : pay_record.payType
     */
    private Integer paytype;

    /**
     * 支付金额
     * 表字段 : pay_record.payMoney
     */
    private BigDecimal paymoney;

    /**
     * 支付时间
     * 表字段 : pay_record.payTime
     */
    private Date paytime;

    /**
     * 0:请求初始化 1：处理成功
     * 表字段 : pay_record.payState
     */
    private Integer paystate;

    /**
     * 支付回调时间
     * 表字段 : pay_record.notifyTime
     */
    private Date notifytime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pay_record
     *
     * @mbg.generated Mon Nov 06 14:17:07 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取 支付记录ID 字段:pay_record.id
     *
     * @return pay_record.id, 支付记录ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 支付记录ID 字段:pay_record.id
     *
     * @param id the value for pay_record.id, 支付记录ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 关联订单编号 字段:pay_record.orderNo
     *
     * @return pay_record.orderNo, 关联订单编号
     */
    public String getOrderno() {
        return orderno;
    }

    /**
     * 设置 关联订单编号 字段:pay_record.orderNo
     *
     * @param orderno the value for pay_record.orderNo, 关联订单编号
     */
    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    /**
     * 获取 支付类型；1：微信支付；2：支付宝支付； 字段:pay_record.payType
     *
     * @return pay_record.payType, 支付类型；1：微信支付；2：支付宝支付；
     */
    public Integer getPaytype() {
        return paytype;
    }

    /**
     * 设置 支付类型；1：微信支付；2：支付宝支付； 字段:pay_record.payType
     *
     * @param paytype the value for pay_record.payType, 支付类型；1：微信支付；2：支付宝支付；
     */
    public void setPaytype(Integer paytype) {
        this.paytype = paytype;
    }

    /**
     * 获取 支付金额 字段:pay_record.payMoney
     *
     * @return pay_record.payMoney, 支付金额
     */
    public BigDecimal getPaymoney() {
        return paymoney;
    }

    /**
     * 设置 支付金额 字段:pay_record.payMoney
     *
     * @param paymoney the value for pay_record.payMoney, 支付金额
     */
    public void setPaymoney(BigDecimal paymoney) {
        this.paymoney = paymoney;
    }

    /**
     * 获取 支付时间 字段:pay_record.payTime
     *
     * @return pay_record.payTime, 支付时间
     */
    public Date getPaytime() {
        return paytime;
    }

    /**
     * 设置 支付时间 字段:pay_record.payTime
     *
     * @param paytime the value for pay_record.payTime, 支付时间
     */
    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    /**
     * 获取 0:请求初始化 1：处理成功 字段:pay_record.payState
     *
     * @return pay_record.payState, 0:请求初始化 1：处理成功
     */
    public Integer getPaystate() {
        return paystate;
    }

    /**
     * 设置 0:请求初始化 1：处理成功 字段:pay_record.payState
     *
     * @param paystate the value for pay_record.payState, 0:请求初始化 1：处理成功
     */
    public void setPaystate(Integer paystate) {
        this.paystate = paystate;
    }

    /**
     * 获取 支付回调时间 字段:pay_record.notifyTime
     *
     * @return pay_record.notifyTime, 支付回调时间
     */
    public Date getNotifytime() {
        return notifytime;
    }

    /**
     * 设置 支付回调时间 字段:pay_record.notifyTime
     *
     * @param notifytime the value for pay_record.notifyTime, 支付回调时间
     */
    public void setNotifytime(Date notifytime) {
        this.notifytime = notifytime;
    }
}