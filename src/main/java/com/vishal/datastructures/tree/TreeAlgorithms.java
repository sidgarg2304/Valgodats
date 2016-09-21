package com.vishal.datastructures.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class TreeAlgorithms {

	public static void main(String[] args) {
		TreeNode ggf = createTreeNodes();

		System.out.println(allCousins(ggf, "f4"));
		
		System.out.println(allCousinsTwoWhileLoops(ggf, "f4"));
		
		testDegreeOfConnection();
	}

	public static void testDegreeOfConnection() {
		TreeNode ggf = createTreeNodes();
		degreeOfConnection(ggf, "f4");		
	}

	public static void degreeOfConnection(TreeNode t1, String t2Name) {

		TreeNode p = t1;
		Stack<QueueNode> stack = new Stack<QueueNode>();

		stack.push(new QueueNode(p, 0, null));

		while (!stack.isEmpty()) {
			QueueNode t = stack.pop();
			
			if (t.n.name.equals(t2Name)) {
				System.out.print("degree of connection between " + t1.name + " and " + t2Name + " is " + t.levelNumber);
				return;
			}

			for (TreeNode child : t.n.children) {
				stack.push(new QueueNode(child, (t.levelNumber + 1), t.n));
			}
		}

		System.out.print(t1.name + " and " + t2Name + " are not friends ");
	}

	public static List<TreeNode> allCousins(TreeNode ggf, String myself) {
		/**
		 * ResultKey to track levelNumber and parent Map's value is to store list
		 * of tree nodes in the corresponding level denoted by ResultKey
		 */
		Map<Integer, List<QueueNode>> result = new HashMap<Integer, List<QueueNode>>();
		TreeNode p = ggf;
		/**
		 * QueueNode is use to track current level number and it’s parent
		 */
		Queue<QueueNode> queue = new LinkedList<QueueNode>();

		queue.offer(new QueueNode(p, 0, null));

		int myLevelNumber = 0;
		TreeNode myParent = ggf;
		while (!queue.isEmpty()) {
			QueueNode t = queue.poll();
			List<QueueNode> levelNodes = result.get(t.levelNumber);
			if (levelNodes == null) {
				levelNodes = new ArrayList<QueueNode>();
				result.put(t.levelNumber, levelNodes);
			}
			levelNodes.add(t);
			if (t.n.name.equals(myself)) {
				myLevelNumber = t.levelNumber;
				myParent = t.parent;
			}
			for (TreeNode child : t.n.children) {
				queue.offer(new QueueNode(child, (t.levelNumber + 1), t.n));
			}
		}
		List<QueueNode> res = result.get(myLevelNumber);
		List<TreeNode> finalResult = new ArrayList<TreeNode>();
		for(QueueNode r: res){
			if(!r.parent.name.equals(myParent.name)){
				finalResult.add(r.n);
			}
		}
		return finalResult;
	}
	
	public static List<TreeNode> allCousinsTwoWhileLoops(TreeNode ggf, String myself) {		
		TreeNode p = ggf;
		/**
		 * QueueNode is use to track current level number and it’s parent
		 */
		Queue<QueueNode> queue = new LinkedList<QueueNode>();
		
		int myLevelNumber = 0;
		TreeNode myParent = ggf;
		
		//BFS first to find out the level in which I am present.
		queue.offer(new QueueNode(p, 0, null));		
		while (!queue.isEmpty()) {
			QueueNode t = queue.poll();			
			if (t.n.name.equals(myself)) {
				//We found my level number, so break the BFS loop
				myLevelNumber = t.levelNumber;
				myParent = t.parent;
				break;
			}
			for (TreeNode child : t.n.children) {
				queue.offer(new QueueNode(child, (t.levelNumber + 1), t.n));
			}
		}
		List<TreeNode> finalResult = new ArrayList<TreeNode>();
		
		//BFS again to find out cousins in our level
		queue.clear();			
		queue.offer(new QueueNode(p, 0, null));		
		while (!queue.isEmpty()) {
			QueueNode t = queue.poll();			
			if (t.levelNumber == myLevelNumber && t.parent != myParent) {
				finalResult.add(t.n);
			}
			// We don't need our next generation information
			if(t.levelNumber > myLevelNumber){
				break;
			}
			for (TreeNode child : t.n.children) {
				queue.offer(new QueueNode(child, (t.levelNumber + 1), t.n));
			}
		}
						
		return finalResult;
	}

	static TreeNode createTreeNodes() {
		TreeNode ggf = new TreeNode("ggf");
		TreeNode gf1 = new TreeNode("gf1");
		TreeNode gf2 = new TreeNode("gf2");
		ggf.addChild(gf1);
		ggf.addChild(gf2);
		TreeNode f1 = new TreeNode("f1");
		TreeNode f2 = new TreeNode("f2");
		TreeNode f3 = new TreeNode("f3");

		gf1.addChild(f1);
		gf1.addChild(f2);
		gf1.addChild(f3);

		TreeNode f4 = new TreeNode("f4");
		TreeNode f5 = new TreeNode("f5");
		TreeNode f6 = new TreeNode("f6");

		gf2.addChild(f4);
		gf2.addChild(f5);
		gf2.addChild(f6);

		return ggf;
	}

}

class TreeNode {
	public String name;

	TreeNode(String name) {
		this.name = name;
		children = new ArrayList<TreeNode>();
	}

	List<TreeNode> children;

	void addChild(TreeNode c) {
		children.add(c);
	}

	public String toString() {
		return name;
	}

}

class ResultKey {
	TreeNode parent;
	int levelNumber;

	ResultKey(TreeNode parent, int levelNumber) {
		this.parent = parent;
		this.levelNumber = levelNumber;
	}

	public boolean equals(Object o) {
		if (o instanceof ResultKey) {
			ResultKey resKey = (ResultKey) o;
			return (resKey.levelNumber == this.levelNumber);

		} else {
			return false;
		}
	}
}

class QueueNode {
	TreeNode n;
	int levelNumber;
	TreeNode parent;

	QueueNode(TreeNode n, int levelNumber, TreeNode parent) {
		this.n = n;
		this.parent = parent;
		this.levelNumber = levelNumber;
	}
}
