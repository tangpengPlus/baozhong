package com.bz.manage.model.test;

/**
 * 
 * 作者: 胡竞
 * 描述: 测试邮箱设置模型类
 * 创建时间:2017年10月11日 下午3:18:23
 * 修改备注:
 */
public class Email {

	/**
	 * 邮件发送方式
	 */
	private int sendMode;
	
	/**
	 * SMTP 服务器
	 */
	private String smtpServers;
	
	/**
	 * SMTP 端口
	 */
	private String smtpPort;
	
	/**
	 * 发信人邮件地址
	 */
	private String senderEmail;
	
	/**
	 * SMTP 身份验证用户名 
	 */
	private String smtpName;
	
	/**
	 * SMTP 身份验证密码
	 */
	private String smptPassword;
	
	/**
	 * 测试邮件地址
	 */
	private String testEmail;

	public int getSendMode() {
		return sendMode;
	}

	public void setSendMode(int sendMode) {
		this.sendMode = sendMode;
	}

	public String getSmtpServers() {
		return smtpServers;
	}

	public void setSmtpServers(String smtpServers) {
		this.smtpServers = smtpServers;
	}

	public String getSmtpPort() {
		return smtpPort;
	}

	public void setSmtpPort(String smtpPort) {
		this.smtpPort = smtpPort;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	public String getSmtpName() {
		return smtpName;
	}

	public void setSmtpName(String smtpName) {
		this.smtpName = smtpName;
	}

	public String getSmptPassword() {
		return smptPassword;
	}

	public void setSmptPassword(String smptPassword) {
		this.smptPassword = smptPassword;
	}

	public String getTestEmail() {
		return testEmail;
	}

	public void setTestEmail(String testEmail) {
		this.testEmail = testEmail;
	}
	
}
