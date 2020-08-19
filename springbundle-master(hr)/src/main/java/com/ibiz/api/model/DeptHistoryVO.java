package com.ibiz.api.model;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DeptHistoryVO {
    /**
     * 붓서ID
     */
    @Valid
    @NotNull
    @Size(min = 1, max = 3,message = "8자이하")
    private String deptId;

    /***
     * 기준연도
     */
    private String critYear;

    /***
     * 기준연도
     */
    private String preYear;

    /**
     * 붓서명
     */
    private String deptNm;

    /**
     * 상위부서id
     */
    private String hgrkDeptId;

    /**
     * 상위부서명
     */
    private String hgrkDeptNm;

    /**
     * 부서정렬순서
     */
    private String deptSortSeqc;

    /**
     * 부서레벨
     */
    private String deptLvlCd;

    /**
     * 부서레벨명
     */
    private String deptLvlCdNm;

    /**
     * 브사징ID
     */
    private String hddpEmpId;

    /**
     * 부서장명
     */
    private String hddpEmpNm;

    /**
     * 메츨브사
     */
    private String sellOcrYn;

    /**
     * 조직생성일
     */
    private String orgCrtDate;

    /**
     * 조직폐쇄일
     */
    private String orgCloseDate;

    /**
     * 이력시작일
     */
    private String avlStartDate;

    /**
     * 이력종료일
     */
    private String avlEndDate;

    /**
     * 부서장직위명
     */
    private String ofpsCdNm;

    /**
     * 부서장직위코드
     */
    private String ofpsCd;

    /**
     * 기준일자
     */
    private String stadDate;

    /**
     * 추가 또는 변경 가능 여부
     */
    private String valChk;

    /**
     * 추가 변경 사용자 ID
     */
    private String chgEmpId;

    /**
     * list Count
     */
    private Integer listCnt;

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
     * orgDstCd
     */
    private String orgDstCd;

    /**
     * orgDstCdNm
     */
    private String orgDstCdNm;

    /**
     * 기준일자
     */
    private String standardDate;

    /**
     * 이력추가 여부
     * */
    private String isAddRecord;


    /**
     * 신규등록 여부
     */
    private String isCreating;

    public DeptHistoryVO() {
        deptId = null;
    }

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

    public String getCritYear() {
        return critYear;
    }

    public void setCritYear(String critYear) {
        this.critYear = critYear;
    }

    public String getPreYear() {
        return preYear;
    }

    public void setPreYear(String preYear) {
        this.preYear = preYear;
    }

    public String getHgrkDeptId() {
        return hgrkDeptId;
    }



    public void setHgrkDeptId(String hgrkDeptId) {
        this.hgrkDeptId = hgrkDeptId;
    }



    public String getHgrkDeptNm() {
        return hgrkDeptNm;
    }



    public void setHgrkDeptNm(String hgrkDeptNm) {
        this.hgrkDeptNm = hgrkDeptNm;
    }



    public String getDeptSortSeqc() {
        return deptSortSeqc;
    }



    public void setDeptSortSeqc(String deptSortSeqc) {
        this.deptSortSeqc = deptSortSeqc;
    }



    public String getDeptLvlCd() {
        return deptLvlCd;
    }



    public void setDeptLvlCd(String deptLvlCd) {
        this.deptLvlCd = deptLvlCd;
    }



    public String getDeptLvlCdNm() {
        return deptLvlCdNm;
    }



    public void setDeptLvlCdNm(String deptLvlCdNm) {
        this.deptLvlCdNm = deptLvlCdNm;
    }



    public String getHddpEmpId() {
        return hddpEmpId;
    }



    public void setHddpEmpId(String hddpEmpId) {
        this.hddpEmpId = hddpEmpId;
    }



    public String getHddpEmpNm() {
        return hddpEmpNm;
    }



    public void setHddpEmpNm(String hddpEmpNm) {
        this.hddpEmpNm = hddpEmpNm;
    }



    public String getSellOcrYn() {
        return sellOcrYn;
    }



    public void setSellOcrYn(String sellOcrYn) {
        this.sellOcrYn = sellOcrYn;
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



    public String getOfpsCdNm() {
        return ofpsCdNm;
    }



    public void setOfpsCdNm(String ofpsCdNm) {
        this.ofpsCdNm = ofpsCdNm;
    }



    public String getOfpsCd() {
        return ofpsCd;
    }



    public void setOfpsCd(String ofpsCd) {
        this.ofpsCd = ofpsCd;
    }



    public String getStadDate() {
        return stadDate;
    }



    public void setStadDate(String stadDate) {
        this.stadDate = stadDate;
    }



    public String getValChk() {
        return valChk;
    }



    public void setValChk(String valChk) {
        this.valChk = valChk;
    }



    public String getChgEmpId() {
        return chgEmpId;
    }



    public void setChgEmpId(String chgEmpId) {
        this.chgEmpId = chgEmpId;
    }



    public Integer getListCnt() {
        return listCnt;
    }



    public void setListCnt(Integer listCnt) {
        this.listCnt = listCnt;
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

    public String getStandardDate() {
        return standardDate;
    }

    public void setStandardDate(String standardDate) {
        this.standardDate = standardDate;
    }

    public String getIsAddRecord() {
        return isAddRecord;
    }

    public void setIsAddRecord(String isAddRecord) {
        this.isAddRecord = isAddRecord;
    }



    public String getIsCreating() {
        return isCreating;
    }



    public void setIsCreating(String isCreating) {
        this.isCreating = isCreating;
    }

    @Override
    public String toString() {
        return "DeptHistoryVO [deptId=" + deptId + ", deptNm=" + deptNm + ", hgrkDeptId=" + hgrkDeptId + ", hgrkDeptNm="
                + hgrkDeptNm + ", deptSortSeqc=" + deptSortSeqc + ", deptLvlCd=" + deptLvlCd + ", deptLvlCdNm="
                + deptLvlCdNm + ", hddpEmpId=" + hddpEmpId + ", hddpEmpNm=" + hddpEmpNm + ", sellOcrYn=" + sellOcrYn
                + ", orgCrtDate=" + orgCrtDate + ", orgCloseDate=" + orgCloseDate + ", avlStartDate=" + avlStartDate
                + ", avlEndDate=" + avlEndDate + ", ofpsCdNm=" + ofpsCdNm + ", ofpsCd=" + ofpsCd + ", stadDate="
                + stadDate + ", valChk=" + valChk + ", chgEmpId=" + chgEmpId + ", listCnt=" + listCnt + ", pageSize="
                + pageSize + ", pageNumber=" + pageNumber + ", rowNumber=" + rowNumber + ", depthLevel=" + depthLevel
                + ", orgDstCd=" + orgDstCd + ", orgDstCdNm=" + orgDstCdNm + ", standardDate=" + standardDate
                + ", isAddRecord=" + isAddRecord + ", isCreating=" + isCreating + "]";
    }
}
