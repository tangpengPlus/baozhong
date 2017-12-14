package com.bz.manage.service.statistics.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bz.manage.dao.base.BaseMapper;
import com.bz.manage.model.test.DataTest;
import com.bz.manage.service.base.impl.GenericServiceImp;
import com.bz.manage.service.statistics.StatisticsService;

@Service
@Transactional
public class StatisticsServiceImpl extends GenericServiceImp<DataTest> implements StatisticsService{

	@Override
	public BaseMapper<DataTest> getDao() {
		// TODO Auto-generated method stub
		return null;
	}

}
