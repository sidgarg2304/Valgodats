package com.vishal.interviews.google.easy;

import java.util.*;

/**
 * 830. Positions of Large Groups
 * 
 * 
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.

For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".

Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.

The final answer should be in lexicographic order.

 

Example 1:

Input: "abbxxxxzzy"
Output: [[3,6]]
Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
Example 2:

Input: "abc"
Output: []
Explanation: We have "a","b" and "c" but no large group.
Example 3:

Input: "abcdddeeeeaabbbcd"
Output: [[3,5],[6,9],[12,14]]
 *
 */
public class PositionsofLargeGroups {

	public static void main(String[] args) {

	}
	
	/**
	 * Approach #1: Two Pointer [Accepted]
Intuition

We scan through the string to identify the start and end of each group. If the size of the group is at least 3, we add it to the answer.

Algorithm

Maintain pointers i, j with i <= j. The i pointer will represent the start of the current group, and we will increment j forward until it reaches the end of the group.

We know that we have reached the end of the group when j is at the end of the string, or S[j] != S[j+1]. At this point, we have some group [i, j]; and after, we will update i = j+1, the start of the next group.
Complexity Analysis

Time Complexity: O(N)O(N), where NN is the length of S.

Space Complexity: O(N)O(N), the space used by the answer.
	 */
	public List<List<Integer>> largeGroupPositions(String S) {
      List<List<Integer>> ans = new ArrayList();
      int i = 0, N = S.length(); // i is the start of each group
      for (int j = 0; j < N; ++j) {
          if (j == N-1 || S.charAt(j) != S.charAt(j+1)) {
              // Here, [i, j] represents a group.
              if (j-i+1 >= 3)
                  ans.add(Arrays.asList(new Integer[]{i, j}));
              i = j + 1;
          }
      }

      return ans;
  }

}
