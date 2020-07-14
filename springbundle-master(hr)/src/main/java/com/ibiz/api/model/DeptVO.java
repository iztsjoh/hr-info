package com.ibiz.api.model;

import com.ibiz.api.exception.ExceptionCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;

public class DeptVO {
    /**
     * 붓서ID
     */
    @Size(min=1,max=8, message= ExceptionCode.OUTOFSIZE_EXCEPTION+" 부서아이디는 8자리이하" + ExceptionCode.OUTOFSIZE_EXCEPTION_MESSAGE)
    private String deptId;

    /**
     * 붓서명
     */
    private String deptNm;

    /**
     * 상위부서id
     */
    private String hgrkDeptId;

    /**
     * 상위부서명
     */
    private String hgrkDeptNm;

    /**
     * 부서정렬순서
     */
    private String deptSortSeqc;

    /**
     * 부서레벨
     */
    private String deptLvlCd;

    /**
     * 부서레벨명
     */
    private String deptLvlCdNm;

    /**
     * 브사징ID
     */
    private String hddpEmpId;

    /**
     * 부서장명
     */
    private String hddpEmpNm;

    /**
     * 메츨브사
     */

    private String sellOcrYn;

    /**
     * 조직생성일
     */
    private String orgCrtDate;

    /**
     * 조직폐쇄일
     */
    private String orgCloseDate;

    /**
     * 이력시작일
     */
    @DateTimeFormat
    private String avlStartDate;

    /**
     * 이력종료일
     */
    @DateTimeFormat
    private String avlEndDate;

    /**
     * 부서장직위명
     */
    private String ofpsCdNm;

    /**
     * 부서장직위코드
     */
    private String ofpsCd;

    /**
     * 기준일자
     */
    private String stadDate;

    /**
     * 추가 또는 변경 가능 여부
     */
    private String valChk;

    /**
     * 추가 변경 사용자 ID
     */
    private String chgEmpId;

    /**
     * list Count
     */
    private Integer listCnt;

    /**
     * 페이지사이즈
     */
    private Integer pageSize;

    /**
     * 페이지넘버
     */
    private Integer pageNumber;

    /**
     * rowNumber
     */
    private Integer rowNumber;

    /**
     * depthLevel
     */
    private Integer depthLevel;

    /**
     * orgDstCd
     */
    private String orgDstCd;

    /**
     * orgDstCdNm
     */
    private String orgDstCdNm;

    /**
     * 기준일자
     */
    private String standardDate;

    /**
     * 이력추가 여부
     * */
    private String isAddRecord;


    /**
     * 신규등록 여부
     */
    private String isCreating;


    /**
     * 사용자그룹(권한체크를 위해 추가됨)
     */
    private String userGrpCd;

    /**
     * 기준연도(권한체크를 위해 추가됨)
     */
    private String critYear;

    /**
     * 소속사 코드 (인젠트, 콤텍)
     */
    private String bltcCd;

    /**
     * 부서 생성일자
     */
    private String crtDate;

    /**
     * 부서 폐쇄 일자
     */
    private String closeDate;

    /**
     * 등록사원 ID
     */
    private String regEmpId;

    /**
     * 등록일시
     */
    private String regDt;

    /**
     * 변경일시
     */
    private String chgDt;

    /**
     * 검색값
     */
    private String searchValue;

    /**
     * 조건검색시 표시제한할 부서들
     */
    private String deptIds;

    /**
     * 하위부서 카운팅
     */
    private Integer cntLowerDeptID;

    /**
     * 하위부서(자식) 갯수
     */
    private Integer lowerCnt;

    /**
     * 영업대표(권한체크를 위해 추가됨)
     */
    private String slsEmpId;

    /**
     * 시스템사용자(권한체크를 위해 추가됨)
     */
    private String empId;

    /**
     * 토탈사이즈(권한체크를 위해 추가됨)
     */
    private Integer totalSize;

    private String isAllAuth;

    /**
     * userGrpCd를 기준으로 부서를 조회하나 우선 적용될 userGrpCd가 필요할 시에 사용
     */
    private String priorUserGrpCd;


    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptNm() {
        return deptNm;
    }

    public void setDeptNm(String deptNm) {
        this.deptNm = deptNm;
    }

    public String getHgrkDeptId() {
        return hgrkDeptId;
    }

    public void setHgrkDeptId(String hgrkDeptId) {
        this.hgrkDeptId = hgrkDeptId;
    }

    public String getHgrkDeptNm() {
        return hgrkDeptNm;
    }

    public void setHgrkDeptNm(String hgrkDeptNm) {
        this.hgrkDeptNm = hgrkDeptNm;
    }

    public String getDeptSortSeqc() {
        return deptSortSeqc;
    }

    public void setDeptSortSeqc(String deptSortSeqc) {
        this.deptSortSeqc = deptSortSeqc;
    }

    public String getDeptLvlCd() {
        return deptLvlCd;
    }

    public void setDeptLvlCd(String deptLvlCd) {
        this.deptLvlCd = deptLvlCd;
    }

