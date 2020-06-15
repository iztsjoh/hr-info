package com.ibiz.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IFPublicKeyVO {
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
     * 공개키
     */
    @JsonProperty("PUBLICK_KEY")
    private String PUBLICK_KEY;

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

    public String getPUBLICK_KEY() {
        return PUBLICK_KEY;
    }

    public void setPUBLICK_KEY(String pUBLICK_KEY) {
        PUBLICK_KEY = pUBLICK_KEY;
    }
}
