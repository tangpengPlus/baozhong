package com.bz.framework.constant.pay;

import com.bz.framework.constant.base.BaseEnum;

/**
* @ClassName: WeiXinPaymentScenarioEnum 
* @Description: TODO(微信支付场景封装) 
* @author 胡竞
* @date 2017年11月9日 下午5:50:11 
*
 */
public enum WeiXinPaymentScenarioEnum implements BaseEnum<String>{
	WEIXIN_JSAPI_PAY("公众号分享支付","JSAPI"),
	WEIXIN_NATIVE_PAY("扫码支付","NATIVE"),
	WEIXIN_APP_PAY("APP支付","APP");

	private String key;
	private String value;
	
	private WeiXinPaymentScenarioEnum(String key,String value) {
		this.key=key;
		this.value=value;
	}
	
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return key;
	}
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return value;
	}

	public String toString() {
		
		return "[key="+key+",title="+value+"]";
	}
	
}
