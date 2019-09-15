package com.kkh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-04-one-to-many-uni?useSSL=false"; // userSSL=false 는 warning 없이 한다
        String user = "hbstudent";
        String pass = "hbstudent";

        try {
            System.out.println("Connecting to database : " + jdbcUrl);

            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Connection successful!!!");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
