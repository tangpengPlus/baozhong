package com.bz.agent.core.service.apply;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.internal.metadata.aggregated.ValidatableParametersMetaData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.bz.dao.mapper.agent.BzAuditMapper;
import com.bz.dao.mapper.agent.BzPersonalDetailsMapper;
import com.bz.dao.pojo.agent.BzAudit;
import com.bz.dao.pojo.agent.BzPersonalDetails;
import com.bz.framework.constant.result.ResultValueEnum;
import com.bz.framework.error.exception.AgentIndexException;
import com.bz.framework.pojo.base.BaseResult;
import com.bz.framework.util.date.DateUtil;
import com.bz.framework.util.validate.ValidateUtil;
import com.bz.open.core.service.agent.AgentApplyService;
import com.bz.open.core.service.map.AdministrativeAreaService;
import com.bz.open.core.service.sms.SmsMessageService;
import com.bz.open.core.service.weixin.WeixinToolsService;
import com.bz.open.core.vo.request.agent.AgentRegionRequestVo;

/**
 * 
 * @author 陈青山 时间 ：2017年11月20日 下午18：02 描述 ： 注册服务实现
 */
@Service(version = "1.0.0", interfaceClass = com.bz.open.core.service.agent.AgentApplyService.class)
@Transactional
public class AgentApplyServiceImp implements AgentApplyService {
	private Logger log = LoggerFactory.getLogger(AgentApplyServiceImp.class);
	@Reference(version = "1.0.0")
	private WeixinToolsService weixinToolsService;// 引用微信服务
	@Reference(version = "1.0.0")
	private SmsMessageService smsMessageService;// 短信接口
	@Autowired
	private BzAuditMapper bzAuditMapper;// 审核数据库接口
	@Autowired
	private BzPersonalDetailsMapper bzPersonalDetailsMapper;// 个人信息数据库接口
	@Reference(version = "1.0.0")
	private AdministrativeAreaService administrativeAreaService;// 地图接口
	// 此常量用于对比合伙人类型 1为业务合伙人
	private static final String TYPE_ONE = "1";
	// 此为村社合伙人类型
	private static final int TYPE_SIX = 6;
	// 此常量用于查询合伙人为空返回数值代表不通过或没有申请0正在审核1通过2没通过或没有此条数据
	private static final int STATE_ZERO = 0;
	private static final int STATE_ONE = 1;
	private static final int STATE_TWO = 2;
	// 代表参数错误
	private static final int STATE_THREE = 3;

