package com.vishal.interviews.google.hard;

import java.util.*;
/**
 * 864. Random Pick with Blacklist

Given a blacklist B containing unique integers from [0, N), write a function to return a uniform random integer from [0, N) which is NOT in B.

Optimize it such that it minimizes the call to system’s Math.random().

Note:

1 <= N <= 1000000000
0 <= B.length < min(100000, N)
[0, N) does NOT include N. See interval notation.
Example 1:

Input: 
["Solution","pick","pick","pick"]
[[1,[]],[],[],[]]
Output: [null,0,0,0]
Example 2:

Input: 
["Solution","pick","pick","pick"]
[[2,[]],[],[],[]]
Output: [null,1,1,1]
Example 3:

Input: 
["Solution","pick","pick","pick"]
[[3,[1]],[],[],[]]
Output: [null,0,0,2]
Example 4:

Input: 
["Solution","pick","pick","pick"]
[[4,[2]],[],[],[]]
Output: [null,1,3,1]
Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. Solution's constructor has two arguments, N and the blacklist B. pick has no arguments. Arguments are always wrapped with a list, even if there aren't any.


 *
 */
public class RandomPickwithBlacklist {

	public static void main(String[] args) {

	}
	
	/**
	 * Approach 1: Whitelist
Intuition

The problem is trivial if we have a whitelist.

Algorithm

Create a whitelist by initializing a HashSet with all numbers [0, N)[0,N), removing all blacklisted numbers, and then storing the remaining numbers into a list.

Complexity Analysis

Time Complexity: O(N)O(N) preprocessing. O(1)O(1) pick. Preprocessing is too slow to pass the time limit.
Space Complexity: O(N)O(N). MLE (Memory Limit Exceeded) will occur.
	 */
	List<Integer> w;
   Random r;

   public RandomPickwithBlacklist(int n, int[] b) {
       w = new ArrayList<>();
       r = new Random();
       Set<Integer> W = new HashSet<>();
       for (int i = 0; i < n; i++) W.add(i);
       for (int x : b) W.remove(x);
       for (int x : W) w.add(x);
   }

   public int pick() {
       return w.get(r.nextInt(w.size()));
   }

}

/**
 * Approach 2: Binary Search over Blacklist
Intuition

Given a sorted blacklist, we can quickly find the gap between the blacklist numbers where the k-th largest whitelist number would be located. This makes it easy to compute the k-th largest whitelist number.

Algorithm

Lets say that we are given a non-empty blacklist BB and need to figure out what the k-th zero-based largest whitelist number, hereafter called W[k]W[k], is.

First, sort the blacklist.

Then, use binary search to find the largest blacklist number which is smaller than W[k]W[k].

Initially, the search space is the entire blacklist, so \text{lo} = 0lo=0 and \text{hi} = \text{len}(B)-1hi=len(B)−1.

Loop while \text{lo} \neq \text{hi}lo≠hi:

\text{mid} = \frac{\text{lo} + \text{hi} + 1}{2}mid=
​2
​
​lo+hi+1
​​ 
c = B[\text{mid}]-\text{mid}c=B[mid]−mid, the number of whitelist numbers less than B[\text{mid}]B[mid].
If c > kc>k, then B[\text{mid}]B[mid] is larger than W[k]W[k]. B[\text{mid}]B[mid] and larger blacklist numbers are no longer candidates, so \text{hi} = \text{mid}-1hi=mid−1.
If c \leq kc≤k, then B[\text{mid}]B[mid] is smaller than W[k]W[k]. Blacklist numbers smaller than B[\text{mid}]B[mid] are no longer candidates, so \text{lo} = \text{mid}lo=mid.
At termination, the search space will narrow down to one blacklist number. If it is smaller than W[k]W[k], it is the largest blacklist number smaller than W[k]W[k]. In this case, the equation for W[k]W[k] is k + \text{lo} + 1k+lo+1. If it is larger than W[k]W[k], no blacklist number is smaller than W[k]W[k], so W[k]W[k] is simply kk.

Lastly, to get random whitelist number, randomly pick kk in [0, N-\text{len}(B))[0,N−len(B)).


Complexity Analysis

Time Complexity: O(B\text{log}B)O(BlogB) preprocessing. O(\text{log}B)O(logB) pick.
Space Complexity: O(B)O(B). Or O(1)O(1) if in-place sort is used and input array is not considered extra space.
 *
 */
class RandomPickwithBlacklistSolution2 {

   int n;
   int[] b;
   Random r;

   public RandomPickwithBlacklistSolution2(int N, int[] blacklist) {
       n = N;
       Arrays.sort(blacklist);
       b = blacklist;
       r = new Random();
   }

   public int pick() {
       int k = r.nextInt(n - b.length);
       int lo = 0;
		int hi = b.length - 1;

		while (lo < hi) {
			int i = (lo + hi + 1) / 2;
			if (b[i] - i > k) hi = i - 1;
			else lo = i;
		}
		return lo == hi && b[lo] - lo <= k ? k + lo + 1 : k;
   }
}

/**
 * Approach 3: Virtual Whitelist
Intuition

Re-map all blacklist numbers in [0, N-\text{len}(B))[0,N−len(B)) to whitelist numbers such that when we randomly pick a number from [0, N-\text{len}(B))[0,N−len(B)), we actually randomly pick amongst all whitelist numbers.

For example, for N = 6N=6 and B = [0, 2, 3]B=[0,2,3] a remapping could look like this:


Algorithm

Split BB into two blacklists, XX and YY, such that XX contains all blacklist numbers less than N-\text{len}(B)N−len(B) and YY contains the rest.

Use YY to create WW, a list of all whitelist numbers in [N-\text{len(B)}, N)[N−len(B),N). Approach 1 describes an efficient way to create this whitelist.

Define a HashMap MM, where M[i] = iM[i]=i by default (when there is nothing assigned to M[i]M[i] yet), but M[i]M[i] can also be assigned some other value.

Now, iterate through all numbers in XX, assigning M[X[i]] = W[i]M[X[i]]=W[i]. Note that \text{len}(X) == \text{len}(W)len(X)==len(W).

M[0] ... M[N-\text{len}(B)-1]M[0]...M[N−len(B)−1] now maps to all whitelist numbers, so we can randomly pick in [0, N-\text{len}(B))[0,N−len(B)) to get a random whitelist number.

The implementation below optimizes this algorithm in various ways, but the overall idea remains the same.

Complexity Analysis

Time Complexity: O(B)O(B) preprocessing. O(1)O(1) pick.
Space Complexity: O(B)O(B).
 *
 */
class RandomPickwithBlacklistSolution3 {

   Map<Integer, Integer> m;
   Random r;
   int wlen;

   public RandomPickwithBlacklistSolution3(int n, int[] b) {
       m = new HashMap<>();
       r = new Random();
       wlen = n - b.length;
       Set<Integer> w = new HashSet<>();
       for (int i = wlen; i < n; i++) w.add(i);
       for (int x : b) w.remove(x);
       Iterator<Integer> wi = w.iterator();
       for (int x : b)
           if (x < wlen)
               m.put(x, wi.next());
   }

   public int pick() {
       int k = r.nextInt(wlen);
       return m.getOrDefault(k, k);
   }
}
