package com.akburkut.tv.cms.akburkut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: Sherlock
 * @Description:
 * @Date: Created in 17:04 2018/9/5
 * @Modified By:
 */
@Controller
@RequestMapping(value = "/me")
public class TestPageController {

    @RequestMapping(value = "/hi")
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        return modelAndView;
    }
}
