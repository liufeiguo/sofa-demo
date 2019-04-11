package com.ldap.core.service.impl;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

import java.util.List;

import javax.naming.Name;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.ModificationItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.ContextMapper;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.AbstractContextMapper;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.stereotype.Service;

import com.ldap.core.bean.Person;
import com.ldap.core.service.PersonRepo;

@Service
public class PersonRepoImpl implements PersonRepo {

	//public static final String BASE_DN = "ou=deptment,ou=utrust,dc=chinautrust,dc=com";

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
		 return LdapNameBuilder.newInstance("ou=1234567,ou=deptment")
				 .add("uid","liu4")
			     .add("ou", p.getCountry())
			      //.add("uid", p.getCompany())
			      //.add("cn", p.getFullName())
			      .build();
	}
	
	protected Person buildPerson(Name dn, Attributes attrs) {
		  Person person = new Person();
		  person.setCountry(LdapUtils.getStringValue(dn, "ou"));
		  person.setCompany(LdapUtils.getStringValue(dn, "uid"));
		  //person.setFullName(LdapUtils.getStringValue(dn, "cn"));
		  // Populate rest of person object using attributes.

		  return person;
		}
	
	
	@Override
	public void create(Person p) {
	      Name dn = buildDn(p);
	      ldapTemplate.bind(dn, null, buildAttributes(p));
	   }

	   private Attributes buildAttributes(Person p) {
	      Attributes attrs = new BasicAttributes();
	      BasicAttribute ocattr = new BasicAttribute("objectclass");
	      ocattr.add("top");
	      ocattr.add("person");
	      ocattr.add("organizationalPerson");
	      ocattr.add("inetOrgPerson");
	      attrs.put(ocattr);
	      attrs.put("cn", "Some Person 111111");
	      attrs.put("sn", "Person");
	      return attrs;
	   }
         
	   @Override
	   public void delete(Person p) {
		      Name dn = buildDn(p);
		      ldapTemplate.unbind(dn);
		   }
	   
	   @Override
	   public void update(Person p) {
		      Name dn = buildDn(p);
		      ldapTemplate.rebind(dn, null, buildAttributes(p));
		   }
	   
	   @Override
	   public void updateDescription(Person p) {
		      Name dn = buildDn(p);
		      Attribute attr = new BasicAttribute("description", p.getDescription());
		      ModificationItem item = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, attr);
		      ldapTemplate.modifyAttributes(dn, new ModificationItem[] {item});
		   }
	   
	   
	   @SuppressWarnings("rawtypes")
	private static class PersonContextMapper implements ContextMapper {
		      public Object mapFromContext(Object ctx) {
		         DirContextAdapter context = (DirContextAdapter)ctx;
		         Person p = new Person();
		         p.setFullName(context.getStringAttribute("cn"));
		         p.setLastName(context.getStringAttribute("sn"));
		         p.setDescription(context.getStringAttribute("description"));
		         return p;
		      }
		   }
           
	   
	       @Override
		   public Person findByPrimaryKey(
		      Person person) {
		      Name dn = buildDn(person);
		      return (Person) ldapTemplate.lookup(dn, new PersonContextMapper1());
		   }
	       
	       //PersonContextMapper1  和PersonContextMapper作用是一样的
	       private static class PersonContextMapper1 extends AbstractContextMapper {
	    	   public Object doMapFromContext(DirContextOperations ctx) {
	    	      Person p = new Person();
	    	      DirContextAdapter context = (DirContextAdapter)ctx;
	    	      p.setFullName(context.getStringAttribute("cn"));
	    	      p.setLastName(context.getStringAttribute("sn"));
	    	      p.setDescription(context.getStringAttribute("description"));
	    	      return p;
	    	   }
	    	 }

}