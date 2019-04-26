package com.vishal.interviews.google.medium;

import java.util.*;

import com.vishal.interviews.util.Interval;
/**
 * 616. Add Bold Tag in String
 * 
 * Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b> to wrap the substrings in s that exist in dict. If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag. Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.
Example 1:
Input: 
s = "abcxyz123"
dict = ["abc","123"]
Output:
"<b>abc</b>xyz<b>123</b>"
Example 2:
Input: 
s = "aaabbcc"
dict = ["aaa","aab","bc"]
Output:
"<b>aaabbc</b>c"
Note:
The given dict won't contain duplicates, and its length won't exceed 100.
All the strings in input have length in range [1, 1000].
 *
 */
public class AddBoldTaginString {

	public static void main(String[] args) {

	}
	
	public String addBoldTag(String s, String[] dict) {
      List<Interval> intervals = new ArrayList<>();
		for (String w : dict) {
			int index = -1;
			index = s.indexOf(w, index);
			while (index != -1) {
				intervals.add(new Interval(index, index + w.length()));
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
			sb.append("</b>");
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
