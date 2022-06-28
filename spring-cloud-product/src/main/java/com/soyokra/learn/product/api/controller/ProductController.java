package com.soyokra.learn.product.api.controller;

import com.soyokra.learn.kernel.support.utils.ResponseUtils;
import com.soyokra.learn.product.api.controller.response.ProductResponse;
import com.soyokra.learn.product.boot.AppConfig;
import com.soyokra.learn.product.domain.model.ProductModel;
import com.soyokra.learn.product.support.feign.OrderFeign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RequestMapping(value = "/api")
@RestController
public class ProductController {

    @Resource
    private OrderFeign orderFeign;

    @Resource
    private AppConfig appConfig;

    @GetMapping(value = "select-product")
    public @ResponseBody
    ResponseUtils<ProductResponse> getOrder() {


        ProductModel productModel = new ProductModel();
        productModel.setProductId(appConfig.getConfigTag());
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProduct(productModel);

        return ResponseUtils.success(productResponse);
    }
}
