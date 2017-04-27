package com.vishal.interviews.facebook.hard;

import java.util.Arrays;

/**
 * 410. Split Array Largest Sum
 * 
 * Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.

Note:
If n is the length of array, assume the following constraints are satisfied:

1 ≤ n ≤ 1000
1 ≤ m ≤ min(50, n)
Examples:

Input:
nums = [7,2,5,10,8]
m = 2

Output:
18

Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.
 *
 */
public class SplitArrayLargestSum {

	public static void main(String[] args) {

		splitArray(new int[]{7,2,5,10,8}, 3);
	}

	
	public static int splitArray(int[] nums, int m)
	{
	    int max = Integer.MIN_VALUE;
	    long sum = 0;
	    
	    for(int i: nums){
	   	 max = Math.max(i, max);
	   	 sum += i;
	    }
	    
	    long l = max;
	    long h = sum;
	    
	    if(m == 1){
	   	 return (int)sum;
	    }
	    
	    while(l <= h){
	   	 long mid = (l+h)/2;
	   	 if(isValid(nums, mid, m)){
	   		 h = mid-1;
	   	 }else{
	   		 l = mid+1;
	   	 }
	   	 
	    }
	    
	    return (int)l;
	}
	
	static boolean isValid(int[] nums, long target, int m){
		int ct = 1;
		long total = 0;
		for(int i: nums){
			total += i;
			if(total > target){
				total = i;
				ct++;
				if(ct > m){
					return false;
				}
			}
		}
		return true;
	}
}
