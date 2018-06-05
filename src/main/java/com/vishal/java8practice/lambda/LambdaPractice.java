package com.vishal.java8practice.lambda;

import java.util.Arrays;

public class LambdaPractice {

	public static void main(String[] args) {
		lambdaExample1();
		lambdaExample2();
		lambdaExample3();
	}

	public static void lambdaExample1() {
		String[] arr = new String[] { "ace", "axf", "abc", "bxf" };
		Arrays.sort(arr, (a, b) -> a.compareTo(b));
		System.out.println(Arrays.toString(arr));
	}

	
	public static void lambdaExample2() {
		
		System.out.println("starting a thread from main " + Thread.currentThread().getName());
		Runnable r = () -> System.out.println("running run method " + Thread.currentThread().getName());
		Thread t = new Thread(r);
		t.start();
	}
	
	public static void lambdaExample3() {
		FuncInterface f = new FuncInterface(){
			public void m1(){
				System.out.println("inner f m1");
			}
		};
		f.m1();
		
		FuncInterface f1 = () -> System.out.println("inner lambda m1");
		f1.m1();
	}
}
