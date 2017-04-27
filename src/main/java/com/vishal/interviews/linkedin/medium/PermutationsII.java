package com.vishal.interviews.linkedin.medium;

import java.util.*;
/**
 * 47. Permutations II
 * 
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */
public class PermutationsII {

	public static void main(String[] args) {

		permutationsII(new int[]{1,1,2});
	}
	
	static List<List<Integer>> permutationsII(int[] nums){
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		boolean[] used = new boolean[nums.length];
		
		Arrays.sort(nums);
		dfs(nums, used, temp,res);
		System.out.println(res);
		return res;
	}
	
	static void dfs(int[] nums, boolean[] used, List<Integer> temp, List<List<Integer>> res){
		if(temp.size() == nums.length){
			List<Integer> curRes = new ArrayList<>();
			curRes.addAll(temp);
			res.add(curRes);
			return;
		}
		
		for(int i = 0; i< nums.length;i++){
			if(used[i]){
				continue;
			}
			
			if(i > 0 && nums[i] == nums[i-1] && !used[i-1]){
				continue;
			}
			
			temp.add(nums[i]);
			used[i] = true;
			dfs(nums, used, temp, res);
			temp.remove(temp.size()-1);
			used[i] = false;
			
		}
	}

}
