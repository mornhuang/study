package com.learn.basic;

public class MyThread implements Runnable {
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
		MyThread r = new MyThread();
		new Thread(r).run();
		new Thread(r).run();
	}
}
