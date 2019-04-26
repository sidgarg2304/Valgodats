package com.vishal.interviews.uber.medium;

import java.util.*;

public class ExclusiveTimeofFunctions {

	public static void main(String[] args) {

	}

	public int[] exclusiveTime(int n, List<String> logs) {
		
		if(n == 0) {
			return new int[]{};
		}
		
		int[] res = new int[n];

		Stack<Integer> stack = new Stack<>();
		int prevTime = 0;

		for (int i = 0; i < logs.size(); i++) {
			String cur = logs.get(i);
			String[] arr = cur.split(":");
			int id = Integer.parseInt(arr[0]);
			int time = Integer.parseInt(arr[2]);

			if ("start".equals(arr[1])) {
				if (!stack.isEmpty()) {
					res[stack.peek()] += time - prevTime;					
				}
                prevTime = time;
				stack.push(id);
			} else {
				res[id] += time - prevTime + 1;
                stack.pop();
				prevTime = time + 1;
			}
		}
		return res;
	}

}
