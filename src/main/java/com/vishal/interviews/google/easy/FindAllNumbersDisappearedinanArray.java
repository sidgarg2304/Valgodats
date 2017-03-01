package com.vishal.interviews.google.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. Find All Numbers Disappeared in an Array
 * 
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some
 * elements appear twice and others appear once.
 * 
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * 
 * Could you do it without extra space and in O(n) runtime? You may assume the
 * returned list does not count as extra space.
 * 
 * Example:
 * 
 * Input: [4,3,2,7,8,2,3,1]
 * 
 * Output: [5,6]
 * 
 * @author vkotha
 *
 */
public class FindAllNumbersDisappearedinanArray {

	public static void main(String[] args) {

	}

	/**
	 * The basic idea is that we iterate through the input array and mark
	 * elements as negative using nums[nums[i] -1] = -nums[nums[i]-1]. In this
	 * way all the numbers that we have seen will be marked as negative. In the
	 * second iteration, if a value is not marked as negative, it implies we have
	 * never seen that index before, so just add it to the return list.
	 * 
	 * @param nums
	 * @return
	 */
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> ret = new ArrayList<Integer>();

		for (int i = 0; i < nums.length; i++) {
			int val = Math.abs(nums[i]) - 1;
			if (nums[val] > 0) {
				nums[val] = -nums[val];
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				ret.add(i + 1);
			}
		}
		return ret;
	}

	public List<Integer> findDisappearedNumbersEasy(int[] nums) {
		List<Integer> res = new ArrayList<>();
		int n = nums.length;
		for (int i = 0; i < nums.length; i++)
			nums[(nums[i] - 1) % n] += n;
		for (int i = 0; i < nums.length; i++)
			if (nums[i] <= n)
				res.add(i + 1);
		return res;
	}

	/**
	 * Think we surely have to negate anytime we are given an array with values
	 * from 1 to the length of array. If anyone has a better idea, will be happy
	 * to hear.
	 * 
	 * The steps followed in this is:
	 * 
	 * Negate each number while traversing Run again and find the index that is
	 * not negated.
	 * 
	 * @param nums
	 * @return
	 */
	public List<Integer> findDisappearedNumbersInSpace(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			int index = nums[i];
			if (nums[Math.abs(index) - 1] > 0) {
				nums[Math.abs(index) - 1] = -nums[Math.abs(index) - 1];
			}
		}

		for (int j = 1; j <= nums.length; j++) {
			if (nums[j - 1] > 0) {
				result.add(j);
			}
		}
		return result;
	}

}
