package com.bz.thirdparty.core.service.push;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.bz.framework.constant.exception.BzExceptionEnum.ExternalExceptionEnum;
import com.bz.framework.error.exception.ExternalException;
import com.bz.framework.util.base.ListUtil;
import com.bz.open.core.service.message.UserMessageService;
import com.bz.open.core.service.push.PushService;
import com.bz.open.core.service.user.UserBaseService;
import com.bz.open.core.vo.response.user.UserBaseResponseVo;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosAlert;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

@Service(version = "1.0.0", interfaceClass = com.bz.open.core.service.push.PushService.class)
public class PushServiceImpl implements PushService {

	private final Logger logger = LoggerFactory.getLogger(PushServiceImpl.class);

	@Value("${push.appKey}")
	private String appKey;
	@Value("${push.masterSecret}")
	private String masterSecret;

	@Reference(version = "1.0.0")
	private UserMessageService userMessageService;

	@Reference(version = "1.0.0")
	private UserBaseService userBaseService;

	/**
	 * @作者 胡竞 @Title: sendPush @Description: TODO(推送数据封装) @param @param
	 *     payload @param @return 设定文件 @return PushResult 返回类型 @throws
	 */
	public PushResult sendPush(PushPayload payload) throws ExternalException {
		// 获取配置
		ClientConfig clientConfig = ClientConfig.getInstance();
		// 初始化jpushClient
		JPushClient jpushClient = new JPushClient(masterSecret, appKey, null, clientConfig);
		try {
			PushResult result = jpushClient.sendPush(payload);
			logger.info("发送推送消息给客户端-->返回结果 - " + result);
			return result;
		} catch (APIConnectionException e) {
			logger.error("发送推送消息给客户端-->请求超时", e);
			throw new ExternalException(ExternalExceptionEnum.EXTERNAL_CREATE_ERROR, e.getMessage());
		} catch (APIRequestException e) {
			logger.error("发送推送消息给客户端:第三方服务器返回一个错误的消息 ", e);
			logger.info("发送推送消息给客户端:HTTP Status: " + e.getStatus());
			logger.info("发送推送消息给客户端:Error Code: " + e.getErrorCode());
			logger.info("发送推送消息给客户端:Error Message: " + e.getErrorMessage());
			logger.info("发送推送消息给客户端:Msg ID: " + e.getMsgId());
			throw new ExternalException(ExternalExceptionEnum.EXTERNAL_CREATE_ERROR, e.getMessage());
		}
	}

	public boolean sendPush(String pushids, String title, String count, String url) throws ExternalException {
		logger.info(
				"发送极光推送消息驱动【pushids:" + pushids + "】,【title:" + title + "】,【count:" + count + "】,【url:" + url + "】");
		Audience audience = null;
		// 判断发送群体
		if (pushids.equals("-1")) {
			audience = Audience.all();
		} else {
			audience = Audience.registrationId(pushids);
		}
		// 判断标签形式
		Map<String, String> jumpTypeMap = new HashMap<>();
		if (StringUtils.isEmpty(url)) {
			jumpTypeMap.put("jumpType", "comm");
		} else {
			jumpTypeMap.put("jumpType", "jumpUrl");
		}
		if (audience == null) {
			logger.error("组装消息推送目标失败");
			throw new ExternalException(ExternalExceptionEnum.EXTERNAL_CREATE_ERROR, "组装消息推送目标失败");
		}
		IosAlert iosAlert = IosAlert.newBuilder().setTitleAndBody(title, null, count).build();
		PushPayload payload = PushPayload.newBuilder().setPlatform(Platform.all())// 指定要推送的平台，all代表当前应用配置了的所有平台，也可以传android等具体平台
				.setAudience(audience)// 指定推送的接收对象，all代表所有人，也可以指定已经设置成功的tag或alias或该应应用客户端调用接口获取到的registration id
				.setNotification(Notification.newBuilder()// jpush的通知，android的由jpush直接下发，iOS的由apns服务器下发，Winphone的由mpns下发
						.addPlatformNotification(AndroidNotification.newBuilder()// 指定当前推送的android通知
								.setAlert(title).setTitle(count)
								// .setBuilderId(1)//设置Android 通知样式，需要客户端先定义、设置了该样式才有效
								// .addExtra("extras key", "extras
								// value")//此字段为透传字段，不会显示在通知栏。用户可以通过此字段来做一些定制需求，如特定的key传要指定跳转的页面（value）
								.addExtras(jumpTypeMap).build())
						.addPlatformNotification(IosNotification.newBuilder()// 指定当前推送的iOS通知
								.setAlert(iosAlert)// 传一个IosAlert对象，指定apns title、title、subtitle等
								.incrBadge(1)// 此项是指定此推送的badge自动加1
								// .setSound("sound.caf")//此字段的值default表示系统默认声音；传sound.caf表示此推送以项目里面打包的sound.caf声音来提醒，如果系统没有此音频则以系统默认声音提醒；此字段如果传空字符串，iOS9及以上的系统是无声音提醒，以下的系统是默认声音
								// .addExtra("iOS 的extras1",
								// "JPush111")//此字段为透传字段，不会显示在通知栏。用户可以通过此字段来做一些定制需求，如特定的key传要指定跳转的页面（value）
								.addExtras(jumpTypeMap).setContentAvailable(true)// 此项说明此推送是一个background推送，想了解background看：http://docs.jpush.io/client/ios_tutorials/#ios-7-background-remote-notification
								.build())
						// .addPlatformNotification(WinphoneNotification.newBuilder()
						// .setAlert(pushRequestVo.getCount())
						// .setOpenPage(pushRequestVo.getWindowsphone_visit_url())//指定点击打开的页面（类）,具体后缀忘记，错了请指正
						// .addExtra("WinPhone extras key", "WinPhone extras value")
						// .addExtras(pushRequestVo.getTransparent_data())
						// .build())
						.build())
				// .setMessage(Message.newBuilder()//Platform指定了哪些平台就会像指定平台中符合推送条件的设备进行推送。
				// jpush的自定义消息，sdk默认不做任何处理，不会有通知提示。建议看文档http://docs.jpush.io/guideline/faq/的
				// [通知与自定义消息有什么区别？]了解通知和自定义消息的区别
				// .setMsgContent("message content")
				// .setTitle("message titile")
				// .addExtra("message extras key", "message extras value")
				// .build())
				.setOptions(Options.newBuilder().setApnsProduction(true)// 此字段的值是用来指定本推送要推送的apns环境，false表示开发，true表示生产；对android和自定义消息无意义
						// .setApnsProduction(true)
						// .setSendno()//此字段是给开发者自己给推送编号，方便推送者分辨推送记录
						.setTimeToLive(864000)// 此字段的值是用来指定本推送的离线保存时长，如果不传此字段则默认保存一天，最多指定保留十天；
						.build())
				.build();
		// 打印请求数据
		logger.info("发送推送消息通知给客户端:请求第三方封装的json数据" + payload.toJSON());
		PushResult result = sendPush(payload);
		return result.isResultOK();
	}

