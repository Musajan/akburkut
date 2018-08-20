package com.akburkut.tv.cms.akburkut.proxy.cglibproxy;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: Sherlock
 * @Description:
 * @Date: Created in 15:09 2018/8/20
 * @Modified By:
 */
@Slf4j
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {

        // 设置创建子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);

        return enhancer.create();
    }

    /**
     * 拦截所有目标类方法的调用
     * @param o 目标类的实例
     * @param method 目标方法的反射对象
     * @param objects 方法的参数
     * @param methodProxy proxy代理类的实例
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        // 可以添加一些业务逻辑
        log.info("开始日志处理....");
        // 代理类调用父类的方法
        methodProxy.invokeSuper(o, objects);
        log.info("日志处理结束....");
        return null;
    }
}
