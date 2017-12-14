package com.bz.manage.model.test;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class ShopClassify {

	 /**
     * 菜单数据ID
     * 表字段 : manage_menu.id
     */
    private Integer id;

    /**
     * 菜单描述
     * 表字段 : manage_menu.describe
     */
    @Length(max=255,message="菜单描述太长")
    private String describe;

    /**
     * 菜单等级
     * 表字段 : manage_menu.grade
     */
    private Integer grade;

    /**
     * 1:有内容的菜单 2:无内容的菜单 3:隐藏菜单
     * 表字段 : manage_menu.type
     */
    private Integer type;

    /**
     * 当等级不为一级时 关联上级菜单的数据id
     * 表字段 : manage_menu.superior
     */
    private Integer superior;


    /**
     * 菜单名称
     * 表字段 : manage_menu.name
     */
    @NotEmpty(message="菜单名称不能为空")
    @Length(max=100,message="菜单名称太长")
    private String name;

    /**
     * 图标路径
     * 表字段 : manage_menu.icopath
     */
    private String icopath;

    /**
     * 0:否 1：是
     * 表字段 : manage_menu.isdelete
     */
    private Integer isdelete;

    /**
     * 0为展示页面 1：为修改或者增加页面
     * 表字段 : manage_menu.autoAttach
     */
    private Integer autoattach;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table manage_menu
     *
     * @mbg.generated Wed Aug 23 11:05:17 CST 2017
     */
    private static final long serialVersionUID = 1L;

    
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getSuperior() {
		return superior;
	}

	public void setSuperior(Integer superior) {
		this.superior = superior;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcopath() {
		return icopath;
	}

	public void setIcopath(String icopath) {
		this.icopath = icopath;
	}

	

	public Integer getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Integer isdelete) {
		this.isdelete = isdelete;
	}

	public Integer getAutoattach() {
		return autoattach;
	}

	public void setAutoattach(Integer autoattach) {
		this.autoattach = autoattach;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
	
}
