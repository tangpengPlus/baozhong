package com.bz.thirdparty.wechat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.bz.open.core.service.weixin.WeixinMessageService;
import com.bz.open.core.vo.request.weixin.WeixinMassMessageRequest;
import me.chanjar.weixin.mp.bean.WxMpMassNews;
import me.chanjar.weixin.mp.bean.WxMpMassNews.WxMpMassNewsArticle;
/**
 * 
 * 
 * 作者: 彭云山
 * 描述:调用微信接口测试类
 * 创建时间:2017年10月25日下午6:10:12
 * 修改备注:
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest
public class WechatTest {

	private final Logger logger=LoggerFactory.getLogger(WechatTest.class);
	 @Autowired
	 private WeixinMessageService wxMpService;
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年10月27日上午9:41:53
	 * 描述:测试公众号文字消息
	 */
//	 @Test
	 public void testwechat() {
		 logger.info("开始测试");
		 WeixinMassMessageRequest message = new WeixinMassMessageRequest();
//		 List<String> list=new ArrayList<>();
//		 list.add("oRkX0t6r5RA9TJsRJvIF9Rie5CU0");
//		 list.add("");
//		 list.add("oRkX0t0sbR1tTU_KWFwqJlhPk-9k");
//		 list.add("oRkX0t-J6Cc6Ej3Apthj1dh_8hcA");
//		 list.add("oRkX0t5u2lEx5RPH-qFZyWR55ISc");
//		 message.setWeixinUserOpenIds(list);
//		 list.add("oRkX0t0sbR1tTU_KWFwqJlhPk-9k");
		 message.setWeixinUserOpenId("oeE270r_qvSOKULmBHs1l4LqChT0");
//		 message.setSendToOne(true);
		 message.setSendToOne(true);
		 message.setCount("这是一个测试消息324234");
		 wxMpService.sendTextMessage(message);
	 }
	 /**
	  * 
	  * 作者:彭云山
	  * 创建时间:2017年10月27日下午6:48:31
	  * 描述:测试公众号发送视屏消息
	  */
//	 @Test
	 public void sendVideoMessage() {
		 logger.info("开始测试发送视屏消息");
		 WeixinMassMessageRequest message = new WeixinMassMessageRequest();
//		 List<String> list=new ArrayList<>();
//		 list.add("oRkX0t6r5RA9TJsRJvIF9Rie5CU0");
//		 list.add("oRkX0t0sbR1tTU_KWFwqJlhPk-9k");
		// message.setWeixinUserOpenId("oRkX0t0sbR1tTU_KWFwqJlhPk-9k");
//		 list.add("oRkX0t-J6Cc6Ej3Apthj1dh_8hcA");
//		 list.add("oRkX0t5u2lEx5RPH-qFZyWR55ISc");
		 message.setWeixinUserOpenId("oeE270r_qvSOKULmBHs1l4LqChT0");
//		 message.setWeixinUserOpenIds(list);
		 message.setSendToOne(true);
		 InputStream in = null;
		 File file = new File("D:\\pic\\11.mp4");
		 try {
			in= new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 message.setFileType("mp4");
		 message.setCount("这是一个测试消息");
		 message.setTilte("这是一个测试的title");
		 boolean b = wxMpService.sendVideoMessage(message,in);
		 logger.info("测试结果"+b);
	 }
	 /**
	  * 
	  * 作者:彭云山
	  * 创建时间:2017年10月27日下午6:23:58
	  * 描述:发送图片消息
	  */
	 @Test
	 public void sendImageMessage() {
		 logger.info("开始测试发送图片消息");
		 WeixinMassMessageRequest message = new WeixinMassMessageRequest();
//		 List<String> list=new ArrayList<>();
//		 glllos2DU9s5DJ4TEl6kRXYVzdL2qc4R0noMtIPXAmtz5k0h9o6jMahsnWOH7OAQ
//		 list.add("oeE270r_qvSOKULmBHs1l4LqChT0");
//		 list.add("oeE270okkohvcGSJqUJurjeiux-Y");
//		 message.setWeixinUserOpenIds(list);
		 message.setWeixinUserOpenId("oeE270okkohvcGSJqUJurjeiux-Y");
		 message.setSendToOne(true);
		 File file = new File("D:\\pic\\a1.jpg");
		InputStream inputStream=null;
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		 String filename = file.getName();
		 String prefix=filename.substring(filename.lastIndexOf(".")+1);      
		 message.setFileType(prefix);
		 message.setCount("这是一个测试消息");
		 message.setTilte("这是一个测试图片的title");
		 logger.info("发送消息"+message);
		boolean b = wxMpService.sendImageMessage(message,inputStream);
		logger.info("发送"+b);
	 }
	 /**
	  * 
	  * 作者:彭云山
	  * 创建时间:2017年10月27日下午6:58:30
	  * 描述:测试音频消息
	  */
//	 @Test
	 public void sendVoiceMessage() {
		 logger.info("开始测试发送音频消息");
		 WeixinMassMessageRequest message = new WeixinMassMessageRequest();
		 List<String> list=new ArrayList<>();
		 list.add("oRkX0t6r5RA9TJsRJvIF9Rie5CU0");
		 list.add("oRkX0t0sbR1tTU_KWFwqJlhPk-9k");
		 message.setWeixinUserOpenIds(list);
		 message.setSendToOne(false);
		 File file = new File("D:\\CloudMusic\\12.mp3");
		 message.setFileType("mp3");
		 InputStream inputStream=null;
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		 message.setCount("这是一个测试音乐消息");
		 message.setTilte("这是一个测试音乐的title");
		 wxMpService.sendVoiceMessage(message,inputStream);
	 }
	 
	 /**
	  * 
	  * 作者: 兰俊
	  * 描述: 测试发送微信图文消息
	  * 创建时间:2017年11月20日下午3:51:33
	  */
//	 @Test
	 public void sendImageTextMessageTest() {
		 WeixinMassMessageRequest message = new WeixinMassMessageRequest();
		 message.setWeixinUserOpenId("oeE270liPdEX6XHltvDeZAQLQvEI");
		 message.setSendToOne(true);
		 File file = new File("D:\\pic\\a1.jpg");
		 InputStream inputStream=null;
	     try {
			inputStream = new FileInputStream(file);
		 } catch (FileNotFoundException e) {
				
			e.printStackTrace();
		 }
	     String filename = file.getName();
		 String prefix=filename.substring(filename.lastIndexOf(".")+1);      
		 message.setFileType(prefix);
		 message.setCount("这是一个测试消息");
		 message.setTilte("这是一个测试图片的title");
		 boolean b = wxMpService.sendImageTextMessage(message,inputStream);
		 logger.info("发送"+b);
	 }
}
