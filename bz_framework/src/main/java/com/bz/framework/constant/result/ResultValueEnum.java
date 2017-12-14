package com.bz.framework.constant.result;

import com.bz.framework.constant.base.BaseEnum;
import com.bz.framework.util.validate.ValidateUtil;

/**
 * API返回枚举类<br/>
 * 1~29系统级别错误 	例如:SYS_**<br/>
 * 30~99其他错误	例如：OTHER_**<br/>
 * 100~199订单错误	例如：ORDER_**<br/>
 * 200~299积分错误	例如：INTE_**<br/>
 * 300~399支付错误	例如：PAY_**<br/>
 * 400~499第三方错误	例如：THRID_**<br/>
 * 500~599文件上传错误	例如：UPLOAD_**
 * 600~699短信错诶  例如：MSG_**
 * 700~799商家注册错误 例如：MERCHANT_**
 * 800~899合伙人注册错误  例如：AGENT_**
 * 900~999用户错误 例如：USER_**
 * @author 唐鹏
 *
 */
public enum ResultValueEnum implements BaseEnum<Integer>{
	//1~29系统错误//
	/**1:系统成功*/
	SYS_OK(1,"OK"),
	/**2:系统错误*/
	SYS_ERROR(2,"系统错误"),
	/**3:参数错误*/
	SYS_PARAMETER_ERROR(3,"参数错误"),
	/**4:解析POJO错误*/
	SYS_PARSE_POJO_ERROR(4,"解析POJO错误"),
	/**5:当前访问客户不存在*/
	SYS_NOT_EXIST_CLIENT(5,"当前访问渠道不存在"),
	/**6:签名错误**/
	SYS_SIGN_ERROR(6,"参数签名错误"),
	/**7:应用程序错误*/
	SYS_APPLICATION_ERROR(7,"应用程序错误"),
	/**8:无访问权限**/
	SYS_NO_ACCESS_PERMISSIONS(8,"无访问权限"),
	/**9:站点不存在，未在系统中登记*/
	SYS_WEBSIZE_NOT_EXIST(9,"站点不存在，未在系统中登记"),
	
