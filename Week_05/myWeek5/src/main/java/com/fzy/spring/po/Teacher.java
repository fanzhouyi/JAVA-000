package com.fzy.spring.po;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Fzy
 * @version 1.0
 * @date 2020/11/18 23:21
 */
@Component
@Data
public class Teacher {
    @Value("25")
    Integer age;

    @Value("王老师")
    String name;

    @Value("12000")
    Double salary;
}
