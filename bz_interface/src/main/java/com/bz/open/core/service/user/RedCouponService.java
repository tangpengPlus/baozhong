package com.bz.open.core.service.user;
/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年11月1日上午11:43:31
 * 描述:用户红包券服务
 * 备注:
 */

import java.util.List;
import com.bz.dao.pojo.user.UserRedpacketWarehouse;
import com.bz.framework.error.exception.UserException;
import com.bz.open.core.vo.request.user.UserRedpacketUserecordRequestVo;
import com.bz.open.core.vo.request.user.UserRedpacketWareHouseRequestVo;
import com.bz.open.core.vo.response.user.UserRedpacketUserecordResponseVo;
import com.bz.open.core.vo.response.user.UserRedpacketWareHouseResponseVo;

public interface RedCouponService {

	/**
	 * 
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年11月1日上午11:57:25
	 * 描述:获取用户所有的红包券信息
	 * 备注:
	 * @param userId 用户Id
	 * @return
	 * @throws UserException
	 */
	public List<UserRedpacketWareHouseResponseVo> selectUserRedpacketWarehouse(Integer userId)throws UserException;
	/**
	 * 作者:唐鹏
	 * 创建时间:2017年11月1日上午11:59:34
	 * 描述:获取用户红包券使用记录
	 * 备注:
	 * @param userId 用户Id
	 * @return
	 * @throws UserException {@link UserException} 用户服务异常封装
	 */
	public List<UserRedpacketUserecordResponseVo> selectUserRedpacketUserecord(Integer userId)throws UserException;
	/**
	 * 
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年11月1日下午12:01:01
	 * 描述:用户领取红包券服务
	 * 备注:
	 * @param redpacketWarehouse {@link UserRedpacketWarehouse} 红包券领取记录封装
	 * @throws UserException {@link UserException} 用户服务异常封装
	 */
    public void addUserRedpacket(UserRedpacketWareHouseRequestVo redpacketWarehouse)throws UserException;
    
    /**
     * 
     * 
     * 作者:唐鹏
     * 创建时间:2017年11月1日下午12:02:10
     * 描述:用户使用红包券记录添加
     * 备注:
     * @param redpacketRserecord {@link UserRedpacketRserecord} 红包券使用记录封装
     * @throws UserException {@link UserException} 用户服务异常封装
     */
    public void adduseRedpacket(UserRedpacketUserecordRequestVo userRedpacketUserecordRequestVo)throws UserException;

    
    /**
     * 
     * 
     * 作者:唐鹏
     * 创建时间:2017年11月1日下午12:03:52
     * 描述:判断当前用户当前红包券是否能使用
     * 备注:
     * @param userId:用户Id
     * @param redpacketId:红包券Id
     * @return
     * @throws UserException {@link UserException} 用户服务异常封装
     */
    public boolean isCanUseCurryRedpacket(Integer userId,Integer redpacketId)throws UserException;
    
    /**
     * 
     * 
     * 作者:唐鹏
     * 创建时间:2017年11月1日下午1:43:24
     * 描述:获取用户有效红包券
     * 备注:
     * @return
     * @throws UserException
     */
    public List<UserRedpacketWareHouseResponseVo> selectEffectiveUserRedpacketWarehouse(Integer userId)throws UserException;
    
    /**
     * 
     * 
     * 作者:唐鹏
     * 创建时间:2017年11月3日上午9:57:23
     * 描述:根据条件查询用户的红包券信息
     * 备注:
     * @param redpacketWarehouse {@link UserRedpacketWarehouse} 条件信息封装
     * @return
     * @throws UserException {@link UserException} 用户服务异常封装
     */
    public UserRedpacketWareHouseResponseVo selectUserUserRedpacketWarehouseByCondition(UserRedpacketWareHouseRequestVo redpacketWarehouse)throws UserException;
    
    /**
     * 
     * 
     * 作者:唐鹏
     * 创建时间:2017年11月3日上午10:17:42
     * 描述:锁定用户红包券
     * 备注:
     * @param couponId 用户红包券Id
     * @return
     * @throws UserException {@link UserException} 用户服务异常封装
     */
    public boolean lockUserCoupon(Integer couponId)throws UserException;
    
}
