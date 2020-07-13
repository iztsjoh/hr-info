package com.ibiz.api.dao;

import com.ibiz.api.model.*;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "deptDAO")
public class DeptDAO {

    @Autowired
    private SqlSessionTemplate mybatis;

    /*
     * SELECT : 왼쪽 조직트리 조회
     */
    public List<DeptHistoryVO> selectDeptTree(DeptHistoryVO deptHistoryVO) {
        return mybatis.selectList("DeptMapper.selectDeptTree", deptHistoryVO);
    }

    /*
     * SELECT : 특정조직의 변경이력 조회
     */
    public List<DeptHistoryVO> selectDeptHistoryList(DeptHistoryVO deptHistoryVO) {
        return mybatis.selectList("DeptMapper.selectDeptHistoryList", deptHistoryVO);
    }

    /*
     * SELECT : 마지막 변경이력 조회
     */
    public DeptHistoryVO selectLastDeptHistoryList(DeptHistoryVO deptHistoryVO) {
        return mybatis.selectOne("DeptMapper.selectLastDeptHistoryList", deptHistoryVO);
    }

    /*
     * SELECT : 등록/변경하려는 내용의 적합성 판단
     * @param : DeptId, AvlStartDate
     */
    public DeptHistoryVO selectIsValidDept(DeptHistoryVO deptHistoryVO) {
        return mybatis.selectOne("DeptMapper.selectIsValidDept", deptHistoryVO);
    }

    /*
     * SELECT : 특정부서의 최신 이력 가져오기
     */
    public DeptHistoryVO selectDeptLastChgHistory(DeptHistoryVO deptHistoryVO) {
        return mybatis.selectOne("DeptMapper.selectDeptLastChgHistory", deptHistoryVO);
    }

    /*
     * SELECT : 특정부서의 변경이력 카운트 수
     */
    public DeptHistoryVO selectDeptHistoryCnt(DeptHistoryVO deptHistoryVO) {
        return mybatis.selectOne("DeptMapper.selectDeptHistoryCnt", deptHistoryVO);
    }


    /*
     * INSERT : 부서정보 추가
     */
    public int insertDeptInfo(DeptHistoryVO deptHistoryVO) {
        return mybatis.insert("DeptMapper.insertDeptInfo", deptHistoryVO);

    }

    /*
     * INSERT : 부서이력추가
     */
    public int insertDeptChgHistory(DeptHistoryVO deptHistoryVO) {
        return mybatis.insert("DeptMapper.insertDeptChgHistory", deptHistoryVO);
    }

    /*
     * UPDATE : 최신 부서정보로 변경
     */
    public int updateDeptInfo(DeptHistoryVO deptHistoryVO) {
        return mybatis.update("DeptMapper.updateDeptInfo", deptHistoryVO);
    }

    /*
     * UPDATE : 부서이력 변경
     */
    public int updateDeptChgHistory(DeptHistoryVO deptHistoryVO) {
        return mybatis.update("DeptMapper.updateDeptChgHistory", deptHistoryVO);
    }

    /*
     * UPDATE : 이력유효일자 변경
     */
    public int updateDeptLastAvlEndDate(DeptHistoryVO deptHistoryVO) {
        return mybatis.update("DeptMapper.updateDeptLastAvlEndDate", deptHistoryVO);
    }

    /*
     * DELETE : 부서정보삭제
     */
    public int deleteDeptInfo(DeptHistoryVO deptHistoryVO) {
        return mybatis.delete("DeptMapper.deleteDeptInfo", deptHistoryVO);
    }

    /*
     * DELETE : 부서이력 삭제
     */
    public int deleteDeptChgHistory(DeptHistoryVO deptHistoryVO) {
        return mybatis.delete("DeptMapper.deleteDeptChgHistory", deptHistoryVO);
    }

    /**
     * 8/6
     * */

    /*
     * SELECT : 조직트리 기준일자에 맞는 상위조직 리스트 뽑아오기
     * */

    public List<DeptHistoryVO> selectHgrkDeptFromAvlDateList(DeptHistoryVO deptHistoryVO) {
        return mybatis.selectList("DeptMapper.selectHgrkDeptFromAvlDateList", deptHistoryVO);
    }

    public List<DeptHistoryVO> selectDeptListWhenAddRecord(DeptHistoryVO deptHistoryVO) {
        return mybatis.selectList("DeptMapper.selectDeptListWhenAddRecord", deptHistoryVO);
    }

    public List<DeptHistoryVO> selectHgrkDeptWhenAddRecordList(DeptHistoryVO deptHistoryVO) {
        return mybatis.selectList("DeptMapper.selectHgrkDeptWhenAddRecordList", deptHistoryVO);
    }

    /* 선택한 부서 자체의 종료일자 조회 */
    public DeptHistoryVO selectDeptCloseDate(DeptHistoryVO deptHistoryVO) {
        return mybatis.selectOne("DeptMapper.selectDeptCloseDate", deptHistoryVO);
    }

    /* 부서의 종료일자를 입력받은 종료일자로 변경 */
    public int updateDeptCloseDate(DeptHistoryVO deptHistoryVO) {
        return mybatis.update("DeptMapper.updateDeptCloseDate", deptHistoryVO);
    }

    /* 특정부서의 임직원 숫자 조회 */
    public int selectDeptEmployeeCnt(DeptHistoryVO deptHistoryVO) {
        return mybatis.selectOne("DeptMapper.selectDeptEmployeeCnt", deptHistoryVO);
    }

    /* 신규등록하기 전 중복 체크 */
    public int selectIsDuplicateDept(DeptHistoryVO deptHistoryVO) {
        return mybatis.selectOne("DeptMapper.selectIsDuplicateDept", deptHistoryVO);
    }

    /* 조직 최종이력의  유효종료일자 */
    public String selectLastAvlEndDate(DeptHistoryVO deptHistoryVO) {
        return mybatis.selectOne("DeptMapper.selectLastAvlEndDate", deptHistoryVO);
    }

    /**
     * @return
     * @throws Exception
     * @description 부서명 조회 All
     */
    public List<DeptVO> selectAllDeptList(DeptVO deptVO) throws Exception {
        return mybatis.selectList("DeptMapper.selectAllDeptList", deptVO);

    }

    /**
     * @return
     * @throws Exception
     * @description 권한별 부서 조회
     */
    public List<DeptVO> selectAuthDeptList(DeptVO deptVO) throws Exception {
        return mybatis.selectList("DeptMapper.selectAuthDeptList", deptVO);
    }


    /**
     * @return
     * @throws Exception
     * @description 부서명 검색조건에 따른 조회
     */
    public List<DeptVO> selectDeptSearchList(DeptVO deptVO) throws Exception {
        return mybatis.selectList("DeptMapper.selectDeptSearchList", deptVO);
    }


    /**
     * @return
     * @description  영업대표에 따른 수정삭제권한체크
     */
    public DeptVO selectIsAuthBySlsEmp(DeptVO deptVO) throws Exception{
        return mybatis.selectOne("DeptMapper.selectIsAuthBySlsEmp",deptVO);
    }


    /* 조직 정보 조회 엑셀 */
    public List<ExcelDeptVO> selectExcelDwnlDeptList(DeptVO deptVO) throws Exception {
        return mybatis.selectList("DeptMapper.selectExcelDwnlDeptList", deptVO);
    }

    /* 조직이력 이력 정보 조회 엑셀 */
    public List<ExcelDeptHistoryVO> selectExcelDwnlDeptHistoryList(DeptVO deptVO) throws Exception {
        return mybatis.selectList("DeptMapper.selectExcelDwnlDeptHistoryList", deptVO);
    }


}