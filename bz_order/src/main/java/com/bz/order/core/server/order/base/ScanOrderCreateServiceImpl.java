package com.bz.order.core.server.order.base;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.bz.framework.error.exception.OrderException;
import com.bz.framework.util.base.BaseUtil;
import com.bz.framework.util.base.IntegerUtil;
import com.bz.framework.util.date.DateUtil;
import com.bz.open.core.service.merchant.MerchantRedCouponService;
import com.bz.open.core.service.order.ScanOrderCreateService;
import com.bz.open.core.service.user.RedCouponService;
import com.bz.open.core.vo.request.order.ScanCodeOrderRequestVo;
import com.bz.open.core.vo.request.user.UserRedpacketWareHouseRequestVo;
import com.bz.open.core.vo.response.order.ScanOrderResponseVo;
import com.bz.framework.constant.order.OrderEnum.OrderSource;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.bz.dao.mapper.order.OrderBaseMapper;
import com.bz.dao.pojo.order.OrderBase;
import com.bz.dao.pojo.user.UserRedpacketWarehouse;
import com.bz.framework.constant.exception.BzExceptionEnum.OrderExceptionEnum;
import com.bz.framework.constant.order.OrderEnum.OrderStateEnum;
/**
 * 
 * 
 * 作者:唐鹏
 * 创建时间:2017年10月27日上午11:28:08
 * 描述:扫码订单服务
 * 备注:
 * @param <T>
 */
@Service(version="1.0.0",interfaceClass=com.bz.open.core.service.order.ScanOrderCreateService.class)
public  class ScanOrderCreateServiceImpl implements ScanOrderCreateService{
	
    private final Logger logger=LoggerFactory.getLogger(ScanOrderCreateServiceImpl.class);
    
    public static final String HMACSHA256 = "HMAC-SHA256";
    public static final String MD5 = "MD5";
    
    @Value("${order.create.overtime}")
	private long overTime;//订单请求超时时间
    
    @Reference(version="1.0.0")
    private RedCouponService redCouponService;
    @Reference(version="1.0.0")
	private MerchantRedCouponService merchantRedCouponService;
    @Autowired
    private OrderBaseMapper orderBaseMapper;
	@Override
	public  ScanOrderResponseVo createOrder(ScanCodeOrderRequestVo orderVo) throws OrderException {
		logger.info("创建扫码订单请求参数ScanCodeOrderRequestVo:{}",orderVo);
		//验证订单合法性
		checkCreateOrderBaseInfo(orderVo);
		//产生订单编号
		String orderNumber=createOrderNumber(OrderSource.SCAN_CODE_ORDER, orderVo.getMerchantId(), orderVo.getUserId());
		logger.info("生成的订单编号是:【"+orderNumber+"】");
		orderVo.setOrderNumber(orderNumber);
		//优惠券使用检查
	    checkUserCoupon(orderVo);
		//产生订单对象
	    OrderBase base=changeObj(orderVo);
	    try {
	    	logger.info("创建扫码订单【六】扫码订单信息入库");
	    	orderBaseMapper.save(base);
		} catch (Exception e) {
			logger.error("创建扫码订单:订单入库失败",e);
			throw new OrderException(OrderExceptionEnum.ORDER_CREATE_FALILE, "订单入库失败");
		}
	    ScanOrderResponseVo vo=new ScanOrderResponseVo();
	    vo.setOrderNo(orderNumber);
	    vo.setOrderSign(base.getSignstr());
	    vo.setPayMoney(orderVo.getPayMoney());
		return vo;
	}

