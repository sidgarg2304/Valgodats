package com.vishal.interviews.google.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 293
 * 
 * You are playing the following Flip Game with your friend: Given a string that
 * contains only these two characters: + and -, you and your friend take turns
 * to flip two consecutive "++" into "--". The game ends when a person can no
 * longer make a move and therefore the other person will be the winner.
 * 
 * Write a function to compute all possible states of the string after one valid
 * move.
 * 
 * For example, given s = "++++", after one move, it may become one of the
 * following states: [ "--++", "+--+", "++--" ]
 * 
 * If there is no valid move, return an empty list [].
 * 
 * @author vkotha
 *
 */
public class FlipGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public static List<String> generatePossibleNextMovesSolution1(String s) {
		List<String> list = new ArrayList<>();
		for (int i = -1; (i = s.indexOf("++", i + 1)) >= 0;)
			list.add(s.substring(0, i) + "--" + s.substring(i + 2));
		return list;
	}

	public List<String> generatePossibleNextMovesSolution2(String s) {

		List<String> list = new ArrayList<String>();

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
				list.add(s.substring(0, i - 1) + "--" + s.substring(i + 1, s.length()));
			}
		}

		return list;

	}

	public List<String> generatePossibleNextMovesSolution3Simple(String s) {
		List<String> res = new ArrayList<String>();

		char chs[] = s.toCharArray();
		for (int i = 0; i < s.length() - 1; i++) {
			if (chs[i] == chs[i + 1] && chs[i] == '+') {
				chs[i] = chs[i + 1] = '-';
				res.add(String.valueOf(chs));
				chs[i] = chs[i + 1] = '+';
			}
		}
		return res;
	}
}
