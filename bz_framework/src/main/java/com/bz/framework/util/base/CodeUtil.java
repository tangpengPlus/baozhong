package com.bz.framework.util.base;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import com.bz.framework.util.validate.ValidateUtil;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
/**
 * 编码工具类
 * 
 */
public abstract class CodeUtil {
	final static int BUFFER_SIZE = 4096;

	/**
	 * 从base64字符获取转换后的输入流
	 * 
	 * @param base64Str
	 * @return InputStream
	 * @throws IOException
	 */
	public static InputStream getInputStreamFormBASE64Str(String base64Str)
			throws IOException {
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] bytes = decoder.decodeBuffer(base64Str);
		return new ByteArrayInputStream(bytes);
	}

	/**
	 * 将InputStream转换成byte数组
	 * 
	 * @param in
	 *            InputStream
	 * @return byte[]
	 * @throws IOException
	 */
	public static byte[] inputStreamToByte(InputStream in) throws IOException {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] data = new byte[BUFFER_SIZE];
		int count = -1;
		while ((count = in.read(data, 0, BUFFER_SIZE)) != -1)
			outStream.write(data, 0, count);
		data = null;
		return outStream.toByteArray();
	}

	public static String transferBASE64(byte[] fileByte)throws IOException{
		String strBase64 = new BASE64Encoder().encode(fileByte);  
		return strBase64;
	}
	
	public static String transInputstranBASE64(InputStream in)throws IOException{
		return transferBASE64(inputStreamToByte(in));
	}
	/**
	 * BASE64编码
	 * 
	 * @param str
	 *            需要编码的字符串
	 * @return String
	 */
	public static String transferBASE64(String str) {
		if (str == null)
			return null;
		return (new sun.misc.BASE64Encoder()).encode(str.getBytes());
	}

	/**
	 * 转换
	 * 
	 * @param source
	 *            字符内容
	 * @param sourceCode
	 *            原编码
	 * @param targetCode
	 *            目标编码
	 * @return 转码后内容
	 * @throws UnsupportedEncodingException
	 */
	public static String decode(String source, String sourceCode,
			String targetCode) throws UnsupportedEncodingException {
		if (ValidateUtil.isEmpty(source)) {
			return source;
		}
		return new String(source.getBytes(sourceCode), targetCode);
	}

	/**
	 * ISO-8859-1转UTF-8
	 * 
	 * @param source
	 *            字符内容
	 * @return 转码后内容
	 * @throws UnsupportedEncodingException
	 */
	public static String decodeIsoToUtf(String source)
			throws UnsupportedEncodingException {
		return decode(source, "ISO8859-1", "UTF-8");
	}

	/**
	 * gbk->iso
	 * 
	 * @param source
	 *            字符内容
	 * @return String 转码后内容
	 * @throws UnsupportedEncodingException
	 */
	public static String decodeGbkToIso(String source)
			throws UnsupportedEncodingException {
		return decode(source, "GBK", "ISO-8859-1");
	}

	/**
	 * URL解码
	 * 
	 * @param source
	 *            字符内容
	 * @return 解码后内容
	 * @throws UnsupportedEncodingException
	 */
	public static String decodeUrl(String source)
			throws UnsupportedEncodingException {
		return java.net.URLDecoder.decode(source, "UTF-8");
	}

	/**
	 * URL编码
	 * 
	 * @param source
	 *            字符内容
	 * @return 编码后内容
	 * @throws UnsupportedEncodingException
	 */
	public static String encodeUrl(String source)
			throws UnsupportedEncodingException {
		return java.net.URLEncoder.encode(source, "UTF-8");
	}

	/**
	 * 获取UUID唯一的32位字符串
	 * 
	 * @return
	 */
	public static final String getUUIDStr() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 字节数组转成16进制表示格式的字符串
	 * 
	 * @param byteArray
	 *            需要转换的字节数组
	 * @return 16进制表示格式的字符串
	 **/
	public static String toHexString(byte[] byteArray) {
		if (byteArray == null || byteArray.length < 1)
			throw new IllegalArgumentException(
					"this byteArray must not be null or empty");

		final StringBuilder hexString = new StringBuilder();
		for (int i = 0; i < byteArray.length; i++) {
			if ((byteArray[i] & 0xff) < 0x10)// 0~F前面不零
				hexString.append("0");
			hexString.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		return hexString.toString().toLowerCase();
	}

	/**
	 * 16进制的字符串表示转成字节数组
	 * 
	 * @param hexString
	 *            16进制格式的字符串
	 * @return 转换后的字节数组
	 **/
	public static byte[] toByteArray(String hexString) {
		if (StringUtils.isEmpty(hexString))
			return null;
		hexString = hexString.toLowerCase();
		final byte[] byteArray = new byte[hexString.length() / 2];
		int k = 0;
		for (int i = 0; i < byteArray.length; i++) {// 因为是16进制，最多只会占用4位，转换成字节需要两个16进制的字符，高位在先
			byte high = (byte) (Character.digit(hexString.charAt(k), 16) & 0xff);
			byte low = (byte) (Character.digit(hexString.charAt(k + 1), 16) & 0xff);
			byteArray[i] = (byte) (high << 4 | low);
			k += 2;
		}
		return byteArray;
	}

	/**
	 * @Title: base64Encode
	 * @Description: 加密
	 * @param str
	 * @return
	 */
	public static String base64Encode(String str) {
		byte[] b = null;
		String s = null;
		try {
			b = str.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (b != null) {
			s = new BASE64Encoder().encode(b);
		}
		return s;
	}

	/**
	 * @Title: base64Decode
	 * @Description: 解密
	 * @param base64Str
	 * @return
	 */
	public static String base64Decode(String base64Str) {
		byte[] b = null;
		String result = null;
		if (base64Str != null) {
			BASE64Decoder decoder = new BASE64Decoder();
			try {
				b = decoder.decodeBuffer(base64Str);
				result = new String(b, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}

