package com.ibiz.api.controller;

import com.google.gson.reflect.TypeToken;
import com.ibiz.api.model.*;
import com.ibiz.api.service.DeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hr")
public class DeptController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(DeptController.class);
    @Autowired
    private DeptService deptService;

    /*@GetMapping("/healthcheck")
    public String checkState() {
        return "board-8200";
    }*/

    @PostMapping("/selectDeptTree")
    public ResponseEntity<String> selectDeptTree(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectDeptTree");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptHistoryVO>>(){});

        return super.composePayload(new Payload<JsonObject<List<DeptHistoryVO>, Object>>(deptService.selectDeptTree(requestPayload)));
    }

    @PostMapping("/selectDeptHistoryList")
    public ResponseEntity<String> selectDeptHistoryList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectDeptHistoryList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptHistoryVO>>(){});

        return super.composePayload(new Payload<JsonObject<List<DeptHistoryVO>, Object>>(deptService.selectDeptHistoryList(requestPayload)));
    }

    @PostMapping("/selectLastDeptHistoryList")
    public ResponseEntity<String> selectLastDeptHistoryList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectLastDeptHistoryList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptHistoryVO>>(){});

        return super.composePayload(new Payload<JsonObject<DeptHistoryVO, Object>>(deptService.selectLastDeptHistoryList(requestPayload)));
    }

    @PostMapping("/selectDeptlastestChgHis")
    public ResponseEntity<String> selectDeptlastestChgHis(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectDeptlastestChgHis");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptHistoryVO>>(){});

        return super.composePayload(new Payload<JsonObject<DeptHistoryVO, Object>>(deptService.selectDeptlastestChgHis(requestPayload)));
    }

    @PostMapping("/selectHighDeptTree")
    public ResponseEntity<String> selectHighDeptTree(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectHighDeptTree");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptHistoryVO>>(){});

        return super.composePayload(new Payload<JsonObject<DeptHistoryVO, Object>>(deptService.selectHighDeptTree(requestPayload)));
    }

    @PostMapping("/updateDept")
    public ResponseEntity<String> updateDept(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateDept");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptHistoryVO>>(){});

        return super.composePayload(new Payload<JsonObject<Object, Object>>(deptService.updateDept(requestPayload)));
    }

    @PostMapping("/deleteDeptHis")
    public ResponseEntity<String> deleteDeptHis(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".deleteDeptHis");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptHistoryVO>>(){});

        return super.composePayload(new Payload<JsonObject<Object, Object>>(deptService.deleteDeptHis(requestPayload)));
    }

    @PostMapping("/selectHgrkDeptFromAvlDateList")
    public ResponseEntity<String> selectHgrkDeptFromAvlDateList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectHgrkDeptFromAvlDateList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptHistoryVO>>(){});

        return super.composePayload(new Payload<JsonObject<List<DeptHistoryVO>, Object>>(deptService.selectHgrkDeptFromAvlDateList(requestPayload)));
    }

    @PostMapping("/selectDeptListWhenAddRecord")
    public ResponseEntity<String> selectDeptListWhenAddRecord(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectDeptListWhenAddRecord");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptHistoryVO>>(){});

        return super.composePayload(new Payload<JsonObject<List<DeptHistoryVO>, Object>>(deptService.selectDeptListWhenAddRecord(requestPayload)));
    }

    @PostMapping("/updateDeptLastAvlEndDate")
    public ResponseEntity<String> updateDeptLastAvlEndDate(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateDeptLastAvlEndDate");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptHistoryVO>>(){});

        return super.composePayload(new Payload<JsonObject<Object, Object>>(deptService.updateDeptLastAvlEndDate(requestPayload)));
    }

    @PostMapping("/selectHgrkDeptWhenAddRecordList")
    public ResponseEntity<String> selectHgrkDeptWhenAddRecordList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectHgrkDeptWhenAddRecordList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptHistoryVO>>(){});

        return super.composePayload(new Payload<JsonObject<List<DeptHistoryVO>, Object>>(deptService.selectHgrkDeptWhenAddRecordList(requestPayload)));
    }

    @PostMapping("/selectDeptEmployeeCnt")
    public ResponseEntity<String> selectDeptEmployeeCnt(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectDeptEmployeeCnt");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptHistoryVO>>(){});

        return super.composePayload(new Payload<JsonObject<String, Object>>(deptService.selectDeptEmployeeCnt(requestPayload)));
    }

    @PostMapping("/updateMasterDate")
    public ResponseEntity<String> updateMasterDate(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateMasterDate");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptHistoryVO>>(){});

        return super.composePayload(new Payload<JsonObject<Object, Object>>(deptService.updateMasterDate(requestPayload)));
    }

    @PostMapping("/selectLastAvlEndDate")
    public ResponseEntity<String> selectLastAvlEndDate(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectLastAvlEndDate");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptHistoryVO>>(){});

        return super.composePayload(new Payload<JsonObject<String, Object>>(deptService.selectLastAvlEndDate(requestPayload)));
    }


    @PostMapping("/selectAllDeptList")
    public ResponseEntity<String> selectAllDeptList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectAllDeptList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptVO>>(){});

        return super.composePayload(new Payload<JsonObject<List<DeptVO>, Object>>(deptService.selectAllDeptList(requestPayload)));
    }

    @PostMapping("/selectAuthDeptList")
    public ResponseEntity<String> selectAuthDeptList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectAuthDeptList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptVO>>(){});

        return super.composePayload(new Payload<JsonObject<List<DeptVO>, Object>>(deptService.selectAuthDeptList(requestPayload)));
    }

    @PostMapping("/selectDeptSearchList")
    public ResponseEntity<String> selectDeptSearchList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectDeptSearchList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptVO>>(){});

        return super.composePayload(new Payload<List<DeptVO>>(deptService.selectDeptSearchList(requestPayload)));
    }


    @PostMapping("/selectIsAuthBySlsEmp")
    public ResponseEntity<String> selectIsAuthBySlsEmp(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectIsAuthBySlsEmp");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptVO>>(){});

        return super.composePayload(new Payload<String>(deptService.selectIsAuthBySlsEmp(requestPayload)));
    }

}
