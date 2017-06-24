package com.vishal.interviews.facebook.careercup;

import java.util.*;

/**
 * /From the input array, output a subset array with numbers part of a Fibonacci series. 
// input: [4,2,8,5,20,1,40,13,23] 
// output: [2,5,1,8,13] 


 *
 */
public class FibonacciSubSet {

	public static void main(String[] args) {

		System.out.println(getFibNumbers(new int[] { 4, 2, 8, 5, 20, 1, 40, 13, 23 }));
	}

	public static List<Integer> getFibNumbers(int[] nums) {
		List<Integer> res = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		int max = nums[0];
		for (int i : nums) {
			max = Math.max(max, i);
			set.add(i);
		}

		int p = 0;
		int c = 1;
		while (c <= max) {
			if (set.contains(c)) {
				res.add(c);
				set.remove(c);
			}
			int n = c + p;
			p = c;
			c = n;

		}
		return res;
	}

}
