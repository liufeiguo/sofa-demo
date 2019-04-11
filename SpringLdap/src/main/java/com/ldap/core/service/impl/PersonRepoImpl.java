package com.ldap.core.service.impl;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

import java.util.List;

import javax.naming.Name;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.stereotype.Service;

import com.ldap.core.bean.Person;
import com.ldap.core.service.PersonRepo;

@Service
public class PersonRepoImpl implements PersonRepo {

	public static final String BASE_DN = "ou";

	@Autowired
	private LdapTemplate ldapTemplate;

	public void setLdapTemplate(LdapTemplate ldapTemplate) {
		this.ldapTemplate = ldapTemplate;
	}

	@Override
	public List<String> getAllPersonNames() {
		return ldapTemplate.search(query().where("objectclass").is("person"), new AttributesMapper<String>() {
			public String mapFromAttributes(Attributes attrs) throws NamingException {
				return attrs.get("sn").get().toString();
			}
		});
	}

	private class PersonAttributesMapper implements AttributesMapper<Person> {
		public Person mapFromAttributes(Attributes attrs) throws NamingException {
			Person person = new Person();
			person.setFullName((String) attrs.get("cn").get());
			person.setLastName((String) attrs.get("sn").get());
			person.setDescription((String) attrs.get("description").get());
			return person;
		}
	}

	@Override
	public List<Person> getAllPersons() {
		return ldapTemplate.search(query().where("objectclass").is("person"), new PersonAttributesMapper());
	}

	@Override
	public Person findPerson(String dn) {
		return ldapTemplate.lookup(dn, new PersonAttributesMapper());
	}

	// dc=chinautrust,dc=com
	@Override
	public List<String> getPersonNamesByLastName(String lastName) {

		LdapQuery query = query()
				// ou=deptment,ou=utrust,dc=chinautrust,dc=com

				/**
				 * 在配置文件中写好base="${ldap.base}" 只能加下一级目录
				 */
				.base("ou=deptment").attributes("cn", "sn").where("objectclass").is("person").and("sn").is(lastName);

		return ldapTemplate.search(query, new AttributesMapper<String>() {
			public String mapFromAttributes(Attributes attrs) throws NamingException {

				return (String) attrs.get("cn").get();
			}
		});
	}

	protected Name buildDn(Person p) {
		return LdapNameBuilder.newInstance(BASE_DN).add("description", p.getDescription()).add("accountstaty", p.getAccountstaty())
				.add("bussinessCategory", p.getBussinessCategory()).build();
	}

}