package com.bz.merchant.core.service.regist;


import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.bz.dao.mapper.merchant.MerchantShopMapper;
import com.bz.dao.pojo.merchant.MerchantShop;
import com.bz.framework.error.exception.MerchantException;

import com.bz.framework.util.base.IntegerUtil;
import com.bz.framework.util.exception.BzfAssert;
import com.bz.open.core.service.merchant.MerchantShopRegistService;
import com.bz.open.core.vo.request.merchant.MerchantShopRequestVo;
import com.bz.open.core.vo.response.merchant.MerchantShopResponseVo;
/**
 * 
 * 
 * 作者: 彭云山
 * 描述:添加商铺实现类
 * 创建时间:2017年11月7日下午7:53:55
 * 修改备注:
 */
@Service(version="1.0.0",interfaceClass=com.bz.open.core.service.merchant.MerchantShopRegistService.class)
@Transactional
public class MerchantShopImpl implements MerchantShopRegistService {
	private final Logger logger = LoggerFactory.getLogger(MerchantShopImpl.class);
	@Autowired
	private MerchantShopMapper merchantShopMapper;
	/**
	 * 添加商铺服务接口实现类
	 */
	@Override
	public Integer addMerchantShop(MerchantShopRequestVo shop) throws MerchantException{
		logger.info("初始化添加商铺接口实现");
		MerchantShop daoshop = new MerchantShop();
		try {
			BeanUtils.copyProperties(daoshop,shop);
		} catch (IllegalAccessException e) {
			logger.error("bean转换错误,【MerchantShopRequestVo:"+shop+"】转换成【MerchantShop:"+daoshop+"】有误");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			logger.error("bean转换错误,【MerchantShopRequestVo:"+shop+"】转换成【MerchantShop:"+daoshop+"】有误");
			e.printStackTrace();
			throw new MerchantException("添加商铺信息错误");
		}
		merchantShopMapper.insertSelective(daoshop);
		return daoshop.getId();
	}
	
	/**
	 * 修改商铺服务接口实现类
	 */
	@Override
	public void updateMerchantShop(MerchantShopRequestVo shop) throws MerchantException {
		logger.info("修改商家基础信息 MerchantShopRequestVo:{}",shop);
		BzfAssert.isNull(MerchantException.class, shop,"修改商家基础信息对象 MerchantShopRequestVo为null");
		MerchantShop  shops=new MerchantShop();
		try {
			BeanUtils.copyProperties(shops,shop);
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.error("转换异常MerchantShopRequestVo--->MerchantShop");
			e.printStackTrace();
		}
		merchantShopMapper.updateByPrimaryKeySelective(shops);
	}
	
	/**
	 * 根据ID查询商铺信息
	 */
	@Override
	public MerchantShopResponseVo selectMerchantShopById(Integer shopId) throws MerchantException {
		logger.info("查询的店铺ID为:【shopId:"+shopId+"】");
		if(IntegerUtil.isEmpty(shopId)) {
			logger.error("传入的商铺ID为空,【shopId:"+shopId+"】");
			return null;
		}
		//查询店铺信息
		MerchantShop shop= merchantShopMapper.selectById(shopId);
		//商铺响应类
		MerchantShopResponseVo merchantShopResponseVo=new MerchantShopResponseVo();
		try {
			BeanUtils.copyProperties(merchantShopResponseVo, shop);
		} catch (IllegalAccessException e) {
			logger.error("bean转换有误,【MerchantShop:"+shop+"】复制到【MerchantShopResponseVo:"+merchantShopResponseVo+"】有误");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			logger.error("bean转换有误,【MerchantShop:"+shop+"】复制到【MerchantShopResponseVo:"+merchantShopResponseVo+"】有误");
			e.printStackTrace();
		}
		return merchantShopResponseVo;
	}

}
