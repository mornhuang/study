package com.huang.j2ee.ssh.utils;

public class TestString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String test = "Test.java";
		String[] t = test.split("\\.");
		for (int i = 0; i < t.length; i++) {
			System.out.println(t[i]);
		}
	}

}
