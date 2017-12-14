package com.bz.framework.util.upload;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bz.framework.util.base.CodeUtil;

/**
 * 
 *  作者:唐鹏
 *  描述:文件下载
 *  备注:
 *  创建时间:2017年11月21日下午5:44:10
 */
public class DloadImgUtil {
	  
	private  static final Logger logger=LoggerFactory.getLogger(DloadImgUtil.class);
	  /**
	   * 获取媒体文件
	   * @param accessToken 接口访问凭证
	   * @param mediaId 媒体文件id
	   * @param savePath 文件在本地服务器上的存储路径
	   * */
	  public static  void downloadMedia(String accessToken, String mediaId,String filePath,String fileDir) {
		  logger.info("下载文件accessToken:{},mediaId:{}",accessToken,mediaId);
	    // 拼接请求地址
	    String requestUrl = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
	    requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("MEDIA_ID", mediaId);
	    try {
	      URL url = new URL(requestUrl);
	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      conn.setDoInput(true);
	      conn.setRequestMethod("GET");
	      BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
	    //判断 当前文件夹是否存在
			File file=new File(fileDir);
			if(!file.exists()) {
				//创建文件夹
				file.mkdirs();
			}
	      FileOutputStream fos = new FileOutputStream(new File(filePath));
	      byte[] buf = new byte[8096];
	      int size = 0;
	      while ((size = bis.read(buf)) != -1)
	        fos.write(buf, 0, size);
	      fos.close();
	      bis.close();

	      conn.disconnect();
	    } catch (Exception e) {
	      String error = String.format("下载媒体文件失败：%s", e);
	      System.out.println(error);
	    }
	    
	  }
	  
	  public static InputStream doGet(String accessToken, String mediaId) throws Exception {
		  int timeout=5000; 
		  String requestUrl = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
		    requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("MEDIA_ID", mediaId);
		  InputStream result =null;
			HttpEntity entity = null;
			CloseableHttpClient httpclient = HttpClients.createDefault();
			CloseableHttpResponse response = null;
			try {
				URL url = new URL(requestUrl);

				URI uri = null;
				if (80 == url.getPort()) {
					uri = new URI(url.getProtocol(), url.getHost(), url.getPath(),
							url.getQuery(), null);
				} else {
					uri = new URI(url.getProtocol(), null, url.getHost(),
							url.getPort(), url.getPath(), url.getQuery(), null);
				}

				HttpGet httpget = new HttpGet(uri);

				if (timeout > 0) {
					httpget.setConfig(RequestConfig.custom()
							.setSocketTimeout(timeout).setConnectTimeout(timeout)
							.setConnectionRequestTimeout(timeout).build());
				}

				// 执行get请求
				response = httpclient.execute(httpget);
				// 获取相应实体
				entity = response.getEntity();
				int statuscode = response.getStatusLine().getStatusCode();
				logger.debug("访问：" + url + ",statuscode：" + statuscode);
				if (null != entity && statuscode == HttpStatus.SC_OK) {
					result= entity.getContent();
				} else {
					throw new Exception("access statuscode=" + statuscode);
				}
			} catch (Exception e) {
				throw e;
			} finally {
				if (null != entity) {
					EntityUtils.consume(entity);
				}
				if (null != response) {
					response.close();
				}
				if (null != httpclient) {
					httpclient.close();
				}
			}
			logger.debug("访问：" + requestUrl + ",返回：" + result);
			return result;
		}
}
