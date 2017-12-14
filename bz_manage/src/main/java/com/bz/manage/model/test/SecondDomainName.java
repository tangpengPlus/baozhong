package com.bz.manage.model.test;

/**
 * 作者: 胡竞
 * 描述: 二级域名设置实体测试类
 * 创建时间:2017年10月12日 下午4:55:50
 * 修改备注:
 */
public class SecondDomainName {

	private int isdelete;
	private String suffix;
	private String reserve;
	private String length;
	
	
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getReserve() {
		return reserve;
	}
	public void setReserve(String reserve) {
		this.reserve = reserve;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	
}