    public String getDeptLvlCdNm() {
        return deptLvlCdNm;
    }

    public void setDeptLvlCdNm(String deptLvlCdNm) {
        this.deptLvlCdNm = deptLvlCdNm;
    }

    public String getHddpEmpId() {
        return hddpEmpId;
    }

    public void setHddpEmpId(String hddpEmpId) {
        this.hddpEmpId = hddpEmpId;
    }

    public String getHddpEmpNm() {
        return hddpEmpNm;
    }

    public void setHddpEmpNm(String hddpEmpNm) {
        this.hddpEmpNm = hddpEmpNm;
    }

    public String getSellOcrYn() {
        return sellOcrYn;
    }

    public void setSellOcrYn(String sellOcrYn) {
        this.sellOcrYn = sellOcrYn;
    }

    public String getOrgCrtDate() {
        return orgCrtDate;
    }

    public void setOrgCrtDate(String orgCrtDate) {
        this.orgCrtDate = orgCrtDate;
    }

    public String getOrgCloseDate() {
        return orgCloseDate;
    }

    public void setOrgCloseDate(String orgCloseDate) {
        this.orgCloseDate = orgCloseDate;
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

    public String getOfpsCdNm() {
        return ofpsCdNm;
    }

    public void setOfpsCdNm(String ofpsCdNm) {
        this.ofpsCdNm = ofpsCdNm;
    }

    public String getOfpsCd() {
        return ofpsCd;
    }

    public void setOfpsCd(String ofpsCd) {
        this.ofpsCd = ofpsCd;
    }

    public String getStadDate() {
        return stadDate;
    }

    public void setStadDate(String stadDate) {
        this.stadDate = stadDate;
    }

    public String getValChk() {
        return valChk;
    }

    public void setValChk(String valChk) {
        this.valChk = valChk;
    }

    public String getChgEmpId() {
        return chgEmpId;
    }

    public void setChgEmpId(String chgEmpId) {
        this.chgEmpId = chgEmpId;
    }

    public Integer getListCnt() {
        return listCnt;
    }

    public void setListCnt(Integer listCnt) {
        this.listCnt = listCnt;
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

    public Integer getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(Integer rowNumber) {
        this.rowNumber = rowNumber;
    }

    public Integer getDepthLevel() {
        return depthLevel;
    }

    public void setDepthLevel(Integer depthLevel) {
        this.depthLevel = depthLevel;
    }

    public String getOrgDstCd() {
        return orgDstCd;
    }

    public void setOrgDstCd(String orgDstCd) {
        this.orgDstCd = orgDstCd;
    }

    public String getOrgDstCdNm() {
        return orgDstCdNm;
    }

    public void setOrgDstCdNm(String orgDstCdNm) {
        this.orgDstCdNm = orgDstCdNm;
    }

    public String getStandardDate() {
        return standardDate;
    }

    public void setStandardDate(String standardDate) {
        this.standardDate = standardDate;
    }

    public String getIsAddRecord() {
        return isAddRecord;
    }

    public void setIsAddRecord(String isAddRecord) {
        this.isAddRecord = isAddRecord;
    }

    public String getIsCreating() {
        return isCreating;
    }

    public void setIsCreating(String isCreating) {
        this.isCreating = isCreating;
    }

    public String getUserGrpCd() {
        return userGrpCd;
    }

    public void setUserGrpCd(String userGrpCd) {
        this.userGrpCd = userGrpCd;
    }

    public String getCritYear() {
        return critYear;
    }

    public void setCritYear(String critYear) {
        this.critYear = critYear;
    }

    public String getBltcCd() {
        return bltcCd;
    }

    public void setBltcCd(String bltcCd) {
        this.bltcCd = bltcCd;
    }

    public String getCrtDate() {
        return crtDate;
    }

    public void setCrtDate(String crtDate) {
        this.crtDate = crtDate;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
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

    public String getChgDt() {
        return chgDt;
    }

    public void setChgDt(String chgDt) {
        this.chgDt = chgDt;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(String deptIds) {
        this.deptIds = deptIds;
    }

    public Integer getCntLowerDeptID() {
        return cntLowerDeptID;
    }

    public void setCntLowerDeptID(Integer cntLowerDeptID) {
        this.cntLowerDeptID = cntLowerDeptID;
    }

    public Integer getLowerCnt() {
        return lowerCnt;
    }

    public void setLowerCnt(Integer lowerCnt) {
        this.lowerCnt = lowerCnt;
    }

    public String getSlsEmpId() {
        return slsEmpId;
    }

    public void setSlsEmpId(String slsEmpId) {
        this.slsEmpId = slsEmpId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public String getIsAllAuth() {
        return isAllAuth;
    }

    public void setIsAllAuth(String isAllAuth) {
        this.isAllAuth = isAllAuth;
    }

    public String getPriorUserGrpCd() {
        return priorUserGrpCd;
    }

    public void setPriorUserGrpCd(String priorUserGrpCd) {
        this.priorUserGrpCd = priorUserGrpCd;
    }
}
