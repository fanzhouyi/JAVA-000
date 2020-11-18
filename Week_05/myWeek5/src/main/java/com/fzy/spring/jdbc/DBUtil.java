package com.fzy.spring.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author Fzy
 * @version 1.0
 * @date 2020/11/19 0:44
 */
public class DBUtil {
    //数据库地址
    private static String dbUrl="jdbc:mysql://localhost:3306/test?useSSL=true&serverTimezone=UTC";
    //用户名
    private static String dbUserName="root";
    //密码
    private static String dbPassword="hb135119";
    //驱动名称
    private static String jdbcName="com.mysql.cj.jdbc.Driver";

    /**
     * 获取数据库连接
     * 	1.加载数据库驱动
     *  2.获取数据库连接
     */
    public Connection getCon() throws Exception {

        Class.forName(jdbcName);//加载数据库驱动

        Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);

        return con;
    }

    /**
     * 关闭连接
     */
    public void close(Statement stmt, Connection con) throws Exception {
        if(stmt!=null) {
            stmt.close();
        }
        if(con!=null) {
            con.close();
        }
    }

}
