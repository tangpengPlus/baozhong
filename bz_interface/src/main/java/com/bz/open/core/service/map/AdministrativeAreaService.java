package com.bz.open.core.service.map;
/**
 * 
 * @author hujin
 * 行政区域开放接口
 */

import java.util.List;
import java.util.Map;

import com.bz.framework.error.exception.ExternalException;
import com.bz.open.core.vo.response.regin.ReginResponsVo;

/**
* @ClassName: AdministrativeAreaService 
* @Description: TODO(行政区域开放接口) 
* @author 胡竞
* @date 2017年10月25日 下午2:57:36 
*
 */
public interface AdministrativeAreaService {
	
	/**
	* @作者 胡竞
	* @Title: getProvinceLeveRegion 
	* @Description: TODO(获取省级城市集合) 
	* @param @return
	* @param @throws ExternalException    设定文件 
	* @return List<Region>    返回类型 
	* @throws
	 */
	public List<ReginResponsVo> getProvinceLeveRegion()throws ExternalException;
	
	/**
	* @作者 胡竞
	* @Title: getSubordinateRegionById 
	* @Description: TODO(获取下级城市集合) 
	* @param @param id
	* @param @return
	* @param @throws ExternalException    设定文件 
	* @return List<Region>    返回类型 
	* @throws
	 */
	public List<ReginResponsVo> getSubordinateRegionById(String id)throws ExternalException;
	/**
	 * 
	 * @作者 陈青山
	 * @Title: getSiteById 
	 * @Description: TODO(获取城市名称) 
	 * @param id
	 * @return
	 */
	public String getSiteById(String id);
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月27日上午10:02:03
	 * 描述:根据传入的Id获取上级Id
	 * @param id
	 * @return
	 */
	public Integer getUpLevel(Integer id);
}
