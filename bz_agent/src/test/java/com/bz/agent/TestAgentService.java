package com.bz.agent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bz.dao.mapper.agent.BzPersonalDetailsMapper;
import com.bz.framework.pojo.base.BaseResult;
import com.bz.open.core.service.agent.AgentApplyService;
import com.bz.open.core.service.agent.AgentShopInfoService;
import com.bz.open.core.vo.request.agent.AgentRegionRequestVo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BzAgentApplication.class)
@WebAppConfiguration
public class TestAgentService {
	private Logger log = LoggerFactory.getLogger(TestAgentService.class);
	@Autowired
	private AgentApplyService agentApplyService;
	@Autowired
	private BzPersonalDetailsMapper bzPersonalDetailsMapper;
	@Autowired
	private AgentShopInfoService agentShopInfoService;
	@Autowired
	private com.bz.open.core.service.agent.AgentJudgeService AgentJudgeService;

	// 测试注册服务
	@Test
	public void testapply() {
		log.info("测试合伙人注册服务");
		AgentRegionRequestVo vo = new AgentRegionRequestVo();
		vo.setImPhone("18581201413");
		vo.setLegalCardId("500102121953993");
		vo.setRegion1("123");
		vo.setRegion2("232");
		vo.setRegion3("345");
		vo.setRegion4("340");
		vo.setSgrade("2");
		vo.setUserName("测试");
		vo.setUserid("bz002");
		BaseResult apply = agentApplyService.apply(vo);
		log.info("状态消息：" + apply.getMessage() + "状态码" + apply.getStatusCode());

	}

}
