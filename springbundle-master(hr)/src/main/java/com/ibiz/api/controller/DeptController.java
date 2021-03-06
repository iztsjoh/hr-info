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
@RequestMapping("/dept")
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

    @PostMapping("/selectDeptYearTree")
    public ResponseEntity<String> selectDeptYearTree(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectDeptYearTree");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptHistoryVO>>(){});

        return super.composePayload(new Payload<JsonObject<List<DeptHistoryVO>, Object>>(deptService.selectDeptYearTree(requestPayload)));
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

    @PostMapping("/selectDeptYearInfo")
    public ResponseEntity<String> selectDeptYearInfo(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectDeptYearInfo");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptHistoryVO>>(){});

        return super.composePayload(new Payload<JsonObject<DeptHistoryVO, Object>>(deptService.selectDeptYearInfo(requestPayload)));
    }

    @PostMapping("/updateDept")
    public ResponseEntity<String> updateDept(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateDept");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptHistoryVO>>(){});

        return super.composePayload(new Payload<JsonObject<Object, Object>>(deptService.updateDept(requestPayload)));
    }

    @PostMapping("/updateYearDept")
    public ResponseEntity<String> updateYearDept(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateDept");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptHistoryVO>>(){});

        return super.composePayload(new Payload<JsonObject<Object, Object>>(deptService.updateYearDept(requestPayload)));
    }

    @PostMapping("/copyYearDept")
    public ResponseEntity<String> copyYearDept(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateDept");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptHistoryVO>>(){});

        return super.composePayload(new Payload<JsonObject<Object, Object>>(deptService.copyYearDept(requestPayload)));
    }

    @PostMapping("/deleteDeptHistory")
    public ResponseEntity<String> deleteDeptHistory(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".deleteDeptHistory");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptHistoryVO>>(){});

        return super.composePayload(new Payload<JsonObject<Object, Object>>(deptService.deleteDeptHistory(requestPayload)));
    }

    @PostMapping("/deleteYearDept")
    public ResponseEntity<String> deleteYearDept(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".deleteDeptHistory");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptHistoryVO>>(){});

        return super.composePayload(new Payload<JsonObject<Object, Object>>(deptService.deleteYearDept(requestPayload)));
    }

    @PostMapping("/selectHgrkDeptFromAvlDateList")
    public ResponseEntity<String> selectHgrkDeptFromAvlDateList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectHgrkDeptFromAvlDateList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptHistoryVO>>(){});

        return super.composePayload(new Payload<JsonObject<List<DeptHistoryVO>, Object>>(deptService.selectHgrkDeptFromAvlDateList(requestPayload)));
    }

    @PostMapping("/selectHgrkDeptFromYearList")
    public ResponseEntity<String> selectHgrkDeptFromYearList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectHgrkDeptFromYearList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptHistoryVO>>(){});

        return super.composePayload(new Payload<JsonObject<List<DeptHistoryVO>, Object>>(deptService.selectHgrkDeptFromYearList(requestPayload)));
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

    @PostMapping("/selectHgrkDeptYearAddRecordList")
    public ResponseEntity<String> selectHgrkDeptYearAddRecordList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectHgrkDeptYearAddRecordList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptHistoryVO>>(){});

        return super.composePayload(new Payload<JsonObject<List<DeptHistoryVO>, Object>>(deptService.selectHgrkDeptYearAddRecordList(requestPayload)));
    }

    @PostMapping("/selectDeptEmployeeCnt")
    public ResponseEntity<String> selectDeptEmployeeCnt(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectDeptEmployeeCnt");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptHistoryVO>>(){});

        return super.composePayload(new Payload<JsonObject<String, Object>>(deptService.selectDeptEmployeeCnt(requestPayload)));
    }

    @PostMapping("/updateDeptHistoryAvlDate")
    public ResponseEntity<String> updateDeptHistoryAvlDate(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateDeptHistoryAvlDate");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptHistoryVO>>(){});

        return super.composePayload(new Payload<JsonObject<Object, Object>>(deptService.updateDeptHistoryAvlDate(requestPayload)));
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


    // excel 엑셀

    // 조직정보 엑셀 다운로드
    @PostMapping("/selectExcelDwnlDeptList")
    public ResponseEntity<String> selectExcelDwnlDeptList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectExcelDwnlDeptList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptVO>>(){});

        return super.composePayload(new Payload<List>(deptService.selectExcelDwnlDeptList(requestPayload)));
    }

    // 조직이력정보 엑셀 다운로드
    @PostMapping("/selectExcelDwnlDeptHistoryList")
    public ResponseEntity<String> selectExcelDwnlDeptHistoryList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectExcelDwnlDeptHistoryList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptVO>>(){});

        return super.composePayload(new Payload<List>(deptService.selectExcelDwnlDeptHistoryList(requestPayload)));
    }


}
