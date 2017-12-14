 package com.bz.merchant.core.service.coupon;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.bz.dao.mapper.merchant.MerchantRedpacketGrantRecordMapper;
import com.bz.dao.mapper.merchant.MerchantRedpacketSettingMapper;
import com.bz.dao.mapper.merchant.MerchantRedpacketUseRecordMapper;
import com.bz.dao.pojo.merchant.MerchantRedpacketGrantRecord;
import com.bz.dao.pojo.merchant.MerchantRedpacketSetting;
import com.bz.dao.pojo.merchant.MerchantRedpacketUseRecord;
import com.bz.framework.error.exception.MerchantException;
import com.bz.framework.util.exception.BzfAssert;
import com.bz.open.core.service.merchant.MerchantMemberService;
import com.bz.open.core.service.merchant.MerchantRedCouponService;
import com.bz.open.core.vo.request.merchant.MerchantRedpacketGrantRecordRequest;
import com.bz.open.core.vo.request.merchant.MerchantRedpacketSettingRequest;
import com.bz.open.core.vo.request.merchant.MerchantRedpacketUseRecordRequest;
import com.bz.open.core.vo.response.merchant.MerchantRedpacketSettingResponseVo;

/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年11月2日下午4:16:39
 * 描述:商户红包券开放服务实现
 * 备注:
 */
@Service(version="1.0.0",interfaceClass=com.bz.open.core.service.merchant.MerchantRedCouponService.class)
@Transactional
public class MerchantRedCouponServiceImpl implements MerchantRedCouponService{
     
	private final Logger logger=LoggerFactory.getLogger(MerchantRedCouponServiceImpl.class);
	
	@Autowired
	private MerchantRedpacketSettingMapper merchantRedpacketSettingMapper;
	@Autowired
	private MerchantRedpacketGrantRecordMapper merchantRedpacketGrantRecordMapper;
	@Autowired
	private MerchantRedpacketUseRecordMapper merchantRedpacketUseRecordMapper;
	@Autowired
	private MerchantMemberService merchantMemberService;
	
	
	
	/**
	 * 
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年11月2日上午10:53:39
	 * 描述:验证用户付款金额合法性
	 * 备注:
	 * @param totalMoney: 支付总金额
	 * @param deductible: 抵扣金额
	 * @param redCouponId : 红包券Id
	 * @param userId : 用户Id
	 * @return ture:金额计算正常 false:计算错误
	 * @throws MerchantException ${@link MerchantException} 商家板块异常信息封装
	 */
	@Override
	public boolean checkRedCouponAmount(BigDecimal totalMoney,BigDecimal deductible,
			Integer redCouponId,Integer userId) throws MerchantException {
		this.logger.info("检查用户红包券的使用请求参数详情【totalMoney】{},【deductible】{},【redCouponId】{},【userId】{}]",totalMoney,deductible,redCouponId);
		if(totalMoney==null||deductible==null||redCouponId==null||userId==null) {
			this.logger.info("检查用户红包券的使用请求参数不全");	
			return false;
		}
		MerchantRedpacketSetting merchantRedpacketSetting=merchantRedpacketSettingMapper.selectById(redCouponId);
		if(null==merchantRedpacketSetting) {
		this.logger.info("检查用户红包券的使用当前红包券信息不存在");	
			return false;
		}
		//判断是否超过最大值
		if(deductible.compareTo(merchantRedpacketSetting.getRpmoney())>0) {
			this.logger.info("检查用户红包券的使用==>【抵扣金额:deductible："+deductible+"】超过该红包的最大值："+merchantRedpacketSetting.getRpmoney());
		    return false;
		}
		//判断当前用户是否为该商家的新会员
		if(merchantMemberService.isNewMember(userId,merchantRedpacketSetting.getMerchantid())) {
			logger.info("当前为新用户");
			
			return totalMoney.multiply(BigDecimal.valueOf(merchantRedpacketSetting.getNewuserproportion())).setScale(2, BigDecimal.ROUND_HALF_UP).compareTo(deductible)>=0?true:false;
		}else {
			logger.info("当前为老用户");
			return totalMoney.multiply(BigDecimal.valueOf(merchantRedpacketSetting.getOlduserproportion())).setScale(2, BigDecimal.ROUND_HALF_UP).compareTo(deductible)>=0?true:false;
		}
	}

