package com.bz.dao.pojo.agent;

import com.bz.framework.pojo.base.BasePojo;

/**
	* 作者:唐鹏
	* 描述:
	* 版本: version 1.0.0
	* 时间:2017-11-17 12:01:35
  */
public class BzStoreAssociated extends BasePojo {
    /**
     * id
     * 表字段 : bz_store_associated.id
     */
    private Integer id;

    /**
     * 
     * 表字段 : bz_store_associated.userId
     */
    private String userid;

    /**
     * 店铺id
     * 表字段 : bz_store_associated.store
     */
    private String store;

    /**
     * 创建时间
     * 表字段 : bz_store_associated.createTime
     */
    private String createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table bz_store_associated
     *
     * @mbg.generated Fri Nov 17 12:01:35 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取 id 字段:bz_store_associated.id
     *
     * @return bz_store_associated.id, id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 id 字段:bz_store_associated.id
     *
     * @param id the value for bz_store_associated.id, id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取  字段:bz_store_associated.userId
     *
     * @return bz_store_associated.userId, 
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置  字段:bz_store_associated.userId
     *
     * @param userid the value for bz_store_associated.userId, 
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 获取 店铺id 字段:bz_store_associated.store
     *
     * @return bz_store_associated.store, 店铺id
     */
    public String getStore() {
        return store;
    }

    /**
     * 设置 店铺id 字段:bz_store_associated.store
     *
     * @param store the value for bz_store_associated.store, 店铺id
     */
    public void setStore(String store) {
        this.store = store;
    }

    /**
     * 获取 创建时间 字段:bz_store_associated.createTime
     *
     * @return bz_store_associated.createTime, 创建时间
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * 设置 创建时间 字段:bz_store_associated.createTime
     *
     * @param createtime the value for bz_store_associated.createTime, 创建时间
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}