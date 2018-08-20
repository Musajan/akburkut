package com.akburkut.tv.cms.akburkut.proxy.myproxy;

/**
 * @Author: Sherlock
 * @Description:
 * @Date: Created in 15:49 2018/8/20
 * @Modified By:
 */


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * 动态代理实现思路
 * 实现功能： 通过Proxy类的newProxyInstance静态方法返回代理对象
 * 1，声明一段代码（动态产生代理）
 * 2，编译源码（JDK Compiler API），产生新的类（代理类）
 * 3，将这个类load到内存当中，产生一个新的对象（代理对象）
 * 4，return 代理对象
 */
public class Proxy {

    public static Object newProxyInstance() throws IOException {

        String str = "package com.akburkut.tv.cms.akburkut.proxy;\n" +
                "\n" +
                "import lombok.extern.slf4j.Slf4j;\n" +
                "\n" +
                "/**\n" +
                " * @Author: Sherlock\n" +
                " * @Description:\n" +
                " * @Date: Created in 14:29 2018/8/20\n" +
                " * @Modified By:\n" +
                " */\n" +
                "@Slf4j\n" +
                "public class $Proxy0 implements MoveAble {\n" +
                "\n" +
                "    private MoveAble m;\n" +
                "\n" +
                "    public CarTimeProxy(MoveAble m) {\n" +
                "        super();\n" +
                "        this.m = m;\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void move() {\n" +
                "        long starttime = System.currentTimeMillis();\n" +
                "        log.info(\"汽车开始行驶...\");\n" +
                "        m.move();\n" +
                "        long endtime = System.currentTimeMillis();\n" +
                "        log.info(\"汽车行驶结束...汽车行驶时间：\" + (endtime - starttime) + \"毫秒！\");\n" +
                "    }\n" +
                "}\n";

        String fileName = System.getProperty("user.dir")
                + "\\src\\main\\java\\com\\akburkut\\tv\\cms\\akburkut\\proxy\\myproxy\\$Proxy.java";
        File file = new File(fileName);
        FileUtils.writeStringToFile(file, str);
        Object obj = new Object();
        return obj;
    }
}
