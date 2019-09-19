package com.yindejin.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: YDJ
 * @Date: 2019/9/19
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
public class ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class);
    }
}
