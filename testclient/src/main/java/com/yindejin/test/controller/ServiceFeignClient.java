package com.yindejin.test.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: YDJ
 * @Date: 2019/9/19
 * @Description:
 */
@FeignClient("SERVICE-A")
public interface ServiceFeignClient {

    @RequestMapping("/hello")
    String hello();
}
