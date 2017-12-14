package com.bz.manage.service.deal;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bz.manage.model.test.Select;
import com.bz.manage.model.test.SelectW;

/**
 * 
 * 作者: 兰俊
 * 描述: 资金流水业务
 * 版本: version 1.0.0
 * 创建时间:2017年10月11日上午9:27:35
 */
@Service
public class BankrollService {

	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 查询店铺资金
	 * 创建时间:2017年10月10日下午6:28:24
	 * @return 店铺资金集合
	 */
	public List getBankrollAll() {
		
		return null;
		
	}

	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 查询资金流水详情
	 * 创建时间:2017年10月11日下午2:52:06
	 * @return 资金流水详情集合
	 */
	public List getCapitalFlow() {
		
		return null;
	}

	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 查询提现记录
	 * 创建时间:2017年10月11日下午3:02:01
	 * @return 提现记录集合
	 */
	public List getWithdrawals() {
		
		return null;
	}

	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 查询交易统计记录
	 * 创建时间:2017年10月11日下午3:09:25
	 * @return 交易统计记录集合
	 */
	public List getCount() {
		
		return null;
	}

	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 查询店铺交易记录
	 * 创建时间:2017年10月11日下午3:12:22
	 * @return 店铺交易记录集合
	 */
	public List getTrade() {
		
		return null;
	}

	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 根据查询条件查询店铺资金
	 * 创建时间:2017年10月11日下午5:00:24
	 * @return 店铺资金集合
	 */
	public List getBankrollAll(Select s) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 根据时间条件查询交易统计记录
	 * 创建时间:2017年10月11日下午6:10:32
	 * @return 交易统计记录集合
	 */
	public Object getCount(String start, String end) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 根据条件查询提现记录
	 * 创建时间:2017年10月12日下午5:05:16
	 * @return 提现记录集合
	 */
	public Object getWithdrawals(SelectW s) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * 作者: 兰俊
	 * 描述: 根据条件查询资金流水记录
	 * 创建时间:2017年10月12日下午5:19:56
	 * @return 资金流水集合
	 */
	public Object getCapitalFlow(Select s) {
		// TODO Auto-generated method stub
		return null;
	}
}
