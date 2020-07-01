package com.ibiz.api.exception;

public class ExceptionCode {

    /*
     * 대분류      중분류       소분류	                  명칭
     *  00      00      00      Unhandled Exception
     *
     *  01						공통
     *  01		01				공통 - DB
     *  01		01		01		공통 - DB - DB EXCEPTION
     *  01      01      02		공통 - DB - UNIQUE INDEX 채번 실패
     *  01      01      03		공통 - DB - 중복된 코드 존재
     *  01		01		04		공통 = DB - Transaction Lock 획득 실패
     *
     *  01		02				공통 - 계정
     *  01		02		01		공통 - 계정 - 계정 정보 미전달
     *  01		02		02		공통 - 계정 - ID 미전달
     *  01		02		03		공통 - 계정 - PW 미전달
     *  01		02		04		공통 - 계정 - ID 존재하지 않음
     *  01		02		05		공통 - 계정 - PW 일치하지 않음
     *  01		02		06		공통 - 계정 - PID 미전달
     *  01		02		07		공통 - 계정 - 조회권한 없음
     *  01		02		08		공통 - 계정 - 회원이 아님
     *  01		02		09		공통 - 계정 - 수정권한 없음
     *  01		02		10		공통 - 계정 - 삭제권한 없음
     *  01		02		11		공통 - 계정 - 중복된 ID
     *  01		02		12		공통 - 계정 - 서비스 일련번호 오류
     *  01		02		13		공통 - 계정 - 삭제된 ID
     *  01		02		14		공통 - 계정 - 미승인 ID
     *
     *
     *  01		03				공통 - 세션
     *  01		03		01		공통 - 세션 - 세션 만료
     *  01		03		02		공통 - 세션 - 세션 데이터 변환 오류
     *
     *  01		04				공통 - 통신
     *  01		04		01		공통 - 통신 - 파라미터 미전달
     *  01		04		02		공통 - 통신 - 파라미터 오류
     *
     *  01		05				공통 - 암호화
     *  01		05		01		공통 - 암호화 - 암호화 오류
     *
     *  01		07				공통 - Thread
     *  01		07		01		공통 - Thread - Thread Exception
     *
     *  01		08				공통 - 검증
     *  01		08		01		공통 - 검증 - 예외처리 되지 않은 오류
     *
     *  01      09      01  	공통 - 화면 - View 동기화 에러 (페이지 갱신)
     *
     *
     *  11 						메뉴
     *  11		01				메뉴 - 조회
     * 	11		01		01		메뉴 - 조회 - 항목 없음
     *  11		01		02		메뉴 - 조회 - 파라미터 미전달
     *  11		01		03		메뉴 - 조회 - 메뉴 코드 미전달
     *  11		01		04		메뉴 - 조회 - 조회권한 없음
     *
     *
     *  21						파일
     *  21		01				파일 - 엑셀
     *  21		01		01		파일 - 엑셀 - 파일 읽기 실패
     *  21		01		02		파일 - 엑셀 - 데이터가 없음
     *  21		01		03		파일 - 엑셀 - 필수 항목이 존재하지 않음
     *  21		01		04		파일 - 엑셀 - 중복된 KEY 정보
     *
     *  21		02		01		파일 - 기타 - 파일이 존재하지 않음
     *  21		02		02		파일 - 기타 - 업로드 파일 용량 초과
     *  21		02		03		파일 - 기타 - 허용되지 않은 파일 형식
     *  21		02		04		파일 - 기타 - 업로드 실패
     *  21		02		05		파일 - 기타 - 업로드 개수 초과
     *
     *
     *
     *  31						서비스
     *  31		01				서비스 - 상태
     *  31		01		01		서비스 - 상태 - 삭제되었음.
     *  31		01		02		서비스 - 상태 - 오류.
     *  31      01		03 		서비스 - 상태 - 동기화 오류
     *
     *  31		02		01 		서비스 - 정책 - 삭제할 수 없음
     *  31		02		02		서비스 - 정책 - 예상손익분석/견적서가 존재하여 삭제 불가능합니다.
     *
     *  31		03		01		서비스 - 코드 - 중복된 코드 존재
     *  31		03		02		서비스 - 코드 - 하위 코드 존재 삭제 불가
     *
     *
     *  32       				결재
     *  32		01				결재 - 상태
     *  32		01		01		결재 - 상태 - 오류
     *
     *  32		02		01		결재 - 결재자 - 오류
     *
     */



