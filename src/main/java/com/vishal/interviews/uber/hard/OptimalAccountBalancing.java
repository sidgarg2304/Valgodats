package com.vishal.interviews.uber.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimalAccountBalancing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minTransfers(int[][] transactions) {

		if (transactions == null || transactions.length == 0) {
			return 0;
		}

		Map<Integer, Integer> personBalance = new HashMap<>();
		for (int[] t : transactions) {
			int lender = t[0];
			int receiver = t[1];
			int amount = t[2];
			personBalance.put(lender, personBalance.getOrDefault(lender, 0) - amount);
			personBalance.put(receiver, personBalance.getOrDefault(receiver, 0) + amount);
		}

		List<Integer> deltas = new ArrayList<>();
		for (int balance : personBalance.values()) {
			if (balance != 0) {
				deltas.add(balance);
			}
		}
		Collections.sort(deltas);
		int res = 0;
		res += removeExactMatches(deltas);
		res += findMinTransactions(deltas, 0);

		return res;
	}

	int removeExactMatches(List<Integer> deltas) {
		int res = 0;
		int i = 0;
		int j = deltas.size() - 1;
		while (i < j) {
			int left = deltas.get(i);
			int right = deltas.get(j);

			if (-1 * left == right) {
				res++;
				deltas.remove(i);
				deltas.remove(j - 1);
				j -= 2;
			} else if (-1 * left < right) {
				i++;
			} else {
				j--;
			}
		}

		return res;
	}

	int findMinTransactions(List<Integer> deltas, int st) {
		while (st < deltas.size() && deltas.get(st) == 0) {
			st++;
		}

		if (st == deltas.size()) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int i = st + 1; i < deltas.size(); i++) {
			if ((long) deltas.get(st) * deltas.get(i) < 0) {
				deltas.set(i, deltas.get(i) + deltas.get(st));
				min = Math.min(min, 1 + findMinTransactions(deltas, st + 1));
				deltas.set(i, deltas.get(i) - deltas.get(st));
			}
		}

		return min;
	}

}
