package com.vishal.interviews.facebook.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


/**
 * 314. Binary Tree Vertical Order Traversal
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 * If two nodes are in the same row and column, the order should be from left to right.
 * 
 * Examples:
 * 1. Given binary tree [3,9,20,null,null,15,7],
 * 3
  /\
 /  \
 9  20
    /\
   /  \
  15   7
  
 * return its vertical order traversal as:
 * [
  [9],
  [3,15],
  [20],
  [7]
]

 * 2. Given binary tree [3,9,8,4,0,1,7],
 *      3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
 
 * return its vertical order traversal as:
 * [
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
 *
 * 3. Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
 *  3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2
 *
 * return its vertical order traversal as:
 * [
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
 */
public class BinaryTreeVerticalOrderTraversal {

	public static void main(String[] args) {

	}
	
	/**
	 * 5ms Java Clean Solution
	 * The following solution takes 5ms.
	 * BFS, put node, col into queue at the same time.
	 * Every left child access col - 1 while right child col + 1
	 * This maps node into different col buckets
	 * Get col boundary min and max on the fly
	 * Retrieve result from cols
	 * Note that TreeMap version takes 9ms.
	 * Here is an example of [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]. 
	 * Notice that every child access changes one column bucket id. 
	 * So 12 actually goes ahead of 11.
	 */
	
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		Queue<TreeNode> q = new LinkedList<>();
		Queue<Integer> cols = new LinkedList<>();

		q.add(root);
		cols.add(0);

		int min = 0;
		int max = 0;

		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			int col = cols.poll();

			if (!map.containsKey(col)) {
				map.put(col, new ArrayList<Integer>());
			}
			map.get(col).add(node.val);

			if (node.left != null) {
				q.add(node.left);
				cols.add(col - 1);
				min = Math.min(min, col - 1);
			}

			if (node.right != null) {
				q.add(node.right);
				cols.add(col + 1);
				max = Math.max(max, col + 1);
			}
		}

		for (int i = min; i <= max; i++) {
			res.add(map.get(i));
		}

		return res;
	}

	/**
	 * Alternatively, we can calculate the rang first, then insert into buckets. 
	 */
	
	public List<List<Integer>> verticalOrder2(TreeNode root) {
	    List<List<Integer>> cols = new ArrayList<>();
	    if (root == null) {
	        return cols;
	    }
	    
	    int[] range = new int[] {0, 0};
	    getRange(root, range, 0);
	    
	    for (int i = range[0]; i <= range[1]; i++) {
	        cols.add(new ArrayList<Integer>());
	    }
	    
	    Queue<TreeNode> queue = new LinkedList<>();
	    Queue<Integer> colQueue = new LinkedList<>();
	    
	    queue.add(root);
	    colQueue.add(-range[0]);
	    
	    while (!queue.isEmpty()) {
	        TreeNode node = queue.poll();
	        int col = colQueue.poll();
	        
	        cols.get(col).add(node.val);
	        
	        if (node.left != null) {
	            queue.add(node.left);   
	            colQueue.add(col - 1);
	        } 
	        if (node.right != null) {
	            queue.add(node.right);
	            colQueue.add(col + 1);
	        }
	    }
	    
	    return cols;
	}

	public void getRange(TreeNode root, int[] range, int col) {
	    if (root == null) {
	        return;
	    }
	    range[0] = Math.min(range[0], col);
	    range[1] = Math.max(range[1], col);
	    
	    getRange(root.left, range, col - 1);
	    getRange(root.right, range, col + 1);
	}
	
	/**
	 * 3ms java solution beats 100%
	 */
	
	//There is no difference when using HashMap. 
	//Since by using HashMap it need keep track of min and max as well, 
	//I'd rather directly insert into list by computing min and max in advance.
	
	private int min = 0, max = 0;
	public List<List<Integer>> verticalOrder3(TreeNode root) {
	    List<List<Integer>> list = new ArrayList<>();
	    if(root == null)    return list;
	    computeRange(root, 0);
	    for(int i = min; i <= max; i++) list.add(new ArrayList<>());
	    Queue<TreeNode> q = new LinkedList<>();
	    Queue<Integer> idx = new LinkedList<>();
	    idx.add(-min);
	    q.add(root);
	    while(!q.isEmpty()){
	        TreeNode node = q.poll();
	        int i = idx.poll();
	        list.get(i).add(node.val);
	        if(node.left != null){
	            q.add(node.left);
	            idx.add(i - 1);
	        }
	        if(node.right != null){
	            q.add(node.right);
	            idx.add(i + 1);
	        }
	    }
	    return list;
	}
	private void computeRange(TreeNode root, int idx){
	    if(root == null)    return;
	    min = Math.min(min, idx);
	    max = Math.max(max, idx);
	    computeRange(root.left, idx - 1);
	    computeRange(root.right, idx + 1);
	}
	
	/**
	 * Using HashMap,BFS Java Solution
	 */
	
	public List<List<Integer>> verticalOrder4(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
       //map's key is column, we assume the root column is zero, the left node will minus 1 ,and the right node will plus 1
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
       //use a HashMap to store the TreeNode and the according cloumn value
        HashMap<TreeNode, Integer> weight = new HashMap<TreeNode, Integer>();
        queue.offer(root);
        weight.put(root, 0);
        int min = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int w = weight.get(node);
            if (!map.containsKey(w)) {
                map.put(w, new ArrayList<>());
            }
            map.get(w).add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                weight.put(node.left, w - 1);
            } 
            if (node.right != null) {
                queue.add(node.right);
                weight.put(node.right, w + 1);
            }
            //update min ,min means the minimum column value, which is the left most node
            min = Math.min(min, w);
        }
        while (map.containsKey(min)) {
            res.add(map.get(min++));
        }
        return res;
    }

}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
}