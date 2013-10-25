package com.huang.j2ee.ch00;

import java.io.InputStream;
import java.util.Properties;

public class TestProp {
	public void test() throws Exception {
		System.out.println(System.getProperty("user.dir"));
		System.out.println(this.getClass().getResource(""));

		InputStream fin = this.getClass().getResourceAsStream("/test.cfg");
		Properties props = new java.util.Properties();

		props.load(fin);
		String odaDriverClass = new String(props.getProperty("driver"));
		String odaURL = new String(props.getProperty("url"));
		String odaUser = new String(props.getProperty("username"));
		String odaPassword = new String(props.getProperty("password"));
		fin.close();

		System.out.println("driver = " + odaDriverClass);
		System.out.println("url = " + odaURL);
		System.out.println("user = " + odaUser);
		System.out.println("password = " + odaPassword);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			TestProp a = new TestProp();
			a.test();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
