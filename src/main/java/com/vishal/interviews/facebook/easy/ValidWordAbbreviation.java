package com.vishal.interviews.facebook.easy;

public class ValidWordAbbreviation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean validWordAbbreviation(String word, String abbr) {
		int i = 0;
		int j = 0;

		while (i < word.length() && j < abbr.length()) {
			char a = word.charAt(i);
			char b = abbr.charAt(j);
			if (a == b) {
				i++;
				j++;
				continue;
			}
			if(b <= '0' || b > '9'){
				return false;
			}

			int en = j + 1;
			while (en < abbr.length() && Character.isDigit(abbr.charAt(en))) {
				en++;
			}

			int val = Integer.parseInt(abbr.substring(j, en));
			j = en;
			i += val;

		}
		return i == word.length() && j == abbr.length();
	}

}
