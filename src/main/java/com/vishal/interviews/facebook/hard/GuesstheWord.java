package com.vishal.interviews.facebook.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class GuesstheWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void findSecretWordInitial(String[] wordlist, Master master) {

		List<String> wordList = new ArrayList<>();
		for (String w : wordlist) {
			wordList.add(w);
		}
		Random rand = new Random();
		int x = 0;
		for (int i = 0; i < 10; i++) {
			int guessPos = rand.nextInt(wordList.size());
			String guess = wordlist[guessPos];

			x = master.guess(guess);
			// We found the guess as 6 character matched
			if (x == 6) {
				break;
			}
			List<String> temp = new ArrayList<>();
			for (String w : wordList) {
				if (match(guess, w) == x) {
					temp.add(w);
				}
			}
			wordList = temp;

		}
	}

	public void findSecretWord(String[] wordlist, Master master) {

		List<String> wordList = new ArrayList<>();
		for (String w : wordlist) {
			wordList.add(w);
		}
		
		int x = 0;
		for (int i = 0; i < 10; i++) {
			Map<String, Integer> countMap = new HashMap<>();
			for (String w1 : wordList) {
				for (String w2 : wordList) {
					if (match(w1, w2) == 0) {
						countMap.put(w1, countMap.getOrDefault(w1, 0) + 1);
					}
				}
			}

			Pair pair = new Pair("", Integer.MAX_VALUE);
			for (String w : wordList) {
				if (countMap.getOrDefault(w, 0) < pair.count) {
					pair = new Pair(w, countMap.getOrDefault(w, 0));
				}
			}

			String guess = pair.word;

			x = master.guess(guess);
			// We found the guess as 6 character matched
			if (x == 6) {
				break;
			}
			List<String> temp = new ArrayList<>();
			for (String w : wordList) {
				if (match(guess, w) == x) {
					temp.add(w);
				}
			}
			wordList = temp;
		}
	}

	int match(String a, String b) {
		int matched = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == b.charAt(i)) {
				matched++;
			}
		}
		return matched;
	}

}

class Pair {
	String word;
	int count;

	Pair(String word, int count) {
		this.word = word;
		this.count = count;
	}
}

class Master {
	public int guess(String word) {
		return -1;
	}
}
