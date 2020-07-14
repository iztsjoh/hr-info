package com.ibiz.api.model;

import com.ibiz.api.utils.CellStyleClassAttribute;
import com.ibiz.api.utils.CellStyles;
import com.ibiz.api.utils.ColumnAttribute;

@CellStyleClassAttribute(CellStyleMethodName = "Title", ClassType = CellStyles.class)
public class ExcelEmployeeVO {

    //@ColumnAttribute(Index = 0, Title = "번호", IsRowMerge = true, ColumnWidth = 50, CellStyleMethodName = "Content")
    //private Long no;
    /**
     * 사원 ID
     */
    @ColumnAttribute(Index = 0, Title = "사원ID",   ColumnWidth = 80, CellStyleMethodName = "Content")
    private String empId;

    /**
     * 사원명
     */
    @ColumnAttribute(Index = 1, Title = "성명",   ColumnWidth = 100, CellStyleMethodName = "Content")
    private String empNm;

    /**
     * 주민등록번호 (ex 821206*******)
     */
    @ColumnAttribute(Index = 2, Title = "주민등록번호",   ColumnWidth = 130, CellStyleMethodName = "Content")
    private String ssrgNo;

    /**
     * 소속부서ID
     */
    @ColumnAttribute(Index = 3, Title = "소속부서ID",   ColumnWidth = 80, CellStyleMethodName = "Content")
    private String bltoDeptId;

    /**
     * 소속부서명
     */
    @ColumnAttribute(Index = 4, Title = "소속부서명",   ColumnWidth = 120, CellStyleMethodName = "Content")
    private String bltoDeptNm;

    /**
     * 직위명
     */
    @ColumnAttribute(Index = 6, Title = "직위명",   ColumnWidth = 100, CellStyleMethodName = "Content")
    private String ofpsCdNm;

    /**
     * 직위연차수
     */
    @ColumnAttribute(Index = 7, Title = "직위연차수",   ColumnWidth = 80, CellStyleMethodName = "Content")
    private String ofpsYrvcCount;


    /**
     * 직책명
     */
    @ColumnAttribute(Index = 8, Title = "직책명",   ColumnWidth = 100, CellStyleMethodName = "Content")
    private String resoCdNm;

    /**
     * 회사입사일자
     */
    @ColumnAttribute(Index = 9, Title = "회사입사일",   ColumnWidth = 110, CellStyleMethodName = "Content")
    private String compEncmDate;

    /**
     * 그룹입사일자
     */
    @ColumnAttribute(Index = 10, Title = "그룹입사일",   ColumnWidth = 110, CellStyleMethodName = "Content")
    private String grpEncmDate;

    /**
     * 퇴직일자
     */
    @ColumnAttribute(Index = 11, Title = "퇴직일",   ColumnWidth = 110, CellStyleMethodName = "Content")
    private String retDate;

    /**
     * 고용구분명
     */
    @ColumnAttribute(Index = 12, Title = "고용구분",   ColumnWidth = 80, CellStyleMethodName = "Content")
    private String recrtDstCdNm;

    /**
     * 재직상태명
     */
    @ColumnAttribute(Index = 13, Title = "재직상태",   ColumnWidth = 80, CellStyleMethodName = "Content")
    private String hdocStatCdNm;

    /**
     * 계약시작일자
     */
    @ColumnAttribute(Index = 14, Title = "계약일",   ColumnWidth = 180, CellStyleMethodName = "Content")
    private String cntrDate;


    /**
     * 휴가시작일자
     */
    @ColumnAttribute(Index = 15, Title = "휴직일",   ColumnWidth = 180, CellStyleMethodName = "Content")
    private String lvabDate;


    /**
     * 회사전호번호
     */
    @ColumnAttribute(Index = 16, Title = "회사전화번호",   ColumnWidth = 120, CellStyleMethodName = "Content")
    private String compTelNo;

    /**
     * 휴대전화번호
     */
    @ColumnAttribute(Index = 17, Title = "이동전화번호",   ColumnWidth = 120, CellStyleMethodName = "Content")
    private String mbphNo;

    /**
     * 이메일주소
     */
    @ColumnAttribute(Index = 18, Title = "이메일주소",   ColumnWidth = 180, CellStyleMethodName = "Content")
    private String emlAdrs;


	/*
	public Long getNo() {
		return no;
	}



	public void setNo(Long no) {
		this.no = no;
	}
	*/


    public String getEmpId() {
        return empId;
    }



    public void setEmpId(String empId) {
        this.empId = empId;
    }



    public String getEmpNm() {
        return empNm;
    }



    public void setEmpNm(String empNm) {
        this.empNm = empNm;
    }



    public String getSsrgNo() {
        return ssrgNo;
    }



    public void setSsrgNo(String ssrgNo) {
        this.ssrgNo = ssrgNo;
    }



    public String getBltoDeptId() {
        return bltoDeptId;
    }



    public void setBltoDeptId(String bltoDeptId) {
        this.bltoDeptId = bltoDeptId;
    }


    public String getBltoDeptNm() {
        return bltoDeptNm;
    }

    public void setBltoDeptNm(String bltoDeptNm) {
        this.bltoDeptNm = bltoDeptNm;
    }

    public String getOfpsCdNm() {
        return ofpsCdNm;
    }



    public void setOfpsCdNm(String ofpsCdNm) {
        this.ofpsCdNm = ofpsCdNm;
    }



    public String getOfpsYrvcCount() {
        return ofpsYrvcCount;
    }



    public void setOfpsYrvcCount(String ofpsYrvcCount) {
        this.ofpsYrvcCount = ofpsYrvcCount;
    }



    public String getResoCdNm() {
        return resoCdNm;
    }



    public void setResoCdNm(String resoCdNm) {
        this.resoCdNm = resoCdNm;
    }



    public String getCompEncmDate() {
        return compEncmDate;
    }



    public void setCompEncmDate(String compEncmDate) {
        this.compEncmDate = compEncmDate;
    }



    public String getGrpEncmDate() {
        return grpEncmDate;
    }



    public void setGrpEncmDate(String grpEncmDate) {
        this.grpEncmDate = grpEncmDate;
    }



    public String getRetDate() {
        return retDate;
    }



    public void setRetDate(String retDate) {
        this.retDate = retDate;
    }



    public String getRecrtDstCdNm() {
        return recrtDstCdNm;
    }



    public void setRecrtDstCdNm(String recrtDstCdNm) {
        this.recrtDstCdNm = recrtDstCdNm;
    }



    public String getHdocStatCdNm() {
        return hdocStatCdNm;
    }



    public void setHdocStatCdNm(String hdocStatCdNm) {
        this.hdocStatCdNm = hdocStatCdNm;
    }



    public String getCntrDate() {
        return cntrDate;
    }



    public void setCntrDate(String cntrDate) {
        this.cntrDate = cntrDate;
    }



    public String getLvabDate() {
        return lvabDate;
    }



    public void setLvabDate(String lvabDate) {
        this.lvabDate = lvabDate;
    }



    public String getCompTelNo() {
        return compTelNo;
    }



    public void setCompTelNo(String compTelNo) {
        this.compTelNo = compTelNo;
    }



    public String getMbphNo() {
        return mbphNo;
    }



    public void setMbphNo(String mbphNo) {
        this.mbphNo = mbphNo;
    }



    public String getEmlAdrs() {
        return emlAdrs;
    }



    public void setEmlAdrs(String emlAdrs) {
        this.emlAdrs = emlAdrs;
    }




}
