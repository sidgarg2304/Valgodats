package com.vishal.datastructures.bktree;

import java.util.*;

public class BKTreeNode {

	String word;
	Map<Integer, BKTreeNode> children;

	public BKTreeNode(String word) {
		this.word = word;
		this.children = new HashMap<>();
	}
	
	public void addChild(String child, int dist){
		BKTreeNode c = new BKTreeNode(child);
		children.put(dist, c);
	}
}
