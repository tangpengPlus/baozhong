package com.bz.framework.constant.message;

import com.bz.framework.constant.base.BaseEnum;

/**
 * 
 * 作者:唐鹏
 * 创建时间:2017年10月16日下午2:52:45
 * 描述:消息常量封装
 * 备注:
 */
public class MessageEnum {
	
		/**
		 * 
		 * 作者:唐鹏
		 * 创建时间:2017年10月16日下午2:55:35
		 * 描述:微信模板类型枚举封装
		 * 备注:
		 */
		public enum WeixinTemplateMessageEnum implements BaseEnum<String>{
		WEIXIN_TEMPLATE_MESSAGE_ORDERID("1000001","123123123123"),//支付消息模板Id
		WEIXIN_TEMPLATE_MESSAGE_COLLECTION("first,remark,keyword1,keyword2,keyword3,keyword4,keyword5","3DUGO7MgazOv3hEdenPhPsYC54IYgdPt6bnL_QSgkbM"),
		WEIXIN_TEMPLATE_MESSAGE_PAYMENT("first,remark,keyword1,keyword2,keyword3,keyword4,keyword5","bOOIsSgxIbFxX_HGhVBHdqJPYn8HT_hDSRQ0e6_UtrA");
		private String key;
		private String message;
		
		private WeixinTemplateMessageEnum(String key,String message) {
			this.key = key;
			this.message = message;
		}
		@Override
		public String getKey() {
			
			return this.key;
		}

		@Override
		public String getTitle() {
			// TODO Auto-generated method stub
			return message;
		}
		public String toString() {
			return "[key="+key+",title="+message+"]";
		}
	}
     /**
      * 
      * 作者:唐鹏
      * 创建时间:2017年10月16日下午4:02:21
      * 描述:系统消息类型枚举
      * 备注:
      */
	public enum MessageTypeEnum implements BaseEnum<Integer>{
		SYSTEM_SMS_VERIFICATION_CODE(2000001,"短信验证码消息"),
		SYSTEM_SMS_NOTICE_CODE(2000002,"短信通知消息"),
		SYSTEM_WEIXIN_MASS(2000003,"微信群发消息"),
		SYSTEM_WEIXIN_TEMPLTE(2000004,"微信模板消息"),
		SYSTEM_PUSH(2000005,"手机推送消息"),
		SYSTEM_EMIL(2000006,"邮件消息");

		private Integer key;
		private String message;
		
		private MessageTypeEnum(Integer key,String message) {
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
	 * 创建时间:2017年10月16日下午5:01:29
	 * 描述:短信模板封装
	 * 备注:
	 */
	public enum SmsTemplateIdEnum{
		/*发送短信验证码*/
		SMS_SED_VERIFICATION_CODE("123123213","【宝众科技】您的验证码是:{验证码}，请在五分钟内输入。请勿告诉他人。");

		private String key;
		private String message;
		
		private SmsTemplateIdEnum(String key,String message) {
			this.key = key;
			this.message = message;
		}
		
		public String getKey() {
			return this.key;
		}
		public String getMessage() {
			return this.message;
		}
		public String toString() {
			return "[key="+key+",title="+message+"]";
		}
	}
}
