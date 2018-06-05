package com.vishal.java8practice.stream;

import java.util.*;
import java.util.stream.Stream;

public class StreamPractice {

	public static void main(String[] args) {
		seqStreamPractice();
		System.out.println("printing parallel now");
		parallelPractice();
	}

	static void seqStreamPractice() {

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}

		Stream<Integer> seqStream = list.stream();
		Stream<Integer> highStream = seqStream.filter(s -> s > 90);
		highStream.forEach(s -> System.out.println(s));

	}

	static void parallelPractice() {

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}

		Stream<Integer> parStream = list.parallelStream();
		Stream<Integer> highStream = parStream.filter(s -> s > 90);
		highStream.forEach(s -> System.out.println(s));

	}

}
