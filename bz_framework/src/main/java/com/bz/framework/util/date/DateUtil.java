package com.bz.framework.util.date;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.util.StringUtils;


/**
 * 【时间工具】
 * 
 * @author King
 **/
public class DateUtil {
	/** 定义常量 **/

	/**yyyyMM*/
	public static final String DATE_JFP_STR = "yyyyMM";
	/**yyyy-MM-dd HH:mm:ss**/
	public static final String DATE_FULL_STR = "yyyy-MM-dd HH:mm:ss";
	/**yyyy-MM-dd**/
	public static final String DATE_SMALL_STR = "yyyy-MM-dd";
	/**yyMMddHHmmss**/
	public static final String DATE_KEY_STR = "yyMMddHHmmss";
	/**全年月日时分秒**/
	public static final String DATE_FULL_STRX = "yyyyMMddHHmmss";

	/**
	 * 获取当日凌晨时间
	 */
	public static Date getToday() {
		Calendar cld = Calendar.getInstance();
		cld.set(Calendar.HOUR_OF_DAY, 0);
		cld.set(Calendar.MINUTE, 0);
		cld.set(Calendar.SECOND, 0);
		cld.set(Calendar.MILLISECOND, 0);
		return cld.getTime();
	}
	

	/**
	 * 获取当日结束时刻23:59:59.999
	 */
	public static Date getEndOfDay() {
		Calendar cld = Calendar.getInstance();
		cld.set(Calendar.HOUR_OF_DAY, 23);
		cld.set(Calendar.MINUTE, 59);
		cld.set(Calendar.SECOND, 59);
		cld.set(Calendar.MILLISECOND, 999);
		return cld.getTime();
	}

