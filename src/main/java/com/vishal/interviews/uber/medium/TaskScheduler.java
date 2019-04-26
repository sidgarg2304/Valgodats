package com.vishal.interviews.uber.medium;

public class TaskScheduler {

	public static void main(String[] args) {

	}

	public int leastInterval(char[] tasks, int n) {

		int r = 0;

		int[] count = new int[26];
		int[] valid = new int[26];
		for (char c : tasks) {
			count[c - 'A']++;
		}

		int i = 0;
		while (i < tasks.length) {
			int nextChar = findNextChar(count, valid, r);
			if (nextChar != -1) {
				i++;
				count[nextChar]--;
				valid[nextChar] += n + 1;
			}
			r++;
		}
		return r;
	}

	int findNextChar(int[] cnt, int[] valid, int pos) {

		int maxCount = 0;
		int cand = -1;
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] > maxCount && valid[i] <= pos) {
				maxCount = cnt[i];
				cand = i;
			}
		}
		return cand;

	}

}
