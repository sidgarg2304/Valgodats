package com.vishal.interviews.salesforce;

import java.util.ArrayList;
import java.util.List;

public class GeneratePossibleValidParenthisis {

	public static void main(String[] args) {
		generateParenthisis(3);
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
