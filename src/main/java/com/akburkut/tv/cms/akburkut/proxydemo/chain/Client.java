package com.akburkut.tv.cms.akburkut.proxydemo.chain;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Sherlock
 * @Description:
 * @Date: Created in 9:54 2018/9/6
 * @Modified By:
 */
@Slf4j
public class Client {

    static class HandlerA extends Handler {
        @Override
        protected void handleProcess() {
            log.info("handle by A.....");
        }
    }

    static class HandlerB extends Handler {
        @Override
        protected void handleProcess() {
            log.info("handle by B.....");
        }
    }

    static class HandlerC extends Handler {
        @Override
        protected void handleProcess() {
            log.info("handle by C.....");
        }
    }

    public static void main(String[] args) {
        Handler handlerA = new HandlerA();
        Handler handlerB = new HandlerB();
        Handler handlerC = new HandlerC();

        handlerA.setSucessor(handlerB);
        handlerB.setSucessor(handlerC);

        handlerA.execute();
    }
}
