package com.vishal.interviews.leetcodereremaining.medium;

import java.util.*;

/**
 * 582. Kill Process
 *
 *Given n processes, each process has a unique PID (process id) and its PPID (parent process id).

Each process only has one parent process, but may have one or more children processes. This is just like a tree structure. Only one process has PPID that is 0, which means this process has no parent process. All the PIDs will be distinct positive integers.

We use two list of integers to represent a list of processes, where the first list contains PID for each process and the second list contains the corresponding PPID.

Now given the two lists, and a PID representing a process you want to kill, return a list of PIDs of processes that will be killed in the end. You should assume that when a process is killed, all its children processes will be killed. No order is required for the final answer.

Example 1:
Input: 
pid =  [1, 3, 10, 5]
ppid = [3, 0, 5, 3]
kill = 5
Output: [5,10]
Explanation: 
           3
         /   \
        1     5
             /
            10
Kill 5 will also kill 10.
 */
public class KillProcess {

	public static void main(String[] args) {

	}

	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

		Map<Integer, List<Integer>> adjList = new HashMap<>();
		for (int i = 0; i < ppid.size(); i++) {
			int p = ppid.get(i);
			int c = pid.get(i);
			if (!adjList.containsKey(p)) {
				adjList.put(p, new ArrayList<>());
			}
			adjList.get(p).add(c);
		}

		List<Integer> res = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(kill);

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			res.add(cur);
			if (adjList.get(cur) != null) {
				queue.addAll(adjList.get(cur));
			}
		}

		return res;
	}

}
