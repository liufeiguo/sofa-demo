package com.example.demo;

import net.sf.json.JSONObject;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;





public class TestAuthenticationServiceAction {

	
	public static void main(String[] args) {
		String userUrl = "http://10.20.60.68:8080/idm/jsoninterface/userManager/addUserStrs.do";
		HttpClient httpclient = new HttpClient();
		PostMethod postMethod = new PostMethod(userUrl);
	    NameValuePair[] data1 = { new NameValuePair("userDetailInfo", "uid=tes111,cn=tes1111,userPassword=12345622,idtype=01," +
	    		"idno=411002198308351536,sex=boy,birthday=2017-12-22") };

		try {
			postMethod.setRequestBody(data1);
			postMethod.setRequestHeader("username", "user1");
			String timestamp=String.valueOf(System.currentTimeMillis());
			postMethod.setRequestHeader("timestamp", timestamp);
			postMethod.setRequestHeader("token",getToken(timestamp, "user1", "A722C63DB8EC8625AF6CF71CB8C2D939"));
			int statusCode1 = httpclient.executeMethod(postMethod);
			System.out.println(statusCode1);
			if (statusCode1 != HttpStatus.SC_OK) {
				System.out.println("Method is wrong "
						+ postMethod.getStatusLine());
			}
			String response = postMethod.getResponseBodyAsString();
			
			JSONObject json = JSONObject.fromObject(response);
			String code= json.getString("code");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		
	}
	
	
	private static String getToken(String timeStamp,String jsonUser,String loginCode){
		MD5 md5=new MD5();
		String temp=loginCode+jsonUser+timeStamp;
		String token=md5.encrypt(temp);
		return token;
	}
}
