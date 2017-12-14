package com.bz.framework.vo.upload;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

import com.bz.framework.constant.upload.AllowUploadType;
import com.bz.framework.constant.upload.UploadBusinessType;
import com.bz.framework.util.upload.UpLoadUtil;


/**
 * 上传文件类
 */
public class UploadFile implements Serializable{
	private static final long serialVersionUID = -6587814329347631657L;
	private MultipartFile multipartFile;
	private long fileSize;
	private UploadBusinessType uploadBusinessType;
	/**
	 * 默认构造方法
	 * 默认只允许图片类型文件上传
	 * @param multipartFile 上传文件 {@link org.springframework.web.multipart.MultipartFile}
	 * @param fileSize      允许上传文件大小，单位为字节
	 * @param uploadFileType {@link UploadBusinessType}
	 * @param realPath 当前项目绝对路径
	 * @see org.springframework.web.multipart.MultipartFile
	 */
	public UploadFile(MultipartFile multipartFile,long fileSize,UploadBusinessType uploadFileType){
		this.multipartFile=multipartFile;
		this.fileSize=fileSize;
		this.uploadBusinessType=uploadFileType;
	}
	public UploadFile(MultipartFile multipartFile,AllowUploadType allowUploadType){
		this.multipartFile=multipartFile;
		this.fileSize=allowUploadType.getSize();
		this.uploadBusinessType=allowUploadType.getUploadBusinessType();
	}
	/** 获取文件二进制内容
	 * @see org.springframework.web.multipart.MultipartFile#getBytes()
	 */
	public byte[] getBytes() throws IOException {
		return multipartFile.getBytes();
	}

	/** 获取文件类型
	 * @see org.springframework.web.multipart.MultipartFile#getContentType()
	 */
	public String getContentType() {
		return multipartFile.getContentType();
	}
	/** 获取输入流
	 * @see org.springframework.web.multipart.MultipartFile#getInputStream()
	 */
	public InputStream getInputStream() throws IOException {
		return multipartFile.getInputStream();
	}

	/** 获取文件名
	 * @see org.springframework.web.multipart.MultipartFile#getName()
	 */
	public String getName() {
		return multipartFile.getName();
	}

	/** 获取原始文件名
	 * @see org.springframework.web.multipart.MultipartFile#getOriginalFilename()
	 */
	public String getOriginalFilename() {
		return multipartFile.getOriginalFilename();
	}

	/** 获取文件大小
	 * @see org.springframework.web.multipart.MultipartFile#getSize()
	 */
	public long getSize() {
		return multipartFile.getSize();
	}

	/** 文件是否为空
	 * @see org.springframework.web.multipart.MultipartFile#isEmpty()
	 */
	public boolean isEmpty() {
		return multipartFile.isEmpty();
	}

	/** 传输文件
	 * @see org.springframework.web.multipart.MultipartFile#transferTo(java.io.File)
	 */
	public void transferTo(File file) throws IOException, IllegalStateException {
		multipartFile.transferTo(file);
	}

	/** (non-Javadoc)
	 * @see wm.com.text.IUploadFile#checkFileSize()
	 */
	public boolean checkFileSize() {
		return fileSize>=getSize();
	}

	/** 检查文件类型
	 * @see wm.com.text.IUploadFile#checkFileType()
	 */
	public boolean checkFileType() {
		String extName=this.getExtName();
		for(String type : this.uploadBusinessType.getAllowFileType()){
			if(extName.equals(type)){
				return true;
			}
		}
		return false;
	}
	/**
	 * 获取文件后缀名 .xxx
	 * @return 文件后缀名
	 */
	public String getExtName() {
		return getOriginalFilename().substring(getOriginalFilename().lastIndexOf(".")).toLowerCase();
	}
	
	public String save(String saveFolder) throws Exception {
		String fileName=UpLoadUtil.createFileName(getExtName());
		transferTo(new File(saveFolder+File.separator+fileName));
		return fileName;
	}
	
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public long getFileSize() {
		return fileSize;
	}
	
	
	public UploadBusinessType getUploadBusinessType() {
		return uploadBusinessType;
	}
	/**
	 * toString
	 */
	@Override
	public String toString() {
		return "UploadFile [fileSize=" + fileSize + ", fileTypes="
				+ Arrays.toString(uploadBusinessType.getAllowFileType()) 
				+", getContentType()="
				+ getContentType() + ", getName()=" + getName()
				+ ", getOriginalFilename()=" + getOriginalFilename()
				+ ", getSize()=" + getSize() + ", isEmpty()=" + isEmpty()
				+ ", getExtName()=" + getExtName() + "]";
	}
	
}

