package com.bz.dao.mapper.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bz.dao.mapper.base.BaseMapper;
import com.bz.dao.pojo.user.UserMessage;

public interface UserMessageMapper extends BaseMapper<UserMessage> {
    /**
     *  动态字段,写入数据库记录,user_message
     *
     * @param record
     */
    int insertSelective(UserMessage record);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,user_message
     *
     * @param record
     */
    int updateByPrimaryKeySelective(UserMessage record);
    /**
     * @作者 胡竞
     * @Title: selectUserMessage 
     * @Description: TODO(根据用户ID查询用户不同消息状态的消息) 
     * @param @param userId
     * @param @param isprivately
     * @param @return    设定文件 
     * @return List<UserMessage>    返回类型 
     * @throws
      */
     List<UserMessage> selectUserMessage(@Param("userId")Integer userId,@Param("status")Integer status);
}