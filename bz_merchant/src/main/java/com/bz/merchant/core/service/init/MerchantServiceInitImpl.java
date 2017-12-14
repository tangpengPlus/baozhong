package com.bz.merchant.core.service.init;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.transaction.Transactional;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.alibaba.dubbo.config.annotation.Service;
import com.bz.dao.mapper.merchant.MerchantServerStatusMapper;
import com.bz.dao.pojo.merchant.MerchantServerStatus;
import com.bz.framework.error.exception.ExternalException;
import com.bz.framework.error.exception.MerchantException;
import com.bz.framework.util.base.IntegerUtil;
import com.bz.framework.util.exception.BzfAssert;
import com.bz.framework.util.number.BzCodeGenerate;
import com.bz.open.core.service.merchant.MerchantServiceInitService;
import com.bz.open.core.vo.request.merchant.MerchantServerInitVo;

/**
 * 
 * 
 * 作者: 彭云山
 * 描述:商家服务初始化接口
 * 创建时间:2017年11月13日下午2:54:41
 * 修改备注:
 */
@Service(version="1.0.0",interfaceClass=com.bz.open.core.service.merchant.MerchantServiceInitService.class)
@Transactional
public class MerchantServiceInitImpl implements MerchantServiceInitService{

	private final Logger logger=LoggerFactory.getLogger(MerchantServiceInitImpl.class);
	
	//聚合支付状态：0表示未开启，1表示开启
	@Value("${merchant.aggregatepaystatus}")
	private Integer aggregatepaystatus;
	
	//信用卡付款方式：0表示未开启；1表示开启
	@Value("${merchant.creditcardstatus}")
	 private Integer creditcardstatus;
	
	//客户积累状态：0表示开启；1表示未开启
	@Value("${merchant.customersaccumulatestatus}")
	private Integer customersaccumulatestatus;
	
	//多机收信息状态：0表示未开启，1表示开启
	@Value("${merchant.phonesmessagestatus}")
	 private Integer phonesmessagestatus;
	
	//网店开启状态：0表示开启；1表示未开启
	@Value("${merchant.onlinestorestatus}")
	 private Integer onlinestorestatus;
	
	//付前广告开启状态：0表示未开启，1表示已开启
	@Value("${merchant.paybeforeadvertisingstatus}")
	private Integer paybeforeadvertisingstatus;
	
	//小票广告开启状态：0表示未开启，1表示已开启
	@Value("${merchant.receiptsstatus}")
	private Integer receiptsstatus;
	
	//开地图点状态：0表示未开启，1表示已开启
	@Value("${merchant.storemapstatus}")
	private Integer storemapstatus;
	
	//销售统计状态：0表示未开启，1表示已开启
	@Value("${merchant.salesstatisticsstatus}")
	private Integer salesstatisticsstatus;
	
	//支付详情状态：0表示未开启，1表示已开启
	@Value("${merchant.paymentdetailsstatus}")
	private Integer paymentdetailsstatus;
	
	//服务联系状态:0表示未开启，1表示已开启
	@Value("${merchant.servicelinksstatus}")
	private Integer servicelinksstatus;
	
	//红包发券状态：0表示开启，1表示未开启
	@Value("${merchant.grantredpacketstatus}")
	private Integer grantredpacketstatus;
	
	//信息群发状态：0表示未开启，1表示已开启
	@Value("${merchant.groupsstatus}")
	 private Integer groupsstatus;
	
	//付后广告状态：0表示未开启，1表示已开启
	@Value("${merchant.payafteradvertisingstatus}")
	private Integer payafteradvertisingstatus;
	
	//是否有效：0表示无效，1表示有效
	@Value("${merchant.isdelete}")
	private Integer isdelete;
	
	@Autowired
	private MerchantServerStatusMapper merchantServerStatusMapper;
	
	
	/**
	 * 修改商家初始化状态服务
	 */
	@Override
	public boolean updateMerchantInitServer(MerchantServerInitVo merchantOpenStatus) throws MerchantException {
		logger.info("修改商家初始化服务状态merchantOpenStatus:{}",merchantOpenStatus);
		BzfAssert.isNull(ExternalException.class,merchantOpenStatus,"初始化对象【merchantOpenStatus】为空");
		BzfAssert.isTrue(ExternalException.class,IntegerUtil.isEmpty(merchantOpenStatus.getMerchantId()),"修改商家初始化对象的【MerchantId】为空");
		MerchantServerStatus daomerchantOpenStatus = new MerchantServerStatus();
		try {
			BeanUtils.copyProperties(daomerchantOpenStatus,merchantOpenStatus);
			merchantServerStatusMapper.update(daomerchantOpenStatus);
		} catch (IllegalAccessException e) {
			logger.error("商家dao层数据输送错误");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			logger.error("商家dao层数据输送错误");
			e.printStackTrace();
		}
		
		return true;
	}

	/**
	 * 商铺服务初始化
	 */
	@Override
	public boolean initMerchantServer(Integer merchantId) throws MerchantException {
		logger.info("初始化商家Id为:{}的服务状态",merchantId);
		BzfAssert.isNull(ExternalException.class,IntegerUtil.isEmpty(merchantId), "修改商家【merchantId】的id为空");
		
		
		MerchantServerStatus daomerchantOpenStatus = new MerchantServerStatus();
		
		daomerchantOpenStatus.setMerchantId(merchantId);
		
		daomerchantOpenStatus.setCreatetime(new Date());
		
		daomerchantOpenStatus.setNumber(BzCodeGenerate.getSysNumber());
		
		daomerchantOpenStatus.setAggregatepaystatus(aggregatepaystatus);
		
		daomerchantOpenStatus.setCreditcardstatus(creditcardstatus);
		
		daomerchantOpenStatus.setCustomersaccumulatestatus(customersaccumulatestatus);
		
		daomerchantOpenStatus.setPhonesmessagestatus(phonesmessagestatus);
		
		daomerchantOpenStatus.setOnlinestorestatus(onlinestorestatus);
		
		daomerchantOpenStatus.setPayafteradvertisingstatus(paybeforeadvertisingstatus);
		
		daomerchantOpenStatus.setReceiptsstatus(receiptsstatus);
		
		daomerchantOpenStatus.setStoremapstatus(storemapstatus);
		
		daomerchantOpenStatus.setSalesstatisticsstatus(salesstatisticsstatus);
		
		daomerchantOpenStatus.setPaymentdetailsstatus(paymentdetailsstatus);
		
		daomerchantOpenStatus.setServicelinksstatus(servicelinksstatus);
		
		daomerchantOpenStatus.setGrantredpacketstatus(grantredpacketstatus);
		
		daomerchantOpenStatus.setGroupsstatus(groupsstatus);
		
		daomerchantOpenStatus.setPayafteradvertisingstatus(payafteradvertisingstatus);
		
		daomerchantOpenStatus.setIsdelete(isdelete);
		daomerchantOpenStatus.setCreatetime(new Date());
			Integer addmerchantStauts = merchantServerStatusMapper.save(daomerchantOpenStatus);
			
		return addmerchantStauts==null?false:true;
	}

}
