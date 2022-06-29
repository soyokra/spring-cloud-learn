package com.soyokra.learn.product.boot;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Data
@Component
public class AppConfig {
    @Value("${app.tags}")
    private String appTags;
}
