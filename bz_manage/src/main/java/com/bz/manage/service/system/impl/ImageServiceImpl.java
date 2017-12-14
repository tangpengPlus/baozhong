package com.bz.manage.service.system.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.bz.manage.core.constant.base.SystemConstant;
import com.bz.manage.core.util.image.GenerateVerificationCodeUtil;
import com.bz.manage.service.system.ImageService;
@Service
public class ImageServiceImpl implements ImageService{

	@Override
	public void getVerificationCode(HttpServletResponse response, HttpServletRequest request) throws Exception {
		
		GenerateVerificationCodeUtil.generateVerificationCode(request, response);
	}

	@Override
	public boolean isMatchingVerificationCode(String code,HttpSession session) throws Exception {
		
		return StringUtils.isNotBlank(code) && session != null
                && StringUtils.equalsIgnoreCase(code, (String) session.getAttribute(SystemConstant.VERIFICATION_CODE));
	}

}
