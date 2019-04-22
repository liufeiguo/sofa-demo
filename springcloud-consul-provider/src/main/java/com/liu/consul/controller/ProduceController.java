/** 
 * Project Name:springcloud-consul-provider 
 * File Name:ProduceController.java 
 * Package Name:com.liu.consul.controller 
 * Date:2019年4月22日下午2:38:02 
 * Copyright (c) 2019, chenzhou1025@126.com All Rights Reserved. 
 * 
*/  
  
package com.liu.consul.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/** 
 * ClassName:ProduceController <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2019年4月22日 下午2:38:02 <br/> 
 * @author   lgf 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@RestController
public class ProduceController {

	     @GetMapping("/producer")
	    public String producer(@RequestParam("name") String name){
	        System.out.println("I'm producer"+name);
	        return "Hello, I'm producer"+ name;
	    }
	
}
  