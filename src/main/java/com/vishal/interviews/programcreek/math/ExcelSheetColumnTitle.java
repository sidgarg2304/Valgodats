package com.vishal.interviews.programcreek.math;

public class ExcelSheetColumnTitle {

	public static void main(String[] args) {

		System.out.println(convertToTitle(703));
	}

	public static String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();		

		while (n > 0) {
			n--;
			sb.append((char) ('A' + n % 26));
			n = n / 26;
		}
		return sb.toString();
	}

}
