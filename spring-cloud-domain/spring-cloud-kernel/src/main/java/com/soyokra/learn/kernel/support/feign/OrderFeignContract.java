package com.soyokra.learn.kernel.support.feign;

import com.soyokra.learn.kernel.support.feign.response.order.OrderResponse;
import com.soyokra.learn.kernel.support.utils.ResponseUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient("app-server-domain-order")
public interface OrderFeignContract {

    @GetMapping(value = "/api/select-order")
    ResponseUtils<OrderResponse> getOrder();
}
