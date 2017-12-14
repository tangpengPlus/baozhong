package com.bz.open.core.service.merchant;

import java.math.BigDecimal;

import com.bz.dao.pojo.merchant.MerchantRedpacketSetting;
import com.bz.framework.error.exception.MerchantException;
import com.bz.open.core.vo.request.merchant.MerchantRedpacketGrantRecordRequest;
import com.bz.open.core.vo.request.merchant.MerchantRedpacketSettingRequest;
import com.bz.open.core.vo.request.merchant.MerchantRedpacketUseRecordRequest;
import com.bz.open.core.vo.response.merchant.MerchantRedpacketSettingResponseVo;

/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年11月2日上午10:46:02
 * 描述:商家红包券开放服务
 * 备注:
 */
public interface MerchantRedCouponService {

	
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
	 * @return ture:金额计算正常 false:计算错误
	 * @throws MerchantException ${@link MerchantException} 商家板块异常信息封装
	 */
	public boolean checkRedCouponAmount(BigDecimal totalMoney,BigDecimal deductible,Integer redCouponId,Integer userId)throws MerchantException;

	
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
	public MerchantRedpacketSettingResponseVo getMerchantRedpacketSettingByCondition(MerchantRedpacketSettingRequest merchantRedpacketSetting)throws MerchantException;

	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 添加红包发放记录
	 * 创建时间:2017年11月6日上午1:13:20
	 * @param record {@link MerchantRedpacketGrantRecordRequest} 红包发放记录类
	 * @throws MerchantException {@link MerchantException} 商户异常类型封装
	 */
	public void addGrantRecord(MerchantRedpacketGrantRecordRequest record) throws MerchantException;
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 添加红包使用记录
	 * 创建时间:2017年11月6日上午1:16:04
	 * @param record {@link MerchantRedpacketUseRecordRequest} 红包使用记录类
	 * @return 返回数字表示添加成功与否   0:失败;1:成功
	 * @throws MerchantException {@link MerchantException} 商户异常类型封装
	 */
	public Integer addUseRecord(MerchantRedpacketUseRecordRequest record) throws MerchantException;

	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 商铺添加或更新红包劵设置信息
	 * 创建时间:2017年11月7日下午1:48:16
	 * @param merchantRedpacketSetting
	 */
	public void addMerchantRedpacket(MerchantRedpacketSettingRequest merchantRedpacketSetting);
	
}
