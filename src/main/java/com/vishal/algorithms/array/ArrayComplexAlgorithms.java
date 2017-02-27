package com.vishal.algorithms.array;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class ArrayComplexAlgorithms {

	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 0, 0, 6, 0 };
		moveZeroes(a);				
	}

	/**
	 * Given an array of integers, find out whether there are two distinct
	 * indices i and j in the array such that the difference between nums[i] and
	 * nums[j] is at most t and the difference between i and j is at most k.
	 */
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		TreeSet<Integer> set = new TreeSet<Integer>();

		for (int i = 0; i < nums.length; i++) {

			int leftSideValue = nums[i] - t;
			int rightSideValue = nums[i] + t;

			// check if this tree set has any value between left to right
			Set<Integer> subset = set.subSet(leftSideValue, rightSideValue + 1); // right
																										// is
																										// exclusive
			if (subset.size() > 0) {
				return true;
			}
			set.add(nums[i]);

			// maintain element only at k distance
			if (i >= k) {
				set.remove(nums[i - k]);
			}
		}
		return false;
	}

	public static void moveZeroes(int[] nums) {

		int z = -1;

		for (int i = 0; i < nums.length; i++) {
			if (z == -1 && nums[i] == 0) {
				z = i;
			}

			if (z > -1 && nums[i] != 0) {
				swap(nums, z, i);
				z++;
			}
		}

		System.out.println(Arrays.toString(nums));
	}

	public static int medianOfTwoSrotedArrays(int[] a, int[] b) {

		int t = a.length + b.length;

		if ((t) % 2 == 0) {
			return (fndKth(t / 2, a, b, 0, 0) + fndKth(t / 2 + 1, a, b, 0, 0)) / 2;
		} else {
			return fndKth(t / 2 + 1, a, b, 0, 0);
		}

	}

	public static int fndKth(int k, int[] a1, int[] a2, int s1, int s2) {

		if (s1 >= a1.length) {
			return a2[s2 + k - 1];
		}

		if (s2 >= a2.length) {
			return a1[s1 + k - 1];
		}

		if (k == 1) {
			return a1[s1] < a2[s2] ? a1[s1] : a2[s2];
		}

		int m1 = s1 + k / 2 - 1;
		int m2 = s2 + k / 2 - 1;

		int mid1 = m1 < a1.length ? a1[m1] : Integer.MAX_VALUE;
		int mid2 = m2 < a2.length ? a2[m1] : Integer.MAX_VALUE;

		if (mid1 > mid2) {
			// skip second array's starting elements
			return fndKth(m1, a1, a2, s2, m2 + 1);
		} else {
			// skip first array's starting elements
			return fndKth(m1, a1, a2, m1 + 1, s2);
		}

	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}
