package com.akburkut.tv.cms.akburkut.proxydemo.pattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Sherlock
 * @Description:
 * @Date: Created in 14:07 2018/9/5
 * @Modified By:
 */
@Slf4j
public class Proxy implements Subject{

    private RealSubject realSubject;

    public Proxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void request() {

        log.info("before...");
        try {
            realSubject.request();
        } catch (Exception e) {
            log.info("exception: " + e.getMessage());
            throw e;
        } finally {
            log.info("after...");
        }
    }

    @Override
    public void hello() {
        realSubject.hello();
    }
}
