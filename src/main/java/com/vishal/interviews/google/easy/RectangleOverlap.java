package com.vishal.interviews.google.easy;

public class RectangleOverlap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

		return rec2[0] < rec1[2] && rec2[1] < rec1[3] && rec1[0] < rec2[2] && rec1[1] < rec2[3];
	}

}
