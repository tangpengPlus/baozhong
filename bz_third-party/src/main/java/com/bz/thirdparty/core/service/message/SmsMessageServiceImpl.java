package com.bz.thirdparty.core.service.message;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.dubbo.config.annotation.Service;
import com.bz.dao.mapper.message.MessageRecordMapper;
import com.bz.dao.pojo.message.MessageRecord;
import com.bz.framework.constant.exception.BzExceptionEnum.ExternalExceptionEnum;
import com.bz.framework.constant.message.MessageEnum.SmsTemplateIdEnum;
import com.bz.framework.error.exception.ExternalException;
import com.bz.framework.util.base.BaseUtil;
import com.bz.framework.util.base.ListUtil;
import com.bz.framework.util.exception.BzfAssert;
import com.bz.open.core.service.sms.SmsMessageService;
import com.bz.open.core.vo.request.sms.SmsMessageRequest;
import com.bz.thirdparty.core.api.sms.SmsHttpApiService;
import com.bz.thirdparty.model.sms.SmsSendResult;

/**
 * 
 * 作者:唐鹏
 * 创建时间:2017年10月16日下午5:11:05
 * 描述:短信服务接口
 * 备注:
 */
@Service(version="1.0.0",interfaceClass=com.bz.open.core.service.sms.SmsMessageService.class)
@Transactional
public class SmsMessageServiceImpl implements SmsMessageService{
      
    @Autowired
    private MessageRecordMapper messageRecordMapper;
    
    @Autowired
    private SmsHttpApiService smsHttpApiService;
    
    @Value("${sms.send.intervaltime}")
    private String intervaltime;//同一手机号码短信发送时间间隔限
    
    @Value("${sms.send.onedayfrequency}")
    private String onedayfrequency;//同一手机号码短信一天能发送次数
    
    @Value("${sms.verificationcode.termofvalidity}")
    private String termofvalidity;//验证码有效期
    
