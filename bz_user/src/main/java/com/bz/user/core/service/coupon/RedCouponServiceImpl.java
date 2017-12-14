package com.bz.user.core.service.coupon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.bz.dao.mapper.user.UserRedpacketUserecordMapper;
import com.bz.dao.mapper.user.UserRedpacketWarehouseMapper;
import com.bz.dao.pojo.user.UserRedpacketUserecord;
import com.bz.dao.pojo.user.UserRedpacketWarehouse;
import com.bz.framework.error.exception.UserException;
import com.bz.framework.util.base.IntegerUtil;
import com.bz.framework.util.date.DateUtil;
import com.bz.framework.util.exception.BzfAssert;
import com.bz.open.core.service.merchant.MerchantBaseService;
import com.bz.open.core.service.merchant.MerchantRedCouponService;
import com.bz.open.core.service.upload.UploadOpenService;
import com.bz.open.core.service.user.RedCouponService;
import com.bz.open.core.service.user.UserBaseService;
import com.bz.open.core.service.weixin.WeixinMessageService;
import com.bz.open.core.vo.request.merchant.MerchantRedpacketSettingRequest;
import com.bz.open.core.vo.request.user.UserRedpacketUserecordRequestVo;
import com.bz.open.core.vo.request.user.UserRedpacketWareHouseRequestVo;
import com.bz.open.core.vo.request.weixin.WeixinMassMessageRequest;
import com.bz.open.core.vo.response.user.UserBaseResponseVo;
import com.bz.open.core.vo.response.user.UserRedpacketUserecordResponseVo;
import com.bz.open.core.vo.response.user.UserRedpacketWareHouseResponseVo;
/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年11月1日下午12:10:10
 * 描述:用户红包券服务实现
 * 备注:
 */
@Service(version="1.0.0",interfaceClass=com.bz.open.core.service.user.RedCouponService.class)
@Transactional
public class RedCouponServiceImpl implements RedCouponService{
	
	private final Logger logger = LoggerFactory.getLogger(RedCouponServiceImpl.class);
	@Autowired
	private UserRedpacketUserecordMapper userRedpacketUserecordMapper;
	@Autowired
	private UserRedpacketWarehouseMapper userRedpacketWarehouseMapper;
	@Autowired
	private UserBaseService userBaseService;
	@Reference(version="1.0.0")
	private WeixinMessageService weixinMessageService;
	@Reference(version="1.0.0")
	private MerchantBaseService merchantBaseService;
	@Reference(version="1.0.0")
	private UploadOpenService uploadOpenService;
	@Reference(version="1.0.0")
	private MerchantRedCouponService merchantRedCouponService;
//	private DateUtil dateUtil;

