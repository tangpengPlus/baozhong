package com.bz.merchant.core.service.base;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.bz.dao.mapper.merchant.MerchantBaseMapper;
import com.bz.dao.mapper.merchant.MerchantDealFlowMapper;
import com.bz.dao.mapper.merchant.MerchantServerStatusMapper;
import com.bz.dao.mapper.merchant.MerchantShopMapper;
import com.bz.dao.mapper.merchant.MerchantUserRecordMapper;
import com.bz.dao.pojo.merchant.MerchantBase;
import com.bz.dao.pojo.merchant.MerchantDealFlow;
import com.bz.dao.pojo.merchant.MerchantServerStatus;
import com.bz.dao.pojo.merchant.MerchantShop;
import com.bz.dao.pojo.merchant.MerchantUserRecord;
import com.bz.framework.error.exception.MerchantException;
import com.bz.open.core.service.merchant.MerchantBaseService;
import com.bz.open.core.service.user.UserBaseService;
import com.bz.open.core.vo.response.agentShop.AgentShopResponseVo;
import com.bz.open.core.vo.response.merchant.MerchantInfoResponseVo;
import com.bz.open.core.vo.response.merchant.MerchantServerStatusResponseVo;
import com.bz.open.core.vo.response.merchant.MerchantShopResponseVo;
import com.bz.open.core.vo.response.user.UserBaseResponseVo;

@Service(version="1.0.0",interfaceClass=com.bz.open.core.service.merchant.MerchantBaseService.class)
@Transactional
public class MerchantBaseServiceImpl implements MerchantBaseService{

	private final Logger logger=LoggerFactory.getLogger(MerchantBaseServiceImpl.class);
	
	@Autowired
	private MerchantBaseMapper merchantBaseMapper;
	@Autowired
	private MerchantServerStatusMapper merchantServerStatusMapper;
	@Autowired
	private MerchantShopMapper merchantShopMapper;
	@Autowired
	private MerchantDealFlowMapper merchantDealFlowMapper;
	@Autowired
	private MerchantUserRecordMapper merchantUserRecordMapper;
	@Reference(version="1.0.0")
	private UserBaseService userBaseService;
	
	
	@Override
	public MerchantInfoResponseVo getMerchantInfoById(Integer merchantId) throws MerchantException {
		logger.info("根据商户Id获取商户基本信息:【merchantId:{}】",merchantId);
		MerchantBase base =merchantBaseMapper.selectById(merchantId);
		if(base==null) {
			logger.error("查询的商户为空【MerchantBase："+base+"】");
			return null;
		}
		MerchantInfoResponseVo baseVo=new MerchantInfoResponseVo();
		//id
		baseVo.setId(base.getId());
		//身份证图片地址
		baseVo.setIdcardimage(base.getIdcardimage());
		//名称
		baseVo.setName(base.getName());
		//审核状态
		baseVo.setIsverify(base.getIsverify());
		//商户编号
		baseVo.setNumber(base.getNumber());
		//商户电话
		baseVo.setPhone(base.getPhone());
		//创建时间
		baseVo.setCreatetime(base.getCreatetime());
		
		return baseVo;
	}
	
	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 根据地区编码、店铺名称查询店铺信息
	 * 创建时间:2017年11月23日下午4:47:34
	 * @param agentAddress 地区编码
	 * @return 店铺信息集合
	 */
	@Override
	public List<MerchantShopResponseVo> getMerchantInfoByArea(String agentAddress,String shopName) {
		logger.info("根据地区编码【agentAddress="+agentAddress+"】,搜索的店铺名称【shopName="+shopName+"】查询店铺信息");
		String[] address = agentAddress.split(",");
		MerchantShop condition = new MerchantShop();
		condition.setName(shopName);
		if(address.length==1) {
			condition.setProvincelevecode(address[0]);
		}
		if(address.length==2) {
			condition.setCitylevecode(address[1]);
		}
		if(address.length==3) {
			condition.setRegionlevecode(address[2]);
		}
		if(address.length==4) {
			condition.setProvincelevecode(address[3]);
		}
		//根据封装的条件获取店铺信息
		List<MerchantShop> shops = merchantShopMapper.getMerchantInfoByCondition(condition);;
		List<MerchantShopResponseVo> shopes = new ArrayList<>();
		for(MerchantShop m:shops) {
			MerchantShopResponseVo mer = new MerchantShopResponseVo();
			try {
				BeanUtils.copyProperties(mer, m);
			} catch (IllegalAccessException e) {
				logger.error("bean类型转换有误,【shops:"+shops+"】转换到【shopes:"+shopes+"】有误");
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				logger.error("bean类型转换有误,【shops:"+shops+"】转换到【shopes:"+shopes+"】有误");
				e.printStackTrace();
			}
			shopes.add(mer);
		}
		return shopes;
		
	}

	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 根据商家id查询商家开启的功能信息
	 * 创建时间:2017年11月21日下午5:08:24
	 * @param merchantId
	 * @return
	 * @throws MerchantException
	 */
	@Override
	public MerchantServerStatusResponseVo getMerchantServerStatusById(Integer merchantId) throws MerchantException {
		logger.info("根据商家【id="+merchantId+"】查询商家开启的功能信息");
		MerchantServerStatus status = new MerchantServerStatus();
		status.setMerchantId(merchantId);
		List<MerchantServerStatus> statuses = merchantServerStatusMapper.selectList(status);
		if(statuses==null||statuses.size()==0) {
			logger.info("没有查到该店铺的信息");
			return null;
		}
		status = statuses.get(statuses.size()-1);
		logger.info("店铺的初始数据："+statuses.get(statuses.size()-1));
		for(MerchantServerStatus s:statuses) {
			if(s.getCreditcardstatus()==1&&s.getIsdelete()==1) {
				status.setCreditcardstatus(s.getCreditcardstatus());
			}
			if(s.getGrantredpacketstatus()==1&&s.getIsdelete()==1) {
				status.setGrantredpacketstatus(s.getGrantredpacketstatus());
			}
			if(s.getOnlinestorestatus()==1&&s.getIsdelete()==1) {
				status.setOnlinestorestatus(s.getOnlinestorestatus());
			}
			if(s.getPayafteradvertisingstatus()==1&&s.getIsdelete()==1) {
				status.setPayafteradvertisingstatus(s.getPayafteradvertisingstatus());
			}
			if(s.getPaybeforeadvertisingstatus()==1&&s.getIsdelete()==1) {
				status.setPaybeforeadvertisingstatus(s.getPaybeforeadvertisingstatus());
			}
			if(s.getPhonesmessagestatus()==1&&s.getIsdelete()==1) {
				status.setPhonesmessagestatus(s.getPhonesmessagestatus());
			}
			if(s.getReceiptsstatus()==1&&s.getIsdelete()==1) {
				status.setReceiptsstatus(s.getReceiptsstatus());
			}
			if(s.getServicelinksstatus()==1&&s.getIsdelete()==1) {
				status.setServicelinksstatus(s.getServicelinksstatus());
			}
		}
		MerchantServerStatusResponseVo statusResp = new MerchantServerStatusResponseVo();
		try {
			BeanUtils.copyProperties(statusResp, status);
		} catch (IllegalAccessException e) {
			logger.error("bean类型转换有误,【status:"+status+"】转换到【statusResp:"+statusResp+"】有误");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			logger.error("bean类型转换有误,【status:"+status+"】转换到【statusResp:"+statusResp+"】有误");
			e.printStackTrace();
		}
		return statusResp;
	}

