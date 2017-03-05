package com.vishal.interviews.google.hard;

/**
 * 330. Patching Array
 * 
 * Given a sorted positive integer array nums and an integer n, add/patch elements to the array such that any number in range [1, n] inclusive can be formed by the sum of some elements in the array. Return the minimum number of patches required.

Example 1:
nums = [1, 3], n = 6
Return 1.

Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
So we only need 1 patch.

Example 2:
nums = [1, 5, 10], n = 20
Return 2.
The two patches can be [2, 4].

Example 3:
nums = [1, 2, 2], n = 5
Return 0.
 */

/**
 * Share my thinking process The question asked for the
 * "minimum number of patches required". In other words, it asked for an optimal
 * solution. Lots of problems involving optimal solution can be solved by
 * dynamic programming and/or greedy algorithm. I started with greedy algorithm
 * which is conceptually easy to design. Typically, a greedy algorithm needs
 * selection of best moves for a subproblem. So what is our best move?
 * 
 * Think about this example: nums = [1, 2, 3, 9]. We naturally want to iterate
 * through nums from left to right and see what we would discover. After we
 * encountered 1, we know 1...1 is patched completely. After encountered 2, we
 * know 1...3 (1+2) is patched completely. After we encountered 3, we know 1...6
 * (1+2+3) is patched completely. After we encountered 9, the smallest number we
 * can get is 9. So we must patch a new number here so that we don't miss 7, 8.
 * To have 7, the numbers we can patch is 1, 2, 3 ... 7. Any number greater than
 * 7 won't help here. Patching 8 will not help you get 7. So we have 7 numbers
 * (1...7) to choose from. I hope you can see number 7 works best here because
 * if we chose number 7, we can move all the way up to 1+2+3+7 = 13. (1...13 is
 * patched completely) and it makes us reach n as quickly as possible. After we
 * patched 7 and reach 13, we can consider last element 9 in nums. Having 9
 * makes us reach 13+9 = 22, which means 1...22 is completely patched. If we
 * still did't reach n, we can then patch 23, which makes 1...45 (22+23)
 * completely patched. We continue until we reach n.
 */
public class PatchingArray {

	public static void main(String[] args) {

	}
	
	/**
	 * The variable max records the maximal value that can be formed by the
	 * elements in nums and patched numbers. If max is less than nums[i] - 1
	 * which means we need to patch a new number, we then patch max + 1.
	 * 
	 * @param nums
	 * @param n
	 * @return
	 */
	public static int minPatchesGreedy(int[] nums, int n) {
		long max = 0;
		int cnt = 0;
		for (int i = 0; max < n;) {
			if (i >= nums.length || max < nums[i] - 1) {
				max += max + 1;
				cnt++;
			} else {
				max += nums[i];
				i++;
			}
		}
		return cnt;
	}
	

}
