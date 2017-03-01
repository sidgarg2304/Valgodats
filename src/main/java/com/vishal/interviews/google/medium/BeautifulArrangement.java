package com.vishal.interviews.google.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 526. Beautiful Arrangement
 * 
 * Suppose you have N integers from 1 to N. We define a beautiful arrangement as
 * an array that is constructed by these N numbers successfully if one of the
 * following is true for the ith position (1 ≤ i ≤ N) in this array:
 * 
 * The number at the ith position is divisible by i. i is divisible by the
 * number at the ith position. Now given N, how many beautiful arrangements can
 * you construct?
 * 
 * Example 1: Input: 2 Output: 2 Explanation:
 * 
 * The first beautiful arrangement is [1, 2]:
 * 
 * Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
 * 
 * Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
 * 
 * The second beautiful arrangement is [2, 1]:
 * 
 * Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
 * 
 * Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
 * 
 * Note: N is a positive integer and will not exceed 15.
 * 
 */
public class BeautifulArrangement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class BackTrackingSolution {
	int count = 0;

	public int countArrangement(int N) {
		if (N == 0)
			return 0;
		helper(N, 1, new int[N + 1]);
		return count;
	}

	private void helper(int N, int pos, int[] used) {
		if (pos > N) {
			count++;
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (used[i] == 0 && (i % pos == 0 || pos % i == 0)) {
				used[i] = 1;
				helper(N, pos + 1, used);
				used[i] = 0;
			}
		}
	}
}

class BackTrackingSolution2 {
	int res;

	public int countArrangement(int N) {
		res = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= N; i++)
			list.add(i);
		helper(list, 1, N);
		return res;
	}

	private void helper(List<Integer> list, int id, int n) {
		if (id > n) {
			res++;
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) % id == 0 || id % list.get(i) == 0) {
				int temp = list.remove(i);
				helper(list, id + 1, n);
				list.add(i, temp);
			}
		}
	}
}

/**
 * 12 ms Java Backtracking sulotion The trick is: Arrange the values starting
 * from the end of the array.
 */
class BackTrackingSolution3 {
	public int countArrangement(int N) {
		dfs(N, N, new boolean[N + 1]);
		return count;
	}

	int count = 0;

	void dfs(int N, int k, boolean[] visited) {
		if (k == 0) {
			count++;
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (visited[i] || k % i != 0 && i % k != 0) {
				continue;
			}
			visited[i] = true;
			dfs(N, k - 1, visited);
			visited[i] = false;
		}
	}
}
