package com.vishal.interviews.programcreek;

import java.util.*;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {

	}

	public static int longestConsecutive(int[] num) {
		if (num == null || num.length == 0) {
			return 0;
		}

		Set<Integer> set = new HashSet<>();
		for (int i : num) {
			set.add(i);
		}

		int res = 0;
		for (int i : num) {
			int cnt = 1;
			set.remove(i);

			int n = i + 1;
			while (set.contains(n)) {
				set.remove(n);
				cnt++;
				n++;
			}
			int p = i - 1;
			while (set.contains(p)) {
				set.remove(p);
				cnt++;
				p--;
			}

			res = Math.max(res, cnt);
		}

		return res;
	}

}
