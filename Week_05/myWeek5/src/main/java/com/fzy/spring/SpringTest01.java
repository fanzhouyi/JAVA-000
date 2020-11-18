package com.fzy.spring;

import com.fzy.spring.hikari.domain.MyUser;
import com.fzy.spring.hikari.service.UserService;
import com.fzy.spring.po.School;
import com.fzy.spring.po.Student;
import com.fzy.spring.po.Teacher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

/**
 * @author Fzy
 * @version 1.0
 * @date 2020/11/18 23:17
 */
public class SpringTest01 implements CommandLineRunner {


    @Resource
    UserService userService;


    public static void main(String[] args) throws Exception {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student123 = (Student) context.getBean("student1");
        Teacher teacher = (Teacher) context.getBean("teacher");
        System.out.println(teacher);
        System.out.println(student123);
        School sh = (School)context.getBean("school");
        System.out.println(sh.getTeacher());
    }

    /**
     * 第十课作业：测试JPA操作DB
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {

        //todo 使用CommandLineRunner有坑

//        //新增/修改
//        User user = new User();
//        user.setId(8L);
//        user.setName("wangwu");
//        user.setAge(11);
//        userService.saveOrUpdate(user);
//
//        //删除
//        User deleteUser = new User();
//        deleteUser.setId(4L);
//        userService.delete(deleteUser);

        //查询单条记录
        MyUser tmpUser = userService.getOne(8L);
        System.out.println(tmpUser);
    }
}
