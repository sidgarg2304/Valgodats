package com.vishal.interviews.linkedin.careercup;

import java.util.*;
import java.util.Arrays;

/**
 * public interface Triangle {
 
    /**
     * Three segments of lengths A, B, C form a triangle iff
     *
     *      A + B > C
     *      B + C > A
     *      A + C > B
     *
     * e.g.
     *  6, 4, 5 can form a triangle
     * 10, 2, 7 can't
     *
     * Given a list of segments lengths algorithm should find at least one triplet of segments that form a triangle (if any).
     *
     * Method should return an array of either:
     * - 3 elements: segments that form a triangle (i.e. satisfy the condition above)
     * - empty array if there are no such segments
     *    int[] getTriangleSides(int[] segments);
     *    
     *    eg: 9 8 10 7 
ans: 9 8 10, 9 8 7, 9 10 7, 7 8 10 
     */
 

public class Triangle {

	public static void main(String[] args) {

		System.out.println(getTriangleSides(new int[] { 9, 8, 16, 7, 15 }));
	}

	public int triangleNumber(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}
		Arrays.sort(nums);

		int res = 0;
		for (int i = nums.length - 1; i >= 2; i--) {
			int l = 0;
			int r = i - 1;

			while (l < r) {
				if (nums[l] + nums[r] > nums[i]) {
					res += r - l;
					r--;
				} else {
					l++;
				}
			}
		}
		return res;
	}
	public static List<List<Integer>> getTriangleSides(int[] nums) {

		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);

		// 7 8 9 10 15 16 18
		// 2 7 10

		// 7 8 9 10
		
		for (int i = nums.length - 1; i >= 2; i--) {
			int l = 0;
			int r = i - 1;

			while (l < r) {
				if (nums[l] + nums[r] > nums[i]) {
					for (int m = l; m < r; m++) {
						List<Integer> curRes = new ArrayList<>();

						curRes.add(nums[i]);
						curRes.add(nums[r]);
						curRes.add(nums[m]);
						res.add(curRes);
					}
					r--;
				} else {
					l++;
				}
			}
		}
				

		return res;
	}

}
