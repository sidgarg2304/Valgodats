package com.vishal.java8practice.annotations;

public class AnnotationsExample {

	public static void main(String[] args) {

		AnnotationsExample a = new AnnotationsExample();
		System.out.println(a);
	}

	@MethodInfo(author = "vishal", id = "123")
	public String toString(){
		return "AnnotationsExampletoString";
	}

}
