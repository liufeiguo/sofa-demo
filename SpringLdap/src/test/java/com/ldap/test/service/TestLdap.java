/** 
 * Project Name:SpringLdap 
 * File Name:TestLdap.java 
 * Package Name:com.ldap.test.service 
 * Date:2019年4月11日下午12:37:23 
 * Copyright (c) 2019, chenzhou1025@126.com All Rights Reserved. 
 * 
*/  
  
package com.ldap.test.service;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ldap.core.bean.Person;
import com.ldap.core.service.PersonRepo;


/** 
 * ClassName:TestLdap <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2019年4月11日 下午12:37:23 <br/> 
 * @author   user 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/resources/conf_spring/applicationContext*.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestLdap {
	
	Logger logger = LoggerFactory.getLogger(UserTest.class);
	
	@Autowired
    PersonRepo personRepo;
	
	@Test
	public void test1() {
		List<String> allPersonNames = personRepo.getAllPersonNames();
		
		allPersonNames.forEach(e ->System.out.println(e));
		allPersonNames.stream().forEach(System.out::println);
	}
	
	
	@Test
	public void test2() {
		 List<Person> allPersons = personRepo.getAllPersons();
		
		 allPersons.forEach(e ->System.out.println(e));
		//allPersonNames.stream().forEach(System.out::println);
	}
	
	@Test
	public void test3() {
		 Person person = personRepo.findPerson("ou=deptment");
		
		 System.out.println(person);
	}
	
	@Test
	public void test4() {
		
		List<String> allPersonNames = personRepo.getPersonNamesByLastName("liu1");
			
		allPersonNames.forEach(e ->System.out.println(e));
		//allPersonNames.stream().forEach(System.out::println);
	}

}
  