	/**
	 * @作者 陈青山
	 * @param getSgrade
	 *            合伙人类型
	 * @param getUserName
	 *            名字
	 * @param getImPhone
	 *            手机
	 * @param getLegalCardId
	 *            身份证编号
	 * @param getAddress
	 *            详细地址
	 * @param region1
	 *            地区
	 * @param region2
	 *            地区
	 * @param region3
	 *            地区
	 * @param region4
	 *            地区
	 * @param getUserid
	 *            用户id
	 * @描述 合伙人注册服务
	 * @return
	 */
	@Transactional
	public BaseResult apply(AgentRegionRequestVo vo) throws AgentIndexException {
		log.info("合伙人注册服务开始  参数：【Sgrade】类型 ：" + vo.getSgrade() + " 【name】姓名 :" + vo.getUserName() + " 【imphone】电话 :"
				+ vo.getImPhone() + " 【LegalCardId】身份证 :" + vo.getLegalCardId() + " 【Address】详细地址 :" + vo.getAddress()
				+ " 【Region1】地址1 :" + vo.getRegion1() + " 【Region2】地址2 :" + vo.getRegion2() + " 【Region3】地址3 :"
				+ vo.getRegion3() + " 【Region4】地址4 :" + vo.getRegion4());
		BaseResult reBaseResult = BaseResult.newInstance();
		if (StringUtils.isEmpty(vo.getImPhone())) {
			log.error("合伙人注册参数  【电话  tel】为空");
			return reBaseResult.changeStatus(ResultValueEnum.AGENT_TELL_ERROR);
		}
		if (StringUtils.isEmpty(vo.getSgrade())) {
			log.error("合伙人注册参数  【类型  Sgrade】为空");
			return reBaseResult.changeStatus(ResultValueEnum.AGENT_SGRADE_ERROR);
		}
		if (StringUtils.isEmpty(vo.getLegalCardId())) {
			log.error("合伙人注册参数  【身份证号  legalCardId】为空");
			return reBaseResult.changeStatus(ResultValueEnum.AGENT_LEGALCARDID_ERROR);
		}
		if (ValidateUtil.isIdCardNo(vo.getLegalCardId())) {
			log.error("合伙人注册参数  【身份证号  legalCardId】为格式错误");
			return reBaseResult.changeStatus(ResultValueEnum.AGENT_LEGALCARDID_STYLE_ERROR);
		}
		if (StringUtils.isEmpty(vo.getUserName())) {
			log.error("合伙人注册参数 【 姓名  name】为空");
			return reBaseResult.changeStatus(ResultValueEnum.AGENT_USERNAME_ERROR);
		}
		if (vo.getSgrade() == "" + STATE_ONE && StringUtils.isEmpty(vo.getAddress())) {
			log.error("合伙人注册参数     【类型业务合伙人  地址  address】为空");
			return reBaseResult.changeStatus(ResultValueEnum.AGENT_DIZI_ERROR);
		}
		if (tellVail(vo.getImPhone()) == false) {
			log.error("合伙人注册参数    【手机号码格式错误】");
			return reBaseResult.changeStatus(ResultValueEnum.AGENT_TELL_ISERROR);
		}

		// 还需判断是不是业务合伙人 如是则详细地址为接收用户输入的值切地区编码为空
		BzPersonalDetails bzPersonalDetails = new BzPersonalDetails();
		// 设置名字
		bzPersonalDetails.setUsername(vo.getUserName());
		// 设置引用用户id
		bzPersonalDetails.setUserid(vo.getUserid());
		// 设置手机号
		bzPersonalDetails.setImphone(vo.getImPhone());
		// 设置身份证编码
		bzPersonalDetails.setLegalcardid(vo.getLegalCardId());
		// 设置合伙人类型
		bzPersonalDetails.setSgrade(Integer.parseInt(vo.getSgrade()));
		// 得到当前时间
		String dateString = DateUtil.getNowTime();
		// 设置时间
		bzPersonalDetails.setCreatetime(dateString);
		// 设置是否显示 0为显示1为不显示
		bzPersonalDetails.setIsdelete(0);
		// 数组
		if (vo.getSgrade().equals(TYPE_ONE) || vo.getSgrade().equals(TYPE_SIX)) {
			// 只设置详细地址，不设置编号
			log.info("当前用户申请的是业务合伙人或村社合伙人   【id】:" + vo.getUserid() + " 【姓名】:" + vo.getUserName() + "    只添加详细地址");
			bzPersonalDetails.setAddress(vo.getAddress());
		} else {
			String[] dizi = { vo.getRegion1(), vo.getRegion2(), vo.getRegion3(), vo.getRegion4() };
			// 判断是否可以注册
			if (!isHas(vo.getSgrade(), dizi)) {
				log.info("当前地区已被注册");
				return reBaseResult.changeStatus(ResultValueEnum.AGENT_UNREGISTER_ERROR);
			}
			// 设置详细地址串
			bzPersonalDetails.setAddress(address(dizi));
			// 设置地区编码
			bzPersonalDetails.setAgentaddress(agentAddress(dizi));
		}
		// 添加时需改sql语句 select last_insert
		log.info("添加个人信息");
		bzPersonalDetailsMapper.save(bzPersonalDetails);
		// 以上需得到添加数据的id
		// 开始向审核表添加数据
		BzAudit audit = new BzAudit();
		// 设置id引用个人信息表
		audit.setId(bzPersonalDetails.getId());
		// 0为在审核，1为通过，2为不通过
		audit.setState(0);
		// 设置时间
		audit.setCreatetime(dateString);
		log.info("添加审核消息");
		bzAuditMapper.save(audit);
		return reBaseResult;
	}

