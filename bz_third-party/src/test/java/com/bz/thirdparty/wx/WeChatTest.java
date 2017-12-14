package com.bz.thirdparty.wx;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.bz.open.core.service.weixin.WeixinToolsService;
import com.bz.thirdparty.map.AdministrativeAreaTest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeChatTest {

	private final Logger logger=LoggerFactory.getLogger(AdministrativeAreaTest.class);

	@Autowired
	private WeixinToolsService weiXinToolsService;
	
	
	@Test
	public void mpOAuth2Test() {
		logger.info("-------------进入mpoAuth测试环节-------------");
		weiXinToolsService.mpOAuth2("http://att397200731.eicp.net/wechat/accredit/testauthcode");
	}
	/**

	* @作者 胡竞
	* https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxba198d911d6ea1aa&redirect_uri=http://att397200731.eicp.net/wechat/accredit/testauthcode&response_type=code&scope=snsapi_userinfo&state=#wechat_redirect
	* http://att397200731.eicp.net/wechat/accredit/testauthcode
	* @Title: accessTokenTest 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@Test
	public void accessTokenTest() {
		logger.info("-------进入accessToken测试----------");
		weiXinToolsService.getWxMpOAuth2AccessToken("");
	}
	
	
	
}
