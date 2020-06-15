package com.ibiz.api.service;

import com.ibiz.api.dao.CostCenterChgHisDao;
import com.ibiz.api.dao.DeptChgHisDao;
import com.ibiz.api.exception.CodeOverlapException;
import com.ibiz.api.exception.DateOverlapException;
import com.ibiz.api.exception.DeptStateException;
import com.ibiz.api.model.*;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@Service
@Slf4j
public class DeptChgHisService {

    @Resource(name = "deptChgHisDao")
    private DeptChgHisDao deptChgHisDao;

    @Transactional
    public JsonObject<List<DeptChgHisVO>, Object> selectDeptTree(Payload<DeptChgHisVO> requestPayload) throws DeptStateException {
        log.info("call Service : " + this.getClass().getName() + ".selectDeptTree");

        //좌측 트리 조회
        JsonObject<List<DeptChgHisVO>, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        DeptChgHisVO deptChgHisVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + deptChgHisVO);

        //if(StringUtils.isEmpty(deptChgHisVO.getDeptId()))
        //    throw new IllegalArgumentException();

        List<DeptChgHisVO> list = deptChgHisDao.selectDeptTree(deptChgHisVO);
        jsonObject.Data = list;
        jsonObject.IsSucceed = true;

        return jsonObject;
    }

    @Transactional
    public JsonObject<List<DeptChgHisVO>, Object> selectDeptHisList(Payload<DeptChgHisVO> requestPayload) throws DeptStateException{
        log.info("call Service : " + this.getClass().getName() + ".selectDeptHisList");

        //조직이력 조회
        JsonObject<List<DeptChgHisVO>, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        DeptChgHisVO deptChgHisVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + deptChgHisVO);

        List<DeptChgHisVO> list = deptChgHisDao.selectDeptHisList(deptChgHisVO);

        jsonObject.Data = list;
        jsonObject.IsSucceed = true;

        return jsonObject;
    }

    @Transactional
    public JsonObject<DeptChgHisVO, Object> selectLastDeptHisList(Payload<DeptChgHisVO> requestPayload) throws DeptStateException{
        log.info("call Service : " + this.getClass().getName() + ".selectLastDeptHisList");

        //조직의 마지막(최신) 변경 이력 조회
        JsonObject<DeptChgHisVO, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        DeptChgHisVO deptChgHisVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + deptChgHisVO);

        DeptChgHisVO data = deptChgHisDao.selectLastDeptHisList(deptChgHisVO);

        jsonObject.Data = data;
        jsonObject.IsSucceed = true;

        return jsonObject;
    }

    @Transactional
    public JsonObject<DeptChgHisVO, Object> selectDeptlastestChgHis(Payload<DeptChgHisVO> requestPayload) throws DeptStateException{
        log.info("call Service : " + this.getClass().getName() + ".selectDeptlastestChgHis");

        //조직의 최신 이력 조회
        JsonObject<DeptChgHisVO, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        DeptChgHisVO deptChgHisVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + deptChgHisVO);

        DeptChgHisVO dept = deptChgHisDao.selectDeptLastestChgHis(deptChgHisVO);

        jsonObject.Data = dept;
        jsonObject.IsSucceed = true;

        return jsonObject;
    }

    @Transactional
    public JsonObject<List<DeptChgHisVO>, Object> selectHighDeptTree(Payload<DeptChgHisVO> requestPayload) throws DeptStateException{
        log.info("call Service : " + this.getClass().getName() + ".selectHighDeptTree");

        //상위조직 조회
        JsonObject<List<DeptChgHisVO>, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        DeptChgHisVO deptChgHisVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + deptChgHisVO);

        List<DeptChgHisVO> list = deptChgHisDao.selectHighDeptTree(deptChgHisVO);

        jsonObject.Data = list;
        jsonObject.IsSucceed = true;

        return jsonObject;
    }

    @Transactional
    public JsonObject<Object, Object> updateDept(Payload<DeptChgHisVO> requestPayload) throws DeptStateException,CodeOverlapException, DateOverlapException, CodeOverlapException {
        log.info("call Service : " + this.getClass().getName() + ".updateDept");

        JsonObject<Object, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        DeptChgHisVO deptChgHisVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + deptChgHisVO);

        deptChgHisVO.setHgrkDeptId(deptChgHisVO.getHgrkDeptId() != null && deptChgHisVO.getHgrkDeptId().length() > 0 ? deptChgHisVO.getHgrkDeptId() : "");
        deptChgHisVO.setHddpEmpId(deptChgHisVO.getHddpEmpId() != null && deptChgHisVO.getHddpEmpId().length() > 0 ? deptChgHisVO.getHddpEmpId() : "");
        deptChgHisVO.setDeptSortSeqc(deptChgHisVO.getDeptSortSeqc() != null && deptChgHisVO.getDeptSortSeqc().length() > 0 ? deptChgHisVO.getDeptSortSeqc() : "");
        deptChgHisVO.setOrgDstCd(deptChgHisVO.getOrgDstCd() != null && deptChgHisVO.getOrgDstCd().length() > 0 ? deptChgHisVO.getOrgDstCd() : "");

        deptChgHisVO.setChgEmpId(deptChgHisVO.getChgEmpId() != null && deptChgHisVO.getChgEmpId().length() > 0 ? deptChgHisVO.getChgEmpId() : "");

        Boolean isAddRecord = Boolean.valueOf(deptChgHisVO.getIsAddRecord());
        int totalSize = deptChgHisDao.selectDeptHisCnt(deptChgHisVO).getListCnt();
        String deptCloseDate = (deptChgHisDao.selectDeptCloseDate(deptChgHisVO) != null && deptChgHisDao.selectDeptCloseDate(deptChgHisVO).getOrgCloseDate() != null) ? deptChgHisDao.selectDeptCloseDate(deptChgHisVO).getOrgCloseDate() : "99991231";

