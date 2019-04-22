/** 
 * Project Name:springcloud-consul-consumer 
 * File Name:ProducerRemote.java 
 * Package Name:com.liu.consul.remote 
 * Date:2019年4月22日下午2:47:47 
 * Copyright (c) 2019, chenzhou1025@126.com All Rights Reserved. 
 * 
*/  
  
package com.liu.consul.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/** 
 * ClassName:ProducerRemote <br/> 
 * Function: TODO 调用生产者服务. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2019年4月22日 下午2:47:47 <br/> 
 * @author   lgf 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
//	@Service
@FeignClient("consul-producer")
public interface ProducerRemote {
        
	   
	    /**
	     * 
	     * producer:fegin客户端调用. <br/> 
	     * TODO //当使用feign传参数的时候,需要加上@RequestParam注解,否则对方服务无法识别参数;.<br/> 
	     * TODO卡半天.<br/> 
	     * 
	     * @author user 
	     * @param name
	     * @return 
	     * @since JDK 1.7
	     */
	    @GetMapping("/producer")
	    String producer(@RequestParam("name")String name);
}
  