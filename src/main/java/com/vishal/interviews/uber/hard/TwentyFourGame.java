package com.vishal.interviews.uber.hard;

import java.util.*;

public class TwentyFourGame {

	public static void main(String[] args) {

	}

	public boolean judgePoint24(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		List<Double> list = new ArrayList<>();
		for (int i : nums) {
			list.add((double) i);
		}
		return dfs(list);
	}

	boolean dfs(List<Double> list) {
		if (list.size() == 1) {
			if (Math.abs(list.get(0) - 24) < 0.001) {
				return true;
			}
			return false;
		}

		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				List<Double> possRes = generatePossibleResults(list.get(i), list.get(j));
				for (double r : possRes) {
					List<Double> nextRound = new ArrayList<>();
					nextRound.add(r);
					for (int k = 0; k < list.size(); k++) {
						if (k != i && k != j) {
							nextRound.add(list.get(k));
						}
					}
					if (dfs(nextRound)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	List<Double> generatePossibleResults(double a, double b) {
		List<Double> res = new ArrayList<>();
		res.add(a + b);
		res.add(a - b);
		res.add(b - a);
		res.add(a * b);
		if (b != 0) {
			res.add(a / b);
		}
		if (a != 0) {
			res.add(b / a);
		}

		return res;
	}

}
