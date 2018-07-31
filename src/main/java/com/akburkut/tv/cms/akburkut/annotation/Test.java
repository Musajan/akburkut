package com.akburkut.tv.cms.akburkut.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
        // 1.获取到Class
        Class c = filter.getClass();
        // 2.获取到table的名字
        boolean exists = c.isAnnotationPresent(Table.class);
        if (!exists) {
            return null;
        }

        Table table = (Table) c.getAnnotation(Table.class);
        String tableName = table.value();

        builder.append("select * from ").append(tableName).append(" where 1 = 1");

        // 3.便利所有的字段
        Field[] fileds = c.getDeclaredFields();
        for (Field field : fileds) {
            // 4.处理每个字段对应的sql
            // 4.1.拿到字段的名字
            boolean fieldExists = field.isAnnotationPresent(Column.class);
            if (!fieldExists) {
                continue;
            }
            Column column = field.getAnnotation(Column.class);
            String columnName = column.value();
            // 4.2.拿到字段的值
            String filedName = field.getName();
            String getMethodName = "get" + filedName.substring(0, 1).toUpperCase()
                    + filedName.substring(1);
            Object fieldValue = null;
            try {
                Method getMathod = c.getMethod(getMethodName);
                fieldValue = getMathod.invoke(filter);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 4.3.瓶装sql
            if (fieldValue != null && fieldValue instanceof String) {
                builder.append(" and ").append(filedName);
                if (((String) fieldValue).contains(",")) {
                    String[] values = ((String) fieldValue).split(",");
                    builder.append(" in(");
                    for (String v : values) {
                        builder.append("'").append(v).append("'").append(",");
                    }
                    builder.deleteCharAt(builder.length() - 1);
                    builder.append(")");
                } else {
                    builder.append(" = ").append("'").append(fieldValue).append("'");
                }
            } else if (fieldValue instanceof Integer && (Integer)fieldValue != 0) {
                builder.append(" and ").append(filedName);
                builder.append(" = ").append(fieldValue);
            }
        }

        return builder.toString();
    }
}
