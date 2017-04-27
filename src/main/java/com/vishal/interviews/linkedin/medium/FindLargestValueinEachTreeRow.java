package com.vishal.interviews.linkedin.medium;

import java.util.*;

public class FindLargestValueinEachTreeRow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static List<Integer> largestElement(TreeNode root){
		List<Integer> result = new ArrayList<>();
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()){
			int size = queue.size();
			int max = Integer.MIN_VALUE;
			for(int i = 0; i< size; i++){
				TreeNode cur = queue.poll();
				if(cur.left != null){
					queue.offer(cur.left);
				}
				
				if(cur.right != null){
					queue.offer(cur.right);
				}
				
				max = Math.max(cur.val, max);
				
			}
			
			result.add(max);
		}
		
		return result;
		
	}

}
