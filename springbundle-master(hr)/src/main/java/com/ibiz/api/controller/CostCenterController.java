package com.ibiz.api.controller;

import com.google.gson.reflect.TypeToken;
import com.ibiz.api.model.CostCenterVO;
import com.ibiz.api.model.EmployeeVO;
import com.ibiz.api.model.JsonObject;
import com.ibiz.api.model.Payload;
import com.ibiz.api.service.CostCenterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/costCenter")
public class CostCenterController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(CostCenterController.class);
    @Autowired
    private CostCenterService costCenterService;

    /*@GetMapping("/healthcheck")
    public String checkState() {
        return "board-8200";
    }*/

    @PostMapping("/selectCostCenterTree")
    public ResponseEntity<String> selectCostCenterTree(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectCostCenterTree");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<CostCenterVO>>(){});

        return super.composePayload(new Payload<JsonObject<List<CostCenterVO>, Object>>(costCenterService.selectCostCenterTree(requestPayload)));
    }

    @PostMapping("/selectCostCenterHistoryList")
    public ResponseEntity<String> selectCostCenterHistoryList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectCostCenterHistoryList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<CostCenterVO>>(){});

        return super.composePayload(new Payload<JsonObject<List<CostCenterVO>, Object>>(costCenterService.selectCostCenterHistoryList(requestPayload)));
    }

    @PostMapping("/selectCostCenterlastHistory")
    public ResponseEntity<String> selectCostCenterlastHistory(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectCostCenterlastHistory");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<CostCenterVO>>(){});

        return super.composePayload(new Payload<JsonObject<CostCenterVO, Object>>(costCenterService.selectCostCenterlastHistory(requestPayload)));
    }

    @PostMapping("/selectHighCostCenterTree")
    public ResponseEntity<String> selectHighCostCenterTree(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectHighCostCenterTree");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<CostCenterVO>>(){});

        return super.composePayload(new Payload<JsonObject<List<CostCenterVO>, Object>>(costCenterService.selectHighCostCenterTree(requestPayload)));
    }

    @PostMapping("/updateCostCenter")
    public ResponseEntity<String> updateCostCenter(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateCostCenter");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<CostCenterVO>>(){});

        return super.composePayload(new Payload<JsonObject<Object, Object>>(costCenterService.updateCostCenter(requestPayload)));
    }

    @PostMapping("/deleteCostCenterHistory")
    public ResponseEntity<String> deleteCostCenterHistory(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".deleteCostCenterHistory");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<CostCenterVO>>(){});

        return super.composePayload(new Payload<JsonObject<Object, Object>>(costCenterService.deleteCostCenterHistory(requestPayload)));
    }

    @PostMapping("/selectCostCenterAvl")
    public ResponseEntity<String> selectCostCenterAvl(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectCostCenterAvl");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<CostCenterVO>>(){});

        return super.composePayload(new Payload<JsonObject<List<CostCenterVO>, Object>>(costCenterService.selectCostCenterAvl(requestPayload)));
    }

    @PostMapping("/selectHighCostCenterDeptList")
    public ResponseEntity<String> selectHighCostCenterDeptList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectHighCostCenterDeptList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<CostCenterVO>>(){});

        return super.composePayload(new Payload<JsonObject<List<CostCenterVO>, Object>>(costCenterService.selectHighCostCenterDeptList(requestPayload)));
    }

    // excel 엑셀

    // 코스트센터 엑셀 다운로드
    @PostMapping("/selectExcelDwnlCostCenterList")
    public ResponseEntity<String> selectExcelDwnlCostCenterList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectExcelDwnlCostCenterList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<CostCenterVO>>(){});

        return super.composePayload(new Payload<List>(costCenterService.selectExcelDwnlCostCenterList(requestPayload)));
    }

    // 코스트센터 변경이력 엑셀 다운로드
    @PostMapping("/selectExcelDwnlCostCenterHistoryList")
    public ResponseEntity<String> selectExcelDwnlCostCenterHistoryList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectExcelDwnlCostCenterHistoryList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<CostCenterVO>>(){});

        return super.composePayload(new Payload<List>(costCenterService.selectExcelDwnlCostCenterHistoryList(requestPayload)));
    }

}
