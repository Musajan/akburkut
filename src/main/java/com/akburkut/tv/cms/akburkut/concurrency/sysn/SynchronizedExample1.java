package com.akburkut.tv.cms.akburkut.concurrency.sysn;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Sherlock
 * @Description:
 * @Date: Created in 9:15 2018/8/3
 * @Modified By:
 */
@Slf4j
public class SynchronizedExample1 {

    public void test1(int j) {
        // 修饰代码块
        synchronized (this) {
            // 同步语句块
            for (int i = 0; i < 10; i++) {
                log.info("test1 - {} - {}", j, i);
            }
        }
    }

    // 修饰一个方法-同步方法
    public synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2 - {} - {}", j, i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 synchronizedExample1 = new SynchronizedExample1();
        SynchronizedExample1 synchronizedExample2 = new SynchronizedExample1();
        // 线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 开启一个进程来执行方法
        executorService.execute(() -> {
            synchronizedExample1.test2(1);
        });
        // 为了验证是否同步执行，再开启一个线程
        executorService.execute(() -> {
            synchronizedExample2.test2(2);
        });
    }
}
