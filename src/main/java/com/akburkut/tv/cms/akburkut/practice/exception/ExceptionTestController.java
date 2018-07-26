package com.akburkut.tv.cms.akburkut.practice.exception;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Sherlock
 * @Description:
 * @Date: Created in 13:35 2018/7/26
 * @Modified By:
 */
@RestController
public class ExceptionTestController {

    @RequestMapping("/test/hello-error")
    public String error() throws Exception {

        throw new Exception("发生错误！！！！！");
    }
}
