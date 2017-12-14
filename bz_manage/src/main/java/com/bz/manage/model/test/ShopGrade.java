package com.bz.manage.model.test;

/**
 * 作者: 胡竞
 * 描述: 商店等级设置实体类测试
 * 创建时间:2017年10月13日 上午10:06:07
 * 修改备注:
 */
public class ShopGrade {

	private int gradeId;
	private String gradeName;
	private String allowAmount;
	private String uploadSize;
	private int modelAmount;
	private double chargeStandard;
	private int isAudit;
	private int isdelete;
	
	
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public String getAllowAmount() {
		return allowAmount;
	}
	public void setAllowAmount(String allowAmount) {
		this.allowAmount = allowAmount;
	}
	public String getUploadSize() {
		return uploadSize;
	}
	public void setUploadSize(String uploadSize) {
		this.uploadSize = uploadSize;
	}
	public int getModelAmount() {
		return modelAmount;
	}
	public void setModelAmount(int modelAmount) {
		this.modelAmount = modelAmount;
	}
	public double getChargeStandard() {
		return chargeStandard;
	}
	public void setChargeStandard(double chargeStandard) {
		this.chargeStandard = chargeStandard;
	}
	public int getIsAudit() {
		return isAudit;
	}
	public void setIsAudit(int isAudit) {
		this.isAudit = isAudit;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
}