	/**
	 * @author 陈青山
	 * @miaoshu 得到绑定商家信息
	 * @param list 店铺id集合
	 * @return 得到每个商家信息size数
	 */
	@Override
	public List<AgentShopResponseVo> getAgentShopInfo(List<String> list) {
		logger.info("根据商户Id获取商户基本信息:【list:{}】",list);
		List<AgentShopResponseVo> list1=new ArrayList<>();
		for(String str:list) {
			//得到商铺对象
			MerchantShop selectById = merchantShopMapper.selectById(str);
			MerchantDealFlow deta=new MerchantDealFlow();
			deta.setShopid(selectById.getId());
			//通过商铺id查询资金流水表返回集合
			List<MerchantDealFlow> selectList = merchantDealFlowMapper.selectList(deta);
			AgentShopResponseVo vo=new AgentShopResponseVo();
			vo.setSize(selectList.size());
			vo.setTell(selectById.getPhone());
			vo.setTime(selectById.getCreatetime().toString());
			vo.setShopName(selectById.getName());
			vo.setCity(selectById.getProvincelevecode()+" "+selectById.getCitylevecode()+" "+selectById.getRegionlevecode());
			list1.add(vo);
		}
		return list1;
	}

	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 根据用户的openid获取该用户的店铺信息
	 * 创建时间:2017年11月23日下午10:20:00
	 * @param openId
	 * @return
	 */
	@Override
	public List<AgentShopResponseVo> getMerchantShopInfo(String openId) {
		logger.info("根据用户的【openid="+openId+"】获取该用户的店铺信息");
		//根据openid查询用户信息
		UserBaseResponseVo user = userBaseService.getUserByOpenId(openId);
		//根据用户id查询其相关的店铺关联信息
		MerchantUserRecord userRecord = new MerchantUserRecord();
		userRecord.setUserid(user.getId());
		List<MerchantUserRecord> userRecords = merchantUserRecordMapper.selectList(userRecord);
		if(userRecords==null||userRecords.size()==0) {
			logger.info("该用户没有开设店铺");
			return null;
		}
		List<String> shopIds = new ArrayList<>();
		for(MerchantUserRecord record : userRecords) {
			shopIds.add(record.getShopid().toString());
		}
		List<AgentShopResponseVo> agentShops = this.getAgentShopInfo(shopIds);
		return agentShops;
	}

}
