package com.vishal.interviews.programcreek;

import java.util.*;

public class FlipGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> generatePossibleNextMoves(String s) {

		List<String> res = new ArrayList<>();
		char[] arr = s.toCharArray();
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == '+' && arr[i - 1] == '+') {
				arr[i] = '-';
				arr[i - 1] = '-';
				res.add(String.valueOf(arr));
				arr[i] = '+';
				arr[i - 1] = '+';
			}
		}

		return res;
	}

}
