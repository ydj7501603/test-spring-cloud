package com.yindejin.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: YDJ
 * @Date: 2019/9/19
 * @Description:
 */
@RestController
public class TestController {



    @RequestMapping("/hello")
    public String hello() {
        return "hello, world";
    }

}