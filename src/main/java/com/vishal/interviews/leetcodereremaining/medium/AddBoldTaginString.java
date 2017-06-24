package com.vishal.interviews.leetcodereremaining.medium;

import java.util.*;

import com.vishal.interviews.util.Interval;

public class AddBoldTaginString {

	public static void main(String[] args) {

		String s = "aaa";
		System.out.println(s.indexOf("aa", -1));
	}

	// aaa

	public String addBoldTag(String s, String[] dict) {
		List<Interval> intervals = new ArrayList<>();
		for (String w : dict) {
			int index = -1;
			index = s.indexOf(w, index);
			while (index != -1) {
				intervals.add(new Interval(index, index + s.length()));
				index += 1;
				index = s.indexOf(w, index);
			}
		}

		List<Interval> merged = mergeIntervals(intervals);
		StringBuilder sb = new StringBuilder();
		int pre = 0;
		for (Interval i : merged) {
			String left = s.substring(pre, i.st);
			sb.append(left);
			sb.append("<b>");
			String right = s.substring(i.st, i.en);
			sb.append(right);
			sb.append("<b>");
			pre = i.en;
		}

		if (pre < s.length()) {
			sb.append(s.substring(pre));
		}

		return sb.toString();
	}

	List<Interval> mergeIntervals(List<Interval> intervals) {
		List<Interval> res = new ArrayList<>();

		if (intervals.size() == 0) {
			return res;
		}
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.st - b.st;
			}
		});

		Interval pre = intervals.get(0);

		for (int i = 1; i < intervals.size(); i++) {
			Interval cur = intervals.get(i);
			if (cur.st <= pre.en) {
				pre = new Interval(pre.st, Math.max(cur.en, pre.en));
			} else {
				res.add(pre);
				pre = cur;
			}
		}
		res.add(pre);

		return res;
	}

}