    public static final String NO_DEFINITION_EXCEPTION	="00";public static final String NO_DEFINITION_EXCEPTION_MESSAGE="관리자에게 문의하세요";
    public static final String NOTNULL_EXCEPTION="01";public static final String NOTNULL_EXCEPTION_MESSAGE="null or blank";
    public static final String OUTOFSIZE_EXCEPTION="02";public static final String OUTOFSIZE_EXCEPTION_MESSAGE="size";
    public static final String CODE_OVERLAP_EXCEPTION="03";public static final String CODE_OVERLAP_EXCEPTION_MESSAGE="중복 코드";
    public static final String CODE_NOT_EQUAL_EXCEPTION="04";public static final String CODE_NOT_EQUAL_EXCEPTION_MESSAGE="코드 불 일치";
    public static final String NO_AUTHORIZATION_EXCEPTION="05";public static final String NO_AUTHORIZATION_EXCEPTION_MESSAGE="권한 없음";
    public static final String DELETED_PAGE_EXCEPTION="06";public static final String DELETED_PAGE_EXCEPTION_MESSAGE="삭제된 페이지";
    public static final String MISSMATCH_EMAIL_TYPE_EXCPETION="07";public static final String MISSMATCH_EMAIL_TYPE_EXCPETION_MESSAGE="이메일 형식이 맞지않음";
    public static final String MISSMATCH_DATE_TYPE_EXCPETION="08";public static final String MISSMATCH_DATE_TYPE_EXCPETION_MESSAGE="날짜 형식오류";
    public static final String MISSMATCH_NUMBER_TYPE_EXCPETION="09";public static final String MISSMATCH_NUMBER_TYPE_EXCPETION_MESSAGE="숫자 타입";
    public static final String MISSMATCH_CHARACTOR_TYPE_EXCPETION="10";public static final String MISSMATCH_CHARACTOR_TYPE_EXCPETION_MESSAGE="문자 타입";
    public static final String DATE_OVERLAP_EXCEPTION="11";public static final String DATE_OVERLAP_EXCEPTION_MESSAGE="기간중복";
    public static final String 	NO_HISTORY_EXCEPTION	="12";	public static final String 	NO_HISTORY_EXCEPTION_MESSAGE ="이력이 존재하지 않습니다";




    public static final String COMMON_DB_TRANSACTION_EXCEPTION = "IBIZ_010104";
    public static final String COMMON_DB_TRANSACTION_EXCEPTION_MESSAGE = "잠시후 다시 시도해주세요.";

    public static final String UNIQUE_INDEXING_FAIL = "IBIZ_010102";
    public static final String UNIQUE_INDEXING_FAIL_MESSAGE = "UNIQUE INDEX 채번 실패";

    public static final String MAIL_MESSAGING_FAIL = "IBIZ_010103";
    public static final String MAIL_MESSAGING_FAIL_MESSAGE = "이메일 메세징 실패";

    public static final String MAIL_SEND_FAIL = "IBIZ_010104";
    public static final String MAIL_SEND_FAIL_MESSAGE = "메일 전송 실패";


    public static final String COMMON_ACCOUNT_PARAMETER_NOT_FOUND = "IBIZ_010201";
    public static final String COMMON_ACCOUNT_PARAMETER_ID_NOT_FOUND = "IBIZ_010202";
    public static final String COMMON_ACCOUNT_PARAMETER_PW_NOT_FOUND = "IBIZ_010203";
    public static final String COMMON_ACCOUNT_ID_NOT_EXIST = "IBIZ_010204";
    public static final String COMMON_ACCOUNT_PW_DISAGREEMENT = "IBIZ_010205";
    public static final String COMMON_ACCOUNT_PARAMETER_PID_NOT_FOUND = "IBIZ_010206";
    public static final String COMMON_ACCOUNT_ACCESS_REJECTION = "IBIZ_010207";
    public static final String COMMON_ACCOUNT_NOT_MEMBER = "IBIZ_010208";
    public static final String COMMON_ACCOUNT_UPDATE_REJECTION = "IBIZ_010209";
    public static final String COMMON_ACCOUNT_DELETE_REJECTION = "IBIZ_010210";
    public static final String COMMON_ACCOUNT_DUPLICATE_ID = "IBIZ_010211";
    public static final String COMMON_ACCOUNT_SERVICE_CODE_INVALID = "IBIZ_010212";
    public static final String COMMON_ACCOUNT_ID_DELETE = "IBIZ_010213";
    public static final String COMMON_ACCOUNT_UNRECEIVED = "IBIZ_010214";

