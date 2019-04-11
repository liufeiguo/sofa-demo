/**
 * Project Name:SpringLdap
 * File Name:PersonAttributesMapper.java
 * Package Name:com.ldap.core.util
 * Date:2015-4-23下午5:07:26
 *
 */

package com.ldap.core.util;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;

import org.springframework.ldap.core.AttributesMapper;

import com.ldap.core.bean.User;

/**
 * ClassName:PersonAttributesMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015-4-23 下午5:07:26 <br/>
 * 
 * @author zhanghanlin
 * @version
 * @since JDK 1.7
 * @see
 */
public class UserAttributesMapper implements AttributesMapper<User> {

    @Override
    public User mapFromAttributes(Attributes attributes) throws NamingException {
        User user = new User();
        Attribute uid = attributes.get("uid");
        if (uid != null) {
            user.setUid(uid.get().toString());
        }
        Attribute cn = attributes.get("cn");
        if (cn != null) {
            user.setCn(cn.get().toString());
        }
        Attribute sn = attributes.get("sn");
        if (sn != null) {
            user.setSn(sn.get().toString());
        }
        Attribute mail = attributes.get("mail");
        if (mail != null) {
            user.setMail(mail.get().toString());
        }
        Attribute telephoneNumber = attributes.get("telephoneNumber");
        if (telephoneNumber != null) {
            user.setTelephoneNumber(telephoneNumber.get().toString());
        }
        Attribute description = attributes.get("description");
        if (description != null) {
            user.setDescription(description.get().toString());
        }
        return user;
    }
}