package com.akburkut.tv.cms.akburkut.proxy;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * @Author: Sherlock
 * @Description:
 * @Date: Created in 13:17 2018/8/16
 * @Modified By:
 */
@Slf4j
public class Car implements MoveAble {

    @Override
    public void move() {
        // 实现开车
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            log.info("线程睡眠出错： " + e.getMessage());
        }
    }
}
