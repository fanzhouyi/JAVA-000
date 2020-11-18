package com.fzy.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Fzy
 * @version 1.0
 * @date 2020/11/18 23:46
 */
@ConfigurationProperties(prefix = "demo")
public class DemoProperties {
    private String sayWhat;
    private String toWho;

    public String getSayWhat() {
        return sayWhat;
    }

    public void setSayWhat(String sayWhat) {
        this.sayWhat = sayWhat;
    }

    public String getToWho() {
        return toWho;
    }

    public void setToWho(String toWho) {
        this.toWho = toWho;
    }
}
