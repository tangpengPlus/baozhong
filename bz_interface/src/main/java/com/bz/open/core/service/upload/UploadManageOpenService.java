package com.bz.open.core.service.upload;

import java.util.List;

import com.bz.dao.pojo.upload.UploadFileDetail;
import com.bz.framework.error.exception.FileException;
import com.bz.framework.pojo.page.PageBean;

/** 
 * <p>文件管理接口</p> 
 * 
 * CURD文件信息。 
 * 
 * @author 唐鹏
 * @version 1.0.0 Date: 2016年11月15日 下午2:20:51
 */ 
public interface UploadManageOpenService {
	/**
	 * 删除单个上传文件
	 * @param id 文件Id
	 * @return 实际删除数量
	 * @throws FileException
	 */
	public int delete(long id)throws FileException;
	/**
	 * 删除多个上传文件
	 * @param ids 多个文件Id
	 * @return 实际删除数量
	 * @throws FileException
	 */
	public int delete(long ...ids)throws FileException;
	/**
	 * 删除多个上传文件
	 * @param ids 多个文件Id用英文逗号隔开
	 * @return 实际删除数量
	 * @throws FileException
	 */
	public int delete(String ids)throws FileException;
	/**
	 * 获取上传文件总质量大小
	 * 单位字节
	 * @return 总质量大小，单位字节
	 * @throws FileException
	 */
	public long getTotalSize()throws FileException;
	/**
	 * 获取上传文件总数量
	 * 包括已经删除的文件
	 * @return 总数量
	 * @throws FileException
	 */
	public long getTotalQuantity ()throws FileException;
	/**
	 * 获取已经删除的文件总数量
	 * @return 已经删除的文件总数量
	 * @throws FileException
	 */
	public long getTotalDeletedQuantity()throws FileException;
	
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月17日下午5:30:47
	 * 描述:分页查询文件信息
	 * @param pb: 分页信息封装{@link PageBean}
	 * @return
	 * @throws FileException 文件异常封装{@link FileException}
	 */
	public List<UploadFileDetail> selectFileList(PageBean pb)throws FileException;
}
