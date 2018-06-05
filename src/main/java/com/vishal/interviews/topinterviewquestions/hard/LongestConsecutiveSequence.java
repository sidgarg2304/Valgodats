package com.vishal.interviews.topinterviewquestions.hard;

import java.util.HashSet;
import java.util.Set;

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

		int res = Integer.MIN_VALUE;

		for (int i : nums) {
			if (!set.contains(i)) {
				continue;
			}
			int cnt = 1;
			set.remove(i);
			int low = i - 1;
			while (set.contains(low)) {
				cnt++;
				set.remove(low);
				low--;
			}

			int high = i + 1;
			while (set.contains(high)) {
				cnt++;
				set.remove(high);
				high++;
			}
			res = Math.max(res, cnt);
		}
		return res;
	}

}