    public static final String COMMON_SESSION_EXPIRED = "IBIZ_010301";
    public static final String COMMON_SESSION_DATA_CONVERT_EXCEPTION = "IBIZ_010302";

    public static final String COMMON_PARAMETER_NOT_FOUND = "IBIZ_010401";
    public static final String COMMON_PARAMETER_INVALID = "IBIZ_010402";

    public static final String COMMON_ENCRYPTION_EXCEPTION = "IBIZ_010501";

    public static final String COMMON_THREAD_EXCEPTION = "IBIZ_010701";

    public static final String COMMON_VALIDATION_UNEXCEPTED_ERROR = "IBIZ_010801";

    public static final String COMMON_VIEW_SYNCHRONIZATION_EXCEPTION = "IBIZ_010901";
    public static final String COMMON_VIEW_SYNCHRONIZATION_EXCEPTION_MESSAGE = "화면 갱신이 필요합니다.";

    public static final String MENU_ACCESS_LIST_NOT_FOUND = "IBIZ_100101";
    public static final String MENU_ACCESS_PARAMETER_NOT_FOUND = "IBIZ_100102";
    public static final String MENU_ACCESS_MENU_CODE_NOT_FOUND = "IBIZ_100103";
    public static final String MENU_ACCESS_REJECTION = "IBIZ_100104";

    public static final String FILE_EXCEL_READ_FAIL = "IBIZ_210101";
    public static final String FILE_EXCEL_DATA_NOT_FOUND = "IBIZ_210102";
    public static final String FILE_EXCEL_DATA_REQUIRED_NOT_FOUND = "IBIZ_210103";
    public static final String FILE_EXCEL_DATA_DUPLICATION = "IBIZ_210104";

    public static final String FILE_NOT_FOUND = "IBIZ_210201";
    public static final String FILE_EXCEED_UPLOAD_CAPACITY = "IBIZ_210202";
    public static final String FILE_CONTENT_TYPE_NOT_ALLOW = "IBIZ_210203";
    public static final String FILE_UPLOAD_FAIL = "IBIZ_210204";
    public static final String FILE_UPLOAD_OVERFLOW = "IBIZ_210205";


    public static final String SERVICE_STATUS_DELETE = "IBIZ_310101";
    public static final String SERVICE_STATUS_EXCEPTION = "IBIZ_310102";


    public static final String DELETE_DENIED_EXCEPTION = "IBIZ_310201";
    public static final String DELETE_DENIED_EXCEPTION_MESSAGE = "삭제할 수 없음";

    public static final String SERVICE_CODE_EXIST = "IBIZ_310301";
    public static final String SERVICE_CODE_EXIST_MESSAGE = "중복된 코드 존재 입력불가";

    public static final String SERVICE_CODE_INCLUDECODE_EXIST = "IBIZ_310302";
    public static final String SERVICE_CODE_INCLUDECODE_EXIST_MESSAGE = "하위공통코드가 존재하여 삭제할 수 없습니다";


    public static final String DELETE_DENIED_BOPT_EXCEPTION = "IBIZ_310202";
    public static final String DELETE_DENIED_BOPT_EXCEPTION_MESSAGE = "예상손익분석 / 견적서가 존재하여 삭제 불가능합니다.";

    public static final String APPROVAL_STATE_EXCEPTION = "IBIZ_320101";
    public static final String APPROVAL_STATE_EXCEPTION_MESSAGE = "문서상태가 변경되어 결재진행이 불가능합니다.";

    public static final String APPROVER_STATE_EXCEPTION = "IBIZ_320201";
    public static final String APPROVER_STATE_EXCEPTION_MESSAGE = "결재자 정보가 변경되어 결재진행이 불가능합니다.";
}
