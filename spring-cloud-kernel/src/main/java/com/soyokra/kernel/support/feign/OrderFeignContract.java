package com.soyokra.kernel.support.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("app-order-server")
public interface OrderFeignContract {

}
