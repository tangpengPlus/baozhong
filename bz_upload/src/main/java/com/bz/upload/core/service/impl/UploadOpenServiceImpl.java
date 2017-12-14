package com.bz.upload.core.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;
import com.alibaba.dubbo.config.annotation.Service;
import com.bz.dao.pojo.upload.UploadFileDetail;
import com.bz.dao.pojo.upload.UploadFileInfo;
import com.bz.framework.constant.image.WatermarkPostion;
import com.bz.framework.constant.upload.UploadBusinessType;
import com.bz.framework.constant.upload.UploadFileFormat;
import com.bz.framework.error.exception.FileException;
import com.bz.framework.vo.upload.UploadFileReader;
import com.bz.open.core.vo.response.upload.UploadResponseVo;

/**
 * 
 * 作者: 唐鹏
 * 描述: 上传文件开放接口实现类
 * 创建时间:2017年9月30日下午5:40:17
 * 修改备注:
 */
@Service(version="1.0.0",interfaceClass=com.bz.open.core.service.upload.UploadOpenService.class,protocol="hessian")
public class UploadOpenServiceImpl extends BaseUploadOpenService {
	private final Logger logger=LoggerFactory.getLogger(UploadOpenServiceImpl.class);
	
	@Value("${upload.view.server}")
	private String serverUrl;	
	@Value("${upload.watermark.folder}")
	private String watermarkImgFolder;
	@Value("${upload.watermark.data}")
	private String watermarkImgData;
	@Autowired
	private UploadFileManager uploadFileManager;
	
	private static String HTTP="http://";
	
	
	
	public UploadOpenServiceImpl() {
		
	}
	@Override
	protected UploadResponseVo handleUpload(UploadBusinessType uploadBusinessType,
			String realPath, String contextPath,WatermarkPostion watermarkPostion,String apiClientNo) throws Exception {
		UploadResponseVo uploadVo = processFile(uploadBusinessType, realPath, contextPath, watermarkPostion, apiClientNo);
		return uploadVo;
	}

	@Override
	public String getUrl(long id, UploadFileFormat uploadFileFormat) 
			throws FileException {
		try{
			Assert.isTrue(id>0, "参数id不能为"+id);
			UploadFileDetail data = uploadFileManager.queryFileDetail(id, uploadFileFormat.getKey());
			if(data!=null){
				String url = data.getServerurl()+data.getFileurl();
				return HTTP+url;
			}
			return null;
		}catch(Exception e){
			logger.error("getUrl err:",e);
			throw new FileException(e);
		}
		
	}

	@Override
	public List<UploadResponseVo> getUrls(
			UploadFileFormat uploadFileFormat, long... ids)
			throws FileException {
		List<UploadResponseVo> list = new ArrayList<UploadResponseVo>();
		UploadResponseVo uploadVo = null;
		for (long id : ids) {
			if(id>0){
				uploadVo = new UploadResponseVo();
				uploadVo.setId(id);
				uploadVo.setUrl(getUrl(id, uploadFileFormat));
				list.add(uploadVo);
			}
		}
		return list;
	}

	@Override
	public List<UploadResponseVo> getUrlByIds(
			UploadFileFormat uploadFileFormat, String ids)
			throws FileException {
		try{
			Assert.notNull(ids,"ids is empty!");
			List<UploadResponseVo> retturnlist = new ArrayList<UploadResponseVo>();
			UploadResponseVo uploadVo;
			for (String id : ids.split(",")) {
				if(!StringUtils.isEmpty(id)){
					long uploadId = Long.parseLong(id);				
					String url = getUrl(uploadId, uploadFileFormat);
					uploadVo = new UploadResponseVo();
					uploadVo.setId(uploadId);
					uploadVo.setUrl(url);
					retturnlist.add(uploadVo);
				}
				
			}
			logger.debug(retturnlist+"");
			return retturnlist;
		}catch(Exception e){
			logger.error("getUrlByIds err:",e);
			throw new FileException(e);
		}
		
	}
	
	
	/**
	 * 处理文件
	 * @param uploadBusinessType
	 * @param realPath
	 * @param contextPath
	 * @param watermarkPostio
	 * @param apiClientNo
	 * @return
	 * @throws Exception 
	 */
	private final UploadResponseVo processFile(UploadBusinessType uploadBusinessType,
			String realPath, String contextPath,WatermarkPostion watermarkPostio,String apiClientNo) throws Exception{
		try {
			File file = new File(realPath);
			String extName = file.getName().substring(file.getName().lastIndexOf(".")+1,file.getName().length());
		
			//保存原图信息到数据库
			UploadFileInfo uploadFileInfo = new UploadFileInfo();
			uploadFileInfo.setApiClientNo(apiClientNo);
			uploadFileInfo.setUploadTypeId(Integer.valueOf(uploadBusinessType.getKey()+""));
			uploadFileInfo.setExtName(extName);
			uploadFileInfo.setSize(file.length());
			uploadFileInfo.setServerUrl(serverUrl);
			uploadFileInfo.setBaseFileUrl(contextPath);	
			logger.debug("UploadFileInfo:{}",uploadFileInfo);
			uploadFileManager.saveFileInfo(uploadFileInfo);
			long uploadFileId = uploadFileInfo.getUploadFileId();
			UploadResponseVo uploadVo = null;;
			if(uploadFileId>0){
				//根据上传文件业务类型处理并保存图片详细信息
				uploadVo = saveFileDetail(file, contextPath, uploadFileId, uploadBusinessType, watermarkPostio, apiClientNo);
			}
			logger.debug("UploadVo:{}",uploadVo);
			return uploadVo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("saveFileInfo", e);
			throw new Exception(e);
		}		
		
	}
	
