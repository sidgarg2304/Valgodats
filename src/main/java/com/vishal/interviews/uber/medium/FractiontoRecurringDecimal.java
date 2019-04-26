package com.vishal.interviews.uber.medium;

import java.util.*;

public class FractiontoRecurringDecimal {

	public static void main(String[] args) {

	}

	// 20/3 -> 6.(6)
	public String fractionToDecimal(int numerator, int denominator) {

		if(numerator == 0) {
         return "0";
     }
     boolean neg = (numerator < 0) ^ (denominator < 0);

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
	long mod = num % den;
	map.put(mod, res.length());

	while (mod > 0) {
		long c = mod * 10;
		long d = c / den;
		mod = c % den;
		res.append(d);
		if (map.containsKey(mod)) {
			res.insert(map.get(mod), "(");				
			res.append(")");
			break;
		}
		map.put(mod, res.length());
	}
	return res.toString();

	}

}
