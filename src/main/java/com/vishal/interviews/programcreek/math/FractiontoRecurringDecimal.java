package com.vishal.interviews.programcreek.math;

import java.util.*;

public class FractiontoRecurringDecimal {

	public static void main(String[] args) {

	}

	// 20/6 = 3.(3)
	//
	public String fractionToDecimal(int numerator, int denominator) {

		StringBuilder sb = new StringBuilder();

		sb.append((numerator > 0) ^ (denominator > 0) ? "-" : "");		

		int num = Math.abs(numerator);
		int den = Math.abs(denominator);

		int val = num / den;
		sb.append(val);

		if (num % den == 0) {
			return sb.toString();
		}
		
		sb.append(".");

		int n = num % den;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(n, sb.length() - 1);

		while (n > 0) {
			n *= 10;
			int v = n / den;
			n = n % den;

			sb.append(v);
			if (map.containsKey(n)) {
				sb.insert(map.get(n), "(");
				sb.append(")");
				break;
			}

			map.put(n, sb.length() - 1);
		}

		return sb.toString();
	}

}
