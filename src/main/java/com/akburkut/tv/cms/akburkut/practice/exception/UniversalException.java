package com.akburkut.tv.cms.akburkut.practice.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Sherlock
 * @Description:
 * @Date: Created in 13:26 2018/7/26
 * @Modified By:
 */
@ControllerAdvice
 class UniversalException {

      public static final String DEFAULT_ERROR_VIEW = "error";

      @ExceptionHandler
      public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception exception) throws Exception {

          ModelAndView modelAndView = new ModelAndView();
          modelAndView.addObject("exception", exception);
          modelAndView.addObject("url", request.getRequestURL());
          modelAndView.setViewName(DEFAULT_ERROR_VIEW);

          return modelAndView;
      }
}
