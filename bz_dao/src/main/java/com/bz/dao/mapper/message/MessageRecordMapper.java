package com.bz.dao.mapper.message;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bz.dao.mapper.base.BaseMapper;
import com.bz.dao.pojo.message.MessageRecord;

public interface MessageRecordMapper extends BaseMapper<MessageRecord> {
    /**
     *  动态字段,写入数据库记录,system_message_record
     *
     * @param record
     */
    int insertSelective(MessageRecord record);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,system_message_record
     *
     * @param record
     */
    int updateByPrimaryKeySelective(MessageRecord record);
    
    /**
     * 
     * 作者:唐鹏
     * 创建时间:2017年10月17日上午10:48:22
     * 描述:根据手机号码查询一分钟以前的消息记录
     * 备注:
     * @param telPhone
     * @return
     */
    MessageRecord selectOneMinuteMessage(@Param("telPhone")String telPhone,@Param("intervaltime")String intervaltime);
    /**
     * 
     * 作者:唐鹏
     * 创建时间:2017年10月17日上午11:55:37
     * 描述:获取今天当前手机号码发送短信记录
     * 备注:
     * @param telPhone
     * @return
     */
    List<MessageRecord> selectTodaySendMessageByTelPhone(@Param("telPhone")String telPhone);
    
    /**
     * 
     * 作者:唐鹏
     * 创建时间:2017年10月17日下午12:02:31
     * 描述:
     * 备注:
     * @param telPhone 验证电话号码
     * @param code:验证码
     * @param termofvalidity:有效期
     * @return
     */
    MessageRecord selectTelPhoneSendRecord(@Param("telPhone")String telPhone,@Param("code")String code,@Param("termofvalidity")String termofvalidity);
}