	/**
	 * 
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年10月31日上午11:21:55
	 * 描述:订单编号产生
	 * 备注:订单产生规则:当前时间戳+商户编号+用户编号+随机码 927385534748295168
	 * @param orderSource orderSource {@link OrderSource} 订单前缀枚举
	 * @param merchantId 商户编号	
	 * @param userId 用户编号
	 * @return 订单编号
	 */
	protected synchronized  String createOrderNumber(OrderSource orderSource,Integer merchantId,Integer userId) {
		logger.info("创建扫码订单【二】创建扫码订单订单编号");
		String currentTimeStr=DateUtil.getCurryTimeStr();
		String merchantNumber=BaseUtil.createNumber(merchantId.toString());
		String userNumber=BaseUtil.createNumber(userId.toString());
		//String randomCode=BzCodeGenerate.getSysNumber();
		return orderSource.getKey()+currentTimeStr.substring(0, 9)+merchantNumber+userNumber+currentTimeStr.substring(10, 12);
	}
	/**
	 * 
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年11月1日上午11:04:37
	 * 描述:检查优惠券如果使用优惠券将该优惠券进行锁定
	 * 备注:
	 * @param orderVo
	 * @return
	 */
   public boolean checkUserCoupon(ScanCodeOrderRequestVo orderVo) {
	   logger.info("创建扫码订单【三】检查红包使用合法性");
	   if(orderVo.isUseCashCoupon()){
		   if(IntegerUtil.isEmpty(orderVo.getCashCoupon())) {
			    logger.error("订单创建失败:使用红包券支付时:参数对象【ScanCodeOrderVo】属性【cashCoupon】参数为空");
				throw new OrderException(OrderExceptionEnum.ORDER_CREATE_PARM_NULL,"订单创建失败:使用红包券支付时:参数对象【ScanCodeOrderVo】属性【cashCoupon】参数为空");
		   }
		 boolean ok=redCouponService.isCanUseCurryRedpacket(orderVo.getUserId(), orderVo.getCashCoupon());
	     if(ok) {
	    	 //根据用户红包券Id获取红包券的设置信息
	    	 UserRedpacketWarehouse deductible=new UserRedpacketWarehouse();
	    	 deductible.setId(orderVo.getCashCoupon());
	    	 UserRedpacketWareHouseRequestVo userRedpacketWareHouseRequestVo=new UserRedpacketWareHouseRequestVo();
	    	 try {
				BeanUtils.copyProperties(userRedpacketWareHouseRequestVo, deductible);
			} catch (IllegalAccessException e) {
				logger.error("bean类型转换错误,【deductible:"+deductible+"】转换成【userRedpacketWareHouseRequestVo:"+userRedpacketWareHouseRequestVo+"】");
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				logger.error("bean类型转换错误,【deductible:"+deductible+"】转换成【userRedpacketWareHouseRequestVo:"+userRedpacketWareHouseRequestVo+"】");
				e.printStackTrace();
			}
	    	 //判断当前优惠券使用金额 是否正常
	 		 if(merchantRedCouponService.checkRedCouponAmount(orderVo.getTotalMoney(),orderVo.getCashCouponMoney(), deductible.getRpid(), orderVo.getUserId())) {
	 			 //锁定用户当前红包券不能让其他线程使用
	 			redCouponService.lockUserCoupon(orderVo.getCashCoupon());
	 			return true;
	 		 }else {
	 			logger.error("订单创建异常:使用优惠券失败");
		    	throw new OrderException(OrderExceptionEnum.ORDER_CREATE_FALILE,"订单创建异常:当前优惠券折扣金额计算错误");
	 		 }
	     
	     }else {
	    	logger.error("订单创建异常:使用优惠券失败");
	    	throw new OrderException(OrderExceptionEnum.ORDER_CREATE_FALILE,"订单创建异常:当前优惠券不能使用");
	     }
	   }
	   return true;
   }  
   /**
    * 
    * 
    * 作者:唐鹏
    * 创建时间:2017年11月1日下午3:34:12
    * 描述:对象转换
    * 备注:
    * @param scanCodeOrderVo
    * @return
    */
   protected OrderBase changeObj(ScanCodeOrderRequestVo scanCodeOrderVo) {
	   logger.info("创建扫码订单【四】组装订单入库数据");
	   OrderBase orderBase=new OrderBase();
	   /*设置订单编号*/
	   orderBase.setOrderno(scanCodeOrderVo.getOrderNumber());
	   /*设置用户Id*/
	   orderBase.setUserid(scanCodeOrderVo.getUserId());
	   /*设置商户Id*/
	   orderBase.setShopid(scanCodeOrderVo.getMerchantId());
	   /*设置订单总额*/
	   orderBase.setTatolmoney(scanCodeOrderVo.getTotalMoney());
	   /*设置线上支付总额*/
	   orderBase.setOnlinepaymoney(scanCodeOrderVo.getPayMoney());
	   /*设置线线下支付总额*/
	   orderBase.setOfflinepaymoney(new BigDecimal("0.00"));
	   /*设置活动抵用金额*/
	   orderBase.setActivitypaymoney(scanCodeOrderVo.getCashCouponMoney());
	   /*设置积分抵用金额*/
	   orderBase.setIntegralpaymoney(new BigDecimal("0.00"));
	   /*设置支付状态*/
	   orderBase.setPaystate(OrderStateEnum.ORDER_INIT_STATE.getKey());
	   /*设置支付方式*/
	   orderBase.setPayway(scanCodeOrderVo.getPayWay().getKey());
	   /*设置支付备注*/
	   orderBase.setPayremark("扫码支付订单");
	   /*设置订单初始化时间*/
	   orderBase.setCreatetime(new Date());
	   /*设置是否隐藏；0：展示；1：隐藏*/
	   orderBase.setIsshow(0);
	   /*设置订单类型 订单类型;1：扫码订单；2网店订单*/
	   orderBase.setOrdertype(1);
	   /*设置扫码二维码地址*/
	   orderBase.setQrcodelink(scanCodeOrderVo.getQrCodeLink());
	   /*设置客户端IP*/
	   orderBase.setClientip(scanCodeOrderVo.getRequestIp());
	   /*设置签名字符串*/
	   orderBase.setSignstr(getCurryOrderSign(scanCodeOrderVo.getOrderNumber()));
	   return orderBase;
   }
   
