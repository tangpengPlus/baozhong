package com.bz.merchant.core.service.member;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.bz.dao.mapper.merchant.MerchantUserRecordMapper;
import com.bz.dao.pojo.merchant.MerchantUserRecord;
import com.bz.framework.error.exception.MerchantException;
import com.bz.framework.util.exception.BzfAssert;
import com.bz.open.core.service.merchant.MerchantMemberService;
/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年11月2日下午5:57:41
 * 描述:商家会员开放服务实现
 * 备注:
 */
@Service(version="1.0.0",interfaceClass=com.bz.open.core.service.merchant.MerchantMemberService.class)
@Transactional
public class MerchantMemberServiceImpl implements MerchantMemberService{
    private final Logger logger=LoggerFactory.getLogger(MerchantMemberServiceImpl.class);
	@Autowired
	private MerchantUserRecordMapper merchantUserRecordMapper;
	
	/**
	 * 
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年11月2日下午4:57:50
	 * 描述:判断当前用户是否是该店的新会员
	 * 备注:
	 * @param userId
	 * @param merchantId
	 * @return
	 * @throws MerchantException
	 */
    @Override
	public boolean isNewMember(Integer userId, Integer merchantId) throws MerchantException {
		logger.info("判断当前用户【userId】{}是否为当前商家【merchantId】的新用户",userId,merchantId);
		BzfAssert.isNull(MerchantException.class, userId, "用户Id为null");
		BzfAssert.isNull(MerchantException.class, merchantId, "商户Id为null");
		MerchantUserRecord merchantUserRecord=new MerchantUserRecord();
		merchantUserRecord.setUserid(userId);
		merchantUserRecord.setShopid(merchantId);
		MerchantUserRecord merchantUserRecords=	merchantUserRecordMapper.selectOne(merchantUserRecord);
		logger.info("获得的店铺会员记录信息:"+merchantUserRecords);
		return merchantUserRecords==null?true:false;
	}

    /**
	 * 
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年11月2日下午5:42:46
	 * 描述:增加商户的会员记录
	 * 备注:
	 * @param userId
	 * @param merchantId
	 * @throws MerchantException
	 */
	@Override
	public void addMerchantMember(Integer userId, Integer merchantId) throws MerchantException {
		logger.info("增加【userId】{}为商家【merchantId】的新用户",userId,merchantId);
		BzfAssert.isNull(MerchantException.class, userId, "用户Id为null");
		BzfAssert.isNull(MerchantException.class, merchantId, "商户Id为null");
		MerchantUserRecord merchantUserRecord=new MerchantUserRecord();
		merchantUserRecord.setCreatetime(new Date());
		merchantUserRecord.setUserid(userId);
		merchantUserRecord.setShopid(merchantId);
		merchantUserRecordMapper.save(merchantUserRecord);
	}

}
