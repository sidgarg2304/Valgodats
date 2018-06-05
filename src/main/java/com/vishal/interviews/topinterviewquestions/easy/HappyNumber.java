package com.vishal.interviews.topinterviewquestions.easy;

import java.util.*;

public class HappyNumber {

	public static void main(String[] args) {

	}

	public boolean isHappy(int n) {

		Set<Integer> set = new HashSet<>();
		set.add(n);
		int v = n;
		while (true) {
			v = calc(v);
			if (v == 1) {
				return true;
			}
			if (set.contains(v)) {
				return false;
			}			
			set.add(v);
		}		
	}

	int calc(int n) {
		int res = 0;
		String s = String.valueOf(n);
		for (int i = 0; i < s.length(); i++) {
			int v = s.charAt(i) - '0';
			res += v * v;
		}
		return res;
	}

}
