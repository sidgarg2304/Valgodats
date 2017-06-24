package com.vishal.interviews.linkedin.careercup;

import java.util.*;

/**
 * Find unique integers from list of integers


# Question
# Write a function that will return an array of integers that occur exactly once in a given array of integers.
# e.g. For a list [1,2,3,5,2,2,3,4], return [1,5,4] since they appear once (order does not matter).

def once_integers(integers):
Follow up: 
Optimize the code if input is sorted.


# What if the input is sorted, such as [1,2,2,2,3,3,4,5], could the algorithm be further optimized
# (e.g. space complexity)?

def once_integers_sorted(integers):
 *
 */
public class FindUniqueIntegers {

	public static void main(String[] args) {

	}

	List<Integer> findUnique(int[] nums) {
		List<Integer> res = new ArrayList<>();

		if (nums == null || nums.length == 0) {
			return res;
		}

		Set<Integer> set = new HashSet<>();
		for (int i : nums) {
			set.add(i);
		}

		res.addAll(set);

		return res;
	}

	List<Integer> findUniqueSorted(int[] nums) {
		List<Integer> res = new ArrayList<>();

		if (nums == null || nums.length == 0) {
			return res;
		}
		
		res.add(nums[0]);		
		
		for(int i = 1; i< nums.length; i++){
			if(nums[i] != nums[i-1]){
				res.add(nums[i]);
			}
		}
		
		return res;
	}
}
