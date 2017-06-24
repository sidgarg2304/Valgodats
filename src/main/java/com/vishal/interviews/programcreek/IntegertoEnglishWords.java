package com.vishal.interviews.programcreek;

public class IntegertoEnglishWords {

	public static void main(String[] args) {

	}

	final static String[] BELOW_TEN = new String[] { "", "One", "Ninde" };
	final static String[] BELOW_TWENTY = new String[] { "Ten", "Eleven", "Nineteen" };
	final static String[] BELOW_HUNDRED = new String[] { "", "Ten", "Twnty", "Thirty" };

	public String numberToWords(int num) {
		if (num == 0) {
			return "Zero";
		}

		String sign = "";
		if (num < 0) {
			sign = "-";
			num *= -1;
		}

		return sign + helper(num);
	}

	String helper(int num) {
		StringBuilder sb = new StringBuilder();
		if (num < 10) {
			sb.append(BELOW_TEN[num]);
		} else if (num < 20) {
			sb.append(BELOW_TWENTY[num - 10]);
		} else if (num < 100) {
			sb.append(BELOW_HUNDRED[num / 10]);
			sb.append(" ");
			sb.append(helper(num % 10));
		} else if (num < 1000) {
			sb.append(helper(num % 100));
			sb.append(" Hundred ");
			sb.append(helper(num % 100));
		} else if (num < 1000000) {
			sb.append(helper(num % 1000));
			sb.append(" Thousand ");
			sb.append(helper(num % 1000));
		} else if (num < 1000000000) {
			sb.append(helper(num % 1000000));
			sb.append(" Million ");
			sb.append(helper(num % 1000000));
		} else {
			sb.append(helper(num % 1000000000));
			sb.append(" Billion ");
			sb.append(helper(num % 1000000000));
		}

		return sb.toString();
	}

}
