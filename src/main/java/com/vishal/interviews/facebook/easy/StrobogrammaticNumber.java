package com.vishal.interviews.facebook.easy;

import java.util.*;

public class StrobogrammaticNumber {

	public static void main(String[] args) {

	}

	public boolean isStrobogrammatic(String num) {

		if(num == null || num.length() == 0){
			return true;
		}
		int i = 0;
		int j = num.length() - 1;
		while (i <= j) {
			char l = num.charAt(i);
			char r = num.charAt(j);

			if (l == r) {
				if (l != '0' && l != '8' && l != '1') {
					return false;
				}
			} else {
				if (!(l == '6' && r == '9') && !(l == '9' && r == '6')) {
					return false;
				}
			}
			i++;
			j--;
		}
		return true;
	}

}
