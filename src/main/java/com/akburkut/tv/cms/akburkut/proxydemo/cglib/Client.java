package com.akburkut.tv.cms.akburkut.proxydemo.cglib;

import com.akburkut.tv.cms.akburkut.proxydemo.pattern.RealSubject;
import com.akburkut.tv.cms.akburkut.proxydemo.pattern.Subject;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;

/**
 * @Author: Sherlock
 * @Description:
 * @Date: Created in 22:53 2018/9/5
 * @Modified By:
 */
@Slf4j
public class Client {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new DemoMethodInterceptor());
        Subject subject = (Subject) enhancer.create();
        subject.hello();

    }
}
