package com.vishal.interviews.google.medium;

import java.util.*;

/**
 * 659. Split Array into Consecutive Subsequences
 * 
 * You are given an integer array sorted in ascending order (may contain duplicates), you need to split them into several subsequences, where each subsequences consist of at least 3 consecutive integers. Return whether you can make such a split.

Example 1:
Input: [1,2,3,3,4,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3
3, 4, 5
Example 2:
Input: [1,2,3,3,4,4,5,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3, 4, 5
3, 4, 5
Example 3:
Input: [1,2,3,4,4,5]
Output: False
 *
 */
public class SplitArrayintoConsecutiveSubsequences {

	public static void main(String[] args) {

	}

	/**
	 * Approach #1: Opening and Closing Events [Accepted]
Intuition

We can think of the problem as drawing intervals on a number line. This gives us the idea of opening and closing events.

To illustrate this concept, say we have nums = [10, 10, 11, 11, 11, 11, 12, 12, 12, 12, 13], with no 9s and no 14s. We must have two sequences start at 10, two sequences start at 11, and 3 sequences end at 12.

In general, when considering a chain of consecutive integers x, we must have C = count[x+1] - count[x] sequences start at x+1 when C > 0, and -C sequences end at x if C < 0. Even if there are more endpoints on the intervals we draw, there must be at least this many endpoints.

With the above example, count[11] - count[10] = 2 and count[13] - count[12] = -3 show that two sequences start at 11, and three sequences end at 12.

Also, if for example we know some sequences must start at time 1 and 4 and some sequences end at 5 and 7, to maximize the smallest length sequence, we should pair the events together in the order they occur: ie., 1 with 5 and 4 with 7.

Algorithm

For each group of numbers, say the number is x and there are count of them. Furthermore, say prev, prev_count is the previous integer encountered and it's count.

Then, in general there are abs(count - prev_count) events that will happen: if count > prev_count then we will add this many t's to starts; and if count < prev_count then we will attempt to pair starts.popleft() with t-1.

More specifically, when we have finished a consecutive group, we will have prev_count endings; and when we are in a consecutive group, we may have count - prev_count starts or prev_count - count endings.

For example, when nums = [1,2,3,3,4,5], then the starts are at [1, 3] and the endings are at [3, 5]. As our algorithm progresses:

When t = 1, count = 1: starts = [1]
When t = 2, count = 1: starts = [1]
When t = 3, count = 2: starts = [1, 3]
When t = 4, count = 1: starts = [3], since prev_count - count = 1 we process one closing event, which is accepted as t-1 >= starts.popleft() + 2.
When t = 5, count = 1: starts = [3]
And at the end, we process prev_count more closing events nums[-1].


Complexity Analysis

Time Complexity: O(N)O(N), where NN is the length of nums. We iterate over the array and every event is added or popped to starts at most once.

Space Complexity: O(N)O(N), the size of starts.
	 */
	public boolean isPossible(int[] nums) {
      Integer prev = null;
      int prevCount = 0;
      Queue<Integer> starts = new LinkedList();
      int anchor = 0;
      for (int i = 0; i < nums.length; ++i) {
          int t = nums[i];
          if (i == nums.length - 1 || nums[i+1] != t) {
              int count = i - anchor + 1;
              if (prev != null && t - prev != 1) {
                  while (prevCount-- > 0)
                      if (prev < starts.poll() + 2) return false;
                  prev = null;
              }

              if (prev == null || t - prev == 1) {
                  while (prevCount > count) {
                      prevCount--;
                      if (t-1 < starts.poll() + 2)
                          return false;
                  }
                  while (prevCount++ < count)
                      starts.add(t);
              }
              prev = t;
              prevCount = count;
              anchor = i+1;
          }
      }

      while (prevCount-- > 0)
          if (nums[nums.length - 1] < starts.poll() + 2)
              return false;
      return true;
  }

	/**
	 * Approach #2: Greedy [Accepted]
Intuition

Call a chain a sequence of 3 or more consecutive numbers.

Considering numbers x from left to right, if x can be added to a current chain, it's at least as good to add x to that chain first, rather than to start a new chain.

Why? If we started with numbers x and greater from the beginning, the shorter chains starting from x could be concatenated with the chains ending before x, possibly helping us if there was a "chain" from x that was only length 1 or 2.

Algorithm

Say we have a count of each number, and let tails[x] be the number of chains ending right before x.

Now let's process each number. If there's a chain ending before x, then add it to that chain. Otherwise, if we can start a new chain, do so.

It's worth noting that our solution can be amended to take only O(1)O(1) additional space, since we could do our counts similar to Approach #1, and we only need to know the last 3 counts at a time.

Complexity Analysis

Time Complexity: O(N)O(N), where NN is the length of nums. We iterate over the array.

Space Complexity: O(N)O(N), the size of count and tails.
	 */
	public boolean isPossibleGreedy(int[] nums) {
      Counter count = new Counter();
      Counter tails = new Counter();
      for (int x: nums) count.add(x, 1);

      for (int x: nums) {
          if (count.get(x) == 0) {
              continue;
          } else if (tails.get(x) > 0) {
              tails.add(x, -1);
              tails.add(x+1, 1);
          } else if (count.get(x+1) > 0 && count.get(x+2) > 0) {
              count.add(x+1, -1);
              count.add(x+2, -1);
              tails.add(x+3, 1);
          } else {
              return false;
          }
          count.add(x, -1);
      }
      return true;
  }
}

class Counter extends HashMap<Integer, Integer> {
  public int get(int k) {
      return containsKey(k) ? super.get(k) : 0;
  }

  public void add(int k, int v) {
      put(k, get(k) + v);
  }
}
