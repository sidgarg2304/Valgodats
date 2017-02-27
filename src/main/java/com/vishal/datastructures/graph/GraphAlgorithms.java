package com.vishal.datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class GraphAlgorithms {

	public static void main(String[] args) {
		// testCanFinishCourses();
		testConstructItenary();
		// testWordLadder();
		// testfindAllTransformationsequences();
	}

	public static void testCanFinishCourses() {
		int[][] courseDependencies = new int[5][2];
		courseDependencies[0] = new int[] { 1, 0 };
		courseDependencies[1] = new int[] { 2, 0 };
		courseDependencies[2] = new int[] { 3, 2 };
		courseDependencies[3] = new int[] { 4, 1 };
		courseDependencies[4] = new int[] { 3, 4 };

		System.out.println("can finish courses " + canFinishCoursesAndPrintSequence(5, courseDependencies));

		courseDependencies = new int[5][2];
		courseDependencies[0] = new int[] { 1, 4 };
		courseDependencies[1] = new int[] { 2, 0 };
		courseDependencies[2] = new int[] { 3, 2 };
		courseDependencies[3] = new int[] { 4, 1 };
		courseDependencies[4] = new int[] { 3, 4 };

		System.out.println("can finish courses " + canFinishCoursesAndPrintSequence(5, courseDependencies));
	}

	public static void testConstructItenary() {
		String[][] tickets = new String[5][2];
		tickets[0] = new String[] { "FLORIDA", "SJC" };
		tickets[1] = new String[] { "MEXICO", "FLORIDA" };
		tickets[2] = new String[] { "VEGAS", "MEXICO" };
		tickets[3] = new String[] { "SJC", "VEGAS" };
		tickets[4] = new String[] { "JFK", "SJC" };
		constructItenary(tickets, "JFK");
	}

	public static void testWordLadder() {
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("cat");
		dictionary.add("dot");
		dictionary.add("cot");
		dictionary.add("dog");
		dictionary.add("pat");

		System.out.println("min distance between words is " + minTransformationSequenceLength("cat", "dog", dictionary));
	}

	public static void testfindAllTransformationsequences() {
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("cat");
		dictionary.add("dot");
		dictionary.add("cot");
		dictionary.add("dog");
		dictionary.add("dat");

		System.out.println("all sequences words is " + findAllTransformationsequences("cat", "dog", dictionary));
	}

	public static void cloneGraph(GraphNode<Integer> root) {

		Map<GraphNode<Integer>, GraphNode<Integer>> map = new HashMap<GraphNode<Integer>, GraphNode<Integer>>();

		GraphNode<Integer> clonedRoot = new GraphNode<Integer>(root.value);
		map.put(root, clonedRoot);

		Queue<GraphNode<Integer>> queue = new LinkedList<GraphNode<Integer>>();
		while (!queue.isEmpty()) {
			GraphNode<Integer> p = queue.poll();
			GraphNode<Integer> clonedP = map.get(p);
			for (GraphNode<Integer> neighbor : p.getNeighbors()) {
				GraphNode<Integer> clonedNeighbor = null;
				if (!map.containsKey(neighbor)) {
					clonedNeighbor = new GraphNode<Integer>(neighbor.value);
					map.put(neighbor, clonedNeighbor);
					queue.offer(neighbor);
				} else {
					clonedNeighbor = map.get(neighbor);
				}
				clonedP.addNeighbor(clonedNeighbor);
			}
		}
	}

	public static boolean canFinishCoursesAndPrintSequence(int numOfCourses, int[][] prerequisites) {

		int[] dependencyCount = new int[numOfCourses];

		for (int i = 0; i < prerequisites.length; i++) {
			dependencyCount[prerequisites[i][0]]++;
		}

		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 0; i < numOfCourses; i++) {
			if (dependencyCount[i] == 0) {
				queue.offer(i);
			}
		}

		int numOfFinishedCourses = queue.size();
		while (!queue.isEmpty()) {
			int course = queue.poll();
			System.out.println("course " + course + " is finished");
			for (int i = 0; i < prerequisites.length; i++) {
				if (prerequisites[i][1] == course) {
					dependencyCount[prerequisites[i][0]]--;
					if (dependencyCount[prerequisites[i][0]] == 0) {
						numOfFinishedCourses++;
						queue.offer(prerequisites[i][0]);
					}
				}
			}

		}

		return numOfFinishedCourses == numOfCourses;

	}

	public static void constructItenary(String[][] tickets, String stAirport) {

		Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();

		for (int i = 0; i < tickets.length; i++) {
			PriorityQueue<String> queue = null;
			if (!map.containsKey(tickets[i][0])) {
				queue = new PriorityQueue<String>();
				map.put(tickets[i][0], queue);
			}
			queue.offer(tickets[i][1]);
		}

		Stack<String> dfsStack = new Stack<String>();
		dfsStack.push(stAirport);

		while (!dfsStack.isEmpty()) {
			String airport = dfsStack.pop();
			System.out.println(airport + "->");
			PriorityQueue<String> destinations = map.get(airport);

			while (!destinations.isEmpty()) {
				dfsStack.push(destinations.poll());
			}
		}

	}

	public static int minTransformationSequenceLength(String startWord, String endWord, Set<String> dictionary) {

		GraphNode<String> root = new GraphNode<String>(startWord);
		Queue<GraphNode<String>> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			GraphNode<String> p = queue.poll();
			if (p.value.equals(endWord)) {
				return p.getLevelNumber();
			}

			char[] wordArr = p.getValue().toCharArray();
			for (int i = 0; i < p.getValue().length(); i++) {
				char origChar = wordArr[i];
				for (char c = 'a'; c <= 'z'; c++) {
					wordArr[i] = c;
					String childWord = String.valueOf(wordArr);
					if (dictionary.contains(childWord)) {
						queue.offer(new GraphNode<String>(childWord, p.getLevelNumber() + 1));
						dictionary.remove(childWord);
					}
					wordArr[i] = origChar;
				}
			}
		}
		return -1;
	}

	public static List<List<String>> findAllTransformationsequences(String startWord, String endWord,
			Set<String> dictionary) {

		List<List<String>> result = new ArrayList<>();
		GraphNode<String> root = new GraphNode<String>(startWord);
		Queue<GraphNode<String>> queue = new LinkedList<>();
		queue.offer(root);

		Set<String> visited = new HashSet<>();
		Set<String> unVisited = new HashSet<>();
		unVisited.addAll(dictionary);

		int preNumSteps = 0;
		while (!queue.isEmpty()) {
			GraphNode<String> p = queue.poll();
			if (p.value.equals(endWord)) {
				List<String> res = new ArrayList<>();
				while (p != null) {
					res.add(p.getValue());
					p = p.getPrev();
				}
				result.add(res);
				continue;
			}

			if (preNumSteps < p.getLevelNumber()) {
				unVisited.removeAll(visited);
			}
			preNumSteps = p.getLevelNumber();

			char[] wordArr = p.getValue().toCharArray();
			for (int i = 0; i < p.getValue().length(); i++) {
				char origChar = wordArr[i];
				for (char c = 'a'; c <= 'z'; c++) {
					if (c == origChar) {
						continue;
					}
					wordArr[i] = c;
					String childWord = String.valueOf(wordArr);
					if (unVisited.contains(childWord)) {
						queue.offer(new GraphNode<String>(childWord, p.getLevelNumber() + 1, p));
						visited.add(childWord);
					}
					wordArr[i] = origChar;
				}
			}
		}
		System.out.println(result);
		return result;
	}

	public static void bfsWithLevelTracking(GraphNode<Integer> root) {
		Queue<GraphNode<Integer>> queue = new LinkedList<>();

		queue.offer(root);

		int levelNumber = 0;
		while (!queue.isEmpty()) {
			int curLevelSize = queue.size();
			System.out.println("printing level " + levelNumber + " nodes");
			for (int i = 0; i < curLevelSize; i++) {
				GraphNode<Integer> n = queue.poll();
				System.out.println(n.value);
				for (GraphNode<Integer> c : n.getNeighbors()) {
					queue.offer(c);
				}
			}
		}

	}
}
