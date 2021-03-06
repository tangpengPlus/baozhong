package com.bz.open.core.vo.response.merchant;

import java.math.BigDecimal;
import java.util.Date;

import com.bz.framework.pojo.base.BasePojo;

public class MerchantRedpacketSettingResponseVo extends BasePojo{

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;

	/**
     * 红包ID
     * 表字段 : merchant_redpacket_setting.id
     */
    private Integer id;

    /**
     * 红包编号
     * 表字段 : merchant_redpacket_setting.rpNo
     */
    private String rpno;

    /**
     * 商户Id
     * 表字段 : merchant_redpacket_setting.merchantId
     */
    private Integer merchantid;

    /**
     * 开启红包功能;0:开启;1:未开启
     * 表字段 : merchant_redpacket_setting.isStart
     */
    private Integer isstart;

    /**
     * 红包券满足最小金额能够使用
     * 表字段: merchant_redpacket_setting.fulfilMoney
     */
    private String fulfilmoney;
    
	/**
	 * @return the fulfilmoney
	 */
	public String getFulfilmoney() {
		return fulfilmoney;
	}

	/**
	 * @param fulfilmoney the fulfilmoney to set
	 */
	public void setFulfilmoney(String fulfilmoney) {
		this.fulfilmoney = fulfilmoney;
	}

	/**
     * 红包金额最大值
     * 表字段 : merchant_redpacket_setting.rpMoney
     */
    private String rpmoney;

    /**
     * 红包有效期
     * 表字段 : merchant_redpacket_setting.termOfValidity
     */
    private Integer termofvalidity;

    /**
     * 老用户红包发放比例
     * 表字段 : merchant_redpacket_setting.oldUserProportion
     */
    private Double olduserproportion;

    /**
     * 新用户红包发放比例
     * 表字段 : merchant_redpacket_setting.newUserProportion
     */
    private Double newuserproportion;

    /**
     * 创建时间
     * 表字段 : merchant_redpacket_setting.createTime
     */
    private Date createtime;

    /**
     * 是否删除；0:保留;1：删除
     * 表字段 : merchant_redpacket_setting.isDelete
     */
    private Integer isdelete;

    /**
     * 获取 红包ID 字段:merchant_redpacket_setting.id
     *
     * @return merchant_redpacket_setting.id, 红包ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 红包ID 字段:merchant_redpacket_setting.id
     *
     * @param id the value for merchant_redpacket_setting.id, 红包ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 红包编号 字段:merchant_redpacket_setting.rpNo
     *
     * @return merchant_redpacket_setting.rpNo, 红包编号
     */
    public String getRpno() {
        return rpno;
    }

    /**
     * 设置 红包编号 字段:merchant_redpacket_setting.rpNo
     *
     * @param rpno the value for merchant_redpacket_setting.rpNo, 红包编号
     */
    public void setRpno(String rpno) {
        this.rpno = rpno == null ? null : rpno.trim();
    }

    /**
     * 获取 商户Id 字段:merchant_redpacket_setting.merchantId
     *
     * @return merchant_redpacket_setting.merchantId, 商户Id
     */
    public Integer getMerchantid() {
        return merchantid;
    }

    /**
     * 设置 商户Id 字段:merchant_redpacket_setting.merchantId
     *
     * @param merchantid the value for merchant_redpacket_setting.merchantId, 商户Id
     */
    public void setMerchantid(Integer merchantid) {
        this.merchantid = merchantid;
    }

    /**
     * 获取 开启红包功能;0:开启;1:未开启 字段:merchant_redpacket_setting.isStart
     *
     * @return merchant_redpacket_setting.isStart, 开启红包功能;0:开启;1:未开启
     */
    public Integer getIsstart() {
        return isstart;
    }

    /**
     * 设置 开启红包功能;0:开启;1:未开启 字段:merchant_redpacket_setting.isStart
     *
     * @param isstart the value for merchant_redpacket_setting.isStart, 开启红包功能;0:开启;1:未开启
     */
    public void setIsstart(Integer isstart) {
        this.isstart = isstart;
    }

    /**
     * 获取 红包金额最大值 字段:merchant_redpacket_setting.rpMoney
     *
     * @return merchant_redpacket_setting.rpMoney, 红包金额最大值
     */
    public String getRpmoney() {
        return rpmoney;
    }

    /**
     * 设置 红包金额最大值 字段:merchant_redpacket_setting.rpMoney
     *
     * @param rpmoney the value for merchant_redpacket_setting.rpMoney, 红包金额最大值
     */
    public void setRpmoney(String rpmoney) {
        this.rpmoney = rpmoney;
    }

    /**
     * 获取 红包有效期 字段:merchant_redpacket_setting.termOfValidity
     *
     * @return merchant_redpacket_setting.termOfValidity, 红包有效期
     */
    public Integer getTermofvalidity() {
        return termofvalidity;
    }

    /**
     * 设置 红包有效期 字段:merchant_redpacket_setting.termOfValidity
     *
     * @param termofvalidity the value for merchant_redpacket_setting.termOfValidity, 红包有效期
     */
    public void setTermofvalidity(Integer termofvalidity) {
        this.termofvalidity = termofvalidity;
    }

    /**
     * 获取 老用户红包发放比例 字段:merchant_redpacket_setting.oldUserProportion
     *
     * @return merchant_redpacket_setting.oldUserProportion, 老用户红包发放比例
     */
    public Double getOlduserproportion() {
        return olduserproportion;
    }

    /**
     * 设置 老用户红包发放比例 字段:merchant_redpacket_setting.oldUserProportion
     *
     * @param olduserproportion the value for merchant_redpacket_setting.oldUserProportion, 老用户红包发放比例
     */
    public void setOlduserproportion(Double olduserproportion) {
        this.olduserproportion = olduserproportion;
    }

    /**
     * 获取 新用户红包发放比例 字段:merchant_redpacket_setting.newUserProportion
     *
     * @return merchant_redpacket_setting.newUserProportion, 新用户红包发放比例
     */
    public Double getNewuserproportion() {
        return newuserproportion;
    }

    /**
     * 设置 新用户红包发放比例 字段:merchant_redpacket_setting.newUserProportion
     *
     * @param newuserproportion the value for merchant_redpacket_setting.newUserProportion, 新用户红包发放比例
     */
    public void setNewuserproportion(Double newuserproportion) {
        this.newuserproportion = newuserproportion;
    }

    /**
     * 获取 创建时间 字段:merchant_redpacket_setting.createTime
     *
     * @return merchant_redpacket_setting.createTime, 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置 创建时间 字段:merchant_redpacket_setting.createTime
     *
     * @param createtime the value for merchant_redpacket_setting.createTime, 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取 是否删除；0:保留;1：删除 字段:merchant_redpacket_setting.isDelete
     *
     * @return merchant_redpacket_setting.isDelete, 是否删除；0:保留;1：删除
     */
    public Integer getIsdelete() {
        return isdelete;
    }

    /**
     * 设置 是否删除；0:保留;1：删除 字段:merchant_redpacket_setting.isDelete
     *
     * @param isdelete the value for merchant_redpacket_setting.isDelete, 是否删除；0:保留;1：删除
     */
    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}
