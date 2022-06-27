package com.soyokra.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringShopOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringShopOrderApplication.class, args);
    }

}
