package com.vishal.interviews.programcreek;

public class TwoSumII {

	public static void main(String[] args) {

	}

	// sorted array
	public int[] twoSum(int[] numbers, int target) {
		int[] res = new int[2];

		int i = 0;
		int j = numbers.length - 1;

		while (i < j) {
			int sum = numbers[i] + numbers[j];

			if (sum == target) {
				res[0] = i;
				res[1] = j;
				break;
			} else if (sum < target) {
				i++;
			} else {
				j--;
			}
		}

		return res;
	}

}
