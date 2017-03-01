package com.vishal.interviews.google.medium;

/**
 * 370. Range Addition
 * 
 * Assume you have an array of length n initialized with all 0's and are given k
 * update operations.
 * 
 * Each operation is represented as a triplet: [startIndex, endIndex, inc] which
 * increments each element of subarray A[startIndex ... endIndex] (startIndex
 * and endIndex inclusive) with inc.
 * 
 * Return the modified array after all k operations were executed.
 * 
 * Example:
 * 
 * Given:
 * 
 * length = 5, updates = [ [1, 3, 2], [2, 4, 3], [0, 2, -2] ]
 * 
 * Output:
 * 
 * [-2, 0, 3, 5, 3]
 * 
 * Explanation:
 * 
 * Initial state:
 * 
 * [ 0, 0, 0, 0, 0 ]
 * 
 * After applying operation [1, 3, 2]:
 * 
 * [ 0, 2, 2, 2, 0 ]
 * 
 * After applying operation [2, 4, 3]:
 * 
 * [ 0, 2, 5, 5, 3 ]
 * 
 * After applying operation [0, 2, -2]:
 * 
 * [-2, 0, 3, 5, 3 ]
 * 
 * 
 * Hint:
 * 
 * Thinking of using advanced data structures? You are thinking it too
 * complicated.
 * 
 * For each update operation, do you really need to update all elements between
 * i and j?
 * 
 * Update only the first and end element is sufficient.
 * 
 * The optimal time complexity is O(k + n) and uses O(1) extra space.
 */
public class RangeAddition {

	public static void main(String[] args) {

	}

	/**
	 * Java O(K + N)time complexity Solution Just store every start index for
	 * each value and at end index plus one minus it
	 * 
	 * for example it will look like:
	 * 
	 * [1 , 3 , 2] , [2, 3, 3] (length = 5)
	 * 
	 * res[ 0, 2, ,0, 0 -2 ]
	 * 
	 * res[ 0 ,2, 3, 0, -5]
	 * 
	 * sum 0, 2, 5, 5, 0
	 * 
	 * res[0, 2, 5, 5, 0]
	 */

	public int[] getModifiedArray(int length, int[][] updates) {

		int[] res = new int[length];
		for (int[] update : updates) {
			int value = update[2];
			int start = update[0];
			int end = update[1];

			res[start] += value;

			if (end < length - 1)
				res[end + 1] -= value;

		}

		int sum = 0;
		for (int i = 0; i < length; i++) {
			sum += res[i];
			res[i] = sum;
		}

		return res;
	}

	/**
	 * Java O(n+k) time O(1) space with algorithm explained
	 * 
	 * segment [i,j] is made of two parts [0,i-1] and [0, j] so [i,j] increase 2
	 * is same as [0,j] increase 2 and [0,i-1] increase -2. so you only need to
	 * update value at nums[j] with inc and nums[i-1] -inc. initially nums[i] is
	 * defined as all elements [0,i] increases inc
	 * 
	 * then think from length-1 to 0 backward. The last spot nums[length-1] does
	 * not need any modification. nums[length-2] value should be updated as
	 * nums[length-2] + nums[length-1] as the latter covers the front. but front
	 * does not influence what is after it. so every spot should be updated as +
	 * the accumulate sum from the end.
	 * 
	 * @param length
	 * @param updates
	 * @return
	 */
	public int[] getModifiedArraySol2(int length, int[][] updates) {
		int[] nums = new int[length];
		for (int[] update : updates) {
			nums[update[1]] += update[2];
			if (update[0] > 0) {
				nums[update[0] - 1] -= update[2];
			}
		}

		int sum = nums[length - 1];
		for (int i = length - 2; i >= 0; i--) {
			int tmp = sum + nums[i];
			nums[i] += sum;
			sum = tmp;
		}
		return nums;
	}

}
