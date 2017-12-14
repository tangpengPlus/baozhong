package com.bz.open.core.vo.response.order;

import java.math.BigDecimal;
import java.util.Date;

import com.bz.framework.pojo.base.BasePojo;

/**
* @ClassName: UserOrderResponseVo 
* @Description: TODO(用户订单响应类) 
* @author 胡竞
* @date 2017年11月27日 上午10:18:59 
*
 */
public class UserOrderResponseVo extends BasePojo{
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -2869565958073309361L;

	/**
     * 订单ID
     * 表字段 : order_base.id
     */
    private Integer id;

    /**
     * 订单编号
     * 表字段 : order_base.orderNo
     */
    private String orderno;

    /**
     * 订单关联用户ID
     * 表字段 : order_base.userId
     */
    private Integer userid;

    /**
     * 订单关联店铺ID
     * 表字段 : order_base.shopId
     */
    private Integer shopid;

    /**
     * 订单总额
     * 表字段 : order_base.tatolMoney
     */
    private String tatolmoney;

    /**
     * 线上支付总额
     * 表字段 : order_base.onlinePayMoney
     */
    private BigDecimal onlinepaymoney;

    /**
     * 线下付款总额
     * 表字段 : order_base.offlinePayMoney
     */
    private BigDecimal offlinepaymoney;

    /**
     * 活动抵用总额
     * 表字段 : order_base.activityPayMoney
     */
    private BigDecimal activitypaymoney;

    /**
     * 积分抵用总额
     * 表字段 : order_base.integralPayMoney
     */
    private BigDecimal integralpaymoney;

    /**
     * 支付状态;0:未支付；1:支付成功;2:支付失败;3:支付超时
     * 表字段 : order_base.payState
     */
    private Integer paystate;

    /**
     * 支付方式；1：微信支付；2：支付宝支付；3：混合支付；
     * 表字段 : order_base.payWay
     */
    private Integer payway;

    /**
     * 支付结果回调时间
     * 表字段 : order_base.callBackTime
     */
    private Date callbacktime;

    /**
     * 支付备注
     * 表字段 : order_base.payRemark
     */
    private String payremark;

    /**
     * 订单创建时间
     * 表字段 : order_base.createTime
     */
    private Date createtime;

    /**
     * 是否隐藏；0：展示；1：隐藏
     * 表字段 : order_base.isShow
     */
    private Integer isshow;

    /**
     * 订单类型;1：扫码订单；2网店订单
     * 表字段 : order_base.orderType
     */
    private Integer ordertype;

    /**
     * 二维码地址
     * 表字段 : order_base.qrCodeLink
     */
    private String qrcodelink;

    /**
     * 客户端IP
     * 表字段 : order_base.clientIp
     */
    private String clientip;
    
    /**
     * 店铺名称
     */
    private String merchantName;

    /**
	 * @return the merchantName
	 */
	public String getMerchantName() {
		return merchantName;
	}

	/**
	 * @param merchantName the merchantName to set
	 */
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	/**
     * 获取 订单ID 字段:order_base.id
     *
     * @return order_base.id, 订单ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 订单ID 字段:order_base.id
     *
     * @param id the value for order_base.id, 订单ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 订单编号 字段:order_base.orderNo
     *
     * @return order_base.orderNo, 订单编号
     */
    public String getOrderno() {
        return orderno;
    }

    /**
     * 设置 订单编号 字段:order_base.orderNo
     *
     * @param orderno the value for order_base.orderNo, 订单编号
     */
    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    /**
     * 获取 订单关联用户ID 字段:order_base.userId
     *
     * @return order_base.userId, 订单关联用户ID
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 设置 订单关联用户ID 字段:order_base.userId
     *
     * @param userid the value for order_base.userId, 订单关联用户ID
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 获取 订单关联店铺ID 字段:order_base.shopId
     *
     * @return order_base.shopId, 订单关联店铺ID
     */
    public Integer getShopid() {
        return shopid;
    }

    /**
     * 设置 订单关联店铺ID 字段:order_base.shopId
     *
     * @param shopid the value for order_base.shopId, 订单关联店铺ID
     */
    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

	/**
	 * @return the tatolmoney
	 */
	public String getTatolmoney() {
		return tatolmoney;
	}

	/**
	 * @param tatolmoney the tatolmoney to set
	 */
	public void setTatolmoney(String tatolmoney) {
		this.tatolmoney = tatolmoney;
	}

	/**
	 * @return the onlinepaymoney
	 */
	public BigDecimal getOnlinepaymoney() {
		return onlinepaymoney;
	}

	/**
	 * @param onlinepaymoney the onlinepaymoney to set
	 */
	public void setOnlinepaymoney(BigDecimal onlinepaymoney) {
		this.onlinepaymoney = onlinepaymoney;
	}

	/**
	 * @return the offlinepaymoney
	 */
	public BigDecimal getOfflinepaymoney() {
		return offlinepaymoney;
	}

	/**
	 * @param offlinepaymoney the offlinepaymoney to set
	 */
	public void setOfflinepaymoney(BigDecimal offlinepaymoney) {
		this.offlinepaymoney = offlinepaymoney;
	}

