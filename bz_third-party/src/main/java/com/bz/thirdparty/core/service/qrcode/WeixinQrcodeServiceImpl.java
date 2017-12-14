package com.bz.thirdparty.core.service.qrcode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;
import javax.imageio.ImageIO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.bz.framework.constant.exception.BzExceptionEnum.ExternalExceptionEnum;
import com.bz.framework.error.exception.ExternalException;
import com.bz.framework.util.image.ImageUtils;
import com.bz.open.core.service.qrcode.WeixinQrcodeService;
import com.swetake.util.Qrcode;
/**
 * 
 * 作者: 兰俊
 * 描述: 微信生成解析二维码服务实现
 * 版本: version 1.0.0
 * 创建时间:2017年11月1日下午6:51:29
 */
@Service(version="1.0.0",interfaceClass=com.bz.open.core.service.qrcode.WeixinQrcodeService.class)
public class WeixinQrcodeServiceImpl implements WeixinQrcodeService{
	
	private static Logger logger = LoggerFactory.getLogger(WeixinQrcodeServiceImpl.class);
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 生成商铺收款二维码
	 * 创建时间:2017年11月2日下午4:04:54
	 * @param json 生成二维码的内容
	 * @return ByteArrayInputStream 输入流
	 * @throws ExternalException
	 */
	@Override
	@SuppressWarnings("unchecked")
	public ByteArrayInputStream createQrcade(String json) throws ExternalException{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ByteArrayInputStream bis = null;
		Map<String, String> map = (Map<String, String>) JSONObject.parse(json);
		try {
			Qrcode qrcode = new Qrcode();
	        // 设置二维码排错率, L(7%)、M(15%)、Q(25%)、H(30%) 排错率越高可存储的信息越少，但对二维码的清晰度要求比较低
	        qrcode.setQrcodeErrorCorrect('M');
	        // N代表数字，A代表字符a-Z，B代表其他字符
	        qrcode.setQrcodeEncodeMode('B');
	        // 设置二维码版本，取值范围为0-40，值越大尺寸越大，存储的信息越大
	        qrcode.setQrcodeVersion(11);

	        // 设置图片高宽度
	        BufferedImage bufferedImage = new BufferedImage(273, 273, BufferedImage.TYPE_INT_RGB);
	        // 创建一个 Graphics2D,画图
	        Graphics2D gs = bufferedImage.createGraphics();
	        // 设置图片的背景色
	        gs.setBackground(Color.WHITE);
	        gs.clearRect(0, 0, 273, 273);

	        // 设置图片颜色
	        gs.setColor(Color.black);

	        // 将输出内容转为byte类型
	        byte[] contentBytes = map.get("contents").getBytes("utf-8");

	        // 设置偏移量，不设置可能导致解析出错
	        int pixoff = 15;

	        // 输出内容
	        if (contentBytes.length > 0 && contentBytes.length < 130) {
	            boolean[][] codeOut = qrcode.calQrcode(contentBytes);
	            System.out.println("sss="+codeOut.length);
	            for (int i = 0; i < codeOut.length; i++) {
	               for (int j = 0; j < codeOut.length; j++) {
	                  if (codeOut[j][i]) {
	                    gs.fillRect(j * 4 + pixoff, i * 4 + pixoff, 4, 4);
	                  }
	               }
	             }
	         } else {
	        	logger.error("生成二维码失败原因:字符字节过长(字节最长130)");
	        	throw new ExternalException(ExternalExceptionEnum.EXTERNAL_QRCODE_SERVER_ERROR,"生成二维码失败原因:字符字节过长(字节最长130)");
	         }

	         // 没有logo的二维码
	         gs.dispose();
	         bufferedImage.flush();
	         // 生成二维码QRCode图片在D盘下
	         ImageIO.write(bufferedImage, "jpg", new File("D:\\pic\\5.jpg"));
	         //背景图片
	         BufferedImage bgImage = ImageIO.read(new File("D:\\pic\\2.jpg"));
	        
	         //合成新的图片(背景加二维码)
	         BufferedImage bgImage1 = ImageUtils.pressImage(bgImage, bufferedImage, 0, 0, 130, 1.0f);
//	         ImageIO.write(image3, "jpg", new File("D:\\pic\\4.jpg"));
	         //合成新图片(添加文字水印)
	         BufferedImage bgImage2 = ImageUtils.pressText(bgImage1, map.get("shop_name"), null, 1, 40, Color.BLACK, 10, 240, 100, 1.0f);
	         ImageIO.write(bgImage2, "jpg", new File("d:\\pic\\1.jpg"));
	         ImageIO.write(bgImage2, "jpg", bos);
	         byte[] b = bos.toByteArray();
	         bis = new ByteArrayInputStream(b);
	      } catch (Exception e) {
	    	  	logger.error("生成二维码失败原因:"+e);
	            e.printStackTrace();
	      }
		return bis!=null?bis:null;
	}


}