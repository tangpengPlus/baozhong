package com.bz.open.core.vo.response.merchant;

import com.bz.framework.pojo.base.BasePojo;
/**
 * 
 * 作者: 彭云山
 * 描述:商品分类实体
 * 创建时间:2017年11月27日下午3:08:54
 * 修改备注:
 */
public class MerchantGoodsCategoryResponse extends BasePojo{
	
	 /**
     * 商品分类id
     * 表字段 : merchant_goods_category.id
     */
    private Integer id;

    /**
     * 商品分类名称
     * 表字段 : merchant_goods_category.name
     */
    private String name;

    /**
     * 手机端显示的商品分类名
     * 表字段 : merchant_goods_category.mobile_name
     */
    private String mobileName;

    /**
     * 父id
     * 表字段 : merchant_goods_category.parent_id
     */
    private Integer parentId;

    /**
     * 家族图谱
     * 表字段 : merchant_goods_category.parent_id_path
     */
    private String parentIdPath;

    /**
     * 等级
     * 表字段 : merchant_goods_category.level
     */
    private Integer level;

    /**
     * 顺序排序
     * 表字段 : merchant_goods_category.sort_order
     */
    private Integer sortOrder;

    /**
     * 是否显示
     * 表字段 : merchant_goods_category.is_show
     */
    private Integer isShow;

    /**
     * 分类图片
     * 表字段 : merchant_goods_category.image
     */
    private String image;

    /**
     * 是否推荐为热门分类
     * 表字段 : merchant_goods_category.is_hot
     */
    private Integer isHot;

    /**
     * 分类分组默认0
     * 表字段 : merchant_goods_category.cat_group
     */
    private Integer catGroup;

    /**
     * 分佣比例
     * 表字段 : merchant_goods_category.commission_rate
     */
    private Double commissionRate;
	
	private static final long serialVersionUID = 3932532826377933752L;

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

	public String getMobileName() {
		return mobileName;
	}

	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getParentIdPath() {
		return parentIdPath;
	}

	public void setParentIdPath(String parentIdPath) {
		this.parentIdPath = parentIdPath;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Integer getIsShow() {
		return isShow;
	}

	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getIsHot() {
		return isHot;
	}

	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}

	public Integer getCatGroup() {
		return catGroup;
	}

	public void setCatGroup(Integer catGroup) {
		this.catGroup = catGroup;
	}

	public Double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(Double commissionRate) {
		this.commissionRate = commissionRate;
	}

	

	
}
