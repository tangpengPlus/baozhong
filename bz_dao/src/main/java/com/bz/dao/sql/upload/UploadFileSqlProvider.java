package com.bz.dao.sql.upload;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bz.dao.pojo.upload.UploadFileDetail;

/**
 * 文件上传SQL
 * 作者: 唐鹏
 * 描述:
 * 创建时间:2017年9月30日下午5:17:07
 * 修改备注:
 */

public class UploadFileSqlProvider {
	static Log log=LogFactory.getLog(UploadFileSqlProvider.class);
	/**
	 * 保存文件信息动态SQL
	 * @param parameters
	 * @return
	 */
	public String saveFileInfoSql(Map<String, Object> parameters){
//		EcUploadFileInfo fileinfo = (EcUploadFileInfo) parameters.get("fileInfo");
		String resultSql = StringUtils.EMPTY;
		StringBuffer sbSql = new StringBuffer("INSERT INTO system_upload_file_info(createTime");
		StringBuffer values = new StringBuffer(" VALUES(now()");
		sbSql.append(",uploadTypeId");
		values.append(",#{fileInfo.uploadTypeId}");
		
		sbSql.append(",serverUrl");
		values.append(",#{fileInfo.serverUrl}");
		
		sbSql.append(",baseFileUrl");
		values.append(",#{fileInfo.baseFileUrl}");
		
		sbSql.append(",size");
		values.append(",#{fileInfo.size}");
		
		sbSql.append(",extName");
		values.append(",#{fileInfo.extName}");
		
		sbSql.append(",apiClientNo");
		values.append(",#{fileInfo.apiClientNo}");
		sbSql.append(")");
		values.append(")");
		
		resultSql = sbSql.toString()+values.toString();
	
		log.info(resultSql);
		
		sbSql.setLength(0);
		values.setLength(0);
		sbSql = null;
		values = null;
		
		return resultSql;
	}
	/**
	 * 保存文件详细信息动态SQL
	 * @param parameters
	 * @return
	 */
	public String saveFileDetailSql(Map<String, Object> parameters){
		@SuppressWarnings("unchecked")
		List<UploadFileDetail> fileDetails = (List<UploadFileDetail>)parameters.get("fileDetails");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO system_upload_file_detail");
        sb.append("(createTime,uploadFileId,fileFormat,serverUrl,size,fileUrl,extName) ");
        sb.append("VALUES ");
        MessageFormat mf = new MessageFormat("(now(), #'{'fileDetails[{0}].uploadFileId}, #'{'fileDetails[{0}].fileFormat}, #'{'fileDetails[{0}].serverUrl}, #'{'fileDetails[{0}].size}, #'{'fileDetails[{0}].fileUrl}, #'{'fileDetails[{0}].extName})");
        for (int i = 0; i < fileDetails.size(); i++) {
            sb.append(mf.format(new Object[]{i}));
            if (i < fileDetails.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
	}
	/**
	 * 获取上传文件详情信息
	 * @param parameters
	 * @return
	 */
	public String queryFileDetailsByIds(Map<String, Object> parameters){
		int fileFormat = (Integer)parameters.get("fileFormat");
		String ids = parameters.get("ids")+"";
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM system_upload_file_detail WHERE isDelete=0 AND uploadFileId in(");
		sb.append(ids);
		sb.append(")");
		if(fileFormat>-1){
			sb.append(" and fileFormat=#{fileFormat}");
		}
		return sb.toString();
	}
	/**
	 * 获取上传文件详情信息
	 * @param parameters
	 * @return
	 */
	public String queryFileDetailSql(Map<String, Object> parameters){
		int fileFormat = (Integer)parameters.get("fileFormat");
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM system_upload_file_detail WHERE isDelete=0 AND uploadFileId = #{uploadFileId} ");
		if(fileFormat>-1){
			sb.append(" and fileFormat=#{fileFormat}");
		}
		return sb.toString();
	}
	/**
	 * 删除
	 * @Title:delFileInfoByIdsSql
	 * @Description: TODO
	 * @param parameters
	 * @return String 返回类型 {@link String} 
	 */
	public String delFileInfoByIdsSql(Map<String, Object> parameters){
		String ids = parameters.get("ids")+"";
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE system_upload_file_info a left join ec_upload_file_detail b ON a.uploadFileId=b.uploadFileId SET a.isDelete=1,b.isDelete=1 WHERE a.uploadFileId in("+ids+")");
		return sb.toString();
	}
}
