package com.bz.upload.core.service.impl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import com.bz.framework.constant.image.WatermarkPostion;
import com.bz.framework.constant.result.ResultValueEnum;
import com.bz.framework.constant.upload.UploadBusinessType;
import com.bz.framework.error.exception.FileException;
import com.bz.framework.pojo.base.BaseResult;
import com.bz.framework.util.exception.BzfAssert;
import com.bz.framework.util.upload.DloadImgUtil;
import com.bz.framework.util.upload.UpLoadUtil;
import com.bz.framework.util.validate.TwoItem;
import com.bz.framework.vo.upload.UploadFileBASE64;
import com.bz.open.core.service.upload.UploadOpenService;
import com.bz.open.core.service.weixin.WeixinToolsService;
import com.bz.open.core.vo.request.upload.UploadFileRequestVo;
import com.bz.open.core.vo.response.upload.UploadResponseVo;

import net.coobird.thumbnailator.Thumbnails;
/**
 * 
 *  作者:唐鹏
 *  描述:文件上传服务实现
 *  备注:
 *  创建时间:2017年11月20日下午1:55:23
 */
public abstract class BaseUploadOpenService implements UploadOpenService {
	private final Logger logger=LoggerFactory.getLogger(BaseUploadOpenService.class);
	@Value("${upload.save.folder}")
	protected String uploadSaveFolder;
	
	@Reference(version="1.0.0")//微信工具服务
	private WeixinToolsService weixinToolsService;
	
	public BaseUploadOpenService() {
		
	}
	@Override
	public UploadResponseVo uploadWxImage(UploadFileRequestVo fileVo,String imageId)throws FileException{
		logger.info("获取微信图片信息到本地:imageId:{}",imageId);
		/*参数验证判断*/
		BzfAssert.isNull(FileException.class, fileVo,"文件上传服务实现 文件信息封装参数【fileVo】为null");
		
		BzfAssert.isTrue(FileException.class, StringUtils.isEmpty(imageId),"获取微信图片信息到本地imageId为null");
	    String acctoken= weixinToolsService.getCurryAccToken(); 
	  //获取文件上传的路径
  		TwoItem<String, String> saveFolder=fileVo.getUploadBusinessType().getSaveFolder(uploadSaveFolder);
  		//获取随机文件名
  		String fileName=UpLoadUtil.createFileName(fileVo.getFileSuffixName());
  		logger.info("微信文件下载实现:文件存储路径为:"+saveFolder);
  		logger.info("微信文件下载实现:文件名称为:"+fileName);
		try {
			DloadImgUtil.downloadMedia(acctoken, imageId, (saveFolder.first+fileName),saveFolder.first);
		} catch (Exception e) {
			logger.error("下载微信图片失败");
			throw new FileException(e);
		}
	    try {
			return handleUpload(fileVo.getUploadBusinessType(),saveFolder.first+fileName,saveFolder.second+fileName,WatermarkPostion.NONE,fileVo.getAipNo());
		} catch (Exception e) {
			logger.error("文件入库异常");
			e.printStackTrace();
		}
	    return null;
	}
	
	
	
	@Override
	public BaseResult<UploadResponseVo> uploadByBASE64(WatermarkPostion watermarkPostion,String apiClientNo,UploadFileBASE64 upFileBASE64)throws FileException{
		logger.info("文件上传服务:上传BASE64格式数据watermarkPostion:{},apiClientNo:{},UploadFileBASE64:{}",watermarkPostion,apiClientNo,upFileBASE64);
		InputStream inputStream = null;
		BaseResult<UploadResponseVo> baseResult = BaseResult.newInstance();
		try {
			//log.debug(upFileBASE64);
			inputStream = upFileBASE64.getInputStream();
			//上传文件检查（base64）
			if(StringUtils.isEmpty(upFileBASE64.getFile())){
				return BaseResult.valueOf(ResultValueEnum.UPLOAD_NULL_ERROR);
			}
			//必填参数检查
			if(upFileBASE64.getUploadBusinessType()==null||upFileBASE64.getFileSize()==0){
				return BaseResult.valueOf(ResultValueEnum.UPLOAD_ALLOW_TYPE_ERROR);
			}
			//检查文件大小
			if(inputStream.available()>upFileBASE64.getFileSize()){
				return BaseResult.valueOf(ResultValueEnum.UPLOAD_SIZE_ERROR);
			}			
			String extName=upFileBASE64.getExtName();
			boolean flag = false;
			if(!StringUtils.isEmpty(extName)){
				for(String type : upFileBASE64.getUploadBusinessType().getAllowFileType()){
					if(extName.equals(type)){
						flag=true;
					}
				}
			}
			//检查文件类型
			if(!flag){
				return BaseResult.valueOf(ResultValueEnum.UPLOAD_FORMAT_ERROR);
			}
			
			TwoItem<String, String> saveFolder=upFileBASE64.getUploadBusinessType().getSaveFolder(uploadSaveFolder);
			if(StringUtils.isEmpty(extName)){
				extName = ".jpg";
			}
			String fileName=UpLoadUtil.createFileName(extName);
			logger.info("文件上传服务实现:文件存储路径为:"+saveFolder);
			logger.info("文件上传服务实现:文件名称为:"+fileName);
			FileUtils.copyInputStreamToFile(inputStream, new File(saveFolder.first+fileName));
			UploadResponseVo uploadVo = handleUpload(upFileBASE64.getUploadBusinessType(),saveFolder.first+fileName,saveFolder.second+fileName,watermarkPostion,apiClientNo);
			baseResult.setData(uploadVo);
			return baseResult;
		} catch (Exception e) {
			logger.error("uploadBASE64",e);
			closeInputStream(inputStream);
			throw new FileException(e);
		}finally{
			closeInputStream(inputStream);
		}
	}
	
