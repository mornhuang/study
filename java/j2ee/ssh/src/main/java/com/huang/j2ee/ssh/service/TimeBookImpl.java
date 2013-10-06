package com.huang.j2ee.ssh.service;

public class TimeBookImpl implements TimeBook {

	@Override
	public void doAudit() {
		System.out.println("功能实现 -- 进行审核doAudit!");
	}

	@SuppressWarnings("unused")
	public void doThrow() {
		System.out.println("功能实现  -- 抛异常doThrow!");
		int i = 1/0;
	}

	public void doCheck() {
		System.out.println("功能实现  -- 进行检查doCheck!");
	}

}
