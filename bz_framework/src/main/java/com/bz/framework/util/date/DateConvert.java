package com.bz.framework.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.convert.converter.Converter;
/**
 * spring mvc 针对日期参数转换（全局日期处理类）
 * @author 唐鹏
 *
 */
public class DateConvert implements Converter<String,Date>{
	static Log log = LogFactory.getLog(DateConvert.class);
	@Override
	public Date convert(String arg0) {
		if (null == arg0 || arg0.equals("")) {
			return null;
		}
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		if (arg0.length() == 10) {
			simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		}
		 
		try {
			return simpleDateFormat.parse(arg0);
		} catch (ParseException e) {
			log.info(e);
			e.printStackTrace();
		}
		return null;
	}

}
