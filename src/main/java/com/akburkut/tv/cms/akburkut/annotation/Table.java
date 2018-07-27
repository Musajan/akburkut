package com.akburkut.tv.cms.akburkut.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: Sherlock
 * @Description:
 * @Date: Created in 17:07 2018/7/27
 * @Modified By:
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {

    String value();
}
