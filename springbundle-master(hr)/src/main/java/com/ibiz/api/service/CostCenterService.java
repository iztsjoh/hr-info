package com.ibiz.api.service;

import com.ibiz.api.dao.CostCenterDAO;
import com.ibiz.api.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
@Slf4j
public class CostCenterService {
    @Resource(name = "costCenterDAO")
    private CostCenterDAO costCenterDAO;

    @Transactional
    public JsonObject<List<CostCenterVO>, Object> selectCostCenterTree(Payload<CostCenterVO> requestPayload) {
        log.info("call Service : " + this.getClass().getName() + ".selectBoardList");

        //단순 리스트 조회. 좌측 트리를 조회하는 쿼리를 실행
        JsonObject<List<CostCenterVO>, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        CostCenterVO costCenterVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + costCenterVO);

        List<CostCenterVO>costCenterList = costCenterDAO.selectCostCenterTree(costCenterVO);
        jsonObject.Data = costCenterList;
        jsonObject.IsSucceed = true;

        return jsonObject;
    }

    @Transactional
    public JsonObject<List<CostCenterVO>, Object> selectCostCenterHistoryList(Payload<CostCenterVO> requestPayload) {
        log.info("call Service : " + this.getClass().getName() + ".selectCostCenterHistoryList");

        //단순 리스트 조회. 조직의 변경이력을 조회하는 쿼리를 실행
        JsonObject<List<CostCenterVO>, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        CostCenterVO costCenterVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + costCenterVO);

        List<CostCenterVO>costCenterList = costCenterDAO.selectCostCenterHistoryList(costCenterVO);
        jsonObject.Data = costCenterList;
        jsonObject.TotalSize = costCenterDAO.selectCostCenterHistoryCnt(costCenterVO).getListCnt();
        jsonObject.IsSucceed = true;

        return jsonObject;
    }

    @Transactional
    public JsonObject<CostCenterVO, Object> selectCostCenterlastHistory(Payload<CostCenterVO> requestPayload) {
        log.info("call Service : " + this.getClass().getName() + ".selectCostCenterlastHistory");

        //단순 조회. 조직의 최신(마지막) 이력을 조회
        JsonObject<CostCenterVO, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        CostCenterVO costCenterVO = requestPayload.getDto();
        CostCenterVO costCenter = costCenterDAO.selectCostCenterLastChgHistory(costCenterVO);

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + costCenterVO);

        jsonObject.Data = costCenter;
        jsonObject.IsSucceed = true;

        return jsonObject;
    }

    @Transactional
    public JsonObject<List<CostCenterVO>, Object> selectHighCostCenterTree(Payload<CostCenterVO> requestPayload) {
        log.info("call Service : " + this.getClass().getName() + ".selectHighCostCenterTree");

        //단순 리스트조회. 상위 부서 조회
       JsonObject<List<CostCenterVO>, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        CostCenterVO costCenterVO = requestPayload.getDto();

        List<CostCenterVO> list = costCenterDAO.selectHighCostCenterTree(costCenterVO);

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + costCenterVO);

        jsonObject.Data = list;
        jsonObject.IsSucceed = true;

        return jsonObject;
    }

    @Transactional
    public JsonObject<Object, Object> updateCostCenter(Payload<CostCenterVO> requestPayload) throws Exception {
        log.info("call Service : " + this.getClass().getName() + ".updateCostCenter");

        //업데이트 로직
        JsonObject<Object, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        CostCenterVO costCenterChgVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + costCenterChgVO);

        //상위CCID, 정렬순서, 변경자정보 입력
        costCenterChgVO.setHgrkCcId(costCenterChgVO.getHgrkCcId() != null && costCenterChgVO.getHgrkCcId().length() > 0 ? costCenterChgVO.getHgrkCcId() : "");
        costCenterChgVO.setDeptSortSeqc(costCenterChgVO.getDeptSortSeqc() != null && costCenterChgVO.getDeptSortSeqc().length() > 0 ? costCenterChgVO.getDeptSortSeqc() : "0");
        costCenterChgVO.setChgEmpId(costCenterChgVO.getChgEmpId() != null && costCenterChgVO.getChgEmpId().length() > 0 ? costCenterChgVO.getChgEmpId() : "");

        //이력을 추가하는 경우
        Boolean isAddRecord = Boolean.valueOf(costCenterChgVO.getAddRecord());

