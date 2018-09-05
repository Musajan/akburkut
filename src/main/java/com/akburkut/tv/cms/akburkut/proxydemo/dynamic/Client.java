package com.akburkut.tv.cms.akburkut.proxydemo.dynamic;

import com.akburkut.tv.cms.akburkut.proxydemo.pattern.RealSubject;
import com.akburkut.tv.cms.akburkut.proxydemo.pattern.Subject;

import java.lang.reflect.Proxy;

/**
 * @Author: Sherlock
 * @Description:
 * @Date: Created in 15:07 2018/9/5
 * @Modified By:
 */
public class Client {

    public static void main(String[] args) {

        Subject subject = (Subject) Proxy.newProxyInstance(Client.class.getClassLoader(),
                new Class[]{Subject.class}, new JdkProxySubject(new RealSubject()));
        //subject.request();
        subject.hello();
    }
}
