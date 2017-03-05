package com.vishal.interviews.google.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 465. Optimal Account Balancing
 * 
 * A group of friends went on holiday and sometimes lent each other money. For example, Alice paid for Bill's lunch for $10. Then later Chris gave Alice $5 for a taxi ride. We can model each transaction as a tuple (x, y, z) which means person x gave person y $z. Assuming Alice, Bill, and Chris are person 0, 1, and 2 respectively (0, 1, 2 are the person's ID), the transactions can be represented as [[0, 1, 10], [2, 0, 5]].

Given a list of transactions between a group of people, return the minimum number of transactions required to settle the debt.

Note:

A transaction will be given as a tuple (x, y, z). Note that x ≠ y and z > 0.
Person's IDs may not be linear, e.g. we could have the persons 0, 1, 2 or we could also have the persons 0, 2, 6.
Example 1:

Input:
[[0,1,10], [2,0,5]]

Output:
2

Explanation:
Person #0 gave person #1 $10.
Person #2 gave person #0 $5.

Two transactions are needed. One way to settle the debt is person #1 pays person #0 and #2 $5 each.
Example 2:

Input:
[[0,1,10], [1,0,1], [1,2,5], [2,0,5]]

Output:
1

Explanation:
Person #0 gave person #1 $10.
Person #1 gave person #0 $1.
Person #1 gave person #2 $5.
Person #2 gave person #0 $5.

Therefore, person #1 only need to give person #0 $4, and all debt is settled.

Looks that this is a wrong question. The expected solution didn't consider this case.
Given the input [[0,1,1], [2,3,2], [4,5,3], [6,7,4], [8,9,5], [10,11,6], [12,13,7], [14,15,2], [14,16,2], [14,17,2], [14,18,2]]

The provided expected result is 14. However, there are only 11 transactions, so the upper bound of the result should be 11.
 */
public class OptimalAccountBalancing {

	public static void main(String[] args) {

		int[][] A = new int[][] { { 0, 1, 1 }, { 2, 3, 2 }, { 4, 5, 3 }, { 6, 7, 4 }, { 8, 9, 5 }, { 10, 11, 6 },
				{ 12, 13, 7 }, { 14, 15, 2 }, { 14, 16, 2 }, { 14, 17, 2 }, { 14, 18, 2 } };
		OptimalAccountBalancingNPC solution = new OptimalAccountBalancingNPC();
		System.out.println(solution.minTransfers(A));
	}

}

/**
 * Easy java solution, with explanation
 * 
construct an isolated system. It mean the total amount of money in the system keeps constant. Thus, what matters is the amount of extra money each person have after all transactions complete. For example, if id1 gave id2 5$, then after that transaction id1's money decreased to 5$, on the contrary id2's money increased to 5$. That way, we know how did change account of each person. For imagination let's consider the following input [[1,2,3],[2,3,5], [4,1,6]]:

           id|  trans |  total |
          ---------------------
           1 | -3 + 6 |   +3   |
          ---------------------
           2 | +3 - 5 |   -2   |
         ----------------------
           3 |    +5  |   +5   |
         ----------------------
           4 |    -6  |   -6   |
         ----------------------
Now, we have some negative account changes and positive account changes. By the way it is not hard to see that they compensate each other. Now, our task is to balance the accounts, by performing minimal amount of transactions. For instance we can balance these accounts, by performing the following transactions: [1,2,2], [3,4,5], [1,4,1]. After that, all accounts become balanced, i.e 0 extra money in total. But we have performed 3 transactions. Can we do better? May be. The number of transactions depend on the order of pairs taking part in each transaction. Consequently, the next question is, 'how to know which set of pairs give minimum number of transactions?'. One solution idea is just, brute force through all pairs and just take the minimum number of transactions. Another idea is just take some random combinations of pairs and take the minimum number of trans so far.

P.S: May be there are other elegant and exact solutions and this solution doesn't pretend to the best one, but it is quite reasonable. The more random shuffles you do, the more probability of hitting the answer. For that test cases 1000 is enough, may be less...
 *
 */
class OptimalAccountBalancingEasy {
	public int minTransfers(int[][] transactions) {
		if (transactions == null || transactions.length == 0)
			return 0;
		Map<Integer, Integer> acc = new HashMap<>();
		for (int i = 0; i < transactions.length; i++) {
			int id1 = transactions[i][0];
			int id2 = transactions[i][1];
			int m = transactions[i][2];
			acc.put(id1, acc.getOrDefault(id1, 0) - m);
			acc.put(id2, acc.getOrDefault(id2, 0) + m);
		}
		List<Integer> negs = new ArrayList<>();
		List<Integer> poss = new ArrayList<>();
		for (Integer key : acc.keySet()) {
			int m = acc.get(key);
			if (m == 0)
				continue;
			if (m < 0)
				negs.add(-m);
			else
				poss.add(m);
		}
		int ans = Integer.MAX_VALUE;
		Stack<Integer> stNeg = new Stack<>(), stPos = new Stack<>();
		for (int i = 0; i < 1000; i++) {
			for (Integer num : negs)
				stNeg.push(num);
			for (Integer num : poss)
				stPos.push(num);
			int cur = 0;
			while (!stNeg.isEmpty()) {
				int n = stNeg.pop();
				int p = stPos.pop();
				cur++;
				if (n == p)
					continue;
				if (n > p) {
					stNeg.push(n - p);
				} else {
					stPos.push(p - n);
				}
			}
			ans = Math.min(ans, cur);
			Collections.shuffle(negs);
			Collections.shuffle(poss);
		}
		return ans;
	}

}

