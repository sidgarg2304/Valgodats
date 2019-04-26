package com.vishal.interviews.uber.hard;

public class BasicCalculator {

	public static void main(String[] args) {

	}

	public int calculate(String s) {

		int res = 0;

		if (s == null || s.isEmpty()) {
			return res;
		}

		s = s.replaceAll("\\s+", "");

		int sign = 1;
		int i = 0;
		while (i < s.length()) {
			char c = s.charAt(i);

			if (c == '(') {
				int bracesCnt = 1;
				int en = i + 1;
				while (en < s.length() && bracesCnt > 0) {
					if (s.charAt(en) == '(') {
						bracesCnt++;
					}

					if (s.charAt(en) == ')') {
						bracesCnt--;
					}
					en++;
				}

				int bracesRes = calculate(s.substring(i + 1, en - 1));
				res += bracesRes * sign;
				i = en;
			} else if (Character.isDigit(c)) {
				int en = i;
				int val = 0;
				while (en < s.length() && Character.isDigit(s.charAt(en))) {
					val *= 10;
					val += s.charAt(en) - '0';
					en++;
				}

				res += val * sign;
				i = en;
			} else {
				sign = c == '+' ? 1 : -1;
				i++;
			}
		}
		return res;
	}

}