	/**
	 * 
	 * @作者 胡竞 @Title: sendPushTextMessage @Description: TODO(发送文本消息给单用户)
	 * @param @param
	 *            userId 用户Id
	 * @param @param
	 *            countent消息内容
	 * @param @throws
	 *            ExternalException 设定文件
	 * @return void 返回类型 @throws
	 */
	@Override
	public void sendPushTextMessage(Integer userId, String title, String content) throws ExternalException {

		logger.info("获得参数【userId:" + userId + "】,【title:" + title + "】,【content:" + content + "】");
		estimate(userId, title, content);
		// 根据用户Id获取用户的推送标识
		UserBaseResponseVo userBase = userBaseService.getUserBaseInfo(userId);
		String pushId = userBase.getPushid();
		sendPush(pushId, title, content, null);

		// 存入数据库
		userMessageService.addUserMessage(userId, title, content);

	}

	/**
	 * 
	 * @作者 胡竞 @Title: sendPushUrlMessage @Description:
	 *     TODO(发送地址消息给单个用户) @param @throws ExternalException 设定文件 @return void
	 *     返回类型 @throws
	 */
	@Override
	public void sendPushUrlMessage(Integer userId, String title, String content, String url) throws ExternalException {
		logger.info("获得参数【userId:" + userId + "】,【title:" + title + "】,【content:" + content + "】，【url:" + url + "】");
		estimateHaveUrl(userId, title, content, url);
		// 根据用户Id获取用户的推送标识
		UserBaseResponseVo userBase = userBaseService.getUserBaseInfo(userId);
		String pushId = userBase.getPushid();
		sendPush(pushId, title, content, url);

		// 存入数据库
		userMessageService.addUserMessage(userId, title, content);
	}

	/**
	 * 
	 * @作者 胡竞 @Title: sendPushRegionTextMessage @Description:
	 *     TODO(发送区域文本消息) @param @param regionId @param @param
	 *     countent @param @throws ExternalException 设定文件 @return void 返回类型 @throws
	 */
	@Override
	public void sendPushRegionTextMessage(Integer regionId, String title, String content) throws ExternalException {
		logger.info("获得参数【regionId:" + regionId + "】,【title:" + title + "】,【content:" + content + "】");
		// 判断参数是否有效
		estimate(regionId, title, content);
		// 根据用户Id获取用户的推送标识
		List<UserBaseResponseVo> userList = userBaseService.getRegionUserBase(regionId);
		List<String> userPushId = new ArrayList<>();
		if (!ListUtil.isEmpty(userList)) {
			for (UserBaseResponseVo userBase2 : userList) {
				if (!StringUtils.isEmpty(userBase2.getPushid())) {
					userPushId.add(userBase2.getPushid());
					// 存入数据库
					userMessageService.addUserMessage(userBase2.getId(), title, content);
				}
			}
		}
		String pushIds = StringUtils.join(userPushId, ",");
		sendPush(pushIds, title, content, null);

	}

