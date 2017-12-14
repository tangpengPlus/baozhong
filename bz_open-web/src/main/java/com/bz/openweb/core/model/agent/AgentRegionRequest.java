package com.bz.openweb.core.model.agent;

import com.bz.framework.pojo.base.BasePojo;
/**
 * 
 * @author 陈青山
 * @miaoshu 合伙人注册封装类
 *
 */
public class AgentRegionRequest extends BasePojo{
	
	private static final long serialVersionUID = 1L;

	 private String smsCode;//短信验证码
	 private String sgrade;//合伙人类型
	 private String userName;//用户姓名
	 private String imPhone;//用户手机号
	 private String legalCardId;//用户身份证号
	 private String address;//详细地址
	 private String region1;//地址编码
	 private String region2;//地址编码
	 private String region3;//地址编码
	 private String region4;//地址编码
	 private String userid;//当前用户id
	 public String getSmsCode() {
			return smsCode;
		}
		public void setSmsCode(String smsCode) {
			this.smsCode = smsCode;
		}
	 public String getSgrade() {
		return sgrade;
	}
	public void setSgrade(String sgrade) {
		this.sgrade = sgrade;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getImPhone() {
		return imPhone;
	}
	public void setImPhone(String imPhone) {
		this.imPhone = imPhone;
	}
	public String getLegalCardId() {
		return legalCardId;
	}
	public void setLegalCardId(String legalCardId) {
		this.legalCardId = legalCardId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRegion1() {
		return region1;
	}
	public void setRegion1(String region1) {
		this.region1 = region1;
	}
	public String getRegion2() {
		return region2;
	}
	public void setRegion2(String region2) {
		this.region2 = region2;
	}
	public String getRegion3() {
		return region3;
	}
	public void setRegion3(String region3) {
		this.region3 = region3;
	}
	public String getRegion4() {
		return region4;
	}
	public void setRegion4(String region4) {
		this.region4 = region4;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
