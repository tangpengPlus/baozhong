package com.bz.pay.core.service.pay.recod;

import java.math.BigDecimal;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bz.dao.mapper.pay.PayRecordMapper;
import com.bz.dao.pojo.pay.PayRecord;
/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年11月6日下午2:20:18
 * 描述:支付请求回调数据入库操作服务
 * 备注:
 */
@Service
@Transactional
public class PayRecordLogService {

	private final Logger logger=LoggerFactory.getLogger(PayRecordLogService.class);
	
	@Autowired
	private PayRecordMapper payRecordMapper;
	
	/**
	 * 
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年11月6日下午2:22:17
	 * 描述:增加支付记录日志
	 * 备注:
	 * @param orderNumber 订单编号
	 * @param payWay 支付方式 支付类型；1：微信支付；2：支付宝支付；
	 */
	@Async
	public void addPayRecord(String orderNumber,Integer payWay,BigDecimal money) {
		logger.info("增加支付记录日志入库:【orderNumber:"+orderNumber+",payWay:"+payWay+"】");
		PayRecord payRecord =new PayRecord();
		payRecord.setOrderno(orderNumber);
		payRecord.setPaymoney(money);
		payRecord.setPaystate(0);
		payRecord.setPaytime(new Date());
		payRecord.setPaytype(payWay);
		payRecordMapper.save(payRecord);
	}
	/**
	 * 
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年11月6日下午5:29:13
	 * 描述:修改支付记录状态
	 * 备注:
	 * @param orderNumber:订单编号
	 * @param state 0:请求初始化 1：支付成功 2:支付失败
	 */
	public void updatePayRecordState(String orderNumber,Integer state) {
		logger.info("修改支付记录状态:【orderNumber:"+orderNumber+",state:"+state+"】");
		payRecordMapper.updatePayRecordInfo(orderNumber, state,new Date());
	}
}
