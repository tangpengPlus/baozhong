package com.bz.open.core.vo.response.merchant;

import java.util.Date;

import com.bz.framework.pojo.base.BasePojo;
/**
 *  作者:唐鹏
 *  描述:商家基础信息封装
 *  备注:
 *  创建时间:2017年11月15日下午6:15:54
 */
public class MerchantInfoResponseVo extends BasePojo{


	private static final long serialVersionUID = -5564177881125870141L;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLegalperson() {
		return legalperson;
	}

	public void setLegalperson(String legalperson) {
		this.legalperson = legalperson;
	}

	public String getIdcardimage() {
		return idcardimage;
	}

	public void setIdcardimage(String idcardimage) {
		this.idcardimage = idcardimage;
	}

	public Integer getIsverify() {
		return isverify;
	}

	public void setIsverify(Integer isverify) {
		this.isverify = isverify;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Integer getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}
    
    
	
}
