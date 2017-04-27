package com.vishal.interviews.google.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 544. Output Contest Matches
 * 
 * During the NBA playoffs, we always arrange the rather strong team to play with the rather weak team, like make the rank 1 team play with the rank nth team, which is a good strategy to make the contest more interesting. Now, you're given n teams, you need to output their final contest matches in the form of a string.

The n teams are given in the form of positive integers from 1 to n, which represents their initial rank. (Rank 1 is the strongest team and Rank n is the weakest team.) We'll use parentheses('(', ')') and commas(',') to represent the contest team pairing - parentheses('(' , ')') for pairing and commas(',') for partition. During the pairing process in each round, you always need to follow the strategy of making the rather strong one pair with the rather weak one.

Example 1:
Input: 2
Output: (1,2)
Explanation: 
Initially, we have the team 1 and the team 2, placed like: 1,2.
Then we pair the team (1,2) together with '(', ')' and ',', which is the final answer.
Example 2:
Input: 4
Output: ((1,4),(2,3))
Explanation: 
In the first round, we pair the team 1 and 4, the team 2 and 3 together, as we need to make the strong team and weak team together.
And we got (1,4),(2,3).
In the second round, the winners of (1,4) and (2,3) need to play again to generate the final winner, so you need to add the paratheses outside them.
And we got the final answer ((1,4),(2,3)).
Example 3:
Input: 8
Output: (((1,8),(4,5)),((2,7),(3,6)))
Explanation: 
First round: (1,8),(2,7),(3,6),(4,5)
Second round: ((1,8),(4,5)),((2,7),(3,6))
Third round: (((1,8),(4,5)),((2,7),(3,6)))
Since the third round will generate the final winner, you need to output the answer (((1,8),(4,5)),((2,7),(3,6))).
Note:
The n is in range [2, 212].
We ensure that the input n can be converted into the form 2k, where k is a positive integer.
 *
 */
public class OutputContestMatches {

	public static void main(String[] args) {

	}

	/**
	 * Java 10 lines
	 * 
	 * @param n
	 * @return
	 */
	public String findContestMatchSimple(int n) {
		List<String> matches = new ArrayList<>();
		for (int i = 1; i <= n; i++)
			matches.add(String.valueOf(i));

		while (matches.size() != 1) {
			List<String> newRound = new ArrayList<>();
			for (int i = 0; i < matches.size() / 2; i++)
				newRound.add("(" + matches.get(i) + "," + matches.get(matches.size() - i - 1) + ")");
			matches = newRound;
		}
		return matches.get(0);
	}

	public String findContestMatchClean(int n) {
		String[] m = new String[n];
		for (int i = 0; i < n; i++) {
			m[i] = String.valueOf(i + 1);
		}

		while (n > 1) {
			for (int i = 0; i < n / 2; i++) {
				m[i] = "(" + m[i] + "," + m[n - 1 - i] + ")";
			}
			n /= 2;
		}

		return m[0];
	}

	/**
	 * It is obvious that the Matching Pattern is Strongest v.s. Weakest. Thus we
	 * keep create Matching Group until there is only 1 group left.
	 * 
	 * @param n
	 * @return
	 */
	public String findContestMatch(int n) {
		LinkedList<String> res = new LinkedList<>();

		for (int i = 1; i <= n; i++)
			res.add(i + "");

		while (res.size() > 1) {
			LinkedList<String> tmp = new LinkedList<>();

			while (!res.isEmpty()) {
				tmp.add("(" + res.remove(0) + "," + res.remove(res.size() - 1) + ")");
			}

			res = tmp;
		}

		return res.get(0);
	}
}