package com.ibiz.api.controller;

import com.google.gson.reflect.TypeToken;
import com.ibiz.api.model.CostCenterChgHisVO;
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
@RequestMapping("/hr")
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
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<CostCenterChgHisVO>>(){});

        return super.composePayload(new Payload<JsonObject<List<CostCenterChgHisVO>, Object>>(costCenterService.selectCostCenterTree(requestPayload)));
    }

    @PostMapping("/selectCostCenterHisList")
    public ResponseEntity<String> selectCostCenterHisList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectCostCenterHisList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<CostCenterChgHisVO>>(){});

        return super.composePayload(new Payload<JsonObject<List<CostCenterChgHisVO>, Object>>(costCenterService.selectCostCenterHisList(requestPayload)));
    }

    @PostMapping("/selectCostCenterlastestChgHis")
    public ResponseEntity<String> selectCostCenterlastestChgHis(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectCostCenterlastestChgHis");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<CostCenterChgHisVO>>(){});

        return super.composePayload(new Payload<JsonObject<CostCenterChgHisVO, Object>>(costCenterService.selectCostCenterlastestChgHis(requestPayload)));
    }

    @PostMapping("/selectHighCostCenterTree")
    public ResponseEntity<String> selectHighCostCenterTree(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectHighCostCenterTree");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<CostCenterChgHisVO>>(){});

        return super.composePayload(new Payload<JsonObject<List<CostCenterChgHisVO>, Object>>(costCenterService.selectHighCostCenterTree(requestPayload)));
    }

    @PostMapping("/updateCostCenter")
    public ResponseEntity<String> updateCostCenter(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateCostCenter");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<CostCenterChgHisVO>>(){});

        return super.composePayload(new Payload<JsonObject<Object, Object>>(costCenterService.updateCostCenter(requestPayload)));
    }

    @PostMapping("/deleteCostCenterHis")
    public ResponseEntity<String> deleteCostCenterHis(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".deleteCostCenterHis");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<CostCenterChgHisVO>>(){});

        return super.composePayload(new Payload<JsonObject<Object, Object>>(costCenterService.deleteCostCenterHis(requestPayload)));
    }

    @PostMapping("/selectCostCenterAvl")
    public ResponseEntity<String> selectCostCenterAvl(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectCostCenterAvl");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<CostCenterChgHisVO>>(){});

        return super.composePayload(new Payload<JsonObject<List<CostCenterChgHisVO>, Object>>(costCenterService.selectCostCenterAvl(requestPayload)));
    }

    @PostMapping("/selectHighCostCenterDeptCombo")
    public ResponseEntity<String> selectHighCostCenterDeptCombo(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectHighCostCenterDeptCombo");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<CostCenterChgHisVO>>(){});

        return super.composePayload(new Payload<JsonObject<List<CostCenterChgHisVO>, Object>>(costCenterService.selectHighCostCenterDeptCombo(requestPayload)));
    }
}
