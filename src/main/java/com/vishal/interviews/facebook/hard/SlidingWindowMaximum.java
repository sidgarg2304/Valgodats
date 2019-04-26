package com.vishal.interviews.facebook.hard;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] maxSlidingWindow(int[] nums, int k) {

		if(nums == null || nums.length == 0 || nums.length < k){
			return new int[]{};
		}
		
		int[] res = new int[nums.length - k + 1];			

		int max = nums[0];
		int maxPos = 0;
		for (int i = 0; i < k; i++) {
			if (nums[i] > max) {
				max = nums[i];
				maxPos = i;
			}
		}
		res[0] = max;
		int r = 1;
		for (int j = k; j < nums.length; j++) {
			if (maxPos < j - k + 1) {
				// find new maxPos for this window
				max = nums[j - k + 1];
				maxPos = j - k + 1;
				for (int i = j - k + 1; i <= j; i++) {
					if (nums[i] > max) {
						max = nums[i];
						maxPos = i;
					}
				}
			} else {
				if (nums[j] > max) {
					maxPos = j;
					max = nums[j];
				}
			}
			res[r++] = max;
		}

		return res;
	}

}
