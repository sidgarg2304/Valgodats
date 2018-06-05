package com.vishal.interviews.netflix.easy;

import java.util.*;

public class FindUniqueElementsFromTwoSets {

	public static void main(String[] args) {

		Set<Integer> set1 = new HashSet<>();
		set1.add(1);
		set1.add(2);
		Set<Integer> set2 = new HashSet<>();
		
		set2.add(3);
		set2.add(2);
		set2.add(1);
		System.out.println(uniqueElementsFromTwoSets(set1, set2));
	}

	// {1,2} {2,3}
	// {1,3}
	static List<Integer> uniqueElementsFromTwoSets(Set<Integer> set1, Set<Integer> set2) {
		List<Integer> res = new ArrayList<>();

		for (int i : set1) {
			if (!set2.contains(i)) {
				res.add(i);
			}
		}

		for (int i : set2) {
			if (!set1.contains(i)) {
				res.add(i);
			}
		}
		return res;
	}

}
