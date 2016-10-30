package com.vishal.algorithms.array;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class ArrayComplexAlgorithms {

	public static void main(String[] args) {

		int [] a = {1,2,3,0,0,6,0};
		moveZeroes(a);

	}

	/**
	 * Given an array of integers, find out whether there are two distinct
	 * indices i and j in the array such that the difference between nums[i] and
	 * nums[j] is at most t and the difference between i and j is at most k. 
	 */
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		TreeSet<Integer> set = new TreeSet<Integer>();

		for (int i = 0; i < nums.length; i++) {

			int leftSideValue = nums[i] - t;
			int rightSideValue = nums[i] + t;

			// check if this tree set has any value between left to right
			Set<Integer> subset = set.subSet(leftSideValue, rightSideValue + 1); // right
																										// is
																										// exclusive
			if (subset.size() > 0) {
				return true;
			}
			set.add(nums[i]);

			// maintain element only at k distance
			if (i >= k) {
				set.remove(nums[i - k]);
			}
		}
		return false;
	}
	public static void moveZeroes(int[] nums) {
		
		int z = -1;
		
		for(int i = 0;i<nums.length;i++){
			if(z == -1 && nums[i] == 0){
				z=i;
			}
			
			if(z > -1 && nums[i] != 0){
				swap(nums, z, i);
				z++;
			}
		}
		
		System.out.println(Arrays.toString(nums));
	}
	
	public static void swap(int [] arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}
