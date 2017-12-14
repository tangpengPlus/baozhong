package com.bz.framework.util.base;

import java.util.List;

/**
 * 
 * 作者:唐鹏
 * 创建时间:2017年10月16日下午12:03:47
 * 描述:集合对象工具
 * 备注:
 */
public class ListUtil {
	
	/**
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年10月16日下午12:58:23
	 * 描述:判断集合对象是否为空
	 * 备注:
	 * @param t
	 * @return
	 */
	public static <T> boolean isEmpty(List<T> t) {
		if(null==t) {
			return false;
		}
		return t.isEmpty();
	}

}
