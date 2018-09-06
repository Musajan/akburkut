package com.akburkut.tv.cms.akburkut.proxydemo.chain;

/**
 * @Author: Sherlock
 * @Description:
 * @Date: Created in 10:08 2018/9/6
 * @Modified By:
 */
public abstract class ChainHandler {

    public void excute(Chain chain) {
        handleProcess();
        chain.proceed();

    }
    protected abstract void handleProcess();
}
