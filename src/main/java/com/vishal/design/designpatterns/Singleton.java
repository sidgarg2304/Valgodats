package com.vishal.design.designpatterns;

public class Singleton {

	private Singleton() {

		
	}

	private static Singleton singleton;

	public static Singleton getSingleton() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				if (singleton != null) {
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
