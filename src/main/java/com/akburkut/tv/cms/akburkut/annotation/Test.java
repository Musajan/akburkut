package com.akburkut.tv.cms.akburkut.annotation;

/**
 * @Author: Sherlock
 * @Description:
 * @Date: Created in 16:58 2018/7/27
 * @Modified By:
 */
public class Test {

    public static void main(String[] args) {

        Filter filter = new Filter();
        filter.setId(10);// 查询Id为10的用户

        Filter filter1 = new Filter();
        filter1.setUserName("lucy");// 模糊查询用户名为lucy的用户

        Filter filter2 = new Filter();
        filter2.setEmail("liu@sina.com, zh@163.com, 77777@qq.com");// 查询邮箱为其中任意一个

        String sq = query(filter);
        String sq1 = query(filter1);
        String sq2 = query(filter2);

        System.out.println(sq);
        System.out.println(sq1);
        System.out.println(sq2);
    }

    private static String query(Filter filter) {
        StringBuilder builder = new StringBuilder();
        //1.获取到Class
        Class c = filter.getClass();

        return null;
    }
}
