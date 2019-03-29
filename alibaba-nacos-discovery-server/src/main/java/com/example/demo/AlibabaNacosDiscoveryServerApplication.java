package com.example.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;



/**
 * @author liuguofei
 * @time 2019年3月28日下午4:03:50
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AlibabaNacosDiscoveryServerApplication {
	
	private static Log log = LogFactory.getLog(AlibabaNacosDiscoveryServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AlibabaNacosDiscoveryServerApplication.class, args);
	}
	
	
	@RestController
    static class TestController {
        @GetMapping("/hello")
        @SentinelResource("hello")
        public String hello(@RequestParam String name) {
            log.info("invoked name = " + name);
            return "hello " + name;
        }
    }

}
