package com.vishal.interviews.google.hard;

import java.util.Arrays;

/**
 * 493. Reverse Pairs
 * 
 * Given an array nums, we call (i, j) an important reverse pair if i < j and
 * nums[i] > 2*nums[j].
 * 
 * You need to return the number of important reverse pairs in the given array.
 * 
 * Example1:
 * 
 * Input: [1,3,2,3,1]
 * 
 * Output: 2
 * 
 * Example2:
 * 
 * Input: [2,4,3,5,1]
 * 
 * Output: 3
 * 
 * Note: The length of the given array will not exceed 50,000.
 * 
 * All the numbers in the input array are in the range of 32-bit integer.
 */
public class ReversePairs {

	public static void main(String[] args) {

	}

	/**
	 * Look at this link for one more type of solution
	 * 
	 * https://leetcode.com/problems/reverse-pairs/?tab=Solutions
	 */

	/**
	 * Very Short and Clear MergeSort & BST Java Solutions
	 * 
	 * MergeSort
	 * 
	 * Explanation: In each round, we divide our array into two parts and sort
	 * them. So after
	 * "int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid+1, e); ", the
	 * left part and the right part are sorted and now our only job is to count
	 * how many pairs of number (leftPart[i], rightPart[j]) satisfies leftPart[i]
	 * <= 2*rightPart[j].
	 * 
	 * For example,
	 * 
	 * left: 4 6 8 right: 1 2 3
	 * 
	 * so we use two pointers to travel left and right parts. For each
	 * leftPart[i], if j<=e && nums[i]/2.0 > nums[j], we just continue to move j
	 * to the end, to increase rightPart[j], until it is valid. Like in our
	 * example, left's 4 can match 1 and 2; left's 6 can match 1, 2, 3, and
	 * left's 8 can match 1, 2, 3. So in this particular round, there are 8 pairs
	 * found, so we increases our total by 8.
	 * 
	 * @param nums
	 * @return
	 */
	public int reversePairsUsingMergeSort(int[] nums) {
		return mergeSort(nums, 0, nums.length - 1);
	}

	private int mergeSort(int[] nums, int s, int e) {
		if (s >= e)
			return 0;
		int mid = s + (e - s) / 2;
		int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid + 1, e);
		for (int i = s, j = mid + 1; i <= mid; i++) {
			while (j <= e && nums[i] / 2.0 > nums[j])
				j++;
			cnt += j - (mid + 1);
		}
		Arrays.sort(nums, s, e + 1);
		return cnt;
	}
}

/**
 * Because left part and right part are sorted, you can replace the
 * Arrays.sort() part with a actual merge sort process. The previous version is
 * easy to write, while this one is faster.
 * 
 */
class ReversePairsWithoutSortingFunction {
	int[] helper;

	public int reversePairs(int[] nums) {
		this.helper = new int[nums.length];
		return mergeSort(nums, 0, nums.length - 1);
	}

	private int mergeSort(int[] nums, int s, int e) {
		if (s >= e)
			return 0;
		int mid = s + (e - s) / 2;
		int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid + 1, e);
		for (int i = s, j = mid + 1; i <= mid; i++) {
			while (j <= e && nums[i] / 2.0 > nums[j])
				j++;
			cnt += j - (mid + 1);
		}
		// Arrays.sort(nums, s, e+1);
		myMerge(nums, s, mid, e);
		return cnt;
	}

	private void myMerge(int[] nums, int s, int mid, int e) {
		for (int i = s; i <= e; i++)
			helper[i] = nums[i];
		int p1 = s;// pointer for left part
		int p2 = mid + 1;// pointer for rigth part
		int i = s;// pointer for sorted array
		while (p1 <= mid || p2 <= e) {
			if (p1 > mid || (p2 <= e && helper[p1] >= helper[p2])) {
				nums[i++] = helper[p2++];
			} else {
				nums[i++] = helper[p1++];
			}
		}
	}
}

/**
 * BST
 * 
 * BST solution is no longer acceptable, because it's performance can be very
 * bad, O(n^2) actually, for extreme cases like [1,2,3,4......49999], due to the
 * its unbalance, but I am still providing it below just FYI.
 * 
 * We build the Binary Search Tree from right to left, and at the same time,
 * search the partially built tree with nums[i]/2.0. The code below should be
 * clear enough.
 * 
 */
class ReversePairsUsingBST {
	public int reversePairs(int[] nums) {
		Node root = null;
		int[] cnt = new int[1];
		for (int i = nums.length - 1; i >= 0; i--) {
			search(cnt, root, nums[i] / 2.0);// search and count the partially
														// built tree
			root = build(nums[i], root);// add nums[i] to BST
		}
		return cnt[0];
	}

