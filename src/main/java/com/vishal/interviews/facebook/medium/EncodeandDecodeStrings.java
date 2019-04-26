package com.vishal.interviews.facebook.medium;

import java.util.*;

public class EncodeandDecodeStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Encodes a list of strings to a single string.
	public String encode(List<String> strs) {

		if (strs == null || strs.isEmpty()) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		for (String s : strs) {
			sb.append(s.replaceAll("#", "##")).append(" # ");
		}
		return sb.toString();
	}

	// Decodes a single string to a list of strings.
	public List<String> decode(String s) {				
		
		List<String> res = new ArrayList<>();
		if (s == null || s.isEmpty()) {
			return res;
		}
		String[] arr = s.split(" # ", -1);

		for(int i = 0; i< arr.length-1; i++) {
			res.add(arr[i].replaceAll("##", "#"));
		}
		return res;
	}

}
