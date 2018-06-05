package com.vishal.interviews.topinterviewquestions.easy;

import java.util.*;

public class IntersectionofTwoArraysII {

	public static void main(String[] args) {

	}

	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums1.length; i++) {
			map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
		}

		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < nums2.length; i++) {
			if (map.containsKey(nums2[i])) {
				res.add(nums2[i]);
				map.put(nums2[i], map.get(nums2[i]) - 1);
				if (map.get(nums2[i]) == 0) {
					map.remove(nums2[i]);
				}
			}
		}

		int[] result = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			result[i] = res.get(i);
		}
		return result;

	}

}
