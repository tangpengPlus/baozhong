package com.bz.pay.core.service.pay.weixin;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.util.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.alibaba.dubbo.config.annotation.Service;
import com.bz.framework.error.exception.OrderException;
import com.bz.framework.error.exception.PayException;
import com.bz.framework.util.exception.BzfAssert;
import com.bz.open.core.service.pay.WeiXinPayService;
import com.bz.open.core.vo.request.weixin.WeixinPayRequet;
import com.bz.open.core.vo.response.weixin.WeiXinPayResponse;
import com.bz.pay.core.config.weixin.WxPayProperties;
import com.bz.pay.core.service.pay.recod.PayRecordLogService;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.bean.result.WxPayUnifiedOrderResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.bz.framework.constant.exception.BzExceptionEnum.PayExceptionEnum;
/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年11月3日下午5:15:50
 * 描述:微信统一下单服务实现
 * 备注:
 */
@Service(version="1.0.0",interfaceClass=com.bz.open.core.service.pay.WeiXinPayService.class)
public class WeiXinPayServiceImpl implements WeiXinPayService{
    public static final String FAIL     = "FAIL";
    public static final String SUCCESS  = "SUCCESS";
    public static final String HMACSHA256 = "HMAC-SHA256";
    public static final String MD5 = "MD5";
    public static final String FIELD_SIGN = "sign";
    public static final String FIELD_SIGN_TYPE = "sign_type";
	private final Logger logger=LoggerFactory.getLogger(WeiXinPayServiceImpl.class);
	@Autowired
	private WxPayService wxPayService;
	@Autowired
	private WxPayProperties wxPayProperties; 
	@Value("${wechat.pay.notify_url}")
	private String notifyUrl;
    @Autowired
    private PayRecordLogService payRecordLogService;
	@Override
	public WeiXinPayResponse wxPayUnifiedOrder(WeixinPayRequet weixinPayRequet) throws PayException {
		logger.info("微信调用统一支付api接口调用请求参数:{}",weixinPayRequet);
		/*参数检查*/
		checkWeiXinPayRequestParm(weixinPayRequet);
		/*初始化交易返回结果封装*/
		WeiXinPayResponse response =new WeiXinPayResponse();
		/*初始化交易请求参数封装*/
		WxPayUnifiedOrderRequest orderRequest=new WxPayUnifiedOrderRequest();
		/*设置请求设备号*/
		orderRequest.setDeviceInfo(weixinPayRequet.getDeviceInfo());
		/*随机字符串*/
		String generateNonceStr=getGenerateNonceStr();
		logger.info("微信调用统一支付api接口调用:生成的随机字符串:【"+generateNonceStr+"】");
		orderRequest.setNonceStr(generateNonceStr);
		weixinPayRequet.setNonceStr(generateNonceStr);
		/*notifyURL赋值*/
		orderRequest.setNotifyURL(notifyUrl);
		/*设置JSAPI支付方式，后必须设置openid*/
		orderRequest.setTradeType("JSAPI");
		/*设置openid*/
		orderRequest.setOpenid("oRkX0t0sbR1tTU_KWFwqJlhPk-9k");
		/*受理机构*/
		orderRequest.setSubMchId("1460096485");
		/*生成签名*/
		String sign=signParm(weixinPayRequet);
		orderRequest.setSign(sign);
		logger.info("微信调用统一支付api接口调用:生成的签名值为:【"+sign+"】");
		/*订单描述*/
		orderRequest.setBody(weixinPayRequet.getOrderDescribe());
		/*订单详情*/
		if(!StringUtils.isEmpty(weixinPayRequet.getOrderDetail())) {
			orderRequest.setDetail(weixinPayRequet.getOrderDetail());
		}
		/*附加数据*/
		if(!StringUtils.isEmpty(weixinPayRequet.getAttach())){
			orderRequest.setAttach(weixinPayRequet.getAttach());
		}
		/*设置订单编号*/
		orderRequest.setOutTradeNo(weixinPayRequet.getOrderNumber());
		/*设置订单金额 注意【微信金额单位默认为“分”】*/
		Integer totalMoney=weixinPayRequet.getPayMoney().multiply(new BigDecimal("100.00")).intValue();
		logger.info("微信调用统一支付api接口调用:总金额为:【"+totalMoney+"】分");
		orderRequest.setTotalFee(totalMoney);
		/*设置请求IP*/
		orderRequest.setSpbillCreateIp(weixinPayRequet.getRequstIp());
		try {
			//异步存储支付日志记录
			payRecordLogService.addPayRecord(weixinPayRequet.getOrderNumber(),1, weixinPayRequet.getPayMoney());
			WxPayUnifiedOrderResult  result=wxPayService.unifiedOrder(orderRequest);
			logger.info("微信调用统一支付api接口调用返回:return_code:"+result.getReturnCode());
			response.setReturnCode(result.getReturnCode());
			logger.info("微信调用统一支付api接口调用返回:result_code:"+result.getResultCode());
			response.setResultCode(result.getResultCode());
			logger.info("微信调用统一支付api接口调用返回:return_msg:"+result.getReturnMsg());
			response.setReturnMsg(result.getReturnMsg());
			logger.info("微信调用统一支付api接口调用返回:appid:"+result.getAppid());
			response.setAppid(result.getAppid());
			logger.info("微信调用统一支付api接口调用返回:mch_id:"+result.getMchId());
			response.setMchId(result.getMchId());
			logger.info("微信调用统一支付api接口调用返回:nonce_str:"+result.getNonceStr());
			response.setNonceStr(result.getNonceStr());
			logger.info("微信调用统一支付api接口调用返回:sign:"+result.getSign());
			response.setSign(result.getSign());
			logger.info("微信调用统一支付api接口调用返回:trade_type:"+result.getTradeType());
			response.setTradeType(result.getTradeType());
			logger.info("微信调用统一支付api接口调用返回:prepay_id:"+result.getPrepayId());
			response.setPrepayId(result.getPrepayId());
		} catch (WxPayException e) {
			logger.error("微信调用统一支付api接口报错:【调用微信接口错误】",e);
			throw new PayException(PayExceptionEnum.PAY_WX_RQ_ERROR, "微信调用统一支付api接口报错:【调用微信接口错误】");
		}
		return response;
	}
	/**
	 * 
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年11月3日下午3:06:07
	 * 描述:生成签名
	 * 
	 * 备注:
	 * @param weixinPayRequet
	 * @return
	 */
	public String signParm(WeixinPayRequet weixinPayRequet) {
		Map<String, String> data=new HashMap<>();
		data.put("appid", wxPayProperties.getAppId());
		data.put("mch_id", wxPayProperties.getMchId());
		data.put("device_info", weixinPayRequet.getDeviceInfo());
		data.put("nonce_str", weixinPayRequet.getNonceStr());
		data.put("sign_type", "MD5");
		data.put("body", weixinPayRequet.getOrderDescribe());
		data.put("detail", weixinPayRequet.getOrderDetail());
		data.put("attach", weixinPayRequet.getAttach());
		data.put("out_trade_no", weixinPayRequet.getOrderNumber());
		data.put("total_fee", weixinPayRequet.getPayMoney().toString());
		data.put("spbill_create_ip", weixinPayRequet.getRequstIp());
		data.put("notify_url", notifyUrl);
		data.put("trade_type", "JSAPI");
		try {
			return generateSignature(data, wxPayProperties.getMchKey());
		} catch (Exception e) {
			logger.error("微信调用统一支付api接口报错:【生成签名错误】",e);
		   throw new PayException(PayExceptionEnum.PAY_WX_SIGN_ERROR, "微信调用统一支付api接口报错:【生成签名错误】");
		}
	}
	
	
	/**
	 * 
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年11月3日下午2:48:52
	 * 描述:生成随机签名字符串
	 * 备注:
	 * @return
	 */
	protected String getGenerateNonceStr() {
		return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
	}
	
