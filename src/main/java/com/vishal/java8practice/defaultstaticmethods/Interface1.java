package com.vishal.java8practice.defaultstaticmethods;

public interface Interface1 {

	public void m1();

	default void m2() {
		System.out.println("m2 from Interface1");
	}
	
	default void mInterface1() {
		System.out.println("m2 from Interface1");
	}

	
	static void sInterface1(){
		System.out.println("s from Interface1");
	}
}
