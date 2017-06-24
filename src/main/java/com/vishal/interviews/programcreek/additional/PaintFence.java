package com.vishal.interviews.programcreek.additional;

public class PaintFence {

	public static void main(String[] args) {

	}

	public int numWays(int n, int k) {

		if (n == 0 || k == 0) {
			return 0;
		}

		// 1 post - k
		// 2 posts - k + k * k-1
		int sameColors = k;
		int diffColors = k * k - 1;

		for (int i = 2; i <= n; i++) {
			int temp = diffColors;
			diffColors = (sameColors + diffColors) * k - 1;
			sameColors = temp;
		}

		return sameColors + diffColors;
	}

}
