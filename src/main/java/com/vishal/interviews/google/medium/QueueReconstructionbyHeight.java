package com.vishal.interviews.google.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 406. Queue Reconstruction by Height
 * 
 * Suppose you have a random list of people standing in a queue. Each person is
 * described by a pair of integers (h, k), where h is the height of the person
 * and k is the number of people in front of this person who have a height
 * greater than or equal to h. Write an algorithm to reconstruct the queue.
 * 
 * Note:
 * 
 * The number of people is less than 1,100.
 * 
 * Example
 * 
 * Input:
 * 
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 
 * Output:
 * 
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * 
 */
public class QueueReconstructionbyHeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] reconstructQueueUsingInsertSort(int[][] people) {
		if (people == null || people.length == 0 || people[0].length == 0)
			return new int[0][0];

		Arrays.sort(people, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (b[0] == a[0])
					return a[1] - b[1];
				return b[0] - a[0];
			}
		});

		int n = people.length;
		ArrayList<int[]> tmp = new ArrayList<>();
		for (int i = 0; i < n; i++)
			tmp.add(people[i][1], new int[] { people[i][0], people[i][1] });

		int[][] res = new int[people.length][2];
		int i = 0;
		for (int[] k : tmp) {
			res[i][0] = k[0];
			res[i++][1] = k[1];
		}

		return res;
	}

	/**
	 * Easy concept with Python/C++/Java Solution
	 * 
	 * 1. Pick out tallest group of people and sort them in a subarray (S). Since
	 * there's no other groups of people taller than them, therefore each guy's
	 * index will be just as same as his k value.
	 * 
	 * 2. For 2nd tallest group (and the rest), insert each one of them into (S)
	 * by k value. So on and so forth.
	 * 
	 * E.g. input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]] subarray after step
	 * 1: [[7,0], [7,1]] subarray after step 2: [[7,0], [6,1], [7,1]] ...
	 * 
	 * It's not the most concise code, but I think it well explained the concept.
	 */

}
