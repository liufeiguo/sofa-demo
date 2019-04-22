/** 
 * Project Name:springcloud-consul-consumer 
 * File Name:ConsumerService.java 
 * Package Name:com.liu.consul.service 
 * Date:2019年4月22日下午2:52:56 
 * Copyright (c) 2019, chenzhou1025@126.com All Rights Reserved. 
 * 
*/  
  
package com.liu.consul.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liu.consul.remote.ProducerRemote;

/** 
 * ClassName:ConsumerService <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2019年4月22日 下午2:52:56 <br/> 
 * @author   lgf 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@Service
public class ConsumerService {

	@Autowired
	ProducerRemote producerRemote;
	
	public String consumer(String name) {
		
		return producerRemote.producer(name);
	}

	
	
	
}
  