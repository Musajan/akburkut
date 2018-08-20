package com.akburkut.tv.cms.akburkut.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Sherlock
 * @Description:
 * @Date: Created in 14:29 2018/8/20
 * @Modified By:
 */
@Slf4j
public class CarLogProxy implements MoveAble {

    private MoveAble m;

    public CarLogProxy(MoveAble m) {
        super();
        this.m = m;
    }

    @Override
    public void move() {
        log.info("日志开始...");
        m.move();
        log.info("日志结束...");
    }
}
