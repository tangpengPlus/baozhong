package com.bz.open.core.service.merchant;

import java.util.List;

import com.bz.framework.error.exception.CategoryException;
import com.bz.open.core.vo.response.merchant.MerchantGoodsCategoryResponse;
import com.bz.open.core.vo.response.regin.ReginResponsVo;

/**
 * 
 * 
 * 作者: 彭云山
 * 描述:商品分类查询接口
 * 创建时间:2017年11月27日下午2:41:47
 * 修改备注:
 */
public interface MerchantGoodsCategoryService {

	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月27日下午3:03:28
	 * 描述:获得当前商品分类
	 * @param id
	 * @return
	 * @throws CategoryException
	 */
	public List<MerchantGoodsCategoryResponse> getOneCategory()throws CategoryException;
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月27日下午4:02:31
	 * 描述:获取下级分类
	 * @return
	 * @throws CategoryException
	 */
	public List<MerchantGoodsCategoryResponse> getNextCategory(Integer id)throws CategoryException;
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月27日下午3:12:43
	 * 描述:根据ID获得上级行业ID
	 * @param id
	 * @return
	 * @throws CategoryException
	 */
	public Integer getUpLevelCategory(Integer id)throws CategoryException;
}
