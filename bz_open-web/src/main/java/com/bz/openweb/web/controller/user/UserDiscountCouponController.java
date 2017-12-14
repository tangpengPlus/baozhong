package com.bz.openweb.web.controller.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.bz.framework.pojo.base.BaseResult;
import com.bz.open.core.vo.response.user.UserRedpacketWareHouseResponseVo;
import com.bz.openweb.config.constant.SystemConstant;
import com.bz.openweb.core.service.user.UserRedpacketService;

/**
* @ClassName: UserDiscountCouponController 
* @Description: TODO(用户红包券控制) 
* @author 胡竞
* @date 2017年11月23日 下午4:19:11 
*
 */
@Controller
@RequestMapping(value="/user")
public class UserDiscountCouponController {

	private final Logger logger=LoggerFactory.getLogger(UserDiscountCouponController.class);
	
	@Autowired
	private UserRedpacketService userService;
	
	/**
	* @作者 胡竞
	* @Title: getUserConpon 
	* @Description: TODO(访问用户红包券页面) 
	* @param @param mv
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@GetMapping(value="/redpacket")
	public ModelAndView getUserConpon(ModelAndView mv,Integer id) {
		logger.info("进入用户红包券页面,传入的【userId:"+id+"】");
			//查询用户的红包券
	    BaseResult<List<UserRedpacketWareHouseResponseVo>>	baseResult=userService.getUserDiscountCoupon(id);
		//判断结果是否成功
		if(baseResult.isSucceed()) {
			//成功跳转红包券页面
			mv.addObject("redpacketList",baseResult.getData());
			mv.setViewName("user/discountcoupon");
		}else {
			//不成功跳转首页
			mv.addObject(SystemConstant.PAGE_ALERT_MESSAGE_KEY, baseResult.getMessage());
			mv.setViewName("redirect:index");
		}
		return mv;
	}
	
}
