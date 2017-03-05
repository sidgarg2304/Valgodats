package com.vishal.interviews.google.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 514. Freedom Trail
 * 
 * In the video game Fallout 4, the quest "Road to Freedom" requires players to reach a metal dial called the "Freedom Trail Ring", and use the dial to spell a specific keyword in order to open the door.

Given a string ring, which represents the code engraved on the outer ring and another string key, which represents the keyword needs to be spelled. You need to find the minimum number of steps in order to spell all the characters in the keyword.

Initially, the first character of the ring is aligned at 12:00 direction. You need to spell all the characters in the string key one by one by rotating the ring clockwise or anticlockwise to make each character of the string key aligned at 12:00 direction and then by pressing the center button. 
At the stage of rotating the ring to spell the key character key[i]:
You can rotate the ring clockwise or anticlockwise one place, which counts as 1 step. The final purpose of the rotation is to align one of the string ring's characters at the 12:00 direction, where this character must equal to the character key[i].
If the character key[i] has been aligned at the 12:00 direction, you need to press the center button to spell, which also counts as 1 step. After the pressing, you could begin to spell the next character in the key (next stage), otherwise, you've finished all the spelling.

Input: ring = "godding", key = "gd"
Output: 4
Explanation:
 For the first key character 'g', since it is already in place, we just need 1 step to spell this character. 
 For the second key character 'd', we need to rotate the ring "godding" anticlockwise by two steps to make it become "ddinggo".
 Also, we need 1 more step for spelling.
 So the final output is 4.
 
 Note:
Length of both ring and key will be in range 1 to 100.
There are only lowercase letters in both strings and might be some duplcate characters in both strings.
It's guaranteed that string key could always be spelled by rotating the string ring.
 */
public class FreedomTrail {

	public static void main(String[] args) {

	}

	public int findRotateStepsDP(String ring, String key) {
		int n = ring.length();
		int m = key.length();
		int[][] dp = new int[m + 1][n];

		for (int i = m - 1; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = 0; k < n; k++) {
					if (ring.charAt(k) == key.charAt(i)) {
						int diff = Math.abs(j - k);
						int step = Math.min(diff, n - diff);
						dp[i][j] = Math.min(dp[i][j], step + dp[i + 1][k]);
					}
				}
			}
		}

		return dp[0][0] + m;
	}
	
	/**
	 * We can further improve the runtime of this DP Solution from O(R * R * K)
	 * to O(R * (26 + K)) = O(RK), where R = |Ring| and K = |Key|. Basically, we
	 * can do the inner-most loop in O(1) time. The idea is that if we are
	 * currently at position i and require the previous char equal to some letter
	 * ch, we just need to check the position (with letter ch) that is closest to
	 * i from its left or right. Thus, at most two positions need to be checked,
	 * instead of the entire ring.
	 * 
	 * Update: The preprocessing of the following code takes O(R^2 * 26) = O(R^2)
	 * time. But I believe there must exist a faster way, and I was just too lazy
	 * to do that...
	 * 
	 * Update: Okay, the preprocessing can be done in O(26 * R) = O(R) time.
	 * 
	 * @param ring
	 * @param key
	 * @return
	 */
	public int findRotateStepsDPSol2(String ring, String key) {
		int R = ring.length(), K = key.length();
		int[][] prev = new int[R][26], next = new int[R][26];
		for (int i = 0; i < R; i++) {
			Arrays.fill(prev[i], -1);
			Arrays.fill(next[i], -1);
			for (int j = (i + 1) % R; j != i; j = (j + 1) % R) {
				int ch = ring.charAt(j) - 'a';
				if (next[i][ch] == -1)
					next[i][ch] = j;
			}
			for (int j = (i - 1 + R) % R; j != i; j = (j - 1 + R) % R) {
				int ch = ring.charAt(j) - 'a';
				if (prev[i][ch] == -1)
					prev[i][ch] = j;
			}
			prev[i][ring.charAt(i) - 'a'] = next[i][ring.charAt(i) - 'a'] = i;
		}

		int[][] f = new int[K][R];
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < K; i++) {
			for (int j = 0; j < R; j++) {
				f[i][j] = Integer.MAX_VALUE / 2;

				if (key.charAt(i) == ring.charAt(j)) {
					if (i == 0)
						f[i][j] = Math.min(f[i][j], dist(0, j, ring.length()));
					else {
						int preKey = key.charAt(i - 1) - 'a';
						f[i][j] = Math.min(f[i][j], f[i - 1][prev[j][preKey]] + dist(prev[j][preKey], j, ring.length()));
						f[i][j] = Math.min(f[i][j], f[i - 1][next[j][preKey]] + dist(next[j][preKey], j, ring.length()));
					}
				}
				if (i == K - 1)
					ans = Math.min(ans, f[i][j]);
			}
		}
		return ans + K;
	}
	
	/**
	 * JAVA DP with explanation The dp is a 2D integer array, with height = the
	 * length of ring, with width = the length of key. So DP[i][j] represents
	 * that if we want to spell the next character key[j], and at the same time
	 * the 12:00 aligns with the ring[i], then what is the minimum steps to spell
	 * the whole key start at key[j]. If we finish the DP array, then the answer
	 * is just DP[0][0], which means the minimum steps to spell the whole key
	 * start at key[0], if currently 12:00 aligns with the ring[0], and this is
	 * exactly the original problem. And don't forget to plus the length of key,
	 * which is the steps we need to push the button.
	 * 
	 * @param ring
	 * @param key
	 * @return
	 */
	public int findRotateStepsDPRecursive(String ring, String key) {
		int[][] dp = new int[ring.length()][key.length()];
		for (int[] line : dp)
			Arrays.fill(line, -1);

		return helper(ring, 0, key, 0, dp) + key.length();
	}

	public int helper(String ring, int rIndex, String key, int kIndex, int[][] dp) {
		if (kIndex == key.length())
			return 0;
		if (dp[rIndex][kIndex] != -1)
			return dp[rIndex][kIndex];

		char dest = key.charAt(kIndex);

		int nextIndex = ring.indexOf(dest);
		int sol = Integer.MAX_VALUE;
		do {
			int move = Math.min(Math.abs(rIndex - nextIndex), ring.length() - Math.abs(rIndex - nextIndex));
			int remain = helper(ring, nextIndex, key, kIndex + 1, dp);
			sol = Math.min(sol, move + remain);
			nextIndex = ring.indexOf(dest, nextIndex + 1);
		} while (nextIndex != -1);
		dp[rIndex][kIndex] = sol;
		return sol;
	}
	
	/**
	 * added this method for just compilation
	 * figure out actual method
	 * @param val
	 * @param i
	 * @param j
	 * @return
	 */
	int dist(int val, int i, int j){
		return 1;
	}
	
	/**
	 * An O(26R) = O(R)-time preprocessing.

int R = ring.length(), K = key.length();
int[][] prev = new int[R][26], next = new int[R][26];
Map<Character, List<Integer>> map = new HashMap<>();
for (int i = 0; i < ring.length(); i++) {
    char ch = ring.charAt(i);
    map.putIfAbsent(ch, new ArrayList<>());
    map.get(ch).add(i);
}
for (char ch : map.keySet()) {
    List<Integer> list = map.get(ch);
    for (int i = 0, ptr = 0; i < ring.length(); i++) {
        next[i][ch - 'a'] = list.get(ptr);
        prev[i][ch - 'a'] = list.get((ptr - 1 + list.size()) % list.size());
        if (ring.charAt(i) == ch) ptr = (ptr + 1) % list.size();
    }
}
	 */

}

