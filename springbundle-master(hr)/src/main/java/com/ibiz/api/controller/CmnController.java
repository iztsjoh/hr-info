package com.ibiz.api.controller;

import com.google.gson.reflect.TypeToken;
import com.ibiz.api.model.*;
import com.ibiz.api.service.CmnService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hr")
public class CmnController extends BaseController  {

    private static final Logger log = LoggerFactory.getLogger(CostCenterController.class);

    @Autowired
    private CmnService cmnService;

    @PostMapping("/selectAllDeptList")
    public ResponseEntity<String> selectAllDeptList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectDeptTree");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptVO>>(){});

        return super.composePayload(new Payload<JsonObject<List<DeptVO>, Object>>(cmnService.selectAllDeptList(requestPayload)));
    }

    @PostMapping("/selectAuthDeptList")
    public ResponseEntity<String> selectAuthDeptList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectAuthDeptList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptVO>>(){});

        return super.composePayload(new Payload<JsonObject<List<DeptVO>, Object>>(cmnService.selectAuthDeptList(requestPayload)));
    }

    @PostMapping("/selectDeptSearchList")
    public ResponseEntity<String> selectDeptSearchList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectDeptSearchList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptVO>>(){});

        return super.composePayload(new Payload<List<DeptVO>>(cmnService.selectDeptSearchList(requestPayload)));
    }

    @PostMapping("/selectIsLowerDept")
    public ResponseEntity<String> selectIsLowerDept(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectIsLowerDept");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptVO>>(){});

        return super.composePayload(new Payload<JsonObject<DeptVO, Object>>(cmnService.selectIsLowerDept(requestPayload)));
    }

    @PostMapping("/selectHddpEmp")
    public ResponseEntity<String> selectHddpEmp(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectHddpEmp");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptVO>>(){});

        return super.composePayload(new Payload<JsonObject<EmpVO, Object>>(cmnService.selectHddpEmp(requestPayload)));
    }

    @PostMapping("/selectEMPSearchList")
    public ResponseEntity<String> selectEMPSearchList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectEMPSearchList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<EmpVO>>(){});

        return super.composePayload(new Payload<JsonObject<List<EmpVO>, Object>>(cmnService.selectEMPSearchList(requestPayload)));
    }

    @PostMapping("/selectEMPInfo")
    public ResponseEntity<String> selectEMPInfo(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectEMPInfo");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<EmpVO>>(){});

        return super.composePayload(new Payload<JsonObject<EmpVO, Object>>(cmnService.selectEMPInfo(requestPayload)));
    }

    @PostMapping("/selectIsAuthBySlsEmp")
    public ResponseEntity<String> selectIsAuthBySlsEmp(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectIsAuthBySlsEmp");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptVO>>(){});

        return super.composePayload(new Payload<String>(cmnService.selectIsAuthBySlsEmp(requestPayload)));
    }

}
