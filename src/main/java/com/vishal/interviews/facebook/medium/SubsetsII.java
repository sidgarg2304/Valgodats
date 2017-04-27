package com.vishal.interviews.facebook.medium;

import java.util.*;

/**
 * 90. Subsets II
 * 
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 *
 */
public class SubsetsII {

	public static void main(String[] args) {

		System.out.println(subsetsWithDup(new int[]{1,2,2}));
	}

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		Arrays.sort(nums);
		
		dfs(nums, res, temp, 0);
		return res;
	}
	
	static void  dfs(int[] nums, List<List<Integer>> res, List<Integer> temp, int st){
		res.add(new ArrayList<>(temp));
		
		int i = st;
		while(i < nums.length){	
			temp.add(nums[i]);
			dfs(nums, res, temp, i+1);
			temp.remove(temp.size()-1);
			i++;
			while(i < nums.length && nums[i] == nums[i-1]){
				i++;
			}			
		}
	}

}
