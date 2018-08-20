package com.akburkut.tv.cms.akburkut.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Sherlock
 * @Description:
 * @Date: Created in 14:12 2018/8/20
 * @Modified By:
 */
@Slf4j
public class Client {

    /*public static void main(String[] args) {

        //Car car = new Car();
        //car.move();

        //聚合的方式
        Car car = new Car();
        MoveAble m = new CarTimeProxy(car);
        m.move();
    }*/

    public static void main(String[] args) {
        Car car = new Car();
        CarTimeProxy timeProxy = new CarTimeProxy(car);
        CarLogProxy logProxy = new CarLogProxy(timeProxy);
        logProxy.move();
    }
}
