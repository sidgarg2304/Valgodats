package com.vishal.interviews.google.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 272. Closest Binary Search Tree Value II
 * 
 * Given a non-empty binary search tree and a target value, find k values in the
 * BST that are closest to the target.
 * 
 * Note:
 * 
 * Given target value is a floating point.
 * 
 * You may assume k is always valid, that is: k ≤ total nodes.
 * 
 * You are guaranteed to have only one unique set of k values in the BST that
 * are closest to the target.
 * 
 * Follow up:
 * 
 * Assume that the BST is balanced, could you solve it in less than O(n) runtime
 * (where n = total nodes)?
 * 
 * Hint:
 * 
 * Consider implement these two helper functions:
 * 
 * getPredecessor(N), which returns the next smaller node to N.
 * 
 * getSuccessor(N), which returns the next larger node to N.
 * 
 * Try to assume that each node has a parent pointer, it makes the problem much
 * easier.
 * 
 * Without parent pointer we just need to keep track of the path from the root
 * to the current node using a stack.
 * 
 * You would need two stacks to track the path in finding predecessor and
 * successor node separately.
 */
public class ClosestBinarySearchTreeValueII {

	public static void main(String[] args) {

	}

	/**
	 * AC clean Java solution using two stacks
	 * 
	 * The idea is to compare the predecessors and successors of the closest node
	 * to the target, we can use two stacks to track the predecessors and
	 * successors, then like what we do in merge sort, we compare and pick the
	 * closest one to the target and put it to the result list.
	 * 
	 * As we know, inorder traversal gives us sorted predecessors, whereas
	 * reverse-inorder traversal gives us sorted successors.
	 * 
	 * We can use iterative inorder traversal rather than recursion, but to keep
	 * the code clean, here is the recursion version.
	 * 
	 * @param root
	 * @param target
	 * @param k
	 * @return
	 */
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		List<Integer> res = new ArrayList<>();

		Stack<Integer> s1 = new Stack<>(); // predecessors
		Stack<Integer> s2 = new Stack<>(); // successors

		inorder(root, target, false, s1);
		inorder(root, target, true, s2);

		while (k-- > 0) {
			if (s1.isEmpty())
				res.add(s2.pop());
			else if (s2.isEmpty())
				res.add(s1.pop());
			else if (Math.abs(s1.peek() - target) < Math.abs(s2.peek() - target))
				res.add(s1.pop());
			else
				res.add(s2.pop());
		}

		return res;
	}

	// inorder traversal
	void inorder(TreeNode root, double target, boolean reverse, Stack<Integer> stack) {
		if (root == null)
			return;

		inorder(reverse ? root.right : root.left, target, reverse, stack);
		// early terminate, no need to traverse the whole tree
		if ((reverse && root.val <= target) || (!reverse && root.val > target))
			return;
		// track the value of current node
		stack.push(root.val);
		inorder(reverse ? root.left : root.right, target, reverse, stack);
	}

	/**
	 * Java in-order traversal 1ms solution
	 * 
	 * @param root
	 * @param target
	 * @param k
	 * @return
	 */
	public List<Integer> closestKValuesInOrder(TreeNode root, double target, int k) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		closestKValuesHelper(list, root, target, k);
		return list;
	}

	/**
	 * @return <code>true</code> if result is already found.
	 */
	private boolean closestKValuesHelper(LinkedList<Integer> list, TreeNode root, double target, int k) {
		if (root == null) {
			return false;
		}

		if (closestKValuesHelper(list, root.left, target, k)) {
			return true;
		}

		if (list.size() == k) {
			if (Math.abs(list.getFirst() - target) < Math.abs(root.val - target)) {
				return true;
			} else {
				list.removeFirst();
			}
		}

		list.addLast(root.val);
		return closestKValuesHelper(list, root.right, target, k);
	}
}

class TreeNode {
	public TreeNode(int val){
		this.val = val;
	}
	int val;
	TreeNode left;
	TreeNode right;
}

/**
 * O(logN) Java Solution with two stacks following hint
 */
