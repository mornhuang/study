package com.huang.study.web.base;

public class BaseModelTest extends BaseModel<String> {
	public static void main(String[] args) {
		BaseModelTest t = new BaseModelTest();
		System.out.print(t.getEntityClassName());
	}
}
