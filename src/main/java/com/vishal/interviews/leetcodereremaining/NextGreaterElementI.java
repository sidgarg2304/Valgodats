package com.vishal.interviews.leetcodereremaining;

import java.util.*;

public class NextGreaterElementI {

	public static void main(String[] args) {

	}

	public int[] nextGreaterElement(int[] findNums, int[] nums) {

		if (findNums == null || findNums.length == 0 || nums == null || nums.length == 0) {
			return findNums;
		}

		Map<Integer, Integer> map = new HashMap<>();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < nums.length; i++) {
			while(!stack.isEmpty() && nums[i] > stack.peek()){
				map.put(stack.pop(), nums[i]);
			}
			stack.push(nums[i]);
		}

		for (int i = 0; i < findNums.length; i++) {
			findNums[i] = map.getOrDefault(findNums[i], -1);
		}
		return findNums;
	}

}
