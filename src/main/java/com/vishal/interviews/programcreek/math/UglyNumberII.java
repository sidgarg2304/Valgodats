package com.vishal.interviews.programcreek.math;

public class UglyNumberII {

	public static void main(String[] args) {

	}

	public int nthUglyNumber(int n) {
		
		if(n <=  0){
			return 0;
		}

		int[] ugly = new int[n];

		ugly[0] = 1;
		int val2 = 2;
		int index2 = 1;

		int val3 = 3;
		int index3 = 1;

		int val5 = 5;
		int index5 = 1;

		for (int i = 1; i < n; i++) {
			ugly[i] = Math.min(val5, Math.min(val2, val3));

			if (val2 == ugly[i]) {
				val2 = 2 * ugly[++index2];
			} else if (val3 == ugly[i]) {
				val2 = 3 * ugly[++index3];
			} else if (val5 == ugly[i]) {
				val2 = 5 * ugly[++index5];
			}
		}
		return ugly[n - 1];
	}

}
