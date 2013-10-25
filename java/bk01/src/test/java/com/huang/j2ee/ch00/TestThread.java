package com.huang.j2ee.ch00;

public class TestThread implements Runnable {
	private int x;
	private int y;
	
	@Override
	public void run() {
		while (true) {
			x++;
			y++;
			System.out.println("x=" + x + ", y=" + y);
		}
	}
	
	public static void main(String[] args) {
		TestThread r = new TestThread();
		new Thread(r).run();
		new Thread(r).run();
	}
}
