package com.vishal.interviews.google.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. Summary Ranges
 * 
 * Given a sorted integer array without duplicates, return the summary of its
 * ranges.
 * 
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * 
 * 
 */
public class SummaryRanges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	List<String> summaryRangesEasySol(int[] nums) {

		List<String> list = new ArrayList<>();
		if (nums.length == 1) {
			list.add(nums[0] + "");
			return list;
		}
		for (int i = 0; i < nums.length; i++) {
			int a = nums[i];
			while (i + 1 < nums.length && (nums[i + 1] - nums[i]) == 1) {
				i++;
			}
			if (a != nums[i]) {
				list.add(a + "->" + nums[i]);
			} else {
				list.add(a + "");
			}
		}
		return list;
	}
	
	public List<String> summaryRanges(int[] nums) {

	    int length = nums.length;

	    List<String> result = new ArrayList<String>(length);

	    for (int i = 0; i < length; i++) {
	        int num = nums[i];

	        while (i < length - 1 && nums[i] + 1 == nums[i + 1]) {
	            i++;
	        }

	        if (num != nums[i]) {
	            result.add(num + "->" + nums[i]);
	        } else {
	            result.add(num + "");
	        }
	    }

	    return result;

	}

}
