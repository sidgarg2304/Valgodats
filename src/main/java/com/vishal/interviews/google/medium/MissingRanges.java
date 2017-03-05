package com.vishal.interviews.google.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 163. Missing Ranges
 * 
 * Given a sorted integer array where the range of elements are in the inclusive
 * range [lower, upper], return its missing ranges.
 * 
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2",
 * "4->49", "51->74", "76->99"].
 * 
 */
public class MissingRanges {

	public static void main(String[] args) {

	}

	public List<String> findMissingRangesAccepted(int[] a, int lo, int hi) {
		List<String> res = new ArrayList<String>();

		// the next number we need to find
		int next = lo;

		for (int i = 0; i < a.length; i++) {
			// not within the range yet
			if (a[i] < next)
				continue;

			// continue to find the next one
			if (a[i] == next) {
				next++;
				continue;
			}

			// get the missing range string format
			res.add(getRange(next, a[i] - 1));

			// now we need to find the next number
			next = a[i] + 1;
		}

		// do a final check
		if (next <= hi)
			res.add(getRange(next, hi));

		return res;
	}

	String getRange(int n1, int n2) {
		return (n1 == n2) ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
	}

	public List<String> findMissingRangesConcise(int[] A, int lower, int upper) {
		List<String> result = new ArrayList<String>();
		int pre = lower - 1;
		for (int i = 0; i <= A.length; i++) {
			int after = i == A.length ? upper + 1 : A[i];
			if (pre + 2 == after) {
				result.add(String.valueOf(pre + 1));
			} else if (pre + 2 < after) {
				result.add(String.valueOf(pre + 1) + "->" + String.valueOf(after - 1));
			}
			pre = after;
		}
		return result;
	}

	public List<String> findMissingRangesSimple(int[] nums, int lower, int upper) {
		List<String> list = new ArrayList<String>();
		if (nums == null)
			return list;
		int n = nums.length;
		for (int i = 0; i <= n; i++) {
			int lt = (i == 0) ? lower : nums[i - 1] + 1;
			int gt = (i == n) ? upper : nums[i] - 1;
			addRange(list, lt, gt);
		}
		return list;
	}

	private void addRange(List<String> list, int lo, int hi) {
		if (lo > hi)
			return;
		else if (lo == hi)
			list.add(String.valueOf(lo));
		else
			list.add(lo + "->" + hi);
	}

}
