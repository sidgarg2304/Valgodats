package com.vishal.interviews.leetcodereremaining;

public class NumberComplement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findComplement(int num) {

		int ones = 0;
		int j = 0;
		while(ones < num){
			ones += Math.pow(2, j);
			j++;
		}
		
		return ones - num;
	}

}
