package com.vishal.interviews.programcreek;

public class HIndex {

	public static void main(String[] args) {

	}

	public int hIndex(int[] citations) {
		int[] count = new int[citations.length + 1];
		for (int i = 0; i < citations.length; i++) {
			if (citations[i] > citations.length) {
				count[citations.length]++;
			} else {
				count[citations[i]]++;
			}
		}

		for (int i = count.length - 1; i >= 0; i--) {
			if (i < count.length - 1) {
				count[i] += count[i + 1];
			}
			if (count[i] >= i) {
				return i;
			}
		}

		return 0;
	}

}
