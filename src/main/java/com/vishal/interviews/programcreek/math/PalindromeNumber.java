package com.vishal.interviews.programcreek.math;

public class PalindromeNumber {

	public static void main(String[] args) {

		System.out.println(isPalindrome(1));
	}

	public static boolean isPalindrome(int x) {
		if (x < 0 || (x > 0 && x % 10 == 0)) {
			return false;
		}
		
		int rev = 0;
		while(x > rev){
			rev = rev * 10 + x % 10;
			x /= 10;
		}
		
		
		
		return rev == x || x == rev/10;
	}

}
