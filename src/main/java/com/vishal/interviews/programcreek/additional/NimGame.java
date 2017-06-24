package com.vishal.interviews.programcreek.additional;

public class NimGame {

	public static void main(String[] args) {

	}

	public boolean canWinNim(int n) {

		if (n <= 3) {
			return true;
		}
		
		for (int i = 1; i <= 3; i++) {
			boolean canSecWin = canWinNim(n - i);
			if (!canSecWin) {
				return true;
			}
		}
		return false;
	}

}
