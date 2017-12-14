package com.bz.open.core.vo.request.mail;

import java.io.File;
import com.bz.framework.pojo.base.BaseMessage;
/**
 * 
 * 作者:唐鹏
 * 创建时间:2017年10月17日下午2:08:36
 * 描述:邮件服务请求参数封装
 * 备注:
 */
public class MailRequestVo extends BaseMessage{

	/**
	 * 
	 */
	private static final long serialVersionUID = 291151504064720966L;
	
	private String theRecipients;//接收人多个接收人以逗号隔开
	
	private File file;//附件文件流
	
	private Integer mailType;//邮件类型 1简单文本邮件 2:Html邮件 3:带附件的邮件

	public String getTheRecipients() {
		return theRecipients;
	}

	public void setTheRecipients(String theRecipients) {
		this.theRecipients = theRecipients;
	}

	public Integer getMailType() {
		return mailType;
	}

	public void setMailType(Integer mailType) {
		this.mailType = mailType;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
    
}
