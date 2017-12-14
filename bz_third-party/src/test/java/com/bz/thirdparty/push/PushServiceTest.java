package com.bz.thirdparty.push;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.bz.open.core.service.push.PushService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PushServiceTest {

	@Autowired
	private PushService pushService;
	
	/**
	* @作者 胡竞
	* @Title: testSendPushMessageToUser 
	* @Description: TODO(发送给单个用户测试) 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@Test
	public void testSendPushMessageToUser() {
		pushService.sendPushTextMessage(6, "测试发送推送标题", "测试发送推送内容");
	}
	
	/**
	* @作者 胡竞
	* @Title: testSendUrlMessageToUser 
	* @Description: TODO(发送url推送给单个用户测试) 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	//@Test
	public void testSendUrlMessageToUser() {
		pushService.sendPushUrlMessage(1, "测试发送URL推送", "百度", "http://www.baidu.com");
	}
	
	/**
	* @作者 胡竞
	* @Title: testSendRegionTextMessageToUser 
	* @Description: TODO(发送地区文本消息测试) 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	//@Test
	public void testSendRegionTextMessageToUser() {
		pushService.sendPushRegionTextMessage(31588, "测试按地区发送推送文本消息", "测试地区文本消息发送推送消息");
	}
	//@Test
	public void testSendAllUser() {
		pushService.sendPushAllUser("发送给全部用户", "pushAllUser", "http://www.baidu.com");
	}
		
}
