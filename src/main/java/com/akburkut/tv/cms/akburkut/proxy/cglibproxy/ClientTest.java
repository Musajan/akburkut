package com.akburkut.tv.cms.akburkut.proxy.cglibproxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Sherlock
 * @Description:
 * @Date: Created in 15:19 2018/8/20
 * @Modified By:
 */
@Slf4j
public class ClientTest {

    public static void main(String[] args) {

        CglibProxy proxy = new CglibProxy();
        Train train = (Train) proxy.getProxy(Train.class);
        train.move();
    }
}
