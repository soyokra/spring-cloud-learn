package com.soyokra.learn.order.api.controller;

import com.soyokra.learn.kernel.support.utils.ResponseUtils;
import com.soyokra.learn.order.api.controller.response.home.InfoResponse;
import com.soyokra.learn.order.boot.AppConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping(value = "/api")
@RestController
public class HomeController {

    @Resource
    private AppConfig appConfig;

    @GetMapping(value = "info")
    public @ResponseBody
    ResponseUtils<InfoResponse> info() {
        InfoResponse infoResponse = new InfoResponse();
        infoResponse.setAppTags(appConfig.getAppTags());
        return ResponseUtils.success(infoResponse);
    }
}
