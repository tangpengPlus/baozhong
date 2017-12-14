package com.bz.framework.vo.upload;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName UploadFileReader
 * @author 唐鹏
 * @description 上传文件读取器
 * @dete 2016年10月31日 下午5:13:32
 *
 */
public abstract class UploadFileReader<T> implements Serializable{

	private static final long serialVersionUID = 6333433322363478064L;
	private List<T> dataList;
	public UploadFileReader(List<T> dataList) {
		this.dataList=dataList;
	}
	/**
	 * 获取数据列表
	 * @return {@link List<T>}
	 */
	public List<T> getDataList(){
		return dataList;
	}
	/**
	 * 获取上传文件Id
	 * @param data {@link T}
	 * @return 上传文件Id
	 */
	public abstract Long getUploadFileId(T data);
	/**
	 * 设置访问URL
	 * @param data {@link T}
	 * @param url 图片访问地址
	 */
	public abstract void setReadUrl(T data,String url);

}
