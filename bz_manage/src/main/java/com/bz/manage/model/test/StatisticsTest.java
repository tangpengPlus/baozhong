package com.bz.manage.model.test;

import java.util.Date;

public class StatisticsTest {

	/**
	 * 统计ID
	 */
	private int id;
	/**
	 * 关联店铺名称
	 */
	private String shopName;
	/**
	 * 收入支出
	 */
	private double income;
	/**
	 * 查询时间
	 */
	private Date selectTime;
	
	
	/**
	 * @return the selectTime
	 */
	public Date getSelectTime() {
		return selectTime;
	}
	/**
	 * @param selectTime the selectTime to set
	 */
	public void setSelectTime(Date selectTime) {
		this.selectTime = selectTime;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the shopName
	 */
	public String getShopName() {
		return shopName;
	}
	/**
	 * @param shopName the shopName to set
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	/**
	 * @return the income
	 */
	public double getIncome() {
		return income;
	}
	/**
	 * @param income the income to set
	 */
	public void setIncome(double income) {
		this.income = income;
	}

	
}