	/**
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年11月1日上午11:57:25
	 * 描述:获取用户所有的红包券信息
	 * 备注:
	 * @param userId 用户Id
	 * @return
	 * @throws UserException
	 */
	@Override
	public List<UserRedpacketWareHouseResponseVo> selectUserRedpacketWarehouse(Integer userId) throws UserException {
		logger.info("获取该用户所有红包劵信息:用户id="+userId);
		BzfAssert.isTrue(UserException.class, userId==null||userId.intValue()==0, "当前用户不存在");
		//dao层用户红包对象
		UserRedpacketWarehouse userRedpacketWarehouse =new UserRedpacketWarehouse();
		userRedpacketWarehouse.setUserid(userId);
		//用户红包响应集合
		List<UserRedpacketWareHouseResponseVo> UserRedpacketWareHouseResponseVoList=new ArrayList<UserRedpacketWareHouseResponseVo>();
		//用户红包集合
		List<UserRedpacketWarehouse> userRedpacketWarehouseList=new ArrayList<UserRedpacketWarehouse>();
		//查询用户红包
		try {
			userRedpacketWarehouseList=userRedpacketWarehouseMapper.selectList(userRedpacketWarehouse);
		} catch (Exception e) {
			logger.error("用户红包券服务查询用户红包券出现异常");
			e.printStackTrace();
		}
		for (UserRedpacketWarehouse userRedpacketWarehouse2 : userRedpacketWarehouseList) {
			UserRedpacketWareHouseResponseVo userRedpacketWareHouseResponseVo=new UserRedpacketWareHouseResponseVo();
			
			//ID
			userRedpacketWareHouseResponseVo.setId(userRedpacketWarehouse2.getId());
			//红包关联商家ID
			userRedpacketWareHouseResponseVo.setMerchantid(userRedpacketWarehouse2.getMerchantid());
			//红包是否使用
			userRedpacketWareHouseResponseVo.setIsuse(userRedpacketWarehouse2.getIsuse());
			//红包ID
			userRedpacketWareHouseResponseVo.setRpid(userRedpacketWarehouse2.getRpid());
			//红包金额
			userRedpacketWareHouseResponseVo.setRpmoney(userRedpacketWarehouse2.getRpmoney().toString());
			//用户ID
			userRedpacketWareHouseResponseVo.setUserid(userRedpacketWarehouse2.getUserid());
			//获取订单号
			userRedpacketWareHouseResponseVo.setOrdernumber(userRedpacketWarehouse2.getOrdernumber());
			//获取红包对应的商家
			try {
				userRedpacketWareHouseResponseVo.setMerchantName(merchantBaseService.getMerchantInfoById(userRedpacketWarehouse2.getMerchantid()).getName());
			} catch (Exception e) {
				logger.error("用户红包券查询对应商家名称出现异常");
				e.printStackTrace();
			}
			//获取商家设置红包使用限定金额
			MerchantRedpacketSettingRequest merchantRedpacketSettingRequest=new MerchantRedpacketSettingRequest();
			merchantRedpacketSettingRequest.setId(userRedpacketWarehouse2.getRpid());
			try {
				userRedpacketWareHouseResponseVo.setFulfilMoney(merchantRedCouponService.getMerchantRedpacketSettingByCondition(merchantRedpacketSettingRequest).getFulfilmoney());
			} catch (Exception e) {
				logger.error("用户红包券查询红包指定金额使用出现异常");
				e.printStackTrace();
			}
			//红包创建时间
			userRedpacketWareHouseResponseVo.setCreatetime(userRedpacketWarehouse2.getCreatetime());
			//红包到期时间
			userRedpacketWareHouseResponseVo.setEndtime(userRedpacketWarehouse2.getEndtime());
			
			//添加到userRedpacketWareHouseResponseVo的集合
			UserRedpacketWareHouseResponseVoList.add(userRedpacketWareHouseResponseVo);
		}
		
		return UserRedpacketWareHouseResponseVoList;
	}

	/**
	 * 
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年11月1日上午11:59:34
	 * 描述:获取用户红包券使用记录
	 * 备注:经胡竞更改返回参数由UserRedpacketUserecord 改为 UserRedpacketUserecordResponseVo
	 * @param userId 用户Id
	 * @return List<UserRedpacketUserecordResponseVo>
	 * @throws UserException {@link UserException} 用户服务异常封装
	 */
	@Override
	public List<UserRedpacketUserecordResponseVo> selectUserRedpacketUserecord(Integer userId) throws UserException {
		logger.info("获取该用户所有红包劵使用记录:用户id="+userId);
		BzfAssert.isTrue(UserException.class, userId==null||userId.intValue()==0, "当前用户不存在");
		UserRedpacketUserecord redpacketRserecord=new UserRedpacketUserecord();
		redpacketRserecord.setUserid(userId);
		UserRedpacketUserecordResponseVo userRedpacketUserecordResponseVo=new UserRedpacketUserecordResponseVo();
		List<UserRedpacketUserecordResponseVo> UserRedpacketUserecordResponseVoList=new ArrayList<UserRedpacketUserecordResponseVo>();
		List<UserRedpacketUserecord> UserRedpacketUserecordList=new ArrayList<UserRedpacketUserecord>();
		UserRedpacketUserecordList=userRedpacketUserecordMapper.selectList(redpacketRserecord);
		for (UserRedpacketUserecord userRedpacketUserecord : UserRedpacketUserecordList) {
			try {
				BeanUtils.copyProperties(userRedpacketUserecordResponseVo, userRedpacketUserecord);
			} catch (IllegalAccessException e) {
				logger.error("bean的转换错误，【userRedpacketUserecord:"+userRedpacketUserecord+"】转换成【userRedpacketUserecordResponseVo:"+userRedpacketUserecordResponseVo+"】");
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				logger.error("bean的转换错误，【userRedpacketUserecord:"+userRedpacketUserecord+"】转换成【userRedpacketUserecordResponseVo:"+userRedpacketUserecordResponseVo+"】");
				e.printStackTrace();
			}
			UserRedpacketUserecordResponseVoList.add(userRedpacketUserecordResponseVo);
		}
		return UserRedpacketUserecordResponseVoList;
	}

