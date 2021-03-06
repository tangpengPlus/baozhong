package com.bz.dao.pojo.user;

import com.bz.framework.pojo.base.BasePojo;
import java.math.BigDecimal;
import java.util.Date;

/**
	* 作者:唐鹏
	* 描述:
	* 版本: version 1.0.0
	* 时间:2017-11-01 14:05:37
  */
public class UserDealFlow extends BasePojo {
    /**
     * 用户支付记录ID
     * 表字段 : user_deal_flow.id
     */
    private Integer id;

    /**
     * 关联订单编号
     * 表字段 : user_deal_flow.orderNo
     */
    private String orderno;

    /**
     * 关联二维码编号
     * 表字段 : user_deal_flow.qrCodeNo
     */
    private String qrcodeno;

    /**
     * 关联用户ID
     * 表字段 : user_deal_flow.userId
     */
    private Integer userid;

    /**
     * 用户扫码总额
     * 表字段 : user_deal_flow.scanMoney
     */
    private BigDecimal scanmoney;

    /**
     * 交易状态；0：交易完成；1：交易失败；2：交易超时
     * 表字段 : user_deal_flow.dealState
     */
    private Integer dealstate;

    /**
     * 关联店铺ID
     * 表字段 : user_deal_flow.shopId
     */
    private Integer shopid;

    /**
     * 交易类型;1:扫码支付;2:网店支付;
     * 表字段 : user_deal_flow.dealType
     */
    private Integer dealtype;

    /**
     * 交易时间
     * 表字段 : user_deal_flow.dealTime
     */
    private Date dealtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_deal_flow
     *
     * @mbg.generated Wed Nov 01 14:05:37 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取 用户支付记录ID 字段:user_deal_flow.id
     *
     * @return user_deal_flow.id, 用户支付记录ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 用户支付记录ID 字段:user_deal_flow.id
     *
     * @param id the value for user_deal_flow.id, 用户支付记录ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 关联订单编号 字段:user_deal_flow.orderNo
     *
     * @return user_deal_flow.orderNo, 关联订单编号
     */
    public String getOrderno() {
        return orderno;
    }

    /**
     * 设置 关联订单编号 字段:user_deal_flow.orderNo
     *
     * @param orderno the value for user_deal_flow.orderNo, 关联订单编号
     */
    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    /**
     * 获取 关联二维码编号 字段:user_deal_flow.qrCodeNo
     *
     * @return user_deal_flow.qrCodeNo, 关联二维码编号
     */
    public String getQrcodeno() {
        return qrcodeno;
    }

    /**
     * 设置 关联二维码编号 字段:user_deal_flow.qrCodeNo
     *
     * @param qrcodeno the value for user_deal_flow.qrCodeNo, 关联二维码编号
     */
    public void setQrcodeno(String qrcodeno) {
        this.qrcodeno = qrcodeno == null ? null : qrcodeno.trim();
    }

    /**
     * 获取 关联用户ID 字段:user_deal_flow.userId
     *
     * @return user_deal_flow.userId, 关联用户ID
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 设置 关联用户ID 字段:user_deal_flow.userId
     *
     * @param userid the value for user_deal_flow.userId, 关联用户ID
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 获取 用户扫码总额 字段:user_deal_flow.scanMoney
     *
     * @return user_deal_flow.scanMoney, 用户扫码总额
     */
    public BigDecimal getScanmoney() {
        return scanmoney;
    }

    /**
     * 设置 用户扫码总额 字段:user_deal_flow.scanMoney
     *
     * @param scanmoney the value for user_deal_flow.scanMoney, 用户扫码总额
     */
    public void setScanmoney(BigDecimal scanmoney) {
        this.scanmoney = scanmoney;
    }

    /**
     * 获取 交易状态；0：交易完成；1：交易失败；2：交易超时 字段:user_deal_flow.dealState
     *
     * @return user_deal_flow.dealState, 交易状态；0：交易完成；1：交易失败；2：交易超时
     */
    public Integer getDealstate() {
        return dealstate;
    }

    /**
     * 设置 交易状态；0：交易完成；1：交易失败；2：交易超时 字段:user_deal_flow.dealState
     *
     * @param dealstate the value for user_deal_flow.dealState, 交易状态；0：交易完成；1：交易失败；2：交易超时
     */
    public void setDealstate(Integer dealstate) {
        this.dealstate = dealstate;
    }

    /**
     * 获取 关联店铺ID 字段:user_deal_flow.shopId
     *
     * @return user_deal_flow.shopId, 关联店铺ID
     */
    public Integer getShopid() {
        return shopid;
    }

    /**
     * 设置 关联店铺ID 字段:user_deal_flow.shopId
     *
     * @param shopid the value for user_deal_flow.shopId, 关联店铺ID
     */
    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    /**
     * 获取 交易类型;1:扫码支付;2:网店支付; 字段:user_deal_flow.dealType
     *
     * @return user_deal_flow.dealType, 交易类型;1:扫码支付;2:网店支付;
     */
    public Integer getDealtype() {
        return dealtype;
    }

    /**
     * 设置 交易类型;1:扫码支付;2:网店支付; 字段:user_deal_flow.dealType
     *
     * @param dealtype the value for user_deal_flow.dealType, 交易类型;1:扫码支付;2:网店支付;
     */
    public void setDealtype(Integer dealtype) {
        this.dealtype = dealtype;
    }

    /**
     * 获取 交易时间 字段:user_deal_flow.dealTime
     *
     * @return user_deal_flow.dealTime, 交易时间
     */
    public Date getDealtime() {
        return dealtime;
    }

    /**
     * 设置 交易时间 字段:user_deal_flow.dealTime
     *
     * @param dealtime the value for user_deal_flow.dealTime, 交易时间
     */
    public void setDealtime(Date dealtime) {
        this.dealtime = dealtime;
    }
}