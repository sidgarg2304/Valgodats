package com.vishal.interviews.leetcodereremaining;

import java.util.*;

public class DistributeCandies {

	public static void main(String[] args) {

	}
	
	
	public int distributeCandies(int[] candies) {
		
		if (candies == null || candies.length == 0) {
			return 0;
		}

		Set<Integer> set = new HashSet<>();
		for (int i : candies) {
			set.add(i);
		}

		int sister = candies.length / 2;

		return Math.min(set.size(), sister);
      
   }
}
