package com.vishal.interviews.programcreek.bitmanipulation;

public class SumofTwoIntegers {

	public static void main(String[] args) {

	}

	/**
	 * Adding bits as below, so to get these values we can use xor
	 * 1 1 -> 0
	 * 1 0 -> 1
	 * 0 1 -> 1
	 * 
	 * Carry will be generated as below, so we can use & to get carry 
	 * However since carry has to be shifted to next bit, we left shift 
	 * 1 1 -> 1
	 * 0 1 -> 0
	 * 1 0 -> 1
	 * 
	 * Since we need to add carry back, it is like another addition. 
	 * So, do the same operation until carry becomes 0
	 */
	public int getSum(int a, int b) {

		if (a == 0) {
			return b;
		}

		if (b == 0) {
			return a;
		}

		while (b != 0) {
			int carry = a & b;
			carry <<= 1; // left shift carry as carry is always added to next left bit
			
			int res = a ^ b;
			
			//add res and carry using same logic
			a = res;
			b = carry;
		}

		return a;
	}

}