	/**
	 * @return the activitypaymoney
	 */
	public BigDecimal getActivitypaymoney() {
		return activitypaymoney;
	}

	/**
	 * @param activitypaymoney the activitypaymoney to set
	 */
	public void setActivitypaymoney(BigDecimal activitypaymoney) {
		this.activitypaymoney = activitypaymoney;
	}

	/**
	 * @return the integralpaymoney
	 */
	public BigDecimal getIntegralpaymoney() {
		return integralpaymoney;
	}

	/**
	 * @param integralpaymoney the integralpaymoney to set
	 */
	public void setIntegralpaymoney(BigDecimal integralpaymoney) {
		this.integralpaymoney = integralpaymoney;
	}

	/**
     * 获取 支付状态;0:未支付；1:支付成功;2:支付失败;3:支付超时 字段:order_base.payState
     *
     * @return order_base.payState, 支付状态;0:未支付；1:支付成功;2:支付失败;3:支付超时
     */
    public Integer getPaystate() {
        return paystate;
    }

    /**
     * 设置 支付状态;0:未支付；1:支付成功;2:支付失败;3:支付超时 字段:order_base.payState
     *
     * @param paystate the value for order_base.payState, 支付状态;0:未支付；1:支付成功;2:支付失败;3:支付超时
     */
    public void setPaystate(Integer paystate) {
        this.paystate = paystate;
    }

    /**
     * 获取 支付方式；1：微信支付；2：支付宝支付；3：混合支付； 字段:order_base.payWay
     *
     * @return order_base.payWay, 支付方式；1：微信支付；2：支付宝支付；3：混合支付；
     */
    public Integer getPayway() {
        return payway;
    }

    /**
     * 设置 支付方式；1：微信支付；2：支付宝支付；3：混合支付； 字段:order_base.payWay
     *
     * @param payway the value for order_base.payWay, 支付方式；1：微信支付；2：支付宝支付；3：混合支付；
     */
    public void setPayway(Integer payway) {
        this.payway = payway;
    }

    /**
     * 获取 支付结果回调时间 字段:order_base.callBackTime
     *
     * @return order_base.callBackTime, 支付结果回调时间
     */
    public Date getCallbacktime() {
        return callbacktime;
    }

    /**
     * 设置 支付结果回调时间 字段:order_base.callBackTime
     *
     * @param callbacktime the value for order_base.callBackTime, 支付结果回调时间
     */
    public void setCallbacktime(Date callbacktime) {
        this.callbacktime = callbacktime;
    }

    /**
     * 获取 支付备注 字段:order_base.payRemark
     *
     * @return order_base.payRemark, 支付备注
     */
    public String getPayremark() {
        return payremark;
    }

    /**
     * 设置 支付备注 字段:order_base.payRemark
     *
     * @param payremark the value for order_base.payRemark, 支付备注
     */
    public void setPayremark(String payremark) {
        this.payremark = payremark == null ? null : payremark.trim();
    }

    /**
     * 获取 订单创建时间 字段:order_base.createTime
     *
     * @return order_base.createTime, 订单创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置 订单创建时间 字段:order_base.createTime
     *
     * @param createtime the value for order_base.createTime, 订单创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取 是否隐藏；0：展示；1：隐藏 字段:order_base.isShow
     *
     * @return order_base.isShow, 是否隐藏；0：展示；1：隐藏
     */
    public Integer getIsshow() {
        return isshow;
    }

    /**
     * 设置 是否隐藏；0：展示；1：隐藏 字段:order_base.isShow
     *
     * @param isshow the value for order_base.isShow, 是否隐藏；0：展示；1：隐藏
     */
    public void setIsshow(Integer isshow) {
        this.isshow = isshow;
    }

    /**
     * 获取 订单类型;1：扫码订单；2网店订单 字段:order_base.orderType
     *
     * @return order_base.orderType, 订单类型;1：扫码订单；2网店订单
     */
    public Integer getOrdertype() {
        return ordertype;
    }

    /**
     * 设置 订单类型;1：扫码订单；2网店订单 字段:order_base.orderType
     *
     * @param ordertype the value for order_base.orderType, 订单类型;1：扫码订单；2网店订单
     */
    public void setOrdertype(Integer ordertype) {
        this.ordertype = ordertype;
    }

    /**
     * 获取 二维码地址 字段:order_base.qrCodeLink
     *
     * @return order_base.qrCodeLink, 二维码地址
     */
    public String getQrcodelink() {
        return qrcodelink;
    }

    /**
     * 设置 二维码地址 字段:order_base.qrCodeLink
     *
     * @param qrcodelink the value for order_base.qrCodeLink, 二维码地址
     */
    public void setQrcodelink(String qrcodelink) {
        this.qrcodelink = qrcodelink == null ? null : qrcodelink.trim();
    }

    /**
     * 获取 客户端IP 字段:order_base.clientIp
     *
     * @return order_base.clientIp, 客户端IP
     */
    public String getClientip() {
        return clientip;
    }

    /**
     * 设置 客户端IP 字段:order_base.clientIp
     *
     * @param clientip the value for order_base.clientIp, 客户端IP
     */
    public void setClientip(String clientip) {
        this.clientip = clientip == null ? null : clientip.trim();
    }
}
