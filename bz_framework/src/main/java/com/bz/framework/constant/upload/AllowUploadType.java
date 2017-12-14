package com.bz.framework.constant.upload;

import org.springframework.util.Assert;

import com.bz.framework.pojo.base.BasePojo;



/**
 * 允许上传文件类型基类
 *
 */
public class AllowUploadType extends BasePojo{
	private static final long serialVersionUID = -2231277401828070483L;
	private int id;
	private long size;
	private UploadBusinessType uploadBusinessType;
	public AllowUploadType(){
		
	}
	/**
	 * 类型Id，不能重复
	 * @return 类型Id
	 */
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		Assert.isTrue(id>0);
		this.id = id;
	}
	/**
	 * 允许文件上传文件大小，单位字节
	 * @return 允许上传文件大小
	 */
	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		Assert.isTrue(size>0);
		this.size = size;
	}
	/**
	 * 上传文件业务类型
	 * @return 上传文件业务类型{@link UploadBusinessType}
	 */
	public UploadBusinessType getUploadBusinessType() {
		return uploadBusinessType;
	}
	public void setUploadBusinessType(UploadBusinessType uploadBusinessType) {
		this.uploadBusinessType = uploadBusinessType;
	}
}
