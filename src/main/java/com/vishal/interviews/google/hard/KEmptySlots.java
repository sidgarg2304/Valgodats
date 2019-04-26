package com.vishal.interviews.google.hard;

import java.util.*;
/**
 * 683. K Empty Slots

There is a garden with N slots. In each slot, there is a flower. The N flowers will bloom one by one in N days. In each day, there will be exactly one flower blooming and it will be in the status of blooming since then.

Given an array flowers consists of number from 1 to N. Each number in the array represents the place where the flower will open in that day.

For example, flowers[i] = x means that the unique flower that blooms at day i will be at position x, where i and x will be in the range from 1 to N.

Also given an integer k, you need to output in which day there exists two flowers in the status of blooming, and also the number of flowers between them is k and these flowers are not blooming.

If there isn't such day, output -1.

Example 1:
Input: 
flowers: [1,3,2]
k: 1
Output: 2
Explanation: In the second day, the first and the third flower have become blooming.
Example 2:
Input: 
flowers: [1,2,3]
k: 1
Output: -1
Note:
The given array will be in the range [1, 20000].

 *
 */
public class KEmptySlots {

	public static void main(String[] args) {

	}
	
	/**
	 * Approach #1: Insert Into Sorted Structure [Accepted]
Intuition

Let's add flowers in the order they bloom. When each flower blooms, we check it's neighbors to see if they can satisfy the condition with the current flower.

Algorithm

We'll maintain active, a sorted data structure containing every flower that has currently bloomed. When we add a flower to active, we should check it's lower and higher neighbors. If some neighbor satisfies the condition, we know the condition occurred first on this day.

Complexity Analysis

Time Complexity (Java): O(N \log N)O(NlogN), where NN is the length of flowers. Every insertion and search is O(\log N)O(logN).

Time Complexity (Python): O(N^2)O(N
​2
​​ ). As above, except list.insert is O(N)O(N).

Space Complexity: O(N)O(N), the size of active.
	 */
	public int kEmptySlots(int[] flowers, int k) {
      TreeSet<Integer> active = new TreeSet();
      int day = 0;
      for (int flower: flowers) {
          day++;
          active.add(flower);
          Integer lower = active.lower(flower);
          Integer higher = active.higher(flower);
          if (lower != null && flower - lower - 1 == k ||
                  higher != null && higher - flower - 1 == k)
              return day;
      }
      return -1;
  }
	
	/**
	 * Approach #3: Sliding Window [Accepted]
Intuition

As in Approach #2, we have days[x] = i for the time that the flower at position x blooms. We wanted to find candidate intervals [left, right] where days[left], days[right] are the two smallest values in [days[left], days[left+1], ..., days[right]], and right - left = k + 1.

Notice that these candidate intervals cannot intersect: for example, if the candidate intervals are [left1, right1] and [left2, right2] with left1 < left2 < right1 < right2, then for the first interval to be a candidate, days[left2] > days[right1]; and for the second interval to be a candidate, days[right1] > days[left2], a contradiction.

That means whenever whether some interval can be a candidate and it fails first at i, indices j < i can't be the start of a candidate interval. This motivates a sliding window approach.

Algorithm

As in Approach #2, we construct days.

Then, for each interval [left, right] (starting with the first available one), we'll check whether it is a candidate: whether days[i] > days[left] and days[i] > days[right] for left < i < right.

If we fail, then we've found some new minimum days[i] and we should check the new interval [i, i+k+1]. If we succeed, then it's a candidate answer, and we'll check the new interval [right, right+k+1].


Complexity Analysis

Time and Space Complexity: O(N)O(N). The analysis is the same as in Approach #2.	 */
	public int kEmptySlotsSlidingWindow(int[] flowers, int k) {
      int[] days = new int[flowers.length];
      for (int i = 0; i < flowers.length; i++) {
          days[flowers[i] - 1] = i + 1;
      }

      int ans = Integer.MAX_VALUE;
      int left = 0, right = k+1;

      search: while (right < days.length) {
          for (int i = left+1; i < right; ++i) {
              if (days[i] < days[left] || days[i] < days[right]) {
                  left = i;
                  right = i + k + 1;
                  continue search;
              }
          }
          ans = Math.min(ans, Math.max(days[left], days[right]));
          left = right;
          right = left + k + 1;
      }

      return ans < Integer.MAX_VALUE ? ans : -1;
  }

	/**
	 * Approach #2: Min Queue [Accepted]
Intuition

For each contiguous block ("window") of k positions in the flower bed, we know it satisfies the condition in the problem statement if the minimum blooming date of this window is larger than the blooming date of the left and right neighbors.

Because these windows overlap, we can calculate these minimum queries more efficiently using a sliding window structure.

Algorithm

Let days[x] = i be the time that the flower at position x blooms. For each window of k days, let's query the minimum of this window in (amortized) constant time using a MinQueue, a data structure built just for this task. If this minimum is larger than it's two neighbors, then we know this is a place where "k empty slots" occurs, and we record this candidate answer.

To operate a MinQueue, the key invariant is that mins will be an increasing list of candidate answers to the query MinQueue.min.

For example, if our queue is [1, 3, 6, 2, 4, 8], then mins will be [1, 2, 4, 8]. As we MinQueue.popleft, mins will become [2, 4, 8], then after 3 more popleft's will become [4, 8], then after 1 more popleft will become [8].

As we MinQueue.append, we should maintain this invariant. We do it by popping any elements larger than the one we are inserting. For example, if we appended 5 to [1, 3, 6, 2, 4, 8], then mins which was [1, 2, 4, 8] becomes [1, 2, 4, 5].

Note that we used a simpler variant of MinQueue that requires every inserted element to be unique to ensure correctness. Also, the operations are amortized constant time because every element will be inserted and removed exactly once from each queue.

Complexity Analysis

Time Complexity: O(N)O(N), where NN is the length of flowers. In enumerating through the O(N)O(N) outer loop, we do constant work as MinQueue.popleft and MinQueue.min operations are (amortized) constant time.

Space Complexity: O(N)O(N), the size of our window.
	 */
	public int kEmptySlotsMinQueue(int[] flowers, int k) {
      int[] days = new int[flowers.length];
      for (int i = 0; i < flowers.length; i++) {
          days[flowers[i] - 1] = i + 1;
      }

      MinQueue<Integer> window = new MinQueue();
      int ans = days.length;

      for (int i = 0; i < days.length; i++) {
          int day = days[i];
          window.addLast(day);
          if (k <= i && i < days.length - 1) {
              window.pollFirst();
              if (k == 0 || days[i-k] < window.min() && days[i+1] < window.min()) {
                  ans = Math.min(ans, Math.max(days[i-k], days[i+1]));
              }
          }
      }

      return ans < days.length ? ans : -1;
  }
}

class MinQueue<E extends Comparable<E>> extends ArrayDeque<E> {
  Deque<E> mins;

  public MinQueue() {
      mins = new ArrayDeque<E>();
  }

  @Override
  public void addLast(E x) {
      super.addLast(x);
      while (mins.peekLast() != null &&
              x.compareTo(mins.peekLast()) < 0) {
          mins.pollLast();
      }
      mins.addLast(x);
  }

  @Override
  public E pollFirst() {
      E x = super.pollFirst();
      if (x == mins.peekFirst()) mins.pollFirst();
      return x;
  }

  public E min() {
      return mins.peekFirst();
  }
}
