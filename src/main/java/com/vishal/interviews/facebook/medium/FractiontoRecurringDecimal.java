package com.vishal.interviews.facebook.medium;

import java.util.*;
public class FractiontoRecurringDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String fractionToDecimal(int numerator, int denominator) {
      
      if(numerator == 0){
			return "0";
		}
      
      boolean neg = numerator < 0 ^ denominator < 0;

		long num = Math.abs((long)numerator);
		long den = Math.abs((long)denominator);

		StringBuilder res = new StringBuilder();
		if (neg) {
			res.append("-");
		}
		res.append(num / den);
		if (num % den == 0) {
			return res.toString();
		}
		res.append(".");
		Map<Long, Integer> map = new HashMap<>();
		long n = num % den;
		map.put(n, res.length());

		while (n > 0) {
			n *= 10;
			res.append(n / den);
			n = n % den;

			if (map.containsKey(n)) {
				res.insert(map.get(n), "(");
				res.append(")");
				break;
			}
			map.put(n, res.length());
		}

		return res.toString();
  }

}
