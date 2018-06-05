package com.vishal.interviews.topinterviewquestions.easy;

public class SumofTwoIntegers {

	public static void main(String[] args) {

	}

	public int getSum(int a, int b) {
		if (a == 0) {
			return b;
		}

		if (b == 0) {
			return a;
		}
		
		while(b != 0){
			int carry = a & b;
			carry <<= 1;
			int res = a ^ b;
			a = res;
			b = carry;
		}
		
		return a;
	}

}
