package com.ibiz.api.model;

public class LoginVO {

    private String userId;

    private String password;

    /**
     * 사용자 아이디
     */
    private String UID;

    /**
     * 비밀번호
     */
    private String PWD;

    /**
     * return url
     */
    private String returnUrl;

    /**
     * 로그인 정보 저장 체크 유무
     */
    private boolean rememberMe;

    /**
     * 접속일시
     */
    private String cnntDt;

    /**
     * IPV4 주소
     */
    private String ipv4Adrs;

    /**
     * 접속시스템프로그램ID
     */
    private String cnntSysPgmId;

    /**
     * 호출 url
     */
    private String clngSysScrnUrl;

    public String getUID() {
        return UID;
    }

    public void setUID(String uID) {
        UID = uID;
    }

    public String getPWD() {
        return PWD;
    }

    public void setPWD(String pWD) {
        PWD = pWD;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public String getCnntDt() {
        return cnntDt;
    }

    public void setCnntDt(String cnntDt) {
        this.cnntDt = cnntDt;
    }

    public String getIpv4Adrs() {
        return ipv4Adrs;
    }

    public void setIpv4Adrs(String ipv4Adrs) {
        this.ipv4Adrs = ipv4Adrs;
    }

    public String getCnntSysPgmId() {
        return cnntSysPgmId;
    }

    public void setCnntSysPgmId(String cnntSysPgmId) {
        this.cnntSysPgmId = cnntSysPgmId;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClngSysScrnUrl() {
        return clngSysScrnUrl;
    }

    public void setClngSysScrnUrl(String clngSysScrnUrl) {
        this.clngSysScrnUrl = clngSysScrnUrl;
    }

}
