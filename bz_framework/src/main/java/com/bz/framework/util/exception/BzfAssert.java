package com.bz.framework.util.exception;

import java.util.Collection;
import java.util.Map;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.bz.framework.constant.exception.BzExceptionEnum.FileExceptionEnum;
import com.bz.framework.constant.exception.BzExceptionEnum.MerchantExceptionEnum;
import com.bz.framework.constant.exception.BzExceptionEnum.OrderExceptionEnum;
import com.bz.framework.constant.exception.BzExceptionEnum.PayExceptionEnum;
import com.bz.framework.constant.exception.BzExceptionEnum.UserExceptionEnum;
import com.bz.framework.error.exception.BzBaseException;
import com.bz.framework.error.exception.ExternalException;
import com.bz.framework.error.exception.FileException;
import com.bz.framework.error.exception.MerchantException;
import com.bz.framework.error.exception.OrderException;
import com.bz.framework.error.exception.PayException;
import com.bz.framework.error.exception.UserException;
/**
 * 
 * 作者:唐鹏
 * 描述:错误比较工具
 * 创建时间:2017年9月29日上午11:09:10
 */
public  class BzfAssert {
	private BzfAssert(){}
	/**
	 * 维护表达式是否为真<br/>
	 * 如果false抛出错误
	 * @param expression	false 报错
	 * @param message		信息提示
	 * @param classes		错误平台类
	 * @throws classes if expression is {@code false}
	 */
	public static void isTrue(Class<? extends BzBaseException> classes,boolean expression, String message) {
		if (expression) {
			compareExp(classes,message);
		}
	}
	public static void isTrue(Class<? extends BzBaseException> classes,boolean expression) {
		if (!expression) {
			compareExp(classes,"[HpfAssert.class]表达式比较为false");
		}
	}
	/**
	 * 维护表达式是否为空<br/>
	 * 如果null抛出错误
	 * @param expression	null 报错
	 * @param message		信息提示
	 * @param classes		错误平台类
	 * @throws classes if expression is {@code null}
	 */
	public static void isNull(Class<? extends BzBaseException> classes,Object object, String message) {
		if (object == null) {
			compareExp(classes,message);
		}
	}
	public static void isNull(Class<? extends BzBaseException> classes,Object object) {
		isNull(classes,object,"[HpfAssert.class]表达式为空");
	}
	
	/**
	 * 维护表达式是对象长度不能为0<br/>
	 * 表达式Null or empty 抛出错误
	 * @param text			检测值
	 * @param message		信息提示
	 * @param classes		错误平台类
	 * @throws classes if expression is {@code length==0}
	 */
	public static void hasLength(Class<? extends BzBaseException> classes,String text, String message) {
		if (!StringUtils.hasLength(text)) {
			compareExp(classes,message);
		}
	}
	public static void hasLength(Class<? extends BzBaseException> classes,String text) {
		hasLength(classes,text,"[HpfAssert.class]参数为空或者为null");
	}

	/**
	 * 判断数组不能为空
	 * @param array		数组
	 * @param message	信息提示
	 * @param classes	错误平台类
	 * @throws classes if expression is {@code null or length==0}
	 */
	public static void notEmpty(Class<? extends BzBaseException> classes,Object[] array, String message) {
		if (ObjectUtils.isEmpty(array)) {
			compareExp(classes,message);
		}
	}

	public static void notEmpty(Class<? extends BzBaseException> classes,Object[] array) {
		notEmpty(classes,array,"[HpfAssert.class]数组对象不能为空或者长度为零");
	}

	/**
	 * 判断数组中是否有null
	 * @param array		
	 * @param message
	 * @param classes
	 * @throws classes if the object array contains a {@code null} element
	 */
	public static void noNullElements(Class<? extends BzBaseException> classes,Object[] array, String message) {
		if (array != null) {
			for (Object element : array) {
				if (element == null) {
					compareExp(classes,message);
				}
			}
		}
	}

	public static void noNullElements(Class<? extends BzBaseException> classes,Object[] array) {
		noNullElements(classes,array, "[HpfAssert.class]数组中有为null");
	}


	/**
	 * 判断集合是否为空
	 * @param collection
	 * @param message
	 * @param classes
	 * @throws classes if the collection is {@code null} or has no elements
	 */
	@SuppressWarnings("rawtypes") 
	public static void notEmpty(Class<? extends BzBaseException> classes,Collection collection, String message) {
		if (CollectionUtils.isEmpty(collection)) {
			compareExp(classes,message);
		}
	}
	@SuppressWarnings("rawtypes") 
	public static void notEmpty(Class<? extends BzBaseException> classes,Collection collection) {
		notEmpty(classes,collection,"[HpfAssert.class]集合为空");
	}

	/**
	 * 集合Map不能为空或者Null
	 * @param map
	 * @param message
	 * @param classes
	 * @throws map if the collection is {@code null Or length==0} or has no elements
	 */
	@SuppressWarnings("rawtypes")
	public static void notEmpty(Map map, String message,Class<? extends BzBaseException> classes) {
		if (CollectionUtils.isEmpty(map)) {
			compareExp(classes,message);
		}
	}

	
	@SuppressWarnings("rawtypes")
	public static void notEmpty(Map map,Class<? extends BzBaseException> classes) {
		notEmpty(map, "[HpfAssert.class]集合不能为空或者Null",classes);
	}
	
	/**
	 * 用户模块异常类
	 * @param userExceptionEnum {@link UserExceptionEnum}
	 * @param message 异常信息提示
	 */
	public static void throwUserException(UserExceptionEnum userExceptionEnum,String message){
		throw new UserException(userExceptionEnum,message);
	}
	
	/**
	 * 商户模块异常类
	 * @param merchantExceptionEnum {@link MerchantExceptionEnum}
	 * @param message 异常信息提示
	 */
	public static void throwMerchantException(MerchantExceptionEnum merchantExceptionEnum,String message){
		throw new MerchantException(merchantExceptionEnum,message);
	}
	
	/**
	 * 订单模块异常类
	 * @param orderExceptionEnum {@link OrderExceptionEnum}
	 * @param message 异常信息提示
	 */
	public static void throwOrderException(OrderExceptionEnum orderExceptionEnum,String message){
		throw new OrderException(orderExceptionEnum,message);
	}
	
	/**
	 * 支付系统异常类
	 * @param payExceptionEnum {@link PayExceptionEnum}
	 * @param message 异常信息提示
	 */
	public static void throwPayException(PayExceptionEnum payExceptionEnum,String message){
		throw new PayException(payExceptionEnum, message);
	}
	
	/**
	 *文件服务板块异常类
	 * @param fileExceptionEnum {@link FileExceptionEnum}
	 * @param message
	 */
	public static void throwThirdpartyException(FileExceptionEnum fileExceptionEnum,String message){
		throw new FileException(fileExceptionEnum,message);
	}
	
	/**
	 * 只抛出错误信息
	 * @param message
	 * @param classes
	 */
	private static void compareExp(Class<? extends BzBaseException> classes,String message){
		//用户
		if(classes.equals(UserException.class)){
			throw new UserException(message);
		}
		//商户
		if(classes.equals(MerchantException.class)){
			throw new MerchantException(message);
		}
		//订单
		if(classes.equals(OrderException.class)){
			throw new OrderException(message);
		}
		//支付
		if(classes.equals(PayException.class)){
			throw new PayException(message);
		}
		//第三方
		if(classes.equals(ExternalException.class)){
			throw new ExternalException(message);
		}
		//文件
		if(classes.equals(FileException.class)){
			throw new FileException(message);
		}
		//其他
	}
}
