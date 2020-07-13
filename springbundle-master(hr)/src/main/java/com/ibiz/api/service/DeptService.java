package com.ibiz.api.service;

import com.ibiz.api.dao.DeptDAO;
import com.ibiz.api.exception.CodeOverlapException;
import com.ibiz.api.exception.DateOverlapException;
import com.ibiz.api.exception.DeptStateException;
import com.ibiz.api.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
@Slf4j
public class DeptService {

    @Resource(name = "deptDAO")
    private DeptDAO deptDAO;

    @Transactional
    public JsonObject<List<DeptHistoryVO>, Object> selectDeptTree(Payload<DeptHistoryVO> requestPayload) throws DeptStateException {
        log.info("call Service : " + this.getClass().getName() + ".selectDeptTree");

        //좌측 트리 조회
        JsonObject<List<DeptHistoryVO>, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        DeptHistoryVO deptHistoryVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + deptHistoryVO);

        //if(StringUtils.isEmpty(deptHistoryVO.getDeptId()))
        //    throw new IllegalArgumentException();

        List<DeptHistoryVO> list = deptDAO.selectDeptTree(deptHistoryVO);
        jsonObject.Data = list;
        jsonObject.IsSucceed = true;

        return jsonObject;
    }

    @Transactional
    public JsonObject<List<DeptHistoryVO>, Object> selectDeptHistoryList(Payload<DeptHistoryVO> requestPayload) throws DeptStateException{
        log.info("call Service : " + this.getClass().getName() + ".selectDeptHistoryList");

        //조직이력 조회
        JsonObject<List<DeptHistoryVO>, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        DeptHistoryVO deptHistoryVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + deptHistoryVO);

        List<DeptHistoryVO> list = deptDAO.selectDeptHistoryList(deptHistoryVO);

        jsonObject.Data = list;
        jsonObject.IsSucceed = true;

        return jsonObject;
    }

    @Transactional
    public JsonObject<DeptHistoryVO, Object> selectLastDeptHistoryList(Payload<DeptHistoryVO> requestPayload) throws DeptStateException{
        log.info("call Service : " + this.getClass().getName() + ".selectLastDeptHistoryList");

        //조직의 마지막(최신) 변경 이력 조회
        JsonObject<DeptHistoryVO, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        DeptHistoryVO deptHistoryVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + deptHistoryVO);

        DeptHistoryVO data = deptDAO.selectLastDeptHistoryList(deptHistoryVO);

        jsonObject.Data = data;
        jsonObject.IsSucceed = true;

        return jsonObject;
    }

    @Transactional
    public JsonObject<DeptHistoryVO, Object> selectDeptlastestChgHis(Payload<DeptHistoryVO> requestPayload) throws DeptStateException{
        log.info("call Service : " + this.getClass().getName() + ".selectDeptlastestChgHis");

        //조직의 최신 이력 조회
        JsonObject<DeptHistoryVO, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        DeptHistoryVO deptHistoryVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + deptHistoryVO);

        DeptHistoryVO dept = deptDAO.selectDeptLastChgHistory(deptHistoryVO);

        jsonObject.Data = dept;
        jsonObject.IsSucceed = true;

        return jsonObject;
    }

    @Transactional
    public JsonObject<List<DeptHistoryVO>, Object> selectHighDeptTree(Payload<DeptHistoryVO> requestPayload) throws DeptStateException{
        log.info("call Service : " + this.getClass().getName() + ".selectHighDeptTree");

        //상위조직 조회
        JsonObject<List<DeptHistoryVO>, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        DeptHistoryVO deptHistoryVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + deptHistoryVO);

        List<DeptHistoryVO> list = deptDAO.selectHighDeptTree(deptHistoryVO);

        jsonObject.Data = list;
        jsonObject.IsSucceed = true;

        return jsonObject;
    }

    @Transactional
    public JsonObject<Object, Object> updateDept(Payload<DeptHistoryVO> requestPayload) throws DeptStateException,CodeOverlapException, DateOverlapException, CodeOverlapException {
        log.info("call Service : " + this.getClass().getName() + ".updateDept");

        JsonObject<Object, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        DeptHistoryVO deptHistoryVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + deptHistoryVO);

        deptHistoryVO.setHgrkDeptId(deptHistoryVO.getHgrkDeptId() != null && deptHistoryVO.getHgrkDeptId().length() > 0 ? deptHistoryVO.getHgrkDeptId() : "");
        deptHistoryVO.setHddpEmpId(deptHistoryVO.getHddpEmpId() != null && deptHistoryVO.getHddpEmpId().length() > 0 ? deptHistoryVO.getHddpEmpId() : "");
        deptHistoryVO.setDeptSortSeqc(deptHistoryVO.getDeptSortSeqc() != null && deptHistoryVO.getDeptSortSeqc().length() > 0 ? deptHistoryVO.getDeptSortSeqc() : "");
        deptHistoryVO.setOrgDstCd(deptHistoryVO.getOrgDstCd() != null && deptHistoryVO.getOrgDstCd().length() > 0 ? deptHistoryVO.getOrgDstCd() : "");

        deptHistoryVO.setChgEmpId(deptHistoryVO.getChgEmpId() != null && deptHistoryVO.getChgEmpId().length() > 0 ? deptHistoryVO.getChgEmpId() : "");

        Boolean isAddRecord = Boolean.valueOf(deptHistoryVO.getIsAddRecord());
        int totalSize = deptDAO.selectDeptHistoryCnt(deptHistoryVO).getListCnt();
        String deptCloseDate = (deptDAO.selectDeptCloseDate(deptHistoryVO) != null && deptDAO.selectDeptCloseDate(deptHistoryVO).getOrgCloseDate() != null) ? deptDAO.selectDeptCloseDate(deptHistoryVO).getOrgCloseDate() : "99991231";

