package com.bz.manage.service.system.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bz.manage.dao.base.BaseMapper;
import com.bz.manage.dao.sys.ManageOptionLogMapper;
import com.bz.manage.model.system.ManageOptionLog;
import com.bz.manage.service.base.impl.GenericServiceImp;
import com.bz.manage.service.system.SystemLogService;
@Service
public class SystemLogServiceImpl extends GenericServiceImp<ManageOptionLog> implements SystemLogService{
@Autowired
private ManageOptionLogMapper manageOptionLogMapper;
	@Override
	public BaseMapper<ManageOptionLog> getDao() {
		return manageOptionLogMapper;
	}

}
