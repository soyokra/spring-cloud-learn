package com.soyokra.order.api.controller;

import com.soyokra.common.support.lib.StdResponse;
import com.soyokra.order.api.controller.response.OrderResponse;
import com.soyokra.order.api.domain.model.OrderModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api")
@RestController
public class OrderController {

    @GetMapping(value = "select-order")
    public @ResponseBody
    StdResponse<OrderResponse> getOrder() {
        OrderModel orderModel = new OrderModel();
        orderModel.setOrderId("aaaa");
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrder(orderModel);

        return StdResponse.success(orderResponse);
    }
}
