package com.vishal.interviews.google.hard;

import java.util.*;
/**
 * 854. K-Similar Strings

Strings A and B are K-similar (for some non-negative integer K) if we can swap the positions of two letters in A exactly K times so that the resulting string equals B.

Given two anagrams A and B, return the smallest K for which A and B are K-similar.

Example 1:

Input: A = "ab", B = "ba"
Output: 1
Example 2:

Input: A = "abc", B = "bca"
Output: 2
Example 3:

Input: A = "abac", B = "baca"
Output: 2
Example 4:

Input: A = "aabc", B = "abca"
Output: 2
Note:

1 <= A.length == B.length <= 20
A and B contain only lowercase letters from the set {'a', 'b', 'c', 'd', 'e', 'f'}
 *
 */
public class KSimilarStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Approach 1: Brute Force with Dynamic Programming
Intuition and Algorithm

Let P_1, P_2, \cdotsP
​1
​​ ,P
​2
​​ ,⋯ be possible cycles of the underlying graph GG. Let's attempt to write G = \sum k_i P_iG=∑k
​i
​​ P
​i
​​  for some constants k_ik
​i
​​ . Then, the number of cycles is \sum k_i∑k
​i
​​ .

We can represent GG and P_iP
​i
​​  as the number of directed edges from node XX to YY. For example, if P_1P
​1
​​  is the cycle a -> b -> d -> e -> a, then P_1P
​1
​​  is a -> b plus b -> d plus d -> e plus e -> a. This can be represented as a column vector possibles[0] of 1s and 0s, with four 1s, (each possibles[0][i] == 1 represents the ith directed edge being there [and having quantity 1]). Similarly, the graph GG can also be represented as a column vector.

This sets the stage for dynamic programming. For each graph GG, represented as a column vector, say we want to find numCycles(G). We can take all possible cycles CC, and check if GG contains CC. If it does, then a candidate answer is 1 + numCycles(G - C).

It should also be noted that maximizing the number of cycles cannot be done in a greedy way, ie. by always removing the lowest size cycle. For example, consider the graph with edges a -> b -> c -> a, b -> d -> e -> b, and c -> e -> f -> c. Those form cycles, and there is a fourth 3-cycle b -> c -> e -> b. If we remove that cycle first, then we would have only two cycles; but if we remove the first 3 cycles, then we would have three cycles.

Complexity Analysis

Time Complexity: O(2^{N+W})O(2
​N+W
​​ ), where NN is the length of the string, and WW is the length of the alphabet.

Space Complexity: O(2^{N+W})O(2
​N+W
​​ ). 
	 */
	String[] alphabet = new String[]{"a", "b", "c", "d", "e", "f"};
   Map<String, Integer> memo;

   public int kSimilarity(String A, String B) {
       if (A.equals(B)) return 0;
       int N = A.length();
       memo = new HashMap();
       int ans = 0;

       int[] count = new int[alphabet.length * alphabet.length];
       for (int i = 0; i < N; ++i)
           if (A.charAt(i) != B.charAt(i)) {
               count[alphabet.length * (A.charAt(i) - 'a') + (B.charAt(i) - 'a')]++;
               ans++;
           }

       List<int[]> possibles = new ArrayList();
       // Enumerate over every cycle
       for (int size = 2; size <= alphabet.length; ++size)
           search: for (String cycle: permutations(alphabet, 0, size)) {
               // Check if cycle is canonical
               for (int i = 1; i < size; ++i)
                   if (cycle.charAt(i) < cycle.charAt(0))
                       continue search;

               // Add count to possibles
               int[] row = new int[count.length];
               for (int i = 0; i < size; ++i) {
                   int u = cycle.charAt(i) - 'a';
                   int v = cycle.charAt((i+1) % size) - 'a';
                   row[alphabet.length * u + v]++;
               }
               possibles.add(row);
           }

       int[] ZERO = new int[count.length];
       memo.put(Arrays.toString(ZERO), 0);
       return ans - numCycles(possibles, count);
   }

   public int numCycles(List<int[]> possibles, int[] count) {
       String countS = Arrays.toString(count);
       if (memo.containsKey(countS)) return memo.get(countS);

       int ans = Integer.MIN_VALUE;
       search: for (int[] row: possibles) {
           int[] count2 = count.clone();
           for (int i = 0; i < row.length; ++i) {
               if (count2[i] >= row[i])
                   count2[i] -= row[i];
               else
                   continue search;
           }
           ans = Math.max(ans, 1 + numCycles(possibles, count2));
       }

       memo.put(countS, ans);
       return ans;
   }

   public List<String> permutations(String[] alphabet, int used, int size) {
       List<String> ans = new ArrayList();
       if (size == 0) {
           ans.add(new String(""));
           return ans;
       }

       for (int b = 0; b < alphabet.length; ++b)
           if (((used >> b) & 1) == 0)
               for (String rest: permutations(alphabet, used | (1 << b), size - 1))
                   ans.add(alphabet[b] + rest);
       return ans;
   }
}

