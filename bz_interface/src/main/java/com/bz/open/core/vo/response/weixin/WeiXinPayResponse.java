package com.bz.open.core.vo.response.weixin;

import com.bz.framework.pojo.base.BasePojo;
/**
 * 
 * 作者:唐鹏
 * 创建时间:2017年11月3日下午4:13:15
 * 描述:微信支付返回结果封装
 * 备注:
 */

public class WeiXinPayResponse extends BasePojo{


	private static final long serialVersionUID = 6433325583104693851L;
	
	private String returnCode;//返回状态码
	
	private String resultCode;//业务结果
	
	private String returnMsg;//返回信息
	
	private String appid;//公众账号ID
	
	private String mchId;//商户Id
	
	private String nonceStr;//随机签名字符串
	
	private String sign;//签名
	
	private String tradeType;//交易类型
	
	private String prepayId;//预支付交易会话标识

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getPrepayId() {
		return prepayId;
	}

	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId;
	}
	
	

}
