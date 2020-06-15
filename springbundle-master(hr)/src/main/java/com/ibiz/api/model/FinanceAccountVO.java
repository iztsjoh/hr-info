package com.ibiz.api.model;

public class FinanceAccountVO {
    /**
     * 금융계좌ID
     */
    private String fnacId;

    /**
     * 금융계좌구분코드
     */
    private String fnacDstCd;

    /**
     * 금융계좌구분명
     */
    private String fnacDstNm;

    /**
     * 금융계좌명
     */
    private String fnacNm;

    /**
     * 계좌고객ID
     */
    private String bnacCustId;

    /**
     * 금융기관코드
     */
    private String fnisCd;

    /**
     * 금융기관명
     */
    private String fnisNm;

    /**
     * 금융계좌번호
     */
    private String fnacNo;

    /**
     * 예금자명
     */
    private String dpsrNm;

    /**
     * 금융계좌상태코드
     */
    private String fnacStatCd;

    /**
     * 금융계좌상태명
     */
    private String fnacStatNm;

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
     * 금융기관지점코드
     */
    private String fnisBrstCd;

    /**
     * 유효시작일자
     */
    private String avlStartDate;

    /**
     * 유효종료일자
     */
    private String avlEndDate;

    public String getFnacId() {
        return fnacId;
    }

    public void setFnacId(String fnacId) {
        this.fnacId = fnacId;
    }

    public String getFnacDstCd() {
        return fnacDstCd;
    }

    public void setFnacDstCd(String fnacDstCd) {
        this.fnacDstCd = fnacDstCd;
    }

    public String getFnacDstNm() {
        return fnacDstNm;
    }

    public void setFnacDstNm(String fnacDstNm) {
        this.fnacDstNm = fnacDstNm;
    }

    public String getFnacNm() {
        return fnacNm;
    }

    public void setFnacNm(String fnacNm) {
        this.fnacNm = fnacNm;
    }

    public String getBnacCustId() {
        return bnacCustId;
    }

    public void setBnacCustId(String bnacCustId) {
        this.bnacCustId = bnacCustId;
    }

    public String getFnisCd() {
        return fnisCd;
    }

    public void setFnisCd(String fnisCd) {
        this.fnisCd = fnisCd;
    }

    public String getFnisNm() {
        return fnisNm;
    }

    public void setFnisNm(String fnisNm) {
        this.fnisNm = fnisNm;
    }

    public String getFnacNo() {
        return fnacNo;
    }

    public void setFnacNo(String fnacNo) {
        this.fnacNo = fnacNo;
    }

    public String getDpsrNm() {
        return dpsrNm;
    }

    public void setDpsrNm(String dpsrNm) {
        this.dpsrNm = dpsrNm;
    }

    public String getFnacStatCd() {
        return fnacStatCd;
    }

    public void setFnacStatCd(String fnacStatCd) {
        this.fnacStatCd = fnacStatCd;
    }

    public String getFnacStatNm() {
        return fnacStatNm;
    }

    public void setFnacStatNm(String fnacStatNm) {
        this.fnacStatNm = fnacStatNm;
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

    public String getFnisBrstCd() {
        return fnisBrstCd;
    }

    public void setFnisBrstCd(String fnisBrstCd) {
        this.fnisBrstCd = fnisBrstCd;
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
        return "FinanceAccountVO [fnacId=" + fnacId + ", fnacDstCd=" + fnacDstCd + ", fnacDstNm=" + fnacDstNm
                + ", fnacNm=" + fnacNm + ", bnacCustId=" + bnacCustId + ", fnisCd=" + fnisCd + ", fnisNm=" + fnisNm
                + ", fnacNo=" + fnacNo + ", dpsrNm=" + dpsrNm + ", fnacStatCd=" + fnacStatCd + ", fnacStatNm="
                + fnacStatNm + ", regEmpId=" + regEmpId + ", regDt=" + regDt + ", chgEmpId=" + chgEmpId + ", chgDt="
                + chgDt + ", fnisBrstCd=" + fnisBrstCd + ", avlStartDate=" + avlStartDate + ", avlEndDate=" + avlEndDate
                + "]";
    }
}
