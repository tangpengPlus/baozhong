package com.bz.openweb.core.service.merchant;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.alibaba.dubbo.config.annotation.Reference;
import com.bz.framework.constant.result.ResultValueEnum;
import com.bz.framework.constant.upload.UploadBusinessType;
import com.bz.framework.constant.upload.UploadFileFormat;
import com.bz.framework.error.exception.MerchantException;
import com.bz.framework.pojo.base.BaseResult;
import com.bz.framework.util.exception.BzfAssert;
import com.bz.framework.util.number.BzCodeGenerate;
import com.bz.framework.util.validate.ValidateUtil;
import com.bz.open.core.service.map.AdministrativeAreaService;
import com.bz.open.core.service.merchant.MerchantGoodsCategoryService;
import com.bz.open.core.service.merchant.MerchantServiceInitService;
import com.bz.open.core.service.merchant.MerchantShopRegistService;
import com.bz.open.core.service.sms.SmsMessageService;
import com.bz.open.core.service.upload.UploadOpenService;
import com.bz.open.core.service.weixin.WeixinMessageService;
import com.bz.open.core.service.weixin.WeixinToolsService;
import com.bz.open.core.vo.request.merchant.MerchantServerInitVo;
import com.bz.open.core.vo.request.merchant.MerchantShopRequestVo;
import com.bz.open.core.vo.request.sms.SmsMessageRequest;
import com.bz.open.core.vo.request.upload.UploadFileRequestVo;
import com.bz.open.core.vo.request.weixin.WeixinMassMessageRequest;
import com.bz.open.core.vo.response.merchant.MerchantGoodsCategoryResponse;
import com.bz.open.core.vo.response.merchant.MerchantShopResponseVo;
import com.bz.open.core.vo.response.regin.ReginResponsVo;
import com.bz.openweb.core.model.merchant.MerchantRegistRequest;
import com.bz.openweb.core.model.merchant.MerchantRegistResponse;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

/**
 * 
 * 
 * 作者: 彭云山
 * 描述:商铺申请调用远程服务接口
 * 创建时间:2017年11月9日上午10:35:31
 * 修改备注:
 */
@Service
public class MerchantRegistService{

	@Value("${server.clientNo}")
	private String apiClientNo;
	
	@Reference(version="1.0.0")
	private MerchantGoodsCategoryService cateService;
	
	/*文件服务*/
	@Reference(version="1.0.0")
	private UploadOpenService uploadOpenService;
	
	/*调用地图服务*/
	@Reference(version="1.0.0")
	private AdministrativeAreaService administrativeAreaService;
	
	/*微信工具服务*/
	@Reference(version="1.0.0")
	private WeixinToolsService weixinToolsService;
	
	/*商铺注册服务接口*/
	@Reference(version="1.0.0")
	private MerchantShopRegistService merchantShopService;
	
	/*微信消息服务*/
	@Reference(version="1.0.0")
	private WeixinMessageService weixinMessageService;
	
	/*初始化商家功能项*/
	@Reference(version="1.0.0")
	private MerchantServiceInitService merchantServiceInitService;
	
	
	/*初始化商家功能项*/
	@Reference(version="1.0.0")
	private SmsMessageService smsMessageService;
	
