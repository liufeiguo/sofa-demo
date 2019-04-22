package com.liu.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient//consul服务发现
@SpringBootApplication
@EnableFeignClients//启用fegin客户端必须加上
public class SpringcloudConsulConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudConsulConsumerApplication.class, args);
	}

}
