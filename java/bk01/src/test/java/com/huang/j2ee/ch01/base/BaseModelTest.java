package com.huang.j2ee.ch01.base;

public class BaseModelTest extends BaseModel<String> {
	public static void main(String[] args) {
		BaseModelTest t = new BaseModelTest();
		System.out.print(t.getEntityClassName());
	}
}
