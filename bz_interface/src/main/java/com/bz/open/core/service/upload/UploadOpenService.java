package com.bz.open.core.service.upload;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.bz.framework.constant.image.WatermarkPostion;
import com.bz.framework.constant.upload.UploadFileFormat;
import com.bz.framework.error.exception.FileException;
import com.bz.framework.pojo.base.BaseResult;
import com.bz.framework.vo.upload.UploadFileBASE64;
import com.bz.open.core.vo.request.upload.UploadFileRequestVo;
import com.bz.open.core.vo.response.upload.UploadResponseVo;

/***
 * 文件上传业务接口
 *
 */
public interface UploadOpenService {
	
	/**
	 * 上传文件 base64
	 * @Title:uploadByBASE64
	 * @Description: TODO
	 * @param watermarkPostion 水印位置{@link WatermarkPostion}
	 * @param apiClientNo API客户端编号
	 * @param upFile  BASE64上传文件类{@link UploadFileBASE64}
	 * @return 上传文件结果{@link BaseResult<UploadResponseVo>}
	 * @throws UploadFileError 
	 */
	public BaseResult<UploadResponseVo> uploadByBASE64(WatermarkPostion watermarkPostion,String apiClientNo,UploadFileBASE64 upFile)throws FileException;
	/**
	 * 上传文件
	 * @param watermarkPostion 水印位置{@link WatermarkPostion}
	 * @param apiClientNo API客户端编号
	 * @param upFile  {@link UploadFileRequestVo}
	 * @param inputStream 文件输入流
	 * @return 上传文件结果{@link UploadResponseVo},id,url
	 * @throws UploadFileError
	 */
	public UploadResponseVo upload(WatermarkPostion watermarkPostion,UploadFileRequestVo fileVo,InputStream inputStream)throws FileException;
	
	
	
	/**
	 * 
	 *  作者:唐鹏
	 *  描述:上传微信图片信息
	 *  备注:
	 *  创建时间:2017年11月20日下午1:48:45
	 *  @param imageId:微信图片Id
	 *  @return 上传文件结果{@link UploadResponseVo},id,url
	 *  @throws FileException:文件服务异常
	 */
	public UploadResponseVo uploadWxImage(UploadFileRequestVo fileVo,String imageId)throws FileException;
	/**
	 * 获取上传文件URL地址
	 * @param id 上传文件Id
	 * @param uploadFileFormat 规格{@link UploadFileFormat}
	 * @return URL地址
	 * @throws UploadFileError
	 */
	public String getUrl(long id,UploadFileFormat uploadFileFormat)throws FileException;
	/**
	 * 获取上传文件URL地址
	 * @param uploadFileFormat 规格{@link UploadFileFormat}
	 * @param ids 多个上传文件Id
	 * @return {@link List<UploadResponseVo>},UploadResponseVo<id,url>
	 * @throws UploadFileError
	 */
	public List<UploadResponseVo> getUrls(UploadFileFormat uploadFileFormat,long ...ids)throws FileException;
	/**
	 * 获取上传文件URL地址
	 * @param uploadFileFormat 规格{@link UploadFileFormat}
	 * @param ids 上传文件Id字符串，多个Id用英文逗号隔开
	 * @return {@link List<UploadResponseVo>},UploadResponseVo<id,url>
	 * @throws UploadFileError
	 */
	public List<UploadResponseVo> getUrlByIds(UploadFileFormat uploadFileFormat,String ids)throws FileException;
	/**
	 * 获取上传文件URL地址
	 * @param uploadFileFormat 规格{@link UploadFileFormat}
	 * @param ids 多个上传文件Id
	 * @return  Map<上传文件Id,URL>
	 */
	public Map<Long,String> getUrlsMap(UploadFileFormat uploadFileFormat,long ...ids)throws Exception;
	/**
	 * 获取上传文件URL地址
	 * @param uploadFileFormat
	 * @param ids   上传文件Id字符串，多个Id用英文逗号隔开
	 * @return Map<上传文件Id,URL>
	 */
	public Map<Long,String> getUrlsMapIds(UploadFileFormat uploadFileFormat,String ids)throws Exception;
}

