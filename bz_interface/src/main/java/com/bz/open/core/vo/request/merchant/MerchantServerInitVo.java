package com.bz.open.core.vo.request.merchant;

import java.util.Date;

import com.bz.framework.pojo.base.BasePojo;

/**
 * 
 * 作者: 彭云山
 * 描述:商家开启服务状态
 * 创建时间:2017年11月13日下午2:40:46
 * 修改备注:
 */
public class MerchantServerInitVo extends BasePojo{

	
	private static final long serialVersionUID = 1452905108208559753L;

	/**
     * 添加数据的id
     * 表字段 : merchant_open_status.id
     */
    private Integer id;

    /**
     * 添加数据的编号
     * 表字段 : merchant_open_status.number
     */
    private String number;

    /**
     * 关联商户编号
     * 表字段 : merchant_open_status.merchant_id
     */
    private Integer merchantId;

    /**
     * 创建时间
     * 表字段 : merchant_open_status.createtime
     */
    private Date createtime;

    /**
     * 聚合支付状态：0表示未开启，1表示开启
     * 表字段 : merchant_open_status.aggregatePayStatus
     */
    private Integer aggregatepaystatus;

    /**
     * 信用卡付款方式：0表示未开启；1表示开启
     * 表字段 : merchant_open_status.creditCardStatus
     */
    private Integer creditcardstatus;

    /**
     * 客户积累状态：0表示开启；1表示未开启
     * 表字段 : merchant_open_status.customersAccumulateStatus
     */
    private Integer customersaccumulatestatus;

    /**
     * 多机收信息状态：0表示未开启，1表示开启
     * 表字段 : merchant_open_status.phonesMessageStatus
     */
    private Integer phonesmessagestatus;

    /**
     * 网店开启状态：0表示开启；1表示未开启
     * 表字段 : merchant_open_status.onlineStoreStatus
     */
    private Integer onlinestorestatus;

    /**
     * 付前广告开启状态：0表示未开启，1表示已开启
     * 表字段 : merchant_open_status.payBeforeAdvertisingStatus
     */
    private Integer paybeforeadvertisingstatus;

    /**
     * 小票广告开启状态：0表示未开启，1表示已开启
     * 表字段 : merchant_open_status.receiptsStatus
     */
    private Integer receiptsstatus;

    /**
     * 开地图点状态：0表示未开启，1表示已开启
     * 表字段 : merchant_open_status.storeMapStatus
     */
    private Integer storemapstatus;

    /**
     * 销售统计状态：0表示未开启，1表示已开启
     * 表字段 : merchant_open_status.salesStatisticsStatus
     */
    private Integer salesstatisticsstatus;

    /**
     * 支付详情状态：0表示未开启，1表示已开启
     * 表字段 : merchant_open_status.paymentDetailsStatus
     */
    private Integer paymentdetailsstatus;

    /**
     * 服务联系状态:0表示未开启，1表示已开启
     * 表字段 : merchant_open_status.serviceLinksStatus
     */
    private Integer servicelinksstatus;

    /**
     * 红包发券状态：0表示开启，1表示未开启
     * 表字段 : merchant_open_status.grantRedpacketStatus
     */
    private Integer grantredpacketstatus;

    /**
     * 信息群发状态：0表示未开启，1表示已开启
     * 表字段 : merchant_open_status.groupsStatus
     */
    private Integer groupsstatus;

    /**
     * 付后广告状态：0表示未开启，1表示已开启
     * 表字段 : merchant_open_status.payAfterAdvertisingStatus
     */
    private Integer payafteradvertisingstatus;

    /**
     * 是否有效：0表示无效，1表示有效
     * 表字段 : merchant_open_status.isdelete
     */
    private Integer isdelete;

    /**
     * 商家红包券手续费
     * 表字段 : merchant_open_status.redPackagePay
     */
    private Double redpackagepay;

    
	public Double getRedpackagepay() {
		return redpackagepay;
	}

	public void setRedpackagepay(Double redpackagepay) {
		this.redpackagepay = redpackagepay;
	}

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

	public Integer getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Integer integer) {
		this.merchantId = integer;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Integer getAggregatepaystatus() {
		return aggregatepaystatus;
	}

	public void setAggregatepaystatus(Integer aggregatepaystatus) {
		this.aggregatepaystatus = aggregatepaystatus;
	}

	public Integer getCreditcardstatus() {
		return creditcardstatus;
	}

	public void setCreditcardstatus(Integer creditcardstatus) {
		this.creditcardstatus = creditcardstatus;
	}

	public Integer getCustomersaccumulatestatus() {
		return customersaccumulatestatus;
	}

	public void setCustomersaccumulatestatus(Integer customersaccumulatestatus) {
		this.customersaccumulatestatus = customersaccumulatestatus;
	}

	public Integer getPhonesmessagestatus() {
		return phonesmessagestatus;
	}

	public void setPhonesmessagestatus(Integer phonesmessagestatus) {
		this.phonesmessagestatus = phonesmessagestatus;
	}

	public Integer getOnlinestorestatus() {
		return onlinestorestatus;
	}

	public void setOnlinestorestatus(Integer onlinestorestatus) {
		this.onlinestorestatus = onlinestorestatus;
	}

	public Integer getPaybeforeadvertisingstatus() {
		return paybeforeadvertisingstatus;
	}

	public void setPaybeforeadvertisingstatus(Integer paybeforeadvertisingstatus) {
		this.paybeforeadvertisingstatus = paybeforeadvertisingstatus;
	}

	public Integer getReceiptsstatus() {
		return receiptsstatus;
	}

	public void setReceiptsstatus(Integer receiptsstatus) {
		this.receiptsstatus = receiptsstatus;
	}

	public Integer getStoremapstatus() {
		return storemapstatus;
	}

	public void setStoremapstatus(Integer storemapstatus) {
		this.storemapstatus = storemapstatus;
	}

	public Integer getSalesstatisticsstatus() {
		return salesstatisticsstatus;
	}

	public void setSalesstatisticsstatus(Integer salesstatisticsstatus) {
		this.salesstatisticsstatus = salesstatisticsstatus;
	}

	public Integer getPaymentdetailsstatus() {
		return paymentdetailsstatus;
	}

	public void setPaymentdetailsstatus(Integer paymentdetailsstatus) {
		this.paymentdetailsstatus = paymentdetailsstatus;
	}

	public Integer getServicelinksstatus() {
		return servicelinksstatus;
	}

	public void setServicelinksstatus(Integer servicelinksstatus) {
		this.servicelinksstatus = servicelinksstatus;
	}

	public Integer getGrantredpacketstatus() {
		return grantredpacketstatus;
	}

	public void setGrantredpacketstatus(Integer grantredpacketstatus) {
		this.grantredpacketstatus = grantredpacketstatus;
	}

	public Integer getGroupsstatus() {
		return groupsstatus;
	}

	public void setGroupsstatus(Integer groupsstatus) {
		this.groupsstatus = groupsstatus;
	}

	public Integer getPayafteradvertisingstatus() {
		return payafteradvertisingstatus;
	}

	public void setPayafteradvertisingstatus(Integer payafteradvertisingstatus) {
		this.payafteradvertisingstatus = payafteradvertisingstatus;
	}

	public Integer getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}
}
