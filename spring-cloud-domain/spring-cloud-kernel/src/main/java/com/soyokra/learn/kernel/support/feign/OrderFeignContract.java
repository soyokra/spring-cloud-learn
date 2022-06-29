package com.soyokra.learn.kernel.support.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("app-server-domain-order")
public interface OrderFeignContract {

}
