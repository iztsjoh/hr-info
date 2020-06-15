package com.ibiz.api.service;

import com.ibiz.api.cmnUtil.IndexUtils;
import com.ibiz.api.dao.CostCenterChgHisDao;
import com.ibiz.api.exception.ExceptionCode;
import com.ibiz.api.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class CostCenterService {
    @Resource(name = "costCenterChgHisDao")
    private CostCenterChgHisDao costCenterChgHisDao;

    @Transactional
    public JsonObject<List<CostCenterChgHisVO>, Object> selectCostCenterTree(Payload<CostCenterChgHisVO> requestPayload) {
        log.info("call Service : " + this.getClass().getName() + ".selectBoardList");

        //단순 리스트 조회. 좌측 트리를 조회하는 쿼리를 실행
        JsonObject<List<CostCenterChgHisVO>, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        CostCenterChgHisVO costCenterChgHisVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + costCenterChgHisVO);

        List<CostCenterChgHisVO>costCenterList = costCenterChgHisDao.selectCostCenterTree(costCenterChgHisVO);
        jsonObject.Data = costCenterList;
        jsonObject.IsSucceed = true;

        return jsonObject;
    }

    @Transactional
    public JsonObject<List<CostCenterChgHisVO>, Object> selectCostCenterHisList(Payload<CostCenterChgHisVO> requestPayload) {
        log.info("call Service : " + this.getClass().getName() + ".selectCostCenterHisList");

        //단순 리스트 조회. 조직의 변경이력을 조회하는 쿼리를 실행
        JsonObject<List<CostCenterChgHisVO>, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        CostCenterChgHisVO costCenterChgHisVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + costCenterChgHisVO);

        List<CostCenterChgHisVO>costCenterList = costCenterChgHisDao.selectCostCenterHisList(costCenterChgHisVO);
        jsonObject.Data = costCenterList;
        jsonObject.TotalSize = costCenterChgHisDao.selectCostCenterHisCnt(costCenterChgHisVO).getListCnt();
        jsonObject.IsSucceed = true;

        return jsonObject;
    }

    @Transactional
    public JsonObject<CostCenterChgHisVO, Object> selectCostCenterlastestChgHis(Payload<CostCenterChgHisVO> requestPayload) {
        log.info("call Service : " + this.getClass().getName() + ".selectCostCenterlastestChgHis");

        //단순 조회. 조직의 최신(마지막) 이력을 조회
        JsonObject<CostCenterChgHisVO, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        CostCenterChgHisVO costCenterChgHisVO = requestPayload.getDto();
        CostCenterChgHisVO costCenter = costCenterChgHisDao.selectCostCenterLastestChgHis(costCenterChgHisVO);

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + costCenterChgHisVO);

        jsonObject.Data = costCenter;
        jsonObject.IsSucceed = true;

        return jsonObject;
    }

    @Transactional
    public JsonObject<List<CostCenterChgHisVO>, Object> selectHighCostCenterTree(Payload<CostCenterChgHisVO> requestPayload) {
        log.info("call Service : " + this.getClass().getName() + ".selectHighCostCenterTree");

        //단순 리스트조회. 상위 부서 조회
       JsonObject<List<CostCenterChgHisVO>, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        CostCenterChgHisVO costCenterChgHisVO = requestPayload.getDto();

        List<CostCenterChgHisVO> list = costCenterChgHisDao.selectHighCostCenterTree(costCenterChgHisVO);

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + costCenterChgHisVO);

        jsonObject.Data = list;
        jsonObject.IsSucceed = true;

        return jsonObject;
    }

    @Transactional
    public JsonObject<Object, Object> updateCostCenter(Payload<CostCenterChgHisVO> requestPayload) throws Exception {
        log.info("call Service : " + this.getClass().getName() + ".updateCostCenter");

        //업데이트 로직
        JsonObject<Object, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        CostCenterChgHisVO costCenterChgHisVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + costCenterChgHisVO);

        //상위CCID, 정렬순서, 변경자정보 입력
        costCenterChgHisVO.setHgrkCcId(costCenterChgHisVO.getHgrkCcId() != null && costCenterChgHisVO.getHgrkCcId().length() > 0 ? costCenterChgHisVO.getHgrkCcId() : "");
        costCenterChgHisVO.setDeptSortSeqc(costCenterChgHisVO.getDeptSortSeqc() != null && costCenterChgHisVO.getDeptSortSeqc().length() > 0 ? costCenterChgHisVO.getDeptSortSeqc() : "0");
        costCenterChgHisVO.setChgEmpId(costCenterChgHisVO.getChgEmpId() != null && costCenterChgHisVO.getChgEmpId().length() > 0 ? costCenterChgHisVO.getChgEmpId() : "");

        //이력을 추가하는 경우
        Boolean isAddRecord = Boolean.valueOf(costCenterChgHisVO.getAddRecord());

