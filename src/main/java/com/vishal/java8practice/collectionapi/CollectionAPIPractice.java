package com.vishal.java8practice.collectionapi;

import java.util.*;
import java.util.function.BiFunction;

public class CollectionAPIPractice {

	public static void main(String[] args) {
//		removeIfExample();
		splitIteratorExample();
//		mapMethodsExample();
	}

	static void removeIfExample() {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}
		
		list.removeIf(p -> p < 50);
		list.forEach((i) -> System.out.println(i));
	}

	static void splitIteratorExample() {
		System.out.println("splitIteratorExample");
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}

		Spliterator<Integer> siter = list.spliterator();
		siter.forEachRemaining((i) -> System.out.println(i));

	}

	static void mapMethodsExample() {
		System.out.println("mapMethodsExample");
		Map<Integer, Integer> map = new HashMap<>();		
		map.put(1, 100);
		map.put(2, 200);
		map.put(3, 300);

		map.replaceAll((k, v) -> v = k + v);
		System.out.println(map);
	}

}
