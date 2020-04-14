package com.xzsd.app.storeInvest.entity;

public class InvestCode {
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 邀请码
     */
    private String invitationCode;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }
}
