package com.akburkut.tv.cms.akburkut.proxydemo.chain;

/**
 * @Author: Sherlock
 * @Description:
 * @Date: Created in 8:54 2018/9/6
 * @Modified By:
 */
public abstract class Handler {

    private Handler sucessor;

    public Handler getSucessor() {
        return sucessor;
    }

    public void setSucessor(Handler sucessor) {
        this.sucessor = sucessor;
    }

    public void execute() {
        handleProcess();
        if (sucessor != null) {
            sucessor.execute();
        }
    }

    protected abstract void handleProcess();
}
