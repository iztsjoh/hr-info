package com.ibiz.api.controller;

import com.google.gson.reflect.TypeToken;
import com.ibiz.api.model.CostCenterChgHisVO;
import com.ibiz.api.model.DeptChgHisVO;
import com.ibiz.api.model.JsonObject;
import com.ibiz.api.model.Payload;
import com.ibiz.api.service.CostCenterService;
import com.ibiz.api.service.DeptChgHisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hr")
public class DeptChgHisController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(CostCenterController.class);
    @Autowired
    private DeptChgHisService deptChgHisService;

    /*@GetMapping("/healthcheck")
    public String checkState() {
        return "board-8200";
    }*/

    @PostMapping("/selectDeptTree")
    public ResponseEntity<String> selectDeptTree(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectDeptTree");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptChgHisVO>>(){});

        return super.composePayload(new Payload<JsonObject<List<DeptChgHisVO>, Object>>(deptChgHisService.selectDeptTree(requestPayload)));
    }

    @PostMapping("/selectDeptHisList")
    public ResponseEntity<String> selectDeptHisList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectDeptHisList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptChgHisVO>>(){});

        return super.composePayload(new Payload<JsonObject<List<DeptChgHisVO>, Object>>(deptChgHisService.selectDeptHisList(requestPayload)));
    }

    @PostMapping("/selectLastDeptHisList")
    public ResponseEntity<String> selectLastDeptHisList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectLastDeptHisList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptChgHisVO>>(){});

        return super.composePayload(new Payload<JsonObject<DeptChgHisVO, Object>>(deptChgHisService.selectLastDeptHisList(requestPayload)));
    }

    @PostMapping("/selectDeptlastestChgHis")
    public ResponseEntity<String> selectDeptlastestChgHis(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectDeptlastestChgHis");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptChgHisVO>>(){});

        return super.composePayload(new Payload<JsonObject<DeptChgHisVO, Object>>(deptChgHisService.selectDeptlastestChgHis(requestPayload)));
    }

    @PostMapping("/selectHighDeptTree")
    public ResponseEntity<String> selectHighDeptTree(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectHighDeptTree");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptChgHisVO>>(){});

        return super.composePayload(new Payload<JsonObject<DeptChgHisVO, Object>>(deptChgHisService.selectHighDeptTree(requestPayload)));
    }

    @PostMapping("/updateDept")
    public ResponseEntity<String> updateDept(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateDept");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptChgHisVO>>(){});

        return super.composePayload(new Payload<JsonObject<Object, Object>>(deptChgHisService.updateDept(requestPayload)));
    }

    @PostMapping("/deleteDeptHis")
    public ResponseEntity<String> deleteDeptHis(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".deleteDeptHis");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptChgHisVO>>(){});

        return super.composePayload(new Payload<JsonObject<Object, Object>>(deptChgHisService.deleteDeptHis(requestPayload)));
    }

    @PostMapping("/selectDeptParentSelectList")
    public ResponseEntity<String> selectDeptParentSelectList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectDeptParentSelectList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptChgHisVO>>(){});

        return super.composePayload(new Payload<JsonObject<List<DeptChgHisVO>, Object>>(deptChgHisService.selectDeptParentSelectList(requestPayload)));
    }

    @PostMapping("/selectDeptListWhenAddRecord")
    public ResponseEntity<String> selectDeptListWhenAddRecord(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectDeptListWhenAddRecord");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptChgHisVO>>(){});

        return super.composePayload(new Payload<JsonObject<List<DeptChgHisVO>, Object>>(deptChgHisService.selectDeptListWhenAddRecord(requestPayload)));
    }

    @PostMapping("/updateDeptLastesAvlEndDate")
    public ResponseEntity<String> updateDeptLastesAvlEndDate(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateDeptLastesAvlEndDate");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptChgHisVO>>(){});

        return super.composePayload(new Payload<JsonObject<Object, Object>>(deptChgHisService.updateDeptLastesAvlEndDate(requestPayload)));
    }

    @PostMapping("/selectDeptParentComboList")
    public ResponseEntity<String> selectDeptParentComboList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectDeptParentComboList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptChgHisVO>>(){});

        return super.composePayload(new Payload<JsonObject<List<DeptChgHisVO>, Object>>(deptChgHisService.selectDeptParentComboList(requestPayload)));
    }

    @PostMapping("/selectDeptEmpCount")
    public ResponseEntity<String> selectDeptEmpCount(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectDeptEmpCount");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptChgHisVO>>(){});

        return super.composePayload(new Payload<JsonObject<String, Object>>(deptChgHisService.selectDeptEmpCount(requestPayload)));
    }

    @PostMapping("/updateMasterDate")
    public ResponseEntity<String> updateMasterDate(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateMasterDate");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptChgHisVO>>(){});

        return super.composePayload(new Payload<JsonObject<Object, Object>>(deptChgHisService.updateMasterDate(requestPayload)));
    }

    @PostMapping("/selectLastAvlEndDate")
    public ResponseEntity<String> selectLastAvlEndDate(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectLastAvlEndDate");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<DeptChgHisVO>>(){});

        return super.composePayload(new Payload<JsonObject<String, Object>>(deptChgHisService.selectLastAvlEndDate(requestPayload)));
    }
}
