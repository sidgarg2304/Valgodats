package com.vishal.interviews.google.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 294. Flip Game II
 * 
 * You are playing the following Flip Game with your friend: Given a string that
 * contains only these two characters: + and -, you and your friend take turns
 * to flip two consecutive "++" into "--". The game ends when a person can no
 * longer make a move and therefore the other person will be the winner.
 * 
 * Write a function to determine if the starting player can guarantee a win.
 * 
 * For example, given s = "++++", return true. The starting player can guarantee
 * a win by flipping the middle "++" to become "+--+".
 * 
 * Follow up:
 * 
 * Derive your algorithm's runtime complexity.
 */
public class FlipGameII {

	public static void main(String[] args) {

	}

	/**
	 * Share my Java backtracking solution
	 * 
	 * The idea is try to replace every "++" in the current string s to "--" and
	 * see if the opponent can win or not, if the opponent cannot win, great, we
	 * win!
	 * 
	 * For the time complexity, here is what I thought, let's say the length of
	 * the input string s is n, there are at most n - 1 ways to replace "++" to
	 * "--" (imagine s is all "+++..."), once we replace one "++", there are at
	 * most (n - 2) - 1 ways to do the replacement, it's a little bit like
	 * solving the N-Queens problem, the time complexity is (n - 1) x (n - 3) x
	 * (n - 5) x ..., so it's O(n!!), double factorial.
	 * 
	 * That's what I thought, but I could be wrong :)
	 * 
	 * @param s
	 * @return
	 */
	public boolean canWin(String s) {
		if (s == null || s.length() < 2) {
			return false;
		}

		for (int i = 0; i < s.length() - 1; i++) {
			if (s.startsWith("++", i)) {
				String t = s.substring(0, i) + "--" + s.substring(i + 2);

				if (!canWin(t)) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Simple backtracking inspired by Flip Game I
	 * 
	 * @param s
	 * @return
	 */
	public boolean canWinSimple(String s) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == '+' && s.charAt(i + 1) == '+')
				list.add(s.substring(0, i) + "--" + s.substring(i + 2, s.length())); // generate
																											// all
																											// possible
																											// sequence
																											// after
																											// every
																											// attempt
		}
		/*
		 * if(list.isEmpty()) return false;
		 */
		for (String str : list) {
			if (!canWin(str)) // if there is any one way the next player can't win,
									// take it and you'll win
				return true;
		}
		return false;
	}

	/**
	 * Java backtracking solution with time optimization through DP(205ms ->
	 * 19ms) Thanks jeantimex for sharing his code and explanation.
	 * 
	 * https://leetcode.com/discuss/64291/share-my-java-backtracking-solution
	 * 
	 * The idea of the solution is clear, but the time complexity of the
	 * backtracking method is high. During the process of searching, we could
	 * encounter duplicate computation as the following simple case.
	 * 
	 * One search path:
	 * 
	 * Input s = "++++++++"
	 * 
	 * Player 0: "--++++++"
	 * 
	 * Player 1: "----++++"
	 * 
	 * Player 0: "----+--+"
	 * 
	 * Player0 can win for the input string as "----++++".
	 * 
	 * Another search path:
	 * 
	 * Player 0: "++--++++"
	 * 
	 * Player 1: "----++++"
	 * 
	 * Player 0: "----+--+"
	 * 
	 * (Duplicate computation happens. We have already known anyone can win for
	 * the
	 * 
	 * input string as "----++++".)
	 * 
	 * Use a HashMap to avoid duplicate computation
	 * 
	 * Key : InputString.
	 * 
	 * Value: can win or not.
	 * 
	 * @param s
	 * @return
	 */
	public boolean canWinBackTrackingDP(String s) {
		if (s == null || s.length() < 2) {
			return false;
		}
		HashMap<String, Boolean> winMap = new HashMap<String, Boolean>();
		return helper(s, winMap);
	}

	public boolean helper(String s, HashMap<String, Boolean> winMap) {
		if (winMap.containsKey(s)) {
			return winMap.get(s);
		}
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.startsWith("++", i)) {
				String t = s.substring(0, i) + "--" + s.substring(i + 2);
				if (!helper(t, winMap)) {
					winMap.put(s, true);
					return true;
				}
			}
		}
		winMap.put(s, false);
		return false;
	}

}
