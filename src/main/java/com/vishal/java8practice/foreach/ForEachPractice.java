package com.vishal.java8practice.foreach;

import java.util.*;
import java.util.function.Consumer;

public class ForEachPractice {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			list.add(i);
		}
		forEachExampleDirect(list);

		forEachExampleInnerLambda(list);

		forEachExampleInner(list);

	}

	static void forEachExampleDirect(List<Integer> list) {

		MyConsumer cons = new MyConsumer();
		list.forEach(cons);
	}

	static void forEachExampleInnerLambda(List<Integer> list) {

		list.forEach((p) -> System.out.println("Logic what we want to do for each list element " + p));
	}

	static void forEachExampleInner(List<Integer> list) {
		list.forEach(new Consumer<Integer>() {
			public void accept(Integer t) {
				System.out.println("Logic what we want to do for each list element " + t);
			}
		});
	}

}

class MyConsumer implements Consumer<Integer> {

	@Override
	public void accept(Integer t) {
		System.out.println("Logic what we want to do for each list element " + t);

	}

}
