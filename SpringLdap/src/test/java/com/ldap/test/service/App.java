package com.ldap.test.service;

import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.ldap.sdk.*;
import com.unboundid.ldap.sdk.controls.SimplePagedResultsControl;

public class App {

	/**
	 * @param args
	 * @throws LDAPException
	 */
	public static void main(String[] args) throws LDAPException {

		LDAPConnection connection = new LDAPConnection("10.20.90.92", 389, "cn=Manager,dc=chinautrust,dc=com", "password12345");// "cn=admin4directory,dc=ilex-si,dc=eu",
																											// "M3d2p5a4!");

		// SearchRequest searchRequest = new SearchRequest("ou=people,dc=ilex-si,dc=eu",
		// SearchScope.SUB,"(ixuid=*)");
		SearchRequest searchRequest = new SearchRequest("dc=chinautrust,dc=com", SearchScope.BASE,
				Filter.createEqualityFilter("objectClass", "person"));

		ASN1OctetString cookie = null;
		do {
			searchRequest.setControls(new Control[] { new SimplePagedResultsControl(500, cookie) });
			SearchResult searchResult = connection.search(searchRequest);

			// Do something with the entries that are returned.

			cookie = null;
			for (Control c : searchResult.getResponseControls()) {
				if (c instanceof SimplePagedResultsControl) {
					cookie = ((SimplePagedResultsControl) c).getCookie();
					System.out.println("\ncookie = " + cookie.toString());
				}
			}
		} while ((cookie != null) && (cookie.getValueLength() > 0));

		connection.close();

	}

}