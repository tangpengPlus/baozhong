package com.bz.open.core.vo.response.user;

import java.math.BigDecimal;
import java.util.Date;

import com.bz.framework.pojo.base.BasePojo;

/**
* 作者:胡竞
* 描述: 用户红包使用响应参数类
* 版本: version 1.0.0
* 时间:2017-11-01 14:06:11
*/
public class UserRedpacketUserecordResponseVo extends BasePojo{
	 /** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 5965253317972869444L;

	/**
     * 用户红包使用记录ID
     * 表字段 : user_redpacket_userecord.id
     */
    private Integer id;

    /**
     * 关联用户ID
     * 表字段 : user_redpacket_userecord.userId
     */
    private Integer userid;

    /**
     * 关联红包券ID
     * 表字段 : user_redpacket_userecord.rpId
     */
    private Integer rpid;

    /**
     * 使用金额
     * 表字段 : user_redpacket_userecord.useMoney
     */
    private BigDecimal usemoney;

    /**
     * 使用时间
     * 表字段 : user_redpacket_userecord.useTime
     */
    private Date usetime;

    /**
     * 关联订单编号
     * 表字段 : user_redpacket_userecord.orderNo
     */
    private String orderno;

    /**
     * 获取 用户红包使用记录ID 字段:user_redpacket_userecord.id
     *
     * @return user_redpacket_userecord.id, 用户红包使用记录ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 用户红包使用记录ID 字段:user_redpacket_userecord.id
     *
     * @param id the value for user_redpacket_userecord.id, 用户红包使用记录ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 关联用户ID 字段:user_redpacket_userecord.userId
     *
     * @return user_redpacket_userecord.userId, 关联用户ID
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 设置 关联用户ID 字段:user_redpacket_userecord.userId
     *
     * @param userid the value for user_redpacket_userecord.userId, 关联用户ID
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 获取 关联红包券ID 字段:user_redpacket_userecord.rpId
     *
     * @return user_redpacket_userecord.rpId, 关联红包券ID
     */
    public Integer getRpid() {
        return rpid;
    }

    /**
     * 设置 关联红包券ID 字段:user_redpacket_userecord.rpId
     *
     * @param rpid the value for user_redpacket_userecord.rpId, 关联红包券ID
     */
    public void setRpid(Integer rpid) {
        this.rpid = rpid;
    }

    /**
     * 获取 使用金额 字段:user_redpacket_userecord.useMoney
     *
     * @return user_redpacket_userecord.useMoney, 使用金额
     */
    public BigDecimal getUsemoney() {
        return usemoney;
    }

    /**
     * 设置 使用金额 字段:user_redpacket_userecord.useMoney
     *
     * @param usemoney the value for user_redpacket_userecord.useMoney, 使用金额
     */
    public void setUsemoney(BigDecimal usemoney) {
        this.usemoney = usemoney;
    }

    /**
     * 获取 使用时间 字段:user_redpacket_userecord.useTime
     *
     * @return user_redpacket_userecord.useTime, 使用时间
     */
    public Date getUsetime() {
        return usetime;
    }

    /**
     * 设置 使用时间 字段:user_redpacket_userecord.useTime
     *
     * @param usetime the value for user_redpacket_userecord.useTime, 使用时间
     */
    public void setUsetime(Date usetime) {
        this.usetime = usetime;
    }

    /**
     * 获取 关联订单编号 字段:user_redpacket_userecord.orderNo
     *
     * @return user_redpacket_userecord.orderNo, 关联订单编号
     */
    public String getOrderno() {
        return orderno;
    }

    /**
     * 设置 关联订单编号 字段:user_redpacket_userecord.orderNo
     *
     * @param orderno the value for user_redpacket_userecord.orderNo, 关联订单编号
     */
    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }
}
