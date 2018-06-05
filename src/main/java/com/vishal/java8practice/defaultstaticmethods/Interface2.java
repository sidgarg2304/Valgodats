package com.vishal.java8practice.defaultstaticmethods;

public interface Interface2 {

	public void m1();

	default void m2() {
		System.out.println("m2 from Interface1");
	}
	
	default void mInterface2() {
		System.out.println("m2 from Interface1");
	}


}