   /**
    * 
    *  作者:唐鹏
    *  描述:生产订单的唯一签名
    *  备注:
    *  创建时间:2017年11月15日下午4:00:14
    *  @param orderNo:订单编号
    *  @return 订单签名
    */
   protected String getCurryOrderSign(String orderNo) {
	   logger.info("创建扫码订单【五】生成订单唯一签名字符串");
	   try {
		return HMACSHA256(orderNo, getGenerateNonceStr());
	} catch (Exception e) {
	    logger.error("订单创建失败:生产订单签名错误",e);
		e.printStackTrace();
	}
	   return "";
   }
   
   /**
	 * 
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年11月3日下午2:48:52
	 * 描述:生成随机签名字符串
	 * 备注:
	 * @return
	 */
	protected String getGenerateNonceStr() {
		return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
	}
	
	
    
    /**
     * 生成 HMACSHA256生成签名
     * @param data 待处理数据
     * @param key 密钥
     * @return 加密结果
     * @throws Exception
     */
    public static String HMACSHA256(String data, String key) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        byte[] array = sha256_HMAC.doFinal(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();
    }
    
    /**
     * 
     *  作者:唐鹏
     *  描述:订单基本信息验证
     *  备注:
     *  创建时间:2017年11月15日下午4:09:20
     *  @param orderVo:扫码订单请求封装
     */
    public void checkCreateOrderBaseInfo(ScanCodeOrderRequestVo orderVo) {
    	         logger.info("创建扫码订单【一】验证请求扫码订单参数合法性");
    			if(StringUtils.isEmpty(orderVo.getRequestIp())){
    				logger.error("订单创建失败:参数对象【BaseOrderVo】属性【requestIp】为空");
    				throw new OrderException(OrderExceptionEnum.ORDER_CREATE_PARM_NULL, "订单创建失败:参数对象【BaseOrderVo】属性【requestIp】为空");
    			}
    			if(IntegerUtil.isEmpty(orderVo.getUserId())) {
    				logger.error("订单创建失败:参数对象【BaseOrderVo】属性【userId】为空");
    				throw new OrderException(OrderExceptionEnum.ORDER_CREATE_PARM_NULL, "订单创建失败:参数对象【BaseOrderVo】属性【userId】为空");
    			}
    			if(IntegerUtil.isEmpty(orderVo.getMerchantId())){
    				logger.error("订单创建失败:参数对象【BaseOrderVo】属性【merchantId】为空");
    				throw new OrderException(OrderExceptionEnum.ORDER_CREATE_PARM_NULL, "订单创建失败:参数对象【BaseOrderVo】属性【merchantId】为空");
    			}
    			//判断时间戳的合法性
    			if(!DateUtil.isTimeStr(orderVo.getRequestTimeStr())){
    				logger.error("订单创建失败:参数对象【BaseOrderVo】属性【requestTimeStr】格式错误");
    				throw new OrderException(OrderExceptionEnum.ORDER_CREATE_PARM_FORMAT_ERROR, "订单创建失败:参数对象【BaseOrderVo】属性【requestTimeStr】格式错误");
    			}
    			//判断请求时间戳与当前时间的对比若大于则订单超时
    			if(DateUtil.isTimeOut(orderVo.getRequestTimeStr(), overTime)) {
    				logger.error("订单创建失败:请求超时");
    				throw new OrderException(OrderExceptionEnum.ORDER_CREATE_TIME_OUT, "订单创建失败:请求超时");
    			}
    			//判断当前的支付方式
    			if(null==orderVo.getPayWay()) {
    				logger.error("订单创建失败:参数对象【BaseOrderVo】属性【yayWay】支付方式为null");
    				throw new OrderException(OrderExceptionEnum.ORDER_CREATE_PARM_NULL, "订单创建失败:参数对象【BaseOrderVo】属性【yayWay】支付方式为null");
    			}
    			//判断当前金额是否正常
    			if(orderVo.getPayMoney()==null||orderVo.getPayMoney().signum()!=1) {
    				logger.error("订单创建失败:参数对象【BaseOrderVo】属性【payMoney】支付金额异常");
    				throw new OrderException(OrderExceptionEnum.ORDER_CREATE_PARM_NULL, "订单创建失败:参数对象【BaseOrderVo】属性【payMoney】支付金额异常");
    			}
    }
}
