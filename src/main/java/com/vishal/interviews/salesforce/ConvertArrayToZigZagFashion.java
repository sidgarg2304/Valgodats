package com.vishal.interviews.salesforce;

import java.util.*;

/**
 * Given an array of distinct elements, rearrange the elements of array in 
 * zig-zag fashion in O(n) time. The converted array should be in form 
 * a < b > c < d > e < f.

Example: 
Input:  arr[] = {4, 3, 7, 8, 6, 2, 1}
Output: arr[] = {3, 7, 4, 8, 2, 6, 1}

Input:  arr[] =  {1, 4, 3, 2}
Output: arr[] =  {1, 4, 2, 3}
 *
 */
public class ConvertArrayToZigZagFashion {

	public static void main(String[] args) {

		Map<Integer, Integer> map = new HashMap<>();
		map.put(1,1);
		map.put(2,2);
		
		for(int k: map.keySet()){
			if(k == 1){
				map.remove(k);
			}
		}
		System.out.println(map);
	}
	
	// 4, 3, 7, 8, 6, 2, 1
	// 1, 2, 3, 4, 6, 7, 8
	
	static int[] convertZigZag(int[] nums){
		Arrays.sort(nums);
		int[] res = new int[nums.length];
		
		
		
		return res;
	}

}
