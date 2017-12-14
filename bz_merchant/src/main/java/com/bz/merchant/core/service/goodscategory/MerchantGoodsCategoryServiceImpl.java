package com.bz.merchant.core.service.goodscategory;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bz.dao.mapper.merchant.MerchantGoodsCategoryMapper;
import com.bz.dao.pojo.merchant.MerchantGoodsCategory;
import com.bz.framework.error.exception.CategoryException;
import com.bz.open.core.service.merchant.MerchantGoodsCategoryService;
import com.bz.open.core.vo.response.merchant.MerchantGoodsCategoryResponse;

public class MerchantGoodsCategoryServiceImpl implements MerchantGoodsCategoryService{

	@Autowired
	MerchantGoodsCategoryMapper cateMapper;
	
	private final Logger logger=LoggerFactory.getLogger(MerchantGoodsCategoryServiceImpl.class);
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月27日上午15:02:03
	 * 描述:查询商品一级分类
	 * @param id 下级ID
	 * @return 上级城市的ID
	 */
	@Override
	public List<MerchantGoodsCategoryResponse> getOneCategory() throws CategoryException {
		
		logger.info("获取一级商品分类");
		
		MerchantGoodsCategory cate = new MerchantGoodsCategory();
		//获取一级商品
		cate.setParentId(0);
		List<MerchantGoodsCategory> cates= new ArrayList<MerchantGoodsCategory>();
		cates = cateMapper.selectList(cate);
		//创建一个MerchantGoodsCategoryResponse集合
		List<MerchantGoodsCategoryResponse> catesVo = new ArrayList<MerchantGoodsCategoryResponse>();
		
		for(MerchantGoodsCategory daocate:cates) {
			MerchantGoodsCategoryResponse respcate = new MerchantGoodsCategoryResponse();
			respcate.setId(daocate.getId());
			respcate.setName(daocate.getName());
			respcate.setParentId(daocate.getParentId());
			respcate.setParentIdPath(daocate.getParentIdPath());
			respcate.setLevel(daocate.getLevel());
			respcate.setSortOrder(daocate.getSortOrder());
			respcate.setIsShow(daocate.getIsShow());
			respcate.setIsHot(daocate.getIsHot());
			respcate.setCatGroup(daocate.getCatGroup());
			respcate.setCommissionRate(daocate.getCommissionRate());
			catesVo.add(respcate);
		}
		
		return catesVo;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月27日上午15:40:09
	 * 描述:查询商品下级id
	 * @param id 下级ID
	 * @return 上级城市的ID
	 */
	@Override
	public Integer getUpLevelCategory(Integer id) throws CategoryException {
		logger.info("根据ID:{}查询上级商品分类ID",id);
		MerchantGoodsCategory daocate = new MerchantGoodsCategory();
		try {
			daocate = cateMapper.selectById(id);
		} catch (Exception e) {
			logger.error("获取上级ID错误");
			return null;
		}
		return daocate.getParentId();
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月27日上午16:12:09
	 * 描述:查询商品下级分类
	 * @param id {@link id}下级ID
	 * @return 上级商品集合
	 */
	@Override
	public List<MerchantGoodsCategoryResponse> getNextCategory(Integer id) throws CategoryException {
		logger.info("根据ID:{}查询下级商品分类列表",id);
		
		MerchantGoodsCategory cate = new MerchantGoodsCategory();
		//获取一级商品
		cate.setParentId(id);
		List<MerchantGoodsCategory> cates= new ArrayList<MerchantGoodsCategory>();
		cates = cateMapper.selectList(cate);
		//创建一个MerchantGoodsCategoryResponse集合
		List<MerchantGoodsCategoryResponse> catesVo = new ArrayList<MerchantGoodsCategoryResponse>();
		
		for(MerchantGoodsCategory daocate:cates) {
			MerchantGoodsCategoryResponse respcate = new MerchantGoodsCategoryResponse();
			respcate.setId(daocate.getId());
			respcate.setName(daocate.getName());
			respcate.setParentId(daocate.getParentId());
			respcate.setParentIdPath(daocate.getParentIdPath());
			respcate.setLevel(daocate.getLevel());
			respcate.setSortOrder(daocate.getSortOrder());
			respcate.setIsShow(daocate.getIsShow());
			respcate.setIsHot(daocate.getIsHot());
			respcate.setCatGroup(daocate.getCatGroup());
			respcate.setCommissionRate(daocate.getCommissionRate());
			catesVo.add(respcate);
		}
		return catesVo;
	}

}
