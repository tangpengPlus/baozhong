package com.bz.framework.constant.manage;

import com.bz.framework.constant.base.BaseEnum;

/**
 * 
 * 作者:唐鹏
 * 创建时间:2017年10月17日下午5:58:55
 * 描述:管理平台枚举
 * 备注:
 */
public class ManageServiceEnum {

	/**
	 * 
	 * 作者:唐鹏
	 * 创建时间:2017年10月17日下午6:00:14
	 * 描述:构造管理平台页面常量枚举类
	 * 备注:
	 */
	public enum PageSettingEnum implements BaseEnum<Integer>{
		MANAGE_BASE_PAGE_SIZE(10,"管理平台页面每页显示大小");
		private Integer key;
		private String message;
		
		private  PageSettingEnum(Integer key,String message) {
			this.key=key;
			this.message=message;
		}
		
		@Override
		public Integer getKey() {
			
			return this.key;
		}

		@Override
		public String getTitle() {
			
			return this.message;
		}
		public String toString() {
			return "[key="+key+",title="+message+"]";
		}
		
		
	}
}
