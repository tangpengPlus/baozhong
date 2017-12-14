package com.bz.manage.web.controller.statistics;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bz.manage.model.test.DataTest;

@Controller
@RequestMapping(value="/system/analyze")
public class AnalyzeController {

	private static final Log log=LogFactory.getLog(AnalyzeController.class);
	
	
	@GetMapping(value="/day")
	public ModelAndView day(ModelAndView mv ,String beginTime,String endTime) {
		log.info("进入日报表页面 beginTime:"+beginTime+"endTime："+endTime);
		try {
			if (beginTime==null&&endTime==null) {
				
				log.info("----进入日报表分析页面----");
				List<DataTest> list =new ArrayList<>();
				//添加测试数据
				String day=(new SimpleDateFormat("HH")).format(new Date());
				int a = Integer.parseInt(day);
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
				
				mv.addObject("today",list);
				
				mv.setViewName("system/statistics/toDay");
			} else {
				List<DataTest> list =new ArrayList<>();
				log.info("----查询固定时间分析----");
				String [] aa=beginTime.split("~");
				String[] bb=endTime.split("~");
				DataTest one=new DataTest();
				one.setBeginData(12.02);
				one.setBeginDate(aa[0].replace(" ", ""));
				one.setEndDate(bb[0]);
				one.setEndData(128.2);
				
				DataTest ones=new DataTest();
				ones.setBeginData(15.02);
				ones.setBeginDate(aa[1].replace(" ", ""));
				ones.setEndDate(bb[1]);
				ones.setEndData(25.03);
				
				list.add(ones);
				list.add(one);
				
				
				mv.addObject("today",list);
				
				mv.setViewName("system/statistics/toDay");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
	}
		return mv;
	}
	
	@GetMapping(value="/month")
	public ModelAndView month(ModelAndView mv ,String beginTime,String endTime) {
		log.info("进入月报表页面 beginTime:"+beginTime+"endTime："+endTime);
		try {
			if (beginTime==null&&endTime==null) {
				
				log.info("----进入月报表分析页面----");
				List<DataTest> list =new ArrayList<>();
				//添加测试数据
				String day=(new SimpleDateFormat("dd")).format(new Date());
				int a = Integer.parseInt(day);
				String b=Integer.toString(a+1);
				String c=Integer.toString(a+2);
				String d=Integer.toString(a+3);
				String time1=(new SimpleDateFormat("yyyy-MM")).format(new Date())+" "+b+"00:00:00";
				//测试数据1
				DataTest test1=new DataTest();
				test1.setBeginDate(time1);
				test1.setBeginData(222.00);
				//测试数据2
				String time2=(new SimpleDateFormat("yyyy-MM")).format(new Date())+" "+c+"00:00:00";
				DataTest test2=new DataTest();
				test2.setBeginDate(time2);
				test2.setBeginData(333.00);
				//测试数据3
				String time3=(new SimpleDateFormat("yyyy-MM")).format(new Date())+" "+d+":00:00";
				DataTest test3=new DataTest();
				test3.setBeginDate(time3);
				test3.setBeginData(444);
				
				list.add(test1);
				list.add(test2);
				list.add(test3);
				
				mv.addObject("month",list);
				
				mv.setViewName("system/statistics/toMonth");
			} else {
				List<DataTest> list =new ArrayList<>();
				log.info("----查询固定时间分析----");
				String [] aa=beginTime.split("~");
				String[] bb=endTime.split("~");
				DataTest one=new DataTest();
				one.setBeginData(12.02);
				one.setBeginDate(aa[0].replace(" ", ""));
				one.setEndDate(bb[0]);
				one.setEndData(128.2);
				
				DataTest ones=new DataTest();
				ones.setBeginData(15.02);
				ones.setBeginDate(aa[1].replace(" ", ""));
				ones.setEndDate(bb[1]);
				ones.setEndData(25.03);
				
				list.add(ones);
				list.add(one);
				
				
				mv.addObject("month",list);
				
				mv.setViewName("system/statistics/toMonth");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
	}
		return mv;
	}
	
	@GetMapping
	public ModelAndView test(ModelAndView mv,String test) {
		
		System.out.println(test);
		
		mv.setViewName("redirect:day");
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
	
}
