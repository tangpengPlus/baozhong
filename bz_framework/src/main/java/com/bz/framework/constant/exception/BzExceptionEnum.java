package com.bz.framework.constant.exception;

import com.bz.framework.constant.base.BaseEnum;

/**
 * 作者:唐鹏
 * 描述: BZ服务异常枚举类
 * 创建时间:2017年9月29日上午11:22:47
 */
public class BzExceptionEnum {

	/**
	 * 
	 * 作者:唐鹏
	 * 描述: 用户模块异常信息枚举
	 * 创建时间:2017年9月29日上午11:28:48
	 */
	public enum UserExceptionEnum implements BaseEnum<Integer>{
         USER_CREATE_ERROR(100001,"创建用户信息失败"),
         USER_ADD_MESSAGE_ERROR(100002,"添加用户信息失败"),
         USER_SELECT_MESSAGE_ERROR(100003,"查询用户失败");
		
		private Integer key;
		private String message;
		
		private UserExceptionEnum(Integer key, String message) {
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
	
	/**
	 * 
	 * 作者:唐鹏
	 * 描述:商户异常枚举封装
	 * 创建时间:2017年9月29日上午11:34:02
	 */
	public enum MerchantExceptionEnum implements BaseEnum<Integer>{
		MERCHANT_CREATE_FAILE(200001,"商户创建失败");

		
		private Integer key;
		private String message;
		
		private MerchantExceptionEnum(Integer key, String message) {
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
	
	/**
	 * 
	 * 作者:唐鹏
	 * 描述:订单异常枚举
	 * 创建时间:2017年9月29日上午11:36:31
	 */
	public enum OrderExceptionEnum implements BaseEnum<Integer>{
		ORDER_CREATE_FALILE(300001,"订单创建错误"),
		ORDER_CREATE_PARM_NULL(300002,"订单创建请求参数为空"),
		ORDER_CREATE_PARM_FORMAT_ERROR(300003,"订单创建请求参数格式错误"),
		ORDER_CREATE_TIME_OUT(300004,"订单创建超时"),
		ORDER_STATE_CANGE_PARM_NULL(300005,"订单状态改变参数为空"),
		ORDER_STATE_CANGE_ERROR(300006,"订单状态更改错误");

		private Integer key;
		private String message;
		
		private OrderExceptionEnum(Integer key, String message) {
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
	
	/**
	 * 
	 * 作者:唐鹏
	 * 描述:支付异常枚举
	 * 创建时间:2017年9月29日上午11:38:45
	 */
	public enum PayExceptionEnum implements BaseEnum<Integer>{
		PAY_CREATE_FALIE(400001,"支付信息创建失败"),
		PAY_WX_SIGN_ERROR(400002,"调用微信统一下单请求签名失败"),
		PAY_WX_RQ_ERROR(400003,"调用微信统一下单请求调用微信接口失败"),
		PAY_WX_RQ_NULL(400005,"调用微信统一下单请求参数为空"),
		PAY_ALIPYA_RQ_NULL(400006,"调用支付宝移动支付请求参数为空"),
		PAY_ALIPYA_RQ_ERROR(400007,"调用支付宝移动支付请求参数错误");

		private Integer key;
		private String message;
		
		private PayExceptionEnum(Integer key, String message) {
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
	
	/**
	 * 作者:唐鹏
	 * 描述: 文件服务模块异常枚举
	 * 创建时间:2017年9月29日上午11:41:33
	 */
	public enum FileExceptionEnum implements BaseEnum<Integer>{
		FILE_CREATE_ERROR(500001,"文件信息创建失败"),
		FILE_dELETE_ERR0R(500002,"文件信息删除失败");

		private Integer key;
		private String message;
		private FileExceptionEnum(Integer key, String message) {
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
	
	/**
	 * 
	 * 作者:唐鹏
	 * 描述:外接板块异常枚举
	 * 创建时间:2017年9月29日上午11:44:27
	 */
	public enum ExternalExceptionEnum implements BaseEnum<Integer>{
		EXTERNAL_CREATE_ERROR(600001,"第三方调用失败"),
		EXTERNAL_SEND_WEIXI_TEMPLATE_NMESSAGE_ERROR(600002,"发送微信模板消息失败"),
		EXTERNAL_SEND_WEIXI_MASS_NMESSAGE_ERROR(600003,"发送微信群发消息失败"),
		EXTERNAL_WEIXIN_TOOLS_ERROR(600004,"调用微信工具服务失败"),
		EXTERNAL_SEND_SMS_ERROR(600005,"使用短信服务失败"),
		EXTERNAL_SEND_MAIL_ERROR(600006,"调用邮件服务失败"),
		EXTERNAL_MAP_SERVER_ERROR(600007,"调用地图服务失败"),
		EXTERNAL_ADMINISTRATIVE_AREA_SERVICE_ERROR(600008,"调用行政区服务失败"),
		EXTERNAL_SEND_PUSH_ERROR(600009,"发送推送消息失败"),
		EXTERNAL_QRCODE_SERVER_ERROR(600010,"生成二维码失败"),
		EXTERNAL_DOLOAD_FILE_ERROR(600011,"下载微信文件失败");
		private Integer key;
		private String message;
		private ExternalExceptionEnum(Integer key, String message) {
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
	/**
	 * 
	 * 
	 * 作者: 彭云山
	 * 描述:商品分类异常枚举
	 * 创建时间:2017年11月27日下午2:54:23
	 * 修改备注:
	 */
	public enum CategoryExceptionEnum implements BaseEnum<Integer>{
		EXTERNAL_CATEGORY_ERROR(700001,"获取商铺分类错误"),
		EXTERNAL_GETUPLEVEL_ERROR(700002,"获取商铺分类错误");

		private Integer key;
		private String message;
		private CategoryExceptionEnum(Integer key, String message) {
			this.key = key;
			this.message = message;
		}
		@Override
		public Integer getKey() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getTitle() {
			// TODO Auto-generated method stub
			return null;
		}
		public String toString() {
			return "[key="+key+",title="+message+"]";
		}
		
	}
}
