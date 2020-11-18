package com.fzy.spring.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Fzy
 * @version 1.0
 * @date 2020/11/19 0:45
 */
public class JdbcTest {
    private static DBUtil dbUtil = new DBUtil();


    public static void main(String[] args) throws Exception {

        //使用Statement

        Connection conn = null;
        Statement st = null;

        //使用PreparedStatement
        PreparedStatement pstmt = null;
        String updateSql = "update user set name = ? ,age = ? where id = 2";
        try {
            conn = dbUtil.getCon();
            conn.setAutoCommit(false);   //关闭自动提交，此句代码会自动开启事务。默认为true，自动提交。
            pstmt = conn.prepareStatement(updateSql);
            pstmt.setString(1, "wang");
            pstmt.setString(2, "25");
            pstmt.execute();
            conn.commit(); //提交
        } catch (SQLException e) {
            conn.rollback();//回滚
            e.printStackTrace();
        }finally {
            dbUtil.close(pstmt,conn);
        }

    }
}