//        try
//        {

            //신규 등록 CASE1 : 자동부서코드 모드
            if(costCenterChgHisVO.getCcId() == "" || costCenterChgHisVO.getCcId() == null)
            {
                CostCenterChgHisVO costCenterVO = costCenterChgHisDao.selectCostCenterNextId();
                costCenterVO.setChgEmpId("");

                costCenterChgHisVO.setCcId(costCenterVO.getCcId());
                costCenterChgHisDao.insertCostCenterInfoNew(costCenterChgHisVO);
                costCenterChgHisDao.insertCostCenterChgHisNew(costCenterChgHisVO);

                jsonObject.IsSucceed = true;
            }
            else
            {
                CostCenterChgHisVO costtmp = costCenterChgHisDao.selectCostCenterValidationCheck(costCenterChgHisVO);


                if(costtmp.getValChk().trim().equals("S")) //신규
                {
                    costCenterChgHisDao.insertCostCenterInfoNew(costCenterChgHisVO);
                    costCenterChgHisDao.insertCostCenterChgHisNew(costCenterChgHisVO);

                    jsonObject.IsSucceed = true;
                }
                else if ((costtmp.getValChk().trim().equals("LN") || costtmp.getValChk().trim().equals("MN")))  //추가
                {
                    if(costtmp.getValChk().trim().equals("LN") || isAddRecord == true) {
                        String ccCloseDate = costCenterChgHisDao.selectCcCloseDate(costCenterChgHisVO).getOrgCloseDate();

                        if(Integer.parseInt(ccCloseDate) < Integer.parseInt(costCenterChgHisVO.getAvlEndDate())) {
                            costCenterChgHisDao.updateCcCloseDate(costCenterChgHisVO);
                        }

                        costCenterChgHisDao.updateCostCenterInfo(costCenterChgHisVO);
                        costCenterChgHisDao.updateCostCenterLastesAvlEndDate(costCenterChgHisVO);
                    }

                    costCenterChgHisDao.insertCostCenterChgHisNew(costCenterChgHisVO);

                    jsonObject.IsSucceed = true;
                }
                else if (costtmp.getValChk().trim().equals("LU") || costtmp.getValChk().trim().equals("MU"))  //변경
                {
                    costCenterChgHisDao.updateCostCenterChgHis(costCenterChgHisVO);

                    if(costtmp.getValChk().trim().equals("LU"))
                        costCenterChgHisDao.updateCostCenterInfo(costCenterChgHisVO);

                    jsonObject.IsSucceed = true;
                }


                else
                {
                    log.info("===============  유효하지 않은 기간으로 등록 ===============");
                    jsonObject.ErrorMessage = "등록하려는 이력유효기간에 중복기간이 존재합니다.";
                    jsonObject.IsSucceed = false;
                }

            }

//        }
//        catch (Exception e) {
//            log.error(e.toString(), e);
//
//            jsonObject.ErrorNumber = ExceptionCode.UNIQUE_INDEXING_FAIL;
//            jsonObject.ErrorMessage = ExceptionCode.UNIQUE_INDEXING_FAIL_MESSAGE;
//            jsonObject.IsSucceed = false;
//
//            return jsonObject;
//        }

        return jsonObject;
    }

    @Transactional
    public JsonObject<CostCenterChgHisVO, Object> deleteCostCenterHis(Payload<CostCenterChgHisVO> requestPayload) {
        log.info("call Service : " + this.getClass().getName() + ".deleteCostCenterHis");

        //코스트센터 조직 삭제
        JsonObject<CostCenterChgHisVO, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        CostCenterChgHisVO costCenterChgHisVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + costCenterChgHisVO);


        int nResult = 0;

        nResult = costCenterChgHisDao.deleteCostCenterChgHis(costCenterChgHisVO);

        if(nResult > 0) {
            costCenterChgHisDao.deleteCostCenterInfo(costCenterChgHisVO);

            CostCenterChgHisVO costCenter = costCenterChgHisDao.selectCostCenterLastestChgHis(costCenterChgHisVO);
            if(costCenter != null) {
                costCenterChgHisDao.updateCostCenterInfo(costCenter);
            }
            jsonObject.IsSucceed = true;
        }
        else {
            jsonObject.IsSucceed = false;
        }


        return jsonObject;
    }

    @Transactional
    public JsonObject<List<CostCenterChgHisVO>, Object> selectCostCenterAvl(Payload<CostCenterChgHisVO> requestPayload) {
        log.info("call Service : " + this.getClass().getName() + ".selectCostCenterAvl");

        //유효기간에 따른 코스트센터 리스트 조회
        JsonObject<List<CostCenterChgHisVO>, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        CostCenterChgHisVO costCenterChgHisVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + costCenterChgHisVO);


        List<CostCenterChgHisVO> list = costCenterChgHisDao.selectHighCostCenterToAvl(costCenterChgHisVO);

        jsonObject.Data = list;
        jsonObject.IsSucceed = true;

        return jsonObject;
    }

    @Transactional
    public JsonObject<List<CostCenterChgHisVO>, Object> selectHighCostCenterDeptCombo(Payload<CostCenterChgHisVO> requestPayload) {
        log.info("call Service : " + this.getClass().getName() + ".deleteCostCenterHis");

        //상위조직 콤보 조회
        JsonObject<List<CostCenterChgHisVO>, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        CostCenterChgHisVO costCenterChgHisVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + costCenterChgHisVO);

        List<CostCenterChgHisVO> list = costCenterChgHisDao.selectHighCostCenterDeptCombo(costCenterChgHisVO);

        jsonObject.Data = list;
        jsonObject.IsSucceed = true;

        return jsonObject;
    }
}
