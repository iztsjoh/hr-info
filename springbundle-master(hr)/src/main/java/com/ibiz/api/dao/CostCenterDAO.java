package com.ibiz.api.dao;

import com.ibiz.api.model.*;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "costCenterDAO")
public class CostCenterDAO {

    @Autowired
    private SqlSessionTemplate mybatis;

    /*
     * SELECT : 왼쪽 코스트센터트리 조회
     */
    public List<CostCenterVO> selectCostCenterTree(CostCenterVO costCenterVO) {
        return mybatis.selectList("CostCenterMapper.selectCostCenterTree", costCenterVO);
    }

    /*
     * SELECT : 특정코스트센터의 변경이력 조회
     */
    public List<CostCenterVO> selectCostCenterHistoryList(CostCenterVO costCenterVO) {
        return mybatis.selectList("CostCenterMapper.selectCostCenterHistoryList", costCenterVO);
    }

    /*
     * SELECT : 등록/변경하려는 내용의 적합성 판단
     * @param : ccId, AvlStartDate
     */
    public CostCenterVO selectIsValidCostCenter(CostCenterVO costCenterVO) {
        return mybatis.selectOne("CostCenterMapper.selectIsValidCostCenter", costCenterVO);
    }

    /*
     * SELECT : 신규 부서등록시 코스트센터ID 값 가져오기
     */
    public CostCenterVO selectCostCenterNextId() {
        return mybatis.selectOne("CostCenterMapper.selectCostCenterNextId");
    }

    /*
     * SELECT : 특정코스트센터의 최신 이력 가져오기
     */
    public CostCenterVO selectCostCenterLastChgHistory(CostCenterVO costCenterVO) {
        return mybatis.selectOne("CostCenterMapper.selectCostCenterLastChgHistory", costCenterVO);
    }

    /*
     * SELECT : 특정코스트센터의 변경이력 카운트 수
     */
    public CostCenterVO selectCostCenterHistoryCnt(CostCenterVO costCenterVO) {
        return mybatis.selectOne("CostCenterMapper.selectCostCenterHistoryCnt", costCenterVO);
    }

    /*
     * SELECT : 상위부서 조회
     */
    public List<CostCenterVO> selectHighCostCenterTree(CostCenterVO costCenterVO) {
        return mybatis.selectList("CostCenterMapper.selectHighCostCenterTree", costCenterVO);
    }

    /*
     * INSERT : 코스트센터정보 추가
     */
    public void insertCostCenterInfo(CostCenterVO costCenterVO) {
        mybatis.insert("CostCenterMapper.insertCostCenterInfo", costCenterVO);
    }

    /*
     * INSERT : 코스트센터이력추가
     */
    public void insertCostCenterChgHistory(CostCenterVO costCenterVO) {
        mybatis.insert("CostCenterMapper.insertCostCenterChgHistory", costCenterVO);
    }

    /*
     * UPDATE : 최신 코스트센터정보로 변경
     */
    public int updateCostCenterInfo(CostCenterVO costCenterVO) {
        return mybatis.update("CostCenterMapper.updateCostCenterInfo", costCenterVO);
    }

    /*
     * UPDATE : 코스트센터이력 변경
     */
    public int updateCostCenterChgHistory(CostCenterVO costCenterVO) {
        return mybatis.update("CostCenterMapper.updateCostCenterChgHistory", costCenterVO);
    }

    /*
     * UPDATE : 이력유효일자 변경
     */
    public int updateCostCenterLastAvlEndDate(CostCenterVO costCenterVO) {
        return mybatis.update("CostCenterMapper.updateCostCenterLastAvlEndDate", costCenterVO);
    }

    /*
     * DELETE : 코스트센터정보삭제
     */
    public int deleteCostCenterInfo(CostCenterVO costCenterVO) {
        return mybatis.delete("CostCenterMapper.deleteCostCenterInfo", costCenterVO);
    }

    /*
     * DELETE : 코스트센터이력 삭제
     */
    public int deleteCostCenterChgHistory(CostCenterVO costCenterVO) {
        return mybatis.delete("CostCenterMapper.deleteCostCenterChgHistory", costCenterVO);
    }

    /*
     * SELECT : 이력유효기간에 따른 상위조직 검색
     */
    public List<CostCenterVO> selectHighCostCenterToAvl(CostCenterVO costCenterVO) {
        return mybatis.selectList("CostCenterMapper.selectHighCostCenterToAvl", costCenterVO);
    }

    /*
     * SELECT : 이력유효기간에 따른 해당조직을 제외한 상위조직 검색
     */
    public List<CostCenterVO> selectHighCostCenterDept(CostCenterVO costCenterVO) {
        return mybatis.selectList("CostCenterMapper.selectHighCostCenterDept", costCenterVO);
    }

    /* 선택한 부서 자체의 종료일자 조회 */
    public CostCenterVO selectCcCloseDate(CostCenterVO costCenterVO) {
        return mybatis.selectOne("CostCenterMapper.selectCcCloseDate", costCenterVO);
    }

    /* 선택한 부서의 종료일자를 변경 */
    public int updateCcCloseDate(CostCenterVO costCenterVO) {
        return mybatis.update("CostCenterMapper.updateCcCloseDate", costCenterVO);
    }

    /* 코스트센터 정보 조회 엑셀 */
    public List<ExcelCostCenterVO> selectExcelDwnlCostCenterList(CostCenterVO costCenterVO) throws Exception {
        return mybatis.selectList("CostCenterMapper.selectExcelDwnlCostCenterList", costCenterVO);
    }

    /* 코스트센터 이력 정보 조회 엑셀 */
    public List<ExcelCostCenterHistoryVO> selectExcelDwnlCostCenterHistoryList(CostCenterVO costCenterVO) throws Exception {
        return mybatis.selectList("CostCenterMapper.selectExcelDwnlCostCenterHistoryList", costCenterVO);
    }

}