	private final Logger logger=LoggerFactory.getLogger(SmsMessageServiceImpl.class);
	/**
	 * 向用户发送验证码
	 */
	@Override
	public boolean sendVerificationMessage(SmsMessageRequest smsMessage) throws ExternalException {
		logger.info("发送短信验证码:【"+smsMessage+"】");
		BzfAssert.isNull(ExternalException.class, smsMessage,"发送短信验证码失败请求参数对象【SmsMessageRequest】为null");
		if(!(BaseUtil.isTelPhone(smsMessage.getTelPhone()))) {
			logger.error("发送短信验证码失败错误原因:【SmsMessage】对象中 属性【telPhone】不是一个手机号码格式");
			throw new ExternalException(ExternalExceptionEnum.EXTERNAL_SEND_SMS_ERROR, "发送短信验证码失败错误原因:【SmsMessage】对象中 属性【telPhone】不是一个手机号码格式");
		}
		//判断当前手机号码在一段时间间隔内是否发送过该短信
		if(messageRecordMapper.selectOneMinuteMessage(smsMessage.getTelPhone(), intervaltime)!=null) {
			logger.error("发送短信验证码失败错误原因:手机号码【"+smsMessage.getTelPhone()+"】发送短信过于频繁请稍后再试");
			throw new ExternalException(ExternalExceptionEnum.EXTERNAL_SEND_SMS_ERROR, "发送短信验证码失败错误原因:手机号码【"+smsMessage.getTelPhone()+"】发送短信过于频繁请稍后再试");
		}
		//判断当前手机号码今天还能否发送短信验证
		List<MessageRecord> list=messageRecordMapper.selectTodaySendMessageByTelPhone(smsMessage.getTelPhone());
		if(!ListUtil.isEmpty(list)&&list.size()>=Integer.valueOf(onedayfrequency).intValue()) {
			logger.error("发送短信验证码失败错误原因:手机号码【"+smsMessage.getTelPhone()+"】发送短信超过当天限制【"+onedayfrequency+"】条");
			throw new ExternalException(ExternalExceptionEnum.EXTERNAL_SEND_SMS_ERROR, "发送短信验证码失败错误原因:手机号码【"+smsMessage.getTelPhone()+"】发送短信超过当天限制【"+onedayfrequency+"】条");
		}
		//生成短信验证码
		String code=RandomStringUtils.randomNumeric(3).concat(
				RandomStringUtils.randomNumeric(3));
		//将短信验证码模板中的验证码进行替换
	    String sendValidSmsCount=SmsTemplateIdEnum.SMS_SED_VERIFICATION_CODE.getMessage().replace("{验证码}", code);
		logger.info("发送短信验证码，生成的短信内容是:{}",sendValidSmsCount);
	    //发送短信
		SmsSendResult result =smsHttpApiService.sendCaptchaSms(smsMessage.getTelPhone(),sendValidSmsCount);
		logger.info(result.toString());
		if(result.getCode().equals("1")) {
			MessageRecord messageRecord=new MessageRecord();
			messageRecord.setCode(code);
			messageRecord.setType("短信验证码消息");
			messageRecord.setCreatetime(new Date());
			messageRecord.setTelphone(smsMessage.getTelPhone());
			messageRecord.setCount(sendValidSmsCount);
			messageRecordMapper.save(messageRecord);
		}else {
			logger.error("发送短信验证码失败错误原因:"+result.getMsg());
			throw new ExternalException(ExternalExceptionEnum.EXTERNAL_SEND_SMS_ERROR, "发送短信验证码失败错误原因:"+result.getMsg());
		}
		return true;
	}
	/**
	 * 验证用户上传的短信信息
	 */
	@Override
	public boolean isTrueVerificationCode(String telPhone, String code) throws ExternalException {
		if(StringUtils.isEmpty(telPhone)) {
			return false;
		}
		if(StringUtils.isEmpty(code)) {
			return false;
		}
		return messageRecordMapper.selectTelPhoneSendRecord(telPhone, code, termofvalidity)==null ?false:true;
	}
	@Override
	public boolean sendSms(SmsMessageRequest smsMessage) throws ExternalException {
		logger.info("发送短信消息【"+smsMessage+"】");
		BzfAssert.isNull(ExternalException.class, smsMessage,"发送短信失败 参数对象【SmsMessageRequest】为空");
		//验证手机号码格式
		if(!BaseUtil.isTelPhone(smsMessage.getTelPhone())) {
			logger.error("发送短信验证码失败错误原因:【SmsMessage】对象中 属性【telPhone】不是一个手机号码格式");
			throw new ExternalException(ExternalExceptionEnum.EXTERNAL_SEND_SMS_ERROR, "发送短信验证码失败错误原因:【SmsMessage】对象中 属性【telPhone】不是一个手机号码格式");
		}
		//判断当前手机号码在一段时间间隔内是否发送过该短信
		if(messageRecordMapper.selectOneMinuteMessage(smsMessage.getTelPhone(), intervaltime)!=null) {
			logger.error("发送短信验证码失败错误原因:手机号码【"+smsMessage.getTelPhone()+"】发送短信过于频繁请稍后再试");
			throw new ExternalException(ExternalExceptionEnum.EXTERNAL_SEND_SMS_ERROR, "发送短信验证码失败错误原因:手机号码【"+smsMessage.getTelPhone()+"】发送短信过于频繁请稍后再试");
		}
		//判断当前手机号码今天还能否发送短信验证
		List<MessageRecord> list=messageRecordMapper.selectTodaySendMessageByTelPhone(smsMessage.getTelPhone());
		if(!ListUtil.isEmpty(list)&&list.size()>=Integer.valueOf(onedayfrequency).intValue()) {
			logger.error("发送短信验证码失败错误原因:手机号码【"+smsMessage.getTelPhone()+"】发送短信超过当天限制【"+onedayfrequency+"】条");
			throw new ExternalException(ExternalExceptionEnum.EXTERNAL_SEND_SMS_ERROR, "发送短信验证码失败错误原因:手机号码【"+smsMessage.getTelPhone()+"】发送短信超过当天限制【"+onedayfrequency+"】条");
		}
		if(StringUtils.isEmpty(smsMessage.getCount())){
			logger.error("发送短信验证码失败错误原因:短信内容【"+smsMessage.getCount()+"】发送短信内容为空");
			throw new ExternalException(ExternalExceptionEnum.EXTERNAL_SEND_SMS_ERROR, "发送短信验证码失败错误原因:短信内容【"+smsMessage.getCount()+"】发送短信内容为空");
		}
		//判断是发送给单个用户还是多个用户
		String telPhone="";
		if(smsMessage.isSendOne()) {
			telPhone=smsMessage.getTelPhone();
		}else {
			telPhone=StringUtils.join(smsMessage.getTelPhones(), ",");
		}
		SmsSendResult result=smsHttpApiService.sendtNoticeSms(telPhone, smsMessage.getCount());
		logger.info("发送短信第三方返回结果",result);
		if(result.getCode().equals("1")){
			if(smsMessage.isRecord()) {
				MessageRecord messageRecord=new MessageRecord();
				messageRecord.setType(smsMessage.getMsgType().getTitle());
				messageRecord.setCreatetime(new Date());
				messageRecord.setTelphone(smsMessage.getTelPhone());
				messageRecord.setCount(smsMessage.getCount());
				messageRecordMapper.save(messageRecord);
			}
		}else {
			logger.error("发送短信验证码失败错误原因:"+result.getMsg());
			throw new ExternalException(ExternalExceptionEnum.EXTERNAL_SEND_SMS_ERROR, "发送短信验证码失败错误原因:"+result.getMsg());
		}
		return true;
	}
}