	/**
	 * 
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年11月1日下午12:01:01
	 * 描述:用户领取红包券服务
	 * 备注:
	 * @param redpacketWarehouse {@link UserRedpacketWarehouse} 红包券领取记录封装
	 * @throws UserException {@link UserException} 用户服务异常封装
	 */
	@Override
	public void addUserRedpacket(UserRedpacketWareHouseRequestVo redpacketWarehouseRequestVo) throws UserException {
		logger.info("添加用户领取红包劵的信息:"+redpacketWarehouseRequestVo);
		BzfAssert.isTrue(UserException.class,null==redpacketWarehouseRequestVo, "增加用户红包券记录错误对象【UserRedpacketWarehouse】为空");
		BzfAssert.isTrue(UserException.class, redpacketWarehouseRequestVo.getUserid()==null||redpacketWarehouseRequestVo.getUserid().intValue()==0,"增加用户红包券记录错误对象【UserRedpacketWarehouse】属性【userid】为空");
		BzfAssert.isTrue(UserException.class, redpacketWarehouseRequestVo.getRpmoney().signum()!=1, "增加用户红包券记录错误对象【UserRedpacketWarehouse】属性【rpmoney】格式错误");
		BzfAssert.isTrue(UserException.class, redpacketWarehouseRequestVo.getRpid()==null||redpacketWarehouseRequestVo.getRpid().intValue()==0, "增加用户红包券记录错误对象【UserRedpacketWarehouse】属性【rpid】关联红包设置有误");
		BzfAssert.isTrue(UserException.class, redpacketWarehouseRequestVo.getEndtime()==null,"增加用户红包券记录错误对象【UserRedpacketWarehouse】属性【endtime】为空");
		UserRedpacketWarehouse userRedpacketWarehouse=new UserRedpacketWarehouse();
		try {
			BeanUtils.copyProperties(userRedpacketWarehouse, redpacketWarehouseRequestVo);
		} catch (IllegalAccessException e1) {
			logger.error("bean转换有误,【redpacketWarehouseRequestVo:"+redpacketWarehouseRequestVo+"】转换成【userRedpacketWarehouse:"+userRedpacketWarehouse+"】");
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			logger.error("bean转换有误,【redpacketWarehouseRequestVo:"+redpacketWarehouseRequestVo+"】转换成【userRedpacketWarehouse:"+userRedpacketWarehouse+"】");
			e1.printStackTrace();
		}
		logger.info("用户领取红包入库");
		Integer rows = userRedpacketWarehouseMapper.save(userRedpacketWarehouse);
		if(rows>0) {
			//发送图文消息
			UserBaseResponseVo user = userBaseService.getUserBaseInfo(redpacketWarehouseRequestVo.getUserid());
			WeixinMassMessageRequest message = new WeixinMassMessageRequest();
			message.setFileType("jpg");
			message.setTilte("您有一个新红包");
			message.setCount("您刚才收到了一个新的红包!");
			message.setWeixinUserOpenId(user.getWechatopenid());
			message.setSendToOne(true);
			InputStream is = null;
			try {
				is = new FileInputStream(new File("F:\\image\\1.jpg"));
			} catch (FileNotFoundException e) {
				logger.error("发送微信通知用户领取红包消息失败:错误信息如下:"+e);
				e.printStackTrace();
			}
			message.setCreateTime(DateUtil.getNowTime());
			boolean send = true;
			try {
				send = weixinMessageService.sendImageTextMessage(message,is);
				if(send) {
					logger.info("发送微信通知用户领取红包消息成功----发送结果:"+send);
				}else {
					logger.info("发送微信通知用户领取红包消息失败----发送结果:"+send);
				}
			} catch (Exception e) {
				logger.error("发送微信通知失败:失败原因是:"+e);
				e.printStackTrace();
			}
		}else {
			logger.error("该用户红包劵信息入库失败！");
		}
	}

	/**
     * 
     * 
     * 作者:唐鹏
     * 创建时间:2017年11月1日下午12:03:52
     * 描述:判断当前用户当前红包券是否能使用
     * 备注:
     * @param userId:用户Id
     * @param redpacketId:红包券Id
     * @return
     * @throws UserException {@link UserException} 用户服务异常封装
     */
	@Override
	public boolean isCanUseCurryRedpacket(Integer userId, Integer redpacketId) throws UserException {
		logger.info("判断该用户当前红包劵的有效性:用户id="+userId+",红包劵id="+redpacketId);
		if(userId==null||redpacketId==null) {
			return false;
		}
		//查询我的红包券信息
		UserRedpacketWarehouse redpacketWarehouse=new UserRedpacketWarehouse();
		redpacketWarehouse.setUserid(userId);
		redpacketWarehouse.setRpid(redpacketId);
		redpacketWarehouse=	userRedpacketWarehouseMapper.selectOne(redpacketWarehouse);
		logger.info("获得当前用户的红包劵信息:"+redpacketWarehouse);
		if(redpacketWarehouse.getId()==null) {
			return false;
		}
		//判断当前红包券是否使用
		if(redpacketWarehouse.getIsuse().intValue()!=0){
			return false;
		}
		//判断红包券是否过期
		if(DateUtil.compareDateWithNow(redpacketWarehouse.getEndtime())<=0) {
			return false;
		}
		return true;
	}

