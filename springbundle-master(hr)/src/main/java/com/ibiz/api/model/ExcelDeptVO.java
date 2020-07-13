package com.ibiz.api.model;

import com.ibiz.api.utils.CellStyleClassAttribute;
import com.ibiz.api.utils.CellStyles;
import com.ibiz.api.utils.ColumnAttribute;

@CellStyleClassAttribute(CellStyleMethodName = "Title", ClassType = CellStyles.class)
public class ExcelDeptVO {

    //@ColumnAttribute(Index = 0, Title = "번호", IsRowMerge = true, ColumnWidth = 50, CellStyleMethodName = "Content")
    //private Long no;

    /**
     * 부서ID
     */
    @ColumnAttribute(Index = 0, Title = "부서ID",   ColumnWidth = 100, CellStyleMethodName = "Content")
    private String deptId;

    /**
     * 부서명
     */
    @ColumnAttribute(Index = 1, Title = "부서명",   ColumnWidth = 120, CellStyleMethodName = "Content")
    private String deptNm;

    /**
     * 상위부서id
     */
    @ColumnAttribute(Index = 2, Title = "상위조직ID",   ColumnWidth = 100, CellStyleMethodName = "Content")
    private String hgrkDeptId;

    /**
     * 상위부서명
     */
    @ColumnAttribute(Index = 3, Title = "상위조직명",   ColumnWidth = 120, CellStyleMethodName = "Content")
    private String hgrkDeptNm;

    /**
     * 부서정렬순서
     */
    @ColumnAttribute(Index = 4, Title = "부서정렬순서",   ColumnWidth = 100, CellStyleMethodName = "Content")
    private String deptSortSeqc;


    /**
     * 부서레벨
     */
    @ColumnAttribute(Index = 5, Title = "부서레벨코드",   ColumnWidth = 100, CellStyleMethodName = "Content")
    private String deptLvlCd;

    /**
     * 부서레벨명
     */
    @ColumnAttribute(Index = 6, Title = "부서레벨명",   ColumnWidth = 100, CellStyleMethodName = "Content")
    private String deptLvlCdNm;

    /**
     * 브사징ID
     */
    @ColumnAttribute(Index = 7, Title = "부서장ID",   ColumnWidth = 100, CellStyleMethodName = "Content")
    private String hddpEmpId;

    /**
     * 부서장명
     */
    @ColumnAttribute(Index = 8, Title = "부서장명",   ColumnWidth = 100, CellStyleMethodName = "Content")
    private String hddpEmpNm;

    /**
     * 부서장직위명
     */
    @ColumnAttribute(Index = 9, Title = "부서장 직위명",   ColumnWidth = 100, CellStyleMethodName = "Content")
    private String ofpsCdNm;

    /**
     * 조직구분코드명
     */
    @ColumnAttribute(Index = 10, Title = "조직구분코드명",   ColumnWidth = 100, CellStyleMethodName = "Content")
    private String orgDstCdNm;

    /**
     * 메츨브사
     */
    @ColumnAttribute(Index = 11, Title = "매출부서여부",   ColumnWidth = 100, CellStyleMethodName = "Content")
    private String sellOcrYn;

    /**
     * 조직생성일
     */
    @ColumnAttribute(Index = 12, Title = "유효시작일자",   ColumnWidth = 120, CellStyleMethodName = "Content")
    private String avlStartDate;

    /**
     * 조직폐쇄일
     */
    @ColumnAttribute(Index = 13, Title = "유효종료일자",   ColumnWidth = 120, CellStyleMethodName = "Content")
    private String avlEndDate;

    /**
     * 조직생성일
     */
    @ColumnAttribute(Index = 14, Title = "조직생성일자",   ColumnWidth = 120, CellStyleMethodName = "Content")
    private String orgCrtDate;

    /**
     * 조직폐쇄일
     */
    @ColumnAttribute(Index = 15, Title = "조직폐쇄일자",   ColumnWidth = 120, CellStyleMethodName = "Content")
    private String orgCloseDate;


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



    public String getOfpsCdNm() {
        return ofpsCdNm;
    }



    public void setOfpsCdNm(String ofpsCdNm) {
        this.ofpsCdNm = ofpsCdNm;
    }



    public String getOrgDstCdNm() {
        return orgDstCdNm;
    }



    public void setOrgDstCdNm(String orgDstCdNm) {
        this.orgDstCdNm = orgDstCdNm;
    }



    public String getSellOcrYn() {
        return sellOcrYn;
    }



    public void setSellOcrYn(String sellOcrYn) {
        this.sellOcrYn = sellOcrYn;
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



    @Override
    public String toString() {
        return "ExcelDeptInfoVO [deptId=" + deptId + ", deptNm=" + deptNm + ", hgrkDeptId=" + hgrkDeptId
                + ", hgrkDeptNm=" + hgrkDeptNm + ", deptSortSeqc=" + deptSortSeqc
                + ", deptLvlCd=" + deptLvlCd + ", deptLvlCdNm=" + deptLvlCdNm + ", hddpEmpId=" + hddpEmpId
                + ", hddpEmpNm=" + hddpEmpNm + ", ofpsCdNm=" + ofpsCdNm + ", sellOcrYn=" + sellOcrYn + ", avlStartDate="
                + avlStartDate + ", avlEndDate=" + avlEndDate + "]";
    }


}