	/**
	 * 获取距离现在指定天数的某天的开始时刻00:00:00.000
	 * 
	 * @param interval
	 *            间隔
	 * @return Date java.util.Date
	 * 
	 */
	public static Date getStartOfDay(int interval) {
		Calendar cld = Calendar.getInstance();
		cld.setTimeInMillis(cld.getTimeInMillis() + interval * 24 * 60 * 60
				* 1000l);
		cld.set(Calendar.HOUR_OF_DAY, 0);
		cld.set(Calendar.MINUTE, 0);
		cld.set(Calendar.SECOND, 0);
		cld.set(Calendar.MILLISECOND, 0);
		return cld.getTime();
	}
	/**
	 * 
	 * @Title: getPreStartOfDay 
	 * @Description: TODO 获取上个月第一天的00:00:00
	 * @param @param interval
	 * @param @return    设定文件 
	 * @return Date    返回类型 
	 * @throws
	 */
	public static Date getPreStartOfDay(int interval) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, interval);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获取某天的开始时刻00:00:00.000
	 * 
	 * @param date
	 *            需要获取天内的时间
	 * @return Date java.util.Date
	 */
	public static Date getStartOfDay(Date date) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		cld.set(Calendar.HOUR_OF_DAY, 0);
		cld.set(Calendar.MINUTE, 0);
		cld.set(Calendar.SECOND, 0);
		cld.set(Calendar.MILLISECOND, 0);
		return cld.getTime();
	}

	/**
	 * 获取距离现在指定天数的某天的结束时刻23:59:59.999
	 * 
	 * @param interval
	 *            间隔
	 * @return Date java.util.Date
	 */
	public static Date getEndOfDay(int interval) {
		Calendar cld = Calendar.getInstance();
		cld.setTimeInMillis(cld.getTimeInMillis() + interval * 24 * 60 * 60
				* 1000l);
		cld.set(Calendar.HOUR_OF_DAY, 23);
		cld.set(Calendar.MINUTE, 59);
		cld.set(Calendar.SECOND, 59);
		cld.set(Calendar.MILLISECOND, 999);
		return cld.getTime();
	}
	
	/**
	 * 
	 * @Title: getPreEndOfDay 
	 * @Description: TODO 获取上个月最后一天 23:59:59
	 * @param @param interval
	 * @param @return    设定文件 
	 * @return Date    返回类型 
	 * @throws
	 */
	public static Date getPreEndOfDay(int interval) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1); 
		calendar.add(Calendar.DATE, interval);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	/**
	 * 获取某天的最后时刻23:59:59.999
	 * 
	 * @param date
	 *            需要获取天内的时间
	 * @return Date java.util.Date
	 */
	public static Date getEndOfDay(Date date) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		cld.set(Calendar.HOUR_OF_DAY, 23);
		cld.set(Calendar.MINUTE, 59);
		cld.set(Calendar.SECOND, 59);
		cld.set(Calendar.MILLISECOND, 999);
		return cld.getTime();
	}

	/**
	 * 获取距离现在指定星期数的某个星期的开始时刻00:00:00.000
	 * 
	 * @param interval
	 *            间隔
	 * @return Date java.util.Date
	 */
	public static Date getStartOfWeek(int interval) {
		Calendar cld = Calendar.getInstance();
		cld.setTimeInMillis(cld.getTimeInMillis() + interval * 7 * 24 * 60 * 60
				* 1000l);
		cld.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return getStartOfDay(cld.getTime());
	}

	/**
	 * 获取指定星期的开始时刻00:00:00.000
	 * 
	 * @param week
	 *            一年中的第几周
	 * @param year
	 *            年份
	 * @return Date java.util.Date
	 */
	public static Date getStartOfWeek(int year, int week) {
		Calendar cld = Calendar.getInstance();
		cld.set(Calendar.YEAR, year);
		cld.set(Calendar.WEEK_OF_YEAR, week);
		cld.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return getStartOfDay(cld.getTime());
	}

	/**
	 * 获取距离指定日期指定星期数的某个星期的开始时刻00:00:00.000
	 * 
	 * @param interval
	 *            间隔
	 * @param date
	 *            日期
	 * @return Date java.util.Date
	 */
	public static Date getStartOfWeek(Date date, int interval) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		cld.setTimeInMillis(cld.getTimeInMillis() + interval * 7 * 24 * 60 * 60
				* 1000l);
		cld.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return getStartOfDay(cld.getTime());
	}

	/**
	 * 获取指定时间所在周的第一天的00:00:00.000
	 * 
	 * @param date
	 *            需要获取周的某天
	 * @return Date java.util.Date
	 */
	public static Date getStartOfWeek(Date date) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		cld.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return getStartOfDay(cld.getTime());
	}

	/**
	 * 获取距离现在指定周数的某周的最后时刻23:59:59.999
	 * 
	 * @param interval
	 *            间隔
	 * @return Date java.util.Date
	 */
	public static Date getEndOfWeek(int interval) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(getStartOfWeek(interval + 1));
		return new Date(cld.getTimeInMillis() - 1);
	}

	/**
	 * 获取指定周数的最后时刻23:59:59.999
	 * 
	 * @param week
	 *            一年中的第几周
	 * @param year
	 *            年份
	 * @return Date java.util.Date
	 */
	public static Date getEndOfWeek(int year, int week) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(getStartOfWeek(year, week + 1));
		return new Date(cld.getTimeInMillis() - 1);
	}

	/**
	 * 获取距离指定日期指定周数的某周的最后时刻23:59:59.999
	 * 
	 * @param interval
	 *            间隔
	 * @param date
	 *            日期
	 * @return Date java.util.Date
	 */
	public static Date getEndOfWeek(Date date, int interval) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		cld.setTime(getStartOfWeek(date, interval + 1));
		return new Date(cld.getTimeInMillis() - 1);
	}

	/**
	 * 获取指定时间所在周的最后一天的23:59:59.999
	 * 
	 * @param date
	 *            需要获取周的某天
	 * @return Date java.util.Date
	 */
	public static Date getEndOfWeek(Date date) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		cld.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		return getEndOfDay(cld.getTime());
	}

	/**
	 * 获取指定时间所在月的第一天的00:00:00.000
	 * 
	 * @param date
	 *            需要获取月的某天
	 * @return Date java.util.Date
	 */
	public static Date getStartOfMonth(Date date) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		cld.set(Calendar.DAY_OF_MONTH, 1);
		return getStartOfDay(cld.getTime());
	}

	/**
	 * 获取某年某月的开始时刻00:00:00.000
	 * 
	 * @param year
	 *            年份
	 * @param month
	 *            月份
	 * @return Date java.util.Date
	 */
	public static Date getStartOfMonth(int year, int month) {
		Calendar cld = Calendar.getInstance();
		cld.set(Calendar.YEAR, year);
		cld.set(Calendar.MONTH, month);
		cld.set(Calendar.DAY_OF_MONTH, 1);
		return getStartOfDay(cld.getTime());
	}

	/**
	 * 获取距离现在指定月数的某月的开始时刻00:00:00.000
	 * 
	 * @param interval
	 *            间隔
	 * @return Date java.util.Date
	 */
	public static Date getStartOfMonth(int interval) {
		Calendar cld = Calendar.getInstance();
		int currentMonth = cld.get(Calendar.MONTH); // 这里得到的值是0～11
		cld.add(Calendar.YEAR, ((interval + currentMonth) / 12));
		cld.set(Calendar.MONTH, ((interval + currentMonth) % 12));
		cld.set(Calendar.DAY_OF_MONTH, 1);
		return getStartOfDay(cld.getTime());
	}

	/**
	 * 获取指定时间所在月的最后一天的23:59:59.999
	 * 
	 * @param date
	 *            需要获取月的某天
	 * @return Date java.util.Date
	 */
	public static Date getEndOfMonth(Date date) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		int maxDay = cld.getActualMaximum(Calendar.DAY_OF_MONTH);
		cld.set(Calendar.DAY_OF_MONTH, maxDay);
		return getEndOfDay(cld.getTime());
	}

	/**
	 * 获取距离现在指定月数的某月的结束时刻23:59:59.999
	 * 
	 * @param interval
	 *            间隔
	 * @return Date java.util.Date
	 */
	public static Date getEndOfMonth(int interval) {
		return new Date(getStartOfMonth(interval + 1).getTime() - 1);
	}

	/**
	 * 获取某年某月的结束时刻23:59:59.999
	 * 
	 * @param year
	 *            年份
	 * @param month
	 *            月份
	 * @return Date java.util.Date
	 */
	public static Date getEndOfMonth(int year, int month) {
		return new Date(getStartOfMonth(year, month + 1).getTime() - 1);
	}

	/**
	 * 获取2个时间点之间的月份数
	 * 
	 * @param startDate
	 *            endDate
	 * @return int
	 */
	public static int monthsBetween(Date startDate, Date endDate) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(startDate);
		int startMonth = cld.get(Calendar.MONTH);
		int startYear = cld.get(Calendar.YEAR);
		cld.setTime(endDate);
		int endMonth = cld.get(Calendar.MONTH);
		int endYear = cld.get(Calendar.YEAR);
		return (endYear - startYear) * 12 + (endMonth - startMonth);
	}

	/**
	 * 获取2个时间点之间的天数
	 * 
	 * @param startDate
	 *            endDate
	 * @return int
	 */
	public static int daysBetween(Date startDate, Date endDate) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(startDate);
		c2.setTime(endDate);
		return daysBetween(c1, c2);
	}

	public static int daysBetween(Calendar early, Calendar late) {
		return (int) (toJulian(late) - toJulian(early));
	}

	public static final float toJulian(Calendar c) {
		int Y = c.get(Calendar.YEAR);
		int M = c.get(Calendar.MONTH);
		int D = c.get(Calendar.DATE);
		int A = Y / 100;
		int B = A / 4;
		int C = 2 - A + B;
		float E = (int) (365.25f * (Y + 4716));
		float F = (int) (30.6001f * (M + 1));
		float JD = (C + D + E + F) - 1524.5f;
		return JD;
	}

	/**
	 * 根据出生日期获得年龄
	 * 
	 * @param birthday
	 * @return int
	 */
	public static int getAge(Date birthday) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(birthday);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(new Date());
		int age = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
		return age < 0 ? 0 : age;
	}

	/**
	 * 日期相加
	 * 
	 * @param date
	 *            ,day
	 * @return 返回相加后的日期
	 */
	public static Date addDate(Date date, int day) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		cld.setTimeInMillis(cld.getTimeInMillis() + ((long) day) * 24 * 3600
				* 1000);
		return cld.getTime();
	}

	/**
	 * 
	 * 使用预设格式提取字符串日期
	 * 
	 * @param strDate
	 *            日期字符串
	 * 
	 * @return
	 */

	public static Date parse(String strDate) {

		return parse(strDate, DATE_FULL_STR);

	}

	/**
	 * 
	 * 使用用户格式提取字符串日期
	 * 
	 * @param strDate
	 *            日期字符串
	 * 
	 * @param pattern
	 *            日期格式
	 * 
	 * @return
	 */

	public static Date parse(String strDate, String pattern) {

		SimpleDateFormat df = new SimpleDateFormat(pattern);

		try {

			return df.parse(strDate);

		} catch (ParseException e) {

			e.printStackTrace();

			return null;

		}

	}
	/**
	 * 
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年10月26日${time}
	 * 描述:获取时间戳
	 * 备注:
	 * @return
	 */
    public static String getCurryTimeStr() {
    	SimpleDateFormat df = new SimpleDateFormat(DATE_FULL_STRX);
    	return df.format(new Date());
	}
	/**
	 * 
	 * 两个时间比较
	 * 
	 * @param date
	 * 
	 * @return
	 */

	public static int compareDateWithNow(Date date1) {

		Date date2 = new Date();

		int rnum = date1.compareTo(date2);

		return rnum;

	}

	/**
	 * 
	 * 两个时间比较(时间戳比较)
	 * 
	 * @param date
	 * 
	 * @return
	 */

	public static int compareDateWithNow(long date1) {

		long date2 = dateToUnixTimestamp();

		if (date1 > date2) {

			return 1;

		} else if (date1 < date2) {

			return -1;

		} else {

			return 0;

		}

	}

	/**
	 * 
	 * 获取系统当前时间
	 * 
	 * @return
	 */

	public static String getNowTime() {

		SimpleDateFormat df = new SimpleDateFormat(DATE_FULL_STR);

		return df.format(new Date());

	}

	/**
	 * 
	 * 获取系统当前时间
	 * 
	 * @return
	 */

	public static String getNowTime(String type) {

		SimpleDateFormat df = new SimpleDateFormat(type);

		return df.format(new Date());

	}
	
	/**
	 * 将时间格式化
	 * @param date		传入时间
	 * @param type		格式化格式
	 * @return  {@link String}
	 */
	public static String getFormatDt(Date inputDt,String type){
		SimpleDateFormat df = new SimpleDateFormat(type);

		return df.format(inputDt);
	}

	/**
	 * 
	 * 获取系统当前计费期
	 * 
	 * @return
	 */

	public static String getJFPTime() {

		SimpleDateFormat df = new SimpleDateFormat(DATE_JFP_STR);

		return df.format(new Date());

	}

	/**
	 * 
	 * 将指定的日期转换成Unix时间戳
	 * 
	 * @param String
	 *            date 需要转换的日期 yyyy-MM-dd HH:mm:ss
	 * 
	 * @return long 时间戳
	 */

	public static long dateToUnixTimestamp(String date) {

		long timestamp = 0;

		try {

			timestamp = new SimpleDateFormat(DATE_FULL_STR).parse(date)
					.getTime();

		} catch (ParseException e) {

			e.printStackTrace();

		}

		return timestamp;

	}
	/**
	 * 
	 * 将指定的日期转换成Unix时间戳
	 * 
	 * @param String
	 *            date 需要转换的日期 yyyy-MM-dd
	 * 
	 * @return long 时间戳
	 */

	public static long dateToUnixTimestamp(String date, String dateFormat) {

		long timestamp = 0;

		try {

			timestamp = new SimpleDateFormat(dateFormat).parse(date).getTime();

		} catch (ParseException e) {

			e.printStackTrace();

		}

		return timestamp;

	}

	/**
	 * 
	 * 将当前日期转换成Unix时间戳
	 * 
	 * @return long 时间戳
	 */

	public static long dateToUnixTimestamp() {

		long timestamp = new Date().getTime();

		return timestamp;

	}

	/**
	 * 
	 * 将Unix时间戳转换成日期
	 * 
	 * @param long timestamp 时间戳
	 * 
	 * @return String 日期字符串
	 */

	public static String unixTimestampToDate(long timestamp) {

		SimpleDateFormat sd = new SimpleDateFormat(DATE_FULL_STR);

		sd.setTimeZone(TimeZone.getTimeZone("GMT+8"));

		return sd.format(new Date(Long.valueOf(timestamp)));

	}
	
	/**
	 * 
	 * 将当前时间按照指定格式转换
	 * 
	 * @param format
	 *            日期格式
	 * @return 已经格式化的日期字符串
	 */
	public static String formatDate(String format) {
		return formatDate(new java.util.Date(), format);
	}

	/**
	 * 格式化日期
	 * 
	 * @param date
	 *            日期
	 * @param format
	 *            格式
	 * @return 已经格式化的日期字符串
	 * @author 罗家友
	 */
	public static String formatDate(Date date, String format) {
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(
				format);
		return formatter.format(date);
	}
	/**
	 * yyyyMMddHHmmss  to yyyy-MM-dd HH:mm:ss
	 * @param time
	 * @return
	 */
	public static String changeTime(String time){
		try{
	        SimpleDateFormat oldFormat  = new SimpleDateFormat("yyyyMMddHHmmss");
	        SimpleDateFormat newFormat  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        Date date = oldFormat.parse(time);
	        return newFormat.format(date);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return "";
    }
	/**
	 * 
	 * @Title: StringToDate 
	 * @Description: TODO 将字符串时间格式化为Date类型
	 * @param date 时间
	 * @param fmt 格式
	 * @return
	 * @throws ParseException    设定文件 
	 * @return Date    返回类型 
	 * @throws
	 */
	public static Date StringToDate(String date,String fmt) throws ParseException{
		SimpleDateFormat sdf= new SimpleDateFormat(fmt);
		return sdf.parse(date);
	}
	/**
	 * 
	 * @Title: getPreOfDay 
	 * @Description: TODO 获取当前时间的前一天
	 * @author 陈顺
	 * @param date
	 * @return    设定文件 
	 * @return Date    返回类型 
	 * @throws
	 */
	public static Date getPreOfDay(Date date) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		cld.set(Calendar.HOUR_OF_DAY, 23);
		cld.set(Calendar.MINUTE, 59);
		cld.set(Calendar.SECOND, 59);
		cld.set(Calendar.MILLISECOND, 999);
		
		cld.add(Calendar.DAY_OF_MONTH, -1);
		return cld.getTime();
	}
	
	/**
	 * 
	 * @Title: getCurrLastMonth 
	 * @Description: 获取指定日期的上一月时间
	 * @param 
	 * @return
	 */
	public static Date getCurrLastMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);
        return cal.getTime();
    }
	
	/**
	 * 
	 * @Title: getCurrLastMonth 
	 * @Description: 获取指定日期的上一年时间
	 * @param 
	 * @return
	 */
	public static Date getCurrLastYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, -1);
        return cal.getTime();
    }
	
	/**
	 * 
	 * @Title: getRecently7 
	 * @Description: TODO 获取最近7天的开始结束日期
	 * @author 郭靖
	 * @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public static String getRecently7(Date date){
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -7);
		String beginDt = DateUtil.formatDate(calendar.getTime(), "yyyy-MM-dd");
		calendar.add(Calendar.DATE, 6);
		String endDt = DateUtil.formatDate(calendar.getTime(), "yyyy-MM-dd");
		return "{beginDt:'"+beginDt+"',endDt:'"+endDt+"',searchType:1}";
	}
	
	
	/**
	 * 
	 * @Title: getCurrMonth 
	 * @Description: TODO 获取指定月份的开始结束时间
	 * @author 郭靖
	 * @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public static String getCurrMonth(Date date){
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, 0);
	    c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
	    String beginDt = DateUtil.formatDate(c.getTime(), "yyyy-MM-dd");
	    c.add(Calendar.MONTH, 0);
	    c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));  
	    String endDt = DateUtil.formatDate(c.getTime(), "yyyy-MM-dd");
	    return "{beginDt:'"+beginDt+"',endDt:'"+endDt+"',searchType:1}";
	}
	
	/**
	 * 
	 * @Title: getCurrMonth 
	 * @Description: TODO 获取指定某年的开始结束时间
	 * @author 郭靖
	 * @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public static String getCurrYear(Date date){
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		int currYear = c.get(Calendar.YEAR);
		c.clear();
		c.set(Calendar.YEAR, currYear);
		String beginDt = DateUtil.formatDate(c.getTime(), "yyyy-MM-dd");
		c.clear();
	    c.set(Calendar.YEAR, currYear);  
	    c.roll(Calendar.DAY_OF_YEAR, -1); 
	    String endDt = DateUtil.formatDate(c.getTime(), "yyyy-MM-dd");
		return "{beginDt:'"+beginDt+"',endDt:'"+endDt+"',searchType:2}";
	}
	
	/**
	 * 根据开始和结束日期得到之间所有日期集合
	 * @param beginDate
	 * @param endDate
	 * @param pattern  为空默认为yyyy-MM-dd
	 * @return
	 */
	public static List<String> getDatesBetweenTwoDate(Date beginDate, Date endDate, String pattern) {
		if(StringUtils.isEmpty(pattern)) {
			pattern = "yyyy-MM-dd";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);  
		List<String> lDate = new ArrayList<String>();  
		lDate.add(sdf.format(beginDate));// 把开始时间加入集合  
		Calendar cal = Calendar.getInstance();  
		// 使用给定的 Date 设置此 Calendar 的时间  
		cal.setTime(beginDate);  
		boolean bContinue = true;  
		while (bContinue) {  
		    // 根据日历的规则，为给定的日历字段添加或减去指定的时间量  
		    cal.add(Calendar.DAY_OF_MONTH, 1);  
		    // 测试此日期是否在指定日期之后  
		    if (endDate.after(cal.getTime())) {  
		        lDate.add(sdf.format(cal.getTime()));  
		    } else {  
		        break;  
		    }  
		}  
		lDate.add(sdf.format(endDate));// 把结束时间加入集合  
		return lDate;
	 }
	 public static String getBeforDate(int day,String format){
		 if(format==null){
			 format="yyyy-MM-dd";
		 }
		 Calendar cal = Calendar.getInstance();
		 cal.add(Calendar.DATE,day);
		 String beforDay = new SimpleDateFormat(format).format(cal.getTime());
		 return beforDay;
	 }
	 
	 /**
	  * 获取距离当前小时差距的时间
	  * @param time		差距小时
	  * @param format	格式化参数
	  * @param isInit	true-从当天0点开始计算，false-从当前时间开始计算
	  * @return
	  */
	 public static String getBeforTime(int time,String format, boolean isInit){
		 if(StringUtils.isEmpty(format)){
			 format="yyyy-MM-dd";
		 }
		 Calendar cal = Calendar.getInstance();
		 if(isInit) {
			 cal.setTime(getToday());
		 }
		 cal.add(Calendar.HOUR_OF_DAY,time);
		 String beforDay = new SimpleDateFormat(format).format(cal.getTime());
		 return beforDay;
	 }
	 
	 public static String getBeforDate(String date,String fmt,int day){
		 try {
			Date d = StringToDate(date, fmt);
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			c.add(Calendar.DATE,day);
			String beforDay = new SimpleDateFormat(fmt).format(c.getTime());
		    return beforDay;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 return null;
	 }
	 
	 /**
	  * 获取今天星期几
	  * 1-星期天,2-星期一..类推
	  * @return
	  */
	 public static int getTheWeek() {
		 Calendar c = Calendar.getInstance();
		 c.setTime(new Date(System.currentTimeMillis()));
		 return c.get(Calendar.DAY_OF_WEEK);
	 }
	 
	 public static String getBeforMonth(Date date,String fmt,int month){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH,month);
		String beforDay = new SimpleDateFormat(fmt).format(c.getTime());
	    return beforDay;
	 }
	 
	 /**
	  * 
	  * 
	  * 作者:唐鹏
	  * 创建时间:2017年10月30日上午10:40:06
	  * 描述:判断当前时间戳是否合理
	  * 备注:
	  * @param timeStr
	  * @return
	  */
	 public static boolean isTimeStr(String timeStr) {
		 if(org.apache.commons.lang.StringUtils.isEmpty(timeStr)) {
			 return false;
		 }
		 if(timeStr.length()!=13) {
			 return false;
		 }
		 try {
			 SimpleDateFormat format =  new SimpleDateFormat(DATE_FULL_STR);  
			 Long time=new Long(timeStr);
			 String d = format.format(time);  
			 format.parse(d);  
			 return true;
		} catch (Exception e) {
			return false;
		}
	 }
	 /**
	  * 
	  * 
	  * 作者:唐鹏
	  * 创建时间:2017年10月31日上午9:38:53
	  * 描述:判断当前时间戳是否超时
	  * 备注:
	  * @param timeStr
	  * @param overTime
	  * @return
	  */
	 public static boolean isTimeOut(String timeStr,long overTime) {
		 BigDecimal b1 = new BigDecimal(timeStr);   
		 BigDecimal b2 = new BigDecimal(System.currentTimeMillis());
		 return  b1.subtract(b2).doubleValue() >overTime?true:false;
	 }
	 
}