	private final Logger logger = LoggerFactory.getLogger(MerchantRegistService.class);
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月8日下午3:20:18
	 * 描述:商家注册商铺
	 * @param merchantRegistRequest
	 * @return
	 */
	public BaseResult<MerchantRegistResponse> registMerchant(MerchantRegistRequest merchantRegistRequest) throws MerchantException{
		logger.info("商家注册服务实现【一】验证基础信息MerchantRegistRequest：{}",merchantRegistRequest);
		//初始化返回结果封装
		BaseResult<MerchantRegistResponse> reBaseResult=BaseResult.newInstance();
		//注册判断
		if(merchantRegistRequest==null) {
			reBaseResult.changeStatus(ResultValueEnum.MERCHANT_REGIST_REQUEST_ERROR);
			return reBaseResult;
		}
		if(StringUtils.isEmpty(merchantRegistRequest.getPhone())) {
			reBaseResult.changeStatus(ResultValueEnum.MERCHANT_REGIST_PHONENULL_ERROR);
			return reBaseResult;
		}
		if(StringUtils.isEmpty(merchantRegistRequest.getSmsCode())) {
			reBaseResult.changeStatus(ResultValueEnum.MERCHANT_REGIST_VALIDCODE_ERROR);
			return reBaseResult;
		}
		if(!smsMessageService.isTrueVerificationCode(merchantRegistRequest.getPhone(),merchantRegistRequest.getSmsCode())) {
			logger.error("输入的短信验证码错误");
			return reBaseResult.changeStatus(ResultValueEnum.MERCHANT_REGIST_SMSCODE_ERROR);
		}
		if(StringUtils.isEmpty(merchantRegistRequest.getName())) {
			logger.error("申请商家的名字为空");
			return reBaseResult.changeStatus(ResultValueEnum.MERCHANT_REGIST_PARM_ERROR);
		}
		if(merchantRegistRequest.getName().length()>200) {
			logger.error("申请商家的名字长度超过限制");
			return reBaseResult.changeStatus(ResultValueEnum.MERCHANT_REGIST_MAXPARM_ERROR);
		}
		
		if(StringUtils.isEmpty(merchantRegistRequest.getStreetLevel()+"")) {
			logger.error("用户返回的商家街道Id为空");
			return reBaseResult.changeStatus(ResultValueEnum.MERCHANT_REGIST_STREETID_ERROR);
		}
		
		if(StringUtils.isEmpty(merchantRegistRequest.getDetailaddress()) ) {
			logger.error("申请商家的详细地址未填写");
			return reBaseResult.changeStatus(ResultValueEnum.MERCHANT_REGIST_ADDRESS_ERROR);
		}
		if(merchantRegistRequest.getDetailaddress().length()>500 && merchantRegistRequest.getDetailaddress().length()<10) {
			logger.error("申请商家的详细地址字数超限 长度为:"+merchantRegistRequest.getDetailaddress().length());
			return reBaseResult.changeStatus(ResultValueEnum.MERCHANT_REGIST_MAXADDRESS_ERROR);
		}
		if(StringUtils.isEmpty(merchantRegistRequest.getOpenId())) {
			logger.error("没有得到申请商家的用户的openID");
			return reBaseResult.changeStatus(ResultValueEnum.SYS_ERROR);
		}
		if(StringUtils.isEmpty(merchantRegistRequest.getCoordinate())) {
			logger.error("商家申请的商铺经纬度为空");
			return reBaseResult.changeStatus(ResultValueEnum.SYS_ERROR);
		}
		//上传文件信息获取返回Id
	    logger.info("商家注册服务实现【二】上传商家提交的文件信息");
		
		if(StringUtils.isEmpty(merchantRegistRequest.getShopdetailimage())) {
			logger.error("未上传商家logo");
			return reBaseResult.changeStatus(ResultValueEnum.MERCHANT_REGIST_NOT_UPLOAD_INVATED_IMAGE);
		}
		
		boolean idCardsImageUploadState=true;//是否上传了身份证照片 默认为是
		boolean businessImageUploadState=true;//是否上传了营业执照 默认是
		if(StringUtils.isEmpty(merchantRegistRequest.getFrontidcardimg())||StringUtils.isEmpty(merchantRegistRequest.getBackidcardimg())) {
			idCardsImageUploadState=false;
		}
		if(StringUtils.isEmpty(merchantRegistRequest.getLicenseimage())) {
			businessImageUploadState=false;
		}
		if(!idCardsImageUploadState&&!businessImageUploadState) {
			logger.error("商家上传的身份证和营业执照为空");
			return reBaseResult.changeStatus(ResultValueEnum.MERCHANT_REGIST_FRONTIMG_ERROR);
		}
		
	    return reBaseResult;
	}
	/**
	 * 
	 *  作者:唐鹏
	 *  描述:获取网页授权Token
	 *  备注:
	 *  创建时间:2017年11月22日上午11:53:26
	 *  @param code
	 *  @return
	 */
	public WxMpOAuth2AccessToken getTokenByCode(String code) {
		
		WxMpOAuth2AccessToken token=	weixinToolsService.getWxMpOAuth2AccessToken(code);
	
	   return token;
	}
	
	
	public String getRedirctUrl(String url) {
		return weixinToolsService.mpOAuth2(url);
	}
	/**
	 * 
	 *  作者:唐鹏
	 *  描述:获取微信用户基本信息
	 *  备注:
	 *  创建时间:2017年11月22日上午11:56:07
	 *  @param code
	 *  @return
	 */
	public WxMpUser getUserInfo(String code) {
		WxMpOAuth2AccessToken token=getTokenByCode(code);
		WxMpUser user=	weixinToolsService.getWxMpUser(token);
		return user;
	}
	 
	
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月24日上午10:32:52
	 * 描述:根据用户上传的图片ID得到地址，并保存到本地
	 * @param registRequest {@link registRequest}用户填写的商家信息
	 */
	@Async("merchant-image-task")
	public BaseResult<MerchantRegistResponse> exqueMerchantImage(MerchantRegistRequest merchantRegistRequest) {
		logger.info("处理商家图片信息");
		BaseResult<MerchantRegistResponse> reBaseResult=BaseResult.newInstance();
		//上传图片信息
		UploadFileRequestVo uploadVo = new UploadFileRequestVo();
		uploadVo.setAipNo(apiClientNo);
		uploadVo.setFileSuffixName(".jpg");
		
		
		uploadVo.setUploadBusinessType(UploadBusinessType.SHOP_VIEW);
		//获得店铺logo图片文件
		long logoImageId=0;
		long shopdetailimageId=0;
		
		try {
			logoImageId=uploadOpenService.uploadWxImage(uploadVo, merchantRegistRequest.getShopLogoImage()).getId();
		} catch (Exception e) {
			logger.error("上传商铺门头照错误");
			return reBaseResult.changeStatus(ResultValueEnum.MERCHANT_REGIST_SHOPLOGO_IMAGE);
		}
		
		//获得店铺实拍图片文件
		try {
			shopdetailimageId=uploadOpenService.uploadWxImage(uploadVo, merchantRegistRequest.getShopdetailimage()).getId();
		} catch (Exception e) {
			logger.error("上传店铺实拍图片错误",e);
			return reBaseResult.changeStatus(ResultValueEnum.MERCHANT_REGIST_SHOPDETAILI_IMAGE);
		}
		
		
		//身份证正面照
		long idCardsPositiveImage = 0;
		//身份证反面照
		long idCardsBackImage= 0;
		//营业执照
		long businessLicenseImage= 0;
		
		boolean idCardsImageUploadState=true;//是否上传了身份证照片 默认为是
		boolean businessImageUploadState=true;//是否上传了营业执照 默认是
		if(StringUtils.isEmpty(merchantRegistRequest.getFrontidcardimg())||StringUtils.isEmpty(merchantRegistRequest.getBackidcardimg())) {
			idCardsImageUploadState=false;
		}
		if(StringUtils.isEmpty(merchantRegistRequest.getLicenseimage())) {
			businessImageUploadState=false;
		}
		
		if(idCardsImageUploadState) {
			try {
				idCardsPositiveImage=uploadOpenService.uploadWxImage(uploadVo, merchantRegistRequest.getFrontidcardimg()).getId();
				idCardsBackImage=uploadOpenService.uploadWxImage(uploadVo, merchantRegistRequest.getBackidcardimg()).getId();
			}catch (Exception e) {
				logger.error("上传身份证图片错误");
				return reBaseResult.changeStatus(ResultValueEnum.MERCHANT_REGIST_IDCARD_IMAGE);
			}
			
		}
		if(businessImageUploadState) {
			try {
				businessLicenseImage=uploadOpenService.uploadWxImage(uploadVo, merchantRegistRequest.getLicenseimage()).getId();
			} catch (Exception e) {
				logger.error("上传营业执照图片错误");
				return reBaseResult.changeStatus(ResultValueEnum.MERCHANT_REGIST_BUSINESSLICENSEIMAGE);
			}
			
		}
		MerchantShopRequestVo shop = new MerchantShopRequestVo();
		shop.setFrontidcardimg(idCardsPositiveImage+"");//身份证正面
		shop.setBackidcardimg(idCardsBackImage+"");
		shop.setShopfacadeimage(logoImageId+"");
		shop.setShopdetailimage(shopdetailimageId+"");
		shop.setLicenseimage(businessLicenseImage+"");//营业执照
		shop.setId(merchantRegistRequest.getShopId());
		//更新店铺图片信息
		try {
			merchantShopService.updateMerchantShop(shop);
		}catch (Exception e) {
			logger.error("商铺存储错误");
			return reBaseResult.changeStatus(ResultValueEnum.SYS_ERROR);
		}
		return reBaseResult;
		}
	
