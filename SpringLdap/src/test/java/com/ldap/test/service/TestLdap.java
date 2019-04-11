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
	
	@Test
	public void test5() {
		Person person = new Person();
		person.setFullName("123456");
		person.setDescription("sssss");
		person.setCountry("beijing");
		person.setCompany("infosec");
		
		personRepo.create(person);
	}
	
	
	
	
	
	/** 
	 * test6:删除节点. <br/> 
	 * TODO(这里描述这个方法适用条件 – 可选).<br/> 
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/> 
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/> 
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/> 
	 * 
	 * @author lgf  
	 * @since JDK 1.7 
	 */  
	@Test
	public void test6() {
		Person person = new Person();
		person.setFullName("123456");
		person.setDescription("sssss");
		person.setCountry("beijing");
		person.setCompany("infosec");
		
		personRepo.delete(person);
	}
	
	@Test
	public void test7() {
		Person person = new Person();
		person.setFullName("123456");
		person.setDescription("sssss");
		person.setCountry("beijing");
		person.setCompany("infosec");
		
		personRepo.update(person);
	}
	
	@Test
	public void test8() {
		Person person = new Person();
		person.setFullName("123456");
		person.setDescription("sssss");
		person.setCountry("beijing");
		person.setCompany("infosec");
		
		personRepo.updateDescription(person);
	}
	
	@Test
	public void test9() {
		Person person = new Person();
		person.setFullName("123456");
		person.setDescription("sssss");
		person.setCountry("beijing");
		person.setCompany("infosec");
		
		Person findByPrimaryKey = personRepo.findByPrimaryKey(person);
		
		System.out.println(findByPrimaryKey);
	}


}
  