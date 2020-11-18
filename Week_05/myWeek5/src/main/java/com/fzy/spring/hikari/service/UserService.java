package com.fzy.spring.hikari.service;

import com.fzy.spring.hikari.dao.UserDao;
import com.fzy.spring.hikari.domain.MyUser;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Fzy
 * @version 1.0
 * @date 2020/11/19 0:41
 */
public class UserService {
    @Autowired
    private UserDao userDao;

    public MyUser saveOrUpdate(MyUser myUser){
        return userDao.save(myUser);
    }

    public MyUser getOne(Long id){
        return userDao.getOne(id);
    }

    public void delete(MyUser myUser){
        userDao.delete(myUser);
    }
}
