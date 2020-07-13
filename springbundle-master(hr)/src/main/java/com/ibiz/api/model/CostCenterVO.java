package com.ibiz.api.model;

public class CostCenterVO {
    /**
     * 코스트센터 ID
     */
    private String ccId;

    /**
     * 코스트센터명
     */
    private String ccNm;

    /**
     * 상위코스트센터ID
     */
    private String hgrkCcId;

    /**
     * 상위코스트센터명
     */
    private String hgrkCcNm;

    /**
     * 유효시작일자
     */
    private String avlStartDate;

    /**
     * 유효종료일자
     */
    private String avlEndDate;

    /**
     * 변경사원ID
     */
    private String chgEmpId;

    /**
     * 변경일시
     */
    private String chgDt;

    /**
     * 부서정렬순서
     */
    private String deptSortSeqc;

    /**
     * 조직생성일자
     */
    private String orgCrtDate;

    /**
     * 조직종료일자
     */
    private String orgCloseDate;

    /**
     * 추가 또는 변경 가능 여부
     */
    private String valChk;

    /**
     * list Count
     */
    private Integer listCnt;

    /**
     * 기준일자
     */
    private String stadDate;

    /**
     * 페이지사이즈
     */
    private Integer pageSize;

    /**
     * 페이지넘버
     */
    private Integer pageNumber;

    /**
     * rowNumber
     */
    private Integer rowNumber;

    /**
     * depthLevel
     */
    private Integer depthLevel;

    /**
     * 이력추가 여부
     */
    private String addRecord;

    private String isCreating;


    public String getCcId() {
        return ccId;
    }

    public void setCcId(String ccId) {
        this.ccId = ccId;
    }

    public String getCcNm() {
        return ccNm;
    }

    public void setCcNm(String ccNm) {
        this.ccNm = ccNm;
    }

    public String getHgrkCcId() {
        return hgrkCcId;
    }

    public void setHgrkCcId(String hgrkCcId) {
        this.hgrkCcId = hgrkCcId;
    }

    public String getHgrkCcNm() {
        return hgrkCcNm;
    }

    public void setHgrkCcNm(String hgrkCcNm) {
        this.hgrkCcNm = hgrkCcNm;
    }

    public String getAvlStartDate() {
        return avlStartDate;
    }

    public void setAvlStartDate(String avlStartDate) {
        this.avlStartDate = avlStartDate;
    }

    public String getAvlEndDate() {
        return avlEndDate;
    }

    public void setAvlEndDate(String avlEndDate) {
        this.avlEndDate = avlEndDate;
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

    public String getDeptSortSeqc() {
        return deptSortSeqc;
    }

    public void setDeptSortSeqc(String deptSortSeqc) {
        this.deptSortSeqc = deptSortSeqc;
    }

    public String getOrgCrtDate() {
        return orgCrtDate;
    }

    public void setOrgCrtDate(String orgCrtDate) {
        this.orgCrtDate = orgCrtDate;
    }

    public String getOrgCloseDate() {
        return orgCloseDate;
    }

    public void setOrgCloseDate(String orgCloseDate) {
        this.orgCloseDate = orgCloseDate;
    }

    public String getValChk() {
        return valChk;
    }

    public void setValChk(String valChk) {
        this.valChk = valChk;
    }

    public Integer getListCnt() {
        return listCnt;
    }

    public void setListCnt(Integer listCnt) {
        this.listCnt = listCnt;
    }

    public String getStadDate() {
        return stadDate;
    }

    public void setStadDate(String stadDate) {
        this.stadDate = stadDate;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(Integer rowNumber) {
        this.rowNumber = rowNumber;
    }

    public Integer getDepthLevel() {
        return depthLevel;
    }

    public void setDepthLevel(Integer depthLevel) {
        this.depthLevel = depthLevel;
    }

    public String getAddRecord() {
        return addRecord;
    }

    public void setAddRecord(String addRecord) {
        this.addRecord = addRecord;
    }

    public String getIsCreating() {
        return isCreating;
    }

    public void setIsCreating(String isCreating) {
        this.isCreating = isCreating;
    }

    @Override
    public String toString() {
        return "CostCenterVO [ccId=" + ccId + ", ccNm=" + ccNm + ", hgrkCcId=" + hgrkCcId + ", hgrkCcNm="
                + hgrkCcNm + ", avlStartDate=" + avlStartDate + ", avlEndDate=" + avlEndDate + ", chgEmpId=" + chgEmpId
                + ", chgDt=" + chgDt + ", deptSortSeqc=" + deptSortSeqc + ", orgCrtDate=" + orgCrtDate
                + ", orgCloseDate=" + orgCloseDate + ", valChk=" + valChk + ", listCnt=" + listCnt + ", stadDate="
                + stadDate + ", pageSize=" + pageSize + ", pageNumber=" + pageNumber + ", rowNumber=" + rowNumber
                + ", depthLevel=" + depthLevel + ", addRecord=" + addRecord + ", isCreating=" + isCreating + "]";
    }
}