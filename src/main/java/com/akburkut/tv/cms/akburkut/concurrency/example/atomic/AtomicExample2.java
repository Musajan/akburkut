package com.akburkut.tv.cms.akburkut.concurrency.example.atomic;

import com.akburkut.tv.cms.akburkut.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: Sherlock
 * @Description: 并发测试-线程安全
 * @Date: Created in 14:30 2018/6/26
 * @Modified By:
 */
@Slf4j
@ThreadSafe
public class AtomicExample2 {

    public static int TOTAL_CLIENT = 5000;// 请求总数
    public static int TOTAL_THREAD = 200;// 同时并发执行的线程数
    public static AtomicLong COUNT = new AtomicLong(0);// 计数器基数

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();// 线程池
        final Semaphore semaphore = new Semaphore(TOTAL_THREAD);// 信号量
        final CountDownLatch countDownLatch = new CountDownLatch(TOTAL_CLIENT);// 线程池闭锁
        for (int i = 0; i < TOTAL_CLIENT; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("Exception: ", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("--count:{}", COUNT.get());
    }

    private static void add() {
        COUNT.incrementAndGet();
    }
}
