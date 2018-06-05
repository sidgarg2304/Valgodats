package com.vishal.interviews.top100linkedquestions.medium;

public class TaskScheduler {

	public static void main(String[] args) {

	}

	public int leastInterval(char[] tasks, int n) {

		if (tasks == null || tasks.length == 0) {
			return 0;
		}

		int[] cnt = new int[26];
		for (char t : tasks) {
			cnt[t - 'A']++;
		}

		int[] valid = new int[26];
		int res = 0;
		int i = 0;
		while (i < tasks.length) {
			int p = findPos(tasks[i], valid, cnt);
			if (p != -1) {
				i++;
				valid[p] += n;
				cnt[p]--;	
			} else {

			}
			res++;
		}

		return res;
	}

	int findPos(int p, int[] valid, int[] cnt) {
		int maxCnt = 0;
		int r = -1;

		for (int i = 0; i < 26; i++) {
			if (cnt[i] > maxCnt && p >= valid[i]) {
				maxCnt = cnt[i];
				r = i;
			}
		}
		return r;
	}

}
