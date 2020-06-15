package com.ibiz.api.service;

import com.ibiz.api.dao.CmnDao;
import com.ibiz.api.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class CmnService {
    @Resource(name = "CmnDao")
    private CmnDao CmnDao;

    @Transactional
    public JsonObject<List<DeptVO>, Object> selectAllDeptList(Payload<DeptVO> requestPayload) throws Exception {
        log.info("call Service : " + this.getClass().getName() + "selectAllDeptList");

        JsonObject<List<DeptVO>, Object> jsonObject = new JsonObject<>();
        //AccountVO accountVO = requestPayload.getAccountVO();
        DeptVO deptVO = requestPayload.getDto();

        log.info("Paramater : " + deptVO);

        List<DeptVO> list = CmnDao.selectAllDeptList(deptVO);

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
        List<DeptVO> list = CmnDao.selectAuthDeptList(deptVO);

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

        List<DeptVO> list = CmnDao.selectDeptSearchList(deptVO);

        return list;
    }

    @Transactional
    public JsonObject<DeptVO, Object> selectIsLowerDept(Payload<DeptVO> requestPayload) throws Exception {
        log.info("call Service : " + this.getClass().getName() + ".selectIsLowerDept");

        JsonObject<DeptVO, Object> jsonObject = new JsonObject<>();
        //AccountVO accountVO = requestPayload.getAccountVO();
        DeptVO deptVO = requestPayload.getDto();

        log.info("Paramater : " + deptVO);

        DeptVO result = CmnDao.selectIsLowerDept(deptVO);

        jsonObject.IsSucceed = true;
        jsonObject.Data = result;

        return jsonObject;
    }

    @Transactional
    public JsonObject<EmpVO, Object> selectHddpEmp(Payload<DeptVO> requestPayload) {
        log.info("call Service : " + this.getClass().getName() + ".selectHddpEmp");

        JsonObject<EmpVO, Object> jsonObject = new JsonObject<>();
        //AccountVO accountVO = requestPayload.getAccountVO();
        DeptVO deptVO = requestPayload.getDto();

        log.info("Paramater : " + deptVO);

        EmpVO data;

        data = CmnDao.selectHddpEmp(deptVO);

        jsonObject.Data = data;
        jsonObject.IsSucceed = true;

        return jsonObject;
    }

    @Transactional
    public JsonObject<List<EmpVO>, Object> selectEMPSearchList(Payload<EmpVO> requestPayload) throws Exception {
        log.info("call Service : " + this.getClass().getName() + ".selectEMPSearchList");

        JsonObject<List<EmpVO>, Object> jsonObject = new JsonObject<>();
        //AccountVO accountVO = requestPayload.getAccountVO();
        EmpVO empVO = requestPayload.getDto();

        log.info("Paramater : " + empVO);


        List<EmpVO> list = CmnDao.selectEMPSearchList(empVO);

        jsonObject.IsSucceed = true;
        jsonObject.Data = list;

        if(list.size() < 1) {
            jsonObject.TotalSize = 0;
        } else {
            jsonObject.TotalSize = list.get(0).getTotalCnt();
        }

        return jsonObject;
    }

    @Transactional
    public JsonObject<EmpVO, Object> selectEMPInfo(Payload<EmpVO> requestPayload) throws Exception {
        log.info("call Service : " + this.getClass().getName() + ".selectEMPInfo");

        JsonObject<EmpVO, Object> jsonObject = new JsonObject<>();
        //AccountVO accountVO = requestPayload.getAccountVO();
        EmpVO empVO = requestPayload.getDto();

        log.info("Paramater : " + empVO);

        EmpVO vo = CmnDao.selectEmpInfo(empVO);

        jsonObject.IsSucceed = true;
        jsonObject.Data = vo;

        return jsonObject;
    }

    @Transactional
    public String selectIsAuthBySlsEmp(Payload<DeptVO> requestPayload) throws Exception {
        log.info("call Service : " + this.getClass().getName() + ".selectIsAuthBySlsEmp");

        JsonObject<List<EmpVO>, Object> jsonObject = new JsonObject<>();
        //AccountVO accountVO = requestPayload.getAccountVO();
        DeptVO deptVO = requestPayload.getDto();

        log.info("Paramater : " + deptVO);

        String totalSize = CmnDao.selectIsAuthBySlsEmp(deptVO).getTotalSize().toString();

        return totalSize;
    }
}
