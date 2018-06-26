package com.akburkut.tv.cms.akburkut.concurrency.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Sherlock
 * @Description: 测试控制器
 * @Date: Created in 10:28 2018/6/26
 * @Modified By:
 */
@Controller
@Slf4j
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String test() {

        log.info("---测试开始了： ");
        return "test";
    }
}
