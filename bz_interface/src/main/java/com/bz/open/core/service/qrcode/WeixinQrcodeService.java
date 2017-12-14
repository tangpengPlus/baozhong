package com.bz.open.core.service.qrcode;

import java.io.ByteArrayInputStream;

import com.bz.framework.error.exception.ExternalException;

/**
 * 
 * 作者: 兰俊
 * 描述: 微信生成解析二维码开放接口
 * 版本: version 1.0.0
 * 创建时间:2017年11月1日下午6:40:12
 */
public interface WeixinQrcodeService {

	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 生成商铺收款二维码
	 * 创建时间:2017年11月2日下午4:04:54
	 * @param json 生成二维码的内容
	 * @return ByteArrayInputStream 输入流
	 * @throws ExternalException
	 */
	public ByteArrayInputStream createQrcade(String json) throws ExternalException;



}