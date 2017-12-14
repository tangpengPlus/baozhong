package com.bz.thirdparty.map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bz.open.core.service.map.AdministrativeAreaService;

/**
* @ClassName: AdministrativeAreaTest 
* @Description: TODO(行政区域查询的测试类) 
* @author 胡竞
* @date 2017年10月25日 上午11:28:01 
*
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdministrativeAreaTest {
	private final Logger logger=LoggerFactory.getLogger(AdministrativeAreaTest.class);
	
	
	@Autowired
	private AdministrativeAreaService administrativeAreaService;
	
	/**
	* @作者 胡竞
	* @Title: testGetProvinceLeveRegion 
	* @Description: TODO(查询行政区域的测试方法) 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@Test
	public void testGetProvinceLeveRegion() {
		logger.info("获取到所有一级城市信息是:"+administrativeAreaService.getProvinceLeveRegion(null));
		logger.info("获取到所有当前ID下级区域信息:"+administrativeAreaService.getSubordinateRegionById("2"));
		
	}
}
