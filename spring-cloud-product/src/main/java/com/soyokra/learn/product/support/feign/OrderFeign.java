package com.soyokra.learn.product.support.feign;

import com.soyokra.learn.kernel.support.feign.OrderFeignContract;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("app-order-server")
public interface OrderFeign extends OrderFeignContract {
    @GetMapping("/api/select-order")
    String selectOrder();
}