//        try {
            //입력한 유효기간이 유효한가 체크 및 신규등록 체크
            DeptChgHisVO deptTmp = deptChgHisDao.selectDeptValidationCheck(deptChgHisVO);

            if(Boolean.valueOf(deptChgHisVO.getIsCreating()) == true && deptChgHisDao.selectCheckOverlapDept(deptChgHisVO) > 0) {
                //jsonObject.IsSucceed = false;
                //jsonObject.ErrorMessage = "같은 부서ID로 등록된 부서조직이 존재합니다.";

                //return jsonObject;
                throw new CodeOverlapException("조직");
            }

            if(deptTmp.getValChk().trim().equals("S")) {
                //신규
                try {
                    deptChgHisDao.insertDeptInfoNew(deptChgHisVO);
                    deptChgHisDao.insertDeptChgHisNew(deptChgHisVO);

                    if (Integer.parseInt(deptCloseDate) < Integer.parseInt(deptChgHisVO.getAvlEndDate())) {
                        deptChgHisDao.updateDeptCloseDate(deptChgHisVO);
                    }

                    jsonObject.IsSucceed = true;
                }catch (Exception e){
                    throw new DeptStateException();
                }
            } else if (deptTmp.getValChk().trim().equals("LN") || deptTmp.getValChk().trim().equals("MN")) {
                //추가
                if(deptTmp.getValChk().trim().equals("LN") && isAddRecord == true) {
                    deptChgHisDao.updateDeptInfo(deptChgHisVO);
                    deptChgHisDao.updateDeptLastesAvlEndDate(deptChgHisVO);

                }

                deptChgHisDao.insertDeptChgHisNew(deptChgHisVO);

                if(Integer.parseInt(deptCloseDate) < Integer.parseInt(deptChgHisVO.getAvlEndDate())) {
                    deptChgHisDao.updateDeptCloseDate(deptChgHisVO);
                }

                jsonObject.IsSucceed = true;
            } else if (deptTmp.getValChk().trim().equals("LU") || deptTmp.getValChk().trim().equals("MU") || totalSize == 1) {
                //변경
                deptChgHisDao.updateDeptChgHis(deptChgHisVO);

                if(Boolean.valueOf(deptChgHisVO.getIsCreating()) == true && deptChgHisDao.selectCheckOverlapDept(deptChgHisVO) > 0) {
                    //jsonObject.IsSucceed = false;
                    //jsonObject.ErrorMessage = "같은 부서ID로 등록된 부서조직이 존재합니다.";

                    //return jsonObject;
                    throw new CodeOverlapException("부서ID");
                }


                if(deptTmp.getValChk().trim().equals("LU"))
                    deptChgHisDao.updateDeptInfo(deptChgHisVO);

                //if(Integer.parseInt(deptCloseDate) < Integer.parseInt(deptChgHisVO.getAvlEndDate())) {
                    deptChgHisDao.updateDeptCloseDate(deptChgHisVO);
                //}

                jsonObject.IsSucceed = true;
            } else {
                throw new DateOverlapException("유효");
                //log.info("===============  유효하지 않은 기간으로 등록 ===============");
                //jsonObject.ErrorMessage = "등록하려는 이력유효기간에 중복기간이 존재합니다.";
                //jsonObject.IsSucceed = false;
                //throw new DeptStateException("DateOverlap");
            }

