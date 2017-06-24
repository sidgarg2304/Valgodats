package com.vishal.interviews.programcreek.bitmanipulation;

public class BitwiseANDofNumbersRange {

	public static void main(String[] args) {

		System.out.println(rangeBitwiseAnd(7, 9));
				
	}

	public static int rangeBitwiseAnd(int m, int n) {
		if (m == 0) {
			return 0;
		}
		int count = 0;
		while (m != n) {
			m >>= 1;
			n >>= 1;
			count++;
		}		
		
		return m << count;
	}

}
