package com.vishal.interviews.programcreek.bitmanipulation;

import java.util.*;

public class GrayCode {

	public static void main(String[] args) {

	}

	public List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<>();

		// we need 0 to 3 for n = 2
		// we need 0 to 7 for n = 3
		for (int i = 0; i < (i << n); i++) {
			res.add(i ^ (i >> 1));
		}
		return res;
	}

}