//        try {
            //입력한 유효기간이 유효한가 체크 및 신규등록 체크
            DeptHistoryVO deptTmp = deptDAO.selectIsValidDept(deptHistoryVO);

            if(Boolean.valueOf(deptHistoryVO.getIsCreating()) == true && deptDAO.selectIsDuplicateDept(deptHistoryVO) > 0) {
                //jsonObject.IsSucceed = false;
                //jsonObject.ErrorMessage = "같은 부서ID로 등록된 부서조직이 존재합니다.";

                //return jsonObject;
                throw new CodeOverlapException("조직");
            }

            if(deptTmp.getValChk().trim().equals("S")) {
                //신규
                try {
                    deptDAO.insertDeptInfo(deptHistoryVO);
                    deptDAO.insertDeptChgHistory(deptHistoryVO);

                    if (Integer.parseInt(deptCloseDate) < Integer.parseInt(deptHistoryVO.getAvlEndDate())) {
                        deptDAO.updateDeptCloseDate(deptHistoryVO);
                    }

                    jsonObject.IsSucceed = true;
                }catch (Exception e){
                    throw new DeptStateException();
                }
            } else if (deptTmp.getValChk().trim().equals("LN") || deptTmp.getValChk().trim().equals("MN")) {
                //추가
                if(deptTmp.getValChk().trim().equals("LN") && isAddRecord == true) {
                    deptDAO.updateDeptInfo(deptHistoryVO);
                    deptDAO.updateDeptLastAvlEndDate(deptHistoryVO);

                }

                deptDAO.insertDeptChgHistory(deptHistoryVO);

                if(Integer.parseInt(deptCloseDate) < Integer.parseInt(deptHistoryVO.getAvlEndDate())) {
                    deptDAO.updateDeptCloseDate(deptHistoryVO);
                }

                jsonObject.IsSucceed = true;
            } else if (deptTmp.getValChk().trim().equals("LU") || deptTmp.getValChk().trim().equals("MU") || totalSize == 1) {
                //변경
                deptDAO.updateDeptChgHistory(deptHistoryVO);

                if(Boolean.valueOf(deptHistoryVO.getIsCreating()) == true && deptDAO.selectIsDuplicateDept(deptHistoryVO) > 0) {
                    //jsonObject.IsSucceed = false;
                    //jsonObject.ErrorMessage = "같은 부서ID로 등록된 부서조직이 존재합니다.";

                    //return jsonObject;
                    throw new CodeOverlapException("부서ID");
                }


                if(deptTmp.getValChk().trim().equals("LU"))
                    deptDAO.updateDeptInfo(deptHistoryVO);

                //if(Integer.parseInt(deptCloseDate) < Integer.parseInt(deptHistoryVO.getAvlEndDate())) {
                    deptDAO.updateDeptCloseDate(deptHistoryVO);
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
    public JsonObject<Object, Object> deleteDeptHis(Payload<DeptHistoryVO> requestPayload) throws DeptStateException {
        log.info("call Service : " + this.getClass().getName() + ".deleteDeptHis");

        //조직 삭제
        JsonObject<Object, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        DeptHistoryVO deptHistoryVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + deptHistoryVO);

        int listCount = deptDAO.selectDeptHistoryCnt(deptHistoryVO).getListCnt();
        int empCount = deptDAO.selectDeptEmployeeCnt(deptHistoryVO);

        if(listCount > 0) {
            if(listCount == 1 && empCount > 0) {
                jsonObject.IsSucceed = false;
                jsonObject.ErrorMessage = "임직원이 존재하여 삭제할 수 없습니다.";
            } else {
                deptDAO.deleteDeptChgHistory(deptHistoryVO);

                DeptHistoryVO dept = deptDAO.selectDeptLastChgHistory(deptHistoryVO);

                if(dept != null) {
                    deptDAO.updateDeptInfo(dept);
                }

                if(dept == null) {
                    deptDAO.deleteDeptInfo(deptHistoryVO);
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
    public JsonObject<List<DeptHistoryVO>, Object> selectHgrkDeptFromAvlDateList(Payload<DeptHistoryVO> requestPayload) throws DeptStateException {
        log.info("call Service : " + this.getClass().getName() + ".selectHgrkDeptFromAvlDateList");

        //조직의 상위조직 조회
        JsonObject<List<DeptHistoryVO>, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        DeptHistoryVO deptHistoryVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + deptHistoryVO);

        List<DeptHistoryVO> deptList;

        deptList = deptDAO.selectHgrkDeptFromAvlDateList(deptHistoryVO);

        jsonObject.Data = deptList;
        jsonObject.TotalSize = deptDAO.selectDeptHistoryCnt(deptHistoryVO).getListCnt();
        jsonObject.IsSucceed = true;

        return jsonObject;
    }

    @Transactional
    public JsonObject<List<DeptHistoryVO>, Object> selectDeptListWhenAddRecord(Payload<DeptHistoryVO> requestPayload) throws DeptStateException {
        log.info("call Service : " + this.getClass().getName() + ".selectDeptListWhenAddRecord");

        //이력 추가할 때 조직리스트 조회
        JsonObject<List<DeptHistoryVO>, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        DeptHistoryVO deptHistoryVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + deptHistoryVO);

        List<DeptHistoryVO> list = deptDAO.selectDeptListWhenAddRecord(deptHistoryVO);

        jsonObject.Data = list;
        jsonObject.IsSucceed = true;
        jsonObject.TotalSize = deptDAO.selectDeptHistoryCnt(deptHistoryVO).getListCnt();

        return jsonObject;
    }

    @Transactional
    public JsonObject<List<DeptHistoryVO>, Object> updateDeptLastAvlEndDate(Payload<DeptHistoryVO> requestPayload) throws DeptStateException {
        log.info("call Service : " + this.getClass().getName() + ".updateDeptLastAvlEndDate");

        //조직의 유효기간 수정
        JsonObject<List<DeptHistoryVO>, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        DeptHistoryVO deptHistoryVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + deptHistoryVO);

        String avlStartDate = deptHistoryVO.getAvlStartDate();
        String avlEndDate = deptHistoryVO.getAvlEndDate();
        String deptId = deptHistoryVO.getDeptId();

        if(avlStartDate != "" && avlEndDate != "" && deptId != "") {
            try {
                deptDAO.updateDeptLastAvlEndDate(deptHistoryVO);
            } catch(Exception e) {
                jsonObject.IsSucceed = false;
            }
        }

        return jsonObject;
    }

    @Transactional
    public JsonObject<List<DeptHistoryVO>, Object> selectHgrkDeptWhenAddRecordList(Payload<DeptHistoryVO> requestPayload) throws DeptStateException {
        log.info("call Service : " + this.getClass().getName() + ".selectHgrkDeptWhenAddRecordList");

        //상위조직 콤보 조회
        JsonObject<List<DeptHistoryVO>, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        DeptHistoryVO deptHistoryVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + deptHistoryVO);

        List<DeptHistoryVO> list = deptDAO.selectHgrkDeptWhenAddRecordList(deptHistoryVO);

        jsonObject.Data = list;
        jsonObject.IsSucceed = true;

        return jsonObject;
    }

    @Transactional
    public JsonObject<Integer, Object> selectDeptEmployeeCnt(Payload<DeptHistoryVO> requestPayload) throws DeptStateException {
        log.info("call Service : " + this.getClass().getName() + ".selectDeptEmployeeCnt");

        //조직에 속한 임직원 count 조회
        JsonObject<Integer, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        DeptHistoryVO deptHistoryVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + deptHistoryVO);

        String deptId = deptHistoryVO.getDeptId();

        if(deptId != "" && deptId != null) {
            try {
                jsonObject.Data = deptDAO.selectDeptEmployeeCnt(deptHistoryVO);
            } catch(Exception e) {
                jsonObject.IsSucceed = false;
            }
        }

        return jsonObject;
    }

    @Transactional
    public JsonObject<Object, Object> updateMasterDate(Payload<DeptHistoryVO> requestPayload) throws DeptStateException {
        log.info("call Service : " + this.getClass().getName() + ".updateMasterDate");

        //조직의 마스터데이터 수정
        JsonObject<Object, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        DeptHistoryVO deptHistoryVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + deptHistoryVO);

        String deptId = deptHistoryVO.getDeptId();
        String orgCloseDate = deptHistoryVO.getOrgCloseDate();

        if(deptId != "" && deptId != null) {
            try {
                deptDAO.updateDeptLastAvlEndDate(deptHistoryVO);
                jsonObject.IsSucceed = true;
            } catch(Exception e) {
                jsonObject.IsSucceed = false;
            }
        }

        return jsonObject;
    }

    @Transactional
    public JsonObject<String, Object> selectLastAvlEndDate(Payload<DeptHistoryVO> requestPayload) throws DeptStateException {
        log.info("call Service : " + this.getClass().getName() + ".selectLastAvlEndDate");

        //조직의 최신이력의 유효기간 조회
        JsonObject<String, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        DeptHistoryVO deptHistoryVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + deptHistoryVO);

        String deptId = deptHistoryVO.getDeptId();

        jsonObject.Data = deptId;
        jsonObject.IsSucceed = true;

        if(deptId != "" && deptId != null) {
            try {
                jsonObject.Data = deptDAO.selectLastAvlEndDate(deptHistoryVO);
                jsonObject.IsSucceed = true;
            } catch(Exception e) {
                jsonObject.IsSucceed = false;
            }
        }

        return jsonObject;
    }


    @Transactional
    public JsonObject<List<DeptVO>, Object> selectAllDeptList(Payload<DeptVO> requestPayload) throws Exception {
        log.info("call Service : " + this.getClass().getName() + "selectAllDeptList");

        JsonObject<List<DeptVO>, Object> jsonObject = new JsonObject<>();
        //AccountVO accountVO = requestPayload.getAccountVO();
        DeptVO deptVO = requestPayload.getDto();

        log.info("Paramater : " + deptVO);

        List<DeptVO> list = deptDAO.selectAllDeptList(deptVO);

        jsonObject.IsSucceed = true;
        jsonObject.Data = list;

        return jsonObject;
    }

    @Transactional
    public JsonObject<List<DeptVO>, Object> selectAuthDeptList(Payload<DeptVO> requestPayload) throws Exception {
        log.info("call Service : " + this.getClass().getName() + ".selectAuthDeptList");

        JsonObject<List<DeptVO>, Object> jsonObject = new JsonObject<>();
        AccountVO accountVO = requestPayload.getAccountVO();
        DeptVO deptVO = requestPayload.getDto();

        log.info("Paramater : " + accountVO);
        log.info("Paramater : " + deptVO);

        // 권한 우선순위
        // 영업권한 > 제품기획/마케팅권한
        if((accountVO.getRoleList().contains("BS") && accountVO.getRoleList().contains("MK")) && deptVO.getUserGrpCd().equals("BS")) {
            deptVO.setUserGrpCd("BS");
        }else if(accountVO.getRoleList().contains("MK") && deptVO.getUserGrpCd().equals("BS")) {
            // 영업권한을 조회하는 콤보박스인데 접속자가 마케팅권한만 있을 경우
            // 마케팅권한부서 중에서 영업부서만 조회
            deptVO.setUserGrpCd("MK");
            deptVO.setPriorUserGrpCd("BS");
        }

        deptVO.setEmpId(accountVO.getEmpId());
        List<DeptVO> list = deptDAO.selectAuthDeptList(deptVO);

        jsonObject.IsSucceed = true;
        jsonObject.Data = list;

        return jsonObject;
    }

    @Transactional
    public List<DeptVO> selectDeptSearchList(Payload<DeptVO> requestPayload) throws Exception {
        log.info("call Service : " + this.getClass().getName() + ".selectDeptSearchList");

        JsonObject<List<DeptVO>, Object> jsonObject = new JsonObject<>();
        //AccountVO accountVO = requestPayload.getAccountVO();
        DeptVO deptVO = requestPayload.getDto();

        log.info("Paramater : " + deptVO);

        List<DeptVO> list = deptDAO.selectDeptSearchList(deptVO);

        return list;
    }


    @Transactional
    public String selectIsAuthBySlsEmp(Payload<DeptVO> requestPayload) throws Exception {
        log.info("call Service : " + this.getClass().getName() + ".selectIsAuthBySlsEmp");

        JsonObject<List<EmployeeVO>, Object> jsonObject = new JsonObject<>();
        //AccountVO accountVO = requestPayload.getAccountVO();
        DeptVO deptVO = requestPayload.getDto();

        log.info("Paramater : " + deptVO);

        String totalSize = deptDAO.selectIsAuthBySlsEmp(deptVO).getTotalSize().toString();

        return totalSize;
    }


    // Excel
    @Transactional
    public List<ExcelDeptVO> selectExcelDwnlDeptList(Payload<DeptVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectExcelDwnlDeptList");
        DeptVO deptVO = requestPayload.getDto();

        List<ExcelDeptVO> list = deptDAO.selectExcelDwnlDeptList(deptVO);

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
    public List<ExcelDeptHistoryVO> selectExcelDwnlDeptHistoryList(Payload<DeptVO> requestPayload) throws Exception {
        log.info("Call Service : " + this.getClass().getName() + ".selectExcelDwnlDeptHistoryList");
        DeptVO deptVO = requestPayload.getDto();

        List<ExcelDeptHistoryVO> list = deptDAO.selectExcelDwnlDeptHistoryList(deptVO);

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