/**
 * Approach 2: Pruned Breadth First Search
Intuition

Based on the underlying graph interpretation of the problem, we can prove that an optimal solution swaps the left-most unmatched character A[i] with an appropriate match A[j] == B[i] (j > i).

This reduces the number of "neighbors" of a node (string state) from O(N^2)O(N
​2
​​ ) to O(N)O(N), but it also focuses our search greatly. Each node searched with k matches, will have at most 2^k2
​k
​​  swaps on the unmatched characters. This leads to \sum_k \binom{N}{k} 2^k = 3^N∑
​k
​​ (
​k
​N
​​ )2
​k
​​ =3
​N
​​  checked states. Furthermore, some characters are the same, so we must divide the number of states by approximate factors of \prod (N_i)!∏(N
​i
​​ )! [where N_iN
​i
​​  is the number of occurrences of the iith character in A.] With N \leq 20N≤20, this means the number of states will be small.

Algorithm

We'll perform a regular breadth-first search. The neighbors to each node string S are all the strings reachable with 1 swap, that match the first unmatched character in S.


Complexity Analysis

Time Complexity: O(\sum_{k=0}^n \binom{N}{k} \frac{\min(2^k, (N-k)!)}{W * (\frac{N-k}{W})!})O(∑
​k=0
​n
​​ (
​k
​N
​​ )
​W∗(
​W
​
​N−k
​​ )!
​
​min(2
​k
​​ ,(N−k)!)
​​ ), where NN is the length of the string, and WW is the length of the alphabet.

Space Complexity: O(N * t)O(N∗t), where tt is the time complexity given above. 
 *
 */
class KSimilarStringsSolution2{
	public int kSimilarity(String A, String B) {
      Queue<String> queue = new ArrayDeque();
      queue.offer(A);

      Map<String, Integer> dist = new HashMap();
      dist.put(A, 0);

      while (!queue.isEmpty()) {
          String S = queue.poll();
          if (S.equals(B)) return dist.get(S);
          for (String T: neighbors(S, B)) {
              if (!dist.containsKey(T)) {
                  dist.put(T, dist.get(S) + 1);
                  queue.offer(T);
              }
          }
      }

      throw null;
  }

  public List<String> neighbors(String S, String target) {
      List<String> ans = new ArrayList();
      int i = 0;
      for (; i < S.length(); ++i) {
          if (S.charAt(i) != target.charAt(i)) break;
      }

      char[] T = S.toCharArray();
      for (int j = i+1; j < S.length(); ++j)
          if (S.charAt(j) == target.charAt(i)) {
              swap(T, i, j);
              ans.add(new String(T));
              swap(T, i, j);
          }

      return ans;
  }

  public void swap(char[] T, int i, int j) {
      char tmp = T[i];
      T[i] = T[j];
      T[j] = tmp;
  }
}
