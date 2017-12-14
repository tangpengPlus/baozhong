package com.bz.manage.model.test;


/**
 * 作者: 胡竞
 * 描述: 店铺管理实体测试类
 * 创建时间:2017年10月16日 下午2:43:06
 * 修改备注:
 */
public class ShopManage {

	//id
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	//店主
	private String shopkeeper;
	//店铺名称
	private String shopName;
	//所在地
	private String address;
	//所属等级
	private String grade;
	
	//状态
	private int status;
	
	
	public String getShopkeeper() {
		return shopkeeper;
	}
	public void setShopkeeper(String shopkeeper) {
		this.shopkeeper = shopkeeper;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
