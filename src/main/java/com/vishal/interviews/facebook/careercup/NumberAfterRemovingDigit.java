package com.vishal.interviews.facebook.careercup;

import java.util.*;

/**
 * Given n1, n2 is the number after removing one digit from n1. Example, n1 = 123, then n2 can be 12, 13 or 23. 

If we know the sum of n1 + n2, and find the possible values of n1 and n2. 
*
 */
public class NumberAfterRemovingDigit {

	public static void main(String[] args) {

	}

	public List<List<Integer>> getNumber(int sum) {

		List<List<Integer>> res = new ArrayList<>();

		return res;

	}

	void dfs(int sum, List<Integer> temp, List<List<Integer>> res) {

		if (sum == 0 && temp.size() == 2) {
			res.add(new ArrayList<>(temp));
		}

		
	}
}
