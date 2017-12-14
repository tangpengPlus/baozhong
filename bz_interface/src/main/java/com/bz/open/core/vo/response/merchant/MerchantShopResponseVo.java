package com.bz.open.core.vo.response.merchant;

import java.util.Date;

import com.bz.framework.pojo.base.BasePojo;

/**
 * 
 * 作者: 彭云山
 * 描述:商铺
 * 创建时间:2017年11月9日下午3:48:58
 * 修改备注:
 */
public class MerchantShopResponseVo extends BasePojo{

	
	private static final long serialVersionUID = -6528249555941041148L;

	 /**
     * 店铺ID
     * 表字段 : merchant_shop.id
     */
    private Integer id;

    /**
     * 商铺编号
     * 表字段 : merchant_shop.number
     */
    private String number;

    /**
     * 店铺名称
     * 表字段 : merchant_shop.name
     */
    private String name;

    /**
     * 营业执照图片
     * 表字段 : merchant_shop.licenseImage
     */
    private String licenseimage;

    /**
     * 省级编码
     * 表字段 : merchant_shop.provinceLeveCode
     */
    private String provincelevecode;

    /**
     * 市级编码
     * 表字段 : merchant_shop.cityLeveCode
     */
    private String citylevecode;

    /**
     * 区域编码
     * 表字段 : merchant_shop.regionLeveCode
     */
    private String regionlevecode;

    /**
     * 详细地址
     * 表字段 : merchant_shop.detailAddress
     */
    private String detailaddress;

    /**
     * 店铺经纬度
     * 表字段 : merchant_shop.coordinate
     */
    private String coordinate;

    /**
     * 所属银行
     * 表字段 : merchant_shop.bankName
     */
    private String bankname;

    /**
     * 银行卡
     * 表字段 : merchant_shop.bankCard
     */
    private String bankcard;

    /**
     * 店铺电话
     * 表字段 : merchant_shop.phone
     */
    private String phone;

    /**
     * 店铺注册时使用微信ID
     * 表字段 : merchant_shop.weChatOpenId
     */
    private String wechatopenid;

    /**
     * 所属商户ID
     * 表字段 : merchant_shop.belongMerchantId
     */
    private Integer belongmerchantid;

    /**
     * 审核状态；0：待审核；1：审核成功;2：审核失败
     * 表字段 : merchant_shop.isVerify
     */
    private Integer isverify;

    /**
     * 上线状态;0:未上线;1::已经上线;2:已经下线
     * 表字段 : merchant_shop.onlineState
     */
    private Integer onlinestate;

    /**
     * 审核备注
     * 表字段 : merchant_shop.verifyRemark
     */
    private String verifyremark;

    /**
     * 审核人
     * 表字段 : merchant_shop.verifyAdmin
     */
    private Integer verifyadmin;

    /**
     * 审核时间
     * 表字段 : merchant_shop.verifyTime
     */
    private Date verifytime;

    /**
     * 店铺门面图片
     * 表字段 : merchant_shop.shopFacadeImage
     */
    private String shopfacadeimage;

    /**
     * 店铺实拍
     * 表字段 : merchant_shop.shopDetailImage
     */
    private String shopdetailimage;

    /**
     * 行业父类
     * 表字段 : merchant_shop.industryParent
     */
    private Integer industryparent;

    /**
     * 行业子类
     * 表字段 : merchant_shop.industrySubclass
     */
    private Integer industrysubclass;

    /**
     * 创建时间
     * 表字段 : merchant_shop.createTime
     */
    private Date createtime;

    /**
     * 0:保留;1:删除
     * 表字段 : merchant_shop.isDelete
     */
    private Integer isdelete;

    /**
     * 合作类型:1:扫码支付；2：线上开店；3线上线下共存
     * 表字段 : merchant_shop.cooperationType
     */
    private Integer cooperationtype;

    /**
     * 身份证正面照
     * 表字段 : merchant_shop.frontidcardimg
     */
    private String frontidcardimg;

    /**
     * 身份证背面照
     * 表字段 : merchant_shop.backidcardimg
     */
    private String backidcardimg;

    /**
     * 半身照
     * 表字段 : merchant_shop.bustimg
     */
    private String bustimg;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getLicenseimage() {
		return licenseimage;
	}

	public void setLicenseimage(String licenseimage) {
		this.licenseimage = licenseimage;
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

	public String getWechatopenid() {
		return wechatopenid;
	}

	public void setWechatopenid(String wechatopenid) {
		this.wechatopenid = wechatopenid;
	}

	public Integer getBelongmerchantid() {
		return belongmerchantid;
	}

	public void setBelongmerchantid(Integer belongmerchantid) {
		this.belongmerchantid = belongmerchantid;
	}

	public Integer getIsverify() {
		return isverify;
	}

	public void setIsverify(Integer isverify) {
		this.isverify = isverify;
	}

	public Integer getOnlinestate() {
		return onlinestate;
	}

	public void setOnlinestate(Integer onlinestate) {
		this.onlinestate = onlinestate;
	}

	public String getVerifyremark() {
		return verifyremark;
	}

	public void setVerifyremark(String verifyremark) {
		this.verifyremark = verifyremark;
	}

	public Integer getVerifyadmin() {
		return verifyadmin;
	}

	public void setVerifyadmin(Integer verifyadmin) {
		this.verifyadmin = verifyadmin;
	}

	public Date getVerifytime() {
		return verifytime;
	}

	public void setVerifytime(Date verifytime) {
		this.verifytime = verifytime;
	}

	public String getShopfacadeimage() {
		return shopfacadeimage;
	}

	public void setShopfacadeimage(String shopfacadeimage) {
		this.shopfacadeimage = shopfacadeimage;
	}

	public String getShopdetailimage() {
		return shopdetailimage;
	}

	public void setShopdetailimage(String shopdetailimage) {
		this.shopdetailimage = shopdetailimage;
	}

	public Integer getIndustryparent() {
		return industryparent;
	}

	public void setIndustryparent(Integer industryparent) {
		this.industryparent = industryparent;
	}

	public Integer getIndustrysubclass() {
		return industrysubclass;
	}

	public void setIndustrysubclass(Integer industrysubclass) {
		this.industrysubclass = industrysubclass;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Integer getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

	public Integer getCooperationtype() {
		return cooperationtype;
	}

	public void setCooperationtype(Integer cooperationtype) {
		this.cooperationtype = cooperationtype;
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
    
}
