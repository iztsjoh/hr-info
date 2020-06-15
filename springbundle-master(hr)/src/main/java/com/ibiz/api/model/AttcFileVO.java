package com.ibiz.api.model;

import java.util.List;

public class AttcFileVO {

    /**
     * 파일 첨부를 사용하는 영역 이름(board, customer, approval)
     */
    private String useCategory;
    /**
     * 파일 첨부를 사용하는 영역 테이블의 키값 (ex> board -> notcDocId)
     */
    private String useCategoryId;

    /**
     * 첨부아이디
     */
    private String attcId;

    /**
     * 첨부순번
     */
    private String attcSeq;

    /**
     * 첨부파일경로명
     */
    private String atcflRuteNm;

    /**
     * 첨부파일명
     */
    private String atcflNm;

    /**
     * 첨부파일확장자명
     */
    private String atcflExtsNm;

    /**
     * 첨부파일용량
     */
    private Long atcflCapa;

    /**
     * 가상파일명
     */
    private String virtualName;

    /**
     * DB pk vlolation이 발생한경우 문제가 발생한 아이디를 담아두는 임시 id
     */
    private String originAttcId ;

    /**
     * DB pk vlolation이 발생한경우 문제가 발생한 아이디를 담아두는 임시 Seq
     */
    private String originAttcSeq ;

    /**
     * DB pk vlolation이 발생한경우 문제가 발생한 게시판의 ID;
     */
    private String bbsId;
    /**
     * DB pk vlolation이 발생한경우 문제가 발생한 게시문서 ID;
     */
    private String notcDocId;

    /**
     * DB pk vlolation이 발생한경우 문제가 발생한 고객 ID;
     */
    private String custId;

    /**
     * DB pk vlolation이 발생한경우 문제가 발생한 결재 ID;
     */
    private String santId;

    /**
     * 사용하지않으며, 기존 코드와의 호환성으로 남겨둠
     */
    private List<AttcFileVO> attcFileVO;

    private String state;

    public String getUseCategory() {
        return useCategory;
    }

    public void setUseCategory(String useCategory) {
        this.useCategory = useCategory;
    }

    public String getUseCategoryId() {
        return useCategoryId;
    }

    public void setUseCategoryId(String useCategoryId) {
        this.useCategoryId = useCategoryId;
    }

    public String getAttcId() {
        return attcId;
    }

    public void setAttcId(String attcId) {
        this.attcId = attcId;
    }

    public String getAttcSeq() {
        return attcSeq;
    }

    public void setAttcSeq(String attcSeq) {
        this.attcSeq = attcSeq;
    }

    public String getAtcflRuteNm() {
        return atcflRuteNm;
    }

    public void setAtcflRuteNm(String atcflRuteNm) {
        this.atcflRuteNm = atcflRuteNm;
    }

    public String getAtcflNm() {
        return atcflNm;
    }

    public void setAtcflNm(String atcflNm) {
        this.atcflNm = atcflNm;
    }

    public String getAtcflExtsNm() {
        return atcflExtsNm;
    }

    public void setAtcflExtsNm(String atcflExtsNm) {
        this.atcflExtsNm = atcflExtsNm;
    }

    public Long getAtcflCapa() {
        return atcflCapa;
    }

    public void setAtcflCapa(Long atcflCapa) {
        this.atcflCapa = atcflCapa;
    }

    public String getVirtualName() {
        return virtualName;
    }

    public void setVirtualName(String virtualName) {
        this.virtualName = virtualName;
    }

    public String getOriginAttcId() {
        return originAttcId;
    }

    public void setOriginAttcId(String originAttcId) {
        this.originAttcId = originAttcId;
    }

    public String getOriginAttcSeq() {
        return originAttcSeq;
    }

    public void setOriginAttcSeq(String originAttcSeq) {
        this.originAttcSeq = originAttcSeq;
    }

    public String getBbsId() {
        return bbsId;
    }

    public void setBbsId(String bbsId) {
        this.bbsId = bbsId;
    }

    public String getNotcDocId() {
        return notcDocId;
    }

    public void setNotcDocId(String notcDocId) {
        this.notcDocId = notcDocId;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getSantId() {
        return santId;
    }

    public void setSantId(String santId) {
        this.santId = santId;
    }

    public List<AttcFileVO> getAttcFileVO() {
        return attcFileVO;
    }

    public void setAttcFileVO(List<AttcFileVO> attcFileVO) {
        this.attcFileVO = attcFileVO;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