	/**
	 * @author 陈青山
	 * @miaoshu 查询此用户审核状态 0为审核1为通过2为不通过
	 * @param userid
	 *            用户id
	 * @param type
	 *            用户的合伙人类型
	 * @return
	 */
	public int ifPass(String userid, String type) throws AgentIndexException {
		log.info("查询此用户审核状态  参数：【userid】 ：" + userid + " 【type】 :" + type);
		if (StringUtils.isEmpty(userid) || StringUtils.isEmpty(type)) {
			log.info("判断是不是已经注册过   参数为空【用户id userid】" + userid + "【类型type】" + type);
			return STATE_THREE;
		}
		BzPersonalDetails per = new BzPersonalDetails();
		per.setUserid(userid);
		per.setSgrade(Integer.parseInt(type));
		List<BzPersonalDetails> selectList = bzPersonalDetailsMapper.selectList(per);
		for (BzPersonalDetails deta : selectList) {
			BzAudit selectById = bzAuditMapper.selectById(deta.getId());
			if (selectById.getState() == STATE_ONE) {
				log.info("查询此用户审核状态    通过");
				return STATE_ONE;
			} else if (selectById.getState() == STATE_ZERO) {
				log.info("查询此用户审核状态     正在审核");
				return STATE_ZERO;
			}
		}
		// 返回2 STATE_TWO代表返回页面 注册页面
		log.info("查询此用户审核状态 返回 ：STATE_TWO代表返回注册页面");
		return STATE_TWO;
	}

	/**
	 * @author 陈青山
	 * @miaoshu 判断当前地区是否已经申请过【"+type+"】种类型的合伙人
	 * @param type
	 *            合伙人类型
	 * @param vo
	 *            地区请求参数
	 * @return true为可以申请 已经测试
	 */
	public boolean isHas(String type, String dizi[]) {
		log.info("判断当前地区是否已经申请过第【" + type + "】种类型的合伙人" + "参数地址【dizi】" + "【" + dizi + "】");
		String agentAddress = agentAddress(dizi);
		int hasAgent = bzPersonalDetailsMapper.isHasAgent(type, agentAddress);
		if (hasAgent == 0) {
			return true;
		}
		return false;
	}

	/**
	 * @作者 陈青山
	 * @param dizi数组
	 *            得到的所有地区号
	 * @return 返回地址编码串
	 */
	public String agentAddress(String dizi[]) {
		log.info("拼接地址编码      参数【dizi数组】【" + dizi + "】");
		StringBuilder site = new StringBuilder();
		for (String s : dizi) {
			if (s != null && s != "") {
				site.append(s + ",");
			}
		}
		log.info("拼接完成        【" + site + "】");
		return site.toString();
	}

	/**
	 * @作者 陈青山
	 * @param dizi数组
	 *            得到的所有地区号
	 * @return 返回中文详细地址
	 */
	public String address(String dizi[]) {
		log.info("拼接详细地址            参数【dizi数组】【" + dizi + "】");
		StringBuilder site = new StringBuilder();
		for (String s : dizi) {
			if (s != null && s != "") {
				// 调用地区服务接口
				// 参数地区id
				site.append(administrativeAreaService.getSiteById(s));
			}
		}
		log.info("拼接完成   【" + site + "】");
		return site.toString();
	}

	/**
	 * @author 陈青山
	 * @miaoshu 正则表达式判断手机号码
	 * @param tell
	 * @return
	 */
	public boolean tellVail(String tell) {
		log.info(" 手机号验证   参数【tell】" + "【" + tell + "】");
		String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(tell);
		return m.matches();
	}

}
