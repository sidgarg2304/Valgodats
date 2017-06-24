package com.vishal.interviews.linkedin.careercup;

import java.util.*;

/**
 * This question was asked in the first coding round on-site. 

Give two sorted lists List<Integer> a and List<Integer> b. 

Find 
the Union of these two lists -> the union list should also be sorted 
the Intersection of these two lists -> Intersection list should also be sorted.
 *
 */
public class UnionAndIntersectionofLists {

	public static void main(String[] args) {

		List<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(2);
		a.add(3);
		
		List<Integer> b = new ArrayList<>();		
		b.add(1);
		b.add(2);
		b.add(3);
		b.add(4);
		b.add(5);
		b.add(6);
		
		System.out.println(union(a,b));
		System.out.println(intersection(a,b));
	}

	static List<Integer> union(List<Integer> a, List<Integer> b) {
		List<Integer> res = new ArrayList<>();
		if (a == null || a.size() == 0) {
			res.addAll(b);
			return res;
		}

		if (b == null || b.size() == 0) {
			res.addAll(a);
			return res;
		}
		
		Set<Integer> set = new HashSet<>();
		for(int i: a){
			set.add(i);
			res.add(i);
		}
		
		for(int i: b){
			if(!set.contains(i)){
				res.add(i);
			}
		}
		
		return res;
	}
	
	static List<Integer> intersection(List<Integer> a, List<Integer> b) {
		List<Integer> res = new ArrayList<>();
		if (a == null || a.size() == 0) {
			res.addAll(b);
			return res;
		}

		if (b == null || b.size() == 0) {
			res.addAll(a);
			return res;
		}
		
		Set<Integer> set = new HashSet<>();
		for(int i: a){
			set.add(i);			
		}
		
		for(int i: b){
			if(set.contains(i)){
				res.add(i);
			}
		}
		
		return res;
	}

}
