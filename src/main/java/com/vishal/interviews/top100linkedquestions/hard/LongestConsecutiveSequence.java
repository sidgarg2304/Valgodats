package com.vishal.interviews.top100linkedquestions.hard;

import java.util.*;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {

	}

	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		Set<Integer> set = new HashSet<>();
		for (int i : nums) {
			set.add(i);
		}

		int max = 1;
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				set.remove(nums[i]);
				int cnt = 1;
				int l = nums[i] - 1;
				while (set.contains(l)) {
					l--;
					set.remove(l);
					cnt++;
				}
				int h = nums[i] + 1;
				while (set.contains(h)) {
					h++;
					set.remove(h);
					cnt++;
				}
				
				max = Math.max(max, cnt);
			}
		}
		
		return max;
	}

}
