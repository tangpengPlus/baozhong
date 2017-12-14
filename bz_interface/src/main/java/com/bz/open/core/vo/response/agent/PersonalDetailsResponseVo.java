package com.bz.open.core.vo.response.agent;

/**
 * 
 * 作者: 兰俊
 * 描述: 合伙人信息返回信息封装
 * 创建时间:2017年11月22日上午11:50:53
 * 修改备注:
 */
public class PersonalDetailsResponseVo {

    /**
     * id
     * 表字段 : bz_personal_details.id
     */
    private Integer id;

    /**
     * 使用者id
     * 表字段 : bz_personal_details.userId
     */
    private String userid;

    /**
     * 用户名称
     * 表字段 : bz_personal_details.userName
     */
    private String username;

    /**
     * 合伙人类型
     * 表字段 : bz_personal_details.sgrade
     */
    private Integer sgrade;

    /**
     * 详细地址
     * 表字段 : bz_personal_details.address
     */
    private String address;

    /**
     * 身份证编号
     * 表字段 : bz_personal_details.legalCardId
     */
    private String legalcardid;

    /**
     * 电话
     * 表字段 : bz_personal_details.imTel
     */
    private String imtel;

    /**
     * 手机
     * 表字段 : bz_personal_details.imPhone
     */
    private String imphone;

    /**
     * 电子邮箱
     * 表字段 : bz_personal_details.imEmail
     */
    private String imemail;

    /**
     * 作为营业员是否可以查看合伙人收入项
     * 表字段 : bz_personal_details.ifShow
     */
    private Integer ifshow;

    /**
     * 创建时间
     * 表字段 : bz_personal_details.createTime
     */
    private String createtime;

    /**
     * 代理人地址
     * 表字段 : bz_personal_details.agentAddress
     */
    private String agentaddress;

    /**
     * 是否显示
     * 表字段 : bz_personal_details.isDelete
     */
    private Integer isdelete;

    /**
     * 获取 id 字段:bz_personal_details.id
     *
     * @return bz_personal_details.id, id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 id 字段:bz_personal_details.id
     *
     * @param id the value for bz_personal_details.id, id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 使用者id 字段:bz_personal_details.userId
     *
     * @return bz_personal_details.userId, 使用者id
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置 使用者id 字段:bz_personal_details.userId
     *
     * @param userid the value for bz_personal_details.userId, 使用者id
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 获取 用户名称 字段:bz_personal_details.userName
     *
     * @return bz_personal_details.userName, 用户名称
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置 用户名称 字段:bz_personal_details.userName
     *
     * @param username the value for bz_personal_details.userName, 用户名称
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取 合伙人类型 字段:bz_personal_details.sgrade
     *
     * @return bz_personal_details.sgrade, 合伙人类型
     */
    public Integer getSgrade() {
        return sgrade;
    }

    /**
     * 设置 合伙人类型 字段:bz_personal_details.sgrade
     *
     * @param sgrade the value for bz_personal_details.sgrade, 合伙人类型
     */
    public void setSgrade(Integer sgrade) {
        this.sgrade = sgrade;
    }

    /**
     * 获取 详细地址 字段:bz_personal_details.address
     *
     * @return bz_personal_details.address, 详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置 详细地址 字段:bz_personal_details.address
     *
     * @param address the value for bz_personal_details.address, 详细地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取 身份证编号 字段:bz_personal_details.legalCardId
     *
     * @return bz_personal_details.legalCardId, 身份证编号
     */
    public String getLegalcardid() {
        return legalcardid;
    }

    /**
     * 设置 身份证编号 字段:bz_personal_details.legalCardId
     *
     * @param legalcardid the value for bz_personal_details.legalCardId, 身份证编号
     */
    public void setLegalcardid(String legalcardid) {
        this.legalcardid = legalcardid;
    }

    /**
     * 获取 电话 字段:bz_personal_details.imTel
     *
     * @return bz_personal_details.imTel, 电话
     */
    public String getImtel() {
        return imtel;
    }

    /**
     * 设置 电话 字段:bz_personal_details.imTel
     *
     * @param imtel the value for bz_personal_details.imTel, 电话
     */
    public void setImtel(String imtel) {
        this.imtel = imtel;
    }

    /**
     * 获取 手机 字段:bz_personal_details.imPhone
     *
     * @return bz_personal_details.imPhone, 手机
     */
    public String getImphone() {
        return imphone;
    }

    /**
     * 设置 手机 字段:bz_personal_details.imPhone
     *
     * @param imphone the value for bz_personal_details.imPhone, 手机
     */
    public void setImphone(String imphone) {
        this.imphone = imphone;
    }

    /**
     * 获取 电子邮箱 字段:bz_personal_details.imEmail
     *
     * @return bz_personal_details.imEmail, 电子邮箱
     */
    public String getImemail() {
        return imemail;
    }

    /**
     * 设置 电子邮箱 字段:bz_personal_details.imEmail
     *
     * @param imemail the value for bz_personal_details.imEmail, 电子邮箱
     */
    public void setImemail(String imemail) {
        this.imemail = imemail;
    }

    /**
     * 获取 作为营业员是否可以查看合伙人收入项 字段:bz_personal_details.ifShow
     *
     * @return bz_personal_details.ifShow, 作为营业员是否可以查看合伙人收入项
     */
    public Integer getIfshow() {
        return ifshow;
    }

    /**
     * 设置 作为营业员是否可以查看合伙人收入项 字段:bz_personal_details.ifShow
     *
     * @param ifshow the value for bz_personal_details.ifShow, 作为营业员是否可以查看合伙人收入项
     */
    public void setIfshow(Integer ifshow) {
        this.ifshow = ifshow;
    }

    /**
     * 获取 创建时间 字段:bz_personal_details.createTime
     *
     * @return bz_personal_details.createTime, 创建时间
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * 设置 创建时间 字段:bz_personal_details.createTime
     *
     * @param createtime the value for bz_personal_details.createTime, 创建时间
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取 代理人地址 字段:bz_personal_details.agentAddress
     *
     * @return bz_personal_details.agentAddress, 代理人地址
     */
    public String getAgentaddress() {
        return agentaddress;
    }

    /**
     * 设置 代理人地址 字段:bz_personal_details.agentAddress
     *
     * @param agentaddress the value for bz_personal_details.agentAddress, 代理人地址
     */
    public void setAgentaddress(String agentaddress) {
        this.agentaddress = agentaddress;
    }

    /**
     * 获取 是否显示 字段:bz_personal_details.isDelete
     *
     * @return bz_personal_details.isDelete, 是否显示
     */
    public Integer getIsdelete() {
        return isdelete;
    }

    /**
     * 设置 是否显示 字段:bz_personal_details.isDelete
     *
     * @param isdelete the value for bz_personal_details.isDelete, 是否显示
     */
    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}
