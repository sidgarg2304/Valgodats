package com.vishal.interviews.facebook.medium;

/**
 * 275. H-Index II
 * 
 * Follow up for H-Index: What if the citations array is sorted in ascending
 * order? Could you optimize your algorithm?
 *
 */
public class HIndexII {

	public static void main(String[] args) {

	}

	public int hIndexBinarySearch(int[] citations) {

		int l = citations.length;
		int res = Integer.MIN_VALUE;
		int i = 0;
		int j = citations.length - 1;
		while (i <= j) {
			int m = (i + j) / 2;
			if (citations[m] == (l - m)) {
				return (l - m);
			} else if (citations[m] < (l - m)) {
				i = m + 1;
			} else {
				j = m - 1;
			}
		}

		return res;
	}

	/**
	 * O(1) solution
	 * 
	 * @param citations
	 * @return
	 */
	public int hIndex(int[] citations) {

		int l = citations.length;
		int res = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < citations.length; i++) {
			min = Math.min(citations[i], l - citations[i]);
			res = Math.max(res, min);
		}

		return res;
	}

}
