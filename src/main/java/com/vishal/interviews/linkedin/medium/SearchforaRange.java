package com.vishal.interviews.linkedin.medium;

/**
 * 34. Search for a Range
 * 
 * Given an array of integers sorted in ascending order, find the starting and
 * ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 */
public class SearchforaRange {

	public static void main(String[] args) {

	}

	// 5, 7, 7, 8, 8, 10
	static int[] search(int[] nums, int target) {
		int[] res = new int[2];

		int i = 0;
		int j = nums.length - 1;
		
		while (i < j) {
			int mid = (i +j)/2;
			if(nums[mid] < target){
				j = mid+1;
			}else if(nums[mid] > target){
				j = mid-1;
			}else{
				res[0] = mid;
				res[1] = mid;
				
				int st = mid;
				while(st >= 0 && nums[st] == target){
					st--;
					res[0] = st;
				}
				
				int en = mid;
				while(en < nums.length && nums[en] == target){
					en++;
					res[1] = en;
				}
			}
		}

		return res;
	}

}
