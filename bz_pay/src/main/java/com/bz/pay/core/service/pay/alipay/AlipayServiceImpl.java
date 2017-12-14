package com.bz.pay.core.service.pay.alipay;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.bz.framework.error.exception.PayException;
import com.bz.framework.util.exception.BzfAssert;
import com.bz.framework.util.order.OrderBaseUtil;
import com.bz.open.core.service.pay.AlipayService;
import com.bz.open.core.vo.request.alipay.AliPayRequest;
import com.bz.pay.core.service.pay.recod.PayRecordLogService;
import com.bz.framework.constant.exception.BzExceptionEnum.PayExceptionEnum;
/**
 * 
 * 作者:唐鹏
 * 创建时间:2017年11月6日上午11:26:18
 * 描述:支付宝支付服务实现
 * 备注:
 */
@Service(version="1.0.0",interfaceClass=com.bz.open.core.service.pay.AlipayService.class)
public class AlipayServiceImpl implements AlipayService{
	
	private final Logger logger=LoggerFactory.getLogger(AlipayServiceImpl.class);
	  @Autowired
	  private AlipayClient alipayClient;
	  @Value("${sdk.alipay.notify_url}")
	  private String notifyUrl;
	  @Autowired
	  private PayRecordLogService payRecordLogService;
	@Override
	public String AlipayMobilePhoneOrder(AliPayRequest aliPayRequest) throws PayException {
		logger.info("支付宝支付服务实现开始;请求参数AliPayRequest:【{}】",aliPayRequest);
		logger.info("验证请求参数合法性开始");
		//验证请求参数
		validRequestParm(aliPayRequest);
		//组装请求参数
		logger.info("组装请求参数开始");
		JSONObject data = new JSONObject();
		//订单编号封装
		data.put("out_trade_no", aliPayRequest.getOrderNumber());
		//产品码封装
		data.put("product_code", aliPayRequest.getAliPayPaymentScenarioEnum().getTitle());
		//订单金额封装
		data.put("total_amount", aliPayRequest.getPayMoney().toBigInteger());
		//订单标题封装
		data.put("subject", aliPayRequest.getOrderTitle()); //订单标题
		//服务商编号
		//data.put("sys_service_provider_id", "");
		//APP支付
		String form="";
		try {
			logger.info("支付宝支付服务实现==>封装支付宝支付请求表单开始");
			if(aliPayRequest.getAliPayPaymentScenarioEnum().getTitle().equals("QUICK_MSECURITY_PAY")) {
				logger.info("支付宝支付服务实现==>使用app场景支付");
		        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
		        request.setBizContent(data.toJSONString()); //业务参数
		        request.setNotifyUrl(notifyUrl); //异步通知地址
		        form=alipayClient.sdkExecute(request).getBody();
			}else if(aliPayRequest.getAliPayPaymentScenarioEnum().getTitle().equals("FAST_INSTANT_TRADE_PAY")) {
				logger.info("支付宝支付服务实现==>使用PC端场景支付");
				AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
				request.setNotifyUrl(notifyUrl); //异步通知地址
				request.setBizContent(data.toJSONString()); //业务参数
				form=alipayClient.sdkExecute(request).getBody();
			}else if(aliPayRequest.getAliPayPaymentScenarioEnum().getTitle().equals("QUICK_WAP_PAY")) {
				logger.info("支付宝支付服务实现==>使用H5移动端支付");
				AlipayTradeWapPayRequest request = new AlipayTradeWapPayRequest();
				request.setBizContent(data.toJSONString()); //业务参数
				request.setNotifyUrl(notifyUrl); //异步通知地址
				form=alipayClient.sdkExecute(request).getBody();
			}else {
				logger.error("支付宝支付服务实现==>封装支付宝支付请求表单:未选择合适的支付产品场景");
				throw new PayException(PayExceptionEnum.PAY_CREATE_FALIE, "支付宝支付服务实现==>封装支付宝支付请求表单:未选择合适的支付产品场景");
			}
			//异步实现日志入库
			payRecordLogService.addPayRecord(aliPayRequest.getOrderNumber(), 2, aliPayRequest.getPayMoney());
			return form;
		} catch (Exception e) {
			logger.error("支付宝支付服务实现封装支付宝支付请求表单错误");
			throw new PayException(PayExceptionEnum.PAY_CREATE_FALIE, "支付宝支付服务实现封装支付宝支付请求表单错误");
		}
	}
	
	/**
	 * 
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年11月6日上午11:45:11
	 * 描述:验证请求参数合法性
	 * 备注:
	 * @param aliPayRequest {@link AliPayRequest} 请求参数封装
	 */
	protected void validRequestParm(AliPayRequest aliPayRequest) throws PayException{
		logger.info("请求支付宝支付请求验证参数合法性参数列表:{}",aliPayRequest);
		BzfAssert.isNull(PayException.class, aliPayRequest,"请求支付宝支付请求验证参数合法性参数对象【aliPayRequest】为空");
		//验证订单编号
		if(StringUtils.isEmpty(aliPayRequest.getOrderNumber())) {
			logger.error("请求支付宝支付请求验证参数合法性参数列表参数对象【AliPayRequest】属性【orderNumber】为空");
			throw new PayException(PayExceptionEnum.PAY_ALIPYA_RQ_NULL, "请求支付宝支付请求验证参数合法性参数列表参数对象【AliPayRequest】属性【orderNumber】为空");
		}
		//验证订单的合法性
		if(OrderBaseUtil.isOrder(aliPayRequest.getOrderNumber())) {
			logger.error("请求支付宝支付请求验证参数合法性参数列表参数对象【AliPayRequest】属性【orderNumber】不合法");
			throw new PayException(PayExceptionEnum.PAY_ALIPYA_RQ_ERROR, "请求支付宝支付请求验证参数合法性参数列表参数对象【AliPayRequest】属性【orderNumber】不合法");
		}
		//验证订单标题
		if(StringUtils.isEmpty(aliPayRequest.getOrderTitle())) {
			logger.error("请求支付宝支付请求验证参数合法性参数列表参数对象【AliPayRequest】属性【orderTitle】为空");
			throw new PayException(PayExceptionEnum.PAY_ALIPYA_RQ_NULL, "请求支付宝支付请求验证参数合法性参数列表参数对象【AliPayRequest】属性【orderTitle】为空");
		}
		//验证支付使用场景
		if(null==aliPayRequest.getAliPayPaymentScenarioEnum()) {
			logger.error("请求支付宝支付请求验证参数合法性参数列表参数对象【AliPayRequest】属性【aliPayPaymentScenarioEnum】为空");
			throw new PayException(PayExceptionEnum.PAY_ALIPYA_RQ_NULL, "请求支付宝支付请求验证参数合法性参数列表参数对象【AliPayRequest】属性【aliPayPaymentScenarioEnum】为空");
		}
		//验证金额参数
		if(aliPayRequest.getPayMoney()==null||aliPayRequest.getPayMoney().compareTo(new BigDecimal("0.00"))==0) {
			logger.error("请求支付宝支付请求验证参数合法性参数列表参数对象【AliPayRequest】属性【payMoney】不合法");
			throw new PayException(PayExceptionEnum.PAY_ALIPYA_RQ_NULL, "请求支付宝支付请求验证参数合法性参数列表参数对象【AliPayRequest】属性【payMoney】不合法");
		}
	}

}
