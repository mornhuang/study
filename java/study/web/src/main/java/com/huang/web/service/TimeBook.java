package com.huang.web.service;

public class TimeBook implements ITimeBook {

	@Override
	public void doAudit() {
		System.out.println("进行审核！");
	}

	public void doThrow() {
		System.out.println("抛异常");
		int i = 1/0;
	}
	
	public void doCheck() {
		System.out.println("进行检查！");
	}

}
