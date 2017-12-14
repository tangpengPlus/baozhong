package com.bz.framework.util.base;
/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年11月3日上午9:37:35
 * 描述:Integer工具
 * 备注:
 */
public class IntegerUtil {

	/**
	 * 
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年11月3日上午9:39:10
	 * 描述:判断integer是否为空
	 * 备注:
	 * @param arg
	 * @return
	 */
	public static boolean isEmpty(Integer arg) {
		if(null==arg) {
			return true;
		}
		if(arg.intValue()==0) {
			return true;
		}
		return false;
	}
}
