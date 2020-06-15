package com.ibiz.api.model;

public class JsonObject<T, K> {

    /**
     * 성공여부
     */
    public boolean IsSucceed = false;
    /**
     * 성공시 반환 데이터
     */
    public T Data;
    /**
     * 성공시 반환 데이터의 length
     */
    public int TotalSize;
    /**
     * 성공시 나타낼 팝업 메시지
     */
    public String InfoLayoutMessage;
    /**
     * 오류 코드 번호
     */
    public String ErrorNumber;
    /**
     * 오류 사유
     */
    public String ErrorCause;
    /**
     * 오류 메시지 상세
     */
    public String ErrorMessage;
    /**
     * 모달의 제목
     */
    public String Title;
    /**
     * 페이지 이동 URL
     */
    public String RedirectUrl;
    /**
     * 강제 페이지 이동 URL
     */
    public String ForcedRedirectUrl;
    /**
     * client에 내려줄 DoubleSubmit 데이터
     */
    public Object DoubleSubmitData;

    /**
     * DoubleSubmit 오류가 발생되면 true 입니다.
     */
    public boolean InvalidDoubleSubmit;

    /**
     * 결재자 변경 삭제시 오류가 발생된 리스트
     */
    public K ErrorList;

}
