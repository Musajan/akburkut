package com.akburkut.tv.cms.akburkut.concurrency.example.atomic;

import com.akburkut.tv.cms.akburkut.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Author: Sherlock
 * @Description: 并发测试-线程安全
 * @Date: Created in 14:30 2018/6/26
 * @Modified By:
 */
@Slf4j
@ThreadSafe
public class AtomicExample4 {

    private static AtomicReference<Integer> COUNT = new AtomicReference<>(0);

    public static void main(String[] args) {
        COUNT.compareAndSet(0, 2);
        COUNT.compareAndSet(0, 1);
        COUNT.compareAndSet(1, 3);
        COUNT.compareAndSet(2, 4);
        COUNT.compareAndSet(3, 5);
        log.info("count:{}", COUNT.get());
    }
}
