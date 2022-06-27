package com.soyokra.product.api.controller;

import com.soyokra.common.support.lib.StdResponse;
import com.soyokra.product.api.controller.response.ProductResponse;
import com.soyokra.product.domain.model.ProductModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api")
@RestController
public class ProductController {
    @GetMapping(value = "select-product")
    public @ResponseBody
    StdResponse<ProductResponse> getOrder() {
        ProductModel productModel = new ProductModel();
        productModel.setProductId("bbbb");
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProduct(productModel);

        return StdResponse.success(productResponse);
    }
}
