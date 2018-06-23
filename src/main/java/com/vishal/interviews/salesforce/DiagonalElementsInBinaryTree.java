package com.vishal.interviews.salesforce;

import java.util.*;

/**
 *        1
 *    2       3
 * 4    5    
 *        6       8
 *          7         
 *          
 *  res
 *  {1,3,8}
 *  {2,5,6,7}
 *  {4}
 */
public class DiagonalElementsInBinaryTree {

	public static void main(String[] args) {

		BTreeNode one = new  BTreeNode(1);
		BTreeNode two = new  BTreeNode(2);
		BTreeNode three = new  BTreeNode(3);
		BTreeNode four = new  BTreeNode(4);
		BTreeNode five = new  BTreeNode(5);
		BTreeNode six = new  BTreeNode(6);
		BTreeNode seven = new  BTreeNode(7);
		BTreeNode eight = new  BTreeNode(8);
		
		one.left = two;
		one.right = three;
		
		two.left = four;
		two.right = five;
		five.right = seven;
				
				
		three.left = six;
		three.right = eight;
		
		System.out.println(diagonalElements(one));
				
	}

	static List<List<Integer>> diagonalElements(BTreeNode root) {
		List<List<Integer>> res = new ArrayList<>();

		if (root == null) {
			return res;
		}

		Map<Integer, List<Integer>> map = new HashMap<>();
		Queue<BTreeNode> queue = new LinkedList<>();
		Queue<Integer> diameter = new LinkedList<>();
		diameter.offer(0);
		queue.offer(root);
		while (!queue.isEmpty()) {
			BTreeNode c = queue.poll();
			int d = diameter.poll();
			
			if (!map.containsKey(d)) {
				map.put(d, new ArrayList<>());
			}
			map.get(d).add(c.val);

			if (c.left != null) {
				queue.offer(c.left);
				diameter.offer(d + 1);
			}
			if (c.right != null) {
				queue.offer(c.right);
				diameter.offer(d);
			}
		}

		res.addAll(map.values());
		return res;
	}

}

class BTreeNode {
	int val;
	BTreeNode(int val){
		this.val = val;
	}
	BTreeNode left;
	BTreeNode right;
}
