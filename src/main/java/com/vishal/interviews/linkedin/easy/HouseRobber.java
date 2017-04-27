package com.vishal.interviews.linkedin.easy;

public class HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int rob(int[] houses) {

		if (houses == null || houses.length == 0) {
			return 0;

		}
		
		int rob = 0;
		int notRob = 0;

		for (int i = 0; i < houses.length; i++) {
			int curRob = notRob + houses[i];
			notRob = Math.max(notRob, rob);
			rob = curRob;
		}
		
		return Math.max(rob, notRob);
	}

}
