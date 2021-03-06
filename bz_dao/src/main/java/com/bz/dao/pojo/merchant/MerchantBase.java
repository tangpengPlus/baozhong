package com.bz.dao.pojo.merchant;

import com.bz.framework.pojo.base.BasePojo;
import java.util.Date;

/**
	* 作者:唐鹏
	* 描述:
	* 版本: version 1.0.0
	* 时间:2017-10-18 16:25:54
  */
public class MerchantBase extends BasePojo {
    /**
     * 商户ID
     * 表字段 : merchant_base.id
     */
    private Integer id;

    /**
     * 商户编号
     * 表字段 : merchant_base.number
     */
    private String number;

    /**
     * 商户名称
     * 表字段 : merchant_base.name
     */
    private String name;

    /**
     * 电话
     * 表字段 : merchant_base.phone
     */
    private String phone;

    /**
     * 法人名称
     * 表字段 : merchant_base.legalPerson
     */
    private String legalperson;

    /**
     * 
     * 表字段 : merchant_base.idcardImage
     */
    private String idcardimage;

    /**
     * 审核状态；0：待审核 ；1：审核通过 ;2：审核未通过 
     * 表字段 : merchant_base.isVerify
     */
    private Integer isverify;

    /**
     * 创建时间
     * 表字段 : merchant_base.createTime
     */
    private Date createtime;

    /**
     * 0:保留;1:删除
     * 表字段 : merchant_base.isDelete
     */
    private Integer isdelete;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table merchant_base
     *
     * @mbg.generated Wed Oct 18 16:25:54 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取 商户ID 字段:merchant_base.id
     *
     * @return merchant_base.id, 商户ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 商户ID 字段:merchant_base.id
     *
     * @param id the value for merchant_base.id, 商户ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 商户编号 字段:merchant_base.number
     *
     * @return merchant_base.number, 商户编号
     */
    public String getNumber() {
        return number;
    }

    /**
     * 设置 商户编号 字段:merchant_base.number
     *
     * @param number the value for merchant_base.number, 商户编号
     */
    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    /**
     * 获取 商户名称 字段:merchant_base.name
     *
     * @return merchant_base.name, 商户名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 商户名称 字段:merchant_base.name
     *
     * @param name the value for merchant_base.name, 商户名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取 电话 字段:merchant_base.phone
     *
     * @return merchant_base.phone, 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置 电话 字段:merchant_base.phone
     *
     * @param phone the value for merchant_base.phone, 电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取 法人名称 字段:merchant_base.legalPerson
     *
     * @return merchant_base.legalPerson, 法人名称
     */
    public String getLegalperson() {
        return legalperson;
    }

    /**
     * 设置 法人名称 字段:merchant_base.legalPerson
     *
     * @param legalperson the value for merchant_base.legalPerson, 法人名称
     */
    public void setLegalperson(String legalperson) {
        this.legalperson = legalperson == null ? null : legalperson.trim();
    }

    /**
     * 获取  字段:merchant_base.idcardImage
     *
     * @return merchant_base.idcardImage, 
     */
    public String getIdcardimage() {
        return idcardimage;
    }

    /**
     * 设置  字段:merchant_base.idcardImage
     *
     * @param idcardimage the value for merchant_base.idcardImage, 
     */
    public void setIdcardimage(String idcardimage) {
        this.idcardimage = idcardimage == null ? null : idcardimage.trim();
    }

    /**
     * 获取 审核状态；0：待审核 ；1：审核通过 ;2：审核未通过  字段:merchant_base.isVerify
     *
     * @return merchant_base.isVerify, 审核状态；0：待审核 ；1：审核通过 ;2：审核未通过 
     */
    public Integer getIsverify() {
        return isverify;
    }

    /**
     * 设置 审核状态；0：待审核 ；1：审核通过 ;2：审核未通过  字段:merchant_base.isVerify
     *
     * @param isverify the value for merchant_base.isVerify, 审核状态；0：待审核 ；1：审核通过 ;2：审核未通过 
     */
    public void setIsverify(Integer isverify) {
        this.isverify = isverify;
    }

    /**
     * 获取 创建时间 字段:merchant_base.createTime
     *
     * @return merchant_base.createTime, 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置 创建时间 字段:merchant_base.createTime
     *
     * @param createtime the value for merchant_base.createTime, 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取 0:保留;1:删除 字段:merchant_base.isDelete
     *
     * @return merchant_base.isDelete, 0:保留;1:删除
     */
    public Integer getIsdelete() {
        return isdelete;
    }

    /**
     * 设置 0:保留;1:删除 字段:merchant_base.isDelete
     *
     * @param isdelete the value for merchant_base.isDelete, 0:保留;1:删除
     */
    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}