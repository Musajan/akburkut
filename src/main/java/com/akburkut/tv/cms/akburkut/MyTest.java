package com.akburkut.tv.cms.akburkut;

/**
 * @Author: Sherlock
 * @Description:
 * @Date: Created in 15:51 2018/9/7
 * @Modified By:
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 随机生成32位字符串
 */
public class MyTest {

    private static final int TEST_NUM = 2000000;

    public static void main(String[] args){

        String url= "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&amp;characterEncoding=utf-8";
        String username = "root";
        String password = "musha@1027";
        Connection conn = null;
        String sql = "insert into test_id(catelog_id,result) values(?,?)";
        PreparedStatement pst = null;
        String err_id = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            pst = conn.prepareStatement(sql);
            conn.setAutoCommit(false);
            for (int j = 0; j < TEST_NUM; j++){
                String basicStr = "abcdefghijklmnopqrstuvwxyz0123456789";
                String randomStr = "";
                for (int i = 1; i <= 16; i++ ) {
                    char randomChar = basicStr.charAt((int)(Math.random() * 36));
                    randomStr = randomStr + randomChar;
                    if (i % 4 == 0 && i / 16 != 1) {
                        randomStr = randomStr + "-";
                    }
                }
                if (j % 10000 == 0) {
                    System.out.println("--------now: " + j);
                }
                err_id = randomStr;
                pst.setString(1, randomStr);
                pst.setString(2, "成功");
                pst.execute();
                conn.commit();
            }
            pst.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("-----重复id: " + err_id);
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("结束了.......");
    }
}
