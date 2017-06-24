package com.vishal.interviews.programcreek;

public class FirstBadVersion {

	public static void main(String[] args) {

	}

	public int firstBadVersion(int n) {

		int i = 1;
		int j = n;

		while (i < j) {
			int m = i + (j - i) / 2;
			if (isBadVersion(m)) {
				j = m;
			} else {
				i = m + 1;
			}
		}
		if (isBadVersion(i)) {
			return i;
		}
		return j;

	}

	boolean isBadVersion(int v) {
		return true;
	}

}
