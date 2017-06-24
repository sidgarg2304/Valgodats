package com.vishal.interviews.leetcodereremaining;

public class PerfectNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean checkPerfectNumber(int num) {

		if (num == 1) {
			return false;
		}

		int sum = 0;
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				sum += i;
			}
		}
		return sum == num;
	}
}
