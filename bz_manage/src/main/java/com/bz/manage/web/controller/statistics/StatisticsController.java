package com.bz.manage.web.controller.statistics;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bz.manage.model.test.DataTest;
import com.bz.manage.service.statistics.StatisticsService;

/**
* @ClassName: StatisticsController 
* @Description: TODO(公司统计页面控制) 
* @author 胡竞
* @date 2017年10月19日 下午2:23:00 
*
 */
@Controller
@RequestMapping(value="/system/statistics")
public class StatisticsController {

	private static final Log log=LogFactory.getLog(StatisticsController.class);
	@Autowired
	private StatisticsService statisticsService;
	
	List<DataTest> list=new ArrayList<DataTest>();
	
	/**
	* @作者 胡竞
	* @Title: today 
	* @Description: TODO(日统计页面) 
	* @param @param mv
	* @param @param time
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@GetMapping(value="/day")
	public ModelAndView today(ModelAndView mv,String dayTime) {
		log.info("进入统计页面");
		
		try {
			if (dayTime==null) {
				log.info("----查询今日统计---");
				
				//添加测试数据
				dayTime=(new SimpleDateFormat("HH")).format(new Date());
				int a = Integer.parseInt(dayTime);
				String b=Integer.toString(a+1);
				String c=Integer.toString(a+2);
				String d=Integer.toString(a+3);
				String time1=(new SimpleDateFormat("yyyy-MM-dd")).format(new Date())+" "+b+":00:00";
				//测试数据1
				DataTest test1=new DataTest();
				test1.setBeginDate(time1);
				test1.setBeginData(222.00);
				//测试数据2
				String time2=(new SimpleDateFormat("yyyy-MM-dd")).format(new Date())+" "+c+":00:00";
				DataTest test2=new DataTest();
				test2.setBeginDate(time2);
				test2.setBeginData(333.00);
				//测试数据3
				String time3=(new SimpleDateFormat("yyyy-MM-dd")).format(new Date())+" "+d+":00:00";
				DataTest test3=new DataTest();
				test3.setBeginDate(time3);
				test3.setBeginData(444);
				
				list.add(test1);
				list.add(test2);
				list.add(test3);
				
				mv.addObject("day",list);
				mv.setViewName("system/statistics/day");
			}else {
				log.info("----查询指定日期统计----");
				
				String time3=(new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
						DataTest test3=new DataTest();
				test3.setBeginDate(time3);
				test3.setBeginData(444);
				
				mv.addObject("day",test3);
				mv.setViewName("system/statistics/day");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	* @作者 胡竞
	* @Title: month 
	* @Description: TODO(月统计页面) 
	* @param @param mv
	* @param @param month
	* @param @param test
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@GetMapping(value="/month")
	public ModelAndView month(ModelAndView mv,String month,DataTest test) {
		
		try {
			if (month==null) {
				log.info("-----查询本月统计----");
				month=(new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
				
				test.setBeginData(123456);
				test.setBeginDate(month);
				
				mv.addObject("month",test);
				mv.setViewName("system/statistics/month");
			} else {
				log.info("查询指定月份统计");
				
				test.setBeginDate(month);
				test.setBeginData(666);
				
				mv.addObject("month",test);
				mv.setViewName("system/statistics/month");
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mv;
	}

	/**
	* @作者 胡竞
	* @Title: year 
	* @Description: TODO(年统计页面) 
	* @param @param mv
	* @param @param year
	* @param @param test
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@GetMapping(value="/year")
	public ModelAndView year(ModelAndView mv,String year,DataTest test) {
		log.info("----访问年统计页面----");
		try {
			if (year==null) {
				year=(new SimpleDateFormat("yyyy")).format(new Date());
				//注入测试数据
				test.setBeginData(123456);
				test.setBeginDate(year);
				
				mv.addObject("year",year);
				mv.setViewName("system/statistics/year");
				
			} else {

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mv;
	}
	
	
}
