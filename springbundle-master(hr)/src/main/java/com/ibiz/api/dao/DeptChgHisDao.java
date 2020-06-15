package com.ibiz.api.dao;

import com.ibiz.api.model.DeptChgHisVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "deptChgHisDao")
public class DeptChgHisDao {

    @Autowired
    private SqlSessionTemplate mybatis;

    /*
     * SELECT : 왼쪽 조직트리 조회
     */
    public List<DeptChgHisVO> selectDeptTree(DeptChgHisVO deptchghisVo) {
        return mybatis.selectList("DeptChgHisMapper.Select_DeptTreeList", deptchghisVo);
    }

    /*
     * SELECT : 특정조직의 등록가능한 상위조직 조회
     */
    public List<DeptChgHisVO> selectDeptHighTree(DeptChgHisVO deptchghisVo) {
        return mybatis.selectList("DeptChgHisMapper.Select_DeptHighTreeList", deptchghisVo);
    }

/*    *//*
     * SELECT : 조직 다운로드
     *//*
    public List<ExcelDeptInfoVO> selectDeptInfoDownload(DeptChgHisVO deptchghisVo) throws Exception {
        return mybatis.selectList(MAPPER_PATH + "DeptChgHisMapper.Select_DeptInfoDownload", deptchghisVo);
    }

    *//*
     * SELECT : 조직 이력 다운로드
     *//*
    public List<ExcelDeptChgHisVO> selectDeptHisDownload(DeptChgHisVO deptchghisVo) throws Exception {
        return mybatis.selectList(MAPPER_PATH + "DeptChgHisMapper.Select_DeptHisDownload", deptchghisVo);
    }*/

    /*
     * SELECT : 특정조직의 변경이력 조회
     */
    public List<DeptChgHisVO> selectDeptHisList(DeptChgHisVO deptchghisVo) {
        return mybatis.selectList("DeptChgHisMapper.Select_DeptChgHisList", deptchghisVo);
    }

    /*
     * SELECT : 마지막 변경이력 조회
     */
    public DeptChgHisVO selectLastDeptHisList(DeptChgHisVO deptChghisVo) {
        return mybatis.selectOne("DeptChgHisMapper.Select_LastDeptHisList", deptChghisVo);
    }

    /*
     * SELECT : 등록/변경하려는 내용의 적합성 판단
     * @param : DeptId, AvlStartDate
     */
    public DeptChgHisVO selectDeptValidationCheck(DeptChgHisVO deptchghisVo) {
        return mybatis.selectOne("DeptChgHisMapper.Select_DeptValidationCheck", deptchghisVo);
    }

    /*
     * SELECT : 신규 부서등록시 부서ID 값 가져오기
     */
    public DeptChgHisVO selectDeptNextId() {
        return mybatis.selectOne("DeptChgHisMapper.Select_DeptNextId");
    }

    /*
     * SELECT : 특정부서의 최신 이력 가져오기
     */
    public DeptChgHisVO selectDeptLastestChgHis(DeptChgHisVO deptchghisVo) {
        return mybatis.selectOne("DeptChgHisMapper.Select_DeptlastestChgHis", deptchghisVo);
    }

    /*
     * SELECT : 특정부서의 변경이력 카운트 수
     */
    public DeptChgHisVO selectDeptHisCnt(DeptChgHisVO deptchghisVo) {
        return mybatis.selectOne("DeptChgHisMapper.Select_DeptChgHisCnt", deptchghisVo);
    }

    /*
     * SELECT : 상위 조직조회
     */
    public List<DeptChgHisVO> selectHighDeptTree(DeptChgHisVO deptchghisVo) {
        return mybatis.selectList("DeptChgHisMapper.Select_DeptHighTreeList", deptchghisVo);
    }

    /*
     * INSERT : 부서정보 추가
     */
    public int insertDeptInfoNew(DeptChgHisVO deptchghisVo) {
        return mybatis.insert("DeptChgHisMapper.Insert_DeptInfoNew", deptchghisVo);

    }

