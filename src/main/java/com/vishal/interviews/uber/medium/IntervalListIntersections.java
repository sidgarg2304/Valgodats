package com.vishal.interviews.uber.medium;

import java.util.*;

public class IntervalListIntersections {

	public static void main(String[] args) {

	}

	public Interval[] intervalIntersection(Interval[] A, Interval[] B) {

		List<Interval> res = new ArrayList<>();

		int i = 0;
		int j = 0;
		while (i < A.length && j < B.length) {
			int low = Math.max(A[i].start, B[j].start);
			int high = Math.min(A[i].end, B[j].end);

			if (low <= high) {
				res.add(new Interval(low, high));
			}

			if (A[i].end < B[j].end) {
				i++;
			} else {
				j++;
			}
		}

		return res.toArray(new Interval[res.size()]);
	}

	class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

}
