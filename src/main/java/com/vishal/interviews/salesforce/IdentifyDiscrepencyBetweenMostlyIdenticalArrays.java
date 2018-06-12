package com.vishal.interviews.salesforce;

import java.util.*;

/**
 * 
 * nums1 = {3,1,4,5,2,6,6}; nums2 = {3,5,2,1,4,6};
 * 
 */
public class IdentifyDiscrepencyBetweenMostlyIdenticalArrays {

	public static void main(String[] args) {

		System.out.println("using hashmap");

		System.out.println(
				identifyDiscrepencyUsingHashMap(new int[] { 3, 1, 4, 5, 2, 6, 6 }, new int[] { 3, 5, 2, 1, 4, 6 }));
		System.out.println(
				identifyDiscrepencyUsingHashMap(new int[] { 3, 1, 4, 5, 2, 6, 6 }, new int[] { 3, 5, 2, 1, 4, 6, 4, 6 }));

		System.out.println(
				identifyDiscrepencyUsingHashMap(new int[] { 3, 1, 4, 5, 2, 6, 6 }, new int[] { 3, 5, 2, 1, 4, 6, 6 }));

		System.out.println("\nusing sorting");

		System.out.println(
				identifyDiscrepencyUsingSorting(new int[] { 3, 1, 4, 5, 2, 6, 6 }, new int[] { 3, 5, 2, 1, 4, 6 }));
		System.out.println(
				identifyDiscrepencyUsingSorting(new int[] { 3, 1, 4, 5, 2, 6, 6 }, new int[] { 3, 5, 2, 1, 4, 6, 4, 6 }));

		System.out.println(
				identifyDiscrepencyUsingSorting(new int[] { 3, 1, 4, 5, 2, 6, 6 }, new int[] { 3, 5, 2, 1, 4, 6, 6 }));
	}

	static int identifyDiscrepencyUsingHashMap(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] first = nums1.length < nums2.length ? nums1 : nums2;
		int[] sec = nums1.length > nums2.length ? nums1 : nums2;
		for (int i : first) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		for (int i : sec) {
			if (!map.containsKey(i)) {
				return i;
			}
			map.put(i, map.get(i) - 1);
			if (map.get(i) == 0) {
				map.remove(i);
			}
		}
		return -1;
	}

	// 1,2,3,4,5,6,6
	// 1,2,3,4,4,5,6,6
	static int identifyDiscrepencyUsingSorting(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		if (nums1.length == nums2.length) {
			return -1;
		}

		int i = 0;
		int j = 0;
		while (i < nums1.length || j < nums2.length) {
			if (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
				i++;
				j++;
			} else if (nums1.length < nums2.length) {
				return nums2[j];
			} else {
				return nums1[i];
			}
		}

		return -1;
	}

}
