package com.bz.openweb.core.service.pay;
import java.math.BigDecimal;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.alibaba.dubbo.config.annotation.Reference;
import com.bz.framework.constant.order.OrderEnum.PayWay;
import com.bz.framework.constant.result.ResultValueEnum;
import com.bz.framework.pojo.base.BaseResult;
import com.bz.framework.util.base.IntegerUtil;
import com.bz.open.core.service.order.ScanOrderCreateService;
import com.bz.openweb.core.model.pay.PayRequest;
import com.bz.openweb.core.model.pay.PayResponse;

/**
 * 
 *  作者:唐鹏
 *  描述:支付请求服务处理
 *  备注:
 *  创建时间:2017年11月28日上午10:55:04
 */
@Service
public class PayService {

	private final Logger logger=LoggerFactory.getLogger(PayService.class);
	
	@Reference(version="1.0.0")
	private ScanOrderCreateService scanOrderCreateService;
	/**
	 * 
	 *  作者:唐鹏
	 *  描述:处理支付请求
	 *  备注:
	 *  创建时间:2017年11月28日上午10:59:18
	 *  @param payRequest:支付请求封装
	 *  @return PayResponse:支付返回封装
	 */
	public BaseResult<PayResponse> handlerPay(PayRequest payRequest){
		logger.info("处理支付请求:PayRequest:{}",payRequest);
		
		BaseResult<PayResponse> response=BaseResult.newInstance();
		//验证
		if(null==payRequest) {
			response.changeStatus(ResultValueEnum.ORDER_DOWDN_NO_DEFIND);
			return response;
		}
		if(StringUtils.isEmpty(payRequest.getPayWay())) {
			response.changeStatus(ResultValueEnum.PAY_WAY_ERROR);
			return response;
		}
		if(PayWay.getByValue(payRequest.getPayWay())==null) {
			response.changeStatus(ResultValueEnum.PAY_WAY_ERROR);
			return response;
		}
		//获取支付金额
		BigDecimal payMoeny=null;
		try {
			payMoeny=new BigDecimal(payRequest.getPayMoney());
		} catch (Exception e) {
			response.changeStatus(ResultValueEnum.PAY_MONEY_ERROR);
			return response;
		}
		if(payMoeny.compareTo(BigDecimal.ZERO)==0) {
			response.changeStatus(ResultValueEnum.PAY_MONEY_ERROR);
			return response;
		}
		//判断是否使用优惠券
		if(IntegerUtil.isEmpty(payRequest.getRedPackageId())){
			
		}
		//scanOrderCreateService.createOrder();
		return response;
	}
	
}
