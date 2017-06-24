package com.vishal.interviews.programcreek.combinationsandpermutations;

import java.util.*;

public class PermutationSequence {

	public static void main(String[] args) {

		System.out.println(getPermutation(1,1));
	}

	public static String getPermutation(int n, int k) {

		if (n == 0) {
			return "";
		}

		k--;
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}

		int factorial = 1;
		for (int i = 1; i <= n; i++) {
			factorial *= i;
		}

		// n = 4,factorial = 24
		StringBuilder res = new StringBuilder();

		for (int i = 0; i < n; i++) {

			factorial = factorial / (n - i); // i ==0, factorial = 6

			int index = k / factorial;
			
			res.append(list.get(index));
			list.remove(index);

			k = k % factorial;
		}

		return res.toString();
	}

}
