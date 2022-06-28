package com.soyokra.learn.product.boot;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class AppConfig {
    @Value("${config.tag}")
    private String configTag;
}
