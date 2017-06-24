package com.vishal.interviews.programcreek;

public class HIndexII {

	public static void main(String[] args) {

	}

	public int hIndex(int[] citations) {
		if (citations == null || citations.length == 0)
			return 0;

		int i = 0;
		int j = citations.length - 1;

		int l = citations.length;

		while (i <= j) {
			int m = i + (j - i) / 2;
			if (citations[m] == (l - m)) {
				return l - m;
			} else if (citations[m] > (l - m)) {
				j = m - 1;
			} else {
				i = m + 1;
			}
		}

		return l - i;
	}

}
