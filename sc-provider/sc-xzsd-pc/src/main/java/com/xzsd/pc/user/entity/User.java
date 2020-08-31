package com.xzsd.pc.user.entity;
/**
 * @Description 用户实体类
 * @Author zhonghecheng
 * @Date 2020-03-24
 */
public class User {
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户账号
     */
    private String userAccount;
    /**
     * 用户密码
     */
    private String userPass;
    /**
     * 用户身份证
     */
    private String userIdCard;
    /**
     *用户性别
     */
    private int userSex;
    /**
     *用户角色
     */
    private String userRole;
    /**
     * 用户电话
     */
    private String userTel;

    /**
     * 用户手机
     */
    private String userPhone;
    /**
     * 用户积分
     */
    private int userIntegral;
    /**
     * 用户邮箱
     */
    private String userEmail;
    /**
     * 用户是否删除
     */
    private int isDelete;
    /**
     * 默认头像
     */
    private String defaultImageUrl;
    /**
     * 创建作者
     */
    private String createUser;
    /**
     * 更新作者
     */
    private String updateUser;
    /**
     * 版本
     */
    /**
     * 当前页数
     */
    private int pageSize;
    /**
     * 每页显示条数
     */
    private int pageNum;
    /**
     * 版本号
     */
    private int version;

    private String userJudgeExamine;

    public String getUserJudgeExamine() {
        return userJudgeExamine;
    }

    public void setUserJudgeExamine(String userJudgeExamine) {
        this.userJudgeExamine = userJudgeExamine;
    }

    public String getDefaultImageUrl() {
        return defaultImageUrl;
    }

    public void setDefaultImageUrl(String defaultImageUrl) {
        this.defaultImageUrl = defaultImageUrl;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserIdCard() {
        return userIdCard;
    }

    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getUserIntegral() {
        return userIntegral;
    }

    public void setUserIntegral(int userIntegral) {
        this.userIntegral = userIntegral;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "User{" +
                "userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userIdCard='" + userIdCard + '\'' +
                ", userSex=" + userSex +
                ", userRole=" + userRole +
                ", userTel='" + userTel + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userIntegral=" + userIntegral +
                ", userEmail='" + userEmail + '\'' +
                ", isDelete=" + isDelete +
                ", createUser='" + createUser + '\'' +
                ", updateUser='" + updateUser + '\'' +
                ", pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                ", version=" + version +
                '}';
    }
}
