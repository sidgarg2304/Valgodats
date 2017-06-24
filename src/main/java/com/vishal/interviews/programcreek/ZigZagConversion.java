package com.vishal.interviews.programcreek;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * P A H N A P L S I I G Y I R And then read line by line: "PAHNAPLSIIGYIR"
 * Write the a method convert("PAYPALISHIRING", 3) which returns
 * "PAHNAPLSIIGYIR".
 *
 */
public class ZigZagConversion {

	public static void main(String[] args) {

		System.out.println(convert("ABCDEF", 4));
	}

	public static String convert(String s, int numRows) {
		if (numRows == 1)
			return s;

		StringBuilder sb = new StringBuilder();
		int step = 2 * numRows - 2;
		for (int i = 0; i < numRows; i++) {
			if (i == 0 || i == numRows - 1) {
				for (int j = i; j < s.length(); j += step) {
					sb.append(s.charAt(j));
				}
			} else {				
				int step2 = 2 * i;
				int step1 = step - step2;
				boolean flag = true;
				int j = i;
				while (j < s.length()) {
					sb.append(s.charAt(j));
					if (flag) {
						j += step1;
					} else {
						j += step2;
					}
					flag = !flag;
				}
			}
		}
		return sb.toString();
	}

}
