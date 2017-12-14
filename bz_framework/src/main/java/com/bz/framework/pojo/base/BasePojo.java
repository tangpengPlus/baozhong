package com.bz.framework.pojo.base;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * 作者:唐鹏
 * 描述:域对象(pojo)基类
 * 创建时间:2017年9月29日下午12:16:37
 */
public class BasePojo implements Serializable {
	private static final long serialVersionUID = 1L;
	public BasePojo(){
		
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
