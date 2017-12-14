package com.bz.open.core.vo.request.weixin;

/**
 * 
 * 作者: 兰俊
 * 描述: 微信消息模版值的封装
 * 创建时间:2017年11月16日下午6:16:24
 * 修改备注:
 */
public class WeixinTemplageMessageValue {
	
	private String  first;//抬头语
	
	private String keyword1;//店铺名称
	
	private String keyword2;//实收金额//支付金额
	
	private String keyword3;//订单金额//使用优惠
	
	private String keyword4;//收付款时间
	
	private String keyword5;//交易单号
	
	private String remark;//结束尾语

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getKeyword1() {
		return keyword1;
	}

	public void setKeyword1(String keyword1) {
		this.keyword1 = keyword1;
	}

	public String getKeyword2() {
		return keyword2;
	}

	public void setKeyword2(String keyword2) {
		this.keyword2 = keyword2;
	}

	public String getKeyword3() {
		return keyword3;
	}

	public void setKeyword3(String keyword3) {
		this.keyword3 = keyword3;
	}

	public String getKeyword4() {
		return keyword4;
	}

	public void setKeyword4(String keyword4) {
		this.keyword4 = keyword4;
	}

	public String getKeyword5() {
		return keyword5;
	}

	public void setKeyword5(String keyword5) {
		this.keyword5 = keyword5;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	

}
