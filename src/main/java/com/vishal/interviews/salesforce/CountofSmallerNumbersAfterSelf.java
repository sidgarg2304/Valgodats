package com.vishal.interviews.salesforce;

import java.util.*;


/**
 * Input:   arr[] =  {12, 1, 2, 3, 0, 11, 4}
Output:  countSmaller[]  =  {6, 1, 1, 1, 0, 1, 0} 

(Corner Cases)
Input:   arr[] =  {5, 4, 3, 2, 1}
Output:  countSmaller[]  =  {4, 3, 2, 1, 0} 

Input:   arr[] =  {1, 2, 3, 4, 5}
Output:  countSmaller[]  =  {0, 0, 0, 0, 0}
 *
 */
public class CountofSmallerNumbersAfterSelf {

	public static void main(String[] args) {

		System.out.println(Arrays.toString(countSmallerOnRightSide(new int[] { 12, 1, 2, 3, 0, 11, 4 })));
		System.out.println(Arrays.toString(countSmallerOnRightSideSortingSolution(new int[] { 12, 1, 2, 3, 0, 11, 4 })));
	}

	static int[] countSmallerOnRightSide(int[] nums) {
		if (nums == null || nums.length == 0) {
			return nums;
		}
		int[] res = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			int cnt = 0;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[i]) {
					cnt++;
				}
			}
			res[i] = cnt;
		}
		return res;
	}

	static int[] countSmallerOnRightSideSortingSolution(int[] nums) {

		if (nums == null || nums.length == 0) {
			return nums;
		}
		int[] res = new int[nums.length];
		List<Integer> sorted = new ArrayList<>();
		for (int i = nums.length - 1; i >= 0; i--) {
			int index = findIndexInSorted(nums[i], sorted);
			res[i] = index;
			sorted.add(index, nums[i]);
		}

		return res;
	}

	static int findIndexInSorted(int num, List<Integer> sorted) {
		if (sorted.size() == 0 || num <= sorted.get(0)) {
			return 0;
		}

		if (num >= sorted.get(sorted.size() - 1)) {
			return sorted.size();
		}

		int st = 0;
		int en = sorted.size() - 1;
		while (st <= en) {
			int m = (st + en) / 2;
			if (num < sorted.get(m)) {
				en = m - 1;
			} else {
				st = m + 1;
			}
		}

		if (num > sorted.get(st)) {
			return st + 1;
		}
		return st;
	}

}
