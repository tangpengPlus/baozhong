package com.bz.open.core.vo.request.user;

import java.math.BigDecimal;
import java.util.Date;

import com.bz.framework.pojo.base.BasePojo;

/**
* @ClassName: UserRedpacketWareHouseVo 
* @Description: TODO(用户红包券请求参数类) 
* @author 胡竞
* @date 2017年11月14日 下午7:23:47 
*
 */
public class UserRedpacketWareHouseRequestVo extends BasePojo{

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;

	/**
     * 用户红包ID
     * 表字段 : user_redpacket_warehouse.id
     */
    private Integer id;

    /**
     * 用户ID
     * 表字段 : user_redpacket_warehouse.userId
     */
    private Integer userid;
    
    /**
     * 红包券关联商家ID
     */
    private Integer merchantid;

    /**
	 * @return the merchantid
	 */
	public Integer getMerchantid() {
		return merchantid;
	}

	/**
	 * @param merchantid the merchantid to set
	 */
	public void setMerchantid(Integer merchantid) {
		this.merchantid = merchantid;
	}

	/**
     * 红包金额
     * 表字段 : user_redpacket_warehouse.rpMoney
     */
    private BigDecimal rpmoney;

    /**
     * 关联红包券ID
     * 表字段 : user_redpacket_warehouse.rpId
     */
    private Integer rpid;
    
	/**
     * 关联订单编号
     * 表字段 : user_redpacket_warehouse.orderNumber
     */
    private String ordernumber;

    /**
     * 0:未使用 1：使用中 2.已使用
     * 表字段 : user_redpacket_warehouse.isUse
     */
    private Integer isuse;

    /**
     * 红包获取时间
     * 表字段 : user_redpacket_warehouse.createTime
     */
    private Date createtime;

    /**
     * 到期时间
     * 表字段 : user_redpacket_warehouse.endTime
     */
    private Date endtime;

    /**
     * 获取 用户红包ID 字段:user_redpacket_warehouse.id
     *
     * @return user_redpacket_warehouse.id, 用户红包ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 用户红包ID 字段:user_redpacket_warehouse.id
     *
     * @param id the value for user_redpacket_warehouse.id, 用户红包ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 用户ID 字段:user_redpacket_warehouse.userId
     *
     * @return user_redpacket_warehouse.userId, 用户ID
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 设置 用户ID 字段:user_redpacket_warehouse.userId
     *
     * @param userid the value for user_redpacket_warehouse.userId, 用户ID
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 获取 红包金额 字段:user_redpacket_warehouse.rpMoney
     *
     * @return user_redpacket_warehouse.rpMoney, 红包金额
     */
    public BigDecimal getRpmoney() {
        return rpmoney;
    }

    /**
     * 设置 红包金额 字段:user_redpacket_warehouse.rpMoney
     *
     * @param rpmoney the value for user_redpacket_warehouse.rpMoney, 红包金额
     */
    public void setRpmoney(BigDecimal rpmoney) {
        this.rpmoney = rpmoney;
    }

    /**
     * 获取 关联红包券ID 字段:user_redpacket_warehouse.rpId
     *
     * @return user_redpacket_warehouse.rpId, 关联红包券ID
     */
    public Integer getRpid() {
        return rpid;
    }

    /**
     * 设置 关联红包券ID 字段:user_redpacket_warehouse.rpId
     *
     * @param rpid the value for user_redpacket_warehouse.rpId, 关联红包券ID
     */
    public void setRpid(Integer rpid) {
        this.rpid = rpid;
    }

    /**
     * 获取 关联订单编号 字段:user_redpacket_warehouse.orderNumber
     *
     * @return user_redpacket_warehouse.orderNumber, 关联订单编号
     */
    public String getOrdernumber() {
        return ordernumber;
    }

    /**
     * 设置 关联订单编号 字段:user_redpacket_warehouse.orderNumber
     *
     * @param ordernumber the value for user_redpacket_warehouse.orderNumber, 关联订单编号
     */
    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }

    /**
     * 获取 0:未使用 1：使用中 2.已使用 字段:user_redpacket_warehouse.isUse
     *
     * @return user_redpacket_warehouse.isUse, 0:未使用 1：使用中 2.已使用
     */
    public Integer getIsuse() {
        return isuse;
    }

    /**
     * 设置 0:未使用 1：使用中 2.已使用 字段:user_redpacket_warehouse.isUse
     *
     * @param isuse the value for user_redpacket_warehouse.isUse, 0:未使用 1：使用中 2.已使用
     */
    public void setIsuse(Integer isuse) {
        this.isuse = isuse;
    }

    /**
     * 获取 红包获取时间 字段:user_redpacket_warehouse.createTime
     *
     * @return user_redpacket_warehouse.createTime, 红包获取时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置 红包获取时间 字段:user_redpacket_warehouse.createTime
     *
     * @param createtime the value for user_redpacket_warehouse.createTime, 红包获取时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取 到期时间 字段:user_redpacket_warehouse.endTime
     *
     * @return user_redpacket_warehouse.endTime, 到期时间
     */
    public Date getEndtime() {
        return endtime;
    }

    /**
     * 设置 到期时间 字段:user_redpacket_warehouse.endTime
     *
     * @param endtime the value for user_redpacket_warehouse.endTime, 到期时间
     */
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}
