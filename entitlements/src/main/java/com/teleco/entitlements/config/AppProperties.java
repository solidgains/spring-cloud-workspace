package com.teleco.entitlements.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Data
@RefreshScope
@Configuration
public class AppProperties {

    @Value("${applicationProperty}")
    private String applicationProperty;

    @Value("${applicationDevProperty}")
    private String applicationDevProperty;

    @Value("${entitlementsProperty}")
    private String entitlementsProperty;

    @Value("${entitlementsDevProperty}")
    private String entitlementsDevProperty;
}
