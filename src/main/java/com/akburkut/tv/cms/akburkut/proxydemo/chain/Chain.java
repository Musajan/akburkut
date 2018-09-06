package com.akburkut.tv.cms.akburkut.proxydemo.chain;

import java.util.List;

/**
 * @Author: Sherlock
 * @Description:
 * @Date: Created in 10:07 2018/9/6
 * @Modified By:
 */
public class Chain {

    private List<ChainHandler> handlers;

    private int index = 0;

    public Chain(List<ChainHandler> handlers) {
        this.handlers = handlers;
    }

    public void proceed() {
        if (index >= handlers.size()) {
            return;
        }
        handlers.get(index++).excute(this);
    }
}
