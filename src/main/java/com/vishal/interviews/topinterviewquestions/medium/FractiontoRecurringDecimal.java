package com.vishal.interviews.topinterviewquestions.medium;

import java.util.*;

public class FractiontoRecurringDecimal {

	public static void main(String[] args) {

	}

	// 20/3
	// 6.(6)
	public String fractionToDecimal(int numerator, int denominator) {

		boolean neg = ((numerator > 0) ^ (denominator > 0)) ? false : true;

		int num = Math.abs(numerator);
		int den = Math.abs(denominator);

		StringBuilder res = new StringBuilder();

		if (neg) {
			res.append("-");
		}

		int val = num / den;
		int mod = num % den;

		res.append(val);

		if (mod == 0) {
			return res.toString();
		}

		res.append(".");

		Map<Integer, Integer> map = new HashMap<>();
		map.put(mod, res.length());

		while (mod > 0) {
			mod *= 10;
			
			res.append(mod/den);
			
			mod = mod % den;
			if (map.containsKey(val)) {
				res.insert(map.get(val), "(");
				res.append(")");
				break;
			}
			map.put(mod, res.length());
		}

		return res.toString();
	}

}
