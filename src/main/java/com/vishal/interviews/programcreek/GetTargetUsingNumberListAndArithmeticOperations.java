package com.vishal.interviews.programcreek;

import java.util.*;

/**
 * Given a list of numbers and a target number, write a program to determine
 * whether the target number can be calculated by applying "+ - * /" operations
 * to the number list? You can assume () is automatically added when necessary.
 * 
 * For example, given {1,2,3,4} and 21, return true. Because (1+2)*(3+4)=21
 *
 */
public class GetTargetUsingNumberListAndArithmeticOperations {

	public static void main(String[] args) {

	}

	public static boolean isReachable(List<Integer> list, int target) {

		List<Integer> results = getCombinations(list, 0, list.size() - 1);
		for (int i : results) {
			if (i == target) {
				return true;
			}
		}

		return false;
	}

	static List<Integer> getCombinations(List<Integer> list, int i, int j) {
		List<Integer> res = new ArrayList<>();

		if (i > j) {
			return res;
		}
		if (i == j) {
			res.add(list.get(i));
			return res;
		}

		for (int m = i; m < j; m++) {
			List<Integer> left = getCombinations(list, i, m);
			List<Integer> right = getCombinations(list, m + 1, j);

			for (int p : left) {
				for (int q : right) {
					res.add(p + q);
					res.add(p - q);
					res.add(p * q);
					if (q != 0) {
						res.add(p / q);
					}
				}
			}
		}

		return res;
	}

}
