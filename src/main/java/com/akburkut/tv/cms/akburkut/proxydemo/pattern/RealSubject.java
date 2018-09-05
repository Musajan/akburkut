package com.akburkut.tv.cms.akburkut.proxydemo.pattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Sherlock
 * @Description:
 * @Date: Created in 13:50 2018/9/5
 * @Modified By:
 */
@Slf4j
public class RealSubject implements Subject{
    @Override
    public void request() {
        log.info("real subject excute request");
    }

    @Override
    public void hello() {
        log.info("hello world, this is me!!!!");
    }
}