	 /**
     * 生成签名
     *
     * @param data 待签名数据
     * @param key API密钥
     * @return 签名
     */
    public static String generateSignature(final Map<String, String> data, String key) throws Exception {
        return generateSignature(data, key, SignType.MD5);
    }
    
    /**
     * 生成签名. 注意，若含有sign_type字段，必须和signType参数保持一致。
     *
     * @param data 待签名数据
     * @param key API密钥
     * @param signType 签名方式
     * @return 签名
     */
    public static String generateSignature(final Map<String, String> data, String key, SignType signType) throws Exception {
        Set<String> keySet = data.keySet();
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keyArray);
        StringBuilder sb = new StringBuilder();
        for (String k : keyArray) {
            if (k.equals(FIELD_SIGN)) {
                continue;
            }
            if (data.get(k).trim().length() > 0) // 参数值为空，则不参与签名
                sb.append(k).append("=").append(data.get(k).trim()).append("&");
        }
        sb.append("key=").append(key);
        if (SignType.MD5.equals(signType)) {
            return MD5(sb.toString()).toUpperCase();
        }
        else if (SignType.HMACSHA256.equals(signType)) {
            return HMACSHA256(sb.toString(), key);
        }
        else {
            throw new OrderException("签名错误:未选择签名类型");
        }
    }

    /**
     * 生成 MD5
     *
     * @param data 待处理数据
     * @return MD5结果
     */
    public static String MD5(String data) throws Exception {
        java.security.MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] array = md.digest(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();
    }

    /**
     * 生成 HMACSHA256
     * @param data 待处理数据
     * @param key 密钥
     * @return 加密结果
     * @throws Exception
     */
    public static String HMACSHA256(String data, String key) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        byte[] array = sha256_HMAC.doFinal(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();
    }

    /**
     * 
     * 
     * 作者:唐鹏
     * 创建时间:2017年11月3日下午3:00:47
     * 描述:加密方式枚举
     * 备注:
     */
    public enum SignType {
        MD5, HMACSHA256
    }
    
    /**
     * 
     * 
     * 作者:唐鹏
     * 创建时间:2017年11月3日下午5:04:11
     * 描述:检查微信统一支付api请求参数的合法性
     * 备注:
     * @param requet
     * @return
     */
    public  void checkWeiXinPayRequestParm(WeixinPayRequet requet) {
    	
    	BzfAssert.isNull(PayException.class, requet, "调用微信统一支付api接口调用请求参数封装对象【WeixinPayRequet】为空");
       /*订单描述的判断*/
    	if(StringUtils.isEmpty(requet.getOrderDescribe())) {
        	logger.error("调用微信统一支付api接口调用请求参数对象【WeixinPayRequet】属性【orderDescribe】不能为空");
            throw new PayException(PayExceptionEnum.PAY_WX_RQ_NULL, "调用微信统一支付api接口调用请求参数对象【WeixinPayRequet】属性【orderDescribe】不能为空");
        }
        /*订单编号的判断*/
    	if(StringUtils.isEmpty(requet.getOrderNumber())||requet.getOrderNumber().length()>32) {
    		logger.error("调用微信统一支付api接口调用请求参数对象【WeixinPayRequet】属性【orderNumber】不合法");
            throw new PayException(PayExceptionEnum.PAY_WX_RQ_NULL, "调用微信统一支付api接口调用请求参数对象【WeixinPayRequet】属性【orderNumber】不合法");
    	}
    	
    	/*支付金额的判断*/
    	if(requet.getPayMoney()==null||requet.getPayMoney().compareTo(new BigDecimal("0.00"))<=0) {
    		logger.error("调用微信统一支付api接口调用请求参数对象【WeixinPayRequet】属性【payMoney】不合法");
            throw new PayException(PayExceptionEnum.PAY_WX_RQ_NULL, "调用微信统一支付api接口调用请求参数对象【WeixinPayRequet】属性【payMoney】不合法");
    	}
    	if(StringUtils.isEmpty(requet.getRequstIp())||requet.getRequstIp().length()>12) {
    		logger.error("调用微信统一支付api接口调用请求参数对象【WeixinPayRequet】属性【requstIp】不合法");
            throw new PayException(PayExceptionEnum.PAY_WX_RQ_NULL, "调用微信统一支付api接口调用请求参数对象【WeixinPayRequet】属性【requstIp】不合法");
    	}
    	
    }
    
}
