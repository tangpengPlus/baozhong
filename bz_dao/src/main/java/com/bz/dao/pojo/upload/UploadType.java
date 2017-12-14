package com.bz.dao.pojo.upload;

import com.bz.framework.pojo.base.BasePojo;
import java.util.Date;

/**
	* 作者:唐鹏
	* 描述:
	* 版本: version 1.0.0
	* 时间:2017-09-30 16:59:44
  */
public class UploadType extends BasePojo {
    /**
     * 上传文件类型Id
     * 表字段 : system_upload_type.uploadTypeId
     */
    private Short uploadtypeid;

    /**
     * 名称
     * 表字段 : system_upload_type.title
     */
    private String title;

    /**
     * 是否删除：0未删除；1已删除
     * 表字段 : system_upload_type.isDelete
     */
    private Byte isdelete;

    /**
     * 创建时间
     * 表字段 : system_upload_type.createTime
     */
    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table system_upload_type
     *
     * @mbg.generated Sat Sep 30 16:59:44 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取 上传文件类型Id 字段:system_upload_type.uploadTypeId
     *
     * @return system_upload_type.uploadTypeId, 上传文件类型Id
     */
    public Short getUploadtypeid() {
        return uploadtypeid;
    }

    /**
     * 设置 上传文件类型Id 字段:system_upload_type.uploadTypeId
     *
     * @param uploadtypeid the value for system_upload_type.uploadTypeId, 上传文件类型Id
     */
    public void setUploadtypeid(Short uploadtypeid) {
        this.uploadtypeid = uploadtypeid;
    }

    /**
     * 获取 名称 字段:system_upload_type.title
     *
     * @return system_upload_type.title, 名称
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置 名称 字段:system_upload_type.title
     *
     * @param title the value for system_upload_type.title, 名称
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取 是否删除：0未删除；1已删除 字段:system_upload_type.isDelete
     *
     * @return system_upload_type.isDelete, 是否删除：0未删除；1已删除
     */
    public Byte getIsdelete() {
        return isdelete;
    }

    /**
     * 设置 是否删除：0未删除；1已删除 字段:system_upload_type.isDelete
     *
     * @param isdelete the value for system_upload_type.isDelete, 是否删除：0未删除；1已删除
     */
    public void setIsdelete(Byte isdelete) {
        this.isdelete = isdelete;
    }

    /**
     * 获取 创建时间 字段:system_upload_type.createTime
     *
     * @return system_upload_type.createTime, 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置 创建时间 字段:system_upload_type.createTime
     *
     * @param createtime the value for system_upload_type.createTime, 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}