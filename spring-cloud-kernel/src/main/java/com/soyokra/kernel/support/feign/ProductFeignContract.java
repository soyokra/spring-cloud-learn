package com.soyokra.kernel.support.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("app-product-server")
public interface ProductFeignContract {
}
