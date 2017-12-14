package com.bz.framework.error.exception;

import com.bz.framework.constant.base.BaseEnum;
import com.bz.framework.error.exception.BzBaseException;
/**
 * 
 * @author 陈青山
 * @TIME 2017年11月18日 下午15：46
 * @MIAOSHU 合伙人首页异常
 *
 */
public class AgentIndexException extends BzBaseException{

	public AgentIndexException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AgentIndexException(BaseEnum<Integer> ExceptionEnum, String message) {
		super(ExceptionEnum, message);
		// TODO Auto-generated constructor stub
	}

	public AgentIndexException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public AgentIndexException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public AgentIndexException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
