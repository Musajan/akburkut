package com.akburkut.tv.cms.akburkut.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Sherlock
 * @Description:
 * @Date: Created in 14:29 2018/8/20
 * @Modified By:
 */
@Slf4j
public class CarTimeProxy implements MoveAble {

    private MoveAble m;

    public CarTimeProxy(MoveAble m) {
        super();
        this.m = m;
    }

    @Override
    public void move() {
        long starttime = System.currentTimeMillis();
        log.info("汽车开始行驶...");
        m.move();
        long endtime = System.currentTimeMillis();
        log.info("汽车行驶结束...汽车行驶时间：" + (endtime - starttime) + "毫秒！");
    }
}