	/**
	 * 
	 *  作者:唐鹏
	 *  描述:发送微信文本消息给微信用户
	 *  备注:
	 *  创建时间:2017年11月22日下午2:11:26
	 *  @param openId {@link openId} 用的的openID
	 *  @param merchantName {@link merchantName}用户填写的商铺名称
	 */
	@Async("mass-message")
	public BaseResult<MerchantRegistResponse> sendMeessageToMerchant(String openId,String merchantName) {
		logger.info("商家注册服务实现【六】发送微信消息给当前注册商家opendId:{}","");
		
		BaseResult<MerchantRegistResponse> reBaseResult=BaseResult.newInstance();
		
		WeixinMassMessageRequest message = new WeixinMassMessageRequest();
		
		message.setWeixinUserOpenId(openId);
	    message.setSendToOne(true);
	    message.setCount("您申请的店铺名称:\""+merchantName+"\"已提交审核"
	    		+ "，我们将在三个工作日内给你答复");
	    try {
	    	weixinMessageService.sendTextMessage(message);
	    }catch (Exception e) {
			logger.error("发送微信信息失败",e);
			return reBaseResult.changeStatus(ResultValueEnum.MERCHANT_REGIST_SENDWXMESSAGE_ERROR);
		}
	    return reBaseResult;
	}
	
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月14日下午9:38:06
	 * 描述:短信发送
	 * @param telPhone {@link telPhone} 用户填写的电话号码
	 * @return
	 */
	public boolean sendMessage(String telPhone) {
		logger.info("调用服务，验证电话号码是否正确，并向{}发送短信",telPhone);
		if(ValidateUtil.isMobilePhoneNum(telPhone)==false) {
			return false;
		}
		SmsMessageRequest smsMessage = new SmsMessageRequest();
		smsMessage.setTelPhone(telPhone);
		smsMessage.setSendOne(true);
		smsMessage.setCodeEndTime(300000);
		try {
			smsMessageService.sendVerificationMessage(smsMessage);
		}catch (Exception e) {
			logger.error("发送短信失败",e);
			return false;
		}
		
		return true;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月22日下午7:59:39
	 * 描述:获取所有的等级为1的城市列表
	 * @return
	 */
	public Map<Integer,String> getRegin(){
		List<ReginResponsVo> reginList= new ArrayList<ReginResponsVo>();
		reginList = administrativeAreaService.getProvinceLeveRegion();
		Map<Integer,String> getLevelOne = new HashMap<>();
		for(ReginResponsVo region:reginList) {
			getLevelOne.put(region.getId(), region.getName());
		}
		return getLevelOne;
	}
	
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月23日下午1:38:36
	 * 描述:根据Id获取下级城市列表
	 * @param id
	 * @return
	 */
	public Map<Integer,String> getSubordinateRegionById(Integer id) {
		logger.info("根据ID:{}获取下级城市列表",id);
		List<ReginResponsVo> reginList= new ArrayList<ReginResponsVo>();
		try {
			reginList = administrativeAreaService.getSubordinateRegionById(id+"");
		} catch (Exception e) {
			logger.error("获取下级城市列表失败",e);
			return null;
		}
		Map<Integer,String> getNextLevel = new HashMap<>();
		for(ReginResponsVo region:reginList) {
			getNextLevel.put(region.getId(), region.getName());
		}
		return getNextLevel;
	}
	
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月27日下午4:46:42
	 * 描述:根据ID获取下级商品列表
	 * @param id
	 * @return
	 */
	public Map<Integer,String> getNextCateGoods(Integer id){
		logger.info("根据ID:{}获取下级商品列表",id);
		List<MerchantGoodsCategoryResponse> cateList = new ArrayList<MerchantGoodsCategoryResponse>();
		try {
			cateList=cateService.getNextCategory(id);
		} catch (Exception e) {
			logger.error("获取商品下级错误");
			return null;
		}
		Map<Integer,String> getNextLevel = new HashMap<>();
		for(MerchantGoodsCategoryResponse cate:cateList) {
			getNextLevel.put(cate.getId(), cate.getName());
		}
		return getNextLevel;
	}
	
	
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月27日下午4:37:49
	 * 描述:获取商铺分类的一级分类
	 * @return
	 */
	public Map<Integer,String> getCateOneLevel(){
		logger.info("获取商铺分类的一级分类");
		List<MerchantGoodsCategoryResponse> catesVo = new ArrayList<MerchantGoodsCategoryResponse>();
		
		Map<Integer,String> levelOneCate = new HashMap<>();
		try {
			catesVo = cateService.getOneCategory();
		} catch (Exception e) {
			logger.error("获取商品分类的一级分类错误");
			return null;
		}
		for(MerchantGoodsCategoryResponse cates:catesVo) {
			levelOneCate.put(cates.getId(), cates.getName());
		}
		return levelOneCate;
	}
	
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月23日下午2:53:28
	 * 描述:增加商铺
	 * @return
	 */
	@SuppressWarnings("unlikely-arg-type")
	public BaseResult<MerchantRegistResponse> addMerchantShop(MerchantRegistRequest merchantRegistRequest) {
		logger.info("增加申请商铺：{}",merchantRegistRequest);
		BzfAssert.isNull(MerchantException.class, merchantRegistRequest,"用户传入的商家封装参数【merchantRegistRequest】为null");
		BaseResult<MerchantRegistResponse> reBaseResult=BaseResult.newInstance();
		
		reBaseResult = registMerchant(merchantRegistRequest);
		if(!(reBaseResult.equals(ResultValueEnum.SYS_OK))) {
			return reBaseResult;
		}
		//商户信息入库
		logger.info("商家注册服务实现【四】设置商家基本信息，并调用商家添加服务");
		//店铺
		MerchantShopRequestVo shop = new MerchantShopRequestVo();
		shop.setNumber(BzCodeGenerate.getSysNumber());//编号
		shop.setName(merchantRegistRequest.getName());//商铺名称
		logger.info("商家注册服务实现【五】设置商家地理位置行政区域编码");
		//获取街道ID
		String regionlevecode = merchantRegistRequest.getStreetLevel()+"";
		shop.setRegionlevecode(regionlevecode);//区编码
		//获取区县ID
		String citylevecode =getUpLevel(regionlevecode)+"";
		shop.setCitylevecode(citylevecode);//市编码
		//获得省.市编码
		shop.setProvincelevecode(getUpLevel(citylevecode)+"");//省编码
		
		shop.setDetailaddress(merchantRegistRequest.getDetailaddress());
		shop.setCoordinate(merchantRegistRequest.getCoordinate());
		shop.setPhone(merchantRegistRequest.getPhone());
		shop.setVerifyremark(merchantRegistRequest.getVerifyRemark());
		shop.setWechatopenid(merchantRegistRequest.getOpenId());
		//初始化商家基本项
		shop.setCreatetime(new Date());
		//合作类型:1:扫码支付；2：线上开店；3线上线下共存
		shop.setCooperationtype(1);
		//审核状态；0：待审核；1：审核成功;2：审核失败
		shop.setIsverify(0);
		//上线状态;0:未上线;1::已经上线;2:已经下线
		shop.setOnlinestate(0);
		
		Integer merchantId=null;
		try {
			merchantId=merchantShopService.addMerchantShop(shop);
		} catch (Exception e) {
			logger.error("商家注册服务实现【四】设置商家基本信息，调用商家添加服务失败");
			e.printStackTrace();
			reBaseResult.changeStatus(ResultValueEnum.MERCHANT_REGIST_ADDBASEDATA_ERROR);
		}
		logger.info("商家注册服务实现【四】设置商家基本信息,数据入库后的Id:{}",merchantId);
		
		//商家图片信息
		merchantRegistRequest.setShopId(merchantId);
		
		exqueMerchantImage(merchantRegistRequest);
		
		logger.info("商家注册服务实现【五】初始化商家功能项");
		MerchantServerInitVo merchantOpenStauts=new MerchantServerInitVo();
	    merchantOpenStauts.setMerchantId(merchantId);
	    merchantServiceInitService.initMerchantServer(merchantId);
	    //发送微信消息给商户
	    sendMeessageToMerchant(merchantRegistRequest.getOpenId(), merchantRegistRequest.getName());
        return reBaseResult;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月27日下午4:57:42
	 * 描述:根据ID获取上级城市ID
	 * @param id {@link id} 下级城市ID
	 * @return
	 */
	public Integer getUpLevel(String id) {
		logger.info("获取id:{}的上级编码",id);
		Integer upLevel = null;
		try {
			upLevel = administrativeAreaService.getUpLevel(Integer.parseInt(id));
		} catch (Exception e) {
			logger.error("获取省级编码错误",e);
		}
		return upLevel;
	}
	
	
	
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月23日下午2:27:09
	 * 描述:根据ID查询需要修改的merchantShop的信息
	 * @param id {@link id} 修改商铺的ID
	 * @return
	 */
	public BaseResult<MerchantRegistRequest> selectOneMerchantShop(Integer id) {
		
		logger.info("查询ID为：{}的商铺信息",id);
		BaseResult<MerchantRegistRequest> reBaseResult=BaseResult.newInstance();
		if(StringUtils.isEmpty(id+"")) {
			logger.error("获取的ID错误，请重新进入");
			return reBaseResult.changeStatus(ResultValueEnum.MERCHANT_REGIST_MERCHANTGRTID_ERROR);
		}
		MerchantShopResponseVo merchant = new MerchantShopResponseVo();
		try {
			merchant=merchantShopService.selectMerchantShopById(id);
		}catch (Exception e) {
			logger.error("查询商家服务异常",e);
			reBaseResult.changeStatus(ResultValueEnum.MERCHANT_REGIST_MERCHANTSERVER_ERROR);
		}
		MerchantRegistRequest request = new MerchantRegistRequest();
		//设置基本信息
		request.setOpenId(merchant.getWechatopenid());
		request.setNumber(merchant.getNumber());
		request.setName(merchant.getName());
		request.setPhone(merchant.getPhone());
		request.setProvincelevecode(merchant.getProvincelevecode());//省市
		request.setCitylevecode(merchant.getCitylevecode());//区
		request.setRegionlevecode(merchant.getRegionlevecode());//街道
		request.setVerifyRemark(merchant.getVerifyremark());
		request.setDetailaddress(merchant.getDetailaddress());
		request.setBelongmerchantid(merchant.getBelongmerchantid());
		//设置图片信息
		request.setLicenseimage(merchant.getLicenseimage());
		request.setShopLogoImage(merchant.getShopfacadeimage());
		request.setShopdetailimage(merchant.getShopdetailimage());
		request.setFrontidcardimg(merchant.getFrontidcardimg());
		request.setBackidcardimg(merchant.getBackidcardimg());
		//设置图片路径信息
		//营业执照
		if(merchant.getLicenseimage()==null || merchant.getLicenseimage()=="" || merchant.getLicenseimage().equals("0")) {
			request.setLicenseimagePath("");
		}else {
			request.setLicenseimagePath(getWxImageUrl(merchant.getLicenseimage()));
		}
		
		//店铺眉头照地址
		request.setShopLogoImagePath(getWxImageUrl(merchant.getShopfacadeimage()));
		//店铺实拍地址
		request.setShopdetailImagePath(getWxImageUrl(merchant.getShopdetailimage()));
		//身份份证地址
		if(getWxImageUrl(merchant.getFrontidcardimg()) == null || getWxImageUrl(merchant.getFrontidcardimg())=="" ||getWxImageUrl(merchant.getFrontidcardimg()).equals("0")) {
			request.setFrontidcardImgPath("");
			request.setBackidcardImgPath("");
		}else {
			request.setFrontidcardImgPath(getWxImageUrl(merchant.getFrontidcardimg()));
			request.setBackidcardImgPath(getWxImageUrl(merchant.getBackidcardimg()));
		}
		
		
		reBaseResult.setData(request);
		return reBaseResult;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月24日上午9:50:14
	 * 描述:获取微信图片地址通用方法
	 * @param ImageId
	 * @return
	 */
	public String getWxImageUrl(String ImageId) {
		logger.info(ImageId);
		String url = uploadOpenService.getUrl(Long.parseLong(ImageId), UploadFileFormat.USER_MIN);
		return url;
	}
	/**
	 * 
	 * 作者:彭云山
	 * 创建时间:2017年11月23日下午3:46:54
	 * 描述:修改商铺信息
	 * @param merchantRegistRequest {@link merchantRegistRequest}商家修改的商铺信息
	 * @return
	 */
	@SuppressWarnings("unlikely-arg-type")
	public BaseResult<MerchantRegistResponse> updateMerchantShop(MerchantRegistRequest merchantRegistRequest) {
		logger.info("商家修改的商铺merchantRegistRequest信息为：{}",merchantRegistRequest);
		
		//验证商家ID
		BzfAssert.isNull(MerchantException.class, merchantRegistRequest,"用户传入的商家封装参数【merchantRegistRequest】为null");
		
		
		BaseResult<MerchantRegistResponse> reBaseResult=BaseResult.newInstance();
		reBaseResult = registMerchant(merchantRegistRequest);
		if(!(reBaseResult.equals(ResultValueEnum.SYS_OK))) {
			return reBaseResult;
		}
		//商户信息入库
		logger.info("商家注册服务实现【三】设置商家基本信息，并调用商家添加服务");
		//店铺
		MerchantShopRequestVo updshop = new MerchantShopRequestVo();
		updshop.setName(merchantRegistRequest.getName());//商铺名称
		logger.info("商家注册服务实现【四】设置商家地理位置行政区域编码");
		
		//获取街道ID
		String regionlevecode = merchantRegistRequest.getStreetLevel()+"";
		updshop.setRegionlevecode(regionlevecode);//区编码
		//获取区县ID
		String citylevecode =getUpLevel(regionlevecode)+"";
		updshop.setCitylevecode(citylevecode);//市编码
		//获得省.市编码
		updshop.setProvincelevecode(getUpLevel(citylevecode)+"");//省编码
		
		updshop.setDetailaddress(merchantRegistRequest.getDetailaddress());
		updshop.setCoordinate(merchantRegistRequest.getCoordinate());
		updshop.setPhone(merchantRegistRequest.getPhone());
		updshop.setWechatopenid(merchantRegistRequest.getOpenId());
		//审核状态；0：待审核；1：审核成功;2：审核失败
		updshop.setIsverify(0);
		//上线状态;0:未上线;1:已经上线;2:已经下线
		updshop.setOnlinestate(0);
		try {
			merchantShopService.updateMerchantShop(updshop); 
		}catch (Exception e) {
			logger.error("商家修改服务实现【五】设置商家基本信息，调用商家修改服务失败");
			e.printStackTrace();
			reBaseResult.changeStatus(ResultValueEnum.MERCHANT_REGIST_UPDATEMERCHANT_ERROR);
		}
		exqueMerchantImage(merchantRegistRequest);
		sendMeessageToMerchant(merchantRegistRequest.getOpenId(), merchantRegistRequest.getName());
        return reBaseResult;
	}
}
