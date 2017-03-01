package com.vishal.interviews.google.easy;

/**
 * 276
 * 
 * There is a fence with n posts, each post can be painted with one of the k
 * colors.
 * 
 * You have to paint all the posts such that no more than two adjacent fence
 * posts have the same color.
 * 
 * Return the total number of ways you can paint the fence.
 * 
 * Note: n and k are non-negative integers.
 * 
 * Show Company Tags Show Tags Show Similar Problems
 * 
 * @author vkotha
 *
 */
public class PaintFence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * O(n) time java solution, O(1) space
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public int numWaysO1Solution(int n, int k) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return k;
		int diffColorCounts = k * (k - 1);
		int sameColorCounts = k;
		for (int i = 2; i < n; i++) {
			int temp = diffColorCounts;
			diffColorCounts = (diffColorCounts + sameColorCounts) * (k - 1);
			sameColorCounts = temp;
		}
		return diffColorCounts + sameColorCounts;
	}

	/**
	 * Easy to understand Java O(n) runtime, O(1) space
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public int numWaysEasy(int n, int k) {
		if ((n == 0 || k == 0) || (k == 1 && n >= 3))
			return 0;
		int w1 = k;
		int w2 = k * k;
		int w3;
		if (n == 1)
			return w1;
		if (n == 2)
			return w2;
		for (int i = 0; i <= n - 3; i++) {
			w3 = (k - 1) * (w2 + w1);
			w1 = w2;
			w2 = w3;
		}
		return w2; // wrong if you return w3, w3 may not be initialized.
	}

	/**
	 * DP solution
	 */

	public int numWaysDP(int n, int k) {
		if (n == 0 || k == 0)
			return 0;
		if (n == 1)
			return k;
		// same[i] means the ith post has the same color with the (i-1)th post.
		int[] same = new int[n];
		// diff[i] means the ith post has a different color with the (i-1)th post.
		int[] diff = new int[n];
		same[0] = same[1] = k;
		diff[0] = k;
		diff[1] = k * (k - 1);
		for (int i = 2; i < n; ++i) {
			same[i] = diff[i - 1];
			diff[i] = (k - 1) * same[i - 1] + (k - 1) * diff[i - 1];
		}
		return same[n - 1] + diff[n - 1];
	}
}
