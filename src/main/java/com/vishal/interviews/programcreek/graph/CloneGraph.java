package com.vishal.interviews.programcreek.graph;

import java.util.*;

import com.vishal.interviews.util.UndirectedGraphNode;

public class CloneGraph {

	public static void main(String[] args) {

	}

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;

		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		UndirectedGraphNode clonedNode = new UndirectedGraphNode(node.label);
		map.put(node, clonedNode);

		Queue<UndirectedGraphNode> queue = new LinkedList<>();

		queue.offer(node);

		while (!queue.isEmpty()) {
			UndirectedGraphNode cur = queue.poll();
			UndirectedGraphNode cloned = map.get(cur);

			for (UndirectedGraphNode n : cur.neighbors) {
				UndirectedGraphNode clonedN = null;
				if (!map.containsKey(n)) {
					clonedN = new UndirectedGraphNode(n.label);
					map.put(n, clonedN);
					queue.offer(clonedN);
				} else {
					clonedN = map.get(n);
				}
				cloned.neighbors.add(clonedN);
			}

		}

		return clonedNode;
	}

}
