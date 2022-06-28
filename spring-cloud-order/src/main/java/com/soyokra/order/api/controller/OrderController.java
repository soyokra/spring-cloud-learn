package com.soyokra.order.api.controller.open;

import com.soyokra.kernel.support.lib.StdResponse;
import com.soyokra.order.api.controller.open.response.OrderResponse;
import com.soyokra.order.domain.model.OrderModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api/open")
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
