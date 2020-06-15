package com.ibiz.api.model;

import java.util.List;

public class EmpVO {
    /**
     * 사원ID
     */
    private String empId;

    /**
     * 사원명
     */
    private String empNm;

    /**
     * 소속부서ID
     */
    private String bltoDeptId;

    /**
     * 주민등록번호
     */
    private String ssrgNo;

    /**
     * 직군코드
     */
    private String jbgrCd;

    /**
     * 직위코드
     */
    private String ofpsCd;

    /**
     * 직위연차수
     */
    private Integer ofpsYrvcCount;

    /**
     * 직책코드
     */
    private String resoCd;

    /**
     * 회사전화번호
     */
    private String compTelNo;

    /**
     * 이동전화번호
     */
    private String mbphNo;

    /**
     * 이메일주소
     */
    private String emlAdrs;

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
     * 휴직상태코드
     */
    private String lvabStatCd;

    /**
     * 퇴직상태코드
     */
    private String retStatCd;

    /**
     * 등록사원ID
     */
    private String regEmpId;

    /**
     * 등록일시
     */
    private String regDt;

    /**
     * 변경사원ID
     */
    private String chgEmpId;

    /**
     * 변경일시
     */
    private String chgDt;

    /**
     * 부서명
     */
    private String deptNm;
    /**
     * 직위명
     */
    private String ofpsCdNm;

    /**
     * 직책명
     */
    private String resoCdNm;

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

    /**
     * 고객 ID
     */
    private String custId;

    private String resoNm;

    private String ofpsNm;

    private List<EmpVO> subEmpVO;

    /**
     * 재직상태 이름
     */

    private String hdocStatNm;

    /**
     * 재직회사
     */
    private String compNm;

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

    public String getBltoDeptId() {
        return bltoDeptId;
    }

    public void setBltoDeptId(String bltoDeptId) {
        this.bltoDeptId = bltoDeptId;
    }

    public String getSsrgNo() {
        return ssrgNo;
    }

    public void setSsrgNo(String ssrgNo) {
        this.ssrgNo = ssrgNo;
    }

    public String getJbgrCd() {
        return jbgrCd;
    }

    public void setJbgrCd(String jbgrCd) {
        this.jbgrCd = jbgrCd;
    }

    public String getOfpsCd() {
        return ofpsCd;
    }

    public void setOfpsCd(String ofpsCd) {
        this.ofpsCd = ofpsCd;
    }

    public Integer getOfpsYrvcCount() {
        return ofpsYrvcCount;
    }

    public void setOfpsYrvcCount(Integer ofpsYrvcCount) {
        this.ofpsYrvcCount = ofpsYrvcCount;
    }

    public String getResoCd() {
        return resoCd;
    }

    public void setResoCd(String resoCd) {
        this.resoCd = resoCd;
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

    public String getLvabStatCd() {
        return lvabStatCd;
    }

    public void setLvabStatCd(String lvabStatCd) {
        this.lvabStatCd = lvabStatCd;
    }

    public String getRetStatCd() {
        return retStatCd;
    }

    public void setRetStatCd(String retStatCd) {
        this.retStatCd = retStatCd;
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

    public String getDeptNm() {
        return deptNm;
    }

    public void setDeptNm(String deptNm) {
        this.deptNm = deptNm;
    }

    public String getOfpsCdNm() {
        return ofpsCdNm;
    }

    public void setOfpsCdNm(String ofpsCdNm) {
        this.ofpsCdNm = ofpsCdNm;
    }

    public String getResoCdNm() {
        return resoCdNm;
    }

    public void setResoCdNm(String resoCdNm) {
        this.resoCdNm = resoCdNm;
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

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getResoNm() {
        return resoNm;
    }

    public void setResoNm(String resoNm) {
        this.resoNm = resoNm;
    }

    public String getOfpsNm() {
        return ofpsNm;
    }

    public void setOfpsNm(String ofpsNm) {
        this.ofpsNm = ofpsNm;
    }

    public List<EmpVO> getSubEmpVO() {
        return subEmpVO;
    }

    public void setSubEmpVO(List<EmpVO> subEmpVO) {
        this.subEmpVO = subEmpVO;
    }

    public String getHdocStatNm() {
        return hdocStatNm;
    }

    public void setHdocStatNm(String hdocStatNm) {
        this.hdocStatNm = hdocStatNm;
    }

    public Integer getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(Integer totalCnt) {
        this.totalCnt = totalCnt;
    }

    public String getCompNm() {
        return compNm;
    }

    public void setCompNm(String compNm) {
        this.compNm = compNm;
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

    @Override
    public String toString() {
        return "EmpVO [ empId=" + empId + ", empNm=" + empNm + ", bltoDeptId=" + bltoDeptId + ", ssrgNo="
                + ssrgNo + ", jbgrCd=" + jbgrCd + ", ofpsCd=" + ofpsCd + ", ofpsYrvcCount="
                + ofpsYrvcCount + ", resoCd=" + resoCd + ", compTelNo=" + compTelNo + ", mbphNo=" + mbphNo
                + ", emlAdrs=" + emlAdrs + ", compEncmDate=" + compEncmDate+ ", grpEncmDate=" + grpEncmDate
                + ", retDate=" + retDate+ ", recrtDstCd=" + recrtDstCd+ ", cntrStartDate=" + cntrStartDate
                + ", lvabStatCd=" + lvabStatCd+ ", recrtDstCd=" + recrtDstCd+ ", retStatCd=" + retStatCd
                + ", regEmpId=" + regEmpId+ ", regDt=" + regDt+ ", chgEmpId=" + chgEmpId
                + ", chgDt=" + chgDt+ ", deptNm=" + deptNm+ ", ofpsCdNm=" + ofpsCdNm
                + ", resoCdNm=" + resoCdNm+ ", custId=" + custId+ ", resoNm=" + resoNm
                + ", ofpsNm=" + ofpsNm+ ", subEmpVO=" + subEmpVO+ ", hdocStatNm=" + hdocStatNm
                + ", compNm=" + compNm+ ", dcarReglMA=" + dcarReglMA+ ", isPerdExtend=" + isPerdExtend
                + ", cntrEndDate=" + cntrEndDate+ ", hdocStatCd=" + hdocStatCd+ "]";
    }
}
