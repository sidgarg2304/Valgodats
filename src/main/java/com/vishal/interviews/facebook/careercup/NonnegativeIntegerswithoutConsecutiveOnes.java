package com.vishal.interviews.facebook.careercup;

import java.util.Arrays;

/**
 * Input: 5
Output: 5
Explanation: 
Here are the non-negative integers <= 5 with their corresponding binary representations:
0 : 0
1 : 1
2 : 10
3 : 11
4 : 100
5 : 101
Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule. 
 */

public class NonnegativeIntegerswithoutConsecutiveOnes {

	public static void main(String[] args) {

		System.out.println(findIntegers(8));
	}
	
	public static int findIntegers(int num) {
      StringBuilder sb = new StringBuilder(Integer.toBinaryString(num)).reverse();
      int n = sb.length();
      
      int a[] = new int[n];
      int b[] = new int[n];
      a[0] = b[0] = 1;
      for (int i = 1; i < n; i++) {
          a[i] = a[i - 1] + b[i - 1];
          b[i] = a[i - 1];
      }
      
      int result = a[n - 1] + b[n - 1];
      System.out.println(Arrays.toString(a));
      System.out.println(Arrays.toString(b));
      System.out.println(sb.toString());
      for (int i = n - 2; i >= 0; i--) {
          if (sb.charAt(i) == '1' && sb.charAt(i + 1) == '1') break;
          if (sb.charAt(i) == '0' && sb.charAt(i + 1) == '0') result -= b[i];
      }
      
      return result;
  }
	
	static int findNumbers(int n){
		int res = 0;
		while(n >= 0){
			if(!hasConsecutiveOnes(n)){
				res++;
			}
			n--;
		}
		
		return res;
	}
	
	static boolean hasConsecutiveOnes(int n){
		return (n << 1 & n) != 0;
	}

}
