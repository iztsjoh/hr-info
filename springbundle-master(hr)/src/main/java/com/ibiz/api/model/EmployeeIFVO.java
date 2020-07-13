package com.ibiz.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeIFVO {
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
     * 주민등록번호
     */
    @JsonProperty("SSRG_NO")
    private String SSRG_NO;

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
     * 코스센터ID
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
     * 직위명
     */
    @JsonProperty("OFPS_CD_NM")
    private String OFPS_CD_NM;

    /**
     * 직위연차수
     */
    @JsonProperty("OFPS_YRVC_COUNT")
    private String OFPS_YRVC_COUNT;

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
     * 계약시작일
     */
    @JsonProperty("CNTR_START_DATE")
    private String CNTR_START_DATE;

    /**
     * 계약종료일
     */
    @JsonProperty("CNTR_END_DATE")
    private String CNTR_END_DATE;

    /**
     * 재직상태코드
     */
    @JsonProperty("HDOC_STAT_CD")
    private String HDOC_STAT_CD;

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
     * 회사전화번호
     */
    @JsonProperty("COMP_TEL_NO")
    private String COMP_TEL_NO;

    /**
     * 휴대폰번호
     */
    @JsonProperty("MBPH_NO")
    private String MBPH_NO;

    /**
     * 이메일주소
     */
    @JsonProperty("EML_ADRS")
    private String EML_ADRS;

    /**
     * 회사입사일
     */
    @JsonProperty("COMP_ENCM_DATE")
    private String COMP_ENCM_DATE;

    /**
     * 그룹입사일
     */
    @JsonProperty("GRP_ENCM_DATE")
    private String GRP_ENCM_DATE;

    /**
     * 휴직시작일
     */
    @JsonProperty("LVAB_START_DATE")
    private String LVAB_START_DATE;

    /**
     * 휴직종료일
     */
    @JsonProperty("LVAB_END_DATE")
    private String LVAB_END_DATE;

    /**
     * 퇴직일
     */
    @JsonProperty("RET_DATE")
    private String RET_DATE;

    /**
     * 직전사원ID
     */
    @JsonProperty("JBEF_EMP_ID")
    private String JBEF_EMP_ID;

    /**
     * 성별
     */
    @JsonProperty("SEX_CD")
    private String SEX_CD;


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



    public String getSSRG_NO() {
        return SSRG_NO;
    }



    public void setSSRG_NO(String sSRG_NO) {
        SSRG_NO = sSRG_NO;
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



    public String getOFPS_YRVC_COUNT() {
        return OFPS_YRVC_COUNT;
    }



    public void setOFPS_YRVC_COUNT(String oFPS_YRVC_COUNT) {
        OFPS_YRVC_COUNT = oFPS_YRVC_COUNT;
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



    public String getHDOC_STAT_CD() {
        return HDOC_STAT_CD;
    }



    public void setHDOC_STAT_CD(String hDOC_STAT_CD) {
        HDOC_STAT_CD = hDOC_STAT_CD;
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



    public String getCOMP_TEL_NO() {
        return COMP_TEL_NO;
    }



    public void setCOMP_TEL_NO(String cOMP_TEL_NO) {
        COMP_TEL_NO = cOMP_TEL_NO;
    }



    public String getMBPH_NO() {
        return MBPH_NO;
    }



    public void setMBPH_NO(String mBPH_NO) {
        MBPH_NO = mBPH_NO;
    }



    public String getEML_ADRS() {
        return EML_ADRS;
    }



    public void setEML_ADRS(String eML_ADRS) {
        EML_ADRS = eML_ADRS;
    }



    public String getCOMP_ENCM_DATE() {
        return COMP_ENCM_DATE;
    }



    public void setCOMP_ENCM_DATE(String cOMP_ENCM_DATE) {
        COMP_ENCM_DATE = cOMP_ENCM_DATE;
    }



    public String getGRP_ENCM_DATE() {
        return GRP_ENCM_DATE;
    }



    public void setGRP_ENCM_DATE(String gRP_ENCM_DATE) {
        GRP_ENCM_DATE = gRP_ENCM_DATE;
    }



    public String getLVAB_START_DATE() {
        return LVAB_START_DATE;
    }



    public void setLVAB_START_DATE(String lVAB_START_DATE) {
        LVAB_START_DATE = lVAB_START_DATE;
    }



    public String getLVAB_END_DATE() {
        return LVAB_END_DATE;
    }



    public void setLVAB_END_DATE(String lVAB_END_DATE) {
        LVAB_END_DATE = lVAB_END_DATE;
    }



    public String getRET_DATE() {
        return RET_DATE;
    }



    public void setRET_DATE(String rET_DATE) {
        RET_DATE = rET_DATE;
    }



    public String getJBEF_EMP_ID() {
        return JBEF_EMP_ID;
    }



    public void setJBEF_EMP_ID(String jBEF_EMP_ID) {
        JBEF_EMP_ID = jBEF_EMP_ID;
    }

    public String getSEX_CD() {
        return SEX_CD;
    }



    public void setSEX_CD(String sEX_CD) {
        SEX_CD = sEX_CD;
    }



    @Override
    public String toString() {
        return "IFUserBaseInfoVO [SND_STAT_CD=" + SND_STAT_CD + ", SND_STAT_MSG=" + SND_STAT_MSG + ", SND_JOB_CD=" + SND_JOB_CD + ", SND_DT=" + SND_DATE
                + ", SND_SEQ=" + SND_SEQ + ", DATA_CHG_DST_CD=" + DATA_CHG_DST_CD + ", SND_SYS_DST_CD=" + SND_SYS_DST_CD + ", EMP_ID=" + EMP_ID
                + ", EMP_NM=" + EMP_NM + ", SSRG_NO=" + SSRG_NO + ", BLTO_DEPT_ID=" + BLTO_DEPT_ID + ", BLTO_DEPT_NM=" + BLTO_DEPT_NM
                + ", CC_ID=" + CC_ID + ", CC_NM=" + CC_NM + ", OFPS_CD=" + OFPS_CD + ", OFPS_CD_NM=" + OFPS_CD_NM
                + ", OFPS_YRVC_COUNT=" + OFPS_YRVC_COUNT + ", RESO_CD=" + RESO_CD + ", RESO_CD_NM=" + RESO_CD_NM
                + ", RECRT_DST_CD=" + RECRT_DST_CD + ", RECRT_DST_CD_NM=" + RECRT_DST_CD_NM + ", CNTR_START_DATE=" + CNTR_START_DATE
                + ", CNTR_END_DATE=" + CNTR_END_DATE + ", HDOC_STAT_CD=" + HDOC_STAT_CD + ", HDOC_STAT_DTL_CD=" + HDOC_STAT_DTL_CD
                + ", HDOC_STAT_DTL_CD_NM=" + HDOC_STAT_DTL_CD_NM + ", COMP_TEL_NO=" + COMP_TEL_NO + ", MBPH_NO=" + MBPH_NO
                + ", EML_ADRS=" + EML_ADRS + ", COMP_ENCM_DATE=" + COMP_ENCM_DATE + ", GRP_ENCM_DATE=" + GRP_ENCM_DATE
                + ", LVAB_START_DATE=" + LVAB_START_DATE + ", LVAB_END_DATE=" + LVAB_END_DATE + ", RET_DATE=" + RET_DATE
                + ", JBEF_EMP_ID=" + JBEF_EMP_ID
                + "]";
    }
}
