package com.ibiz.api.model;

import java.util.List;

public class AccountVO {

    /**
     * 사용자 ID
     */
    private String userId;

    /**
     * 고객ID
     */
    private String custId;

    /**
     * 사용자 암호
     */
    private String pswd;

    /**
     * 소속부서 ID
     */
    private String deptId;

    /**
     * EMP ID
     */
    private String empId;

    /**
     * 이름
     */
    private String userNm;

    /**
     * 직위 코드
     */
    private String ofpsCd;

    /**
     * 직책 코드
     */
    private String resoCd;

    /**
     * 직위명
     */
    private String ofpsNm;

    /**
     * 직책명
     */
    private String resoNm;

    /**
     * 소속부서명
     */
    private String deptNm;

    /**
     * 사용자권한정보
     */
    private List<String> roleList;

    /**
     * 사용자 로그인 정보
     */
    private LoginVO loginVO;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getUserNm() {
        return userNm;
    }

    public void setUserNm(String userNm) {
        this.userNm = userNm;
    }

    public String getOfpsCd() {
        return ofpsCd;
    }

    public void setOfpsCd(String ofpsCd) {
        this.ofpsCd = ofpsCd;
    }

    public String getResoCd() {
        return resoCd;
    }

    public void setResoCd(String resoCd) {
        this.resoCd = resoCd;
    }

    public String getOfpsNm() {
        return ofpsNm;
    }

    public void setOfpsNm(String ofpsNm) {
        this.ofpsNm = ofpsNm;
    }

    public String getResoNm() {
        return resoNm;
    }

    public void setResoNm(String resoNm) {
        this.resoNm = resoNm;
    }

    public String getDeptNm() {
        return deptNm;
    }

    public void setDeptNm(String deptNm) {
        this.deptNm = deptNm;
    }

    public List<String> getRoleList() { return roleList; }

    public void setRoleList(List<String> roleList) { this.roleList = roleList; }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }


    public LoginVO getLoginVO() {
        return loginVO;
    }

    public void setLoginVO(LoginVO loginVO) {
        this.loginVO = loginVO;
    }

    @Override
    public String toString() {
        return "AccountVO [ userId=" + userId + ", custId=" + custId + ", pswd=" + pswd + ", deptId="
                + deptId + ", empId=" + empId + ", userNm=" + userNm + ", ofpsCd="
                + ofpsCd + ", resoCd=" + resoCd + ", ofpsNm=" + ofpsNm + ", resoNm=" + resoNm
                + ", deptNm=" + deptNm + ", roleList=" + roleList + "]";
    }
}