	/**
	 * 
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年11月3日上午9:51:11
	 * 描述:条件查询商家红包券设置信息
	 * 备注:
	 * @param merchantRedpacketSetting {@link MerchantRedpacketSetting} 条件封装
	 * @return
	 * @throws MerchantException {@link MerchantException} 商户异常类型封装
	 */
	@Override
	public MerchantRedpacketSettingResponseVo getMerchantRedpacketSettingByCondition(
			MerchantRedpacketSettingRequest merchantRedpacketSettingRequest) throws MerchantException {
		logger.info("根据条件查询商家的设置信息:条件【merchantRedpacketSetting】="+merchantRedpacketSettingRequest);
		if(merchantRedpacketSettingRequest!=null) {
			MerchantRedpacketSettingResponseVo merchantRedpacketSettingResponse=new MerchantRedpacketSettingResponseVo();
			MerchantRedpacketSetting merchantRedpacketSetting=new MerchantRedpacketSetting();
			try {
				BeanUtils.copyProperties(merchantRedpacketSetting, merchantRedpacketSettingRequest);
			} catch (IllegalAccessException e) {
				logger.error("bean类型转换有误,【merchantRedpacketSettingRequest:"+merchantRedpacketSettingRequest+"】转换到【merchantRedpacketSetting:"+merchantRedpacketSetting+"】有误");
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				logger.error("bean类型转换有误,【merchantRedpacketSettingRequest:"+merchantRedpacketSettingRequest+"】转换到【merchantRedpacketSetting:"+merchantRedpacketSetting+"】有误");
				e.printStackTrace();
			}
			merchantRedpacketSetting=merchantRedpacketSettingMapper.selectOne(merchantRedpacketSetting);
			//id
			merchantRedpacketSettingResponse.setId(merchantRedpacketSetting.getId());
			//商户ID
			merchantRedpacketSettingResponse.setMerchantid(merchantRedpacketSetting.getMerchantid());
			//红包编号
			merchantRedpacketSettingResponse.setRpno(merchantRedpacketSetting.getRpno());
			//红包最大金额
			merchantRedpacketSettingResponse.setRpmoney(merchantRedpacketSetting.getRpmoney().toString());
			//是否开启红包
			merchantRedpacketSettingResponse.setIsstart(merchantRedpacketSetting.getIsstart());
			//红包券满足金额使用
			merchantRedpacketSettingResponse.setFulfilmoney(merchantRedpacketSetting.getFulfilmoney().toString());
			/*try {
				BeanUtils.copyProperties(merchantRedpacketSettingResponse, merchantRedpacketSetting);
			} catch (IllegalAccessException e) {
				logger.error("bean类型转换有误,【merchantRedpacketSetting:"+merchantRedpacketSetting+"】转换到【merchantRedpacketSettingResponse:"+merchantRedpacketSettingResponse+"】有误");
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				logger.error("bean类型转换有误,【merchantRedpacketSetting:"+merchantRedpacketSetting+"】转换到【merchantRedpacketSettingResponse:"+merchantRedpacketSettingResponse+"】有误");
				e.printStackTrace();
			}*/
			
			return merchantRedpacketSettingResponse;
		}
		return null;
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 商铺添加或更新红包劵设置信息
	 * 创建时间:2017年11月7日下午1:48:16
	 * @param merchantRedpacketSetting
	 */
	@Override
	public void addMerchantRedpacket(MerchantRedpacketSettingRequest merchantRedpacketSettingRequest) {
		logger.info("商铺添加新红包劵设置信息:红包设置信息【merchantRedpacketSetting】="+merchantRedpacketSettingRequest);
		if(null==merchantRedpacketSettingRequest) {
			logger.error("红包设置信息为空");
		}
		if(merchantRedpacketSettingRequest.getIsstart()!=0) {
			logger.error("该商铺还未开通红包功能");
		}else {
			MerchantRedpacketSetting merchantRedpacketSetting=new MerchantRedpacketSetting();
			if(merchantRedpacketSettingRequest.getId()==null) {
				logger.info("添加新的红包劵设置信息");
				try {
					BeanUtils.copyProperties(merchantRedpacketSetting, merchantRedpacketSetting);
				} catch (IllegalAccessException e) {
					logger.error("bean转换错误,【merchantRedpacketSetting:"+merchantRedpacketSetting+"】转换为【merchantRedpacketSetting:"+merchantRedpacketSetting+"】");
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					logger.error("bean转换错误,【merchantRedpacketSetting:"+merchantRedpacketSetting+"】转换为【merchantRedpacketSetting:"+merchantRedpacketSetting+"】");
					e.printStackTrace();
				}
				merchantRedpacketSettingMapper.save(merchantRedpacketSetting);
			}else {
				logger.info("修改当前红包劵设置信息");
				try {
					BeanUtils.copyProperties(merchantRedpacketSetting, merchantRedpacketSettingRequest);
				} catch (IllegalAccessException e) {
					logger.error("bean转换错误,【merchantRedpacketSetting:"+merchantRedpacketSetting+"】转换为【merchantRedpacketSetting:"+merchantRedpacketSetting+"】");
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					logger.error("bean转换错误,【merchantRedpacketSetting:"+merchantRedpacketSetting+"】转换为【merchantRedpacketSetting:"+merchantRedpacketSetting+"】");
					e.printStackTrace();
				}
				merchantRedpacketSettingMapper.update(merchantRedpacketSetting);
			}
		}
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 添加红包发放记录
	 * 创建时间:2017年11月6日上午1:13:20
	 * @param record {@link MerchantRedpacketGrantRecord} 红包领取记录类
	 * @throws MerchantException {@link MerchantException} 商户异常类型封装
	 */
	@Override
	public void addGrantRecord(MerchantRedpacketGrantRecordRequest record) throws MerchantException {
		logger.info("开始记录红包发放消息:"+record);
		MerchantRedpacketSettingRequest redpacketSetting = new MerchantRedpacketSettingRequest();
		redpacketSetting.setMerchantid(record.getShopid());
		MerchantRedpacketSettingResponseVo merchantRedpacketSettingResponse = this.getMerchantRedpacketSettingByCondition(redpacketSetting);
		if(merchantRedpacketSettingResponse.getIsstart()==0) {
			BzfAssert.isTrue(MerchantException.class,null==record, "增加商铺红包券领取记录错误对象【MerchantRedpacketGrantRecord】为空");
			BzfAssert.isTrue(MerchantException.class, record.getUserid()==null||record.getUserid().intValue()==0,"增加商铺红包券领取记录错误对象【MerchantRedpacketGrantRecord】属性【userid】为空");
			BzfAssert.isTrue(MerchantException.class, record.getShopid()==null||record.getShopid().intValue()==0, "增加商铺红包券领取记录错误对象【MerchantRedpacketGrantRecord】属性【shopid】关联商铺有误");
			BzfAssert.isTrue(MerchantException.class, record.getRpid()==null||record.getRpid().intValue()==0, "增加商铺红包券领取记录错误对象【MerchantRedpacketGrantRecord】属性【rpid】关联红包有误");
			BzfAssert.isTrue(MerchantException.class, record.getOrderno()==null||record.getOrderno().equals(""), "增加商铺红包券领取记录错误对象【MerchantRedpacketGrantRecord】属性【orderno】关联订单有误");
			BzfAssert.isTrue(MerchantException.class, record.getCreatetime()==null,"增加商铺红包券领取记录错误对象【MerchantRedpacketGrantRecord】属性【createtime】为空");
			MerchantRedpacketGrantRecord merchantRedpacketGrantRecord=new MerchantRedpacketGrantRecord();
			try {
				BeanUtils.copyProperties(merchantRedpacketGrantRecord, record);
			} catch (IllegalAccessException e) {
				logger.error("bean转换错误,【record:"+record+"】转换为【merchantRedpacketGrantRecord:"+merchantRedpacketGrantRecord+"】");
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				logger.error("bean转换错误,【record:"+record+"】转换为【merchantRedpacketGrantRecord:"+merchantRedpacketGrantRecord+"】");
				e.printStackTrace();
			}
			merchantRedpacketGrantRecordMapper.save(merchantRedpacketGrantRecord);
		}else {
			logger.error("还未开通红包功能");
		}
	}

	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 添加红包使用记录
	 * 创建时间:2017年11月6日上午1:16:04
	 * @param record {@link MerchantRedpacketUseRecord} 红包使用记录类
	 * @return 返回数字表示添加成功与否   0:失败;1:成功
	 * @throws MerchantException {@link MerchantException} 商户异常类型封装
	 */
	@Override
	public Integer addUseRecord(MerchantRedpacketUseRecordRequest record) throws MerchantException {
		logger.info("开始记录红包使用消息:"+record);
		BzfAssert.isTrue(MerchantException.class,null==record, "增加商铺红包券使用记录错误对象【MerchantRedpacketUseRecord】为空");
		BzfAssert.isTrue(MerchantException.class, record.getUserid()==null||record.getUserid().intValue()==0,"增加商铺红包券使用记录错误对象【MerchantRedpacketUseRecord】属性【userid】为空");
		BzfAssert.isTrue(MerchantException.class, record.getShopid()==null||record.getShopid().intValue()==0, "增加商铺红包券使用记录错误对象【MerchantRedpacketUseRecord】属性【shopid】关联商铺有误");
		BzfAssert.isTrue(MerchantException.class, record.getRpid()==null||record.getRpid().intValue()==0, "增加商铺红包券使用记录错误对象【MerchantRedpacketUseRecord】属性【rpid】关联红包有误");
		BzfAssert.isTrue(MerchantException.class, record.getOrderno()==null||record.getOrderno().equals(""), "增加商铺红包券使用记录错误对象【MerchantRedpacketUseRecord】属性【orderno】关联订单有误");
		BzfAssert.isTrue(MerchantException.class, record.getUsemoney()==null||record.getUsemoney().longValue()==0, "增加商铺红包券使用记录错误对象【MerchantRedpacketUseRecord】属性【usemoney】为空");
		BzfAssert.isTrue(MerchantException.class, record.getUsetime()==null,"增加商铺红包券使用记录错误对象【MerchantRedpacketUseRecord】属性【usetime】为空");
		logger.info("红包使用记录入库");
		MerchantRedpacketUseRecord merchantRedpacketUseRecord=new MerchantRedpacketUseRecord();
		try {
			BeanUtils.copyProperties(merchantRedpacketUseRecord, record);
		} catch (IllegalAccessException e) {
			logger.error("bean转换错误,【record:"+record+"】转换为【merchantRedpacketUseRecord:"+merchantRedpacketUseRecord+"】");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			logger.error("bean转换错误,【record:"+record+"】转换为【merchantRedpacketUseRecord:"+merchantRedpacketUseRecord+"】");
			e.printStackTrace();
		}
		int num = merchantRedpacketUseRecordMapper.save(merchantRedpacketUseRecord);
		return num==0?0:1;
	}

	

}
