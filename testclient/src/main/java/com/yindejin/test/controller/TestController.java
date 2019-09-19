package com.yindejin.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: YDJ
 * @Date: 2019/9/19
 * @Description:
 */
@RestController
public class TestController {

    @Autowired
    private ServiceFeignClient serviceFeignClient;

    @RequestMapping("/call")
    public String call() {
        return serviceFeignClient.hello();
    }

}
