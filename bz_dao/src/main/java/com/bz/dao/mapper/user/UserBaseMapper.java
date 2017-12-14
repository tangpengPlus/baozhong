package com.bz.dao.mapper.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bz.dao.mapper.base.BaseMapper;
import com.bz.dao.pojo.user.UserBase;

public interface UserBaseMapper extends BaseMapper<UserBase> {
    /**
     *  动态字段,写入数据库记录,user_base
     *
     * @param record
     */
    int insertSelective(UserBase record);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,user_base
     *
     * @param record
     */
    int updateByPrimaryKeySelective(UserBase record);
    
    /**
    * @作者 胡竞
    * @Title: selectRegion 
    * @Description: TODO(查询地区用户信息) 
    * @param @param regionId
    * @param @return    设定文件 
    * @return List<UserBase>    返回类型 
    * @throws
     */
    List<UserBase> selectRegion(@Param("regionId")Integer regionId);
    
    /**
    * @作者 胡竞
    * @Title: selectUserByPushId 
    * @Description: TODO(通过PushId查询用户ID) 
    * @param @return    设定文件 
    * @return int    返回类型 
    * @throws
     */
    List<UserBase> selectUserIdByPushId(@Param("pushId")String pushids);
    
    /**
    * @作者 胡竞
    * @Title: selectUserByOpenId 
    * @Description: TODO(通过openId查询用户信息) 
    * @param @param wechatopenid
    * @param @return    设定文件 
    * @return int    返回类型 
    * @throws
     */
    UserBase selectUserByOpenId(@Param("weChatOpenId")String weChatOpenId);
}