class ClosestBinarySearchTreeValueIIOLogN {
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		List<Integer> ret = new LinkedList<>();
		Stack<TreeNode> succ = new Stack<>();
		Stack<TreeNode> pred = new Stack<>();
		initializePredecessorStack(root, target, pred);
		initializeSuccessorStack(root, target, succ);
		if (!succ.isEmpty() && !pred.isEmpty() && succ.peek().val == pred.peek().val) {
			getNextPredecessor(pred);
		}
		while (k-- > 0) {
			if (succ.isEmpty()) {
				ret.add(getNextPredecessor(pred));
			} else if (pred.isEmpty()) {
				ret.add(getNextSuccessor(succ));
			} else {
				double succ_diff = Math.abs((double) succ.peek().val - target);
				double pred_diff = Math.abs((double) pred.peek().val - target);
				if (succ_diff < pred_diff) {
					ret.add(getNextSuccessor(succ));
				} else {
					ret.add(getNextPredecessor(pred));
				}
			}
		}
		return ret;
	}

	private void initializeSuccessorStack(TreeNode root, double target, Stack<TreeNode> succ) {
		while (root != null) {
			if (root.val == target) {
				succ.push(root);
				break;
			} else if (root.val > target) {
				succ.push(root);
				root = root.left;
			} else {
				root = root.right;
			}
		}
	}

	private void initializePredecessorStack(TreeNode root, double target, Stack<TreeNode> pred) {
		while (root != null) {
			if (root.val == target) {
				pred.push(root);
				break;
			} else if (root.val < target) {
				pred.push(root);
				root = root.right;
			} else {
				root = root.left;
			}
		}
	}

	private int getNextSuccessor(Stack<TreeNode> succ) {
		TreeNode curr = succ.pop();
		int ret = curr.val;
		curr = curr.right;
		while (curr != null) {
			succ.push(curr);
			curr = curr.left;
		}
		return ret;
	}

	private int getNextPredecessor(Stack<TreeNode> pred) {
		TreeNode curr = pred.pop();
		int ret = curr.val;
		curr = curr.left;
		while (curr != null) {
			pred.push(curr);
			curr = curr.right;
		}
		return ret;
	}
}

/**
 * Java 5ms iterative, following hint, O(klogn) time and space Following the
 * hint, I use a predecessor stack and successor stack. I do a logn traversal to
 * initialize them until I reach the null node. Then I use the getPredecessor
 * and getSuccessor method to pop k closest nodes and update the stacks.
 * 
 * Time complexity is O(klogn), since k BST traversals are needed and each is
 * bounded by O(logn) time. Note that it is not O(logn + k) which is the time
 * complexity for k closest numbers in a linear array.
 * 
 * Space complexity is O(klogn), since each traversal brings O(logn) new nodes
 * to the stack.
 */
class ClosestBinarySearchTreeValueIIIterative {
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		List<Integer> result = new LinkedList<Integer>();
		// populate the predecessor and successor stacks
		Stack<TreeNode> pred = new Stack<TreeNode>();
		Stack<TreeNode> succ = new Stack<TreeNode>();
		TreeNode curr = root;
		while (curr != null) {
			if (target <= curr.val) {
				succ.push(curr);
				curr = curr.left;
			} else {
				pred.push(curr);
				curr = curr.right;
			}
		}
		while (k > 0) {
			if (pred.empty() && succ.empty()) {
				break;
			} else if (pred.empty()) {
				result.add(getSuccessor(succ));
			} else if (succ.empty()) {
				result.add(getPredecessor(pred));
			} else if (Math.abs(target - pred.peek().val) < Math.abs(target - succ.peek().val)) {
				result.add(getPredecessor(pred));
			} else {
				result.add(getSuccessor(succ));
			}
			k--;
		}
		return result;
	}

	private int getPredecessor(Stack<TreeNode> st) {
		TreeNode popped = st.pop();
		TreeNode p = popped.left;
		while (p != null) {
			st.push(p);
			p = p.right;
		}
		return popped.val;
	}

	private int getSuccessor(Stack<TreeNode> st) {
		TreeNode popped = st.pop();
		TreeNode p = popped.right;
		while (p != null) {
			st.push(p);
			p = p.left;
		}
		return popped.val;
	}
}

/**
 * Java Two stacks Iterative solution
 */
class ClosestBinarySearchTreeValueIITwoStacks {
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		Deque<TreeNode> bigger = new ArrayDeque<TreeNode>();
		Deque<TreeNode> smaller = new ArrayDeque<TreeNode>();
		TreeNode node = root;
		// log(n)
		while (node != null) {
			if (node.val > target) {
				bigger.push(node);
				node = node.left;
			} else {
				smaller.push(node);
				node = node.right;
			}
		}

		// k
		List<Integer> ret = new ArrayList<Integer>();
		while (ret.size() < k) {
			if (bigger.isEmpty() || !smaller.isEmpty() && ((bigger.peek().val - target) > (target - smaller.peek().val))) {
				node = smaller.pop();
				ret.add(node.val);

				// Get next smaller
				node = node.left;
				while (node != null) {
					smaller.push(node);
					node = node.right;
				}
			} else {
				node = bigger.pop();
				ret.add(node.val);

				// get next bigger
				node = node.right;
				while (node != null) {
					bigger.push(node);
					node = node.left;
				}
			}
		}

		return ret;
	}
}
