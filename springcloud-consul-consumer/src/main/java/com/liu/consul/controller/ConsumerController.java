/** 
 * Project Name:springcloud-consul-consumer 
 * File Name:ConsumerController.java 
 * Package Name:com.liu.consul 
 * Date:2019年4月22日下午2:45:32 
 * Copyright (c) 2019, chenzhou1025@126.com All Rights Reserved. 
 * 
*/

package com.liu.consul.controller;
/** 
 * ClassName:ConsumerController <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2019年4月22日 下午2:45:32 <br/> 
 * @author   lgf 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.liu.consul.service.ConsumerService;

/**
 * 消费者
 */
@RestController
public class ConsumerController {

	@Autowired
	private ConsumerService consumerService;

	@GetMapping("/consumer")
	public String getProducer(@RequestParam("name") String name) {

		return consumerService.consumer(name);
	}
}
