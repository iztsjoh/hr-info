package com.ibiz.api.model;

public class DeptVO {
    /**
     * 부서 아이디
     */
    private String deptId;

    /**
     * 부서명
     */
    private String deptNm;

    /**
     * Cost Center 코드
     */
    private String ccCd;

    /**
     * 부서분류 코드
     */
    private String orgDstCd;

    /**
     * 부서분류 코드명
     */
    private String orgDstCdNm;

    /**
     * 상위부서 아이디
     */
    private String hgrkDeptId;

    /**
     * 부서 정렬 순서
     */
    private String deptSortSeqc;

    /**
     * 소속사 코드 (인젠트, 콤텍)
     */
    private String bltcCd;

    /**
     * 부서 레벨 코드
     */
    private String deptLvlCd;

    /**
     * 부서장 사원 ID
     */
    private String hddpEmpId;
    /**
     * 부서 생성일자
     */
    private String crtDate;

    /**
     * 부서 폐쇄 일자
     */
    private String closeDate;

    /**
     * 매출발생부서여부
     */
    private String sellOcrYn;

    /**
     * 등록사원 ID
     */
    private String regEmpId;

    /**
     * 등록일시
     */
    private String regDt;

    /**
     * 변경사원 ID
     */
    private String chgEmpId;

    /**
     * 변경일시
     */
    private String chgDt;

    /**
     * 그리드의 입력(C) 수정(U) 삭제(D) 상태
     */
    private String gridStatus;

    /**
     * 검색값
     */
    private String searchValue;

    /**
     * 조건검색시 표시제한할 부서들
     */
    private String deptIds;

    /**
     * 하위부서 카운팅
     */
    private Integer cntLowerDeptID;

    /**
     * 부서 레벨(정렬)
     */
    private Integer depthLevel;

    /**
     * 하위부서(자식) 갯수
     */
    private Integer lowerCnt;

    /**
     * 상위부서명
     */
    private String hgrkDeptNm;

    /**
     * 영업대표(권한체크를 위해 추가됨)
     */
    private String slsEmpId;

    /**
     * 시스템사용자(권한체크를 위해 추가됨)
     */
    private String empId;

    /**
     * 사용자그룹(권한체크를 위해 추가됨)
     */
    private String userGrpCd;

    /**
     * 토탈사이즈(권한체크를 위해 추가됨)
     */
    private Integer totalSize;

    private String isAllAuth;

    /**
     * userGrpCd를 기준으로 부서를 조회하나 우선 적용될 userGrpCd가 필요할 시에 사용
     */
    private String priorUserGrpCd;

    /**
     * 기준연도
     */
    private String critYear;

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptNm() {
        return deptNm;
    }

    public void setDeptNm(String deptNm) {
        this.deptNm = deptNm;
    }

    public String getCcCd() {
        return ccCd;
    }

    public void setCcCd(String ccCd) {
        this.ccCd = ccCd;
    }

    public String getHgrkDeptId() {
        return hgrkDeptId;
    }

    public void setHgrkDeptId(String hgrkDeptId) {
        this.hgrkDeptId = hgrkDeptId;
    }

    public String getDeptSortSeqc() {
        return deptSortSeqc;
    }

    public void setDeptSortSeqc(String deptSortSeqc) {
        this.deptSortSeqc = deptSortSeqc;
    }

    public String getBltcCd() {
        return bltcCd;
    }

    public void setBltcCd(String bltcCd) {
        this.bltcCd = bltcCd;
    }

    public String getDeptLvlCd() {
        return deptLvlCd;
    }

    public void setDeptLvlCd(String deptLvlCd) {
        this.deptLvlCd = deptLvlCd;
    }

    public String getHddpEmpId() {
        return hddpEmpId;
    }

    public void setHddpEmpId(String hddpEmpId) {
        this.hddpEmpId = hddpEmpId;
    }

    public String getCrtDate() {
        return crtDate;
    }

    public void setCrtDate(String crtDate) {
        this.crtDate = crtDate;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }


    public String getSellOcrYn() {
        return sellOcrYn;
    }

    public void setSellOcrYn(String sellOcrYn) {
        this.sellOcrYn = sellOcrYn;
    }

    public String getRegEmpId() {
        return regEmpId;
    }

