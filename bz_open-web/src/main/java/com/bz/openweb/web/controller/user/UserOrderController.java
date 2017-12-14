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
import com.bz.open.core.vo.response.order.UserOrderResponseVo;
import com.bz.openweb.config.constant.SystemConstant;
import com.bz.openweb.core.service.user.UserOrderMessageService;

/**
* @ClassName: UserOrderController 
* @Description: TODO(用户订单控制) 
* @author 胡竞
* @date 2017年11月24日 下午8:10:54 
*
 */
@Controller
@RequestMapping(value="/user")
public class UserOrderController {

	private final Logger logger=LoggerFactory.getLogger(UserOrderController.class);
	
	@Autowired
	private UserOrderMessageService userOrderMessageService;
	
	/**
	* @作者 胡竞
	* @Title: userOrderMessage 
	* @Description: TODO(访问用户订单页面) 
	* @param @param mv
	* @param @param id
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@GetMapping(value="/order")
	public ModelAndView userOrderMessage(ModelAndView mv,Integer id) {
		BaseResult<List<UserOrderResponseVo>> baseResult=userOrderMessageService.getUserOrder(id);
		//判断是否成功
		if(baseResult.isSucceed()) {
			//成功条状到订单页面
			List<UserOrderResponseVo> list=baseResult.getData();
			mv.addObject("userorderList",list);
			mv.setViewName("user/myorder");
		}else {
			//不成功跳转到用户中心
			mv.addObject(SystemConstant.PAGE_ALERT_MESSAGE_KEY,baseResult.getMessage());
			mv.setViewName("redirect:index");
		}
		return mv;
	}
	
	/**
	* @作者 胡竞
	* @Title: orderDetails 
	* @Description: TODO(用户订单详情页面) 
	* @param @param mv
	* @param @param orderId
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@GetMapping(value="/orderDetails")
	public ModelAndView orderDetails(ModelAndView mv,Integer orderId) {
		logger.info("进入用户订单详情");
		BaseResult<UserOrderResponseVo> baseResult=userOrderMessageService.getDetailsOrder(orderId);
		//判断返回结果是否成功
		if(baseResult.isSucceed()) {
			//成功
			logger.info("请求成功");
			mv.addObject("order",baseResult.getData());
			mv.setViewName("user/myorder_details");
		}else {
			//失败
			mv.addObject(SystemConstant.PAGE_ALERT_MESSAGE_KEY,baseResult.getMessage());
			mv.setViewName("rediect:order");
		}
		return mv;
	}
}
