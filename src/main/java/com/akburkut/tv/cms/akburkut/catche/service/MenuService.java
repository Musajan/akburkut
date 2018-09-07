package com.akburkut.tv.cms.akburkut.catche.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: Sherlock
 * @Description:
 * @Date: Created in 10:40 2018/9/7
 * @Modified By:
 */
@Slf4j
@Component
public class MenuService {

    @Cacheable(cacheNames = {"menu"})
    public List<String> getMenuList() {
        log.info("");
        log.info("mock: get from db");
        return Arrays.asList("article", "comment", "admin");
    }
}
