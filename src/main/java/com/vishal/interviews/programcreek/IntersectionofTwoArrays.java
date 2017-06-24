package com.vishal.interviews.programcreek;

import java.util.*;

public class IntersectionofTwoArrays {

	public static void main(String[] args) {

	}

	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<>();
		for (int i : nums1) {
			set1.add(i);
		}

		Set<Integer> set2 = new HashSet<>();
		for (int i : nums2) {
			if (set1.contains(i)) {
				set2.add(i);
			}
		}

		int[] res = new int[set2.size()];
		int r = 0;
		for (int i : set2) {
			res[r++] = i;
		}

		return res;
	}
}
