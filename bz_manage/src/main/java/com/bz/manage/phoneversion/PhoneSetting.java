package com.bz.manage.phoneversion;

import java.io.Serializable;
/**
 * 
 * 
 * 作者: 彭云山
 * 描述:手机商城的设置，包括名称，商城OLGO，网站描述，手机网站标题，关键字（注：此类非重要情况，请勿修改！）
 * 创建时间:2017年10月13日上午10:43:07
 * 修改备注:
 */
public class PhoneSetting implements Serializable{

	private Integer id;
	//商城名称
	private String name;
	//网站标题
	private String logoname;
	//网站描述
	private String describe;
	//网站关键字
	private String keyword;
	//网站图标
	private String logo;
	private Integer isDelete;
	public PhoneSetting() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public PhoneSetting(Integer id, String name, String logoname, String describe, String keyword, String logo,
			Integer isDelete) {
		super();
		this.id = id;
		this.name = name;
		this.logoname = logoname;
		this.describe = describe;
		this.keyword = keyword;
		this.logo = logo;
		this.isDelete = isDelete;
	}


	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	@Override
	public String toString() {
		return "PhoneSetting [id=" + id + ", name=" + name + ", logoname=" + logoname + ", describe=" + describe
				+ ", keyword=" + keyword + ", logo=" + logo + ", isDelete=" + isDelete + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogoname() {
		return logoname;
	}
	public void setLogoname(String logoname) {
		this.logoname = logoname;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
}
