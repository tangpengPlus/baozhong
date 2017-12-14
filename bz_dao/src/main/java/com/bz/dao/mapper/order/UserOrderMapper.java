package com.bz.dao.mapper.order;

import java.util.List;

import com.bz.dao.mapper.base.BaseMapper;
import com.bz.dao.pojo.order.OrderBase;

public interface UserOrderMapper extends BaseMapper<OrderBase>{

	List<OrderBase> selectAllUserOrder(Integer id);
}
