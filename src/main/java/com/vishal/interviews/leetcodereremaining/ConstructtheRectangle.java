package com.vishal.interviews.leetcodereremaining;

public class ConstructtheRectangle {

	public static void main(String[] args) {

	}

	public int[] constructRectangle(int area) {

		int w = (int) Math.sqrt(area);
		while (area % w != 0) {
			w--;
		}

		return new int[] { area / w, w };
	}

}
