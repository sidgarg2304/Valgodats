package com.vishal.interviews.facebook.medium;

public class UTF8Validation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean validUtf8(int[] data) {

		if (data == null || data.length == 0) {
			return false;
		}
		int bitCount = 0;
		for (int n : data) {
			if (n >= 192) {

				if (bitCount > 0) {
					return false;
				}

				if (n > 247) {
					return false;
				}

				if (n >= 240) {
					bitCount = 3;
				} else if (n >= 224) {
					bitCount = 2;
				} else {
					bitCount = 1;
				}
			} else if (n >= 128) {
				bitCount--;
				if (bitCount < 0) {
					return false;
				}
			} else {
				if (bitCount > 0) {
					return false;
				}
			}
		}
		return bitCount == 0;

	}

}
