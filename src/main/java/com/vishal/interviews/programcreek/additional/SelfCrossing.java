package com.vishal.interviews.programcreek.additional;

public class SelfCrossing {

	public static void main(String[] args) {

	}
	
	/**
	 1
	  --
	2|  | 0
	  --
	  3
	*/
	
	public boolean isSelfCrossing(int[] x) {
		if (x.length <= 3) {
			return false;
		}

		for (int i = 3; i < x.length; i++) {
			// top i-3, bottom - i-1
			// left i-2 , right i

			// right should be greater than left
			// bottom should be lesser than top
			if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) {
				return true;
			}

			if (i >= 4) {
				// if 1 and 3 are of same length then 4 will start going exactly as 0
				if (x[i - 3] == x[i - 1]) {
					if (x[i] + x[i - 4] >= x[i - 2]) {
						return true;
					}
				}
			}
			
			if(i >= 5){
				// yet to do similar thing for i == 5 as we did for  i = 4
			}
		}

		return false;
	}

}