    public void setRegEmpId(String regEmpId) {
        this.regEmpId = regEmpId;
    }

    public String getRegDt() {
        return regDt;
    }

    public void setRegDt(String regDt) {
        this.regDt = regDt;
    }

    public String getChgEmpId() {
        return chgEmpId;
    }

    public void setChgEmpId(String chgEmpId) {
        this.chgEmpId = chgEmpId;
    }

    public String getChgDt() {
        return chgDt;
    }

    public void setChgDt(String chgDt) {
        this.chgDt = chgDt;
    }

    public String getGridStatus() {
        return gridStatus;
    }

    public void setGridStatus(String gridStatus) {
        this.gridStatus = gridStatus;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(String deptIds) {
        this.deptIds = deptIds;
    }

    public Integer getCntLowerDeptID() {
        return cntLowerDeptID;
    }

    public void setCntLowerDeptID(Integer cntLowerDeptID) {
        this.cntLowerDeptID = cntLowerDeptID;
    }

    public Integer getDepthLevel() {
        return depthLevel;
    }

    public void setDepthLevel(Integer depthLevel) {
        this.depthLevel = depthLevel;
    }

    public String getOrgDstCd() {
        return orgDstCd;
    }

    public void setOrgDstCd(String orgDstCd) {
        this.orgDstCd = orgDstCd;
    }

    public String getOrgDstCdNm() {
        return orgDstCdNm;
    }

    public void setOrgDstCdNm(String orgDstCdNm) {
        this.orgDstCdNm = orgDstCdNm;
    }

    public Integer getLowerCnt() {
        return lowerCnt;
    }

    public void setLowerCnt(Integer lowerCnt) {
        this.lowerCnt = lowerCnt;
    }

    public String getHgrkDeptNm() {
        return hgrkDeptNm;
    }

    public void setHgrkDeptNm(String hgrkDeptNm) {
        this.hgrkDeptNm = hgrkDeptNm;
    }

    public String getSlsEmpId() {
        return slsEmpId;
    }

    public void setSlsEmpId(String slsEmpId) {
        this.slsEmpId = slsEmpId;
    }

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getUserGrpCd() {
        return userGrpCd;
    }

    public void setUserGrpCd(String userGrpCd) {
        this.userGrpCd = userGrpCd;
    }

    public String getIsAllAuth() {
        return isAllAuth;
    }

    public void setIsAllAuth(String isAllAuth) {
        this.isAllAuth = isAllAuth;
    }

    public String getPriorUserGrpCd() {
        return priorUserGrpCd;
    }

    public void setPriorUserGrpCd(String priorUserGrpCd) {
        this.priorUserGrpCd = priorUserGrpCd;
    }

    public String getCritYear() {
        return critYear;
    }

    public void setCritYear(String critYear) {
        this.critYear = critYear;
    }

    @Override
    public String toString() {
        return "DeptVO [deptId=" + deptId + ", deptNm=" + deptNm + ", ccCd=" + ccCd + ", orgDstCd="
                + orgDstCd + ", orgDstCdNm=" + orgDstCdNm + ", hgrkDeptId=" + hgrkDeptId + ", deptSortSeqc="
                + deptSortSeqc + ", bltcCd=" + bltcCd + ", deptLvlCd=" + deptLvlCd + ", hddpEmpId=" + hddpEmpId
                + ", crtDate=" + crtDate + ", closeDate=" + closeDate + ", sellOcrYn=" + sellOcrYn
                + ", regEmpId=" + regEmpId + ", regDt=" + regDt + ", chgEmpId=" + chgEmpId  + ", chgDt ="
                + chgDt + ", gridStatus=" + gridStatus + ", searchValue=" + searchValue + ", deptIds=" + deptIds + ", cntLowerDeptID="
                + cntLowerDeptID + ", depthLevel=" + depthLevel + ", lowerCnt=" + lowerCnt + ", hgrkDeptNm=" + hgrkDeptNm
                + ", slsEmpId=" + slsEmpId + ", empId=" + empId + ", userGrpCd=" + userGrpCd
                + ", totalSize=" + totalSize + ", isAllAuth=" + isAllAuth + ", priorUserGrpCd=" + priorUserGrpCd+ ", critYear=" + critYear + "]";
    }
}
