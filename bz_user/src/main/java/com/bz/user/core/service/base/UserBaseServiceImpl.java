package com.bz.user.core.service.base;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.bz.dao.mapper.user.UserBaseMapper;
import com.bz.dao.pojo.user.UserBase;
import com.bz.framework.error.exception.UserException;
import com.bz.framework.util.exception.BzfAssert;
import com.bz.framework.util.number.BzCodeGenerate;
import com.bz.open.core.service.user.UserBaseService;
import com.bz.open.core.vo.response.user.UserBaseResponseVo;

import me.chanjar.weixin.mp.bean.result.WxMpUser;
@Service(version="1.0.0",interfaceClass=com.bz.open.core.service.user.UserBaseService.class)
@Transactional
public class UserBaseServiceImpl implements UserBaseService{

	private final Logger logger=LoggerFactory.getLogger(UserBaseServiceImpl.class);
	
	@Autowired
	private UserBaseMapper userBaseMapper;
	
	
	@Override
	public UserBaseResponseVo getUserBaseInfo(Integer userId) throws UserException {
		logger.info("根据用户Id查询用户基本信息userId:【"+userId+"】");
		BzfAssert.isTrue(UserException.class, userId==null, "根据用户Id查询用户基本信息userId为null");
		UserBaseResponseVo userBaseVo=new UserBaseResponseVo();
		try {
			UserBase userBase=new UserBase();
			userBase=userBaseMapper.selectById(userId);
			BeanUtils.copyProperties(userBaseVo, userBase);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userBaseVo;
	}


	@Override
	public List<UserBaseResponseVo> getRegionUserBase(Integer regionId) throws UserException{
		logger.info("根据地区查询当前地区所有用户基本信息,【regionId:"+regionId+"】");
		BzfAssert.isNull(UserException.class,regionId==null , "需要查询的地区id为空,【regionId:"+regionId+"】");
		UserBase base=new UserBase();
		base.setProvinceid(regionId);
		base.setDistrictid(regionId);
		base.setCountyid(regionId);
		UserBaseResponseVo userBaseVo=new UserBaseResponseVo();
		List<UserBaseResponseVo> userBaseVoList=new ArrayList<UserBaseResponseVo>();
		List<UserBase> userBaseList=new ArrayList<UserBase>();
		userBaseList=userBaseMapper.selectRegion(regionId);
		for (UserBase userBase : userBaseList) {
			try {
				BeanUtils.copyProperties(userBaseVo, userBase);
				userBaseVoList.add(userBaseVo);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userBaseVoList;
	}


	@Override
	public UserBaseResponseVo getUserByOpenId(String openId) throws UserException {
		logger.info("传入参数【openId："+openId+"】");
		BzfAssert.isNull(UserException.class, openId==null,"需要查询的【openId】为空，【openId:"+openId+"】");
		UserBaseResponseVo userBaseVo=new UserBaseResponseVo();
		try {
			UserBase user=new UserBase();
			user=userBaseMapper.selectUserByOpenId(openId);
			BeanUtils.copyProperties(userBaseVo, user);
		} catch (IllegalAccessException e) {
			logger.error("用户中心通过OpenId查询用户出现异常");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			logger.error("用户中心通过OpenId查询用户出现异常");
			e.printStackTrace();
		}
		return userBaseVo;
	}


	@Override
	public UserBaseResponseVo getUserByWeiXinUser(WxMpUser user) throws UserException {
		logger.info("传入的微信对象:【WxMpUser:"+user+"】");
		//dao层user对象
		UserBase userBase=new UserBase();
		//用户基础响应类
		UserBaseResponseVo userBaseResponseVo=new UserBaseResponseVo();
		//注入openID，并查询这个openID的用户
		userBase.setWechatopenid(user.getOpenId());
		userBase=userBaseMapper.selectOne(userBase);
		if(userBase==null) {
			logger.info("查询的【UserBase:"+userBase+"】为空，因此新建一个user对象");
			userBase=new UserBase();
			//设置用户名
			userBase.setWechatname(user.getNickname());;
			//设置微信头像
			userBase.setWechatimage(user.getHeadImgUrl());
			//设置微信openID
			userBase.setWechatopenid(user.getOpenId());
			//设置创建时间
			userBase.setCreatetime(new Date());
			//编号生成
			userBase.setNumber(BzCodeGenerate.getSysNumber());
			//初始化用户属性
			userBase.setType("1");
			
			//添加用户
			try {
				userBaseMapper.insertSelective(userBase);
			} catch (Exception e) {
				logger.error("添加新用户出现异常");
				e.printStackTrace();
			}
		}else {
			//更新用户名
			userBase.setWechatname(user.getNickname());;
			//更新微信头像
			userBase.setWechatimage(user.getHeadImgUrl());
			//更新数据库
			try {
				userBaseMapper.update(userBase);
			} catch (Exception e) {
				logger.error("更新用户微信名称、微信头像出现异常");
				e.printStackTrace();
			}
		}
		
		userBaseResponseVo.setId(userBase.getId());
		userBaseResponseVo.setNumber(userBase.getNumber());
		if(StringUtils.isEmpty(userBase.getName())) {
			userBaseResponseVo.setName(userBase.getWechatname());
		}else {
			userBaseResponseVo.setName(userBase.getName());
		}
		userBaseResponseVo.setWechatimage(userBase.getWechatimage());
		
		return userBaseResponseVo;
	}


	

}
