package com.bz.dao.pojo.merchant;

import com.bz.framework.pojo.base.BasePojo;

/**
	* 作者:唐鹏
	* 描述:
	* 版本: version 1.0.0
	* 时间:2017-11-27 15:35:07
  */
public class MerchantGoodsCategory extends BasePojo {
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

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table merchant_goods_category
     *
     * @mbg.generated Mon Nov 27 15:35:07 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取 商品分类id 字段:merchant_goods_category.id
     *
     * @return merchant_goods_category.id, 商品分类id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 商品分类id 字段:merchant_goods_category.id
     *
     * @param id the value for merchant_goods_category.id, 商品分类id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 商品分类名称 字段:merchant_goods_category.name
     *
     * @return merchant_goods_category.name, 商品分类名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 商品分类名称 字段:merchant_goods_category.name
     *
     * @param name the value for merchant_goods_category.name, 商品分类名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取 手机端显示的商品分类名 字段:merchant_goods_category.mobile_name
     *
     * @return merchant_goods_category.mobile_name, 手机端显示的商品分类名
     */
    public String getMobileName() {
        return mobileName;
    }

    /**
     * 设置 手机端显示的商品分类名 字段:merchant_goods_category.mobile_name
     *
     * @param mobileName the value for merchant_goods_category.mobile_name, 手机端显示的商品分类名
     */
    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    /**
     * 获取 父id 字段:merchant_goods_category.parent_id
     *
     * @return merchant_goods_category.parent_id, 父id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置 父id 字段:merchant_goods_category.parent_id
     *
     * @param parentId the value for merchant_goods_category.parent_id, 父id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取 家族图谱 字段:merchant_goods_category.parent_id_path
     *
     * @return merchant_goods_category.parent_id_path, 家族图谱
     */
    public String getParentIdPath() {
        return parentIdPath;
    }

    /**
     * 设置 家族图谱 字段:merchant_goods_category.parent_id_path
     *
     * @param parentIdPath the value for merchant_goods_category.parent_id_path, 家族图谱
     */
    public void setParentIdPath(String parentIdPath) {
        this.parentIdPath = parentIdPath;
    }

    /**
     * 获取 等级 字段:merchant_goods_category.level
     *
     * @return merchant_goods_category.level, 等级
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置 等级 字段:merchant_goods_category.level
     *
     * @param level the value for merchant_goods_category.level, 等级
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取 顺序排序 字段:merchant_goods_category.sort_order
     *
     * @return merchant_goods_category.sort_order, 顺序排序
     */
    public Integer getSortOrder() {
        return sortOrder;
    }

    /**
     * 设置 顺序排序 字段:merchant_goods_category.sort_order
     *
     * @param sortOrder the value for merchant_goods_category.sort_order, 顺序排序
     */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * 获取 是否显示 字段:merchant_goods_category.is_show
     *
     * @return merchant_goods_category.is_show, 是否显示
     */
    public Integer getIsShow() {
        return isShow;
    }

    /**
     * 设置 是否显示 字段:merchant_goods_category.is_show
     *
     * @param isShow the value for merchant_goods_category.is_show, 是否显示
     */
    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    /**
     * 获取 分类图片 字段:merchant_goods_category.image
     *
     * @return merchant_goods_category.image, 分类图片
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置 分类图片 字段:merchant_goods_category.image
     *
     * @param image the value for merchant_goods_category.image, 分类图片
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 获取 是否推荐为热门分类 字段:merchant_goods_category.is_hot
     *
     * @return merchant_goods_category.is_hot, 是否推荐为热门分类
     */
    public Integer getIsHot() {
        return isHot;
    }

    /**
     * 设置 是否推荐为热门分类 字段:merchant_goods_category.is_hot
     *
     * @param isHot the value for merchant_goods_category.is_hot, 是否推荐为热门分类
     */
    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    /**
     * 获取 分类分组默认0 字段:merchant_goods_category.cat_group
     *
     * @return merchant_goods_category.cat_group, 分类分组默认0
     */
    public Integer getCatGroup() {
        return catGroup;
    }

    /**
     * 设置 分类分组默认0 字段:merchant_goods_category.cat_group
     *
     * @param catGroup the value for merchant_goods_category.cat_group, 分类分组默认0
     */
    public void setCatGroup(Integer catGroup) {
        this.catGroup = catGroup;
    }

    /**
     * 获取 分佣比例 字段:merchant_goods_category.commission_rate
     *
     * @return merchant_goods_category.commission_rate, 分佣比例
     */
    public Double getCommissionRate() {
        return commissionRate;
    }

    /**
     * 设置 分佣比例 字段:merchant_goods_category.commission_rate
     *
     * @param commissionRate the value for merchant_goods_category.commission_rate, 分佣比例
     */
    public void setCommissionRate(Double commissionRate) {
        this.commissionRate = commissionRate;
    }
}