package com.vishal.interviews.facebook.medium;

import com.vishal.interviews.util.UndirectedGraphNode;

import java.util.*;

public class CloneGraph {

	public static void main(String[] args) {

	}
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
      
      if (node == null) {
			return null;
		}

		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		UndirectedGraphNode clonedRoot = new UndirectedGraphNode(node.label);

		map.put(node, clonedRoot);

		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		queue.offer(node);
		
		while (!queue.isEmpty()) {
			UndirectedGraphNode cur = queue.poll();
			UndirectedGraphNode clonedCur = map.get(cur);

			for (UndirectedGraphNode n : cur.neighbors) {
				UndirectedGraphNode clonedn = null;
				if (map.containsKey(n)) {
					clonedn = map.get(n);
				} else {
					clonedn = new UndirectedGraphNode(n.label);
					map.put(n, clonedn);
					queue.offer(n);
				}
				clonedCur.neighbors.add(clonedn);

			}
		}
		return clonedRoot;
  }

}
