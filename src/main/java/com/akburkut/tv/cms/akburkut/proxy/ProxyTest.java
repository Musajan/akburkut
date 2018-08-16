package com.akburkut.tv.cms.akburkut.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author: Sherlock
 * @Description: 动态代理测试类
 * @Date: Created in 13:30 2018/8/16
 * @Modified By:
 */
@Slf4j
public class ProxyTest {

    public static void main(String[] args) {
        Car car = new Car();
        InvocationHandler h = new TimeHandler(car);
        Class carClass = car.getClass();
        /**
         * loader 类加载器
         * interfaces 实现接口
         * h - InvocationHandler
         */
        MoveAble moveAble = (MoveAble) Proxy.newProxyInstance(carClass.getClassLoader(),
                                                                carClass.getInterfaces(), h);
        moveAble.move();
    }
}