	@Override
	public UploadResponseVo upload(WatermarkPostion watermarkPostion,UploadFileRequestVo fileVo,InputStream inputStream) throws FileException {
		logger.info("文件上传服务实现WatermarkPostion:{},UploadFileVo:{},InputStream：{}",watermarkPostion,fileVo,inputStream);
		try {
			//判断
			BzfAssert.isNull(FileException.class, watermarkPostion,"文件上传服务实现 文件水印枚举【watermarkPostion】为null");
			
			BzfAssert.isNull(FileException.class, fileVo,"文件上传服务实现 文件信息封装参数【fileVo】为null");
			
			BzfAssert.isTrue(FileException.class, StringUtils.isEmpty(fileVo.getFileSuffixName()),"文件上传服务实现 文件信息封装参数【fileVo】中对象【fileSuffixName】为空");
			
			BzfAssert.isTrue(FileException.class,fileVo.getUploadBusinessType()==null,"文件上传服务实现 文件信息封装参数【fileVo】中对象【UploadBusinessType】为空");
			
			BzfAssert.isTrue(FileException.class, StringUtils.isEmpty(fileVo.getAipNo()),"文件上传服务实现 文件信息封装参数【fileVo】中对象【apiNo】为空");
			
			BzfAssert.isNull(FileException.class, inputStream,"文件上传服务实现 文件流对象【inputStream】为null");
			//获取文件上传的路径
			TwoItem<String, String> saveFolder=fileVo.getUploadBusinessType().getSaveFolder(uploadSaveFolder);
			//获取随机文件名
			String fileName=UpLoadUtil.createFileName(fileVo.getFileSuffixName());
			logger.info("文件上传服务实现:文件存储路径为:"+saveFolder);
			logger.info("文件上传服务实现:文件名称为:"+fileName);
			//图片压缩
			Thumbnails.of(inputStream).scale(1f).outputQuality(0.25f).toFile(new File(saveFolder.first+fileName));
			//FileUtils.copyInputStreamToFile(inputStream, new File(saveFolder.first+fileName));
			return handleUpload(fileVo.getUploadBusinessType(),saveFolder.first+fileName,saveFolder.second+fileName,watermarkPostion,fileVo.getAipNo());
		} catch (Exception e) {
			logger.error("uploadBase64",e);
			closeInputStream(inputStream);
			throw new FileException(e);
		}finally{
			closeInputStream(inputStream);
		}
	}
	private void closeInputStream(InputStream inputStream){
		if(null!=inputStream){
			try {
				inputStream.close();
				inputStream=null;
			} catch (IOException e) {
			}
		}
	}
	/**
	 * 处理上传文件
	 * @param UploadBusinessType 上传文件业务类型
	 * @param realPath 上传文件保存的物理完整路径
	 * @param contextPath 上传文件保存的相对路径
	 * @param watermarkPostio 水印位置 {@link WatermarkPostion}
	 * @return 上传源文件保存后结果{@link UploadResponseVo}
	 * @throws Exception
	 */
	protected abstract UploadResponseVo handleUpload(UploadBusinessType uploadBusinessType,String realPath,String contextPath,WatermarkPostion watermarkPostion,String apiNo) throws Exception;
	
	
	
	/**
	 * 
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年11月14日上午10:00:49
	 * 描述:InputStream 转file
	 * 备注:
	 * @param ins
	 * @param file
	 */
	public void inputstreamtofile(InputStream ins,File file){  
		   try {
			   OutputStream os = new FileOutputStream(file);  
			   int bytesRead = 0;  
			   byte[] buffer = new byte[8192];  
			   while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {  
			      os.write(buffer, 0, bytesRead);  
			   }  
			   os.close();  
			   ins.close();  
		} catch (Exception e) {
			logger.error("InputStream 转 file 失败");
		} 
		 
		}  
}
