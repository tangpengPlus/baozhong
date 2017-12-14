package com.bz.dao.pojo.merchant;

import com.bz.framework.pojo.base.BasePojo;
import java.util.Date;

/**
	* 作者:唐鹏
	* 描述:
	* 版本: version 1.0.0
	* 时间:2017-11-02 18:08:25
  */
public class MerchantUserRecord extends BasePojo {
    /**
     * 店铺会员ID
     * 表字段 : merchant_user_record.id
     */
    private Integer id;

    /**
     * 关联用户ID
     * 表字段 : merchant_user_record.userId
     */
    private Integer userid;

    /**
     * 关联商铺ID
     * 表字段 : merchant_user_record.shopId
     */
    private Integer shopid;

    /**
     * 创建时间
     * 表字段 : merchant_user_record.createTime
     */
    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table merchant_user_record
     *
     * @mbg.generated Thu Nov 02 18:08:25 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取 店铺会员ID 字段:merchant_user_record.id
     *
     * @return merchant_user_record.id, 店铺会员ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 店铺会员ID 字段:merchant_user_record.id
     *
     * @param id the value for merchant_user_record.id, 店铺会员ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 关联用户ID 字段:merchant_user_record.userId
     *
     * @return merchant_user_record.userId, 关联用户ID
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 设置 关联用户ID 字段:merchant_user_record.userId
     *
     * @param userid the value for merchant_user_record.userId, 关联用户ID
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 获取 关联商铺ID 字段:merchant_user_record.shopId
     *
     * @return merchant_user_record.shopId, 关联商铺ID
     */
    public Integer getShopid() {
        return shopid;
    }

    /**
     * 设置 关联商铺ID 字段:merchant_user_record.shopId
     *
     * @param shopid the value for merchant_user_record.shopId, 关联商铺ID
     */
    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    /**
     * 获取 创建时间 字段:merchant_user_record.createTime
     *
     * @return merchant_user_record.createTime, 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置 创建时间 字段:merchant_user_record.createTime
     *
     * @param createtime the value for merchant_user_record.createTime, 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}