package com.vishal.interviews.leetcodereremaining;

import java.util.*;
public class Base7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Integer> set = new TreeSet<>();
		
	}

	public String convertToBase7(int num) {

		if (num == 0) {
			return "0";
		}

		StringBuilder sb = new StringBuilder();
		boolean neg = false;
		if (num < 0) {
			neg = true;
			num = -num;
		}

		while (num > 0) {
			sb.append(num % 7);
			num /= 7;
		}
		if (neg) {
			sb.append("-");
		}

		return sb.reverse().toString();

	}

}
