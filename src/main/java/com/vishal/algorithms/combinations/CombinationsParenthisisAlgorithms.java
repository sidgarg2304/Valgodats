package com.vishal.algorithms.combinations;

import java.util.ArrayList;
import java.util.List;

public class CombinationsParenthisisAlgorithms {

	public static void main(String[] args) {
		testValidParenthisCombinations();
		testGenerateParenthisis();
	}

	public static void testValidParenthisCombinations() {
		System.out.println(validParenthisCombinations("()())()"));
	}

	public static void testGenerateParenthisis() {
		generateParenthisis(3);
	}

	public static List<String> validParenthisCombinations(String s) {
		List<String> result = new ArrayList<>();

		validParenthisCombinations(s, "", 0, 0, result);
		return result;
	}

	private static int max = 0;

	public static void validParenthisCombinations(String left, String right, int leftCount, int maxLeftCount,
			List<String> result) {
		if (left.length() == 0) {
			if (leftCount == 0 && right.length() > 0) {
				if (maxLeftCount > max) {
					max = maxLeftCount;
				}

				if (max == maxLeftCount && !result.contains(right)) {
					result.add(right);
				}
			}
			return;
		}

		if (left.charAt(0) == '(') {
			validParenthisCombinations(left.substring(1), right + '(', leftCount + 1, maxLeftCount + 1, result);
			validParenthisCombinations(left.substring(1), right, leftCount, maxLeftCount, result);
		} else if (left.charAt(0) == ')') {
			if (leftCount > 0) {
				validParenthisCombinations(left.substring(1), right + ')', leftCount - 1, maxLeftCount, result);
			}
			validParenthisCombinations(left.substring(1), right, leftCount, maxLeftCount, result);
		} else {
			validParenthisCombinations(left.substring(1), right + left.charAt(0), leftCount, maxLeftCount, result);
		}
	}

	public static void generateParenthisis(int n) {

		List<String> result = new ArrayList<>();
		generateParenthisis("", n, n, result);
		System.out.println("parenthisis combinations of size " + n + " is " + result);
	}

	public static void generateParenthisis(String s, int numLeft, int numRight, List<String> result) {

		if (numLeft > numRight) {
			return;
		}

		if (numLeft == 0 && numRight == 0) {
			result.add(s);
			return;
		}

		if (numLeft > 0) {
			generateParenthisis(s + "(", numLeft - 1, numRight, result);
		}

		if (numRight > 0) {
			generateParenthisis(s + ")", numLeft, numRight - 1, result);
		}
	}

}
