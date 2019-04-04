package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author liuguofei
 * @time 2019年3月28日下午4:11:56
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AlibabaNacosDiscoveryClientCommonApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlibabaNacosDiscoveryClientCommonApplication.class, args);
	}
	
	    @RestController
	    static class TestController {

	        @Autowired
	        LoadBalancerClient loadBalancerClient;

	        @GetMapping("/test")
	        public String test() {
	            // 通过spring cloud common中的负载均衡接口选取服务提供节点实现接口调用
	            ServiceInstance serviceInstance = loadBalancerClient.choose("alibaba-nacos-discovery-server");
	            String url = serviceInstance.getUri() + "/hello?name=" + "didi";
	            RestTemplate restTemplate = new RestTemplate();
	            String result = restTemplate.getForObject(url, String.class);
	            return "Invoke : " + url + ", return : " + result;
	        }
	    }

}