	/**13:用户未登录*/
	SYS_USER_NO_LOGIN(13,"用户未登录"),
	/**14:发送短信失败*/
	SYS_MESSAGE_FAIL(14,"发送短信失败"),
	/**15:操作超时*/
	SYS_TIME_OUT(15,"操作超时"),
	/**16:重复提交*/
	SYS_SUB_REPEAT(16,"重复提交"),
	/**17:上次操作系统进行中，请稍后...*/
	SYS_EXECUTING(17,"上次操作系统进行中，请稍后..."),
	/**18:参数为空*/
	SYS_PARAMETER_ISNULL(18,"参数为空"),
	/**19:此操作已经过期*/
	SYS_EXE_OVERDUE(19,"此操作已经过期"),
	/**20:调用第三方返回结果失败*/
	SYS_EXE_THIRD_FAIL(20,"调用第三方返回结果失败"),
	/**21:版本号为空*/
	SYS_VERSION_ISNULL(21,"版本号为空"),
	/**22:无数据*/
	SYS_NOTE_HAD_DATA(22,"无数据"),
	//30~99其他错误//
	/**30:账号不存在,不能找回密码*/
	OTHER_USER_NOT_EXIST(30,"账号不存在"),
	/**31:账户已经存在*/
	OTHER_USER_PHONE_ERROR(31,"账户已经存在"),
	/**32:操作未成功*/
	OTHER_COMMON_MODIFY_ERROR(32,"操作未成功"),
	/**33:必填项不合法*/
	OTHER_COMMON_WRONGFUL_ERROR(43,"必填项不合法"),
	/**44:未能找到合适的数据*/
	OTHER_SAERCH_RESULT_ISEMTPY(44,"未能找到合适的数据"),
	/**45:创建索引失败*/
	OTHER_CREATE_INDEX_ERROR(45,"创建索引失败"),
	/**55:用户名或密码错误*/
	OTHER_LOGIN_VALIDATE_FAIL(55,"用户名或密码错误"),
	/**56:密码不匹配*/
	OTHER_PASSWORD_NOT_MATCH(56,"密码不匹配"),
	/**57:验证码错误*/
	OTHER_RANDCODE_ERROR(57,"验证码错误"),
	/**59:密保答案不匹配*/
	OTHER_PROT_ANSWER_NOT_MATCH(59,"密保答案不匹配"),
	/**60:旧电话号码与数据库中电话号码不匹配*/
	OTHER_PHONE_NOT_MATCHING(60,"旧电话号码与数据库中电话号码不匹配"),
	/**61:安全问题未定义*/
	OTHER_USER_SAFE_QUES_EMPTY(61,"安全问题未定义"),
	/**62:用户登录失败.账号与密码不匹配*/
	OTHER_USER_LOGIN_FAIL(62,"账号与密码不匹配,或者是已经被锁定"),
	/**63:用户注册失败*/
	OTHER_USER_REGISTER_FAIL(63,"用户注册失败"),
	/**64:验证码不能为空*/
	OTHER_USER_RANDOM_EMPTY(64,"验证码不能为空"),
	/**65:验证码不匹配*/
	OTHER_USER_RANDOM_MATCH(65,"验证码不匹配"),
	/**66:手机验证码不匹配*/
	OTHER_PHONE_KEY_MATCH(66,"手机验证码不匹配"),
	/**67:用户设置密码*/
	OTHER_PHONE_SETTING_PWD(67,"用户设置密码"),
	/**68:用户已被锁定*/
	OTHER_USER_LOCK(68,"用户已被锁定"),
	/**69:用户自动登录失败**/
	OTHER_USER_LOGIN_AUTO_FAIL(69,"用户自动登录失败"),
	/**电话号码与注册电话号码不匹配**/
	OHTERN_PHONE_NOT_MEMBER(70,"电话号码与注册电话号码不匹配"),
	/**电话号码已经存在**/
	OHTHER_USER_IS_MEMBER(71,"电话号码已经存在"),
	/**用户自动登录失败*/
	OTHER_USER_AUTO_LOGIN_FAIL(72,"用户自动登录失败"),
	/**生成用户异步登录Token失败*/
	OTHER_USER_TOKEN_FAIL(79,"生成用户异步登录Token失败"),
	//100~199订单错误//
	/**100:库存不足或限购*/
	ORDER_STOCK_NOT_ENOUGH_OR_LIMIT(100,"库存不足或限购"),
	/**101:查询订单不存在*/
	ORDER_SEARCH_NOT_EXIST(101,"查询订单不存在"),
	/**102:积分平台异步通知新增预付款记录失败*/
	ORDER_SUBSIST_ADD_FAIL(102,"积分平台异步通知新增预付款记录失败"),
	/**103:第三方平台订单已经关闭*/
	ORDER_THRID_PLATFROM(103,"第三方平台订单已经关闭"),
	/**104:订单随机验证错误*/
	ORDER_RANDOM_CODE_ERR(104,"订单随机验证错误"),
	/**105:订单随机验证码已经使用*/
	ORDER_RANDOM_CODE_USED(105,"订单随机验证码已经使用"),
	/**106:订单随机验证码不属于当前店铺*/
	ORDER_RANDOM_CODE_NOT_MATCH_SHOP(106,"订单随机验证码不属于当前店铺"),
	/**107:订单随机验证码过期*/
	ORDER_RANDOM_CODE_EXPIRE(107,"订单随机验证码过期"),
	/**108:订单随机验证码未到开始使用时间*/
	ORDER_RANDOM_CODE_NOT_START_USE(108,"订单随机验证码未到开始使用时间"),
	/**109:验证码所属订单状态异常*/
	ORDER_RANDOM_CODE_STATE_ERR(109,"验证码所属订单状态异常"),
	/**110:不能申请退款，某些指标不符合*/
	ORDER_NOT_APPLY_REFUND(110,"不能申请退款，某些指标不符合"),
	/**111:不能在申请退款记录*/
	ORDER_NOT_APPLY_RECORDE(111,"不能在申请退款记录"),
	/**112:订单处于完成状态*/
	ORDER_NOT_APPLY_COMPLETE(112,"订单处于完成状态"),
	/**113:创建订单失败*/
	ORDER_CREATE_FAIL(113,"创建订单失败"),
	/**114:充值类型系统为定义*/
	ORDER_PROPERTY_NO_DEFIND(114,"充值类型系统未定义"),
	/**下单明细不能为空*/
	ORDER_DOWDN_NO_DEFIND(115,"下单明细不能为空"),
	/**消费流水还未提交上来*/
	ORDER_CONSUME_SERIAL_DETAIL_NOT_EXIST(117,"消费流水还未提交上来"),
	/**CRM修改餐台位失败*/
	ORDER_MODIFY_TABLEID_FAIL(118,"CRM修改餐台位失败"),
	/**订单类型错误,非线上订单*/
	ORDER_TYPE_FAIL(118,"订单类型错误,非线上订单"),
	/**订单取消*/
	ORDER_CANCLED(1019,"订单已取消"),
	/**订单为空*/
	ORDER_IDISNULL_ERROR(1020,"查询的订单不存在，请核对"),
	
