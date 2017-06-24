package com.vishal.interviews.programcreek;

public class CompareVersionNumbers {

	public static void main(String[] args) {

	}

	public int compareVersion(String version1, String version2) {

		String[] arr1 = version1.split("\\.");
		String[] arr2 = version2.split("\\.");

		int i = 0;
		int j = 0;

		while (i < arr1.length || j < arr2.length) {
			Integer v1 = i < arr1.length ? Integer.parseInt(arr1[i]) : 0;
			Integer v2 = j < arr2.length ? Integer.parseInt(arr2[i]) : 0;

			int compare = v1.compareTo(v2);
			if (compare != 0) {
				return compare;
			}
		}

		return 0;
	}

}
