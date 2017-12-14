package com.bz.manage.merchantfile;

import java.io.Serializable;

public class MerchantFile implements Serializable{

	/**
	 * 
	 * 作者: 彭云山
	 * 描述:
	 * 创建时间:2017年10月17日下午4:12:09
	 * 修改备注:
	 */
	private static final long serialVersionUID = -3561355205739737583L;
	private Integer id;
	private String url;
	private String name;
	private String describe;
	private Integer isDelete;
	public MerchantFile() {
		super();
		
	}
	
	public MerchantFile(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}

	public MerchantFile(Integer id, String url, String name, String describe, Integer isDelete) {
		super();
		this.id = id;
		this.url = url;
		this.name = name;
		this.describe = describe;
		this.isDelete = isDelete;
	}
	@Override
	public String toString() {
		return "MerchantFile [id=" + id + ", url=" + url + ", name=" + name + ", describe=" + describe + ", isDelete="
				+ isDelete + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
}
