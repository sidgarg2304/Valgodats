package com.vishal.interviews.google.medium;

import java.util.*;
/**
 * 817. Linked List Components
 * 
 * We are given head, the head node of a linked list containing unique integer values.

We are also given the list G, a subset of the values in the linked list.

Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.

Example 1:

Input: 
head: 0->1->2->3
G = [0, 1, 3]
Output: 2
Explanation: 
0 and 1 are connected, so [0, 1] and [3] are the two connected components.
Example 2:

Input: 
head: 0->1->2->3->4
G = [0, 3, 1, 4]
Output: 2
Explanation: 
0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
Note:

If N is the length of the linked list given by head, 1 <= N <= 10000.
The value of each node in the linked list will be in the range [0, N - 1].
1 <= G.length <= 10000.
G is a subset of all values in the linked list.

 *
 */
public class LinkedListComponents {

	public static void main(String[] args) {

	}

	/**
	 * Approach #1: Grouping [Accepted]
Intuition

Instead of thinking about connected components in G, think about them in the linked list. Connected components in G must occur consecutively in the linked list.

Algorithm

Scanning through the list, if node.val is in G and node.next.val isn't (including if node.next is null), then this must be the end of a connected component.

For example, if the list is 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7, and G = [0, 2, 3, 5, 7], then when scanning through the list, we fulfill the above condition at 0, 3, 5, 7, for a total answer of 4.

Complexity Analysis

Time Complexity: O(N + G\text{.length})O(N+G.length), where NN is the length of the linked list with root node head.

Space Complexity: O(G\text{.length})O(G.length), to store Gset.
	 */
	public int numComponents(ListNode head, int[] G) {
      Set<Integer> Gset = new HashSet();
      for (int x: G) Gset.add(x);

      ListNode cur = head;
      int ans = 0;

      while (cur != null) {
          if (Gset.contains(cur.val) &&
                  (cur.next == null || !Gset.contains(cur.next.val)))
              ans++;
          cur = cur.next;
      }

      return ans;
  }
}
