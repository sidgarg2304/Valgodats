package com.vishal.interviews.programcreek.math;

import java.util.*;

public class HappyNumber {

	public static void main(String[] args) {

	}

	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<Integer>();

		while (!set.contains(n)) {
			set.add(n);
			n = getSum(n);

			if (n == 1) {
				return true;
			}
		}

		return false;
	}

	int getSum(int n) {
		int res = 0;
		while (n > 0) {
			int dig = n % 10;
			res += dig * dig;
			n = n / 10;
		}

		return res;
	}

}
