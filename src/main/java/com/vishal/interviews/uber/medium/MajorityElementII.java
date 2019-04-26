package com.vishal.interviews.uber.medium;

import java.util.*;

public class MajorityElementII {

	public static void main(String[] args) {

	}

	public List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<>();
		
		if(nums == null || nums.length == 0) {
			return res;
		}

		Integer a = null;
		Integer b = null;
		int cnt1 = 0;
		int cnt2 = 0;

		for (int i : nums) {
			if (a == null || a == i) {
				a = i;
				cnt1++;
			} else if (b == null || b == i) {
				b = i;
				cnt2++;
			} else if (cnt1 == 0) {
				a = i;
				cnt1 = 1;
			} else if (cnt2 == 0) {
				b = i;
				cnt2 = 1;
			} else {
				cnt1--;
				cnt2--;
			}
		}

		cnt1 = 0;
		cnt2 = 0;

		for (int i : nums) {
			if (a != null && i == a) {
				cnt1++;
			}

			if (b != null && i == b) {
				cnt2++;
			}
		}
		
		if(cnt1 > nums.length / 3) {
			res.add(a);
		}
		
		if(cnt2 > nums.length / 3) {
			res.add(b);
		}
		
		return res;
	}

}
