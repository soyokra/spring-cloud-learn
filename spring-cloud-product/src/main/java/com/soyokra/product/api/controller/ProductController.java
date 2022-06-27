package com.soyokra.product.api.controller;

import com.soyokra.common.support.lib.StdResponse;
import com.soyokra.product.api.controller.response.ProductResponse;
import com.soyokra.product.domain.model.ProductModel;
import com.soyokra.product.support.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RequestMapping(value = "/api")
@RestController
public class ProductController {

    @Resource
    RestTemplate restTemplate;

    @Autowired
    private OrderFeign orderFeign;

    @GetMapping(value = "select-product")
    public @ResponseBody
    StdResponse<ProductResponse> getOrder() {

        //根据应用名称调用服务
        String json = restTemplate.getForObject("http://order/api/select-order", String.class);

        orderFeign.selectOrder();

        ProductModel productModel = new ProductModel();
        productModel.setProductId("bbbb");
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProduct(productModel);

        return StdResponse.success(productResponse);
    }
}
