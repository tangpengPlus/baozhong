package com.bz.open.core.vo.response.upload;

import com.bz.framework.pojo.base.BasePojo;

/** 
 * <p>上传vo类。</p> 
 * 
 * 
 * @author 唐鹏
 * @version 1.0.0 Date: 2016年11月15日 下午2:39:27
 */ 
public class UploadResponseVo extends BasePojo {
	private static final long serialVersionUID = -3588791724165991177L;
	private long id;
	private String url;
	public UploadResponseVo() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * id
	 * @return id
	 */
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * 完整 url
	 * @return 完整 url
	 */
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