    /*
     * INSERT : 부서이력추가
     */
    public int insertDeptChgHisNew(DeptChgHisVO deptchghisVo) {
        return mybatis.insert("DeptChgHisMapper.Insert_DeptHisNew", deptchghisVo);
    }

    /*
     * UPDATE : 최신 부서정보로 변경
     */
    public int updateDeptInfo(DeptChgHisVO deptchghisVo) {
        return mybatis.update("DeptChgHisMapper.Update_DeptInfo", deptchghisVo);
    }

    /*
     * UPDATE : 부서이력 변경
     */
    public int updateDeptChgHis(DeptChgHisVO deptchghisVo) {
        return mybatis.update("DeptChgHisMapper.Update_DeptChgHis", deptchghisVo);
    }

    /*
     * UPDATE : 이력유효일자 변경
     */
    public int updateDeptLastesAvlEndDate(DeptChgHisVO deptchghisVo) {
        return mybatis.update("DeptChgHisMapper.Update_DeptLastestAvlEndDate", deptchghisVo);
    }

    /*
     * DELETE : 부서정보삭제
     */
    public int deleteDeptInfo(DeptChgHisVO deptchghisVo) {
        return mybatis.delete("DeptChgHisMapper.Delete_DeptInfo", deptchghisVo);
    }

    /*
     * DELETE : 부서이력 삭제
     */
    public int deleteDeptChgHis(DeptChgHisVO deptchghisVo) {
        return mybatis.delete("DeptChgHisMapper.Delete_DeptChgHis", deptchghisVo);
    }

    /**
     * 8/6
     * */

    /*
     * SELECT : 조직트리 기준일자에 맞는 상위조직 리스트 뽑아오기
     * */

    public List<DeptChgHisVO> selectDeptParentSelectList(DeptChgHisVO deptchghisVo) {
        return mybatis.selectList("DeptChgHisMapper.Select_DeptParentSelectList", deptchghisVo);
    }

    public List<DeptChgHisVO> selectDeptListWhenAddRecord(DeptChgHisVO deptchghisVo) {
        return mybatis.selectList("DeptChgHisMapper.Select_DeptListWhenAddRecord", deptchghisVo);
    }

    public List<DeptChgHisVO> selectDeptParentComboList(DeptChgHisVO deptchghisVo) {
        return mybatis.selectList("DeptChgHisMapper.Select_DeptParentComboList", deptchghisVo);
    }

    /* 선택한 부서 자체의 종료일자 조회 */
    public DeptChgHisVO selectDeptCloseDate(DeptChgHisVO deptchghisVo) {
        return mybatis.selectOne("DeptChgHisMapper.Select_DeptCloseDate", deptchghisVo);
    }

    /* 부서의 종료일자를 입력받은 종료일자로 변경 */
    public int updateDeptCloseDate(DeptChgHisVO deptchghisVo) {
        return mybatis.update("DeptChgHisMapper.Update_DeptCloseDate", deptchghisVo);
    }

    /* 특정부서의 임직원 숫자 조회 */
    public int selectDeptEmpCount(DeptChgHisVO deptchghisVo) {
        return mybatis.selectOne("DeptChgHisMapper.Select_DeptEmpCount", deptchghisVo);
    }

    /* 신규등록하기 전 중복 체크 */
    public int selectCheckOverlapDept(DeptChgHisVO deptchghisVo) {
        return mybatis.selectOne("DeptChgHisMapper.Select_CheckOverlapDept", deptchghisVo);
    }

    /* 조직 최종이력의  유효종료일자 */
    public String selectLastAvlEndDate(DeptChgHisVO deptchghisVo) {
        return mybatis.selectOne("DeptChgHisMapper.Select_LastAvlEndDate", deptchghisVo);
    }
}