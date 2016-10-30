package com.vishal.algorithms.string;

public class StringAlgorithms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(convertZigZag("paypalishiring", 3));
	}

	/**
	 * p   a   h   n 
	 * a p l s i i g 
	 * y   i   r     
	 * @param s
	 * @param numRows
	 * @return
	 */	  
	public static String convertZigZag(String s, int numRows) {

		StringBuilder res = new StringBuilder();
		int step = 2 * (numRows) - 2;

		for (int i = 0; i < numRows; i++) {
			if (i == 0 || i == numRows - 1) {
				int j = i;
				while (j < s.length()) {
					res.append(s.charAt(j));
					j += step;
				}
			} else {
				int step1 = 2 * (numRows - i) - 2;
				int step2 = step - step1;
				boolean flag = true;
				int j = i;
				while (j < s.length()) {
					res.append(s.charAt(j));
					if (flag) {
						j += step1;
					} else {
						j += step2;
					}
					flag = !flag;

				}

			}
		}
		return res.toString();
	}

	public static int compareVersionNumbers(String version1, String version2) {
		String[] arr1 = version1.split("//.");
		String[] arr2 = version2.split("//.");

		int i = 0;

		while (i < arr1.length || i < arr2.length) {
			if (i < arr1.length && i < arr2.length) {
				if (Integer.valueOf(arr1[i]) < Integer.valueOf(arr2[i])) {
					return -1;
				} else if (Integer.valueOf(arr2[i]) < Integer.valueOf(arr1[i])) {
					return 1;
				}
			} else if (i < arr1.length) {
				if (Integer.valueOf(arr1[i]) != 0) {
					return 1;
				}
			} else {
				if (Integer.valueOf(arr2[i]) != 0) {
					return -11;
				}
			}
			i++;
		}
		return 0;
	}

}
