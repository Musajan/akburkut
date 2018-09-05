package com.akburkut.tv.cms.akburkut.proxydemo.dynamic;

import com.akburkut.tv.cms.akburkut.proxydemo.pattern.RealSubject;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: Sherlock
 * @Description: aspectj
 * @Date: Created in 14:34 2018/9/5
 * @Modified By:
 */
@Slf4j
public class JdkProxySubject implements InvocationHandler {

    private RealSubject realSubject;

    public JdkProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        log.info("before...");
        Object result = null;
        try {
            result = method.invoke(realSubject, args);
        } catch (Exception e) {
            log.info("Exception: " + e.getMessage());
            throw e;
        } finally {
            log.info("after...");
        }
        return result;
    }
}
