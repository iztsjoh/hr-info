package com.ibiz.api.model;

import java.util.List;

public class EmployeeVO {
    /**
     * 사원 ID
     */
    private String empId;

    /**
     * 사원명
     */
    private String empNm;

    /**
     * 주민등록번호 (ex 821206*******)
     */
    private String ssrgNo;

    /**
     * 소속부서ID
     */
    private String bltoDeptId;

    /**
     * 소속부서명
     */
    private String bltoDeptNm;

    /**
     * 직위코드
     */
    private String ofpsCd;

    /**
     * 직위명
     */
    private String ofpsCdNm;

    /**
     * 직위연차수
     */
    private String ofpsYrvcCount;

    /**
     * 직채코드
     */
    private String resoCd;

    /**
     * 직책명
     */
    private String resoCdNm;

    /**
     * 회사입사일자
     */
    private String compEncmDate;

    /**
     * 그룹입사일자
     */
    private String grpEncmDate;

    /**
     * 퇴직일자
     */
    private String retDate;

    /**
     * 고용구분코드
     */
    private String recrtDstCd;

    /**
     * 고용구분명
     */
    private String recrtDstCdNm;

    /**
     * 고용계약유형코드
     */
    private String recrtCntrTypeCd;

    /**
     * 고용계약유형코드명
     */
    private String recrtCntrTypeCdNm;

    /**
     * 계약시작일자
     */
    private String cntrStartDate;

    /**
     * 계약종료일자
     */
    private String cntrEndDate;

    /**
     * 재직상태코드
     */
    private String hdocStatCd;

    /**
     * 재직상태명
     */
    private String hdocStatCdNm;

    /**
     * 재직상태상세코드
     */
    private String hdocStatDtlCd;

    /**
     * 휴가시작일자
     */
    private String lvabStartDate;

    /**
     * 휴가종료일자
     */
    private String lvabEndDate;

    /**
     * 회사전호번호
     */
    private String compTelNo;

    /**
     * 휴대전화번호
     */
    private String mbphNo;

    /**
     * 이메일주소
     */
    private String emlAdrs;
    /**
     * 페이지사이즈
     */
    private Integer pageSize;

    /**
     * 페이지넘버
     */
    private Integer pageNumber;
    /**
     * 토탈사이즈
     */
    private Integer totalSize;

    private Integer totalCnt;

    private List<EmployeeVO> subEmployeeVO;

    /**
     * 전결규정구분값(MA일 경우 경영관리본부 제외)
     */
    private boolean dcarReglMA;

    /**
     * MA 계약연장여부(전결규정 간소화 파라미터)
     */
    private String isPerdExtend;

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

    public String getOfpsCd() {
        return ofpsCd;
    }

    public void setOfpsCd(String ofpsCd) {
        this.ofpsCd = ofpsCd;
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

    public String getResoCd() {
        return resoCd;
    }

    public void setResoCd(String resoCd) {
        this.resoCd = resoCd;
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

    public String getRecrtDstCd() {
        return recrtDstCd;
    }

    public void setRecrtDstCd(String recrtDstCd) {
        this.recrtDstCd = recrtDstCd;
    }

    public String getRecrtDstCdNm() {
        return recrtDstCdNm;
    }

    public void setRecrtDstCdNm(String recrtDstCdNm) {
        this.recrtDstCdNm = recrtDstCdNm;
    }

    public String getRecrtCntrTypeCd() {
        return recrtCntrTypeCd;
    }

    public void setRecrtCntrTypeCd(String recrtCntrTypeCd) {
        this.recrtCntrTypeCd = recrtCntrTypeCd;
    }

    public String getRecrtCntrTypeCdNm() {
        return recrtCntrTypeCdNm;
    }

    public void setRecrtCntrTypeCdNm(String recrtCntrTypeCdNm) {
        this.recrtCntrTypeCdNm = recrtCntrTypeCdNm;
    }

    public String getCntrStartDate() {
        return cntrStartDate;
    }

    public void setCntrStartDate(String cntrStartDate) {
        this.cntrStartDate = cntrStartDate;
    }

    public String getCntrEndDate() {
        return cntrEndDate;
    }

    public void setCntrEndDate(String cntrEndDate) {
        this.cntrEndDate = cntrEndDate;
    }

    public String getHdocStatCd() {
        return hdocStatCd;
    }

    public void setHdocStatCd(String hdocStatCd) {
        this.hdocStatCd = hdocStatCd;
    }

    public String getHdocStatCdNm() {
        return hdocStatCdNm;
    }

    public void setHdocStatCdNm(String hdocStatCdNm) {
        this.hdocStatCdNm = hdocStatCdNm;
    }

    public String getHdocStatDtlCd() {
        return hdocStatDtlCd;
    }

    public void setHdocStatDtlCd(String hdocStatDtlCd) {
        this.hdocStatDtlCd = hdocStatDtlCd;
    }

    public String getLvabStartDate() {
        return lvabStartDate;
    }

    public void setLvabStartDate(String lvabStartDate) {
        this.lvabStartDate = lvabStartDate;
    }

    public String getLvabEndDate() {
        return lvabEndDate;
    }

    public void setLvabEndDate(String lvabEndDate) {
        this.lvabEndDate = lvabEndDate;
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

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public Integer getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(Integer totalCnt) {
        this.totalCnt = totalCnt;
    }

    public List<EmployeeVO> getSubEmployeeVO() {
        return subEmployeeVO;
    }

    public void setSubEmployeeVO(List<EmployeeVO> subEmployeeVO) {
        this.subEmployeeVO = subEmployeeVO;
    }

    public boolean isDcarReglMA() {
        return dcarReglMA;
    }

    public void setDcarReglMA(boolean dcarReglMA) {
        this.dcarReglMA = dcarReglMA;
    }

    public String getIsPerdExtend() {
        return isPerdExtend;
    }

    public void setIsPerdExtend(String isPerdExtend) {
        this.isPerdExtend = isPerdExtend;
    }
}