	/**
     * 
     * 
     * 作者:唐鹏
     * 创建时间:2017年11月1日下午1:43:24
     * 描述:获取用户有效红包券
     * 备注:
     * @return
     * @throws UserException
     */
	@Override
	public List<UserRedpacketWareHouseResponseVo> selectEffectiveUserRedpacketWarehouse(Integer userId) throws UserException {
		logger.info("获取该用户有效的红包劵:用户id="+userId);
		BzfAssert.isTrue(UserException.class, userId==null||userId.intValue()==0, "当前用户不存在");
		UserRedpacketWareHouseResponseVo userRedpacketWareHouseResponseVo=new UserRedpacketWareHouseResponseVo();
		UserRedpacketWarehouse userRedpacketWarehouse=new UserRedpacketWarehouse();
		userRedpacketWarehouse.setUserid(userId);
		userRedpacketWarehouse.setIsuse(0);
		List<UserRedpacketWareHouseResponseVo> UserRedpacketWareHouseResponseVoList=new ArrayList<UserRedpacketWareHouseResponseVo>();
		List<UserRedpacketWarehouse> userRedpacketWarehouseList=new ArrayList<UserRedpacketWarehouse>();
		userRedpacketWarehouseList=userRedpacketWarehouseMapper.selectList(userRedpacketWarehouse);
		for (UserRedpacketWarehouse userRedpacketWarehouse2 : userRedpacketWarehouseList) {
			try {
				BeanUtils.copyProperties(userRedpacketWareHouseResponseVo, userRedpacketWarehouse2);
			} catch (IllegalAccessException e) {
				logger.error("bean类型转换有误,【userRedpacketWarehouse2:"+userRedpacketWarehouse2+"】转换为【userRedpacketWareHouseResponseVo:"+userRedpacketWareHouseResponseVo+"】");
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				logger.error("bean类型转换有误,【userRedpacketWarehouse2:"+userRedpacketWarehouse2+"】转换为【userRedpacketWareHouseResponseVo:"+userRedpacketWareHouseResponseVo+"】");
				e.printStackTrace();
			}
			UserRedpacketWareHouseResponseVoList.add(userRedpacketWareHouseResponseVo);
		}
		return UserRedpacketWareHouseResponseVoList;
	}

	/**
     * 
     * 
     * 作者:唐鹏
     * 创建时间:2017年11月3日上午9:57:23
     * 描述:根据条件查询用户的红包券信息
     * 备注:
     * @param redpacketWarehouse {@link UserRedpacketWarehouse} 条件信息封装
     * @return
     * @throws UserException {@link UserException} 用户服务异常封装
     */
	@Override
	public UserRedpacketWareHouseResponseVo selectUserUserRedpacketWarehouseByCondition(UserRedpacketWareHouseRequestVo redpacketWarehouseRequestVo)
			throws UserException {
		logger.info("根据条件查询用户的红包劵信息:条件信息封装="+redpacketWarehouseRequestVo);
		if(null!=redpacketWarehouseRequestVo) {
			UserRedpacketWarehouse userRedpacketWarehouse=new UserRedpacketWarehouse();
			try {
				BeanUtils.copyProperties(userRedpacketWarehouse, redpacketWarehouseRequestVo);
			} catch (IllegalAccessException e) {
				logger.error("bean类型转换有误,【redpacketWarehouseRequestVo:"+redpacketWarehouseRequestVo+"】转换为【userRedpacketWarehouse:"+userRedpacketWarehouse+"】");
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				logger.error("bean类型转换有误,【redpacketWarehouseRequestVo:"+redpacketWarehouseRequestVo+"】转换为【userRedpacketWarehouse:"+userRedpacketWarehouse+"】");
				e.printStackTrace();
			}
			userRedpacketWarehouse=userRedpacketWarehouseMapper.selectOne(userRedpacketWarehouse);
			UserRedpacketWareHouseResponseVo userRedpacketWareHouseResponseVo=new UserRedpacketWareHouseResponseVo();
			try {
				BeanUtils.copyProperties(userRedpacketWareHouseResponseVo, userRedpacketWarehouse);
			} catch (IllegalAccessException e) {
				logger.error("bean类型转换有误,【userRedpacketWarehouse:"+userRedpacketWarehouse+"】转换为【userRedpacketWareHouseResponseVo:"+userRedpacketWareHouseResponseVo+"】");
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				logger.error("bean类型转换有误,【userRedpacketWarehouse:"+userRedpacketWarehouse+"】转换为【userRedpacketWareHouseResponseVo:"+userRedpacketWareHouseResponseVo+"】");
				e.printStackTrace();
			}
			
		return 	userRedpacketWareHouseResponseVo;
		}
		return null;
	}

