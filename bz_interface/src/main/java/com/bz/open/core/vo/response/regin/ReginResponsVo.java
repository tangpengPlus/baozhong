package com.bz.open.core.vo.response.regin;

import java.util.Date;

import com.bz.framework.pojo.base.BasePojo;

/**
 * 
 * 作者: 彭云山
 * 描述:高德地图地区
 * 创建时间:2017年11月22日下午7:07:31
 * 修改备注:
 */
public class ReginResponsVo extends BasePojo{

	/**
     * 主键
     * 表字段 : system_region.id
     */
    private Integer id;

    /**
     * 
     * 表字段 : system_region.number
     */
    private String number;

    /**
     * 省市区名称
     * 表字段 : system_region.name
     */
    private String name;

    /**
     * 上级ID
     * 表字段 : system_region.parentCode
     */
    private String parentcode;

    /**
     * 级别:0,中国；1，省分；2，市；3，区、县
     * 表字段 : system_region.level
     */
    private Integer level;

    /**
     * 城市代码
     * 表字段 : system_region.citycode
     */
    private String citycode;

    /**
     * 
     * 表字段 : system_region.adcode
     */
    private String adcode;

    /**
     * 经度
     * 表字段 : system_region.lng
     */
    private String lng;

    /**
     * 纬度
     * 表字段 : system_region.lat
     */
    private String lat;

    /**
     * 拼音
     * 表字段 : system_region.pinyin
     */
    private String pinyin;

    /**
     * 
     * 表字段 : system_region.createTime
     */
    private Date createtime;
	
	private static final long serialVersionUID = -7290005691927612566L;

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

	public String getParentcode() {
		return parentcode;
	}

	public void setParentcode(String parentcode) {
		this.parentcode = parentcode;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getAdcode() {
		return adcode;
	}

	public void setAdcode(String adcode) {
		this.adcode = adcode;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	
}
