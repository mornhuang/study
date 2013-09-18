package com.kehao.utils;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.SearchControls;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

/*
 * Description: 测试LDAP
 */
public class LdapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Hashtable<String, String> HashEnv = new Hashtable<String, String>();

		String LDAP_URL = "ldap://bj-dc-01.cofco.com:389";              // 或10.6.0.25
		String fullName = "yangjr@cofco.com";							// 用户名
		String adminPassword = "您的密码";								// 请输入您的密码

		String searchFilter = "objectClass=User";
		String searchBase = "DC=cofco,DC=com" ;
		LdapContext ctx = null;

		try
		{
			HashEnv.put(Context.SECURITY_AUTHENTICATION, "simple"); 	// LDAP访问安全级别
			HashEnv.put(Context.SECURITY_PRINCIPAL, fullName); 			// AD User
			HashEnv.put(Context.SECURITY_CREDENTIALS, adminPassword); 	// AD Password
			HashEnv.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory"); 	// LDAP工厂类
			HashEnv.put(Context.PROVIDER_URL, LDAP_URL);

			// 初始化
			ctx = new InitialLdapContext(HashEnv, null);

			//Create the search controls
			SearchControls searchCtls = new SearchControls();

			//Specify the search scope
			searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);

			// 定制返回属性
			String returnedAtts[] = { "*" };

			//设置返回属性集
	    	searchCtls.setReturningAttributes(returnedAtts);

	    	// 遍历验证
	    	NamingEnumeration<?> answer = ctx.search(searchBase, searchFilter,searchCtls);
	        while (answer.hasMoreElements())
			{
				System.out.println("true");
				return;
			}
			System.out.println("false");
	    }
	    catch (Exception e)
	    {
	    	e.printStackTrace();
	    }
	    finally
	    {
		    try
			{
				if (ctx != null)
					ctx.close();
			}
			catch (Exception e1)
			{
			}
	    }
	}
}
