package com.bz.agent.core.service.shop;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.bz.dao.mapper.agent.BzIncidenceRelationMapper;
import com.bz.dao.mapper.agent.BzPersonalDetailsMapper;
import com.bz.dao.mapper.agent.BzStoreAssociatedMapper;
import com.bz.dao.pojo.agent.BzIncidenceRelation;
import com.bz.dao.pojo.agent.BzPersonalDetails;
import com.bz.dao.pojo.agent.BzStoreAssociated;
import com.bz.framework.pojo.page.PageBean;
import com.bz.framework.util.base.PageUtil;
import com.bz.open.core.service.agent.AgentShopInfoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
/**
 * @author 陈青山
 * @TIME 2017年11月18日 下午16：31
 * @MIAOSHU 合伙人店铺信息
 */
@Service(version="1.0.0",interfaceClass=com.bz.open.core.service.agent.AgentShopInfoService.class)
@Transactional
public class AgentShopInfoServiceImp implements AgentShopInfoService{

private Logger log=LoggerFactory.getLogger(AgentShopInfoServiceImp.class);
	
	
	@Autowired
	private BzPersonalDetailsMapper bzPersonalDetailsMapper;//个人信息接口
	@Autowired
	private BzStoreAssociatedMapper bzStoreAssociatedMapper;//店铺关联接口
	@Autowired
	private BzIncidenceRelationMapper bzIncidenceRelationMapper;//合伙人关联接口
	/**
	 * @author 陈青山
	 * @TIME 2017年11月18日 下午16：31
	 * @param  agentId 合伙人id
	 * @param  type 合伙人类型
	 * @MIAOSHU 合伙人店铺数量
	 * @return 当前合伙人的店铺对象
	 */
	public Integer getShopCountOfAgent(String agentId,String type) {
		log.info("查询合伙人店铺数量    参数：【agentId】"+"【"+agentId+"】"+"【type】"+"【"+type+"】");
		BzPersonalDetails per=new BzPersonalDetails();
		per.setUserid(agentId);
		per.setSgrade(Integer.parseInt(type));
		List list2 =new ArrayList<>();
		List<BzPersonalDetails> list = bzPersonalDetailsMapper.selectList(per);
		for(BzPersonalDetails pers:list) {
			BzStoreAssociated storeAssociated=new BzStoreAssociated();
			storeAssociated.setUserid(pers.getId()+"");
			 list2 = bzStoreAssociatedMapper.selectList(storeAssociated);
		}
		return list2.size();
	}
	/**
	 * @author 陈青山
	 * @TIME 2017年11月18日 下午16：31
	 * @param userid
	 * @param type合伙人类型
	 * @param pagesize 总显示数
	 * @param cursize 当前页数
	 * @MIAOSHU 当前类型合伙人店铺
	 * @return 当前合伙人的店铺id
	 */
	@Override
	public List<String> getShopIdsOfAgent(String userid,String type, int pagesize, int cursize) {
		log.info("开始查询合伙人店铺信息      参数【userid】"+"【"+userid+"】"+"【type】"+"【"+type+"】"+
				"【pagesize】"+"【"+pagesize+"】"+"【cursize】"+"【"+cursize+"】");
		BzPersonalDetails per=new BzPersonalDetails();
		per.setUserid(userid);
		per.setSgrade(Integer.parseInt(type));
		BzPersonalDetails selectOne = bzPersonalDetailsMapper.selectOne(per);
		BzStoreAssociated bz=new BzStoreAssociated();
		bz.setStore(selectOne.getId()+"");
		Page<Object> startPage = PageHelper.startPage(cursize, pagesize);
		List<BzStoreAssociated> list =   bzStoreAssociatedMapper.selectList(bz);
		List<String> list1=new ArrayList<>();
		for(BzStoreAssociated p:list) {
			list1.add(p.getId()+"");
		}
		//还需调用店铺表信息
		return list1;
	}
	/**
	 * @author 陈青山
	 * @TIME 2017年11月22日 下午16：31
	 * @param agentId 业务员id
	 * @MIAOSHU 查询合伙人的自营业员集合
	 * @return 当前合伙人的自营业员
	 */
	@Override
	public List<BzPersonalDetails> getMyAgent(String agentId) {
		log.info("查询合伙人的自营业员集合     参数【agentid】"+"【"+agentId+"】");
		BzIncidenceRelation in=new BzIncidenceRelation();
		in.setUserid(agentId);
		List<BzIncidenceRelation> selectList = bzIncidenceRelationMapper.selectList(in);
		if(selectList==null) {
			log.info("查询合伙人的自营业员集合     【当前集合为空】");
			return null;
		}
		List<BzPersonalDetails> list=new ArrayList<>();
		for(BzIncidenceRelation bz:selectList) {
			BzPersonalDetails deta=new BzPersonalDetails();
			deta.setUserid(bz.getRefuserid());
			deta=bzPersonalDetailsMapper.selectOne(deta);
			list.add(deta);
		}
		return list;
	}
	
}
