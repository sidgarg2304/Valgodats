package com.vishal.interviews.facebook.medium;

import java.util.ArrayList;
import java.util.List;

import com.vishal.interviews.util.Interval;

public class IntervalListIntersections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] intervalIntersection(int[][] A, int[][] B) {

		List<int[]> res = new ArrayList<>();

		int i = 0;
		int j = 0;
		while (i < A.length && j < B.length) {
			int[] a = A[i];
			int[] b = B[j];

			if (a[1] < b[0]) {
				i++;
			} else if (b[1] < a[0]) {
				j++;
			} else {

				int lo = Math.max(a[0], b[0]);
				int hi = Math.min(a[1], b[1]);

				if (lo <= hi) {
					res.add(new int[] { lo, hi });
				}

				if (a[1] < b[1]) {
					i++;
				} else {
					j++;
				}
			}
		}

		return res.toArray(new int[][] {});
	}

	public Interval[] intervalIntersection(Interval[] A, Interval[] B) {

		List<Interval> res = new ArrayList<>();

		int i = 0;
		int j = 0;
		while (i < A.length && j < B.length) {
			Interval a = A[i];
			Interval b = B[j];

			if (a.en < b.st) {
				i++;
			} else if (b.en < a.st) {
				j++;
			} else {

				int lo = Math.max(a.st, b.st);
				int hi = Math.min(a.en, b.en);

				if (lo <= hi) {
					res.add(new Interval(lo, hi));
				}

				if (a.en < b.en) {
					i++;
				} else {
					j++;
				}
			}
		}

		return res.toArray(new Interval[res.size()]);
	}

}
