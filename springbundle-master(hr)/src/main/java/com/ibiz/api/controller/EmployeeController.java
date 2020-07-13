package com.ibiz.api.controller;

import com.google.gson.reflect.TypeToken;
import com.ibiz.api.model.*;
import com.ibiz.api.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hr")
public class EmployeeController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeService employeeService;

    /*@GetMapping("/healthcheck")
    public String checkState() {
        return "board-8200";
    }*/

    @PostMapping("/selectEmployeeInfo")
    public ResponseEntity<String> selectEmployeeInfo(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectDeptTree");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<EmployeeVO>>(){});

        return super.composePayload(new Payload<JsonObject<List<EmployeeVO>, Object>>(employeeService.selectEmployeeInfo(requestPayload)));
    }

    @PostMapping("/updateHRIfInfo")
    public ResponseEntity<String> updateHRIfInfo(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateHRIfInfo");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<EmployeeVO>>(){});

        return super.composePayload(new Payload<JsonObject<Object, Object>>(employeeService.updateHRIfInfo(requestPayload)));
    }


    @PostMapping("/selectEmployeeSearchList")
    public ResponseEntity<String> selectEmployeeSearchList(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectEmployeeSearchList");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<EmployeeVO>>(){});

        return super.composePayload(new Payload<JsonObject<List<EmployeeVO>, Object>>(employeeService.selectEmployeeSearchList(requestPayload)));
    }

}
