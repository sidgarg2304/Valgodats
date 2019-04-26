package com.vishal.interviews.facebook.easy;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String reverseString(String s) {
		if(s == null || s.length() == 0) {
			return s;
		}
		
		char [] arr = s.toCharArray();
		int i = 0;
		int j = s.length()-1;
		while(i < j) {
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		return String.valueOf(arr);
	}

}
