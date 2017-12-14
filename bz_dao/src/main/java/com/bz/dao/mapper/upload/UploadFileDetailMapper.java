package com.bz.dao.mapper.upload;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.bz.dao.mapper.base.BaseMapper;
import com.bz.dao.pojo.upload.UploadFileDetail;
import com.bz.dao.sql.upload.UploadFileSqlProvider;

public interface UploadFileDetailMapper extends BaseMapper<UploadFileDetail> {
    /**
     *  动态字段,写入数据库记录,system_upload_file_detail
     *
     * @param record
     */
    int insertSelective(UploadFileDetail record);

    
    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,system_upload_file_detail
     *
     * @param record
     */
    int updateByPrimaryKeySelective(UploadFileDetail record);
    
    /**
	 * 获取上传文件详情信息
	 * @param uploadFileId 上传文件Id
	 * @param fileFormat 规格   等于-1时不加入查询条件
	 * @return
	 */
    List<UploadFileDetail> queryFileDetail(@Param("uploadFileId")long uploadFileId,@Param("fileFormat")int fileFormat);

	/**
	 * 保存文件详情信息
	 * @param uploadFileId 上传文件Id
	 * @param fileDetails  详情信息
	 */
    @InsertProvider(type=UploadFileSqlProvider.class,method="saveFileDetailSql")
	public void saveFileDetail(@Param("fileDetails") List<UploadFileDetail> fileDetails) throws Exception;

    
    /**
	 * 逻辑删除文件信息 
	 * @param ids 上传文件Id字符串，多个Id用英文逗号隔开
	 * @return
	 */
	@DeleteProvider(type=UploadFileSqlProvider.class,method="delFileInfoByIdsSql")
	public int delFileInfoByIds(@Param("ids")String ids) throws Exception;


	/**
	 * 获取上传文件中大小（字节）
	 * @return
	 */
	@Options(useCache = true, timeout = 10000)
	@Select("SELECT sum(size) size FROM system_upload_file_detail")
	public long getTotalSize() throws Exception;
	/**
	 * 获取上传文件总数量 包括已经删除的文件
	 * @return
	 */
	@Options(useCache = true, timeout = 10000)
	@Select("SELECT count(*) size FROM system_upload_file_detail")
	public long getTotalQuantity() throws Exception;
	/**
	 * 获取已经删除的文件总数量
	 * @return
	 */
	@Options(useCache = true, timeout = 10000)
	@Select("SELECT count(*) size FROM system_upload_file_detail where isDelete=1")
	public long getTotalDeletedQuantity() throws Exception;

}