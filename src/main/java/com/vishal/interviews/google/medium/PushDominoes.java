package com.vishal.interviews.google.medium;

/**
 * 838. Push Dominoes
 * 
 * There are N dominoes in a line, and we place each domino vertically upright.

In the beginning, we simultaneously push some of the dominoes either to the left or to the right.



After each second, each domino that is falling to the left pushes the adjacent domino on the left.

Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.

When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.

For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.

Given a string "S" representing the initial state. S[i] = 'L', if the i-th domino has been pushed to the left; S[i] = 'R', if the i-th domino has been pushed to the right; S[i] = '.', if the i-th domino has not been pushed.

Return a string representing the final state. 

Example 1:

Input: ".L.R...LR..L.."
Output: "LL.RR.LLRRLL.."
Example 2:

Input: "RR.L"
Output: "RR.L"
Explanation: The first domino expends no additional force on the second domino.
Note:

0 <= N <= 10^5
String dominoes contains only 'L', 'R' and '.'

 *
 */
public class PushDominoes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Approach #1: Adjacent Symbols [Accepted]
Intuition

Between every group of vertical dominoes ('.'), we have up to two non-vertical dominoes bordering this group. Since additional dominoes outside this group do not affect the outcome, we can analyze these situations individually: there are 9 of them (as the border could be empty). Actually, if we border the dominoes by 'L' and 'R', there are only 4 cases. We'll write new letters between these symbols depending on each case.

Algorithm

Continuing our explanation, we analyze cases:

If we have say "A....B", where A = B, then we should write "AAAAAA".

If we have "R....L", then we will write "RRRLLL", or "RRR.LLL" if we have an odd number of dots. If the initial symbols are at positions i and j, we can check our distance k-i and j-k to decide at position k whether to write 'L', 'R', or '.'.

(If we have "L....R" we don't do anything. We can skip this case.)

Complexity Analysis

Time and Space Complexity: O(N)O(N), where NN is the length of dominoes.
	 */
	public String pushDominoes(String dominoes) {
      int N = dominoes.length();
      int[] indexes = new int[N+2];
      char[] symbols = new char[N+2];
      int len = 1;
      indexes[0] = -1;
      symbols[0] = 'L';

      for (int i = 0; i < N; ++i)
          if (dominoes.charAt(i) != '.') {
              indexes[len] = i;
              symbols[len++] = dominoes.charAt(i);
          }

      indexes[len] = N;
      symbols[len++] = 'R';

      char[] ans = dominoes.toCharArray();
      for (int index = 0; index < len - 1; ++index) {
          int i = indexes[index], j = indexes[index+1];
          char x = symbols[index], y = symbols[index+1];
          char write;
          if (x == y) {
              for (int k = i+1; k < j; ++k)
                  ans[k] = x;
          } else if (x > y) { // RL
              for (int k = i+1; k < j; ++k)
                  ans[k] = k-i == j-k ? '.' : k-i < j-k ? 'R' : 'L';
          }
      }

      return String.valueOf(ans);
  }
	
	/**
	 * Approach #2: Calculate Force [Accepted]
Intuition

We can calculate the net force applied on every domino. The forces we care about are how close a domino is to a leftward 'R', and to a rightward 'L': the closer we are, the stronger the force.

Algorithm

Scanning from left to right, our force decays by 1 every iteration, and resets to N if we meet an 'R', so that force[i] is higher (than force[j]) if and only if dominoes[i] is closer (looking leftward) to 'R' (than dominoes[j]).

Similarly, scanning from right to left, we can find the force going rightward (closeness to 'L').

For some domino answer[i], if the forces are equal, then the answer is '.'. Otherwise, the answer is implied by whichever force is stronger.

Complexity Analysis

Time and Space Complexity: O(N)O(N).

	 */
	public String pushDominoes2(String S) {
      char[] A = S.toCharArray();
      int N = A.length;
      int[] forces = new int[N];

      int force = 0;
      for (int i = 0; i < N; ++i) {
          if (A[i] == 'R') force = N;
          else if (A[i] == 'L') force = 0;
          else force = Math.max(force - 1, 0);
          forces[i] += force;
      }

      force = 0;
      for (int i = N-1; i >= 0; --i) {
          if (A[i] == 'L') force = N;
          else if (A[i] == 'R') force = 0;
          else force = Math.max(force - 1, 0);
          forces[i] -= force;
      }

      StringBuilder ans = new StringBuilder();
      for (int f: forces)
          ans.append(f > 0 ? 'R' : f < 0 ? 'L' : '.');
      return ans.toString();
  }
}
