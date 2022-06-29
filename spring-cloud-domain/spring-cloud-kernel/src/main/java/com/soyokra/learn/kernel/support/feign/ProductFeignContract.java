package com.soyokra.learn.kernel.support.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("app-server-domain-product")
public interface ProductFeignContract {
}
