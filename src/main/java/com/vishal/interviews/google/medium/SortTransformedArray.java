package com.vishal.interviews.google.medium;

/**
 * 360. Sort Transformed Array
 * 
 * 
 * Given a sorted array of integers nums and integer values a, b and c. Apply a function of the form f(x) = ax2 + bx + c to each element x in the array.

The returned array must be in sorted order.

Expected time complexity: O(n)

Example:
nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,

Result: [3, 9, 15, 33]

nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5

Result: [-23, -5, 1, 7]
 */
public class SortTransformedArray {

	public static void main(String[] args) {
	}
	
	/**
	 * Java O(n) incredibly short yet easy to understand AC solution
the problem seems to have many cases a>0, a=0,a<0, (when a=0, b>0, b<0). However, they can be combined into just 2 cases: a>0 or a<0

1.a>0, two ends in original array are bigger than center if you learned middle school math before.

2.a<0, center is bigger than two ends.

so use two pointers i, j and do a merge-sort like process. depending on sign of a, you may want to start from the beginning or end of the transformed array. For a==0 case, it does not matter what b's sign is.
The function is monotonically increasing or decreasing. you can start with either beginning or end.

	 * @param nums
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
		int n = nums.length;
		int[] sorted = new int[n];
		int i = 0, j = n - 1;
		int index = a >= 0 ? n - 1 : 0;
		while (i <= j) {
			if (a >= 0) {
				sorted[index--] = quad(nums[i], a, b, c) >= quad(nums[j], a, b, c) ? quad(nums[i++], a, b, c)
						: quad(nums[j--], a, b, c);
			} else {
				sorted[index++] = quad(nums[i], a, b, c) >= quad(nums[j], a, b, c) ? quad(nums[j--], a, b, c)
						: quad(nums[i++], a, b, c);
			}
		}
		return sorted;
	}

	private int quad(int x, int a, int b, int c) {
		return a * x * x + b * x + c;
	}
	
/**
 * My easy to understand Java AC solution using Two pointers
The idea is simple:
For a parabola,
if a >= 0, the min value is at its vertex. So our our sorting should goes from two end points towards the vertex, high to low.
if a < 0, the max value is at its vertex. So our sort goes the opposite way.

 * @param nums
 * @param a
 * @param b
 * @param c
 * @return
 */
	public int[] sortTransformedArrayJavaAC(int[] nums, int a, int b, int c) {
		int[] res = new int[nums.length];
		int start = 0;
		int end = nums.length - 1;
		int i = a >= 0 ? nums.length - 1 : 0;
		while (start <= end) {
			int startNum = getNum(nums[start], a, b, c);
			int endNum = getNum(nums[end], a, b, c);
			if (a >= 0) {
				if (startNum >= endNum) {
					res[i--] = startNum;
					start++;
				} else {
					res[i--] = endNum;
					end--;
				}
			} else {
				if (startNum <= endNum) {
					res[i++] = startNum;
					start++;
				} else {
					res[i++] = endNum;
					end--;
				}
			}
		}
		return res;
	}

	public int getNum(int x, int a, int b, int c) {
		return a * x * x + b * x + c;
	}
}
