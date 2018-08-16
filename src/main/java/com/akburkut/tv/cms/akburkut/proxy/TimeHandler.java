package com.akburkut.tv.cms.akburkut.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: Sherlock
 * @Description:
 * @Date: Created in 11:10 2018/8/16
 * @Modified By:
 */
@Slf4j
public class TimeHandler implements InvocationHandler {

    private Object target;

    public TimeHandler(Object target) {
        super();
        this.target = target;
    }

    /**
     *
     * @param proxy  被代理对象
     * @param method 被代理对象的方法
     * @param args  方法的参数
     * @return Object 方法的返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long starttime = System.currentTimeMillis();
        log.info("汽车开始行驶...");
        method.invoke(target);
        long endtime = System.currentTimeMillis();
        log.info("汽车行驶结束...汽车行驶时间：" + (endtime - starttime) + "毫秒！");
        return null;
    }
}
