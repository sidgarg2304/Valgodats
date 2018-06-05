package com.vishal.interviews.topinterviewquestions.medium;

public class FindtheCelebrity {

	public static void main(String[] args) {

	}

	public int findCelebrity(int n) {

		int c = 1;
		for (int i = 2; i <= n; i++) {
			if (knows(c, i)) {
				c = i;
			}
		}

		for (int i = 1; i <= n; i++) {
			if (i == c) {
				continue;
			}
			if (knows(c, i) || !knows(i, c)) {
				return -1;
			}
		}
		return c;
	}

	boolean knows(int i, int j) {
		return true;
	}

}
