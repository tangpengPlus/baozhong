package com.bz.open.core.service.map;

import java.util.List;

import com.bz.dao.pojo.merchant.MerchantBase;
import com.bz.framework.error.exception.ExternalException;
import com.bz.open.core.vo.request.merchant.MerchantShopRequestVo;
import com.bz.open.core.vo.response.merchant.MerchantShopResponseVo;

/**
 * 
 * 
 * 作者: 彭云山
 * 描述:地图开放接口
 * 创建时间:2017年10月18日下午4:20:14
 * 修改备注:
 */
public interface MapService {
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月18日下午4:27:00
	 * 描述:向指定的tableid的数据表中插入一条新的数据
	 * @param merchantShop{@link merchantShop} 商家基本信息封装
	 * @return
	 * @throws ExternalException {@link ExternalException} 第三方服务异常封装
	 */
	public boolean addMerchantInfoToMap(MerchantShopRequestVo merchantShop)throws ExternalException;

	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月18日下午6:17:22
	 * 描述:删除指定tableid的数据表中的数据，一次请求删除一条
	 * @param id{@link id} 选择删除的id
	 * @return
	 * @throws ExternalException {@link ExternalException} 第三方服务异常封装
	 */
	public boolean deleteMerchantInfoToMap(Integer id)throws ExternalException;
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月18日下午6:52:47
	 * 描述:更新指定tableid，指定一条数据序列号_id的数据信息。
	 * @param merchantShop {@link MerchantBase} 商家变动信息封装
	 * @return
	 * @throws ExternalException {@link ExternalException} 第三方服务异常封装
	 */
	public boolean updateMerchantInfoToMap(MerchantShopRequestVo merchantShop)throws ExternalException;
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月19日下午2:03:33
	 * 描述:根据用户输入的关键字和城市检索商家信息，当city为全国或输入错误是，会检索全国的商家
	 * @param keywords {@link keywords} 输入的关键字
	 * @param city {@link city} 输入的城市关键字，当city为全国或者city值设置非法或不正确时，按照city = 全国返回
	 * @return
	 * @throws ExternalException {@link ExternalException} 第三方服务异常封装
	 */
	public List<MerchantShopResponseVo> selectLocalityMerchantInfoToMap(String keywords,String city)throws ExternalException;
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月19日下午4:00:35
	 * 描述:周边检索请求,规则：经度和纬度用","分割经纬度小数点后不得超过6位。
	 * @param center {@link center} 中心点坐标 
	 * @return
	 * @throws ExternalException {@link ExternalException} 第三方服务异常封装
	 */
	public List<MerchantShopResponseVo> selectPeripheryMerchantInfoToMap(String center)throws ExternalException;
	 /**
	  * 
	  * 作者:彭云山
	  * 创建时间:2017年10月19日下午5:01:12
	  * 描述:在指定tableid的数据表内，多边形范围内，搜索指定符合筛选条件的位置数据
	  * @param polygon {@link polygon} 多边形中心点坐标
	  * @return
	  * @throws ExternalException {@link ExternalException} 第三方服务异常封装
	  */
	public List<MerchantShopResponseVo> selectPolygonMerchantInfoToMap(String polygon)throws ExternalException;
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月19日下午6:34:07
	 * 描述:在指定table的数据表内，查询对应数据id的数据详情
	 * @param id {@link id} 用户直接给出的商家ID号
	 * @return
	 * @throws ExternalException {@link ExternalException} 第三方服务异常封装
	 */
	public MerchantShopResponseVo selectByIdMerchantInfoToMap(Integer id)throws ExternalException;
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月20日下午4:43:53
	 * 描述:根据指定的条件搜索商家
	 * @param filter {@link filter} 查询条件
	 * @return
	 * @throws ExternalException {@link ExternalException} 第三方服务异常封装
	 */
	public List<MerchantShopResponseVo> slectByConditionMerchantInfoMap(String filter)throws ExternalException;
	

	

}
