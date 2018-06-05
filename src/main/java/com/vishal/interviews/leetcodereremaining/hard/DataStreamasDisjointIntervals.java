package com.vishal.interviews.leetcodereremaining.hard;

import java.util.*;

import com.vishal.interviews.util.Interval;
/**
 * 352. Data Stream as Disjoint Intervals
 *
 *Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.

For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:

[1, 1]
[1, 1], [3, 3]
[1, 1], [3, 3], [7, 7]
[1, 3], [7, 7]
[1, 3], [6, 7]
 */
public class DataStreamasDisjointIntervals {

	public static void main(String[] args) {

	}

	TreeMap<Integer, Interval> treeMap;

	public DataStreamasDisjointIntervals() {
		treeMap = new TreeMap<>();
	}

	public void addNum(int val) {

		if (treeMap.containsKey(val)) {
			return;
		}
		Integer l = treeMap.lowerKey(val);
		Integer h = treeMap.higherKey(val);

		if (l != null && h != null && treeMap.get(l).en + 1 == val && val + 1 == h) {
			treeMap.get(l).en = treeMap.get(h).en;
			treeMap.remove(h);
		} else if (l != null && treeMap.get(l).en + 1 >= val) {
			treeMap.get(l).en = Math.max(treeMap.get(l).en, val);
		} else if (h != null && h == val + 1) {
			treeMap.put(val, new Interval(val, treeMap.get(h).en));
			treeMap.remove(h);
		} else {
			treeMap.put(val, new Interval(val, val));
		}
	}

	public List<Interval> getIntervals() {
		return new ArrayList<>(treeMap.values());
	}

}
