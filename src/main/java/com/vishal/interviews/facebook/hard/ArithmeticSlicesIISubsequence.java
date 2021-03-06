package com.vishal.interviews.facebook.hard;

import java.util.*;
/**
 * 446. Arithmetic Slices II - Subsequence
 * 
 * A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequences:

1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
The following sequence is not arithmetic.

1, 1, 2, 5, 7

A zero-indexed array A consisting of N numbers is given. A subsequence slice of that array is any sequence of integers (P0, P1, ..., Pk) such that 0 ≤ P0 < P1 < ... < Pk < N.

A subsequence slice (P0, P1, ..., Pk) of array A is called arithmetic if the sequence A[P0], A[P1], ..., A[Pk-1], A[Pk] is arithmetic. In particular, this means that k ≥ 2.

The function should return the number of arithmetic subsequence slices in the array A.

The input contains N integers. Every integer is in the range of -231 and 231-1 and 0 ≤ N ≤ 1000. The output is guaranteed to be less than 231-1.


Example:

Input: [2, 4, 6, 8, 10]

Output: 7

Explanation:
All arithmetic subsequence slices are:
[2,4,6]
[4,6,8]
[6,8,10]
[2,4,6,8]
[4,6,8,10]
[2,4,6,8,10]
[2,6,10]
 *
 */
public class ArithmeticSlicesIISubsequence {

	public static void main(String[] args) {

	}
	
	private int n;
   private int ans;
   private void dfs(int dep, int[] A, List<Long> cur) {
       if (dep == n) {
           if (cur.size() < 3) {
               return;
           }
           long diff = cur.get(1) - cur.get(0);
           for (int i = 1; i < cur.size(); i++) {                
               if (cur.get(i) - cur.get(i - 1) != diff) {
                   return;
               }
           }
           ans ++;
           return;
       }
       dfs(dep + 1, A, cur);
       cur.add((long)A[dep]);
       dfs(dep + 1, A, cur);
       cur.remove((long)A[dep]);
   }
   public int numberOfArithmeticSlicesBruteForce(int[] A) {
       n = A.length;
       ans = 0;
       List<Long> cur = new ArrayList<Long>();
       dfs(0, A, cur);
       return (int)ans;        
   }
   
   /**
    * Approach #2 Dynamic Programming [Accepted]
Intuition

To determine an arithmetic sequence, we need at least two parameters: the first (or last) element of the sequence, and the common difference.

Algorithm

Starting from this point, we can easily figure out that one state representation that may work:

f[i][d] denotes the number of arithmetic subsequences that ends with A[i] and its common difference is d.

Let's try to find the state transitions based on the representation above. Assume we want to append a new element A[i] to existing arithmetic subsequences to form new subsequences. We can append A[i] to an existing arithmetic subsequence, only if the difference between the sequence's last element and A[i] is equal to the sequence's common difference.

Thus, we can define the state transitions for the element A[i] intuitively :

for all j < i, f[i][A[i] - A[j]] += f[j][A[i] - A[j]].

This demonstrates the appending process above to form new arithmetic subsequences.

But here comes the problem. Initially all f[i][d] are set to be 0, but how can we form a new arithmetic subsequence if there are no existing subsequences before?

In the original definition of arithmetic subsequences, the length of the subsequence must be at least 3. This makes it hard to form new subsequences if only two indices i and j are given. How about taking the subsequences of length 2 into account?

We can define weak arithmetic subsequences as follows:

Weak arithmetic subsequences are subsequences that consist of at least two elements and if the difference between any two consecutive elements is the same.

There are two properties of weak arithmetic subsequences that are very useful:

For any pair i, j (i != j), A[i] and A[j] can always form a weak arithmetic subsequence.

If we can append a new element to a weak arithmetic subsequence and keep it arithmetic, then the new subsequence must be an arithmetic subsequence.

The second property is quite trival, because the only difference between arithmetic subsequences and weak arithmetic subsequences is their length.

Thus we can change the state representations accordingly:

f[i][d] denotes the number of weak arithmetic subsequences that ends with A[i] and its common difference is d.

Now the state transitions are quite straightforward:

for all j < i, f[i][A[i] - A[j]] += (f[j][A[i] - A[j]] + 1).

The 1 appears here because of the property one, we can form a new weak arithmetic subsequence for the pair (i, j).

Now the number of all weak arithmetic subsequences is the sum of all f[i][d]. But how can we get the number of arithmetic subsequences that are not weak?

There are two ways:

First, we can count the number of pure weak arithmetic subsequences directly. The pure weak arithmetic subsequences are the arithmetic subsequences of length 2, so the number of pure weak arithmetic subsequences should be equal to the number of pairs (i, j), which is \binom{n}{2} = \frac{n * (n - 1)}{2}.( 
2
n
​	
 )= 
2
n∗(n−1)
​	
 .

Second, for the summation f[i][A[i] - A[j]] += (f[j][A[i] - A[j]] + 1), f[j][A[i] - A[j]] is the number of existing weak arithmetic subsequences, while 1 is the new subsequence built with A[i] and A[j]. Based on property two, when we are appending new elements to existing weak arithmetic subsequences, we are forming arithmetic subsequences. So the first part, f[j][A[i] - A[j]] is the number of new formed arithmetic subsequences, and can be added to the answer.

We can use the following example to illustrate the process:

[1, 1, 2, 3, 4, 5]

We need to count the answer for the above sequence.

For the first element 1, there is no element in front of it, the answer remains 0.

For the second element 1, the element itself with the previous 1 can form a pure weak arithmetic subsequence with common difference 0 : [1, 1].

For the third element 2, it cannot be appended to the only weak arithmetic subsequence [1, 1], so the answer remains 0. Similar to the second element, it can form new weak arithmetic subsequences [1, 2] and [1, 2].

For the forth element 3, if we append it to some arithmetic subsequences ending with 2, these subsequences must have a common difference of 3 - 2 = 1. Indeed there are two: [1, 2] and [1, 2]. So we can append 3 to the end of these subsequences, and the answer is added by 2. Similar to above, it can form new weak arithmetic subsequences [1, 3], [1, 3] and [2, 3].

The other elements are the same, we can view the process in the figure below. The red bracket indicates the weak arithmetic subsequence of length 2, and the black bracket indicates the arithmetic subsequence. The answer should be the total number of black brackets.
    * @param A
    * @return
    */
   public int numberOfArithmeticSlicesDP(int[] A) {
      int n = A.length;
      long ans = 0;
      Map<Integer, Integer>[] cnt = new Map[n];
      for (int i = 0; i < n; i++) {
          cnt[i] = new HashMap<>(i);
          for (int j = 0; j < i; j++) {
              long delta = (long)A[i] - (long)A[j];
              if (delta < Integer.MIN_VALUE || delta > Integer.MAX_VALUE) {
                  continue;
              }
              int diff = (int)delta;
              int sum = cnt[j].getOrDefault(diff, 0);
              int origin = cnt[i].getOrDefault(diff, 0);
              cnt[i].put(diff, origin + sum + 1);
              ans += sum;
          }
      }
      return (int)ans;        
  }

}
