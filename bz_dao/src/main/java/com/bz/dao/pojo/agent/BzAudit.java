package com.bz.dao.pojo.agent;

import com.bz.framework.pojo.base.BasePojo;

/**
	* 作者:唐鹏
	* 描述:
	* 版本: version 1.0.0
	* 时间:2017-11-17 11:49:07
  */
public class BzAudit extends BasePojo {
    /**
     * id引用个人信息表
     * 表字段 : bz_audit.id
     */
    private Integer id;

    /**
     * 是否显示
     * 表字段 : bz_audit.isDelete
     */
    private Integer isdelete;

    /**
     * 
     * 表字段 : bz_audit.createTime
     */
    private String createtime;

    /**
     * 审核状态
     * 表字段 : bz_audit.state
     */
    private Integer state;

    /**
     * 通过时间
     * 表字段 : bz_audit.openTime
     */
    private String opentime;

    /**
     * 审核不通过理由
     * 表字段 : bz_audit.reason
     */
    private String reason;

    /**
     * 邀请码
     * 表字段 : bz_audit.inCode
     */
    private String incode;

    /**
     * 审核人
     * 表字段 : bz_audit.audit
     */
    private String audit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table bz_audit
     *
     * @mbg.generated Fri Nov 17 11:49:07 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取 id引用个人信息表 字段:bz_audit.id
     *
     * @return bz_audit.id, id引用个人信息表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 id引用个人信息表 字段:bz_audit.id
     *
     * @param id the value for bz_audit.id, id引用个人信息表
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 是否显示 字段:bz_audit.isDelete
     *
     * @return bz_audit.isDelete, 是否显示
     */
    public Integer getIsdelete() {
        return isdelete;
    }

    /**
     * 设置 是否显示 字段:bz_audit.isDelete
     *
     * @param isdelete the value for bz_audit.isDelete, 是否显示
     */
    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    /**
     * 获取  字段:bz_audit.createTime
     *
     * @return bz_audit.createTime, 
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * 设置  字段:bz_audit.createTime
     *
     * @param createtime the value for bz_audit.createTime, 
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取 审核状态 字段:bz_audit.state
     *
     * @return bz_audit.state, 审核状态
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置 审核状态 字段:bz_audit.state
     *
     * @param state the value for bz_audit.state, 审核状态
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取 通过时间 字段:bz_audit.openTime
     *
     * @return bz_audit.openTime, 通过时间
     */
    public String getOpentime() {
        return opentime;
    }

    /**
     * 设置 通过时间 字段:bz_audit.openTime
     *
     * @param opentime the value for bz_audit.openTime, 通过时间
     */
    public void setOpentime(String opentime) {
        this.opentime = opentime;
    }

    /**
     * 获取 审核不通过理由 字段:bz_audit.reason
     *
     * @return bz_audit.reason, 审核不通过理由
     */
    public String getReason() {
        return reason;
    }

    /**
     * 设置 审核不通过理由 字段:bz_audit.reason
     *
     * @param reason the value for bz_audit.reason, 审核不通过理由
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * 获取 邀请码 字段:bz_audit.inCode
     *
     * @return bz_audit.inCode, 邀请码
     */
    public String getIncode() {
        return incode;
    }

    /**
     * 设置 邀请码 字段:bz_audit.inCode
     *
     * @param incode the value for bz_audit.inCode, 邀请码
     */
    public void setIncode(String incode) {
        this.incode = incode;
    }

    /**
     * 获取 审核人 字段:bz_audit.audit
     *
     * @return bz_audit.audit, 审核人
     */
    public String getAudit() {
        return audit;
    }

    /**
     * 设置 审核人 字段:bz_audit.audit
     *
     * @param audit the value for bz_audit.audit, 审核人
     */
    public void setAudit(String audit) {
        this.audit = audit;
    }
}