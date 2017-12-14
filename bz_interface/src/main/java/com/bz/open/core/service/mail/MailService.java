package com.bz.open.core.service.mail;

import com.bz.framework.error.exception.ExternalException;
import com.bz.open.core.vo.request.mail.MailRequestVo;

/**
 * 
 * 作者:唐鹏
 * 创建时间:2017年10月17日下午2:06:24
 * 描述:邮件服务开放接口
 * 备注:
 */
public interface MailService {

	/**
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年10月17日下午2:13:03
	 * 描述:发送邮件
	 * 备注:
	 * @param mailVo 邮件信息封装 {@link MailRequestVo}
	 * @return boolean true:成功 false:失败
	 * @throws ExternalException 异常封装 {@link ExternalException}
	 */
	public boolean sendEmail(MailRequestVo mailVo)throws ExternalException;
}
