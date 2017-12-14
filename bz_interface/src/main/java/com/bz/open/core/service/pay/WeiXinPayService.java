package com.bz.open.core.service.pay;

import com.bz.framework.error.exception.PayException;
import com.bz.open.core.vo.request.weixin.WeixinPayRequet;
import com.bz.open.core.vo.response.weixin.WeiXinPayResponse;

/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年11月3日下午1:57:24
 * 描述:微信支付请求开放服务
 * 备注:
 */
public interface WeiXinPayService {
	
    /**
     * 
     * 
     * 作者:唐鹏
     * 创建时间:2017年11月3日下午2:38:51
     * 描述:微信统一下单支付预请求
     * 备注:
     * @param weixinPayRequet {@link WeixinPayRequet}微信支付请求参数封装
     * @throws PayException {@link PayException}支付异常封装
     */
	public WeiXinPayResponse wxPayUnifiedOrder(WeixinPayRequet weixinPayRequet)throws PayException;
	

}
