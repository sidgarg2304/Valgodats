package com.vishal.interviews.facebook.medium;

import java.util.*;

import com.vishal.interviews.util.Interval;

/**
 * 56. Merge Intervals
 * 
 * Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 *
 */
public class MergeIntervals {

	public static void main(String[] args) {

	}
	public List<Interval> merge(List<Interval> intervals) {
      
      List<Interval> res = new ArrayList<>();
      if(intervals == null || intervals.size() == 0){
          return res;
      }
		Collections.sort(intervals, (a,b) -> a.st - b.st);
		
		Interval prev = intervals.get(0);
		for(int i =1; i< intervals.size(); i++){
			
			Interval cur = intervals.get(i);
			if(cur.st <= prev.en){
				prev = new Interval(prev.st, Math.max(cur.en, prev.en));
			}else{
				res.add(prev);
				prev = cur;
			}
		}
		res.add(prev);
		
		return res;
  }
	

}
