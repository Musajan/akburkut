package com.akburkut.tv.cms.akburkut.concurrency.sysn;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import java.util.concurrent.*;

/**
 * @Author: Sherlock
 * @Description:
 * @Date: Created in 9:15 2018/8/3
 * @Modified By:
 */
@Slf4j
public class SynchronizedExample2 {

    public static void test1(int j) {
        // 修饰类
        synchronized (SynchronizedExample2.class) {
            // 同步语句块
            for (int i = 0; i < 10; i++) {
                log.info("= {} : test1 - {} - {}", Thread.currentThread().getName(), j, i);
            }
        }
    }

    // 修饰一个静态方法-同步方法
    public static synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("={} : test2 - {} - {}", Thread.currentThread().getName(), j, i);
        }
    }

    public static void main(String[] args) {
        // 线程池
        //ExecutorService executorService = Executors.newCachedThreadPool();
        //ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1,
                //new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());
        ThreadFactory namedTheadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        //Common Thread Pool
        ExecutorService pool = new ThreadPoolExecutor(5, 200, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1024),
                namedTheadFactory, new ThreadPoolExecutor.AbortPolicy());
        // 开启一个进程来执行方法
        pool.execute(() -> {
            System.out.println(Thread.currentThread().getName());
            SynchronizedExample2.test1(1);
        });
        // 为了验证是否同步执行，再开启一个线程
        pool.execute(() -> {
            System.out.println(Thread.currentThread().getName());
            SynchronizedExample2.test1(2);
        });
        pool.shutdown();//gracefully shutdown
    }
}
