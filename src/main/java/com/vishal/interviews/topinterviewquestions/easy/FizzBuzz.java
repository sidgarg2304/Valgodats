package com.vishal.interviews.topinterviewquestions.easy;

import java.util.*;

public class FizzBuzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> fizzBuzz(int n) {
		List<String> res = new ArrayList<>();

		if (n <= 0) {
			return res;
		}

		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				res.add("FizzBuzz");
			} else if (i % 3 == 0) {
				res.add("Fizz");
			} else if (i % 5 == 0) {
				res.add("Buzz");
			} else {
				res.add("" + i);
			}
		}
		return res;
	}

}
