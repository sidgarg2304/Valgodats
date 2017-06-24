package com.vishal.interviews.facebook.medium;

import java.util.*;

/**
 * 
 * 621. Task Scheduler
 * 
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

Example 1:
Input: tasks = ['A','A','A','B','B','B'], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
Note:
The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].
 *
 */
public class TaskScheduler {

	public static void main(String[] args) {

		System.out.println(leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 2));
	}

	public static int leastInterval(char[] tasks, int n) {

		int[] count = new int[26];
		for (char c : tasks) {
			count[c - 'A']++;
		}

		int[] valid = new int[26];

		int i = 0;
		int r = 0;
		List<Character> res = new ArrayList<>();
		while (i < tasks.length) {
			System.out.println(Arrays.toString(valid));
			int candToBePlacedAtR = getNextCandidate(count, valid, r);
			System.out.println("candToBePlacedAtR placing at " + r + " is " + candToBePlacedAtR);
			if (candToBePlacedAtR != -1) {
				i++;
				valid[candToBePlacedAtR] += n+1;
				count[candToBePlacedAtR]--;
				res.add((char)(candToBePlacedAtR + 'A'));
			} else {
				// place idle
				res.add('*');
			}
			r++;
		}

		System.out.println(res);
		return r;
	}

	static int getNextCandidate(int[] count, int[] valid, int r) {

		int maxCount = Integer.MIN_VALUE;
		int cand = -1;
		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0 && count[i] > maxCount && r >= valid[i]) {
				maxCount = count[i];
				cand = i;
			}
		}
		return cand;
	}

}
