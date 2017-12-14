package com.bz.open.core.vo.request.upload;

import com.bz.framework.pojo.base.BasePojo;
import com.bz.framework.constant.upload.UploadBusinessType;
/**
 * 
 * 作者:唐鹏
 * 创建时间:2017年11月13日下午2:11:06
 * 描述:
 * 备注:
 */
public class UploadFileRequestVo extends BasePojo{

	private static final long serialVersionUID = -1008167435245289376L;
	
	private String fileSuffixName;//文件后缀名
	
	private UploadBusinessType UploadBusinessType;
	
	private String aipNo;//客户端编号
	
	
	public String getFileSuffixName() {
		return fileSuffixName;
	}

	public void setFileSuffixName(String fileSuffixName) {
		this.fileSuffixName = fileSuffixName;
	}

	public UploadBusinessType getUploadBusinessType() {
		return UploadBusinessType;
	}

	public void setUploadBusinessType(UploadBusinessType uploadBusinessType) {
		UploadBusinessType = uploadBusinessType;
	}

	public String getAipNo() {
		return aipNo;
	}

	public void setAipNo(String aipNo) {
		this.aipNo = aipNo;
	}
	
	

}
