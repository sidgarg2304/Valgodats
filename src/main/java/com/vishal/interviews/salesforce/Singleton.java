package com.vishal.interviews.salesforce;

public class Singleton {

	private Singleton() {

	}

	private static Singleton singleton;

	public static Singleton getSingleton() {
		if (singleton == null) {
			// To prevent two threads to create 2 instances while calling this
			// function at same time
			synchronized (Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}

		}

		return singleton;
	}

	public String getString() {
		return "singleton found";
	}
}
