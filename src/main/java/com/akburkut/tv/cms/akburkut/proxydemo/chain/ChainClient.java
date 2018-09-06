package com.akburkut.tv.cms.akburkut.proxydemo.chain;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: Sherlock
 * @Description:
 * @Date: Created in 10:20 2018/9/6
 * @Modified By:
 */
@Slf4j
public class ChainClient {

    static class ChainHandlerA extends ChainHandler {
        @Override
        protected void handleProcess() {
            log.info("handle by chain A...");
        }
    }

    static class ChainHandlerB extends ChainHandler {
        @Override
        protected void handleProcess() {
            log.info("handle by chain B...");
        }
    }

    static class ChainHandlerC extends ChainHandler {
        @Override
        protected void handleProcess() {
            log.info("handle by chain C...");
        }
    }

    // 责任链，链式调用，spring的bean 加载
    public static void main(String[] args) {
        List<ChainHandler> handlers = Arrays.asList(new ChainHandlerA(),
                new ChainHandlerB(), new ChainHandlerC());
        Chain chain = new Chain(handlers);
        chain.proceed();
    }
}
