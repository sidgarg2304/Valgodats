package com.vishal.interviews.linkedin.easy;

import java.util.Arrays;

/**
 * 53. Maximum Subarray
 * 
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		maxSubArraySum(new int[]{-2,1,-3,4,-1,2,1,-5,4});
	}
	
	//[-2,1,-3,4,-1,2,1,-5,4],
	static int[] maxSubArraySum(int [] arr){
		
		int curMaxSt = 0;
		int curMaxEn = 0;
		int curMax = arr[0];
		int resMax = Integer.MIN_VALUE;
		int resMaxSt = -1;
		int resMaxEn = -1;
		
		for(int i = 1; i< arr.length;i++){			
			
			if(arr[i] > curMax + arr[i]){
				curMaxSt = i;
				curMaxEn = i;
				curMax = arr[i];
			}else{
				curMax += arr[i];
				curMaxEn = i;
			}
			
			if(curMax > resMax){
				resMax = curMax;
				resMaxSt = curMaxSt;
				resMaxEn = curMaxEn;
			}			
		}		
		int[] res = new int[resMaxEn- resMaxSt + 1];
		System.arraycopy(arr, resMaxSt, res, 0, res.length);
		System.out.println(Arrays.toString(res));
		return res;
	}

}
