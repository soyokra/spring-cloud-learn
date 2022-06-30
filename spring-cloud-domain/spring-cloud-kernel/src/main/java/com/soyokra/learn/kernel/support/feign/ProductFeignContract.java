package com.soyokra.learn.kernel.support.feign;

import com.soyokra.learn.kernel.support.feign.response.product.ProductResponse;
import com.soyokra.learn.kernel.support.utils.ResponseUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient("app-server-domain-product")
public interface ProductFeignContract {

    @GetMapping(value = "/api/select-product")
    ResponseUtils<ProductResponse> getProduct();
}
