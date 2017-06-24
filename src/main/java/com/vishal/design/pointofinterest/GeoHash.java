package com.vishal.design.pointofinterest;

public class GeoHash {

	public static void main(String[] args) {

	}

	int generateHash(int lattitude, int longitude, int size) {
		int minLat = -90;
		int maxLat = 90;

		int minLong = -180;
		int maxLong = -180;

		int res = 0;

		for (int i = 0; i < size; i++) {
			if (i % 2 == 0) {
				// long
				int midLong = minLong + (maxLong - minLong) / 2;
				if (longitude < midLong) {
					res <<= 1;
				} else {
					res <<= 1;
					res |= 1;
				}
			} else {
				// lat
				int midLat = minLat + (maxLat - minLat) / 2;
				if (lattitude < midLat) {
					res <<= 1;
				} else {
					res <<= 1;
					res |= 1;
				}
			}
		}
		return res;

	}

}
