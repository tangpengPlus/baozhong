package com.bz.openweb.core.model.merchant;

import com.bz.framework.pojo.base.BasePojo;

/**
 * 
 * 作者: 彭云山
 * 描述: 商户注册请求封装
 * 创建时间:2017年11月8日上午11:58:48
 * 修改备注:
 */
public class MerchantRegistRequest extends BasePojo{

	 private static final long serialVersionUID = -5858928417173034178L;
	 private String id;
	 private Integer shopId;//店铺Id
	 private String openId;//商户微信ID
	 private String nickname;//商户微信昵称
	 private String headImgUrl;//商户微信头像
	 private String number;//店铺编号
	 private String name;//店铺名称
	 private String smsCode;//短信验证code
	 private String licenseimage;//营业执照
	 private String provincelevecode;//市级/省级编码
	 private String citylevecode;//区级编码
	 private String regionlevecode;//街道编码
	 private String detailaddress;//详细地址
	 private String coordinate;//店铺经纬
	 private String bankname;//所属银行
	 private String bankcard;//银行卡
	 private String phone;//店铺电话
	 private Integer belongmerchantid;//商户ID
	 private String shopLogoImage;//门面图片
	 private String shopdetailimage;//店铺实拍
	 private String frontidcardimg;//身份证正面照
	 private String backidcardimg;//身份证背面照
	 private String bustimg;//半身照
	 private String licenseimagePath;//营业执照地址
	 private String shopLogoImagePath;//店铺门头照地址
	 private String shopdetailImagePath;//店铺实拍地址
	 private String frontidcardImgPath;//身份证正面地址
	 private String backidcardImgPath;//身份证背面地址
	 private String verifyRemark;//店铺介绍
	 private Integer streetLevel;//街道ID
	
	
	 
	public Integer getStreetLevel() {
		return streetLevel;
	}

	public void setStreetLevel(Integer streetLevel) {
		this.streetLevel = streetLevel;
	}

	public String getOpenId() {
		return openId;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSmsCode() {
		return smsCode;
	}

	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getVerifyRemark() {
		return verifyRemark;
	}

	public void setVerifyRemark(String verifyRemark) {
		this.verifyRemark = verifyRemark;
	}

	public String getHeadImgUrl() {
		return headImgUrl;
	}
	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProvincelevecode() {
		return provincelevecode;
	}
	public void setProvincelevecode(String provincelevecode) {
		this.provincelevecode = provincelevecode;
	}
	public String getCitylevecode() {
		return citylevecode;
	}
	public void setCitylevecode(String citylevecode) {
		this.citylevecode = citylevecode;
	}
	public String getRegionlevecode() {
		return regionlevecode;
	}
	public void setRegionlevecode(String regionlevecode) {
		this.regionlevecode = regionlevecode;
	}
	public String getDetailaddress() {
		return detailaddress;
	}
	public void setDetailaddress(String detailaddress) {
		this.detailaddress = detailaddress;
	}
	public String getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getBankcard() {
		return bankcard;
	}
	public void setBankcard(String bankcard) {
		this.bankcard = bankcard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getBelongmerchantid() {
		return belongmerchantid;
	}
	public void setBelongmerchantid(Integer belongmerchantid) {
		this.belongmerchantid = belongmerchantid;
	}

	public String getLicenseimage() {
		return licenseimage;
	}

	public void setLicenseimage(String licenseimage) {
		this.licenseimage = licenseimage;
	}


	public String getShopLogoImage() {
		return shopLogoImage;
	}

	public void setShopLogoImage(String shopLogoImage) {
		this.shopLogoImage = shopLogoImage;
	}

	public String getShopdetailimage() {
		return shopdetailimage;
	}

	public void setShopdetailimage(String shopdetailimage) {
		this.shopdetailimage = shopdetailimage;
	}

	public String getFrontidcardimg() {
		return frontidcardimg;
	}

	public void setFrontidcardimg(String frontidcardimg) {
		this.frontidcardimg = frontidcardimg;
	}

	public String getBackidcardimg() {
		return backidcardimg;
	}

	public void setBackidcardimg(String backidcardimg) {
		this.backidcardimg = backidcardimg;
	}

	public String getBustimg() {
		return bustimg;
	}

	public void setBustimg(String bustimg) {
		this.bustimg = bustimg;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getLicenseimagePath() {
		return licenseimagePath;
	}

	public void setLicenseimagePath(String licenseimagePath) {
		this.licenseimagePath = licenseimagePath;
	}

	public String getShopLogoImagePath() {
		return shopLogoImagePath;
	}

	public void setShopLogoImagePath(String shopLogoImagePath) {
		this.shopLogoImagePath = shopLogoImagePath;
	}

	public String getShopdetailImagePath() {
		return shopdetailImagePath;
	}

	public void setShopdetailImagePath(String shopdetailImagePath) {
		this.shopdetailImagePath = shopdetailImagePath;
	}

	public String getFrontidcardImgPath() {
		return frontidcardImgPath;
	}

	public void setFrontidcardImgPath(String frontidcardImgPath) {
		this.frontidcardImgPath = frontidcardImgPath;
	}

	public String getBackidcardImgPath() {
		return backidcardImgPath;
	}

	public void setBackidcardImgPath(String backidcardImgPath) {
		this.backidcardImgPath = backidcardImgPath;
	}

	
	
}
