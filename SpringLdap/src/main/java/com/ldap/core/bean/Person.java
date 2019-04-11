/** 
 * Project Name:SpringLdap 
 * File Name:Person.java 
 * Package Name:com.ldap.core.bean 
 * Date:2019年4月11日下午1:01:27 
 * Copyright (c) 2019, chenzhou1025@126.com All Rights Reserved. 
 * 
*/  
  
package com.ldap.core.bean;  
/** 
 * ClassName:Person <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2019年4月11日 下午1:01:27 <br/> 
 * @author   user 
 * @version   
 * @since    JDK 1.7 
 * @see       
 */
public class Person {

	private String fullName;
	
	private String lastName;
	
	private String description;
	
	private String country;
	
	private String company;
	
	private int accountstaty;
	
	private int bussinessCategory;
	
	

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getAccountstaty() {
		return accountstaty;
	}

	public void setAccountstaty(int accountstaty) {
		this.accountstaty = accountstaty;
	}

	public int getBussinessCategory() {
		return bussinessCategory;
	}

	public void setBussinessCategory(int bussinessCategory) {
		this.bussinessCategory = bussinessCategory;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Person [fullName=" + fullName + ", lastName=" + lastName + ", description=" + description
				+ ", accountstaty=" + accountstaty + ", bussinessCategory=" + bussinessCategory + ", getAccountstaty()="
				+ getAccountstaty() + ", getBussinessCategory()=" + getBussinessCategory() + ", getFullName()="
				+ getFullName() + ", getLastName()=" + getLastName() + ", getDescription()=" + getDescription()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	
	
	

}
  