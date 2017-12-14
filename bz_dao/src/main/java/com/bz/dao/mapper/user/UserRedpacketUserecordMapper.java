package com.bz.dao.mapper.user;

import com.bz.dao.mapper.base.BaseMapper;
import com.bz.dao.pojo.user.UserRedpacketUserecord;

public interface UserRedpacketUserecordMapper extends BaseMapper<UserRedpacketUserecord> {
    /**
     *  动态字段,写入数据库记录,user_redpacket_userecord
     *
     * @param record
     */
    int insertSelective(UserRedpacketUserecord record);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,user_redpacket_userecord
     *
     * @param record
     */
    int updateByPrimaryKeySelective(UserRedpacketUserecord record);
}