package com.vishal.interviews.google.hard;

import java.util.*;

/**
 * 679. 24 Game
 * You have 4 cards each containing a number from 1 to 9. You need to judge whether they could operated through *, /, +, -, (, ) to get the value of 24.

Example 1:
Input: [4, 1, 8, 7]
Output: True
Explanation: (8-4) * (7-1) = 24
Example 2:
Input: [1, 2, 1, 2]
Output: False
Note:
The division operator / represents real division, not integer division. For example, 4 / (1 - 2/3) = 12.
Every operation done is between two numbers. In particular, we cannot use - as a unary operator. For example, with [1, 1, 1, 1] as input, the expression -1 - 1 - 1 - 1 is not allowed.
You cannot concatenate numbers together. For example, if the input is [1, 2, 1, 2], we cannot write this as 12 + 12.
 */
public class TwentyFourGame {

	public static void main(String[] args) {

	}
	
	public boolean judgePoint24Easy(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		List<Double> list = new ArrayList<>();
		for (int i : nums) {
			list.add((double) i);
		}
		return dfs(list);
	}

	boolean dfs(List<Double> list) {
		if (list.size() == 1) {
			if (Math.abs(list.get(0) - 24) < 0.001) {
				return true;
			}
			return false;
		}

		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				List<Double> possRes = generatePossibleResults(list.get(i), list.get(j));
				for (double r : possRes) {
					List<Double> nextRound = new ArrayList<>();
					nextRound.add(r);
					for (int k = 0; k < list.size(); k++) {
						if (k != i && k != j) {
							nextRound.add(list.get(k));
						}
					}
					if (dfs(nextRound)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	List<Double> generatePossibleResults(double a, double b) {
		List<Double> res = new ArrayList<>();
		res.add(a + b);
		res.add(a - b);
		res.add(b - a);
		res.add(a * b);
		if (b != 0) {
			res.add(a / b);
		}
		if (a != 0) {
			res.add(b / a);
		}

		return res;
	}
	
	/**
	 * Approach #1: Backtracking [Accepted]
Intuition and Algorithm

There are only 4 cards and only 4 operations that can be performed. Even when all operations do not commute, that gives us an upper bound of 12 * 6 * 2 * 4 * 4 * 4 = 921612∗6∗2∗4∗4∗4=9216 possibilities, which makes it feasible to just try them all. Specifically, we choose two numbers (with order) in 12 ways and perform one of 4 operations (12 * 4). Then, with 3 remaining numbers, we choose 2 of them and perform one of 4 operations (6 * 4). Finally we have two numbers left and make a final choice of 2 * 4 possibilities.

We will perform 3 binary operations (+, -, *, / are the operations) on either our numbers or resulting numbers. Because - and / do not commute, we must be careful to consider both a / b and b / a.

For every way to remove two numbers a, b in our list, and for each possible result they can make, like a+b, a/b, etc., we will recursively solve the problem on this smaller list of numbers.

Complexity Analysis

Time Complexity: O(1)O(1). There is a hard limit of 9216 possibilities, and we do O(1)O(1) work for each of them.

Space Complexity: O(1)O(1). Our intermediate arrays are at most 4 elements, and the number made is bounded by an O(1)O(1) factor.
	 */
	public boolean judgePoint24(int[] nums) {
      ArrayList A = new ArrayList<Double>();
      for (int v: nums) A.add((double) v);
      return solve(A);
  }
  private boolean solve(ArrayList<Double> nums) {
      if (nums.size() == 0) return false;
      if (nums.size() == 1) return Math.abs(nums.get(0) - 24) < 1e-6;

      for (int i = 0; i < nums.size(); i++) {
          for (int j = 0; j < nums.size(); j++) {
              if (i != j) {
                  ArrayList<Double> nums2 = new ArrayList<Double>();
                  for (int k = 0; k < nums.size(); k++) if (k != i && k != j) {
                      nums2.add(nums.get(k));
                  }
                  for (int k = 0; k < 4; k++) {
                      if (k < 2 && j > i) continue;
                      if (k == 0) nums2.add(nums.get(i) + nums.get(j));
                      if (k == 1) nums2.add(nums.get(i) * nums.get(j));
                      if (k == 2) nums2.add(nums.get(i) - nums.get(j));
                      if (k == 3) {
                          if (nums.get(j) != 0) {
                              nums2.add(nums.get(i) / nums.get(j));
                          } else {
                              continue;
                          }
                      }
                      if (solve(nums2)) return true;
                      nums2.remove(nums2.size() - 1);
                  }
              }
          }
      }
      return false;
  }

}
