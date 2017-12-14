package com.bz.openweb.web.controller.merchant;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bz.open.core.vo.response.regin.ReginResponsVo;
import com.bz.openweb.core.service.merchant.MerchantRegistService;

/**
 * 
 * 
 * 作者: 彭云山
 * 描述:获取地理位置控制层
 * 创建时间:2017年11月22日下午8:03:18
 * 修改备注:
 */
@Controller
@RequestMapping(value="/merchant")
public class ReginListController {
	private final Logger logger = LoggerFactory.getLogger(MerchantRegistController.class);
	@Autowired
	private MerchantRegistService merchantRegistService;
	
	
}
