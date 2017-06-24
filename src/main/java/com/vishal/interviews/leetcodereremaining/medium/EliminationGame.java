package com.vishal.interviews.leetcodereremaining.medium;

public class EliminationGame {

	public static void main(String[] args) {

	}

	public int lastRemaining(int n) {

		boolean left = true;
		int remaining = n;
		int step = 1;
		int head = 1;
		while (remaining > 1) {
			//odd numbers or if we start from left, next head will change
			if (left || remaining % 2 == 1) {
				head += step;
			}
			step *= 2;
			remaining /= 2;
			left = !left;
		}

		return head;
	}

}
