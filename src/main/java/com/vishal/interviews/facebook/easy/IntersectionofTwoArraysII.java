package com.vishal.interviews.facebook.easy;

import java.util.*;

public class IntersectionofTwoArraysII {

	public static void main(String[] args) {

	}

	public int[] intersect(int[] nums1, int[] nums2) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums1) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		List<Integer> res = new ArrayList<>();
		for (int i : nums2) {
			if (map.containsKey(i)) {
				res.add(i);
				map.put(i, map.get(i) - 1);
				if (map.get(i) == 0) {
					map.remove(i);
				}
			}
		}

		int[] r = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			r[i] = res.get(i);
		}
		return r;
	}

}