/**
 * 6ms ac easy to understand java solution with comments
 *
 */
class OptimalAccountBalancingDFS {
	public int minTransfers(int[][] transactions) {
		if (transactions == null || transactions.length == 0 || transactions[0].length == 0)
			return 0;
		// calculate delta for each account
		Map<Integer, Integer> accountToDelta = new HashMap<Integer, Integer>();
		for (int[] transaction : transactions) {
			int from = transaction[0];
			int to = transaction[1];
			int val = transaction[2];
			if (!accountToDelta.containsKey(from)) {
				accountToDelta.put(from, 0);
			}
			if (!accountToDelta.containsKey(to)) {
				accountToDelta.put(to, 0);
			}
			accountToDelta.put(from, accountToDelta.get(from) - val);
			accountToDelta.put(to, accountToDelta.get(to) + val);
		}
		List<Integer> deltas = new ArrayList<Integer>();
		for (int delta : accountToDelta.values()) {
			if (delta != 0)
				deltas.add(delta);
		}
		// since minTransStartsFrom is slow, we can remove matched deltas to
		// optimize it
		// for example, if account A has balance 5 and account B has balance -5,
		// we know
		// that one transaction from B to A is optimal.
		int matchCount = removeMatchDeltas(deltas);
		// try out all possibilities to get minimum number of transactions
		return matchCount + minTransStartsFrom(deltas, 0);
	}

	private int removeMatchDeltas(List<Integer> deltas) {
		Collections.sort(deltas);
		int left = 0;
		int right = deltas.size() - 1;
		int matchCount = 0;
		while (left < right) {
			if (-1 * deltas.get(left) == deltas.get(right)) {
				deltas.remove(left);
				deltas.remove(right - 1);
				right -= 2;
				matchCount++;
			} else if (-1 * deltas.get(left) > deltas.get(right)) {
				left++;
			} else {
				right--;
			}
		}
		return matchCount;
	}

	private int minTransStartsFrom(List<Integer> deltas, int start) {
		int result = Integer.MAX_VALUE;
		int n = deltas.size();
		while (start < n && deltas.get(start) == 0)
			start++;
		if (start == n)
			return 0;
		for (int i = start + 1; i < n; i++) {
			if ((long) deltas.get(i) * deltas.get(start) < 0) {
				deltas.set(i, deltas.get(i) + deltas.get(start));
				result = Math.min(result, 1 + minTransStartsFrom(deltas, start + 1));
				deltas.set(i, deltas.get(i) - deltas.get(start));
			}
		}
		return result;
	}

}

/**
 * Share My O(N!) NPC solution, TLE for large case
 *
 */
class OptimalAccountBalancingNPC {
	public int minTransfers(int[][] trans) {
		Map<Integer, Integer> net = new HashMap<>();
		for (int i = 0; i < trans.length; i++) {
			net.put(trans[i][0], net.getOrDefault(trans[i][0], 0) - trans[i][2]);
			net.put(trans[i][1], net.getOrDefault(trans[i][1], 0) + trans[i][2]);
		}
		int[] temp = new int[net.size()];
		int i = 0;
		for (int j : net.values()) {
			if (j != 0)
				temp[i++] = j;
		}
		int[] a = new int[i];
		System.arraycopy(temp, 0, a, 0, i);
		transactions.clear();
		number = Integer.MAX_VALUE;
		mintran(a, 0);
		return number;
	}

	private List<int[]> transactions = new ArrayList<>();
	private int number = Integer.MAX_VALUE;

	private void mintran(int[] a, int start) {
		// System.out.println(Arrays.toString(a));
		if (transactions.size() >= number)
			return;
		if (number == (a.length + 1) / 2)
			return;

		if (a.length < 2) {
			number = 0;
			return;
		} else if (a.length == 2) {
			number = a[0] == 0 ? 0 : 1;
			return;
		} else {
			int ind = -1;
			int max = Integer.MIN_VALUE;
			int i = start;
			for (; i < a.length; i++) {
				if (Math.abs(a[i]) > max) {
					max = Math.abs(a[i]);
					ind = i;
				}
			}

			if (max == 0 || start == a.length) {
				if (transactions.size() < number) {
					number = transactions.size();
				}
				return;
			}

			int temp = a[ind];
			a[ind] = a[start];
			a[start] = temp;

			for (i = start + 1; i < a.length; i++) {
				if (a[i] * a[start] < 0) {
					transactions.add(new int[] { a[i], a[start] });
					temp = a[i];
					a[i] += a[start];
					mintran(a, start + 1);
					a[i] = temp;
					transactions.remove(transactions.size() - 1);
				}
			}

			temp = a[ind];
			a[ind] = a[start];
			a[start] = temp;

		}
	}

}