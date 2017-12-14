package com.bz.thirdparty.model.sms;

/**
 * 
 * 作者:唐鹏
 * 创建时间:2017年10月11日下午3:49:51
 * 描述:短信平台返回结果封装
 * 备注:
 */
public class SmsAccountResult extends SmsResult{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2033283255953213604L;
	private Result result;//返回信息封装
	
	public Result getResult() {
		return result;
	}


	public void setResult(Result result) {
		this.result = result;
	}
}
