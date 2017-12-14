package com.bz.openweb.core.service.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bz.framework.constant.result.ResultValueEnum;
import com.bz.framework.pojo.base.BaseResult;
import com.bz.framework.util.base.IntegerUtil;
import com.bz.open.core.service.merchant.MerchantBaseService;
import com.bz.open.core.service.merchant.MerchantRedCouponService;
import com.bz.open.core.service.user.RedCouponService;
import com.bz.open.core.vo.response.user.UserRedpacketWareHouseResponseVo;
/**
* @ClassName: UserRedpacketService 
* @Description: TODO(用户优惠券服务) 
* @author 胡竞
* @date 2017年11月27日 上午10:11:33 
*
 */
@Service
public class UserRedpacketService {

	private final Logger logger=LoggerFactory.getLogger(UserRedpacketService.class);
	
	@Reference(version="1.0.0")
	private RedCouponService redCouponService;
	
	@Reference(version="1.0.0")
	private MerchantRedCouponService merchantRedCouponService;
	
	@Reference(version="1.0.0")
	private MerchantBaseService merchantBaseService;
	
	/**
	* @作者 胡竞
	* @Title: getUserDiscountCoupon 
	* @Description: TODO(查询用户所有优惠券信息) 
	* @param @param userId
	* @param @return    设定文件 
	* @return List<UserRedpacketWareHouseResponseVo>    返回类型 
	* @throws
	 */
	public BaseResult<List<UserRedpacketWareHouseResponseVo>> getUserDiscountCoupon(Integer userId) {
		
		logger.info("传入的【userId:"+userId+"】");
		BaseResult<List<UserRedpacketWareHouseResponseVo>> baseResult=BaseResult.newInstance();
		if(IntegerUtil.isEmpty(userId)) {
			logger.error("获取到的userId为空,【userId:"+userId+"】");
			return baseResult.changeStatus(ResultValueEnum.USER_ISNULL_ERROR);
		}
		try {
			baseResult.setData(redCouponService.selectUserRedpacketWarehouse(userId));
		} catch (Exception e) {
			logger.error("查询用户红包券有误");
			baseResult.changeStatus(ResultValueEnum.USER_REDPACKET_ERROR);
		}
		return baseResult;
	}
	
}
