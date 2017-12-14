package com.bz.merchant.core.service.dealFlow;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.bz.dao.mapper.merchant.MerchantDealFlowMapper;
import com.bz.dao.pojo.merchant.MerchantDealFlow;
import com.bz.framework.pojo.page.PageBean;
import com.bz.framework.util.base.PageUtil;
import com.bz.open.core.service.merchant.MerchantDealFlowService;
import com.bz.open.core.service.user.UserBaseService;
import com.bz.open.core.vo.response.agent.StoreInfoResponseVo;
import com.bz.open.core.vo.response.user.UserBaseResponseVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;


@Service(version="1.0.0",interfaceClass=com.bz.open.core.service.merchant.MerchantDealFlowService.class)
public class MerchantDealFlowServiceImp implements MerchantDealFlowService {
	private Logger log=LoggerFactory.getLogger(MerchantDealFlowServiceImp.class);
	@Autowired
	private MerchantDealFlowMapper merchantDealFlowMapper;
	@Reference(version="1.0.0")
	private UserBaseService userBaseService;
	/**
	 * 作者: 陈青山
	 * 描述: 根据店铺id获取店铺交易次数
	 * @param shopId 店铺id
	 * @return 店铺交易次数
	 */
	public Integer getDealCount(Integer shopId) {
		log.info("查询店铺交易次数");
		MerchantDealFlow flow=new MerchantDealFlow();
		flow.setShopid(shopId);
		return merchantDealFlowMapper.selectList(flow).size();
	}

	/**
	 * 作者: 陈青山
	 * 描述: 根据店铺id获取该店铺的所有流水   分页
	 * @param shopId 店铺id  curr 当前页  size 显示几条
	 * @return 流水集合
	 */
	public List<StoreInfoResponseVo> getAllDealOfShop(Integer shopId,Integer curr,Integer size) {
		log.info("根据店铺id获取该店铺的所有流水详情"+"shopid:"+ shopId+"curr:"+curr+" size:"+size);
		MerchantDealFlow mer=new MerchantDealFlow();
		mer.setShopid(shopId);
		Page<Object> page = PageHelper.startPage(curr, size);
		List<MerchantDealFlow> list = merchantDealFlowMapper.selectList(mer);
		List<StoreInfoResponseVo> list1=new ArrayList<>();
		for(MerchantDealFlow deal:list) {
			log.info("循环赋值");
			//查询客户表查姓名
			UserBaseResponseVo userBaseInfo = userBaseService.getUserBaseInfo(deal.getUserid()) ;
			System.err.println(userBaseInfo.getName());
			String name=userBaseInfo.getName();
			StoreInfoResponseVo vo=new StoreInfoResponseVo();
			vo.setCilentName(name);
			vo.setTime(deal.getCreatetime().toString());
			vo.setMoney(deal.getFlowmoney());
			list1.add(vo);
		}
		PageBean pageBean = PageUtil.getPageBean(page, list1);
		return list1;
	
	}

}
