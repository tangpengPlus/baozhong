package com.bz.open.core.service.weixin;

import java.io.InputStream;

import com.bz.framework.error.exception.ExternalException;

import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;
/**
 * 
 * 作者:唐鹏
 * 创建时间:2017年10月16日上午11:15:54
 * 描述:微信端工具接口
 * 备注:微信支付、网页授权、获取微信用户基本信息、发送微信模板信息、发送图文信息、发送图片信息
 * 获取微信上传文件信息
 * 
 */
public interface WeixinToolsService {
	
	/**
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年10月16日上午10:43:28
	 * 描述:微信MP_OAuth2网页授权获取code
	 * 备注:
	 * @param notfUrl:回调地址
	 * @throws Exception
	 */
	public String mpOAuth2(String notfUrl)throws ExternalException;
	
	
	/**
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年10月16日上午10:45:31
	 * 描述:根据code获取授权凭借
	 * 备注:
	 * @param code:授权code
	 * @return
	 * @throws Exception
	 */
	public WxMpOAuth2AccessToken getWxMpOAuth2AccessToken(String code)throws ExternalException;
	
	/**
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年10月16日上午11:08:44
	 * 描述:获取微信用户的基本信息
	 * 备注:
	 * @param token:获取基本信息令牌
	 * @return
	 * @throws Exception
	 */
	public WxMpUser getWxMpUser(WxMpOAuth2AccessToken token)throws ExternalException;
	
	/**
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年10月16日上午11:14:19
	 * 描述:刷新微信token
	 * 备注:
	 * @param token:刷新后的令牌
	 * @throws Exception
	 */
	public WxMpOAuth2AccessToken  refreshAccessToken(WxMpOAuth2AccessToken  token)throws ExternalException;

    /**
     * 
     * 作者:唐鹏
     * 创建时间:2017年10月16日上午11:19:13
     * 描述:验证access token
     * 备注:
     * @param token
     * @return true:成功 false:失败
     * @throws ExternalException :第三方服务异常封装
     */
   public boolean validateAccessToken(WxMpOAuth2AccessToken  token)throws ExternalException;
   
   /**
    * 
    * 作者:唐鹏
    * 创建时间:2017年10月16日上午11:22:33
    * 描述:根据openId获取微信用户基本消息
    * 备注:
    * @param openId:用户微信服务器唯一Id
    * @param lang:语言默认zh_CN
    * @return
    * @throws ExternalException:第三方服务异常封装
    */
   public WxMpUser getWxMpUser(String openId,String lang)throws ExternalException;
   
   /**
    * 
    * 作者:唐鹏
    * 创建时间:2017年10月16日上午11:24:33
    * 描述:批量获取微信用户基本信息
    * 备注:
    * @param openIds:微信用户id集合
    * @return
    * @throws ExternalException:第三方服务异常封装
    */
   public WxMpUserList getWxMpUserList(String openIds)throws ExternalException;

   /**
   * @作者 胡竞
   * @Title: getWxMpJsapiTicket 
   * @Description: TODO(获取jsapiTicket对象) 
   * @param @param url 当前访问的url地址
   * @param @return
   * @param @throws ExternalException    自定义异常 
   * @return WxJsapiSignature    返回类型 
   * @throws
    */
   public WxJsapiSignature getWxMpJsapiTicket(String url) throws ExternalException;
   
   
   /**
    * 
    *  作者:唐鹏
    *  描述:微信文件下载
    *  备注:
    *  创建时间:2017年11月20日下午2:08:04
    *  @param 获取微信token
    *  @throws ExternalException 第三方服务异常封装
    */
   public String  getCurryAccToken()throws ExternalException;
}