	/**
	 *  保存图片详情
	 * @param file
	 * @param uploadType
	 * @param uploadFileId
	 * @param apiClientNo
	 * @param isWatermark
	 * @param watermarkPosition 
	 * @return
	 */
	private UploadResponseVo saveFileDetail(File file,String contextPath,long uploadFileId,UploadBusinessType uploadBusinessType,WatermarkPostion watermarkPostio,String apiClientNo){
		try{
			List<UploadFileDetail> fileDetails = new ArrayList<UploadFileDetail>();
			UploadFileDetail detail = null;
			String extName = file.getName().substring(file.getName().lastIndexOf(".")+1,file.getName().length());
			UploadResponseVo uploadVo = new UploadResponseVo();
			uploadVo.setId(uploadFileId);
			uploadVo.setUrl(HTTP+serverUrl+contextPath);
			//处理文件类型
			if(uploadBusinessType==UploadBusinessType.DOCUMENT){
				/**
				 * 所有文件类型，如：txt、doc、jpg
				 * 都默认按原始信息生成详细信息 与UploadFileFormat的配置数据格式无关
				 */
				detail = new UploadFileDetail();
				detail.setServerurl(serverUrl);
				detail.setExtname(extName);
				detail.setFileurl(contextPath);
				//detail.setUploadfileid(uploadFileId);
				detail.setUploadfileid(uploadFileId);
				detail.setSize(file.length());			
				fileDetails.add(detail);
				uploadVo.setUrl(HTTP+serverUrl+contextPath);
				logger.debug("UploadFileDetail：{}",detail);
				//保存处理详情到数据库
				uploadFileManager.saveFileDetail(fileDetails);
				return uploadVo;
			}else{
				//处理图片类型
				UploadFileFormat[] fileFormats = uploadBusinessType.getFileFormat();
				long fileSize = 0;
				for (UploadFileFormat uploadFileFormat : fileFormats) {						
					String[] tempName = contextPath.split("\\.");
					String tempPath = tempName[0]+"_"+uploadFileFormat.getKey()+"."+tempName[1];
					//查找返回最小的图片
					File f = new File(uploadSaveFolder+tempPath);
					long tempsize = f.length();
					if(fileSize==0){
						fileSize = tempsize;
						uploadVo.setUrl(HTTP+serverUrl+tempPath);
					}else if(tempsize<fileSize){
						fileSize = tempsize;
						uploadVo.setUrl(HTTP+serverUrl+tempPath);
					}					
					//生成文件处理详情信息
					detail = new UploadFileDetail();
					detail.setServerurl(serverUrl);;
					detail.setExtname(extName);
					detail.setFileurl(tempPath);
					//detail.setUploadfileid(uploadFileId);
					detail.setUploadfileid(uploadFileId);
					detail.setSize(fileSize);
					detail.setFileformat(Integer.valueOf(uploadFileFormat.getKey()+""));
					fileDetails.add(detail);					
				}
				//log.debug(fileDetails);
				//保存处理详情到数据库
				uploadFileManager.saveFileDetail(fileDetails);
				return uploadVo;
			}
			
		} catch(Exception e){
			logger.error("saveFileDetail", e);
			throw new FileException(e);
		}
	}

	public <T> void loadUrl(UploadFileReader<T> uploadFileReader,UploadFileFormat uploadFileFormat) throws FileException {
		for(T data:uploadFileReader.getDataList()){
			Long uploadId=uploadFileReader.getUploadFileId(data);
			if(null!=uploadId && uploadId>0){
				uploadFileReader.setReadUrl(data,getUrl(uploadFileReader.getUploadFileId(data), uploadFileFormat));
			}
		}
	}
	@Override
	public Map<Long, String> getUrlsMap(UploadFileFormat uploadFileFormat,
			long... ids) throws FileException  {
		Map<Long, String> map = new HashMap<Long, String>();
		for (long id : ids) {
			if(id>0){
				map.put(id, getUrl(id, uploadFileFormat));
			}
		}
		return map;
	}
	@Override
	public Map<Long, String> getUrlsMapIds(UploadFileFormat uploadFileFormat,
			String ids) throws FileException {
		Assert.notNull(ids,"ids is empty!");
		Map<Long, String> map = new HashMap<Long, String>();
		for (String id : ids.split(",")) {
			if(!StringUtils.isEmpty(id)){
				long uploadId = Long.parseLong(id);				
				String url = getUrl(uploadId, uploadFileFormat);
				map.put(uploadId, url);
			}
		}
		return map;
	}
}
