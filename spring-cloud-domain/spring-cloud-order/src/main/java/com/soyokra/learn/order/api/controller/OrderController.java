package com.soyokra.learn.order.api.controller;

import com.soyokra.learn.kernel.support.feign.ProductFeignContract;
import com.soyokra.learn.kernel.support.feign.response.order.OrderResponse;
import com.soyokra.learn.kernel.support.feign.response.product.ProductResponse;
import com.soyokra.learn.kernel.support.utils.ResponseUtils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping(value = "/api")
@RestController
public class OrderController {

    @Resource
    ProductFeignContract productFeignContract;

    @GetMapping(value = "select-product")
    public @ResponseBody
    ResponseUtils<ProductResponse> selectProduct() {
        ResponseUtils<ProductResponse> result = productFeignContract.getProduct();
        return ResponseUtils.success(result.getData());
    }


    @GetMapping(value = "select-order")
    public @ResponseBody
    ResponseUtils<OrderResponse> selectOrder() {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderId("this is order id");
        return ResponseUtils.success(orderResponse);
    }
}
