package com.fzy.spring.po;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Fzy
 * @version 1.0
 * @date 2020/11/18 23:37
 */
@Component
public class School {
    @Autowired
    Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
