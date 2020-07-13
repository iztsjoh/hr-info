package com.ibiz.api.model;

import com.ibiz.api.utils.CellStyleClassAttribute;
import com.ibiz.api.utils.CellStyles;
import com.ibiz.api.utils.ColumnAttribute;

@CellStyleClassAttribute(CellStyleMethodName = "Title", ClassType = CellStyles.class)
public class ExcelCostCenterHistoryVO {

    //@ColumnAttribute(Index = 0, Title = "번호", IsRowMerge = true, ColumnWidth = 50, CellStyleMethodName = "Content")
    //private Long no;
    /**
     * 코스트센터 ID
     */
    @ColumnAttribute(Index = 0, Title = "코스트센터 ID",   ColumnWidth = 110, CellStyleMethodName = "Content")
    private String ccId;

    /**
     * 코스트센터명
     */
    @ColumnAttribute(Index = 1, Title = "코스트센터명",   ColumnWidth = 120, CellStyleMethodName = "Content")
    private String ccNm;

    /**
     * 상위코스트센터ID
     */
    @ColumnAttribute(Index = 2, Title = "상위코스트센터 ID",   ColumnWidth = 120, CellStyleMethodName = "Content")
    private String hgrkCcId;

    /**
     * 상위코스트센터명
     */
    @ColumnAttribute(Index = 3, Title = "상위코스트센터명",   ColumnWidth = 120, CellStyleMethodName = "Content")
    private String hgrkCcNm;

    /**
     * 유효시작일자
     */
    @ColumnAttribute(Index = 4, Title = "유효시작일자",   ColumnWidth = 120, CellStyleMethodName = "Content")
    private String avlStartDate;

    /**
     * 유효종료일자
     */
    @ColumnAttribute(Index = 5, Title = "유효종료일자",   ColumnWidth = 120, CellStyleMethodName = "Content")
    private String avlEndDate;

    /**
     * 조직생성일자
     */
    @ColumnAttribute(Index = 6, Title = "조직생성일자",   ColumnWidth = 120, CellStyleMethodName = "Content")
    private String orgCrtDate;

    /**
     * 조직종료일자
     */
    @ColumnAttribute(Index = 7, Title = "조직종료일자",   ColumnWidth = 120, CellStyleMethodName = "Content")
    private String orgCloseDate;

	/*
	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}
	*/

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

    @Override
    public String toString() {
        return "ExcelCostCenterChgHisVO [ccId=" + ccId + ", ccNm=" + ccNm + ", hgrkCcId=" + hgrkCcId
                + ", hgrkCcNm=" + hgrkCcNm + ", orgCrtDate=" + orgCrtDate + ", orgCloseDate="
                + orgCloseDate + "]";
    }


}
