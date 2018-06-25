package com.akburkut.tv.cms.akburkut.concurrency.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: Sherlock
 * @Description: 课程里用来标记线程不安全的类或者写法
 * @Date: Created in 23:02 2018/6/25
 * @Modified By:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface NotThreadSafe {

    String value() default "";
}
