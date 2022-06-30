package com.soyokra.learn.product.api.controller;

import com.soyokra.learn.kernel.support.feign.OrderFeignContract;
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
public class ProductController {

    @Resource
    OrderFeignContract orderFeignContract;

    @GetMapping(value = "select-order")
    public @ResponseBody
    ResponseUtils<OrderResponse> selectOrder() {
        ResponseUtils<OrderResponse> result = orderFeignContract.getOrder();
        return ResponseUtils.success(result.getData());
    }

    @GetMapping(value = "select-product")
    public @ResponseBody
    ResponseUtils<ProductResponse> selectProduct() {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductId("this is product id");
        return ResponseUtils.success(productResponse);
    }
}
