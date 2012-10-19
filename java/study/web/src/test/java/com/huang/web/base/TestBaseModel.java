package com.huang.web.base;

public class TestBaseModel extends BaseModel<String> {
	public static void main(String[] args) {
		TestBaseModel t = new TestBaseModel();
		System.out.print(t.getEntityClassName());
	}
}
