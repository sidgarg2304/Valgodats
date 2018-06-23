package com.vishal.interviews.salesforce;

import java.util.*;

/**
 * Arrange given numbers to form the biggest number. {54, 546, 548, 60}, the
 * arrangement 6054854654
 * 
 * {1, 34, 3, 98, 9, 76, 45, 4}, then the arrangement 998764543431
 *
 */
public class ArrangeNumbersToFormBiggestNumber {

	public static void main(String[] args) {
		System.out.println(arrangeNumbers(new Integer[] { 54, 546, 548, 60 }));
	}

	static String arrangeNumbers(Integer[] nums) {
		Arrays.sort(nums, new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				String XY = a + "" + b;
				String YX = b + "" + a;				
				return YX.compareTo(XY); // critical step
			}
		});
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i< nums.length; i++){
			sb.append(nums[i]);
		}
		return sb.toString();
	}

}
