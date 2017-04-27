package com.vishal.interviews.linkedin.medium;

import java.util.*;

import com.vishal.algorithms.interval.Interval;

/**
 * 56. Merge Intervals
 * 
 * 
 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 */
public class MergeIntervals {

	public static void main(String[] args) {

	}
	
	// 
	static List<Interval> mergeIntervals(List<Interval> input){
		List<Interval> res = new ArrayList<>();
		
		Collections.sort(input, new Comparator<Interval>(){

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.getLow() - o2.getLow();
			}
			
		});
		Interval prev = input.get(0);
		
		for(int i = 1; i< input.size(); i++){
			Interval cur = input.get(i);
			if(cur.getLow() <= prev.getHigh()){
				Interval merged = new Interval(prev.getLow(), Math.max(cur.getHigh(), prev.getHigh()));
				prev = merged;
			}else{
				res.add(prev);
				prev = cur;
			}
		}
		res.add(prev);
		return res;
		
	}

}
