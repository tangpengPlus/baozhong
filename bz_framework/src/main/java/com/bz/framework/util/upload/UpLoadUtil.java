package com.bz.framework.util.upload;

import java.util.UUID;

import com.bz.framework.constant.result.ResultValueEnum;
import com.bz.framework.pojo.base.BaseResult;
import com.bz.framework.vo.upload.UploadFile;



/**
 * 上传文件管理
 * @author 罗家友
 *
 */
public class UpLoadUtil {
	
	/**
	 * 检查上传文件
	 *@param upFile 上传文件
	 *@return  判断返回结果{@link BaseResult<?>}
	 */
	public static BaseResult<Object> checkUploadFile(UploadFile upFile){
		if(upFile.isEmpty()){
			return BaseResult.valueOf(ResultValueEnum.UPLOAD_NULL_ERROR);
		}
		if(!upFile.checkFileType()){ 
			return BaseResult.valueOf(ResultValueEnum.UPLOAD_FORMAT_ERROR);
		}
		if(!upFile.checkFileSize()){
			return BaseResult.valueOf(ResultValueEnum.UPLOAD_SIZE_ERROR);
		}
		return BaseResult.valueOf(ResultValueEnum.SYS_OK);
	}
	/**
	 * 创建文件名
	 * uuid文件名
	 * @param extName 扩展名 .xxxx
	 * @return 文件名xxxx.xxx
	 */
	public static String createFileName(String extName){
		return UUID.randomUUID().toString().replace("-", "")+extName;
	}
}
