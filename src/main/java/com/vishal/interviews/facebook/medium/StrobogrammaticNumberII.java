package com.vishal.interviews.facebook.medium;

import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumberII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> findStrobogrammatic(int n) {
		return helper(n, n);
	}

	List<String> helper(int n, int m) {
		List<String> res = new ArrayList<>();

		if (n == 0) {
			res.add("");
			return res;
		}

		if (n == 1) {
			res.add(String.valueOf(1));
			res.add(String.valueOf(8));
			res.add(String.valueOf(0));
			return res;
		}

		List<String> prev = helper(n - 2, m);

		for (String p : prev) {
			if (n != m) {
				res.add("0" + p + "0");
			}
			res.add("1" + p + "1");
			res.add("8" + p + "8");
			res.add("6" + p + "9");
			res.add("9" + p + "6");					
		}
		return res;
	}

}
