package com.bz.framework.util.base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * 作者:唐鹏
 * 创建时间:2017年10月17日上午9:37:53
 * 描述:基础工具验证
 * 备注:
 */
public class BaseUtil {

	/**
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年10月17日上午9:39:14
	 * 描述:验证是否为电话号码
	 * 备注:
	 * @param telPhone:电话号码
	 * @return
	 * @throws Exception
	 */
	public static boolean isTelPhone(String telPhone){
		if(StringUtils.isEmpty(telPhone)) {
			return false;
		}
		// 手机号验证
			Pattern p = Pattern  
					.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9])|(147)|(17[0-9]))\\d{8}$");
			Matcher m = p.matcher(telPhone);
			return m.matches();
		}
	
	/**
	 * 将long类型数据转为int类型
	 * 作者:GENCY
	 * 创建时间:2015年11月20日 下午3:28:41
	 * 返回: Integer
	 * 所属类:LazyServiceEncrptUtil
	 * @param parm
	 * @return
	 * TODO
	 */
	public static Integer changeLongToInt(Long parm){
		String s=parm.toString();
		return Integer.valueOf(s);
	}
	
	/**
	 * 
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年10月31日上午10:10:53
	 * 描述:
	 * 备注:
	 * @param number
	 * @return
	 */
	public static String createNumber(String number) {
		int length=number.length();
		if(length<4) {
			String prx="";
			for(int i=0;i<(length-4);i++) {
				prx=prx+"0";
			}
			return prx+number;
		}else if(length==4) {
			return number;
		}else if(length>4) {
			return number.substring(0, 3);
		}
		return "";
	}
}