//        try
//        {

            //신규 등록 CASE1 : 자동부서코드 모드
            if(costCenterChgVO.getCcId() == "" || costCenterChgVO.getCcId() == null)
            {
                CostCenterVO costCenterVO = costCenterDAO.selectCostCenterNextId();
                costCenterVO.setChgEmpId("");

                costCenterChgVO.setCcId(costCenterVO.getCcId());
                costCenterDAO.insertCostCenterInfo(costCenterChgVO);
                costCenterDAO.insertCostCenterChgHistory(costCenterChgVO);

                jsonObject.IsSucceed = true;
            }
            else
            {
                CostCenterVO costtmp = costCenterDAO.selectIsValidCostCenter(costCenterChgVO);


                if(costtmp.getValChk().trim().equals("S")) //신규
                {
                    costCenterDAO.insertCostCenterInfo(costCenterChgVO);
                    costCenterDAO.insertCostCenterChgHistory(costCenterChgVO);

                    jsonObject.IsSucceed = true;
                }
                else if ((costtmp.getValChk().trim().equals("LN") || costtmp.getValChk().trim().equals("MN")))  //추가
                {
                    if(costtmp.getValChk().trim().equals("LN") || isAddRecord == true) {
                        String ccCloseDate = costCenterDAO.selectCcCloseDate(costCenterChgVO).getOrgCloseDate();

                        if(Integer.parseInt(ccCloseDate) < Integer.parseInt(costCenterChgVO.getAvlEndDate())) {
                            costCenterDAO.updateCcCloseDate(costCenterChgVO);
                        }

                        costCenterDAO.updateCostCenterInfo(costCenterChgVO);
                        costCenterDAO.updateCostCenterLastAvlEndDate(costCenterChgVO);
                    }

                    costCenterDAO.insertCostCenterChgHistory(costCenterChgVO);

                    jsonObject.IsSucceed = true;
                }
                else if (costtmp.getValChk().trim().equals("LU") || costtmp.getValChk().trim().equals("MU"))  //변경
                {
                    costCenterDAO.updateCostCenterChgHistory(costCenterChgVO);

                    if(costtmp.getValChk().trim().equals("LU"))
                        costCenterDAO.updateCostCenterInfo(costCenterChgVO);

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
    public JsonObject<CostCenterVO, Object> deleteCostCenterHistory(Payload<CostCenterVO> requestPayload) {
        log.info("call Service : " + this.getClass().getName() + ".deleteCostCenterHistory");

        //코스트센터 조직 삭제
        JsonObject<CostCenterVO, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        CostCenterVO costCenterVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + costCenterVO);


        int nResult = 0;

        nResult = costCenterDAO.deleteCostCenterChgHistory(costCenterVO);

        if(nResult > 0) {
            costCenterDAO.deleteCostCenterInfo(costCenterVO);

            CostCenterVO costCenter = costCenterDAO.selectCostCenterLastChgHistory(costCenterVO);
            if(costCenter != null) {
                costCenterDAO.updateCostCenterInfo(costCenter);
            }
            jsonObject.IsSucceed = true;
        }
        else {
            jsonObject.IsSucceed = false;
        }


        return jsonObject;
    }

    @Transactional
    public JsonObject<List<CostCenterVO>, Object> selectCostCenterAvl(Payload<CostCenterVO> requestPayload) {
        log.info("call Service : " + this.getClass().getName() + ".selectCostCenterAvl");

        //유효기간에 따른 코스트센터 리스트 조회
        JsonObject<List<CostCenterVO>, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        CostCenterVO costCenterVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + costCenterVO);


        List<CostCenterVO> list = costCenterDAO.selectHighCostCenterToAvl(costCenterVO);

        jsonObject.Data = list;
        jsonObject.IsSucceed = true;

        return jsonObject;
    }

    @Transactional
    public JsonObject<List<CostCenterVO>, Object> selectHighCostCenterDeptList(Payload<CostCenterVO> requestPayload) {
        log.info("call Service : " + this.getClass().getName() + ".selectHighCostCenterDeptList");

        //상위조직 콤보 조회
        JsonObject<List<CostCenterVO>, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        CostCenterVO costCenterVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + costCenterVO);

        List<CostCenterVO> list = costCenterDAO.selectHighCostCenterDeptList(costCenterVO);

        jsonObject.Data = list;
        jsonObject.IsSucceed = true;

        return jsonObject;
    }


    // Excel
    @Transactional
    public List<ExcelCostCenterVO> selectExcelDwnlCostCenterList(Payload<CostCenterVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectExcelDwnlCostCenterList");
        CostCenterVO costCenterVO = requestPayload.getDto();

        List<ExcelCostCenterVO> list = costCenterDAO.selectExcelDwnlCostCenterList(costCenterVO);

        //날짜 포맷변환
        SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-MM-dd");

        for(int i = 0 ; i < list.size(); i++) {
            if (list.get(i).getAvlStartDate() != null && list.get(i).getAvlStartDate() != "") {
                String avlStartDate = list.get(i).getAvlStartDate();
                avlStartDate = afterFormat.format(beforeFormat.parse(avlStartDate));
                list.get(i).setAvlStartDate(avlStartDate);
            }
            if(list.get(i).getAvlEndDate() != null && list.get(i).getAvlEndDate() != "") {
                String avlEndDate = list.get(i).getAvlEndDate();
                avlEndDate = afterFormat.format(beforeFormat.parse(avlEndDate));
                list.get(i).setAvlEndDate(avlEndDate);
            }
            if(list.get(i).getOrgCrtDate() != null && list.get(i).getOrgCrtDate() != "") {
                String orgCrtDate = list.get(i).getOrgCrtDate();
                orgCrtDate = afterFormat.format(beforeFormat.parse(orgCrtDate));
                list.get(i).setOrgCrtDate(orgCrtDate);
            }
            if(list.get(i).getOrgCloseDate() != null && list.get(i).getOrgCloseDate() != "") {
                String orgCloseDate = list.get(i).getOrgCloseDate();
                orgCloseDate = afterFormat.format(beforeFormat.parse(orgCloseDate));
                list.get(i).setOrgCloseDate(orgCloseDate);
            }
        }
        return list;
    }

    @Transactional
    public List<ExcelCostCenterHistoryVO> selectExcelDwnlCostCenterHistoryList(Payload<CostCenterVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectExcelDwnlCostCenterHistoryList");
        CostCenterVO costCenterVO = requestPayload.getDto();

        List<ExcelCostCenterHistoryVO> list = costCenterDAO.selectExcelDwnlCostCenterHistoryList(costCenterVO);

        //날짜 포맷변환
        SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-MM-dd");

        for(int i = 0 ; i < list.size(); i++) {
            if (list.get(i).getAvlStartDate() != null && list.get(i).getAvlStartDate() != "") {
                String avlStartDate = list.get(i).getAvlStartDate();
                avlStartDate = afterFormat.format(beforeFormat.parse(avlStartDate));
                list.get(i).setAvlStartDate(avlStartDate);
            }
            if(list.get(i).getAvlEndDate() != null && list.get(i).getAvlEndDate() != "") {
                String avlEndDate = list.get(i).getAvlEndDate();
                avlEndDate = afterFormat.format(beforeFormat.parse(avlEndDate));
                list.get(i).setAvlEndDate(avlEndDate);
            }
            if(list.get(i).getOrgCrtDate() != null && list.get(i).getOrgCrtDate() != "") {
                String orgCrtDate = list.get(i).getOrgCrtDate();
                orgCrtDate = afterFormat.format(beforeFormat.parse(orgCrtDate));
                list.get(i).setOrgCrtDate(orgCrtDate);
            }
            if(list.get(i).getOrgCloseDate() != null && list.get(i).getOrgCloseDate() != "") {
                String orgCloseDate = list.get(i).getOrgCloseDate();
                orgCloseDate = afterFormat.format(beforeFormat.parse(orgCloseDate));
                list.get(i).setOrgCloseDate(orgCloseDate);
            }
        }

        return list;
    }
}
