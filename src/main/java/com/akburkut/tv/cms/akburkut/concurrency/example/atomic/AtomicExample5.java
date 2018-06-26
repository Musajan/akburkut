package com.akburkut.tv.cms.akburkut.concurrency.example.atomic;

import com.akburkut.tv.cms.akburkut.concurrency.annoations.ThreadSafe;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;


/**
 * @Author: Sherlock
 * @Description: 并发测试-线程安全
 * @Date: Created in 14:30 2018/6/26
 * @Modified By:
 */
@Slf4j
@ThreadSafe
public class AtomicExample5 {

    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

    //@Getter
    public volatile int count = 100;

    private static AtomicExample5 example5 = new AtomicExample5();

    public static void main(String[] args) {
        if (updater.compareAndSet(example5, 100, 120)) {
            log.info("update success 1, {}", example5.count);
        }

        if (updater.compareAndSet(example5, 100, 120)) {
            log.info("update success 2, {}", example5.count);
        } else {
            log.info("update failed, {}", example5.count);
        }
    }
}
