package com.vishal.interviews.facebook.medium;

/**
 * 713. Subarray Product Less Than K
 * 
 * Your are given an array of positive integers nums.

Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

Example 1:
Input: nums = [10, 5, 2, 6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Note:

0 < nums.length <= 50000.
0 < nums[i] < 1000.
0 <= k < 10^6.
 *
 */
public class SubarrayProductLessThanK {

	public static void main(String[] args) {

	}
	
	/**
	 * Approach #1: Binary Search on Logarithms [Accepted]
Intuition

Because \log(\prod_i x_i) = \sum_i \log x_ilog(∏ 
i
​	
 x 
i
​	
 )=∑ 
i
​	
 logx 
i
​	
 , we can reduce the problem to subarray sums instead of subarray products. The motivation for this is that the product of some arbitrary subarray may be way too large (potentially 1000^50000), and also dealing with sums gives us some more familiarity as it becomes similar to other problems we may have solved before.

Algorithm

After this transformation where every value x becomes log(x), let us take prefix sums prefix[i+1] = nums[0] + nums[1] + ... + nums[i]. Now we are left with the problem of finding, for each i, the largest j so that nums[i] + ... + nums[j] = prefix[j] - prefix[i] < k.

Because prefix is a monotone increasing array, this can be solved with binary search. We add the width of the interval [i, j] to our answer, which counts all subarrays [i, k] with k <= j.
	 */
	public int numSubarrayProductLessThanK(int[] nums, int k) {
      if (k == 0) return 0;
      double logk = Math.log(k);
      double[] prefix = new double[nums.length + 1];
      for (int i = 0; i < nums.length; i++) {
          prefix[i+1] = prefix[i] + Math.log(nums[i]);
      }

      int ans = 0;
      for (int i = 0; i < prefix.length; i++) {
          int lo = i + 1, hi = prefix.length;
          while (lo < hi) {
              int mi = lo + (hi - lo) / 2;
              if (prefix[mi] < prefix[i] + logk - 1e-9) lo = mi + 1;
              else hi = mi;
          }
          ans += lo - i - 1;
      }
      return ans;
  }
	
	/**
	 * Approach #2: Sliding Window [Accepted]
Intuition

For each right, call opt(right) the smallest left so that the product of the subarray nums[left] * nums[left + 1] * ... * nums[right] is less than k. opt is a monotone increasing function, so we can use a sliding window.

Algorithm

Our loop invariant is that left is the smallest value so that the product in the window prod = nums[left] * nums[left + 1] * ... * nums[right] is less than k.

For every right, we update left and prod to maintain this invariant. Then, the number of intervals with subarray product less than k and with right-most coordinate right, is right - left + 1. We'll count all of these for each value of right.
	 */
	public int numSubarrayProductLessThanKSlidingWindow(int[] nums, int k) {
      if (k <= 1) return 0;
      int prod = 1, ans = 0, left = 0;
      for (int right = 0; right < nums.length; right++) {
          prod *= nums[right];
          while (prod >= k) prod /= nums[left++];
          ans += right - left + 1;
      }
      return ans;
  }

}
