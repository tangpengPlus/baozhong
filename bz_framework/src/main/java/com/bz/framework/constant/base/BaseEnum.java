package com.bz.framework.constant.base;
/**
 * 枚举
 * 主要用于值和名的对应和查询
 * 接口
 * @author 唐鹏
 *
 */
public interface BaseEnum<T> {
	/**
	 * 获取值
	 * @return T
	 */
	public T getKey();
	/**
	 * 获取名称
	 * @return String
	 */
	public String getTitle();
}
