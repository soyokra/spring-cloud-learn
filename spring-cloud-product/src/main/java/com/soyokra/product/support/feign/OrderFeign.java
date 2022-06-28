package com.soyokra.product.support.feign;

import com.soyokra.kernel.support.feign.OrderFeignContract;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("order")
public interface OrderFeign extends OrderFeignContract {
    @GetMapping("/api/select-order")
    String selectOrder();
}
