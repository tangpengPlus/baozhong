package com.bz.thirdparty.core.service.map;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.alibaba.dubbo.config.annotation.Service;
import com.bz.dao.mapper.map.RegionMapper;
import com.bz.dao.pojo.map.Region;
import com.bz.framework.error.exception.ExternalException;
import com.bz.open.core.service.map.AdministrativeAreaService;
import com.bz.open.core.vo.response.regin.ReginResponsVo;
/**
* @ClassName: AdministrativeAreaServiceImpl 
* @Description: TODO(地图服务的实现类) 
* @author 胡竞
* @date 2017年10月25日 上午11:26:44 
*
 */
@Service(version="1.0.0",interfaceClass=com.bz.open.core.service.map.AdministrativeAreaService.class)
public class AdministrativeAreaServiceImpl implements AdministrativeAreaService{
   private final Logger logger=LoggerFactory.getLogger(AdministrativeAreaServiceImpl.class);
	@Autowired
    RegionMapper regionMapper;
	@Value("${sms.apikey}")
	private String apikey;
	
	
	/**
	* @作者 胡竞
	* @Title: getProvinceLeveRegion 
	* @Description: TODO(获取一级行政区域的服务) 
	* @param @return
	* @param @throws ExternalException    设定文件 
	* @return List<Region>    返回类型 
	* @throws
	 */
	@Override
	public List<ReginResponsVo> getProvinceLeveRegion() throws ExternalException {
		logger.info("获取一级区域服务开始"+apikey);
		
		Region region=new Region();
		region.setLevel(1);
		//创建一个dao层regin集合
		List<Region> regions = new ArrayList<Region>();
		
		//得到dao层的regin集合
		regions =regionMapper.selectList(region);
		
		//创建一个保存到regin的集合
		List<ReginResponsVo> list = new ArrayList<ReginResponsVo>();
		
		for(Region daoRegion:regions) {
			ReginResponsVo regionVo = new ReginResponsVo();
			regionVo.setId(daoRegion.getId());
			regionVo.setNumber(daoRegion.getNumber());
			regionVo.setName(daoRegion.getName());
			regionVo.setParentcode(daoRegion.getParentcode());
			regionVo.setLevel(daoRegion.getLevel());
			regionVo.setCitycode(daoRegion.getCitycode());
			regionVo.setAdcode(daoRegion.getAdcode());
			regionVo.setLng(daoRegion.getLng());
			regionVo.setLat(daoRegion.getLat());
			regionVo.setPinyin(daoRegion.getPinyin());
			regionVo.setCreatetime(daoRegion.getCreatetime());
			list.add(regionVo);
		}
		return list;
	}
	/**
	* @作者 胡竞
	* @Title: getProvinceLeveRegion 
	* @Description: TODO(获取下级区域的服务) 
	* @param  id 
	* @param @throws ExternalException    设定文件 
	* @return List<Region>    返回类型 
	* @throws
	 */
	@Override
	public List<ReginResponsVo> getSubordinateRegionById(String id) throws ExternalException {
		logger.info("获取Id为：{}下级区域服务开始",id);
		Region region=new Region();
		region.setParentcode(id);
		
		//创建一个dao层regin集合
		List<Region> regions = new ArrayList<Region>();
		
		//得到dao层的regin集合
		regions =regionMapper.selectList(region);
		
		//创建一个保存到regin的集合
		List<ReginResponsVo> list = new ArrayList<ReginResponsVo>();
		for(Region daoRegion:regions) {
			ReginResponsVo regionVo = new ReginResponsVo();
			regionVo.setId(daoRegion.getId());
			regionVo.setNumber(daoRegion.getNumber());
			regionVo.setName(daoRegion.getName());
			regionVo.setParentcode(daoRegion.getParentcode());
			regionVo.setLevel(daoRegion.getLevel());
			regionVo.setCitycode(daoRegion.getCitycode());
			regionVo.setAdcode(daoRegion.getAdcode());
			regionVo.setLng(daoRegion.getLng());
			regionVo.setLat(daoRegion.getLat());
			regionVo.setPinyin(daoRegion.getPinyin());
			regionVo.setCreatetime(daoRegion.getCreatetime());
			list.add(regionVo);
		}
		
		return list;
	}

	/**
	 * @作者 陈青山
	 * @param id
	 * @return 返回中文地址
	 */
	@Override
	public String getSiteById(String  id) {
		logger.info("获取区域名称服务开始");
		Region region=new Region();
		region.setId(Integer.parseInt(id));
		region=regionMapper.selectOne(region);
		String site=region.getName()+" ";
		return site;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月27日上午10:02:03
	 * 描述:根据传入的Id获取上级Id
	 * @param id 下级ID
	 * @return 上级城市的ID
	 */
	@Override
	public Integer getUpLevel(Integer id) {
		logger.info("根据ID:{}查询上级ID",id);
		Region region=new Region();
		region.setId(id);
		try {
			region=regionMapper.selectOne(region);//根据ID查询当前对象
		} catch (Exception e) {
			logger.error("获取当前区域错误");
			return null;
		}
		Integer parentCode = Integer.parseInt(region.getParentcode());//获得parentCode
		return parentCode;
	}
}