//        } catch (Exception e) {
//            log.error(e.toString(), e);
//
//            jsonObject.ErrorNumber = ExceptionCode.UNIQUE_INDEXING_FAIL;
//            jsonObject.ErrorMessage = ExceptionCode.UNIQUE_INDEXING_FAIL_MESSAGE;
//            jsonObject.IsSucceed = false;
//
//            return jsonObject;
//        }
//        finally {
//
//        }

        return jsonObject;
    }

    @Transactional
    public JsonObject<Object, Object> deleteDeptHis(Payload<DeptChgHisVO> requestPayload) throws DeptStateException {
        log.info("call Service : " + this.getClass().getName() + ".deleteDeptHis");

        //조직 삭제
        JsonObject<Object, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        DeptChgHisVO deptChgHisVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + deptChgHisVO);

        int listCount = deptChgHisDao.selectDeptHisCnt(deptChgHisVO).getListCnt();
        int empCount = deptChgHisDao.selectDeptEmpCount(deptChgHisVO);

        if(listCount > 0) {
            if(listCount == 1 && empCount > 0) {
                jsonObject.IsSucceed = false;
                jsonObject.ErrorMessage = "임직원이 존재하여 삭제할 수 없습니다.";
            } else {
                deptChgHisDao.deleteDeptChgHis(deptChgHisVO);

                DeptChgHisVO dept = deptChgHisDao.selectDeptLastestChgHis(deptChgHisVO);

                if(dept != null) {
                    deptChgHisDao.updateDeptInfo(dept);
                }

                if(dept == null) {
                    deptChgHisDao.deleteDeptInfo(deptChgHisVO);
                }

                jsonObject.IsSucceed = true;
            }
        } else {
            throw new DeptStateException("NO_HISTORY_EXCEPTION");
            //jsonObject.IsSucceed = false;
            //jsonObject.ErrorMessage = "삭제할 이력이 존재하지 않습니다.";
        }

        return jsonObject;
    }

    @Transactional
    public JsonObject<List<DeptChgHisVO>, Object> selectDeptParentSelectList(Payload<DeptChgHisVO> requestPayload) throws DeptStateException {
        log.info("call Service : " + this.getClass().getName() + ".selectDeptParentSelectList");

        //조직의 상위조직 조회
        JsonObject<List<DeptChgHisVO>, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        DeptChgHisVO deptChgHisVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + deptChgHisVO);

        List<DeptChgHisVO> deptList;

        deptList = deptChgHisDao.selectDeptParentSelectList(deptChgHisVO);

        jsonObject.Data = deptList;
        jsonObject.TotalSize = deptChgHisDao.selectDeptHisCnt(deptChgHisVO).getListCnt();
        jsonObject.IsSucceed = true;

        return jsonObject;
    }

    @Transactional
    public JsonObject<List<DeptChgHisVO>, Object> selectDeptListWhenAddRecord(Payload<DeptChgHisVO> requestPayload) throws DeptStateException {
        log.info("call Service : " + this.getClass().getName() + ".selectDeptListWhenAddRecord");

        //이력 추가할 때 조직리스트 조회
        JsonObject<List<DeptChgHisVO>, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        DeptChgHisVO deptChgHisVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + deptChgHisVO);

        List<DeptChgHisVO> list = deptChgHisDao.selectDeptListWhenAddRecord(deptChgHisVO);

        jsonObject.Data = list;
        jsonObject.IsSucceed = true;
        jsonObject.TotalSize = deptChgHisDao.selectDeptHisCnt(deptChgHisVO).getListCnt();

        return jsonObject;
    }

    @Transactional
    public JsonObject<List<DeptChgHisVO>, Object> updateDeptLastesAvlEndDate(Payload<DeptChgHisVO> requestPayload) throws DeptStateException {
        log.info("call Service : " + this.getClass().getName() + ".updateDeptLastesAvlEndDate");

        //조직의 유효기간 수정
        JsonObject<List<DeptChgHisVO>, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        DeptChgHisVO deptChgHisVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + deptChgHisVO);

        String avlStartDate = deptChgHisVO.getAvlStartDate();
        String avlEndDate = deptChgHisVO.getAvlEndDate();
        String deptId = deptChgHisVO.getDeptId();

        if(avlStartDate != "" && avlEndDate != "" && deptId != "") {
            try {
                deptChgHisDao.updateDeptLastesAvlEndDate(deptChgHisVO);
            } catch(Exception e) {
                jsonObject.IsSucceed = false;
            }
        }

        return jsonObject;
    }

    @Transactional
    public JsonObject<List<DeptChgHisVO>, Object> selectDeptParentComboList(Payload<DeptChgHisVO> requestPayload) throws DeptStateException {
        log.info("call Service : " + this.getClass().getName() + ".selectDeptParentComboList");

        //상위조직 콤보 조회
        JsonObject<List<DeptChgHisVO>, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        DeptChgHisVO deptChgHisVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + deptChgHisVO);

        List<DeptChgHisVO> list = deptChgHisDao.selectDeptParentComboList(deptChgHisVO);

        jsonObject.Data = list;
        jsonObject.IsSucceed = true;

        return jsonObject;
    }

    @Transactional
    public JsonObject<Integer, Object> selectDeptEmpCount(Payload<DeptChgHisVO> requestPayload) throws DeptStateException {
        log.info("call Service : " + this.getClass().getName() + ".selectDeptEmpCount");

        //조직에 속한 임직원 count 조회
        JsonObject<Integer, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        DeptChgHisVO deptChgHisVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + deptChgHisVO);

        String deptId = deptChgHisVO.getDeptId();

        if(deptId != "" && deptId != null) {
            try {
                jsonObject.Data = deptChgHisDao.selectDeptEmpCount(deptChgHisVO);
            } catch(Exception e) {
                jsonObject.IsSucceed = false;
            }
        }

        return jsonObject;
    }

    @Transactional
    public JsonObject<Object, Object> updateMasterDate(Payload<DeptChgHisVO> requestPayload) throws DeptStateException {
        log.info("call Service : " + this.getClass().getName() + ".updateMasterDate");

        //조직의 마스터데이터 수정
        JsonObject<Object, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        DeptChgHisVO deptChgHisVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + deptChgHisVO);

        String deptId = deptChgHisVO.getDeptId();
        String orgCloseDate = deptChgHisVO.getOrgCloseDate();

        if(deptId != "" && deptId != null) {
            try {
                deptChgHisDao.updateDeptLastesAvlEndDate(deptChgHisVO);
                jsonObject.IsSucceed = true;
            } catch(Exception e) {
                jsonObject.IsSucceed = false;
            }
        }

        return jsonObject;
    }

    @Transactional
    public JsonObject<String, Object> selectLastAvlEndDate(Payload<DeptChgHisVO> requestPayload) throws DeptStateException {
        log.info("call Service : " + this.getClass().getName() + ".selectLastAvlEndDate");

        //조직의 최신이력의 유효기간 조회
        JsonObject<String, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        DeptChgHisVO deptChgHisVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + deptChgHisVO);

        String deptId = deptChgHisVO.getDeptId();

        jsonObject.Data = deptId;
        jsonObject.IsSucceed = true;

        if(deptId != "" && deptId != null) {
            try {
                jsonObject.Data = deptChgHisDao.selectLastAvlEndDate(deptChgHisVO);
                jsonObject.IsSucceed = true;
            } catch(Exception e) {
                jsonObject.IsSucceed = false;
            }
        }

        return jsonObject;
    }
}
