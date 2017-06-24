package com.vishal.interviews.leetcodereremaining;

public class ConvertaNumbertoHexadecimal {

	public static void main(String[] args) {

	}

	public String toHex(int num) {

		if (num == 0) {
			return "0";
		}

		char[] arr = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

		StringBuilder sb = new StringBuilder();

		while (num != 0) {
			sb.append(arr[(num & 15)]);

			num >>>= 4;
		}
		return sb.reverse().toString();
	}
}
