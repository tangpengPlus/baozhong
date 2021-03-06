package com.bz.open.core.vo.request.merchant;

import java.util.Date;

import com.bz.framework.pojo.base.BasePojo;

public class MerchantRedpacketUseRecordRequest extends BasePojo{
	/**
     * 红包使用记录ID
     * 表字段 : merchant_redpacket_use_record.id
     */
    private Integer id;

    /**
     * 关联用户ID
     * 表字段 : merchant_redpacket_use_record.userId
     */
    private Integer userid;

    /**
     * 红包券ID
     * 表字段 : merchant_redpacket_use_record.rpId
     */
    private Integer rpid;

    /**
     * 关联商铺ID
     * 表字段 : merchant_redpacket_use_record.shopId
     */
    private Integer shopid;

    /**
     * 使用时间
     * 表字段 : merchant_redpacket_use_record.useTime
     */
    private Date usetime;

    /**
     * 使用金额
     * 表字段 : merchant_redpacket_use_record.useMoney
     */
    private Long usemoney;

    /**
     * 关联订单编号
     * 表字段 : merchant_redpacket_use_record.orderNo
     */
    private String orderno;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table merchant_redpacket_use_record
     *
     * @mbg.generated Mon Nov 06 01:02:00 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取 红包使用记录ID 字段:merchant_redpacket_use_record.id
     *
     * @return merchant_redpacket_use_record.id, 红包使用记录ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 红包使用记录ID 字段:merchant_redpacket_use_record.id
     *
     * @param id the value for merchant_redpacket_use_record.id, 红包使用记录ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 关联用户ID 字段:merchant_redpacket_use_record.userId
     *
     * @return merchant_redpacket_use_record.userId, 关联用户ID
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 设置 关联用户ID 字段:merchant_redpacket_use_record.userId
     *
     * @param userid the value for merchant_redpacket_use_record.userId, 关联用户ID
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 获取 红包券ID 字段:merchant_redpacket_use_record.rpId
     *
     * @return merchant_redpacket_use_record.rpId, 红包券ID
     */
    public Integer getRpid() {
        return rpid;
    }

    /**
     * 设置 红包券ID 字段:merchant_redpacket_use_record.rpId
     *
     * @param rpid the value for merchant_redpacket_use_record.rpId, 红包券ID
     */
    public void setRpid(Integer rpid) {
        this.rpid = rpid;
    }

    /**
     * 获取 关联商铺ID 字段:merchant_redpacket_use_record.shopId
     *
     * @return merchant_redpacket_use_record.shopId, 关联商铺ID
     */
    public Integer getShopid() {
        return shopid;
    }

    /**
     * 设置 关联商铺ID 字段:merchant_redpacket_use_record.shopId
     *
     * @param shopid the value for merchant_redpacket_use_record.shopId, 关联商铺ID
     */
    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    /**
     * 获取 使用时间 字段:merchant_redpacket_use_record.useTime
     *
     * @return merchant_redpacket_use_record.useTime, 使用时间
     */
    public Date getUsetime() {
        return usetime;
    }

    /**
     * 设置 使用时间 字段:merchant_redpacket_use_record.useTime
     *
     * @param usetime the value for merchant_redpacket_use_record.useTime, 使用时间
     */
    public void setUsetime(Date usetime) {
        this.usetime = usetime;
    }

    /**
     * 获取 使用金额 字段:merchant_redpacket_use_record.useMoney
     *
     * @return merchant_redpacket_use_record.useMoney, 使用金额
     */
    public Long getUsemoney() {
        return usemoney;
    }

    /**
     * 设置 使用金额 字段:merchant_redpacket_use_record.useMoney
     *
     * @param usemoney the value for merchant_redpacket_use_record.useMoney, 使用金额
     */
    public void setUsemoney(Long usemoney) {
        this.usemoney = usemoney;
    }

    /**
     * 获取 关联订单编号 字段:merchant_redpacket_use_record.orderNo
     *
     * @return merchant_redpacket_use_record.orderNo, 关联订单编号
     */
    public String getOrderno() {
        return orderno;
    }

    /**
     * 设置 关联订单编号 字段:merchant_redpacket_use_record.orderNo
     *
     * @param orderno the value for merchant_redpacket_use_record.orderNo, 关联订单编号
     */
    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }
}
