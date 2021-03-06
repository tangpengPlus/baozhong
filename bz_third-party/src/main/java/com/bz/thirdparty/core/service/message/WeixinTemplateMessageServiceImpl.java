package com.bz.thirdparty.core.service.message;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.bz.dao.mapper.message.MessageRecordMapper;
import com.bz.dao.pojo.message.MessageRecord;
import com.bz.framework.constant.exception.BzExceptionEnum.ExternalExceptionEnum;
import com.bz.framework.error.exception.ExternalException;
import com.bz.open.core.service.weixin.WeixinTemplateMessageService;
import com.bz.open.core.vo.request.weixin.WeixinTemplateMessageRequest;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
/**
 * 
 * 作者:唐鹏
 * 创建时间:2017年10月16日下午2:44:23
 * 描述:微信模板消息实现
 * 备注:
 */
@Service(version="1.0.0",interfaceClass=com.bz.open.core.service.weixin.WeixinTemplateMessageService.class)
public class WeixinTemplateMessageServiceImpl implements WeixinTemplateMessageService{
     
	private final Logger logger=LoggerFactory.getLogger(WeixinTemplateMessageServiceImpl.class);
	
	@Autowired
	private WxMpService wxMpService;

	@Autowired
	private MessageRecordMapper messageRecordMapper;
	@Override
	public boolean sendWeixinTemplateMessage(WeixinTemplateMessageRequest weixinTemplateMessage) throws ExternalException {
		if(null==weixinTemplateMessage) {
			logger.error("发送微信模板消息失败:错误原因:{1:参数对象【WeixinTemplateMessage】为空}");
			throw new ExternalException(ExternalExceptionEnum.EXTERNAL_SEND_WEIXI_TEMPLATE_NMESSAGE_ERROR, "发送微信模板消息失败:错误原因:{1:【参数对象WeixinTemplateMessage】为空}");
		}
		if(StringUtils.isEmpty(weixinTemplateMessage.getOpenId())) {
			logger.error("发送微信模板消息失败:错误原因:{1:参数对象【WeixinTemplateMessage】中属性【openId】为空}");
			throw new ExternalException(ExternalExceptionEnum.EXTERNAL_SEND_WEIXI_TEMPLATE_NMESSAGE_ERROR, "发送微信模板消息失败:错误原因:参数对象【WeixinTemplateMessage】中属性【openId】为空}");
		}
		if(weixinTemplateMessage.getMessageEnum()==null) {
			logger.error("发送微信模板消息失败:错误原因:{1:参数对象【WeixinTemplateMessage】中属性【messageEnum】为空}");
			throw new ExternalException(ExternalExceptionEnum.EXTERNAL_SEND_WEIXI_TEMPLATE_NMESSAGE_ERROR, "发送微信模板消息失败:错误原因:参数对象【WeixinTemplateMessage】中属性【messageEnum】为空}");
		}
		
		if(weixinTemplateMessage.getValue()==null) {
			logger.error("发送微信模板消息失败:错误原因:{1:参数对象【WeixinTemplateMessage】中属性【parmAndVule】为空}");
			throw new ExternalException(ExternalExceptionEnum.EXTERNAL_SEND_WEIXI_TEMPLATE_NMESSAGE_ERROR, "发送微信模板消息失败:错误原因:参数对象【WeixinTemplateMessage】中属性【value】为空}");
		}
		HashMap<String, String> ParmAndVule = new HashMap<>();
		String keys = weixinTemplateMessage.getMessageEnum().getKey();
		String[] key = keys.split(",");
		for(int i=0;i<key.length;i++) {
			switch (key[i]) {
				case "first":
					ParmAndVule.put(key[i], weixinTemplateMessage.getValue().getFirst());
					break;
				case "remark":
					ParmAndVule.put(key[i], weixinTemplateMessage.getValue().getRemark());
					break;
				case "keyword1":
					ParmAndVule.put(key[i], weixinTemplateMessage.getValue().getKeyword1());
					break;
				case "keyword2":
					ParmAndVule.put(key[i], weixinTemplateMessage.getValue().getKeyword2());	
					break;
				case "keyword3":
					ParmAndVule.put(key[i], weixinTemplateMessage.getValue().getKeyword3());		
					break;
				case "keyword4":
					ParmAndVule.put(key[i], weixinTemplateMessage.getValue().getKeyword4());
					break;
				case "keyword5":
					ParmAndVule.put(key[i], weixinTemplateMessage.getValue().getKeyword5());
					break;
			default:
				break;
			}
		}
		WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
		templateMessage.setToUser(weixinTemplateMessage.getOpenId());
		templateMessage.setTemplateId(weixinTemplateMessage.getMessageEnum().getTitle());
		templateMessage.setUrl(weixinTemplateMessage.getUrl());
		//拼接模板消息内容
		for(Map.Entry<String, String> map:ParmAndVule.entrySet()) {
			//拼接微信消息体
			templateMessage.getData().add(new WxMpTemplateData(map.getKey(), map.getValue(), "#FF00FF"));
		}
		try {
			wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
			//将消息存入数据库中做记录
			if(weixinTemplateMessage.isRecord()) {
				MessageRecord messageRecord=new MessageRecord();
				messageRecord.setCount(weixinTemplateMessage.getCount());
				messageRecord.setTile(weixinTemplateMessage.getTilte());
				messageRecord.setType(weixinTemplateMessage.getMsgType().getTitle());
				messageRecord.setCreatetime(new Date());
				messageRecordMapper.save(messageRecord);
			}
		} catch (WxErrorException e) {
		   logger.error("发送微信模板消息失败", e);
			throw new ExternalException(ExternalExceptionEnum.EXTERNAL_SEND_WEIXI_TEMPLATE_NMESSAGE_ERROR, "发送微信模板消息失败");
		}
		return true;
	}
	
}