/**
 * Java Clear Solution, dfs+memoization Hi There! The key point in the problem
 * is to make decision whether to move clockwise or anticlockwise. Actually to
 * get optimal answer, we have to move clockwise for some characters of key and
 * anti-clockwise for others. If apply brute force, then for each position in
 * key we have two options,
 * 
 * Search for the character clockwise Search for the character anti-clockwise To
 * find optimal answer we need to try both options and get minimum of them.
 * Thus, we obtain dfs solution for the problem. But, there are duplicate
 * calculation for some positions. Therefore, we need to memorize states. The
 * state is defined by position of thering and the index of character in the
 * key. This way, we can avoid calculating number of steps for the same state.
 * Code will clarify the idea more.
 */
class FreedomTrailDFSSolution {
	Map<String, Map<Integer, Integer>> memo;

	public int findRotateSteps(String ring, String key) {
		memo = new HashMap<>();
		return dfs(ring, key, 0);
	}

	private int findPos(String ring, char ch) { // find first occurrence
															  // clockwise
		return ring.indexOf(ch);
	}

	private int findBackPos(String ring, char ch) { // find first occurrence
																	// anti-clockwise
		if (ring.charAt(0) == ch)
			return 0;
		for (int i = ring.length() - 1; i > 0; i--) {
			if (ring.charAt(i) == ch)
				return i;
		}
		return 0;
	}

	private int dfs(String ring, String key, int i) {
		if (i == key.length())
			return 0;
		int res = 0;
		char ch = key.charAt(i);
		if (memo.containsKey(ring) && memo.get(ring).containsKey(i))
			return memo.get(ring).get(i);
		int f = findPos(ring, ch);
		int b = findBackPos(ring, ch);
		int forward = 1 + f + dfs(ring.substring(f) + ring.substring(0, f), key, i + 1);
		int back = 1 + ring.length() - b + dfs(ring.substring(b) + ring.substring(0, b), key, i + 1);
		res = Math.min(forward, back);
		Map<Integer, Integer> ans = memo.getOrDefault(ring, new HashMap<>());
		ans.put(i, res);
		memo.put(ring, ans);
		return res;
	}
}