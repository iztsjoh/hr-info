package com.ibiz.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeChangeIFVO {

    /**
     * 전송상태
     */
    @JsonProperty("SND_STAT_CD")
    private String SND_STAT_CD;

    /**
     * 전송상태메시지
     */
    @JsonProperty("SND_STAT_MSG")
    private String SND_STAT_MSG;

    /**
     * 요청작업코드
     */
    @JsonProperty("SND_JOB_CD")
    private String SND_JOB_CD;

    /**
     * 전송일자
     */
    @JsonProperty("SND_DATE")
    private String SND_DATE;

    /**
     * 전송순번
     */
    @JsonProperty("SND_SEQ")
    private String SND_SEQ;

    /**
     * 데이터변경코드
     */
    @JsonProperty("DATA_CHG_DST_CD")
    private String DATA_CHG_DST_CD;

    /**
     * 요청시스템코드
     */
    @JsonProperty("SND_SYS_DST_CD")
    private String SND_SYS_DST_CD;

    /**
     * 사번ID
     */
    @JsonProperty("EMP_ID")
    private String EMP_ID;

    /**
     * 사원명
     */
    @JsonProperty("EMP_NM")
    private String EMP_NM;

    /**
     * 이력유효시작일자
     */
    @JsonProperty("AVL_START_DATE")
    private String AVL_START_DATE;

    /**
     * 이력유효종료일자
     */
    @JsonProperty("AVL_END_DATE")
    private String AVL_END_DATE;

    /**
     * 소속부서ID
     */
    @JsonProperty("BLTO_DEPT_ID")
    private String BLTO_DEPT_ID;

    /**
     * 소속부서명
     */
    @JsonProperty("BLTO_DEPT_NM")
    private String BLTO_DEPT_NM;

    /**
     * 겸직구분코드
     */
    @JsonProperty("CNPS_DST_CD")
    private String CNPS_DST_CD;

    /**
     * 겸직구분코드명
     */
    @JsonProperty("CNPS_DST_CD_NM")
    private String CNPS_DST_CD_NM;

    /**
     * 코스트센터ID
     */
    @JsonProperty("CC_ID")
    private String CC_ID;

    /**
     * 코스트센터명
     */
    @JsonProperty("CC_NM")
    private String CC_NM;

    /**
     * 소속회사코드
     */
    @JsonProperty("BLTO_COMP_CD")
    private String BLTO_COMP_CD;

    /**
     * 소속회사명
     */
    @JsonProperty("BLTO_COMP_NM")
    private String BLTO_COMP_NM;

    /**
     * 직위코드
     */
    @JsonProperty("OFPS_CD")
    private String OFPS_CD;

    /**
     * 직위코드명
     */
    @JsonProperty("OFPS_CD_NM")
    private String OFPS_CD_NM;

    /**
     * 직책코드
     */
    @JsonProperty("RESO_CD")
    private String RESO_CD;

    /**
     * 직책코드명
     */
    @JsonProperty("RESO_CD_NM")
    private String RESO_CD_NM;

    /**
     * 고용구분코드
     */
    @JsonProperty("RECRT_DST_CD")
    private String RECRT_DST_CD;

    /**
     * 고용구분코드명
     */
    @JsonProperty("RECRT_DST_CD_NM")
    private String RECRT_DST_CD_NM;

    /**
     * 재직상태상세코드
     */
    @JsonProperty("HDOC_STAT_DTL_CD")
    private String HDOC_STAT_DTL_CD;

    /**
     * 재직상태상세코드명
     */
    @JsonProperty("HDOC_STAT_DTL_CD_NM")
    private String HDOC_STAT_DTL_CD_NM;

    /**
     * 계약시작일자
     */
    @JsonProperty("CNTR_START_DATE")
    private String CNTR_START_DATE;

    /**
     * 계약종료일자
     */
    @JsonProperty("CNTR_END_DATE")
    private String CNTR_END_DATE;

    public String getSND_STAT_CD() {
        return SND_STAT_CD;
    }

    public void setSND_STAT_CD(String sND_STAT_CD) {
        SND_STAT_CD = sND_STAT_CD;
    }

    public String getSND_STAT_MSG() {
        return SND_STAT_MSG;
    }

    public void setSND_STAT_MSG(String sND_STAT_MSG) {
        SND_STAT_MSG = sND_STAT_MSG;
    }

    public String getSND_JOB_CD() {
        return SND_JOB_CD;
    }

    public void setSND_JOB_CD(String sND_JOB_CD) {
        SND_JOB_CD = sND_JOB_CD;
    }

    public String getSND_DATE() {
        return SND_DATE;
    }

    public void setSND_DATE(String sND_DATE) {
        SND_DATE = sND_DATE;
    }

    public String getSND_SEQ() {
        return SND_SEQ;
    }

    public void setSND_SEQ(String sND_SEQ) {
        SND_SEQ = sND_SEQ;
    }

    public String getDATA_CHG_DST_CD() {
        return DATA_CHG_DST_CD;
    }

    public void setDATA_CHG_DST_CD(String dATA_CHG_DST_CD) {
        DATA_CHG_DST_CD = dATA_CHG_DST_CD;
    }

    public String getSND_SYS_DST_CD() {
        return SND_SYS_DST_CD;
    }

    public void setSND_SYS_DST_CD(String sND_SYS_DST_CD) {
        SND_SYS_DST_CD = sND_SYS_DST_CD;
    }

    public String getEMP_ID() {
        return EMP_ID;
    }

    public void setEMP_ID(String eMP_ID) {
        EMP_ID = eMP_ID;
    }

    public String getEMP_NM() {
        return EMP_NM;
    }

    public void setEMP_NM(String eMP_NM) {
        EMP_NM = eMP_NM;
    }

    public String getAVL_START_DATE() {
        return AVL_START_DATE;
    }

    public void setAVL_START_DATE(String aVL_START_DATE) {
        AVL_START_DATE = aVL_START_DATE;
    }

    public String getAVL_END_DATE() {
        return AVL_END_DATE;
    }

    public void setAVL_END_DATE(String aVL_END_DATE) {
        AVL_END_DATE = aVL_END_DATE;
    }

    public String getBLTO_DEPT_ID() {
        return BLTO_DEPT_ID;
    }

    public void setBLTO_DEPT_ID(String bLTO_DEPT_ID) {
        BLTO_DEPT_ID = bLTO_DEPT_ID;
    }

    public String getBLTO_DEPT_NM() {
        return BLTO_DEPT_NM;
    }

    public void setBLTO_DEPT_NM(String bLTO_DEPT_NM) {
        BLTO_DEPT_NM = bLTO_DEPT_NM;
    }

    public String getCNPS_DST_CD() {
        return CNPS_DST_CD;
    }

    public void setCNPS_DST_CD(String cNPS_DST_CD) {
        CNPS_DST_CD = cNPS_DST_CD;
    }

    public String getCNPS_DST_CD_NM() {
        return CNPS_DST_CD_NM;
    }

    public void setCNPS_DST_CD_NM(String cNPS_DST_CD_NM) {
        CNPS_DST_CD_NM = cNPS_DST_CD_NM;
    }

    public String getCC_ID() {
        return CC_ID;
    }

    public void setCC_ID(String cC_ID) {
        CC_ID = cC_ID;
    }

    public String getCC_NM() {
        return CC_NM;
    }

    public void setCC_NM(String cC_NM) {
        CC_NM = cC_NM;
    }

    public String getBLTO_COMP_CD() {
        return BLTO_COMP_CD;
    }

    public void setBLTO_COMP_CD(String bLTO_COMP_CD) {
        BLTO_COMP_CD = bLTO_COMP_CD;
    }

    public String getBLTO_COMP_NM() {
        return BLTO_COMP_NM;
    }

    public void setBLTO_COMP_NM(String bLTO_COMP_NM) {
        BLTO_COMP_NM = bLTO_COMP_NM;
    }

    public String getOFPS_CD() {
        return OFPS_CD;
    }

    public void setOFPS_CD(String oFPS_CD) {
        OFPS_CD = oFPS_CD;
    }

    public String getOFPS_CD_NM() {
        return OFPS_CD_NM;
    }

    public void setOFPS_CD_NM(String oFPS_CD_NM) {
        OFPS_CD_NM = oFPS_CD_NM;
    }

    public String getRESO_CD() {
        return RESO_CD;
    }

    public void setRESO_CD(String rESO_CD) {
        RESO_CD = rESO_CD;
    }

    public String getRESO_CD_NM() {
        return RESO_CD_NM;
    }

    public void setRESO_CD_NM(String rESO_CD_NM) {
        RESO_CD_NM = rESO_CD_NM;
    }

    public String getRECRT_DST_CD() {
        return RECRT_DST_CD;
    }

    public void setRECRT_DST_CD(String rECRT_DST_CD) {
        RECRT_DST_CD = rECRT_DST_CD;
    }

    public String getRECRT_DST_CD_NM() {
        return RECRT_DST_CD_NM;
    }

    public void setRECRT_DST_CD_NM(String rECRT_DST_CD_NM) {
        RECRT_DST_CD_NM = rECRT_DST_CD_NM;
    }

    public String getHDOC_STAT_DTL_CD() {
        return HDOC_STAT_DTL_CD;
    }

    public void setHDOC_STAT_DTL_CD(String hDOC_STAT_DTL_CD) {
        HDOC_STAT_DTL_CD = hDOC_STAT_DTL_CD;
    }

    public String getHDOC_STAT_DTL_CD_NM() {
        return HDOC_STAT_DTL_CD_NM;
    }

    public void setHDOC_STAT_DTL_CD_NM(String hDOC_STAT_DTL_CD_NM) {
        HDOC_STAT_DTL_CD_NM = hDOC_STAT_DTL_CD_NM;
    }

    public String getCNTR_START_DATE() {
        return CNTR_START_DATE;
    }

    public void setCNTR_START_DATE(String cNTR_START_DATE) {
        CNTR_START_DATE = cNTR_START_DATE;
    }

    public String getCNTR_END_DATE() {
        return CNTR_END_DATE;
    }

    public void setCNTR_END_DATE(String cNTR_END_DATE) {
        CNTR_END_DATE = cNTR_END_DATE;
    }
}
