package com.bz.framework.constant.order;

import com.bz.framework.constant.base.BaseEnum;

/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年10月27日上午11:12:24
 * 描述:订单常量数据封装
 * 备注:
 */


public class OrderEnum{
	
	/**
	 * 
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年10月27日上午11:15:58
	 * 描述:订单来源数据封装
	 * 备注:
	 */
	public enum OrderSource implements BaseEnum<String>{
		SCAN_CODE_ORDER("BZS","扫码下单");
		private String key;
		private String message;
		
		private OrderSource(String key,String message) {
			this.key = key;
			this.message = message;
		}
		
		
		@Override
		public String getKey() {
		
			return this.key;
		}

		@Override
		public String getTitle() {
			return this.message;
		}
		
		public String toString() {
			return "[key="+key+",title="+message+"]";
		}
	}

	/**
	 * 
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年10月27日上午11:23:19
	 * 描述:支付方式封装
	 * 备注:
	 */
	public enum PayWay implements BaseEnum<Integer>{
		WCHAT_PAY(10001,"微信支付"),
		ALBBA_PAY(10002,"支付宝支付");

		private Integer key;
		private String message;
		
		private PayWay(Integer key,String message) {
			this.key = key;
			this.message = message;
		}
		
		@Override
		public Integer getKey() {
			// TODO Auto-generated method stub
			return this.key;
		}

		@Override
		public String getTitle() {
			// TODO Auto-generated method stub
			return this.message;
		}

		public String toString() {
			return "[key="+key+",title="+message+"]";
		}
		
		
		public static PayWay getByValue(String value) {
			for (PayWay _enum : values()) {
				if (_enum.getTitle() == value) {
					return _enum;
				}
			}
			return null;
		}
	}
	/**
	 * 
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年11月1日下午2:15:06
	 * 描述:订单状态枚举
	 * 备注:
	 */
	public enum OrderStateEnum implements BaseEnum<Integer>{
		ORDER_INIT_STATE(1001,"订单初始化"),
		ORDER_PAYTIMEOUT(1002,"订单支付超时"),
		ORDER_PAY_ERROR(1003,"订单支付失败"),
		ORDER_PAY_SUCCESS(1004,"订单支付成功"),
		ORDER_CREATE_EXCEPTION(1005,"订单创建异常");

		private Integer key;
		private String message;
		
		private OrderStateEnum(Integer key,String message) {
			this.key = key;
			this.message = message;
		}
		@Override
		public Integer getKey() {
			// TODO Auto-generated method stub
			return this.key;
		}

		@Override
		public String getTitle() {
			// TODO Auto-generated method stub
			return this.message;
		}
		public String toString() {
			return "[key="+key+",title="+message+"]";
		}
	}
}
