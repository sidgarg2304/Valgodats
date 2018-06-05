package com.vishal.java8practice.defaultstaticmethods;

public class ImplClass implements Interface1, Interface2 {

	@Override
	public void m1() {
		System.out.println("ImplClass m1");

	}

	@Override
	public void m2() {
		System.out.println("ImplClass m2");
		Interface1.sInterface1();
	}

}