	/**
	 * 
	 * @作者 胡竞 @Title: sendPushRegionUrlMessage @Description:
	 *     TODO(发送区域网页消息) @param @param regionId @param @param
	 *     countent @param @param Url @param @throws ExternalException 设定文件 @return
	 *     void 返回类型 @throws
	 */
	@Override
	public void sendPushRegionUrlMessage(Integer regionId, String title, String content, String url)
			throws ExternalException {
		logger.info(
				"获得参数【regionId:" + regionId + "】,【title:" + title + "】,【content:" + content + "】，【url:" + url + "】");
		// 判断参数是否有效
		estimateHaveUrl(regionId, title, content, url);
		// 根据用户Id获取用户的推送标识

		List<String> userPushId = new ArrayList<String>();
		List<UserBaseResponseVo> userList = userBaseService.getRegionUserBase(regionId);
		if (!ListUtil.isEmpty(userList)) {
			for (UserBaseResponseVo userBase : userList) {
				if (!StringUtils.isEmpty(userBase.getPushid())) {
					userPushId.add(userBase.getPushid());
					// 存入数据库
					userMessageService.addUserMessage(userBase.getId(), title, content);
				}
			}
		}
		// 用string的内部方法join(参数，"以什么隔开")
		String pushIds = StringUtils.join(userPushId, ",");
		sendPush(pushIds, title, content, url);
	}

	/**
	 * @作者 胡竞 @Title: estimate
	 * @Description: TODO(发送推送消息给所有用户)
	 * @param @param
	 *            userId
	 * @param @param
	 *            title
	 * @param @param
	 *            countent
	 * @param @return
	 *            设定文件
	 * @throws ExternalException
	 */
	@Override
	public void sendPushAllUser(String title, String content, String url) throws ExternalException {
		logger.info("传入的参数【title:" + title + "】,【countent:" + content + "】,【url:" + url + "】,【url:" + url + "】");
		estimate(0, title, content);
		sendPush("-1", title, content, url);

		// 存入数据库
		int userId = 0;
		userMessageService.addUserMessage(userId, title, content);
	}

	/**
	 * @作者 胡竞 @Title: estimateHaveUrl @Description:
	 *     TODO(判断有URL参数的是否有效) @param @param userId @param @param
	 *     title @param @param countent @param @param url @param @return
	 *     设定文件 @return boolean 返回类型 @throws
	 */
	public void estimateHaveUrl(Integer userId, String title, String countent, String url) throws ExternalException {
		estimate(userId, title, countent);
		if (url == null || url.length() <= 0) {
			logger.error("发送推送消息的url地址为空,【url:" + url + "】");
			url = null;
		} else {
			// 判断url地址是否有效
			URL urlObject = null;
			try {
				urlObject = new URL(url);
				urlObject.openStream();
				logger.info("发送的url地址,【url:" + url + "】");
			} catch (IOException e) {
				logger.error("发送推送消息的url地址无效,无效的【url:" + url + "】");
				throw new ExternalException(ExternalExceptionEnum.EXTERNAL_SEND_PUSH_ERROR,
						"发送推送消息的url地址无效,无效的【url:" + url + "】");
			}
		}
	}

	/**
	 * @作者 胡竞 @Title: estimate @Description: TODO(判断参数是否有效) @param @param
	 *     userId @param @param title @param @param countent @param @return
	 *     设定文件 @return boolean 返回类型 @throws
	 */
	public void estimate(Integer userId, String title, String countent) throws ExternalException {
		if (userId == null) {
			logger.error("发送推送消息的用户ID为空,【userId:" + userId + "】");
			userId = null;
		}
		if (StringUtils.isEmpty(title)) {
			logger.error("发送推送消息的标题【title:" + title + "】,发送推送消息的标题为空");
			title = null;
		}
		if (StringUtils.isEmpty(countent)) {
			logger.error("发送推送消息的内容为空,【countent:" + countent + "】");
			countent = null;
		}
		if (title.length() > 20) {
			logger.error("发送推送消息的标题过长,限定在20个字节以内,【title:" + title + "】");
			throw new ExternalException(ExternalExceptionEnum.EXTERNAL_SEND_PUSH_ERROR,
					"发送推送消息的标题过长,限定在20个字节以内,【title:" + title + "】");
		}
		if (countent.length() > 500) {
			logger.error("发送推送消息的内容过长，限定在500个字节以内，【countent:" + countent + "】");
			throw new ExternalException(ExternalExceptionEnum.EXTERNAL_SEND_PUSH_ERROR,
					"发送推送消息的内容过长，限定在500个字节以内，【countent:" + countent + "】");
		}
	}

}