	//200~299积分错误//
	/**200:积分帐户不存在*/
	INTE_USER_NOT_EXIST(200,"积分帐户不存在"),
	/**201:积分余额不足*/
	INTE_BALANCE_NOT_ENOUGH(201,"积分余额不足"),
	/**202:锁定返利操作失败，详情请见返利错误日志表*/
	INTE_SDFL_OPER_ERROR(202,"锁定返利操作失败，详情请见返利错误日志表"),
	/**203:解锁返利操作失败，详情请见返利错误日志表*/
	INTE_JSFL_OPER_ERROR(203,"解锁返利操作失败，详情请见返利错误日志表"),
	/**204:直接返利操作失败，详情请见返利错误日志表*/
	INTE_ZJFL_OPER_ERROR(204,"直接返利操作失败，详情请见返利错误日志表"),
	/**205:积分提现金额不足*/
	INTE_2CASH_NOT_ENOUGH_ERROR(205,"积分提现金额不足"),
	//300~399支付错误//
	/**301:支付密码错误*/
	PAY_PAYPWD_ERROR(301,"支付密码错误"),
	/**302:订单支付状态错误*/
	PAY_STATE_ERR(302,"订单支付状态错误"),
	/**303:支付密码不存在*/
	PAY_PAYPWD_NOT_EXIST(303,"未设置支付密码"),
	PAY_PAYPWD_ERROR_MAX(304,"支付密码错误已超过限制"),
	PAY_PAYPWD_UPDATE_ERR(305,"修改支付密码失败"),
	PAY_ORDER_PAY_URL_ERR(306,"创建付款链接失败"),
	PAY_PAYPWD_INIT_ERR(307,"设置支付密码失败"),
	PAY_FREEAMOUNTPWD_INIT_ERR(308,"修改免密密码失败"),
	PAY_WAY_ERROR(309,"支付方式错误"),
	PAY_MONEY_ERROR(310,"支付金额有误"),
	//400~499第三方错误//
	/**400:电话费充值面额不存在*/
	THIRED_DENO_PHONE_PAR(400,"电话费充值面额不存在"),
	/**401:生成缴费记录错误*/
	THIRED_GENERATE_PAYM_ERROR(401,"生成缴费记录错误"),
	/**402:没有在线销售*/
	THIRED_NO_ONLINE_SALES(402,"没有在线销售"),
	/**403:欠费余额数据查询失败*/
	THIRED_WHATE_ARREARS_BALANCE_FAIL(403,"欠费余额数据查询失败"),
	/**404:上下线类型未定义*/
	THIRED_BM_UP_DOWN_CATEGORY_FAIL(404,"上下线类型未定义"),
	/**未在缴费时间期间内*/
	THIRED_BM_TIME_MIDDELE_FAIL(405,"未在缴费时间期间内"),
	//500~599文件系统错误//
	/**500:上传文件格式错误*/
	UPLOAD_FORMAT_ERROR(500,"上传文件格式错误"),
	/**501:上传文件大小超过限制*/
	UPLOAD_SIZE_ERROR(501,"上传文件大小超过限制"),
	/**502:上传文件为空*/
	UPLOAD_NULL_ERROR(502,"上传文件为空"),
	/**503:上传文件错误*/
	UPLOAD_ERROR(503,"上传文件错误"),
	/**504:允许上传文件类型或参数设置错误*/
	UPLOAD_ALLOW_TYPE_ERROR(504,"允许上传文件类型或参数设置错误"),
	/**504:删除文件失败错误*/
	UPLOAD_DELETE_ERROR(505,"删除文件失败错误"),
	/**短信*/
	/**600~699*/
	MSG_MSGTEMPLET_EMPTY(600,"获取短信模板为空"),
	MSG_MSGTEMPLET_NO_EXIST(601,"短信模板不存在"),
	MSG_MESSAGE_FAIL(602,"消息发送失败"),
	MSG_RANDCODE_ERROR(603,"短信验证码错误"),
	MSG_TYPE_ERROR(604,"短信类型未定义"),
	
	
	/**商户板块*/
	/**700~799*/
	MERCHANT_REGIST_PARM_ERROR(700,"请输入您的商家名称"),
	MERCHANT_REGIST_MAXPARM_ERROR(701,"您的商家名称太长"),
	MERCHANT_REGIST_ADDRESS_ERROR(702,"请填写您商家的具体地址"),
	MERCHANT_REGIST_MAXADDRESS_ERROR(705,"您的具体地址不合法"),
	MERCHANT_REGIST_OPENID_ERROR(703,"商家注册的微信openid为空"),
	MERCHANT_REGIST_COORDANTE_ERROR(704,"获取商家店铺的经纬度为空"),
	MERCHANT_REGIST_PHONE_ERROR(705,"获取商家店铺的联系电话为空"),
	MERCHANT_REGIST_MAXPHONE_ERROR(706,"获取商家店铺的联系电话格式错误"),
	MERCHANT_REGIST_FRONTIMG_ERROR(706,"请上传您的身份证照或营业执照"),
	MERCHANT_REGIST_BUSIMG_ERROR(707,"商家上传的身份证和营业执照为空"),
	MERCHANT_REGIST_SMSCODE_ERROR(708,"用户输入的验证码错误"),
	MERCHANT_REGIST_UPDATEMERCHANT_ERROR(710,"商家修改商铺基本信息服务失败"),
	MERCHANT_REGIST_ADDBASEDATA_ERROR(711,"商户注册调用增加商家基本信息服务失败"),
	MERCHANT_REGIST_REQUEST_ERROR(712,"商户注册请求错误"),
	MERCHANT_REGIST_PHONENULL_ERROR(713,"请输入您的电话号码"),
	MERCHANT_REGIST_VALIDCODE_ERROR(714,"请输入短信验证码"),
	MERCHANT_REGIST_NOT_UPLOAD_LOGO_IMAGE(715,"请上传您店铺的logo,若没有logo请上传店铺的门头照片"),
	MERCHANT_REGIST_NOT_UPLOAD_INVATED_IMAGE(716,"请上传您店铺的实际照片"),
	MERCHANT_REGIST_SHOPLOGO_IMAGE(717,"微信店铺上传门头照错误"),
	MERCHANT_REGIST_SHOPDETAILI_IMAGE(718,"微信店铺上传门头照错误"),
	MERCHANT_REGIST_IDCARD_IMAGE(719,"身份证照片上传错误"),
	MERCHANT_REGIST_BUSINESSLICENSEIMAGE(720,"营业执照照片上传错误"),
	MERCHANT_REGIST_SENDWXMESSAGE_ERROR(721,"微信发送通知信息错误"),
	MERCHANT_REGIST_MERCHANTSERVER_ERROR(721,"查询商家服务异常"),
	MERCHANT_REGIST_MERCHANTGRTID_ERROR(722,"获取商家的ID为空"),
	MERCHANT_REGIST_STREETID_ERROR(723,"街道ID未获得"),
	MERCHANT_REGIST_UPREGINID_ERROR(724,"获取城市上级编码错误"),
	
	
	/**合伙人板块*/
	/**800~899*/
	AGENT_USERNAME_ERROR(800,"合伙人注册名字为空"),
	AGENT_SMSCODE_ERROR(801,"合伙人注册短信码为空"),
	AGENT_TELL_ERROR(802,"合伙人注册电话为空"),
	AGENT_LEGALCARDID_ERROR(803,"合伙人注册身份证编码为空"),
	AGENT_SMSCODE_ISERROR(804,"合伙人注册短信错误"),
	AGENT_SGRADE_ERROR(805,"合伙人注册类型为空"),
	AGENT_DIZI_ERROR(806,"合伙人注册地址为空"),
	AGENT_INSERT_ERROR(807,"添加数据失败"),
	AGENT_TELL_ISERROR(808,"手机号码格式错误"),
	AGENT_PARAM_NULL_ERROR(809, "获取参数错误"),
	AGENT_TELL_NULL_ERROR(809, "手机号码为空"),
	AGENT_UNREGISTER_ERROR(810,"此地区已被注册"),
	AGENT_LEGALCARDID_STYLE_ERROR(811,"身份证格式错误"),
	/**用户模块*/
	/**900~999*/
	USER_WECHATUSER_ACCREDIT_ERROR(900,"当前微信用户授权失败"),
	USER_ISNULL_ERROR(901,"查无此用户"),
	USER_SELECT_MESSAGE_ERROR(902,"查询消息失败，请确认信息后再次查询"),
	USER_REDPACKET_ERROR(903,"查询用户红包有误，请核对");
	
	
	private int key;
	private String msg;
	private ResultValueEnum(int key,String msg){
		this.key=key;
		this.msg=msg;
	}
	public Integer getKey() {
		return this.key;
	}

	public String getTitle() {
		return this.msg;
	}
	/**
	 * 根据错误编号查询具体错误类型
	 * @param key 错误编号
	 * @return {@link ResultValueEnum}
	 */
	public static ResultValueEnum queryByKey(String key){
		ResultValueEnum result=query(key);
		if(null==result){
			result=ResultValueEnum.SYS_ERROR;
		}
		return result;
	}
	private static ResultValueEnum query(String key){
		if(ValidateUtil.isNumber(key)){
			ResultValueEnum[] values= ResultValueEnum.values();
			int intKey=Integer.parseInt(key);
			for(ResultValueEnum result:values){
				if(result.getKey()==intKey){
					return result;
				}
			}
		}
		return null;
	}
	@Override
	public String toString() {
		return "[key="+this.key+",title="+this.name()+"]";
	}
}
