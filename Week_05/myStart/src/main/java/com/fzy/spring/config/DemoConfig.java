package com.fzy.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Fzy
 * @version 1.0
 * @date 2020/11/19 0:07
 */
@Configuration
@EnableConfigurationProperties(DemoProperties.class)
@ConditionalOnProperty(prefix = "demo", name = "isopen", havingValue = "true")
public class DemoConfig {
    @Autowired
    private DemoProperties demoProperties;

    @Bean
    public DemoService demoService() {
        return new DemoService(demoProperties.getSayWhat(), demoProperties.getToWho());
    }

}
