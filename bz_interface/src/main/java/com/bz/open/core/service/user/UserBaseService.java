package com.bz.open.core.service.user;
/**
 * 
* @ClassName: UserBaseService 
* @Description: TODO(用户基础开放服务接口) 
* @author 胡竞
* @date 2017年11月1日 下午5:31:21 
*
 */

import java.util.List;

import com.bz.framework.error.exception.UserException;
import com.bz.open.core.vo.response.user.UserBaseResponseVo;

import me.chanjar.weixin.mp.bean.result.WxMpUser;

public interface UserBaseService {

	/**
	 * 
	* @作者 胡竞
	* @Title: getUserBaseInfo 
	* @Description: TODO(根据用户Id获取用户基本信息) 
	* @param @param userId 用户Id
	* @param @return
	* @param @throws UserException    设定文件 
	* @return UserBase    返回类型 
	* @throws
	 */
	public UserBaseResponseVo getUserBaseInfo(Integer userId)throws UserException;
	
	/**
	* @作者 胡竞
	* @Title: getRegionUserBase 
	* @Description: TODO(查询当前地区的用户基本信息) 
	* @param @param regionId
	* @param @return    设定文件 
	* @return List<UserBase>    返回类型 
	* @throws
	 */
	public List<UserBaseResponseVo> getRegionUserBase(Integer regionId) throws UserException;

	/**
	* @作者 胡竞
	* @Title: getUserByOpenId 
	* @Description: TODO(通过OpenId查询User) 
	* @param @return
	* @param @throws UserException    设定文件 
	* @return UserBase    返回类型 
	* @throws
	 */
	public UserBaseResponseVo getUserByOpenId(String openId)throws UserException;
	
	/**
	* @作者 胡竞
	* @Title: getUserByWeiXinUser 
	* @Description: TODO(根据微信对象获取当前对象) 
	* @param @return
	* @param @throws UserException    设定文件 
	* @return UserBaseResponseVo    返回类型 
	* @throws
	 */
	public UserBaseResponseVo getUserByWeiXinUser(WxMpUser user)throws UserException;
}
