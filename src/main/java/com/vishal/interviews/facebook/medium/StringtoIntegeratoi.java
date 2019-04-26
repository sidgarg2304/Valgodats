package com.vishal.interviews.facebook.medium;

public class StringtoIntegeratoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int myAtoi(String str) {
      if (str == null || str.length() == 0) {
			return 0;
		}

      int i = 0;
      while (i < str.length() && str.charAt(i) == ' ') {
			i++;
		}                
      
		boolean neg =  i < str.length() && str.charAt(i) == '-' ? true : false;
		if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
			i++;
		}		
      
		double res = 0;		
		while (i < str.length()) {
			if (str.charAt(i) < '0' || str.charAt(i) > '9') {
				break;
			}
			int val = str.charAt(i) - '0';
			res = (res * 10) + val;
          i++;
		}        

		if (neg) {
			res *= -1;
		}

		if (res < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}

		if (res > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}

		return (int) res;
  }

}
