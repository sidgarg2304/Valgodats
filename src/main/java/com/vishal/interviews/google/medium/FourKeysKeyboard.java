package com.vishal.interviews.google.medium;

/**
 * 651. 4 Keys Keyboard

Imagine you have a special keyboard with the following keys:

Key 1: (A): Print one 'A' on screen.

Key 2: (Ctrl-A): Select the whole screen.

Key 3: (Ctrl-C): Copy selection to buffer.

Key 4: (Ctrl-V): Print buffer on screen appending it after what has already been printed.

Now, you can only press the keyboard for N times (with the above four keys), find out the maximum numbers of 'A' you can print on screen.

Example 1:
Input: N = 3
Output: 3
Explanation: 
We can at most get 3 A's on screen by pressing following key sequence:
A, A, A
Example 2:
Input: N = 7
Output: 9
Explanation: 
We can at most get 9 A's on screen by pressing following key sequence:
A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V
Note:
1 <= N <= 50
Answers will be in the range of 32-bit signed integer.
 *
 */

/**
 * Approach Framework
Explanation

We either press 'A', or press 'CTRL+A', 'CTRL+C', and some number of 'CTRL+V's. Thus, in the context of making N keypresses to write the letter 'A' M times, there are only two types of moves:

Add (1 keypress): Add 1 to M.
Multiply (k+1 keypresses): Multiply M by k, where k >= 2.
In the following explanations, we will reference these as moves.

 *
 */
public class FourKeysKeyboard {

	public static void main(String[] args) {

	}
	
	/**
	 * Approach #1: Dynamic Programming [Accepted]
Intuition and Algorithm

Say best[k] is the largest number of written 'A's possible after k keypresses.

If the last move in some optimal solution of k keypresses was adding, then best[k] = best[k-1] + 1.

Otherwise, if the last move was multiplying, then we multiplied by x, and best[k-(x+1)] = best[k-(x+1)] * x for some x < k-1.

Taking the best of these candidates lets us find best[k] in terms of previous best[j], when j < k.

Complexity Analysis

Time Complexity: O(N^2)O(N
​2
​​ ). We have two nested for-loops, each of which do O(N)O(N) work.

Space Complexity: O(N)O(N), the size of best.
	 */
	 public int maxADP(int N) {
       int[] best = new int[N+1];
       for (int k = 1; k <= N; ++k) {
           best[k] = best[k-1] + 1;
           for (int x = 0; x < k-1; ++x)
               best[k] = Math.max(best[k], best[x] * (k-x-1));
       }
       return best[N];
   }
	 
	 /**
	  * Approach #3: Mathematical [Accepted]
Explanation

As in Approach #2, we never multiply by more than 5.

When N is arbitrarily large, the long run behavior of multiplying by k repeatedly is to get to the value k^{\frac{N}{k+1}}k
​
​k+1
​
​N
​​ 
​​ . Analyzing the function k^{\frac{1}{k+1}}k
​
​k+1
​
​1
​​ 
​​  at values k = 2, 3, 4, 5k=2,3,4,5, it attains a peak at k = 4k=4. Thus, we should expect that eventually, best[K] = best[K-5] * 4.

Now, we need to make a few more deductions.

We never add after multiplying: if we add c after multiplying by k, we should instead multiply by k+c.

We never add after 5: If we add 1 then multiply by k to get to (x+1) * k = xk + k, we could instead multiply by k+1 to get to xk + x. Since k <= 5, we must have x <= 5 for our additions to not be dominated.

The number of multiplications by 2, 3, or 5 is bounded.

Every time we've multiplied by 2 two times, we prefer to multiply by 4 once for less cost. (4^1 for a cost of 5, vs 2^2 for a cost of 6.)

Every time we've multiplied by 3 five times, we prefer to multiply by 4 four times for the same cost but a larger result. (4^4 > 3^5, and cost is 20.)
Every time we've multiplied by 5 five times, we prefer to multiply by 4 six times for the same cost but a larger result. (4^6 > 5^5, and cost is 30.)
Together, this shows there are at most 5 additions and 9 multiplications by a number that isn't 4.

We can find the first 14 operations on 1 by hand: 1, 2, 3, 4, 5, 6, 9, 12, 16, 20, 27, 36, 48, 64, 81. After that, every subsequent number is achieved by multiplying by 4: ie., best[K] = best[K-5] * 4.
	  */
	 public int maxAMathematical(int N) {
       int[] best = new int[]{0, 1, 2, 3, 4, 5, 6, 9, 12,
                              16, 20, 27, 36, 48, 64, 81};
       int q = N > 15 ? (N - 11) / 5 : 0;
       return best[N - 5*q] << 2 * q;
   }

}
