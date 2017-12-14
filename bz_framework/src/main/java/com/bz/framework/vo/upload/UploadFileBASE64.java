package com.bz.framework.vo.upload;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import com.bz.framework.constant.upload.AllowUploadType;
import com.bz.framework.constant.upload.UploadBusinessType;
import com.bz.framework.util.base.CodeUtil;



/**
 * 上传文件类
 * @ClassName UploadFileBASE64
 * @Description TODO
 */
public class UploadFileBASE64 implements Serializable{
	private static final long serialVersionUID = -6587814329347631657L;
	private String file;	//图片base64字符串
	private String extName;	//后缀名（图片格式）
	private long fileSize;  //图片限制大小
	private UploadBusinessType uploadBusinessType;//上传业务类型
	/**
	 * 默认构造方法
	 * 默认只允许图片类型文件上传
	 * @param fileBase64 上传文件
	 * @param fileSize      允许上传文件大小，单位为字节
	 * @param allowUploadType {@link AllowUploadType}
	 * @see org.springframework.web.multipart.MultipartFile
	 */
	public UploadFileBASE64(String fileBase64,String extName,AllowUploadType allowUploadType){
		this.file=fileBase64;
		this.extName=extName;
		this.fileSize=allowUploadType.getSize();
		this.uploadBusinessType=allowUploadType.getUploadBusinessType();
	}
	/** 获取文件二进制内容
	 * @see org.springframework.web.multipart.MultipartFile#getBytes()
	 */
	public byte[] getBytes() throws IOException {		
		return CodeUtil.inputStreamToByte(getInputStream());
	}


	/** 获取输入流
	 * @see org.springframework.web.multipart.MultipartFile#getInputStream()
	 */
	public InputStream getInputStream() throws IOException {
		if(file!=null){
			return CodeUtil.getInputStreamFormBASE64Str(file.replace(" ", "+"));
		}
		return null;
	}

	/** 文件是否为空
	 * @see org.springframework.web.multipart.MultipartFile#isEmpty()
	 */
	public boolean isEmpty() {
		return file==null||file.isEmpty();
	}

	public String getFile() {
		return file;
	}
	public long getFileSize() {
		return fileSize;
	}
	
	public String getExtName() {
		return extName;
	}

	public UploadBusinessType getUploadBusinessType() {
		return uploadBusinessType;
	}
	@Override
	public String toString() {
		return "UploadFileBASE64 [file=" + file + ", extName=" + extName
				+ ", fileSize=" + fileSize + ", uploadBusinessType="
				+ uploadBusinessType + "]";
	}
	
}

