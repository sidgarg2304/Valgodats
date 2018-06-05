package com.vishal.interviews.nestlabs.careercup;

import java.util.*;

/**
 * Generate a random number with UNIFORM DISTRIBUTION between [0,n) where n is
 * given and excluded list is given. The randomly generated number should belong
 * to the range [0, n) but should be excluded from the given excluded list. For
 * example, n = 10 and excluded list ={2,3,0} then the random number should be
 * from {1,4,5,6,7,8,9} such that any number from the list {1,4,5,6,7,8,9} has
 * UNIFORM probablility of occuring
 *
 */
public class RandomNumberWithUniformDistribution {

	public static void main(String[] args) {

		Set<Integer> ex = new HashSet<>();
		ex.add(2);
		ex.add(3);
		ex.add(0);
		System.out.println(random(10, ex));
		
		
	}

	public static int random(int n, Set<Integer> ex) {
		int idx = new Random().nextInt(n - ex.size());

		for (int num = 0; num < n; num++) {
			if (!ex.contains(num)) {
				idx--;
			}
			if (idx == -1) {
				return num;
			}
		}
		return -1; // no number is available for selection (n is 0 or every number
					  // in range is excluded
	}

}
