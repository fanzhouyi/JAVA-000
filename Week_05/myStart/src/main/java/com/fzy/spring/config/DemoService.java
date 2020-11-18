package com.fzy.spring.config;

import lombok.Data;

/**
 * @author Fzy
 * @version 1.0
 * @date 2020/11/19 0:09
 */
@Data
public class DemoService {
    private String sayWhat;
    private String toWho;

    public String sayHello() {
        return sayWhat + " say： " + toWho + " !";
    }

    public DemoService(String sayWhat, String toWho) {
    this.sayWhat=sayWhat;
    this.toWho=toWho;
    }
}