	private void search(int[] cnt, Node node, double target) {
		if (node == null)
			return;
		else if (target == node.val)
			cnt[0] += node.less;
		else if (target < node.val)
			search(cnt, node.left, target);
		else {
			cnt[0] += node.less + node.same;
			search(cnt, node.right, target);
		}
	}

	private Node build(int val, Node n) {
		if (n == null)
			return new Node(val);
		else if (val == n.val)
			n.same += 1;
		else if (val > n.val)
			n.right = build(val, n.right);
		else {
			n.less += 1;
			n.left = build(val, n.left);
		}
		return n;
	}

	class Node {
		int val, less = 0, same = 1;// less: number of nodes that less than this
											 // node.val
		Node left, right;

		public Node(int v) {
			this.val = v;
		}
	}
}

class ReversePairsWithMergeSort {

	public int ret;

	public int reversePairs(int[] nums) {
		ret = 0;
		mergeSort(nums, 0, nums.length - 1);
		return ret;
	}

	public void mergeSort(int[] nums, int left, int right) {
		if (right <= left) {
			return;
		}
		int middle = left + (right - left) / 2;
		mergeSort(nums, left, middle);
		mergeSort(nums, middle + 1, right);

		// count elements
		int count = 0;
		for (int l = left, r = middle + 1; l <= middle;) {
			if (r > right || (long) nums[l] <= 2 * (long) nums[r]) {
				l++;
				ret += count;
			} else {
				r++;
				count++;
			}
		}

		// merge sort
		int[] temp = new int[right - left + 1];
		for (int l = left, r = middle + 1, k = 0; l <= middle || r <= right;) {
			if (l <= middle && ((r > right) || nums[l] < nums[r])) {
				temp[k++] = nums[l++];
			} else {
				temp[k++] = nums[r++];
			}
		}
		for (int i = 0; i < temp.length; i++) {
			nums[left + i] = temp[i];
		}
	}
}

class ReversePairsWithMergeSortSlower {

	public int ret;

	public int reversePairs(int[] nums) {
		ret = 0;
		mergeSort(nums, 0, nums.length - 1);
		return ret;
	}

	public void mergeSort(int[] nums, int left, int right) {
		if (right <= left) {
			return;
		}
		int middle = left + (right - left) / 2;
		mergeSort(nums, left, middle);
		mergeSort(nums, middle + 1, right);

		// count elements
		int count = 0;
		for (int l = left, r = middle + 1; l <= middle;) {
			if (r > right || (long) nums[l] <= 2 * (long) nums[r]) {
				l++;
				ret += count;
			} else {
				r++;
				count++;
			}
		}

		// sort
		Arrays.sort(nums, left, right + 1);
	}
}

/**
 * Clean Java Solution using Enhanced Binary Search Tree This is literally the
 * same problem with 315. Count of Smaller Numbers After Self. The only
 * difference is to find count of numbers smaller than half of the current
 * number after itself. To efficiently search for count of numbers smaller than
 * a target, we can use a Binary Search Tree. There is a little change of the
 * TreeNode to include count of numbers smaller or equal to it. This will make
 * the query even faster because we don't need to traverse all its left sub-tree
 * to get the count.
 * 
 * Overall Algorithm:
 * 
 * 1. Scan the numbers from right to left.
 * 
 * 2. First search the tree to get count of numbers smaller than nums[i] / 2.0,
 * sum to the final result.
 * 
 * 3. Insert nums[i] to the tree. Insert logic:
 * 
 * Recursively try to find a place to insert this number. When root is null, its
 * time to create a new node. If meet the same number, just increase the count.
 * When try to insert the number to left sub-tree, increase count of current
 * node. Query logic:
 * 
 * If target value is greater than the current value, meaning current node and
 * all left sub-tree are smaller than target, return count (remember it stands
 * for count of numbers smaller or equal to current number) of current node plus
 * any possible smaller number than target in right sub-tree. Otherwise, only
 * search left sub-tree.
 * 
 * @author vkotha
 *
 */
class ReversePairsWithEnhanceBST {
	class Node {
		int value, count;
		Node left, right;

		Node(int v) {
			value = v;
			count = 1;
		}
	}

	public int reversePairs(int[] nums) {
		int result = 0;
		if (nums == null || nums.length <= 1)
			return result;

		int len = nums.length;
		Node root = new Node(nums[len - 1]);

		for (int i = len - 2; i >= 0; i--) {
			result += query(root, nums[i] / 2.0);
			insert(root, nums[i]);
		}

		return result;
	}

	private Node insert(Node root, int value) {
		if (root == null)
			return new Node(value);

		if (root.value == value) {
			root.count++;
		} else if (root.value > value) {
			root.count++;
			root.left = insert(root.left, value);
		} else {
			root.right = insert(root.right, value);
		}

		return root;
	}

	private int query(Node root, double value) {
		if (root == null)
			return 0;

		if (value > root.value) {
			return root.count + query(root.right, value);
		} else {
			return query(root.left, value);
		}
	}
}
