package com.akburkut.tv.cms.akburkut.concurrency.example.atomic;

import com.akburkut.tv.cms.akburkut.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;


/**
 * @Author: Sherlock
 * @Description: 并发测试-线程安全
 * @Date: Created in 14:30 2018/6/26
 * @Modified By:
 */
@Slf4j
@ThreadSafe
public class AtomicExample6 {

    private static AtomicBoolean isHappend = new AtomicBoolean(false);
    public static int TOTAL_CLIENT = 5000;// 请求总数
    public static int TOTAL_THREAD = 200;// 同时并发执行的线程数

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();// 线程池
        final Semaphore semaphore = new Semaphore(TOTAL_THREAD);// 信号量
        final CountDownLatch countDownLatch = new CountDownLatch(TOTAL_CLIENT);// 线程池闭锁
        for (int i = 0; i < TOTAL_CLIENT; i++) {
            int aa = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    test(aa);
                    semaphore.release();
                } catch (Exception e) {
                    log.error("Exception: ", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("--isHappend:{}", isHappend.get());
    }

    private static void test(int i) {
        if (isHappend.compareAndSet(false, true)) {
            log.info("--excute***: " + i);
        } else {
            log.info("---nonstandart-----------: " + i);
        }
    }
}
