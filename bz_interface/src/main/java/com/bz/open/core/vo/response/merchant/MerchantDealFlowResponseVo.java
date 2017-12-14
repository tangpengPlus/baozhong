package com.bz.open.core.vo.response.merchant;

import java.math.BigDecimal;
import java.util.Date;

import com.bz.framework.pojo.base.BasePojo;

/**
 * 
 * 作者: 兰俊
 * 描述:
 * 创建时间:2017年11月21日下午5:25:45
 * 修改备注:
 */
public class MerchantDealFlowResponseVo extends BasePojo {

	 /**
     * 店铺流水ID
     * 表字段 : merchant_deal_flow.id
     */
    private Integer id;

    /**
     * 关联店铺ID
     * 表字段 : merchant_deal_flow.shopId
     */
    private Integer shopid;

    /**
     * 流水创建时间
     * 表字段 : merchant_deal_flow.createTime
     */
    private Date createtime;

    /**
     * 关联用户ID
     * 表字段 : merchant_deal_flow.userId
     */
    private Integer userid;

    /**
     * 订单编号
     * 表字段 : merchant_deal_flow.orderNo
     */
    private String orderno;

    /**
     * 流水总额
     * 表字段 : merchant_deal_flow.flowMoney
     */
    private BigDecimal flowmoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table merchant_deal_flow
     *
     * @mbg.generated Tue Nov 21 17:23:31 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取 店铺流水ID 字段:merchant_deal_flow.id
     *
     * @return merchant_deal_flow.id, 店铺流水ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 店铺流水ID 字段:merchant_deal_flow.id
     *
     * @param id the value for merchant_deal_flow.id, 店铺流水ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 关联店铺ID 字段:merchant_deal_flow.shopId
     *
     * @return merchant_deal_flow.shopId, 关联店铺ID
     */
    public Integer getShopid() {
        return shopid;
    }

    /**
     * 设置 关联店铺ID 字段:merchant_deal_flow.shopId
     *
     * @param shopid the value for merchant_deal_flow.shopId, 关联店铺ID
     */
    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    /**
     * 获取 流水创建时间 字段:merchant_deal_flow.createTime
     *
     * @return merchant_deal_flow.createTime, 流水创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置 流水创建时间 字段:merchant_deal_flow.createTime
     *
     * @param createtime the value for merchant_deal_flow.createTime, 流水创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取 关联用户ID 字段:merchant_deal_flow.userId
     *
     * @return merchant_deal_flow.userId, 关联用户ID
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 设置 关联用户ID 字段:merchant_deal_flow.userId
     *
     * @param userid the value for merchant_deal_flow.userId, 关联用户ID
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 获取 订单编号 字段:merchant_deal_flow.orderNo
     *
     * @return merchant_deal_flow.orderNo, 订单编号
     */
    public String getOrderno() {
        return orderno;
    }

    /**
     * 设置 订单编号 字段:merchant_deal_flow.orderNo
     *
     * @param orderno the value for merchant_deal_flow.orderNo, 订单编号
     */
    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    /**
     * 获取 流水总额 字段:merchant_deal_flow.flowMoney
     *
     * @return merchant_deal_flow.flowMoney, 流水总额
     */
    public BigDecimal getFlowmoney() {
        return flowmoney;
    }

    /**
     * 设置 流水总额 字段:merchant_deal_flow.flowMoney
     *
     * @param flowmoney the value for merchant_deal_flow.flowMoney, 流水总额
     */
    public void setFlowmoney(BigDecimal flowmoney) {
        this.flowmoney = flowmoney;
    }
}