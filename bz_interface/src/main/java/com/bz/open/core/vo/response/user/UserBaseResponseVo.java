package com.bz.open.core.vo.response.user;
import java.util.Date;

import com.bz.framework.pojo.base.BasePojo;

public class UserBaseResponseVo extends BasePojo{

	    /**
	     * 用户ID
	     * 表字段 : user_base.id
	     */
	    private Integer id;

	    /**
	     * 推送标识
	     * 表字段: pushid
	     */
	    private String pushid;
	    
	    /**
		 * @return the pushid
		 */
		public String getPushid() {
			return pushid;
		}

		/**
		 * @param pushid the pushid to set
		 */
		public void setPushid(String pushid) {
			this.pushid = pushid;
		}

		/**
	     * 用户编号
	     * 表字段 : user_base.number
	     */
	    private String number;

	    /**
	     * 用户名称
	     * 表字段 : user_base.name
	     */
	    private String name;

	    /**
	     * 
	     * 表字段 : user_base.weChatOpenId
	     */
	    private String wechatopenid;

	    /**
	     * 微信头像
	     * 表字段 : user_base.weChatImage
	     */
	    private String wechatimage;

	    /**
	     * 创建时间
	     * 表字段 : user_base.createTime
	     */
	    private Date createtime;

	    
	    /**
	     * This field was generated by MyBatis Generator.
	     * This field corresponds to the database table user_base
	     *
	     * @mbg.generated Wed Nov 01 19:28:08 CST 2017
	     */
	    private static final long serialVersionUID = 1L;

	    /**
	     * 获取 用户ID 字段:user_base.id
	     *
	     * @return user_base.id, 用户ID
	     */
	    public Integer getId() {
	        return id;
	    }

	    /**
	     * 设置 用户ID 字段:user_base.id
	     *
	     * @param id the value for user_base.id, 用户ID
	     */
	    public void setId(Integer id) {
	        this.id = id;
	    }

	    /**
		 * @return the number
		 */
		public String getNumber() {
			return number;
		}

		/**
		 * @param number the number to set
		 */
		public void setNumber(String number) {
			this.number = number;
		}

		/**
	     * 获取 用户名称 字段:user_base.name
	     *
	     * @return user_base.name, 用户名称
	     */
	    public String getName() {
	        return name;
	    }

	    /**
	     * 设置 用户名称 字段:user_base.name
	     *
	     * @param name the value for user_base.name, 用户名称
	     */
	    public void setName(String name) {
	        this.name = name == null ? null : name.trim();
	    }

	    /**
	     * 获取  字段:user_base.weChatOpenId
	     *
	     * @return user_base.weChatOpenId, 
	     */
	    public String getWechatopenid() {
	        return wechatopenid;
	    }

	    /**
	     * 设置  字段:user_base.weChatOpenId
	     *
	     * @param wechatopenid the value for user_base.weChatOpenId, 
	     */
	    public void setWechatopenid(String wechatopenid) {
	        this.wechatopenid = wechatopenid == null ? null : wechatopenid.trim();
	    }

	    /**
	     * 获取 微信头像 字段:user_base.weChatImage
	     *
	     * @return user_base.weChatImage, 微信头像
	     */
	    public String getWechatimage() {
	        return wechatimage;
	    }

	    /**
	     * 设置 微信头像 字段:user_base.weChatImage
	     *
	     * @param wechatimage the value for user_base.weChatImage, 微信头像
	     */
	    public void setWechatimage(String wechatimage) {
	        this.wechatimage = wechatimage == null ? null : wechatimage.trim();
	    }

	    /**
	     * 获取 创建时间 字段:user_base.createTime
	     *
	     * @return user_base.createTime, 创建时间
	     */
	    public Date getCreatetime() {
	        return createtime;
	    }

	    /**
	     * 设置 创建时间 字段:user_base.createTime
	     *
	     * @param createtime the value for user_base.createTime, 创建时间
	     */
	    public void setCreatetime(Date createtime) {
	        this.createtime = createtime;
	    }
	
}
