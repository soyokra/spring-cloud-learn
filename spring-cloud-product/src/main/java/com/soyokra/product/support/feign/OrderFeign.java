package com.soyokra.product.support.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("order")
public interface OrderFeign {
    @GetMapping("/api/select-order")
    String selectOrder();
}
