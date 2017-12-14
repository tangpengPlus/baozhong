package com.bz.agent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bz.agent.core.service.apply.AgentApplyServiceImp;
import com.bz.agent.core.service.index.AgentIndexServiceImp;
import com.bz.dao.pojo.map.Region;
import com.bz.open.core.service.map.AdministrativeAreaService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=BzAgentApplication.class)
@WebAppConfiguration
public class BzAgentApplicationTests {

	private Logger log=LoggerFactory.getLogger(BzAgentApplicationTests.class);
	
	
	/**
	 * 测试地区接口
	 */
	@Test
	public void  dizi() {
		
		String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";  
        Pattern p = Pattern.compile(regExp);  
        CharSequence str="1851201412";
		Matcher m = p.matcher(str);  
        System.out.println(  m.matches() );
	}
}
