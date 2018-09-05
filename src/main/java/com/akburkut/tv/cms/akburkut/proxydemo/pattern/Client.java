package com.akburkut.tv.cms.akburkut.proxydemo.pattern;

/**
 * @Author: Sherlock
 * @Description:
 * @Date: Created in 14:27 2018/9/5
 * @Modified By:
 */
public class Client {

    public static void main(String[] args) {

        Subject subject = new Proxy(new RealSubject());
        subject.request();
    }
}
