package com.vishal.interviews.facebook.easy;

public class PeakIndexinaMountainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int peakIndexInMountainArray(int[] A) {

		if(A == null || A.length == 0){
			return -1;
		}
		for (int i = 1; i < A.length; i++) {
			if (A[i] < A[i - 1]) {
				return i - 1;
			}
		}
		return -1;
	}

}
