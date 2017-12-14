package com.bz.open.core.vo.response.message;

import java.util.Date;

import com.bz.framework.pojo.base.BasePojo;

public class UserMessageResponseVo extends BasePojo{
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -1038863548485155229L;

	/**
     * 推送消息ID
     * 表字段 : user_message.id
     */
    private Integer id;

    /**
     * 用户ID
     * 表字段 : user_message.userid
     */
    private Integer userid;

    /**
     * 推送消息标题
     * 表字段 : user_message.title
     */
    private String title;

    /**
     * 推送消息内容
     * 表字段 : user_message.content
     */
    private String content;

    /**
     * 私有消息;0：私有消息,1:公有消息
     * 表字段 : user_message.isprivately
     */
    private Integer isprivately;

    /**
     * 创建时间
     * 表字段 : user_message.createtime
     */
    private Date createtime;
    
    /**
     * 店铺名称
     */
    private String merchantName;
    
    /**
     * 店铺图片
     */
    private String merchantImage;
    
    /**
	 * @return the merchantImage
	 */
	public String getMerchantImage() {
		return merchantImage;
	}

	/**
	 * @param merchantImage the merchantImage to set
	 */
	public void setMerchantImage(String merchantImage) {
		this.merchantImage = merchantImage;
	}

	/**
	 * @return the merchantName
	 */
	public String getMerchantName() {
		return merchantName;
	}

	/**
	 * @param merchantName the merchantName to set
	 */
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	/**
     * 获取 推送消息ID 字段:user_message.id
     *
     * @return user_message.id, 推送消息ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 推送消息ID 字段:user_message.id
     *
     * @param id the value for user_message.id, 推送消息ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 用户ID 字段:user_message.userid
     *
     * @return user_message.userid, 用户ID
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 设置 用户ID 字段:user_message.userid
     *
     * @param userid the value for user_message.userid, 用户ID
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 获取 推送消息标题 字段:user_message.title
     *
     * @return user_message.title, 推送消息标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置 推送消息标题 字段:user_message.title
     *
     * @param title the value for user_message.title, 推送消息标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取 推送消息内容 字段:user_message.content
     *
     * @return user_message.content, 推送消息内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置 推送消息内容 字段:user_message.content
     *
     * @param content the value for user_message.content, 推送消息内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取 私有消息;0：私有消息,1:公有消息 字段:user_message.isprivately
     *
     * @return user_message.isprivately, 私有消息;0：私有消息,1:公有消息
     */
    public Integer getIsprivately() {
        return isprivately;
    }

    /**
     * 设置 私有消息;0：私有消息,1:公有消息 字段:user_message.isprivately
     *
     * @param isprivately the value for user_message.isprivately, 私有消息;0：私有消息,1:公有消息
     */
    public void setIsprivately(Integer isprivately) {
        this.isprivately = isprivately;
    }

    /**
     * 获取 创建时间 字段:user_message.createtime
     *
     * @return user_message.createtime, 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置 创建时间 字段:user_message.createtime
     *
     * @param createtime the value for user_message.createtime, 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
