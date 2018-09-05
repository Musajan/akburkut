package com.akburkut.tv.cms.akburkut.proxydemo.cglib;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: Sherlock
 * @Description:
 * @Date: Created in 22:45 2018/9/5
 * @Modified By:
 */
@Slf4j
public class DemoMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.info("before in cglib...");
        Object result = null;
        try {
            result = methodProxy.invokeSuper(o, objects);
        } catch (Exception e) {
            log.info("Exception: " + e.getMessage());
            throw e;
        } finally {
            log.info("after in cglib....");
        }
        return null;
    }
}
