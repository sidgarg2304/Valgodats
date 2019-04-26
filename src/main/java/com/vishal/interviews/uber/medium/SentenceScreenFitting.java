package com.vishal.interviews.uber.medium;

public class SentenceScreenFitting {

	public static void main(String[] args) {

	}

	public int wordsTyping(String[] sentence, int rows, int cols) {

		String s = String.join(" ", sentence) + " ";

		int l = s.length();
		int st = 0;
		for (int i = 0; i < rows; i++) {
			st += cols;

			while (st > 0 && s.charAt(st % l) != ' ') {
				st--;
			}

			st++;
		}
		
		return st / l;
	}

}
