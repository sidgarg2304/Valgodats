package com.vishal.interviews.linkedin.careercup;

/**
 * 
Display an integer array of [1, 2, 3, 4, 5, 6, 7] in the following format 

1 4 6 
2 5 7 
3 

The method signature takes in an array of integers and the number of columns. In the above example, noOfCols = 3. 
The columns should contain equal number of elements as much as possible.
 */
public class DistributeIntegersWithEqualColumns {

	public static void main(String[] args) {

		printArr(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3);
	}

	private static void printArr(int[] nums, int numCols) {
		int mod = nums.length % numCols;
		int div = nums.length / numCols;

		// first mod cols are of div+1 length
		// remaining cols are of div length

		int row = 0;
		int cnt = 0;
		while (row <= div) {
			int r = row;
			for (int i = 1; i <= numCols; i++) {
				System.out.print(nums[r] + " ");
				cnt++;
				if (cnt == nums.length) {
					break;
				}
				if (i <= mod) {
					r += div + 1;
				} else {
					r += div;
				}
			}

			row++;
			System.out.println("");
		}
	}
}