	/**
     * 
     * 
     * 作者:唐鹏
     * 创建时间:2017年11月3日上午10:17:42
     * 描述:锁定用户红包券
     * 备注:
     * @param couponId 用户红包券Id
     * @return
     * @throws UserException {@link UserException} 用户服务异常封装
     */
	@Override
	public boolean lockUserCoupon(Integer couponId) throws UserException {
		logger.info("锁定红包劵:红包劵id="+couponId);
		if(!IntegerUtil.isEmpty(couponId)) {
			UserRedpacketWarehouse redpacketWarehouse=new UserRedpacketWarehouse();
			redpacketWarehouse.setRpid(couponId);
			redpacketWarehouse = userRedpacketWarehouseMapper.selectOne(redpacketWarehouse);
			logger.info("获取当前用户被锁定前的红包信息:"+redpacketWarehouse);
			redpacketWarehouse.setIsuse(1);
			userRedpacketWarehouseMapper.update(redpacketWarehouse);
			return true;
		}
		return false;
	}

	/**
     * 
     * 作者:唐鹏
     * 创建时间:2017年11月1日下午12:02:10
     * 描述:用户使用红包券记录添加
     * 备注:胡竞更改了参数
     * @param redpacketUserecord {@link UserRedpacketUserecord} 红包券使用记录封装
     * @throws UserException {@link UserException} 用户服务异常封装
     */
	@Override
	public void adduseRedpacket(UserRedpacketUserecordRequestVo userRedpacketUserecordRequestVo) throws UserException {
		logger.info("添加用户使用红包劵记录信息:"+userRedpacketUserecordRequestVo);
		BzfAssert.isTrue(UserException.class,null==userRedpacketUserecordRequestVo, "增加用户红包券使用记录错误对象【UserRedpacketRserecord】为空");
		BzfAssert.isTrue(UserException.class, userRedpacketUserecordRequestVo.getUserid()==null||userRedpacketUserecordRequestVo.getUserid().intValue()==0,"增加用户红包券使用记录错误对象【UserRedpacketWarehouse】属性【userid】为空");
		BzfAssert.isTrue(UserException.class, userRedpacketUserecordRequestVo.getUsemoney()==null||userRedpacketUserecordRequestVo.getUsemoney().doubleValue()==0, "增加用户红包券使用记录错误对象【UserRedpacketRserecord】属性【usemoney】格式错误");
		BzfAssert.isTrue(UserException.class, userRedpacketUserecordRequestVo.getRpid()==null||userRedpacketUserecordRequestVo.getRpid().intValue()==0, "增加用户红包券使用记录错误对象【UserRedpacketRserecord】属性【rpid】关联红包设置有误");
		BzfAssert.isTrue(UserException.class, userRedpacketUserecordRequestVo.getUsetime()==null,"增加用户红包券使用记录错误对象【UserRedpacketRserecord】属性【usetime】为空");
		BzfAssert.isTrue(UserException.class, userRedpacketUserecordRequestVo.getOrderno()==null||userRedpacketUserecordRequestVo.getOrderno().equals(""),"增加用户红包券使用记录错误对象【UserRedpacketRserecord】属性【orderno】为空");
		logger.info("用户红包使用记录入库");
		UserRedpacketUserecord userRedpacketUserecord=new UserRedpacketUserecord();
		try {
			BeanUtils.copyProperties(userRedpacketUserecord, userRedpacketUserecordRequestVo);
		} catch (IllegalAccessException e) {
			logger.error("bean转换有误,【redpacketUserecordResponseVo:"+userRedpacketUserecordRequestVo+"】转换成【userRedpacketUserecord:"+userRedpacketUserecord+"】");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			logger.error("bean转换有误,【redpacketUserecordResponseVo:"+userRedpacketUserecordRequestVo+"】转换成【userRedpacketUserecord:"+userRedpacketUserecord+"】");
			e.printStackTrace();
		}
		userRedpacketUserecordMapper.save(userRedpacketUserecord);
		
	}

}
