package com.ibiz.api.controller;

import com.google.gson.reflect.TypeToken;
import com.ibiz.api.model.DeptChgHisVO;
import com.ibiz.api.model.JsonObject;
import com.ibiz.api.model.Payload;
import com.ibiz.api.model.UserBaseInfoVO;
import com.ibiz.api.service.DeptChgHisService;
import com.ibiz.api.service.UserBaseInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hr")
public class UserBaseInfoController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(CostCenterController.class);
    @Autowired
    private UserBaseInfoService userBaseInfoService;

    /*@GetMapping("/healthcheck")
    public String checkState() {
        return "board-8200";
    }*/

    @PostMapping("/selectUserBaseInfo")
    public ResponseEntity<String> selectUserBaseInfo(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".selectDeptTree");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<UserBaseInfoVO>>(){});

        return super.composePayload(new Payload<JsonObject<List<UserBaseInfoVO>, Object>>(userBaseInfoService.selectUserBaseInfo(requestPayload)));
    }

    @PostMapping("/updateHRIfInfo")
    public ResponseEntity<String> updateHRIfInfo(@RequestParam("payload") String payload) throws Exception {
        log.info("Call Controller : " + this.getClass().getName() + ".updateHRIfInfo");
        Payload requestPayload = super.parsePayload(payload, new TypeToken<Payload<UserBaseInfoVO>>(){});

        return super.composePayload(new Payload<JsonObject<Object, Object>>(userBaseInfoService.updateHRIfInfo(requestPayload)));
    }
}
