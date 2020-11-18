package com.fzy.spring.hikari.dao;

import com.fzy.spring.hikari.domain.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Fzy
 * @version 1.0
 * @date 2020/11/19 0:37
 */
public interface UserDao extends JpaRepository<MyUser,Long> {
}
