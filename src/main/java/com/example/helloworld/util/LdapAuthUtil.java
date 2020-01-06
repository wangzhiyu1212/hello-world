package com.example.helloworld.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class LdapAuthUtil {


	private final static Logger logger = LoggerFactory.getLogger(LdapAuthUtil.class);

	public final static String INITIAL_CONTEXT_FACTORY = "com.sun.jndi.ldap.LdapCtxFactory";
	public final static String SECURITY_AUTHENTICATION = "simple";// "none","simple","strong"

	private static String url;
	private static String ldapDomainName;

	public static void init(String url, String ldapDomainName) {
		LdapAuthUtil.url = url;
		LdapAuthUtil.ldapDomainName = ldapDomainName;
	}

	public static boolean verifyUser(String username, String password) {
		Properties env = new Properties();
		env.put(Context.SECURITY_PRINCIPAL, username + ldapDomainName);
		env.put(Context.SECURITY_CREDENTIALS, password);
		env.put(Context.PROVIDER_URL, url);
		env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
		env.put(Context.SECURITY_AUTHENTICATION, SECURITY_AUTHENTICATION);
		try {
			LdapContext ctx = new InitialLdapContext(env, null);
			logger.info("User verify success:" + username);
			ctx.close();
			return true;
		} catch (AuthenticationException e) {
			logger.info("User verify fail:" + username);
			return false;
		} catch (NamingException e) {
			e.printStackTrace();
			logger.error("Problem searching directory: " + e);
		}
		return false;
	}

	public static Map<String, Object> getLadpUserListByCode(String syscode, String lasttime) {
		Properties env = new Properties();
		Map<String, Object> map = new HashMap<String, Object>();
		env.put(Context.SECURITY_PRINCIPAL, "apptest");
		env.put(Context.SECURITY_CREDENTIALS, "Test@1234");
		env.put(Context.PROVIDER_URL, url);
		env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
		env.put(Context.SECURITY_AUTHENTICATION, SECURITY_AUTHENTICATION);
		try {
			int totalResults = 0;
			LdapContext ctx = new InitialLdapContext(env, null);
			SearchControls searchCtls = new SearchControls();
			searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
			String searchFilter = "";
			if (StringUtils.isNotBlank(lasttime)) {
				searchFilter = "(&(objectCategory=person)(objectClass=user)(name=*)(whenChanged>=" + lasttime + "))";
			} else {
				searchFilter = "(&(objectCategory=person)(objectClass=user)(name=*))";
			}
//			String searchBase = "OU=" + syscode + ",DC=cn,DC=intranet";
//			String returnedAtts[] = { "memberOf", "userAccountControl", "userPrincipalName" };
			String searchBase = "";
			String returnedAtts[] = { "displayName", "userPrincipalName", "department", "description", "mail" };
			searchCtls.setReturningAttributes(returnedAtts);
			NamingEnumeration<SearchResult> answer = ctx.search(searchBase, searchFilter, searchCtls);
			while (answer.hasMoreElements()) {
				SearchResult sr = (SearchResult) answer.next();

				String attrValue = null;
				String userAccountControl = null;
				String userPrincipalName = null;
				Attributes Attrs = sr.getAttributes();
				if (Attrs != null) {
					try {
						for (NamingEnumeration ne = Attrs.getAll(); ne.hasMore();) {
							Attribute Attr = (Attribute) ne.next();// 得到下一个属性
							// 读取属性值
							for (NamingEnumeration e = Attr.getAll(); e.hasMore(); totalResults++) {
								attrValue = e.next().toString();
								if ("userAccountControl".equals(Attr.getID().toString())) {
									userAccountControl = attrValue;
								}
								if ("userPrincipalName".equals(Attr.getID().toString())) {
									userPrincipalName = attrValue;
								}
							}
						}
					} catch (NamingException e) {
						e.printStackTrace();
						logger.error("Throw Exception : " + e);
					}
				}
				if (!StringUtils.isEmpty(userPrincipalName)) {
					String domainName = userPrincipalName.split("@")[0];
					if ("514".equals(userAccountControl)) {
						map.put(domainName, false);// 0表示无权限
					} else {
						map.put(domainName, true);// 1表示有权限
					}
				}
			}
			ctx.close();
		} catch (AuthenticationException e) {
			logger.error(e.toString());
		} catch (NamingException e) {
			e.printStackTrace();
			logger.error("Problem searching directory: " + e);
		}
		return map;
	}
}
