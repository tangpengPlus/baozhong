package com.bz.framework.util.date;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Dates {
	
	public static Date now(){
		return Calendar.getInstance().getTime();
	}


    /**    
     * 得到几天前的时间      
      * @param d    
      * @param day    
      * @return    
      */     
     public static Date getDateBefore(Date d, int day) {      
         Calendar now = Calendar.getInstance();      
         now.setTime(d);      
//         now.set(Calendar.DATE, now.get(Calendar.DATE) - day);    
         now.add(Calendar.DAY_OF_MONTH, -1*day);
         return now.getTime();      
     }
     
     /**    
      * 得到几天后的时间    
      * @param d    
      * @param day    
      * @return    
      */     
	public static Date getDateAfter(Date d, int day) {
		Calendar now = Calendar.getInstance();
		now.setTime(d);
//		now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
		now.add(Calendar.DAY_OF_MONTH, day);
		return now.getTime();
	}
     
     /**
      * 昨天起点
      * @param d
      * @return
      */
     public static Date getYesterdayBegin(){
		  Calendar now = Calendar.getInstance();  
//	      now.set(Calendar.DATE, now.get(Calendar.DATE) -1);
		  now.add(Calendar.DAY_OF_MONTH, -1);
	      now.set(Calendar.HOUR_OF_DAY, 0);
	      now.set(Calendar.MINUTE, 0);
	      now.set(Calendar.SECOND, 0);
	      now.set(Calendar.MILLISECOND, 0);
		return now.getTime();
     }
     
     /**
      * 昨天结束时间
      * @return
      */
     public static Date getYesterdayEnd(){
		  Calendar now = Calendar.getInstance();  
//	      now.set(Calendar.DATE, now.get(Calendar.DATE) -1);
		  now.add(Calendar.DAY_OF_MONTH, -1);
	      now.set(Calendar.HOUR_OF_DAY, 23);
	      now.set(Calendar.MINUTE, 59);
	      now.set(Calendar.SECOND, 59);
	      now.set(Calendar.MILLISECOND, 999);
		return now.getTime();
    }
     
     /**
      * 上月初
      * @param d
      * @return
      */
     public static Date getLastMonthBegin(){
		  Calendar now = Calendar.getInstance();  
//	      now.set(Calendar.MONTH, now.get(Calendar.MONTH) -1);
		  now.add(Calendar.MONTH, -1);
	      now.set(Calendar.DAY_OF_MONTH, 1);
	      now.set(Calendar.HOUR_OF_DAY, 0);
	      now.set(Calendar.MINUTE, 0);
	      now.set(Calendar.SECOND, 0);
	      now.set(Calendar.MILLISECOND, 0);
		return now.getTime();
     }
     
     /**
      * 月初
      * @return
      */
     public static Date getMonthBegin(){
		  Calendar now = Calendar.getInstance();
	      now.set(Calendar.DAY_OF_MONTH, 1);
	      now.set(Calendar.HOUR_OF_DAY, 0);
	      now.set(Calendar.MINUTE, 0);
	      now.set(Calendar.SECOND, 0);
	      now.set(Calendar.MILLISECOND, 0);
		return now.getTime();
    }
     
     /**
      * 昨天结束时间
      * @return
      */
     public static Date getDayEnd(Date date){
		  Calendar now = Calendar.getInstance();
		  now.setTime(date);
	      now.set(Calendar.HOUR_OF_DAY, 23);
	      now.set(Calendar.MINUTE, 59);
	      now.set(Calendar.SECOND, 59);
	      now.set(Calendar.MILLISECOND, 999);
		return now.getTime();
    }
     
    public static Date getPastDayBegin(int day){
    	 Calendar now = Calendar.getInstance();  
//	      now.set(Calendar.DATE, now.get(Calendar.DATE) -day);
    	  now.add(Calendar.DAY_OF_MONTH, -1*day);
	      now.set(Calendar.HOUR_OF_DAY, 0);
	      now.set(Calendar.MINUTE, 0);
	      now.set(Calendar.SECOND, 0);
	      now.set(Calendar.MILLISECOND, 0);
		return now.getTime();
    }
     
     /**
      * 今天0点
      * @param d
      * @return
      */
     public static Date getTodayBegin(){
    	 Calendar now = Calendar.getInstance();  
	      now.set(Calendar.HOUR_OF_DAY, 0);
	      now.set(Calendar.MINUTE, 0);
	      now.set(Calendar.SECOND, 0);
	      now.set(Calendar.MILLISECOND, 0);
		return now.getTime();
    }
     /**
      * 今天结束时间
      * @return
      */
     public static Date getTodayEnd(){
		  Calendar now = Calendar.getInstance();  
	      now.set(Calendar.HOUR_OF_DAY, 23);
	      now.set(Calendar.MINUTE, 59);
	      now.set(Calendar.SECOND, 59);
	      now.set(Calendar.MILLISECOND, 999);
		return now.getTime();
   }
     
    /**
     * 获得间隔日期
     * @param d1
     * @param d2
     * @return
     * @throws ParseException
     */
 	public static int getBetweenDays(Date d1, Date d2) {
		int betweenDays = 0;
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(d1);
		c2.setTime(d2);
		if (c1.after(c2)) {
			c1 = c2;
			c2.setTime(d1);
		}
		int betweenYears = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
		betweenDays = c2.get(Calendar.DAY_OF_YEAR)- c1.get(Calendar.DAY_OF_YEAR);
		for (int i = 0; i < betweenYears; i++) {
			c1.set(Calendar.YEAR, (c1.get(Calendar.YEAR) + 1));
			betweenDays += c1.getMaximum(Calendar.DAY_OF_YEAR);
		}
		return betweenDays-1;
	}
 	
 	@SuppressWarnings("deprecation")
	public static boolean equalDate(Date d1,Date d2){
 		return d1.getYear() == d2.getYear() && d1.getMonth() == d2.getMonth() && d1.getDate() == d2.getDate();
 	}
 	
 	public static int getMonthDayCount(Date date) {   
 	   Calendar calendar = new GregorianCalendar();   
 	   calendar.setTime(date);   
 	   int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);   
 	   return day;

 	}
}
