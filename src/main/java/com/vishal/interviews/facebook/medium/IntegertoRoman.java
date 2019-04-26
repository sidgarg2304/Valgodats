package com.vishal.interviews.facebook.medium;

public class IntegertoRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String intToRoman(int num) {

		String[] M = { "", "M", "MM", "MMM" };
		String[] C = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String[] X = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String[] I = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
		
		// 3549
		return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
	}

}
