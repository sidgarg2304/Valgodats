package com.vishal.interviews.programcreek.combinationsandpermutations;

import java.util.*;

public class GenerateParentheses {

	public static void main(String[] args) {

	}

	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();

		dfs(n, "", 0, 0, res);
		return res;
	}

	void dfs(int n, String cur, int leftCount, int rightCount, List<String> res) {

		if (leftCount == n && rightCount == n) {
			res.add(cur);
			return;
		}

		if (leftCount < n) {
			dfs(n, cur + "(", leftCount + 1, rightCount, res);
		}

		if (rightCount < leftCount) {
			dfs(n, cur + ")", leftCount, rightCount + 1, res);
		}

	}

}
