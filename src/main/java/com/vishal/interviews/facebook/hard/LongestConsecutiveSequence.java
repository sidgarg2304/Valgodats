package com.vishal.interviews.facebook.hard;

import java.util.*;

/**
 * 128. Longest Consecutive Sequence
 * 
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.

Show Company Tags
Show Tags
Show Similar Problems

 *
 */
public class LongestConsecutiveSequence {

	public static void main(String[] args) {

		System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
	}
	
	public static int longestConsecutive(int[] nums) {
		
		if(nums == null || nums.length == 0){
			return 0;
		}
      Set<Integer> set = new HashSet<>();
      
      for(int i = 0; i< nums.length; i++){
      	set.add(nums[i]);
      }
      int res = 0;
      for(int i = 0; i< nums.length; i++){
      	int cur = nums[i];
      	
      	int ct = 1;
      	int p = cur -1;
      	while(set.contains(p)){
      		ct++;
      		set.remove(p);
      		p--;
      	}
      	
      	int n = cur +1;
      	while(set.contains(n)){
      		ct++;
      		set.remove(n);
      		n++;
      	}      	
      	
      	res = Math.max(res, ct);
      }
      
      return res;
   }
	
	

}
