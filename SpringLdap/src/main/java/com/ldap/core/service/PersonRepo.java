/** 
 * Project Name:SpringLdap 
 * File Name:PersonRepo.java 
 * Package Name:com.ldap.core.service 
 * Date:2019年4月11日上午11:47:27 
 * Copyright (c) 2019, chenzhou1025@126.com All Rights Reserved. 
 * 
*/  
  
package com.ldap.core.service;

import java.util.List;

import com.ldap.core.bean.Person;

/** 
 * ClassName:PersonRepo <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2019年4月11日 上午11:47:27 <br/> 
 * @author   user 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public interface PersonRepo {

	List<String> getAllPersonNames();

	List<Person> getAllPersons();

	Person findPerson(String dn);

	List<String> getPersonNamesByLastName(String lastName);

}
  