package com.soyokra.learn.order.api.controller;

import com.soyokra.learn.kernel.support.utils.ResponseUtils;
import com.soyokra.learn.order.api.controller.response.OrderResponse;
import com.soyokra.learn.order.domain.model.OrderModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api")
@RestController
public class OrderController {

    @GetMapping(value = "select-order")
    public @ResponseBody
    ResponseUtils<OrderResponse> getOrder() {
        OrderModel orderModel = new OrderModel();
        orderModel.setOrderId("aaaa");
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrder(orderModel);

        return ResponseUtils.success(orderResponse);
    }
}
