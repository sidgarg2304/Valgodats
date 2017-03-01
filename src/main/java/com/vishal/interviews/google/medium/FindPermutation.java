package com.vishal.interviews.google.medium;

/**
 * 484. Find Permutation
 * 
 * By now, you are given a secret signature consisting of character 'D' and 'I'.
 * 'D' represents a decreasing relationship between two numbers, 'I' represents
 * an increasing relationship between two numbers. And our secret signature was
 * constructed by a special integer array, which contains uniquely all the
 * different number from 1 to n (n is the length of the secret signature plus
 * 1). For example, the secret signature "DI" can be constructed by array
 * [2,1,3] or [3,1,2], but won't be constructed by array [3,2,4] or [2,1,3,4],
 * which are both illegal constructing special string that can't represent the
 * "DI" secret signature.
 * 
 * On the other hand, now your job is to find the lexicographically smallest
 * permutation of [1, 2, ... n] could refer to the given secret signature in the
 * input.
 * 
 * Example 1:
 * 
 * Input: "I"
 * 
 * Output: [1,2]
 * 
 * Explanation: [1,2] is the only legal initial spectial string can construct
 * secret signature "I", where the number 1 and 2 construct an increasing
 * relationship.
 * 
 * Example 2:
 * 
 * Input: "DI"
 * 
 * Output: [2,1,3]
 * 
 * Explanation: Both [2,1,3] and [3,1,2] can construct the secret signature
 * "DI", but since we want to find the one with the smallest lexicographical
 * permutation, you need to output [2,1,3]
 * 
 * Note:
 * 
 * 1. The input string will only contain the character 'D' and 'I'.
 * 
 * 2. The length of input string is a positive integer and will not exceed
 * 10,000
 */
public class FindPermutation {

	public static void main(String[] args) {

	}

	/**
	 * Java O(n) clean solution easy to understand
	 * 
	 * For example, given IDIIDD we start with sorted sequence 1234567
	 * 
	 * Then for each k continuous D starting at index i we need to reverse [i,
	 * i+k] portion of the sorted sequence.
	 * 
	 * IDIIDD
	 * 
	 * 1234567 // sorted
	 * 
	 * 1324765 // answer
	 * 
	 * @param s
	 * @return
	 */
	public int[] findPermutationEasyAndClear(String s) {
		int n = s.length(), arr[] = new int[n + 1];
		for (int i = 0; i <= n; i++)
			arr[i] = i + 1; // sorted
		for (int h = 0; h < n; h++) {
			if (s.charAt(h) == 'D') {
				int l = h;
				while (h < n && s.charAt(h) == 'D')
					h++;
				reverse(arr, l, h);
			}
		}
		return arr;
	}

	void reverse(int[] arr, int l, int h) {
		while (l < h) {
			arr[l] ^= arr[h];
			arr[h] ^= arr[l];
			arr[l] ^= arr[h];
			l++;
			h--;
		}
	}

	/**
	 * Greedy O(n) JAVA solution with explanation
	 * 
	 * Idea is pretty simple. There are 2 possibilities:
	 * 
	 * 1. String starts with "I". Then we should use 1 as the first item.
	 * 
	 * 2. String starts with "D..DI" (k letters) or the string is just "D...D".
	 * In this case we should use k, k - 1, ..., 1 to get lexicographically
	 * smallest permutation.
	 * 
	 * Then we proceed computing the rest of the array. Also we should increase
	 * min variable that is used to store minimum value in remaining part of the
	 * array.
	 * 
	 * 
	 * @param s
	 * @return
	 */
	public int[] findPermutationGreedySolution(String s) {

		s = s + ".";
		int[] res = new int[s.length()];
		int min = 1, i = 0;

		while (i < res.length) {
			if (s.charAt(i) != 'D') {
				res[i++] = min++;
			} else {
				int j = i;
				while (s.charAt(j) == 'D')
					j++;
				for (int k = j; k >= i; k--)
					res[k] = min++;
				i = j + 1;
			}
		}

		return res;
	}
}
