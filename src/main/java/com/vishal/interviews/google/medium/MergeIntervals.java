package com.vishal.interviews.google.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 56. Merge Intervals
 * 
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example,
 * 
 * Given [1,3],[2,6],[8,10],[15,18],
 * 
 * return [1,6],[8,10],[15,18].
 */
public class MergeIntervals {

	public static void main(String[] args) {

	}

	/**
	 * A simple Java solution The idea is to sort the intervals by their starting
	 * points. Then, we take the first interval and compare its end with the next
	 * intervals starts. As long as they overlap, we update the end to be the max
	 * end of the overlapping intervals. Once we find a non overlapping interval,
	 * we can add the previous "extended" interval and start over.
	 * 
	 * Sorting takes O(n log(n)) and merging the intervals takes O(n). So, the
	 * resulting algorithm takes O(n log(n)).
	 * 
	 * I used an a lambda comparator (Java 8) and a for-each loop to try to keep
	 * the code clean and simple.
	 * 
	 * @param intervals
	 * @return
	 */
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() <= 1)
			return intervals;

		// Sort by ascending starting point using an anonymous Comparator
		intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

		List<Interval> result = new LinkedList<Interval>();
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;

		for (Interval interval : intervals) {
			if (interval.start <= end) // Overlapping intervals, move the end if
												// needed
				end = Math.max(end, interval.end);
			else { // Disjoint intervals, add the previous one and reset bounds
				result.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}

		// Add the last interval
		result.add(new Interval(start, end));
		return result;
	}

	class Interval {
		int start;
		int end;

		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public List<Interval> mergeClean(List<Interval> intervals) {
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval obj0, Interval obj1) {
				return obj0.start - obj1.start;
			}
		});

		List<Interval> ret = new ArrayList<>();
		Interval prev = null;
		for (Interval inter : intervals) {
			if (prev == null || inter.start > prev.end) {
				ret.add(inter);
				prev = inter;
			} else if (inter.end > prev.end) {
				// Modify the element already in list
				prev.end = inter.end;
			}
		}
		return ret;
	}

	/**
	 * Beat 98% Java. Sort start & end respectively.
	 * 
	 * The idea is that for the result distinct Interval, the latter one's start
	 * must > previous one's end.
	 * 
	 * @param intervals
	 * @return
	 */
	public List<Interval> mergeUsingSorting(List<Interval> intervals) {
		// sort start&end
		int n = intervals.size();
		int[] starts = new int[n];
		int[] ends = new int[n];
		for (int i = 0; i < n; i++) {
			starts[i] = intervals.get(i).start;
			ends[i] = intervals.get(i).end;
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		// loop through
		List<Interval> res = new ArrayList<Interval>();
		for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
			if (i == n - 1 || starts[i + 1] > ends[i]) {
				res.add(new Interval(starts[j], ends[i]));
				j = i + 1;
			}
		}
		return res;
	}

}
