package com.vishal.interviews.leetcodereremaining.medium;

import java.util.*;

/**
 * 241. Different Ways to Add Parentheses
 * 
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]
 *
 */
public class DifferentWaystoAddParentheses {

	public static void main(String[] args) {
		System.out.println(Integer.parseInt("01"));
	}

	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> res = new ArrayList<>();
		
		if(input == null){
			return res;
		}

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			if (c == '+' || c == '*' || c == '-') {
				List<Integer> left = diffWaysToCompute(input.substring(0, i));
				List<Integer> right = diffWaysToCompute(input.substring(i + 1));

				for (int l : left) {
					for (int r : right) {
						if (c == '+') {
							res.add(l + r);
						} else if (c == '-') {
							res.add(l - r);
						} else {
							res.add(l * r);
						}
					}
				}
			}
		}

		if (res.isEmpty()) {
			res.add(Integer.valueOf(input));
		}
		return res;
	}
}
