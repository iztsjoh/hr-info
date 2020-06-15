package com.ibiz.api.dao;

import com.ibiz.api.model.*;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository(value = "costCenterChgHisDao")
public class CostCenterChgHisDao {

    @Autowired
    private SqlSessionTemplate mybatis;

    /*
     * SELECT : 왼쪽 코스트센터트리 조회
     */
    public List<CostCenterChgHisVO> selectCostCenterTree(CostCenterChgHisVO costCenterchghisVo) {
        return mybatis.selectList("CostCenterChgHisMapper.Select_CostCenterTreeList", costCenterchghisVo);
    }

    /*
     * SELECT : 특정조직의 등록가능한 상위조직 리스트 조회
     */
    public List<CostCenterChgHisVO> selectCostCenterHighTree(CostCenterChgHisVO costCenterchghisVo) {
        return mybatis.selectList("CostCenterChgHisMapper.Select_CostCenterHighTreeList", costCenterchghisVo);
    }

//    /*
//     * SELECT : 코스트센터 다운로드
//     */
//    public List<ExcelCostCenterInfoVO> selectCostCenterInfoDownload(CostCenterChgHisVO costCenterchghisVo) {
//        return mybatis.selectList(MAPPER_PATH + "CostCenterChgHisMapper.Select_CostCenterInfoDownload", costCenterchghisVo);
//    }
//
//    /*
//     * SELECT : 코스트센터 이력 다운로드
//     */
//    public List<ExcelCostCenterChgHisVO> selectCostCenterHisDownload(CostCenterChgHisVO costCenterchghisVo) {
//        return mybatis.selectList(MAPPER_PATH + "CostCenterChgHisMapper.Select_CostCenterChgHisDownload", costCenterchghisVo);
//    }

    /*
     * SELECT : 특정코스트센터의 변경이력 조회
     */
    public List<CostCenterChgHisVO> selectCostCenterHisList(CostCenterChgHisVO costCenterchghisVo) {
        return mybatis.selectList("CostCenterChgHisMapper.Select_CostCenterChgHisList", costCenterchghisVo);
    }

    /*
     * SELECT : 등록/변경하려는 내용의 적합성 판단
     * @param : ccId, AvlStartDate
     */
    public CostCenterChgHisVO selectCostCenterValidationCheck(CostCenterChgHisVO costCenterchghisVo) {
        return mybatis.selectOne("CostCenterChgHisMapper.Select_CostCenterValidationCheck", costCenterchghisVo);
    }

    /*
     * SELECT : 신규 부서등록시 코스트센터ID 값 가져오기
     */
    public CostCenterChgHisVO selectCostCenterNextId() {
        return mybatis.selectOne("CostCenterChgHisMapper.Select_CostCenterNextId");
    }

    /*
     * SELECT : 특정코스트센터의 최신 이력 가져오기
     */
    public CostCenterChgHisVO selectCostCenterLastestChgHis(CostCenterChgHisVO costCenterchghisVo) {
        return mybatis.selectOne("CostCenterChgHisMapper.Select_CostCenterlastestChgHis", costCenterchghisVo);
    }

    /*
     * SELECT : 특정코스트센터의 변경이력 카운트 수
     */
    public CostCenterChgHisVO selectCostCenterHisCnt(CostCenterChgHisVO costCenterchghisVo) {
        return mybatis.selectOne("CostCenterChgHisMapper.Select_CostCenterChgHisCnt", costCenterchghisVo);
    }

    /*
     * SELECT : 상위부서 조회
     */
    public List<CostCenterChgHisVO> selectHighCostCenterTree(CostCenterChgHisVO costCenterchghisVo) {
        return mybatis.selectList("CostCenterChgHisMapper.Select_HighCostCenterTreeList", costCenterchghisVo);
    }

    /*
     * INSERT : 코스트센터정보 추가
     */
    public void insertCostCenterInfoNew(CostCenterChgHisVO costCenterchghisVo) {
        mybatis.insert("CostCenterChgHisMapper.Insert_CostCenterInfoNew", costCenterchghisVo);
    }

    /*
     * INSERT : 코스트센터이력추가
     */
    public void insertCostCenterChgHisNew(CostCenterChgHisVO costCenterchghisVo) {
        mybatis.insert("CostCenterChgHisMapper.Insert_CostCenterHisNew", costCenterchghisVo);
    }

    /*
     * UPDATE : 최신 코스트센터정보로 변경
     */
    public int updateCostCenterInfo(CostCenterChgHisVO costCenterchghisVo) {
        return mybatis.update("CostCenterChgHisMapper.Update_CostCenterInfo", costCenterchghisVo);
    }

    /*
     * UPDATE : 코스트센터이력 변경
     */
    public int updateCostCenterChgHis(CostCenterChgHisVO costCenterchghisVo) {
        return mybatis.update("CostCenterChgHisMapper.Update_CostCenterChgHis", costCenterchghisVo);
    }

    /*
     * UPDATE : 이력유효일자 변경
     */
    public int updateCostCenterLastesAvlEndDate(CostCenterChgHisVO costCenterchghisVo) {
        return mybatis.update("CostCenterChgHisMapper.Update_CostCenterLastestAvlEndDate", costCenterchghisVo);
    }

    /*
     * DELETE : 코스트센터정보삭제
     */
    public int deleteCostCenterInfo(CostCenterChgHisVO costCenterchghisVo) {
        return mybatis.delete("CostCenterChgHisMapper.Delete_CostCenterInfo", costCenterchghisVo);
    }

    /*
     * DELETE : 코스트센터이력 삭제
     */
    public int deleteCostCenterChgHis(CostCenterChgHisVO costCenterchghisVo) {
        return mybatis.delete("CostCenterChgHisMapper.Delete_CostCenterChgHis", costCenterchghisVo);
    }

    /*
     * SELECT : 이력유효기간에 따른 상위조직 검색
     */
    public List<CostCenterChgHisVO> selectHighCostCenterToAvl(CostCenterChgHisVO costCenterchghisVo) {
        return mybatis.selectList("CostCenterChgHisMapper.Select_HighCostCenterAvl", costCenterchghisVo);
    }

    /*
     * SELECT : 이력유효기간에 따른 해당조직을 제외한 상위조직 검색
     */
    public List<CostCenterChgHisVO> selectHighCostCenterDeptCombo(CostCenterChgHisVO costCenterchghisVo) {
        return mybatis.selectList("CostCenterChgHisMapper.Select_HighCostCenterDeptCombo", costCenterchghisVo);
    }

    /* 선택한 부서 자체의 종료일자 조회 */
    public CostCenterChgHisVO selectCcCloseDate(CostCenterChgHisVO costCenterchghisVo) {
        return mybatis.selectOne("CostCenterChgHisMapper.Select_CcCloseDate", costCenterchghisVo);
    }

    /* 선택한 부서의 종료일자를 변경 */
    public int updateCcCloseDate(CostCenterChgHisVO costCenterchghisVo) {
        return mybatis.update("CostCenterChgHisMapper.Update_CcCloseDate", costCenterchghisVo);
    }
}
