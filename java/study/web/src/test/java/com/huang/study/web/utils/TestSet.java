package com.huang.study.web.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TestSet {
	String[] strArray = {"aaa", "bbb", "ccc"}; 
	Set<String> strSet = new HashSet<String>(Arrays.asList(strArray));    
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestSet a = new TestSet();
		if (a.strSet.contains("bbb")) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
	}

}
